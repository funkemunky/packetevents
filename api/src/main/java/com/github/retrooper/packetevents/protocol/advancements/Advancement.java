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

import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Advancement {

    private @Nullable ResourceLocation parent;
    private @Nullable AdvancementDisplay display;
    // 1.20.1-
    private @Nullable List<String> criteria;
    private List<List<String>> requirements;
    // 1.20+
    private @Nullable Boolean sendsTelemetryData;

    public Advancement(@Nullable ResourceLocation parent, @Nullable AdvancementDisplay display, @Nullable List<String> criteria,
                       List<List<String>> requirements, @Nullable Boolean sendsTelemetryData) {
        this.parent = parent;
        this.display = display;
        this.criteria = criteria;
        this.requirements = requirements;
        this.sendsTelemetryData = sendsTelemetryData;
    }

    public static Advancement read(PacketWrapper<?> wrapper, ServerVersion serverVersion) {
        ResourceLocation parentId = wrapper.readOptional(ResourceLocation::read);
        AdvancementDisplay display = wrapper.readOptional(AdvancementDisplay::read);
        List<String> criteria = null;
        if (serverVersion.isOlderThanOrEquals(ServerVersion.V_1_20_1)) {
            criteria = wrapper.readList(PacketWrapper::readString);
        }
        List<List<String>> requirements = wrapper.readList(packetWrapper -> wrapper.readList(PacketWrapper::readString));
        Boolean sendsTelemetryData = null;
        if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20)) {
            sendsTelemetryData = wrapper.readBoolean();
        }
        return new Advancement(parentId, display, criteria, requirements, sendsTelemetryData);
    }

    public static void write(PacketWrapper<?> packetWrapper, Advancement advancement) {
        packetWrapper.writeOptional(advancement.getParent().orElse(null), PacketWrapper::writeIdentifier);
        packetWrapper.writeOptional(advancement.getDisplay().orElse(null), AdvancementDisplay::write);
        if (packetWrapper.getServerVersion().isOlderThanOrEquals(ServerVersion.V_1_20_1)) {
            List<String> criteria = advancement.getCriteria().orElse(new ArrayList<>());
            packetWrapper.writeList(criteria, PacketWrapper::writeString);
        }
        packetWrapper.writeList(advancement.getRequirements(), (packetWrapper1, strings)
                -> packetWrapper1.writeList(strings, PacketWrapper::writeString));
        if (packetWrapper.getServerVersion().isNewerThanOrEquals(ServerVersion.V_1_20)) {
            packetWrapper.writeBoolean(advancement.isSendsTelemetryData().orElse(false));
        }
    }

    public Optional<ResourceLocation> getParent() {
        return Optional.ofNullable(parent);
    }

    public Optional<AdvancementDisplay> getDisplay() {
        return Optional.ofNullable(display);
    }

    public Optional<List<String>> getCriteria() {
        return Optional.ofNullable(criteria);
    }

    public List<List<String>> getRequirements() {
        return requirements;
    }

    public Optional<Boolean> isSendsTelemetryData() {
        return Optional.ofNullable(sendsTelemetryData);
    }

    public void setParent(@Nullable ResourceLocation parent) {
        this.parent = parent;
    }

    public void setDisplay(@Nullable AdvancementDisplay display) {
        this.display = display;
    }

    public void setCriteria(@Nullable List<String> criteria) {
        this.criteria = criteria;
    }

    public void setRequirements(List<List<String>> requirements) {
        this.requirements = requirements;
    }

    public void setSendsTelemetryData(@Nullable Boolean sendsTelemetryData) {
        this.sendsTelemetryData = sendsTelemetryData;
    }
}
