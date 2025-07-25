/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2022 retrooper and contributors
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

package com.github.retrooper.packetevents.protocol.entity.type;

import com.github.retrooper.packetevents.protocol.mapper.LegacyMappedEntity;
import com.github.retrooper.packetevents.protocol.mapper.MappedEntity;

import java.util.Optional;

public interface EntityType extends MappedEntity, LegacyMappedEntity {

    boolean isInstanceOf(EntityType parent);

    Optional<EntityType> getParent();
}
