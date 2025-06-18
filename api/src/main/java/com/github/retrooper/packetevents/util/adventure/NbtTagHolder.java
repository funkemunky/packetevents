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

package com.github.retrooper.packetevents.util.adventure;

import com.github.retrooper.packetevents.protocol.nbt.NBT;
import net.kyori.adventure.nbt.api.BinaryTagHolder;
import net.kyori.adventure.util.Codec;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class NbtTagHolder implements BinaryTagHolder {

    private final NBT tag;

    public NbtTagHolder(NBT tag) {
        this.tag = tag;
    }

    @Override
    public @NotNull String string() {
        // TODO snbt serialization is currently not supported by packetevents
        throw new UnsupportedOperationException();
    }

    @Override
    public <T, DX extends Exception> @NotNull T get(@NotNull Codec<T, String, DX, ?> codec) throws DX {
        return codec.decode(this.string());
    }

    public NBT getTag() {
        return this.tag;
    }
}
