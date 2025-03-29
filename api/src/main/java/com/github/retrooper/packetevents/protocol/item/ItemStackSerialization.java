/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2025 retrooper and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.retrooper.packetevents.protocol.item;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.component.ComponentType;
import com.github.retrooper.packetevents.protocol.component.ComponentTypes;
import com.github.retrooper.packetevents.protocol.component.PatchableComponentMap;
import com.github.retrooper.packetevents.protocol.item.type.ItemType;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class ItemStackSerialization {

    private ItemStackSerialization() {
    }

    public static ItemStack read(PacketWrapper<?> wrapper) {
        return wrapper.getServerVersion().isNewerThanOrEquals(ServerVersion.V_1_20_5)
                ? readModern(wrapper) : readLegacy(wrapper);
    }

    public static void write(PacketWrapper<?> wrapper, @Nullable ItemStack stack) {
        ItemStack replacedStack = stack == null ? ItemStack.EMPTY : stack;
        if (wrapper.getServerVersion().isNewerThanOrEquals(ServerVersion.V_1_20_5)) {
            writeModern(wrapper, replacedStack);
        } else {
            writeLegacy(wrapper, replacedStack);
        }
    }

    /**
     * Removed with 1.20.5
     */
    private static ItemStack readLegacy(PacketWrapper<?> wrapper) {
        boolean v1_13_2 = wrapper.getServerVersion().isNewerThanOrEquals(ServerVersion.V_1_13_2);
        if (v1_13_2 && !wrapper.readBoolean()) {
            return ItemStack.EMPTY;
        }
        int typeId = v1_13_2 ? wrapper.readVarInt() : wrapper.readShort();
        if (typeId < 0 && !v1_13_2) { // 1.13.2 doesn't have this logic
            return ItemStack.EMPTY;
        }

        ItemType type = ItemTypes.getRegistry().getById(wrapper.getServerVersion().toClientVersion(), typeId);
        int amount = wrapper.readByte();
        int legacyData = v1_13_2 ? -1 : wrapper.readShort();
        NBTCompound nbt = wrapper.readNBT();
        return ItemStack.builder().type(type).amount(amount).nbt(nbt).legacyData(legacyData).build();
    }

    /**
     * Removed with 1.20.5
     */
    private static void writeLegacy(PacketWrapper<?> wrapper, ItemStack stack) {
        if (wrapper.getServerVersion().isOlderThan(ServerVersion.V_1_13_2)) {
            int typeId = stack.isEmpty() ? -1 : stack.getType().getId(wrapper.getServerVersion().toClientVersion());
            wrapper.writeShort(typeId);
            if (typeId != -1) {
                wrapper.writeByte(stack.getAmount());
                wrapper.writeShort(stack.getLegacyData());
                wrapper.writeNBT(stack.getNBT());
            }
        } else if (stack.isEmpty()) {
            wrapper.writeBoolean(false);
        } else {
            wrapper.writeBoolean(true);
            wrapper.writeMappedEntity(stack.getType());
            wrapper.writeByte(stack.getAmount());
            wrapper.writeNBT(stack.getNBT());
        }
    }

    /**
     * Added with 1.20.5
     */
    @SuppressWarnings("unchecked")
    public static ItemStack readModern(PacketWrapper<?> wrapper) {
        int count = wrapper.readVarInt();
        if (count <= 0) {
            return ItemStack.EMPTY;
        }
        ItemType itemType = wrapper.readMappedEntity(ItemTypes.getRegistry());

        // read component patch counts
        int presentCount = wrapper.readVarInt();
        int absentCount = wrapper.readVarInt();
        if (presentCount == 0 && absentCount == 0) {
            return ItemStack.builder().type(itemType).amount(count).build();
        }

        PatchableComponentMap components = new PatchableComponentMap(
                itemType.getComponents(wrapper.getServerVersion().toClientVersion()),
                new HashMap<>(4));
        for (int i = 0; i < presentCount; i++) {
            ComponentType<?> type = wrapper.readMappedEntity(ComponentTypes.getRegistry());
            components.set((ComponentType<Object>) type, type.read(wrapper));
        }
        for (int i = 0; i < absentCount; i++) {
            components.unset(wrapper.readMappedEntity(ComponentTypes.getRegistry()));
        }

        return ItemStack.builder().type(itemType).amount(count).components(components).build();
    }

    /**
     * Added with 1.20.5
     */
    @SuppressWarnings("unchecked")
    public static void writeModern(PacketWrapper<?> wrapper, ItemStack stack) {
        if (stack.isEmpty()) {
            wrapper.writeByte(0);
            return;
        }
        wrapper.writeVarInt(stack.getAmount());
        wrapper.writeMappedEntity(stack.getType());

        if (!stack.hasComponentPatches()) {
            wrapper.writeShort(0);
            return; // early return
        }

        // write component patch counts
        Map<ComponentType<?>, Optional<?>> allPatches = stack.getComponents().getPatches();
        int presentCount = 0, absentCount = 0;
        for (Map.Entry<ComponentType<?>, Optional<?>> patch : allPatches.entrySet()) {
            if (patch.getValue().isPresent()) {
                presentCount++;
            } else {
                absentCount++;
            }
        }
        wrapper.writeVarInt(presentCount);
        wrapper.writeVarInt(absentCount);

        // write present patches
        for (Map.Entry<ComponentType<?>, Optional<?>> patch : allPatches.entrySet()) {
            if (patch.getValue().isPresent()) {
                wrapper.writeVarInt(patch.getKey().getId(wrapper.getServerVersion().toClientVersion()));
                ((ComponentType<Object>) patch.getKey()).write(wrapper, patch.getValue().get());
            }
        }

        // write absent patches
        for (Map.Entry<ComponentType<?>, Optional<?>> patch : allPatches.entrySet()) {
            if (!patch.getValue().isPresent()) {
                wrapper.writeVarInt(patch.getKey().getId(wrapper.getServerVersion().toClientVersion()));
            }
        }
    }
}
