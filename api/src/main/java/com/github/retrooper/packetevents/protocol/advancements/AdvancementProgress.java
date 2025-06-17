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

import com.github.retrooper.packetevents.wrapper.PacketWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AdvancementProgress {
    private Map<String, Optional<Long>> criteria = new HashMap<>();

    public AdvancementProgress(Map<String, Optional<Long>> criteria) {
        this.criteria = criteria;
    }

    public static AdvancementProgress read(PacketWrapper<?> wrapper) {
        Map<String, Optional<Long>> criteria = wrapper.readMap(PacketWrapper::readString, packetWrapper -> Optional.ofNullable(packetWrapper.readOptional(PacketWrapper::readLong)));
        return new AdvancementProgress(criteria);
    }

    public static void write(PacketWrapper<?> wrapper, AdvancementProgress progress) {
        wrapper.writeMap(progress.getCriteria(), PacketWrapper::writeString,
                (packetWrapper, aLong) -> packetWrapper.writeOptional(aLong.orElse(null),
                        PacketWrapper::writeLong));
    }

    public Map<String, Optional<Long>> getCriteria() {
        return criteria;
    }

    public void setCriteria(Map<String, Optional<Long>> criteria) {
        this.criteria = criteria;
    }
}
