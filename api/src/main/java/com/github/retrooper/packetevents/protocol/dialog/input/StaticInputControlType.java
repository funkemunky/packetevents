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

package com.github.retrooper.packetevents.protocol.dialog.input;

import com.github.retrooper.packetevents.protocol.mapper.AbstractMappedEntity;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.mappings.TypesBuilderData;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class StaticInputControlType<T extends InputControl> extends AbstractMappedEntity implements InputControl.Type<T> {

    private final InputControl.Decoder<T> decoder;
    private final InputControl.Encoder<T> encoder;

    @ApiStatus.Internal
    public StaticInputControlType(
            @Nullable TypesBuilderData data,
            InputControl.Decoder<T> decoder,
            InputControl.Encoder<T> encoder
    ) {
        super(data);
        this.decoder = decoder;
        this.encoder = encoder;
    }

    @Override
    public T decode(NBTCompound compound, ClientVersion version) {
        return this.decoder.decode(compound, version);
    }

    @Override
    public void encode(NBTCompound compound, ClientVersion version, T control) {
        this.encoder.encode(compound, version, control);
    }
}
