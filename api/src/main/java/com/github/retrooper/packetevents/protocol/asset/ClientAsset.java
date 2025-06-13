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

package com.github.retrooper.packetevents.protocol.asset;

import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

public class ClientAsset {
    private ResourceLocation id;
    private ResourceLocation texturePath;

    public ClientAsset(ResourceLocation id, ResourceLocation texturePath) {
        this.id = id;
        this.texturePath = texturePath;
    }

    public static ClientAsset read(PacketWrapper<?> wrapper) {
        ResourceLocation id = wrapper.readIdentifier();
        ResourceLocation texturePath = wrapper.readIdentifier();

        return new ClientAsset(id, texturePath);
    }

    public static void write(PacketWrapper<?> wrapper, ClientAsset asset) {
        wrapper.writeIdentifier(asset.id);
        wrapper.writeIdentifier(asset.texturePath);
    }

    public ResourceLocation getId() {
        return id;
    }

    public ResourceLocation getTexturePath() {
        return texturePath;
    }

    public void setId(ResourceLocation id) {
        this.id = id;
    }

    public void setTexturePath(ResourceLocation texturePath) {
        this.texturePath = texturePath;
    }
}
