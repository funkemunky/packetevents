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

import com.github.retrooper.packetevents.protocol.item.trimmaterial.TrimMaterial;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.util.Either;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

import java.util.Objects;

public class ItemProvidesTrimMaterial {

    // I am questioning if Mojang understood their own registry system...
    private Either<TrimMaterial, ResourceLocation> material;

    public ItemProvidesTrimMaterial(Either<TrimMaterial, ResourceLocation> material) {
        this.material = material;
    }

    public static ItemProvidesTrimMaterial read(PacketWrapper<?> wrapper) {
        Either<TrimMaterial, ResourceLocation> material = wrapper.readEither(TrimMaterial::read, PacketWrapper::readIdentifier);
        return new ItemProvidesTrimMaterial(material);
    }

    public static void write(PacketWrapper<?> wrapper, ItemProvidesTrimMaterial material) {
        wrapper.writeEither(material.material, TrimMaterial::write, PacketWrapper::writeIdentifier);
    }

    public Either<TrimMaterial, ResourceLocation> getMaterial() {
        return this.material;
    }

    public void setMaterial(Either<TrimMaterial, ResourceLocation> material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemProvidesTrimMaterial)) return false;
        ItemProvidesTrimMaterial that = (ItemProvidesTrimMaterial) obj;
        return this.material.equals(that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.material);
    }
}
