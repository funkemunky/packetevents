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

package com.github.retrooper.packetevents.protocol.component.builtin;

import com.github.retrooper.packetevents.protocol.entity.parrot.ParrotVariant;
import com.github.retrooper.packetevents.protocol.entity.parrot.ParrotVariants;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

import java.util.Objects;

public class ParrotVariantComponent {

    private ParrotVariant variant;

    public ParrotVariantComponent(ParrotVariant variant) {
        this.variant = variant;
    }

    public static ParrotVariantComponent read(PacketWrapper<?> wrapper) {
        ParrotVariant type = wrapper.readMappedEntity(ParrotVariants.getRegistry());
        return new ParrotVariantComponent(type);
    }

    public static void write(PacketWrapper<?> wrapper, ParrotVariantComponent component) {
        wrapper.writeMappedEntity(component.variant);
    }

    public ParrotVariant getVariant() {
        return this.variant;
    }

    public void setVariant(ParrotVariant variant) {
        this.variant = variant;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ParrotVariantComponent)) return false;
        ParrotVariantComponent that = (ParrotVariantComponent) obj;
        return this.variant.equals(that.variant);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.variant);
    }
}
