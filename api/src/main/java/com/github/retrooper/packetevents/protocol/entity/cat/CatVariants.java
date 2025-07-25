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

package com.github.retrooper.packetevents.protocol.entity.cat;

import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.util.mappings.VersionedRegistry;
import org.jetbrains.annotations.ApiStatus;

public final class CatVariants {

    private static final VersionedRegistry<CatVariant> REGISTRY =
            new VersionedRegistry<>("cat_variant");

    private CatVariants() {
    }

    @ApiStatus.Internal
    public static CatVariant define(String name) {
        ResourceLocation assetId = new ResourceLocation("entity/cat/" + name);
        return REGISTRY.define(name, data ->
                new StaticCatVariant(data, assetId));
    }

    public static VersionedRegistry<CatVariant> getRegistry() {
        return REGISTRY;
    }

    public static final CatVariant ALL_BLACK = define("all_black");
    public static final CatVariant BLACK = define("black");
    public static final CatVariant BRITISH_SHORTHAIR = define("british_shorthair");
    public static final CatVariant CALICO = define("calico");
    public static final CatVariant JELLIE = define("jellie");
    public static final CatVariant PERSIAN = define("persian");
    public static final CatVariant RAGDOLL = define("ragdoll");
    public static final CatVariant RED = define("red");
    public static final CatVariant SIAMESE = define("siamese");
    public static final CatVariant TABBY = define("tabby");
    public static final CatVariant WHITE = define("white");

    static {
        REGISTRY.unloadMappings();
    }
}
