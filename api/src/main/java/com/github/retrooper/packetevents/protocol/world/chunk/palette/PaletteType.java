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

    BIOME(1, 3, 2, 4 * 4 * 4),
    CHUNK(4, 8, 4, 16 * 16 * 16);

    private final int minBitsPerEntry;
    private final int maxBitsPerEntry;
    private final int bitShift;
    private final int storageSize;

    PaletteType(int minBitsPerEntry, int maxBitsPerEntry, int bitShift, int storageSize) {
        this.minBitsPerEntry = minBitsPerEntry;
        this.maxBitsPerEntry = maxBitsPerEntry;
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
        ListPalette palette = new ListPalette(this.minBitsPerEntry);
        BitStorage storage = new BitStorage(this.minBitsPerEntry, this.storageSize);
        return new DataPalette(palette, storage, this);
    }

    public int getMaxBitsPerEntry() {
        return maxBitsPerEntry;
    }

    public int getMinBitsPerEntry() {
        return minBitsPerEntry;
    }

    public int getBitShift() {
        return bitShift;
    }

    public int getStorageSize() {
        return storageSize;
    }
}
