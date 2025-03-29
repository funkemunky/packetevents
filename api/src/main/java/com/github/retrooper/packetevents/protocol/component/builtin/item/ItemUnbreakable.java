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

package com.github.retrooper.packetevents.protocol.component.builtin.item;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import org.jetbrains.annotations.ApiStatus;

import java.util.Objects;

public class ItemUnbreakable {

    /**
     * Removed with 1.21.5
     */
    private boolean state;

    public ItemUnbreakable() {
        this(true);
    }

    /**
     * Removed with 1.21.5
     */
    @ApiStatus.Obsolete
    public ItemUnbreakable(boolean state) {
        this.state = state;
    }

    public static ItemUnbreakable read(PacketWrapper<?> wrapper) {
        if (wrapper.getServerVersion().isNewerThanOrEquals(ServerVersion.V_1_21_5)) {
            return new ItemUnbreakable();
        }
        return new ItemUnbreakable(wrapper.readBoolean());
    }

    public static void write(PacketWrapper<?> wrapper, ItemUnbreakable value) {
        if (wrapper.getServerVersion().isOlderThan(ServerVersion.V_1_21_5)) {
            wrapper.writeBoolean(value.state);
        }
    }

    /**
     * Removed with 1.21.5
     */
    @ApiStatus.Obsolete
    public boolean isState() {
        return this.state;
    }

    /**
     * Removed with 1.21.5
     */
    @ApiStatus.Obsolete
    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemUnbreakable)) return false;
        ItemUnbreakable that = (ItemUnbreakable) obj;
        return this.state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.state);
    }
}
