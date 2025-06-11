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

import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;

@NullMarked
public class SingleOptionInputControl implements InputControl {

    private final int width;
    private final List<Entry> entries;
    private final Component label;
    private final boolean labelVisible;

    public SingleOptionInputControl(int width, List<Entry> entries, Component label, boolean labelVisible) {
        boolean initial = false;
        for (Entry entry : entries) {
            if (entry.initial) {
                if (initial) {
                    throw new IllegalArgumentException("Multiple initial values");
                }
                initial = true;
            }
        }
        this.width = width;
        this.entries = entries;
        this.label = label;
        this.labelVisible = labelVisible;
    }

    @Override
    public Type<?> getType() {
        return InputControlTypes.SINGLE_OPTION;
    }

    public int getWidth() {
        return this.width;
    }

    public List<Entry> getEntries() {
        return this.entries;
    }

    public Component getLabel() {
        return this.label;
    }

    public boolean isLabelVisible() {
        return this.labelVisible;
    }

    public static final class Entry {

        private final String id;
        private final @Nullable Component display;
        private final boolean initial;

        public Entry(String id, @Nullable Component display, boolean initial) {
            this.id = id;
            this.display = display;
            this.initial = initial;
        }

        public String getId() {
            return this.id;
        }

        public @Nullable Component getDisplay() {
            return this.display;
        }

        public boolean isInitial() {
            return this.initial;
        }
    }
}
