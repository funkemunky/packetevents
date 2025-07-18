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

import com.github.retrooper.packetevents.wrapper.PacketWrapper;

import java.util.Objects;

public class ItemPotionDurationScale {

    private float scale;

    public ItemPotionDurationScale(float scale) {
        this.scale = scale;
    }

    public static ItemPotionDurationScale read(PacketWrapper<?> wrapper) {
        float scale = wrapper.readFloat();
        return new ItemPotionDurationScale(scale);
    }

    public static void write(PacketWrapper<?> wrapper, ItemPotionDurationScale scale) {
        wrapper.writeFloat(scale.scale);
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemPotionDurationScale)) return false;
        ItemPotionDurationScale that = (ItemPotionDurationScale) obj;
        return Float.compare(that.scale, this.scale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.scale);
    }
}
