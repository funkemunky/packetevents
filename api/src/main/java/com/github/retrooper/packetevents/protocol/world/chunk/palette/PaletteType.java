/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2022 retrooper and contributors
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

package com.github.retrooper.packetevents.protocol.world.chunk.palette;

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.stream.NetStreamInputWrapper;
import com.github.retrooper.packetevents.protocol.stream.NetStreamOutputWrapper;
import com.github.retrooper.packetevents.protocol.world.chunk.storage.BitStorage;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

public enum PaletteType {

    /**
     * Added with 1.18:
     * <ul>
     * <li>0 bits → {@link SingletonPalette}</li>
     * <li>1, 2 or 3 bits → {@link ListPalette}</li>
     * <li>else → {@link GlobalPalette}</li>
     * </ul>
     */
    BIOME(3, 0, 2, 4 * 4 * 4),
    /**
     * <ul>
     * <li>0, 1, 2, 3 or 4 bits → {@link ListPalette}</li>
     * <li>5, 6, 7 or 8 bits → {@link MapPalette}</li>
     * <li>else → {@link GlobalPalette}</li>
     * </ul>
     * Changed with 1.18:
     * <ul>
     * <li>0 bits → {@link SingletonPalette}</li>
     * <li>1, 2, 3 or 4 bits → {@link ListPalette}</li>
     * <li>5, 6, 7 or 8 bits → {@link MapPalette}</li>
     * <li>else → {@link GlobalPalette}</li>
     * </ul>
     */
    CHUNK(4, 8, 4, 16 * 16 * 16);

    private final int maxBitsPerEntryForList;
    private final int maxBitsPerEntryForMap;
    private final int bitShift;
    private final int storageSize;

    PaletteType(int maxBitsPerEntryForList, int maxBitsPerEntryForMap, int bitShift, int storageSize) {
        this.maxBitsPerEntryForList = maxBitsPerEntryForList;
        this.maxBitsPerEntryForMap = maxBitsPerEntryForMap;
        this.bitShift = bitShift;
        this.storageSize = storageSize;
    }

    public static void write(PacketWrapper<?> wrapper, DataPalette palette) {
        DataPalette.write(new NetStreamOutputWrapper(wrapper), palette);
    }

    public DataPalette read(PacketWrapper<?> wrapper) {
        if (wrapper.getServerVersion().isNewerThanOrEquals(ServerVersion.V_1_16)) {
            boolean allowSingletonPalette = wrapper.getServerVersion().isNewerThanOrEquals(ServerVersion.V_1_18);
            return DataPalette.read(new NetStreamInputWrapper(wrapper), this, allowSingletonPalette);
        }
        return DataPalette.readLegacy(new NetStreamInputWrapper(wrapper));
    }

    public DataPalette create() {
        int bitsPerEntry = this.getMaxBitsPerEntryForList();
        Palette palette = new ListPalette(bitsPerEntry);
        BitStorage storage = new BitStorage(bitsPerEntry, this.getStorageSize());
        return new DataPalette(palette, storage, this);
    }

    public int getMaxBitsPerEntryForList() {
        return this.maxBitsPerEntryForList;
    }

    public int getMaxBitsPerEntryForMap() {
        return this.maxBitsPerEntryForMap;
    }

    public int getBitShift() {
        return this.bitShift;
    }

    public int getStorageSize() {
        return this.storageSize;
    }

    @Deprecated
    public int getMaxBitsPerEntry() {
        return this.maxBitsPerEntryForMap;
    }

    @Deprecated
    public int getMinBitsPerEntry() {
        return this.maxBitsPerEntryForList;
    }
}
