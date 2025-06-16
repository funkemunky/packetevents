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

package com.github.retrooper.packetevents.protocol.attribute;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NullMarked;

import java.util.Objects;

@NullMarked
public class OverrideAttributeDisplay implements AttributeDisplay {

    private final Component component;

    public OverrideAttributeDisplay(Component component) {
        this.component = component;
    }

    public static OverrideAttributeDisplay read(PacketWrapper<?> wrapper) {
        return new OverrideAttributeDisplay(wrapper.readComponent());
    }

    public static void write(PacketWrapper<?> wrapper, OverrideAttributeDisplay display) {
        wrapper.writeComponent(display.component);
    }

    @Override
    public AttributeDisplayType<?> getType() {
        return AttributeDisplayTypes.OVERRIDE;
    }

    public Component getComponent() {
        return this.component;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OverrideAttributeDisplay)) return false;
        OverrideAttributeDisplay that = (OverrideAttributeDisplay) obj;
        return this.component.equals(that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.component);
    }
}
