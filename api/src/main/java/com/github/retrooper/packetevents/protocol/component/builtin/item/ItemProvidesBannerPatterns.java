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

import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

import java.util.Objects;

public class ItemProvidesBannerPatterns {

    private ResourceLocation tagKey;

    public ItemProvidesBannerPatterns(ResourceLocation tagKey) {
        this.tagKey = tagKey;
    }

    public static ItemProvidesBannerPatterns read(PacketWrapper<?> wrapper) {
        ResourceLocation tagKey = wrapper.readIdentifier();
        return new ItemProvidesBannerPatterns(tagKey);
    }

    public static void write(PacketWrapper<?> wrapper, ItemProvidesBannerPatterns patterns) {
        wrapper.writeIdentifier(patterns.tagKey);
    }

    public ResourceLocation getTagKey() {
        return this.tagKey;
    }

    public void setTagKey(ResourceLocation tagKey) {
        this.tagKey = tagKey;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemProvidesBannerPatterns)) return false;
        ItemProvidesBannerPatterns that = (ItemProvidesBannerPatterns) obj;
        return this.tagKey.equals(that.tagKey);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.tagKey);
    }
}
