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

import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class TextInputControl implements InputControl {

    private final int width;
    private final Component label;
    private final boolean labelVisible;
    private final String initial;
    private final int maxLength;
    private final @Nullable MultilineOptions multiline;

    public TextInputControl(int width, Component label, boolean labelVisible, String initial, int maxLength, @Nullable MultilineOptions multiline) {
        if (initial.length() > maxLength) {
            throw new IllegalArgumentException("Default text length exceeds allowed size");
        }
        this.width = width;
        this.label = label;
        this.labelVisible = labelVisible;
        this.initial = initial;
        this.maxLength = maxLength;
        this.multiline = multiline;
    }

    public static TextInputControl decode(NBTCompound compound, ClientVersion version) {
        return null;
    }

    public static void encode(NBTCompound compound, ClientVersion version, TextInputControl control) {

    }

    @Override
    public Type<?> getType() {
        return InputControlTypes.TEXT;
    }

    public int getWidth() {
        return this.width;
    }

    public Component getLabel() {
        return this.label;
    }

    public boolean isLabelVisible() {
        return this.labelVisible;
    }

    public String getInitial() {
        return this.initial;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public @Nullable MultilineOptions getMultiline() {
        return this.multiline;
    }

    public static final class MultilineOptions {

        private final @Nullable Integer maxLines;
        private final @Nullable Integer height;

        public MultilineOptions(@Nullable Integer maxLines, @Nullable Integer height) {
            this.maxLines = maxLines;
            this.height = height;
        }

        public @Nullable Integer getMaxLines() {
            return this.maxLines;
        }

        public @Nullable Integer getHeight() {
            return this.height;
        }
    }
}
