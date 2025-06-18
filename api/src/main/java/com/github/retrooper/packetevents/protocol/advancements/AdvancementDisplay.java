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

package com.github.retrooper.packetevents.protocol.advancements;

import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

public class AdvancementDisplay {
    public static final int SHOW_BACKGROUND_TEXTURE = 0x01;
    public static final int SHOW_TOAST = 0x02;
    public static final int HIDDEN = 0x04;
    private Component title;
    private Component description;
    private ItemStack icon;
    private AdvancementType type;
    private boolean showToast;
    private boolean hidden;
    private @Nullable ResourceLocation background;
    private float x;
    private float y;

    public AdvancementDisplay(Component title, Component description, ItemStack icon, AdvancementType type, @Nullable ResourceLocation background, boolean showToast,
                              boolean hidden, float x, float y) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.type = type;
        this.showToast = showToast;
        this.hidden = hidden;
        this.background = background;
        this.x = x;
        this.y = y;
    }


    public static AdvancementDisplay read(PacketWrapper<?> wrapper) {
        Component title = wrapper.readComponent();
        Component description = wrapper.readComponent();
        ItemStack icon = wrapper.readItemStack();
        AdvancementType type = wrapper.readEnum(AdvancementType.class);
        int flags = wrapper.readInt();
        ResourceLocation background = (flags & SHOW_BACKGROUND_TEXTURE) != 0 ? ResourceLocation.read(wrapper) : null;
        boolean showToast = (flags & SHOW_TOAST) != 0;
        boolean hidden = (flags & HIDDEN) != 0;
        float x = wrapper.readFloat();
        float y = wrapper.readFloat();
        return new AdvancementDisplay(title, description, icon, type, background, showToast, hidden, x, y);
    }

    public static void write(PacketWrapper<?> wrapper, AdvancementDisplay display) {
        wrapper.writeComponent(display.title);
        wrapper.writeComponent(display.description);
        wrapper.writeItemStack(display.icon);
        wrapper.writeEnum(display.type);
        int flags = display.flags();
        wrapper.writeInt(flags);
        if (display.background != null) {
            ResourceLocation.write(wrapper, display.background);
        }
        wrapper.writeFloat(display.x);
        wrapper.writeFloat(display.y);
    }

    public int flags() {
        int flags = 0;
        if (background != null) {
            flags |= SHOW_BACKGROUND_TEXTURE;
        }
        if (showToast) {
            flags |= SHOW_TOAST;
        }
        if (hidden) {
            flags |= HIDDEN;
        }
        return flags;
    }

    public Component getTitle() {
        return title;
    }

    public Component getDescription() {
        return description;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public AdvancementType getType() {
        return type;
    }

    public boolean isShowToast() {
        return showToast;
    }

    public boolean isHidden() {
        return hidden;
    }

    @Nullable
    public ResourceLocation getBackground() {
        return background;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setTitle(Component title) {
        this.title = title;
    }

    public void setDescription(Component description) {
        this.description = description;
    }

    public void setIcon(ItemStack icon) {
        this.icon = icon;
    }

    public void setType(AdvancementType type) {
        this.type = type;
    }

    public void setShowToast(boolean showToast) {
        this.showToast = showToast;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setBackground(@Nullable ResourceLocation background) {
        this.background = background;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}
