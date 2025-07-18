/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2024 retrooper and contributors
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

package com.github.retrooper.packetevents.protocol.color;

import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import net.kyori.adventure.util.RGBLike;
import org.jetbrains.annotations.NotNull;

public enum DyeColor implements RGBLike {
    WHITE(new Color(0xf9fffe), new Color(0xffffff), new Color(0xf0f0f0), 8),

    ORANGE(new Color(0xf9801d), new Color(0xff681f), new Color(0xeb8844), 15),

    MAGENTA(new Color(0xc74ebd), new Color(0xff00ff), new Color(0xc354cd), 16),

    LIGHT_BLUE(new Color(0x3ab3da), new Color(0x9ac0cd), new Color(0x6689d3), 17),

    YELLOW(new Color(0xfed83d), new Color(0xffff00), new Color(0xdecf2a), 18),

    LIME(new Color(0x80c71f), new Color(0xbfff00), new Color(0x41cd34), 19),

    PINK(new Color(0xf38baa), new Color(0xff69b4), new Color(0xd88198), 20),

    GRAY(new Color(0x474f52), new Color(0x808080), new Color(0x434343), 21),

    LIGHT_GRAY(new Color(0x9d9d97), new Color(0xd3d3d3), new Color(0xababab), 22),

    CYAN(new Color(0x169c9c), new Color(0xffff), new Color(0x287697), 23),

    PURPLE(new Color(0x8932b8), new Color(0xa020f0), new Color(0x7b2fbe), 24),

    BLUE(new Color(0x3c44aa), new Color(0xff), new Color(0x253192), 25),

    BROWN(new Color(0x835432), new Color(0x8b4513), new Color(0x51301a), 26),

    GREEN(new Color(0x5e7c16), new Color(0xff00), new Color(0x3b511a), 27),

    RED(new Color(0xb02e26), new Color(0xff0000), new Color(0xb3312c), 28),

    BLACK(new Color(0x1d1d21), new Color(0x0), new Color(0x1e1b1b), 29);

    private static final DyeColor[] COLORS = values();

    private final Color textureDiffuseColor;

    private final Color textColor;

    private final Color fireworkColor;

    private final int mapColorId;

    DyeColor(@NotNull Color textureDiffuseColor, @NotNull Color textColor,
             @NotNull Color fireworkColor, int mapColorId) {
        this.textureDiffuseColor = textureDiffuseColor;
        this.textColor = textColor;
        this.fireworkColor = fireworkColor;
        this.mapColorId = mapColorId;
    }

    public static DyeColor read(PacketWrapper<?> wrapper) {
        return wrapper.readEnum(COLORS);
    }

    public static void write(PacketWrapper<?> wrapper, DyeColor color) {
        wrapper.writeEnum(color);
    }

    public @NotNull Color color() {
        return this.textureDiffuseColor;
    }

    public @NotNull Color textColor() {
        return this.textColor;
    }

    public @NotNull Color fireworkColor() {
        return this.fireworkColor;
    }

    @Override
    public int red() {
        return this.textureDiffuseColor.red();
    }

    @Override
    public int green() {
        return this.textureDiffuseColor.green();
    }

    @Override
    public int blue() {
        return this.textureDiffuseColor.blue();
    }

    public int mapColorId() {
        return this.mapColorId;
    }
}
