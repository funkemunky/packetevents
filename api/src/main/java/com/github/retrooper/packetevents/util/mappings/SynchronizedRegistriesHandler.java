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

package com.github.retrooper.packetevents.util.mappings;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.chat.ChatType;
import com.github.retrooper.packetevents.protocol.chat.ChatTypes;
import com.github.retrooper.packetevents.protocol.dialog.Dialog;
import com.github.retrooper.packetevents.protocol.dialog.Dialogs;
import com.github.retrooper.packetevents.protocol.entity.cat.CatVariant;
import com.github.retrooper.packetevents.protocol.entity.cat.CatVariants;
import com.github.retrooper.packetevents.protocol.entity.chicken.ChickenVariant;
import com.github.retrooper.packetevents.protocol.entity.chicken.ChickenVariants;
import com.github.retrooper.packetevents.protocol.entity.cow.CowVariant;
import com.github.retrooper.packetevents.protocol.entity.cow.CowVariants;
import com.github.retrooper.packetevents.protocol.entity.frog.FrogVariant;
import com.github.retrooper.packetevents.protocol.entity.frog.FrogVariants;
import com.github.retrooper.packetevents.protocol.entity.pig.PigVariant;
import com.github.retrooper.packetevents.protocol.entity.pig.PigVariants;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfSoundVariant;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfSoundVariants;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfVariant;
import com.github.retrooper.packetevents.protocol.entity.wolfvariant.WolfVariants;
import com.github.retrooper.packetevents.protocol.item.banner.BannerPattern;
import com.github.retrooper.packetevents.protocol.item.banner.BannerPatterns;
import com.github.retrooper.packetevents.protocol.item.enchantment.type.EnchantmentType;
import com.github.retrooper.packetevents.protocol.item.enchantment.type.EnchantmentTypes;
import com.github.retrooper.packetevents.protocol.item.instrument.Instrument;
import com.github.retrooper.packetevents.protocol.item.instrument.Instruments;
import com.github.retrooper.packetevents.protocol.item.jukebox.IJukeboxSong;
import com.github.retrooper.packetevents.protocol.item.jukebox.JukeboxSongs;
import com.github.retrooper.packetevents.protocol.item.trimmaterial.TrimMaterial;
import com.github.retrooper.packetevents.protocol.item.trimmaterial.TrimMaterials;
import com.github.retrooper.packetevents.protocol.item.trimpattern.TrimPattern;
import com.github.retrooper.packetevents.protocol.item.trimpattern.TrimPatterns;
import com.github.retrooper.packetevents.protocol.mapper.CopyableEntity;
import com.github.retrooper.packetevents.protocol.mapper.DeepComparableEntity;
import com.github.retrooper.packetevents.protocol.mapper.MappedEntity;
import com.github.retrooper.packetevents.protocol.mapper.ResolvableEntity;
import com.github.retrooper.packetevents.protocol.nbt.NBT;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.nbt.NBTList;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.protocol.player.User;
import com.github.retrooper.packetevents.protocol.world.biome.Biome;
import com.github.retrooper.packetevents.protocol.world.biome.Biomes;
import com.github.retrooper.packetevents.protocol.world.damagetype.DamageType;
import com.github.retrooper.packetevents.protocol.world.damagetype.DamageTypes;
import com.github.retrooper.packetevents.protocol.world.dimension.DimensionType;
import com.github.retrooper.packetevents.protocol.world.dimension.DimensionTypes;
import com.github.retrooper.packetevents.protocol.world.painting.PaintingVariant;
import com.github.retrooper.packetevents.protocol.world.painting.PaintingVariants;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.configuration.server.WrapperConfigServerRegistryData.RegistryElement;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

@ApiStatus.Internal
public final class SynchronizedRegistriesHandler {

    private static final boolean FORCE_PER_USER_REGISTRIES = Boolean.getBoolean("packetevents.force-per-user-registries");
    private static final Map<ResourceLocation, RegistryEntry<?>> REGISTRY_KEYS = new HashMap<>();

    static {
        // packetevents ignores a few unimportant registries which aren't used anywhere else in the protocol:
        // test_environment, test_instance
        Stream.of(
                new RegistryEntry<>(Biomes.getRegistry(), Biome::decode),
                new RegistryEntry<>(ChatTypes.getRegistry(), ChatType::decode),
                new RegistryEntry<>(TrimPatterns.getRegistry(), (NbtEntryDecoder<TrimPattern>) TrimPattern::decode),
                new RegistryEntry<>(TrimMaterials.getRegistry(), (NbtEntryDecoder<TrimMaterial>) TrimMaterial::decode),
                new RegistryEntry<>(WolfVariants.getRegistry(), (NbtEntryDecoder<WolfVariant>) WolfVariant::decode),
                new RegistryEntry<>(WolfSoundVariants.getRegistry(), WolfSoundVariant::decode),
                new RegistryEntry<>(PigVariants.getRegistry(), PigVariant::decode),
                new RegistryEntry<>(FrogVariants.getRegistry(), FrogVariant::decode),
                new RegistryEntry<>(CatVariants.getRegistry(), CatVariant::decode),
                new RegistryEntry<>(CowVariants.getRegistry(), CowVariant::decode),
                new RegistryEntry<>(ChickenVariants.getRegistry(), ChickenVariant::decode),
                new RegistryEntry<>(PaintingVariants.getRegistry(), PaintingVariant::decode),
                new RegistryEntry<>(DimensionTypes.getRegistry(), DimensionType::decode),
                new RegistryEntry<>(DamageTypes.getRegistry(), DamageType::decode),
                new RegistryEntry<>(BannerPatterns.getRegistry(), BannerPattern::decode),
                new RegistryEntry<>(EnchantmentTypes.getRegistry(), (NbtEntryDecoder<EnchantmentType>) EnchantmentType::decode),
                new RegistryEntry<>(JukeboxSongs.getRegistry(), (NbtEntryDecoder<IJukeboxSong>) IJukeboxSong::decode),
                new RegistryEntry<>(Instruments.getRegistry(), (NbtEntryDecoder<Instrument>) Instrument::decode),
                new RegistryEntry<>(Dialogs.getRegistry(), Dialog::decodeDirect)
        ).forEach(entry -> REGISTRY_KEYS.put(entry.getRegistryKey(), entry));
    }

    private SynchronizedRegistriesHandler() {
    }

    public static @Nullable RegistryEntry<?> getRegistryEntry(ResourceLocation registryKey) {
        return REGISTRY_KEYS.get(registryKey);
    }

    public static void handleRegistry(
            User user, PacketWrapper<?> wrapper,
            ResourceLocation registryName,
            List<RegistryElement> elements
    ) {
        Object cacheKey = PacketEvents.getAPI().getServerManager().getRegistryCacheKey(
                user, wrapper.getServerVersion().toClientVersion());
        handleRegistry(user, wrapper, registryName, elements, cacheKey);
    }

    public static void handleRegistry(
            User user, PacketWrapper<?> wrapper,
            ResourceLocation registryName,
            List<RegistryElement> elements,
            Object cacheKey
    ) {
        RegistryEntry<?> registryData = REGISTRY_KEYS.get(registryName);
        if (registryData == null) {
            return;
        }
        SimpleRegistry<?> syncedRegistry;
        if (FORCE_PER_USER_REGISTRIES || cacheKey == null) {
            syncedRegistry = registryData.createFromElements(elements, wrapper); // no caching
        } else {
            syncedRegistry = registryData.computeSyncedRegistry(cacheKey, () ->
                    registryData.createFromElements(elements, wrapper));
        }
        user.putRegistry(syncedRegistry);
        // do some resolving stuff for registry entries which may
        // reference the same registry they are in
        for (MappedEntity entry : syncedRegistry.getEntries()) {
            if (entry instanceof ResolvableEntity) {
                ((ResolvableEntity) entry).doResolve(wrapper);
            }
        }
    }

    public static void handleLegacyRegistries(
            User user, PacketWrapper<?> wrapper,
            NBTCompound registryData
    ) {
        Object cacheKey = PacketEvents.getAPI().getServerManager().getRegistryCacheKey(
                user, wrapper.getServerVersion().toClientVersion());
        for (NBT tag : registryData.getTags().values()) {
            //On 1.16 they send an NBTList for dimension.
            if (tag instanceof NBTList) {
                NBTList<NBTCompound> list = (NBTList<NBTCompound>) tag;
                handleRegistry(user, wrapper, DimensionTypes.getRegistry().getRegistryKey(),
                        RegistryElement.convertNbt(list), cacheKey);

            }
            //Newer versions
            else {
                NBTCompound compound = (NBTCompound) tag;
                // extract registry name
                ResourceLocation registryName = new ResourceLocation(compound.getStringTagValueOrThrow("type"));
                // extract registry entries
                NBTList<NBTCompound> nbtElements = compound.getCompoundListTagOrNull("value");
                if (nbtElements != null) {
                    // store registry elements
                    handleRegistry(user, wrapper, registryName,
                            RegistryElement.convertNbt(nbtElements), cacheKey);
                }
            }
        }
    }

    @ApiStatus.Internal
    @FunctionalInterface
    public interface LegacyNbtEntryDecoder<T> {

        T decode(NBT nbt, ClientVersion version, @Nullable TypesBuilderData data);

        default NbtEntryDecoder<T> upgrade() {
            return (nbt, wrapper, data) ->
                    this.decode(nbt, wrapper.getServerVersion().toClientVersion(), data);
        }
    }

    @ApiStatus.Internal
    @FunctionalInterface
    public interface NbtEntryDecoder<T> {

        T decode(NBT nbt, PacketWrapper<?> version, @Nullable TypesBuilderData data);
    }

    @ApiStatus.Internal
    public static final class RegistryEntry<T extends MappedEntity & CopyableEntity<T> & DeepComparableEntity> {

        private final IRegistry<T> baseRegistry;
        private final NbtEntryDecoder<T> decoder;

        // each registry may have a synchronized registry cache, for convenience and enhanced performance
        //
        // the key to this cache depends on the platform - it may be a constant value for bukkit servers
        // or some backend server related value for proxy servers
        private final Map<Object, SimpleRegistry<T>> syncedRegistries = new ConcurrentHashMap<>(2);

        public RegistryEntry(
                IRegistry<T> baseRegistry,
                LegacyNbtEntryDecoder<T> decoder
        ) {
            this(baseRegistry, decoder.upgrade());
        }

        public RegistryEntry(
                IRegistry<T> baseRegistry,
                NbtEntryDecoder<T> decoder
        ) {
            this.baseRegistry = baseRegistry;
            this.decoder = decoder;
        }

        public @Nullable SimpleRegistry<T> getSyncedRegistry(Object key) {
            return this.syncedRegistries.get(key);
        }

        @SuppressWarnings("unchecked")
        public SimpleRegistry<T> computeSyncedRegistry(Object key, Supplier<SimpleRegistry<?>> registry) {
            return this.syncedRegistries.computeIfAbsent(key,
                    $ -> (SimpleRegistry<T>) registry.get());
        }

        private void handleElement(
                SimpleRegistry<T> registry,
                RegistryElement element,
                int id, PacketWrapper<?> wrapper
        ) {
            ResourceLocation elementName = element.getId();
            T baseEntry = this.baseRegistry.getByName(elementName);

            // save new element definition in base entry for comparison - and fallback
            TypesBuilderData data = new SimpleTypesBuilderData(elementName, id);
            T copiedBaseEntry = baseEntry == null ? null : baseEntry.copy(data);

            if (element.getData() != null) {
                // data was provided, use registry element sent over network
                T value = this.decoder.decode(element.getData(), wrapper, data);
                if (!value.deepEquals(copiedBaseEntry)) {
                    // only define decoded value if it doesn't match the base
                    // registry value this ensures we don't save everything twice,
                    // if it has been already stored in memory
                    registry.define(elementName, id, value);
                    return;
                }
            }

            // fallback to looking up in vanilla registry
            // this isn't a 100% valid solution, but a full solution to this
            // is not possible with Mojang's concept of known packs
            //
            // if packetevents isn't running on a proxy and two backend servers
            // share the same custom datapack, the entries wouldn't be sent as
            // the player would tell the server it already knows about them
            //
            // this will cause issues, especially when some datapack overrides world height
            // of a vanilla dimension - and this can't be fixed (or I missed something)

            if (copiedBaseEntry != null) {
                registry.define(elementName, id, copiedBaseEntry);
                return;
            }

            // can't find this element anywhere
            // TODO dummy values to make at least simple stuff work?
            PacketEvents.getAPI().getLogger().warning("Unknown registry entry "
                    + elementName + " for " + this.getRegistryKey());
        }

        public SimpleRegistry<T> createFromElements(List<RegistryElement> elements, PacketWrapper<?> wrapper) {
            SimpleRegistry<T> registry = new SimpleRegistry<>(this.getRegistryKey());
            for (int id = 0; id < elements.size(); id++) {
                RegistryElement element = elements.get(id);
                this.handleElement(registry, element, id, wrapper);
            }
            return registry;
        }

        public ResourceLocation getRegistryKey() {
            return this.baseRegistry.getRegistryKey();
        }
    }
}
