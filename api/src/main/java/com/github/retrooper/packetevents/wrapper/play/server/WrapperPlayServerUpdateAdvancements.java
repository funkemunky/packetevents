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

package com.github.retrooper.packetevents.wrapper.play.server;

import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.advancements.AdvancementHolder;
import com.github.retrooper.packetevents.protocol.advancements.AdvancementProgress;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WrapperPlayServerUpdateAdvancements extends PacketWrapper<WrapperPlayServerUpdateAdvancements> {
    private boolean reset;
    private List<AdvancementHolder> addedAdvancements;
    private LinkedHashSet<ResourceLocation> removedAdvancements;
    private Map<ResourceLocation, AdvancementProgress> progress;// key = advancement id
    private @Nullable Boolean showAdvancements = null; // 1.21.5+

    public WrapperPlayServerUpdateAdvancements(PacketSendEvent event) {
        super(event);
    }

    public WrapperPlayServerUpdateAdvancements(boolean reset, List<AdvancementHolder> addedAdvancements,
                                               LinkedHashSet<ResourceLocation> removedAdvancements,
                                               Map<ResourceLocation, AdvancementProgress> progress,
                                               @Nullable Boolean showAdvancements) {
        super(PacketType.Play.Server.UPDATE_ADVANCEMENTS);
        this.reset = reset;
        this.addedAdvancements = addedAdvancements;
        this.removedAdvancements = removedAdvancements;
        this.progress = progress;
        this.showAdvancements = showAdvancements;
    }

    @Override
    public void read() {
        reset = readBoolean();

        addedAdvancements = readList(AdvancementHolder::read);
        removedAdvancements = readCollection(LinkedHashSet::new, ResourceLocation::read);

        progress = readMap(PacketWrapper::readIdentifier, AdvancementProgress::read);

        if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_21_5)) {
            showAdvancements = readBoolean();
        }
    }

    @Override
    public void write() {
        writeBoolean(reset);
        writeList(addedAdvancements, AdvancementHolder::write);
        writeCollection(removedAdvancements, PacketWrapper::writeIdentifier);
        writeMap(progress, PacketWrapper::writeIdentifier, AdvancementProgress::write);
        if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_21_5)) {
            writeBoolean(showAdvancements != null ? showAdvancements : false);
        }
    }

    @Override
    public void copy(WrapperPlayServerUpdateAdvancements wrapper) {
        this.reset = wrapper.reset;
        this.addedAdvancements = wrapper.addedAdvancements;
        this.removedAdvancements = wrapper.removedAdvancements;
        this.progress = wrapper.progress;
        this.showAdvancements = wrapper.showAdvancements;
    }

    public boolean isReset() {
        return reset;
    }

    public List<AdvancementHolder> getAddedAdvancements() {
        return addedAdvancements;
    }

    public LinkedHashSet<ResourceLocation> getRemovedAdvancements() {
        return removedAdvancements;
    }

    public Map<ResourceLocation, AdvancementProgress> getProgress() {
        return progress;
    }

    public Optional<Boolean> getShowAdvancements() {
        return Optional.ofNullable(showAdvancements);
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public void setAddedAdvancements(List<AdvancementHolder> addedAdvancements) {
        this.addedAdvancements = addedAdvancements;
    }

    public void setRemovedAdvancements(LinkedHashSet<ResourceLocation> removedAdvancements) {
        this.removedAdvancements = removedAdvancements;
    }

    public void setProgress(Map<ResourceLocation, AdvancementProgress> progress) {
        this.progress = progress;
    }

    public void setShowAdvancements(@Nullable Boolean showAdvancements) {
        this.showAdvancements = showAdvancements;
    }
}
