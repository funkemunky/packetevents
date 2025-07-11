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

package com.github.retrooper.packetevents.protocol.world.states.defaulttags;

import com.github.retrooper.packetevents.protocol.component.ComponentTypes;
import com.github.retrooper.packetevents.protocol.item.type.ItemType;
import com.github.retrooper.packetevents.protocol.item.type.ItemTypes;
import com.github.retrooper.packetevents.protocol.world.states.type.StateType;
import org.jetbrains.annotations.VisibleForTesting;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ItemTags {
    private static final HashMap<String, ItemTags> byName = new HashMap<>();

    public static final ItemTags WOOL = bind("wool");
    public static final ItemTags PLANKS = bind("planks");
    public static final ItemTags STONE_BRICKS = bind("stone_bricks");
    public static final ItemTags WOODEN_BUTTONS = bind("wooden_buttons");
    public static final ItemTags STONE_BUTTONS = bind("stone_buttons");
    public static final ItemTags BUTTONS = bind("buttons");
    public static final ItemTags WOOL_CARPETS = bind("carpets");
    public static final ItemTags WOODEN_DOORS = bind("wooden_doors");
    public static final ItemTags WOODEN_STAIRS = bind("wooden_stairs");
    public static final ItemTags WOODEN_SLABS = bind("wooden_slabs");
    public static final ItemTags WOODEN_FENCES = bind("wooden_fences");
    public static final ItemTags FENCE_GATES = bind("fence_gates");
    public static final ItemTags WOODEN_PRESSURE_PLATES = bind("wooden_pressure_plates");
    public static final ItemTags WOODEN_TRAPDOORS = bind("wooden_trapdoors");
    public static final ItemTags DOORS = bind("doors");
    public static final ItemTags SAPLINGS = bind("saplings");
    public static final ItemTags LOGS_THAT_BURN = bind("logs_that_burn");
    public static final ItemTags LOGS = bind("logs");
    public static final ItemTags DARK_OAK_LOGS = bind("dark_oak_logs");
    public static final ItemTags OAK_LOGS = bind("oak_logs");
    public static final ItemTags BIRCH_LOGS = bind("birch_logs");
    public static final ItemTags ACACIA_LOGS = bind("acacia_logs");
    public static final ItemTags CHERRY_LOGS = bind("cherry_logs");
    public static final ItemTags JUNGLE_LOGS = bind("jungle_logs");
    public static final ItemTags SPRUCE_LOGS = bind("spruce_logs");
    public static final ItemTags MANGROVE_LOGS = bind("mangrove_logs");
    public static final ItemTags CRIMSON_STEMS = bind("crimson_stems");
    public static final ItemTags WARPED_STEMS = bind("warped_stems");
    public static final ItemTags BAMBOO_BLOCKS = bind("bamboo_blocks");
    public static final ItemTags WART_BLOCKS = bind("wart_blocks");
    public static final ItemTags BANNERS = bind("banners");
    public static final ItemTags SAND = bind("sand");
    public static final ItemTags SMELTS_TO_GLASS = bind("smelts_to_glass");
    public static final ItemTags STAIRS = bind("stairs");
    public static final ItemTags SLABS = bind("slabs");
    public static final ItemTags WALLS = bind("walls");
    public static final ItemTags ANVIL = bind("anvil");
    public static final ItemTags RAILS = bind("rails");
    public static final ItemTags LEAVES = bind("leaves");
    public static final ItemTags TRAPDOORS = bind("trapdoors");
    public static final ItemTags SMALL_FLOWERS = bind("small_flowers");
    public static final ItemTags BEDS = bind("beds");
    public static final ItemTags FENCES = bind("fences");
    /**
     * Removed with 1.21.4
     */
    @Deprecated
    public static final ItemTags TALL_FLOWERS = bind("tall_flowers");
    /**
     * Removed with 1.21.4, re-added with 1.21.5
     */
    public static final ItemTags FLOWERS = bind("flowers");
    public static final ItemTags PIGLIN_REPELLENTS = bind("piglin_repellents");
    public static final ItemTags PIGLIN_LOVED = bind("piglin_loved");
    public static final ItemTags IGNORED_BY_PIGLIN_BABIES = bind("ignored_by_piglin_babies");
    public static final ItemTags PIGLIN_FOOD = bind("piglin_food");
    public static final ItemTags FOX_FOOD = bind("fox_food");
    public static final ItemTags GOLD_ORES = bind("gold_ores");
    public static final ItemTags IRON_ORES = bind("iron_ores");
    public static final ItemTags DIAMOND_ORES = bind("diamond_ores");
    public static final ItemTags REDSTONE_ORES = bind("redstone_ores");
    public static final ItemTags LAPIS_ORES = bind("lapis_ores");
    public static final ItemTags COAL_ORES = bind("coal_ores");
    public static final ItemTags EMERALD_ORES = bind("emerald_ores");
    public static final ItemTags COPPER_ORES = bind("copper_ores");
    public static final ItemTags NON_FLAMMABLE_WOOD = bind("non_flammable_wood");
    public static final ItemTags SOUL_FIRE_BASE_BLOCKS = bind("soul_fire_base_blocks");
    public static final ItemTags CANDLES = bind("candles");
    public static final ItemTags DIRT = bind("dirt");
    public static final ItemTags TERRACOTTA = bind("terracotta");
    public static final ItemTags COMPLETES_FIND_TREE_TUTORIAL = bind("completes_find_tree_tutorial");
    public static final ItemTags BOATS = bind("boats");
    public static final ItemTags CHEST_BOATS = bind("chest_boats");
    public static final ItemTags FISHES = bind("fishes");
    public static final ItemTags SIGNS = bind("signs");
    /**
     * @deprecated This tag has been removed in 1.21.2 because of components
     */
    @Deprecated
    public static final ItemTags MUSIC_DISCS = bind("music_discs");
    public static final ItemTags CREEPER_DROP_MUSIC_DISCS = bind("creeper_drop_music_discs");
    public static final ItemTags COALS = bind("coals");
    public static final ItemTags ARROWS = bind("arrows");
    public static final ItemTags LECTERN_BOOKS = bind("lectern_books");
    public static final ItemTags BOOKSHELF_BOOKS = bind("bookshelf_books");
    public static final ItemTags BEACON_PAYMENT_ITEMS = bind("beacon_payment_items");
    public static final ItemTags STONE_TOOL_MATERIALS = bind("stone_tool_materials");
    public static final ItemTags STONE_CRAFTING_MATERIALS = bind("stone_crafting_materials");
    public static final ItemTags FREEZE_IMMUNE_WEARABLES = bind("freeze_immune_wearables");
    public static final ItemTags DAMPENS_VIBRATIONS = bind("dampens_vibrations");
    public static final ItemTags CLUSTER_MAX_HARVESTABLES = bind("cluster_max_harvestables");
    public static final ItemTags COMPASSES = bind("compasses");
    public static final ItemTags HANGING_SIGNS = bind("hanging_signs");
    public static final ItemTags CREEPER_IGNITERS = bind("creeper_igniters");
    public static final ItemTags NOTEBLOCK_TOP_INSTRUMENTS = bind("noteblock_top_instruments");
    public static final ItemTags TRIMMABLE_ARMOR = bind("trimmable_armor");
    public static final ItemTags TRIM_MATERIALS = bind("trim_materials");
    /**
     * Removed with 1.21.4
     */
    @Deprecated
    public static final ItemTags TRIM_TEMPLATES = bind("trim_templates");
    public static final ItemTags SNIFFER_FOOD = bind("sniffer_food");
    public static final ItemTags DECORATED_POT_SHERDS = bind("decorated_pot_sherds");
    public static final ItemTags DECORATED_POT_INGREDIENTS = bind("decorated_pot_ingredients");
    public static final ItemTags SWORDS = bind("swords");
    public static final ItemTags AXES = bind("axes");
    public static final ItemTags HOES = bind("hoes");
    public static final ItemTags PICKAXES = bind("pickaxes");
    public static final ItemTags SHOVELS = bind("shovels");
    public static final ItemTags BREAKS_DECORATED_POTS = bind("breaks_decorated_pots");
    /**
     * Removed in 1.20.5 as "duplicate"
     */
    @Deprecated
    public static final ItemTags TOOLS = BREAKS_DECORATED_POTS;
    public static final ItemTags VILLAGER_PLANTABLE_SEEDS = bind("villager_plantable_seeds");

    /**
     * Added with 1.20.5
     */
    public static final ItemTags ARMADILLO_FOOD = bind("armadillo_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags AXOLOTL_FOOD = bind("axolotl_food");
    /**
     * Renamed to {@link #AXOLOTL_FOOD} in 1.20.5
     */
    @Deprecated
    public static final ItemTags AXOLOTL_TEMPT_ITEMS = AXOLOTL_FOOD;
    /**
     * Added with 1.20.5
     */
    public static final ItemTags BEE_FOOD = bind("bee_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags CAMEL_FOOD = bind("camel_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags CAT_FOOD = bind("cat_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags CHEST_ARMOR = bind("chest_armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags CHICKEN_FOOD = bind("chicken_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags COW_FOOD = bind("cow_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags DYEABLE = bind("dyeable");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_ARMOR = bind("enchantable/armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_BOW = bind("enchantable/bow");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_CHEST_ARMOR = bind("enchantable/chest_armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_CROSSBOW = bind("enchantable/crossbow");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_DURABILITY = bind("enchantable/durability");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_EQUIPPABLE = bind("enchantable/equippable");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_FIRE_ASPECT = bind("enchantable/fire_aspect");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_FISHING = bind("enchantable/fishing");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_FOOT_ARMOR = bind("enchantable/foot_armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_HEAD_ARMOR = bind("enchantable/head_armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_LEG_ARMOR = bind("enchantable/leg_armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_MACE = bind("enchantable/mace");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_MINING = bind("enchantable/mining");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_MINING_LOOT = bind("enchantable/mining_loot");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_SHARP_WEAPON = bind("enchantable/sharp_weapon");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_SWORD = bind("enchantable/sword");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_TRIDENT = bind("enchantable/trident");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_VANISHING = bind("enchantable/vanishing");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags ENCHANTABLE_WEAPON = bind("enchantable/weapon");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags FOOT_ARMOR = bind("foot_armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags FROG_FOOD = bind("frog_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags GOAT_FOOD = bind("goat_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags HEAD_ARMOR = bind("head_armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags HOGLIN_FOOD = bind("hoglin_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags HORSE_FOOD = bind("horse_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags HORSE_TEMPT_ITEMS = bind("horse_tempt_items");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags LEG_ARMOR = bind("leg_armor");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags LLAMA_FOOD = bind("llama_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags LLAMA_TEMPT_ITEMS = bind("llama_tempt_items");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags MEAT = bind("meat");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags OCELOT_FOOD = bind("ocelot_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags PANDA_FOOD = bind("panda_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags PARROT_FOOD = bind("parrot_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags PARROT_POISONOUS_FOOD = bind("parrot_poisonous_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags PIG_FOOD = bind("pig_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags RABBIT_FOOD = bind("rabbit_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags SHEEP_FOOD = bind("sheep_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags SKULLS = bind("skulls");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags STRIDER_FOOD = bind("strider_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags STRIDER_TEMPT_ITEMS = bind("strider_tempt_items");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags TURTLE_FOOD = bind("turtle_food");
    /**
     * Added with 1.20.5
     */
    public static final ItemTags WOLF_FOOD = bind("wolf_food");

    /**
     * Added with 1.21.2
     */
    public static final ItemTags PALE_OAK_LOGS = bind("pale_oak_logs");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags PIGLIN_SAFE_ARMOR = bind("piglin_safe_armor");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags DUPLICATES_ALLAYS = bind("duplicates_allays");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags BREWING_FUEL = bind("brewing_fuel");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags SHULKER_BOXES = bind("shulker_boxes");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags IRON_TOOL_MATERIALS = bind("iron_tool_materials");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags GOLD_TOOL_MATERIALS = bind("gold_tool_materials");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags DIAMOND_TOOL_MATERIALS = bind("diamond_tool_materials");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags NETHERITE_TOOL_MATERIALS = bind("netherite_tool_materials");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags REPAIRS_LEATHER_ARMOR = bind("repairs_leather_armor");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags REPAIRS_CHAIN_ARMOR = bind("repairs_chain_armor");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags REPAIRS_IRON_ARMOR = bind("repairs_iron_armor");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags REPAIRS_GOLD_ARMOR = bind("repairs_gold_armor");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags REPAIRS_DIAMOND_ARMOR = bind("repairs_diamond_armor");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags REPAIRS_NETHERITE_ARMOR = bind("repairs_netherite_armor");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags REPAIRS_TURTLE_HELMET = bind("repairs_turtle_helmet");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags REPAIRS_WOLF_ARMOR = bind("repairs_wolf_armor");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags FURNACE_MINECART_FUEL = bind("furnace_minecart_fuel");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags BUNDLES = bind("bundles");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags MAP_INVISIBILITY_EQUIPMENT = bind("map_invisibility_equipment");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags GAZE_DISGUISE_EQUIPMENT = bind("gaze_disguise_equipment");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags PANDA_EATS_FROM_GROUND = bind("panda_eats_from_ground");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags WOODEN_TOOL_MATERIALS = bind("wooden_tool_materials");
    /**
     * Added with 1.21.2
     */
    public static final ItemTags VILLAGER_PICKS_UP = bind("villager_picks_up");

    /**
     * Added with 1.21.4
     */
    public static final ItemTags SKELETON_PREFERRED_WEAPONS = bind("skeleton_preferred_weapons");
    /**
     * Added with 1.21.4
     */
    public static final ItemTags DROWNED_PREFERRED_WEAPONS = bind("drowned_preferred_weapons");
    /**
     * Added with 1.21.4
     */
    public static final ItemTags PIGLIN_PREFERRED_WEAPONS = bind("piglin_preferred_weapons");
    /**
     * Added with 1.21.4
     */
    public static final ItemTags PILLAGER_PREFERRED_WEAPONS = bind("pillager_preferred_weapons");
    /**
     * Added with 1.21.4
     */
    public static final ItemTags WITHER_SKELETON_DISLIKED_WEAPONS = bind("wither_skeleton_disliked_weapons");

    /**
     * Added with 1.21.5
     */
    public static final ItemTags EGGS = bind("eggs");
    /**
     * Added with 1.21.5
     */
    public static final ItemTags BOOK_CLONING_TARGET = bind("book_cloning_target");

    /**
     * Added with 1.21.6
     */
    public static final ItemTags HARNESSES = bind("harnesses");
    /**
     * Added with 1.21.6
     */
    public static final ItemTags HAPPY_GHAST_FOOD = bind("happy_ghast_food");
    /**
     * Added with 1.21.6
     */
    public static final ItemTags HAPPY_GHAST_TEMPT_ITEMS = bind("happy_ghast_tempt_items");

    static {
        copy(BlockTags.WOOL, ItemTags.WOOL);
        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.STONE_BRICKS, ItemTags.STONE_BRICKS);
        copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        copy(BlockTags.STONE_BUTTONS, ItemTags.STONE_BUTTONS);
        copy(BlockTags.WOOL_CARPETS, ItemTags.WOOL_CARPETS);
        copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
        copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        copy(BlockTags.BAMBOO_BLOCKS, ItemTags.BAMBOO_BLOCKS);
        copy(BlockTags.OAK_LOGS, ItemTags.OAK_LOGS);
        copy(BlockTags.DARK_OAK_LOGS, ItemTags.DARK_OAK_LOGS);
        copy(BlockTags.PALE_OAK_LOGS, ItemTags.PALE_OAK_LOGS);
        copy(BlockTags.BIRCH_LOGS, ItemTags.BIRCH_LOGS);
        copy(BlockTags.ACACIA_LOGS, ItemTags.ACACIA_LOGS);
        copy(BlockTags.SPRUCE_LOGS, ItemTags.SPRUCE_LOGS);
        copy(BlockTags.MANGROVE_LOGS, ItemTags.MANGROVE_LOGS);
        copy(BlockTags.JUNGLE_LOGS, ItemTags.JUNGLE_LOGS);
        copy(BlockTags.CHERRY_LOGS, ItemTags.CHERRY_LOGS);
        copy(BlockTags.CRIMSON_STEMS, ItemTags.CRIMSON_STEMS);
        copy(BlockTags.WARPED_STEMS, ItemTags.WARPED_STEMS);
        copy(BlockTags.WART_BLOCKS, ItemTags.WART_BLOCKS);
        copy(BlockTags.SAND, ItemTags.SAND);
        copy(BlockTags.SMELTS_TO_GLASS, ItemTags.SMELTS_TO_GLASS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.ANVIL, ItemTags.ANVIL);
        copy(BlockTags.RAILS, ItemTags.RAILS);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        copy(BlockTags.BEDS, ItemTags.BEDS);
        copy(BlockTags.SOUL_FIRE_BASE_BLOCKS, ItemTags.SOUL_FIRE_BASE_BLOCKS);
        copy(BlockTags.CANDLES, ItemTags.CANDLES);
        copy(BlockTags.GOLD_ORES, ItemTags.GOLD_ORES);
        copy(BlockTags.IRON_ORES, ItemTags.IRON_ORES);
        copy(BlockTags.DIAMOND_ORES, ItemTags.DIAMOND_ORES);
        copy(BlockTags.REDSTONE_ORES, ItemTags.REDSTONE_ORES);
        copy(BlockTags.LAPIS_ORES, ItemTags.LAPIS_ORES);
        copy(BlockTags.COAL_ORES, ItemTags.COAL_ORES);
        copy(BlockTags.EMERALD_ORES, ItemTags.EMERALD_ORES);
        copy(BlockTags.COPPER_ORES, ItemTags.COPPER_ORES);
        copy(BlockTags.DIRT, ItemTags.DIRT);
        copy(BlockTags.TERRACOTTA, ItemTags.TERRACOTTA);
        copy(BlockTags.SHULKER_BOXES, ItemTags.SHULKER_BOXES);
        copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);
        copy(BlockTags.BEE_ATTRACTIVE, ItemTags.BEE_FOOD);
        ItemTags.BANNERS.add(ItemTypes.WHITE_BANNER, ItemTypes.ORANGE_BANNER, ItemTypes.MAGENTA_BANNER, ItemTypes.LIGHT_BLUE_BANNER, ItemTypes.YELLOW_BANNER, ItemTypes.LIME_BANNER, ItemTypes.PINK_BANNER, ItemTypes.GRAY_BANNER, ItemTypes.LIGHT_GRAY_BANNER, ItemTypes.CYAN_BANNER, ItemTypes.PURPLE_BANNER, ItemTypes.BLUE_BANNER, ItemTypes.BROWN_BANNER, ItemTypes.GREEN_BANNER, ItemTypes.RED_BANNER, ItemTypes.BLACK_BANNER);
        ItemTags.PIGLIN_REPELLENTS.add(ItemTypes.SOUL_TORCH, ItemTypes.SOUL_LANTERN, ItemTypes.SOUL_CAMPFIRE);
        ItemTags.IGNORED_BY_PIGLIN_BABIES.add(ItemTypes.LEATHER);
        ItemTags.PIGLIN_SAFE_ARMOR.add(ItemTypes.GOLDEN_HELMET, ItemTypes.GOLDEN_CHESTPLATE, ItemTypes.GOLDEN_LEGGINGS, ItemTypes.GOLDEN_BOOTS);
        ItemTags.DUPLICATES_ALLAYS.add(ItemTypes.AMETHYST_SHARD);
        ItemTags.BREWING_FUEL.add(ItemTypes.BLAZE_POWDER);
        ItemTags.EGGS.add(ItemTypes.EGG, ItemTypes.BLUE_EGG, ItemTypes.BROWN_EGG);
        ItemTags.MEAT.add(ItemTypes.BEEF, ItemTypes.CHICKEN, ItemTypes.COOKED_BEEF, ItemTypes.COOKED_CHICKEN, ItemTypes.COOKED_MUTTON, ItemTypes.COOKED_PORKCHOP, ItemTypes.COOKED_RABBIT, ItemTypes.MUTTON, ItemTypes.PORKCHOP, ItemTypes.RABBIT, ItemTypes.ROTTEN_FLESH);
        ItemTags.SNIFFER_FOOD.add(ItemTypes.TORCHFLOWER_SEEDS);
        ItemTags.PIGLIN_FOOD.add(ItemTypes.PORKCHOP, ItemTypes.COOKED_PORKCHOP);
        ItemTags.FOX_FOOD.add(ItemTypes.SWEET_BERRIES, ItemTypes.GLOW_BERRIES);
        ItemTags.COW_FOOD.add(ItemTypes.WHEAT);
        copy(ItemTags.COW_FOOD, ItemTags.GOAT_FOOD);
        copy(ItemTags.COW_FOOD, ItemTags.SHEEP_FOOD);
        ItemTags.CAT_FOOD.add(ItemTypes.COD, ItemTypes.SALMON);
        ItemTags.HORSE_FOOD.add(ItemTypes.WHEAT, ItemTypes.SUGAR, ItemTypes.HAY_BLOCK, ItemTypes.APPLE, ItemTypes.CARROT, ItemTypes.GOLDEN_CARROT, ItemTypes.GOLDEN_APPLE, ItemTypes.ENCHANTED_GOLDEN_APPLE);
        ItemTags.HORSE_TEMPT_ITEMS.add(ItemTypes.GOLDEN_CARROT, ItemTypes.GOLDEN_APPLE, ItemTypes.ENCHANTED_GOLDEN_APPLE);
        ItemTags.HARNESSES.add(ItemTypes.WHITE_HARNESS, ItemTypes.ORANGE_HARNESS, ItemTypes.MAGENTA_HARNESS, ItemTypes.LIGHT_BLUE_HARNESS, ItemTypes.YELLOW_HARNESS, ItemTypes.LIME_HARNESS, ItemTypes.PINK_HARNESS, ItemTypes.GRAY_HARNESS, ItemTypes.LIGHT_GRAY_HARNESS, ItemTypes.CYAN_HARNESS, ItemTypes.PURPLE_HARNESS, ItemTypes.BLUE_HARNESS, ItemTypes.BROWN_HARNESS, ItemTypes.GREEN_HARNESS, ItemTypes.RED_HARNESS, ItemTypes.BLACK_HARNESS);
        ItemTags.HAPPY_GHAST_FOOD.add(ItemTypes.SNOWBALL);
        ItemTags.CAMEL_FOOD.add(ItemTypes.CACTUS);
        ItemTags.ARMADILLO_FOOD.add(ItemTypes.SPIDER_EYE);
        ItemTags.CHICKEN_FOOD.add(ItemTypes.WHEAT_SEEDS, ItemTypes.MELON_SEEDS, ItemTypes.PUMPKIN_SEEDS, ItemTypes.BEETROOT_SEEDS, ItemTypes.TORCHFLOWER_SEEDS, ItemTypes.PITCHER_POD);
        ItemTags.FROG_FOOD.add(ItemTypes.SLIME_BALL);
        ItemTags.HOGLIN_FOOD.add(ItemTypes.CRIMSON_FUNGUS);
        ItemTags.LLAMA_FOOD.add(ItemTypes.WHEAT, ItemTypes.HAY_BLOCK);
        ItemTags.LLAMA_TEMPT_ITEMS.add(ItemTypes.HAY_BLOCK);
        copy(ItemTags.CAT_FOOD, ItemTags.OCELOT_FOOD);
        ItemTags.PANDA_FOOD.add(ItemTypes.BAMBOO);
        ItemTags.PIG_FOOD.add(ItemTypes.CARROT, ItemTypes.POTATO, ItemTypes.BEETROOT);
        ItemTags.RABBIT_FOOD.add(ItemTypes.CARROT, ItemTypes.GOLDEN_CARROT, ItemTypes.DANDELION);
        ItemTags.STRIDER_FOOD.add(ItemTypes.WARPED_FUNGUS);
        ItemTags.TURTLE_FOOD.add(ItemTypes.SEAGRASS);
        copy(ItemTags.CHICKEN_FOOD, ItemTags.PARROT_FOOD);
        ItemTags.PARROT_POISONOUS_FOOD.add(ItemTypes.COOKIE);
        ItemTags.AXOLOTL_FOOD.add(ItemTypes.TROPICAL_FISH_BUCKET);
        ItemTags.NON_FLAMMABLE_WOOD.add(ItemTypes.WARPED_STEM, ItemTypes.STRIPPED_WARPED_STEM, ItemTypes.WARPED_HYPHAE, ItemTypes.STRIPPED_WARPED_HYPHAE, ItemTypes.CRIMSON_STEM, ItemTypes.STRIPPED_CRIMSON_STEM, ItemTypes.CRIMSON_HYPHAE, ItemTypes.STRIPPED_CRIMSON_HYPHAE, ItemTypes.CRIMSON_PLANKS, ItemTypes.WARPED_PLANKS, ItemTypes.CRIMSON_SLAB, ItemTypes.WARPED_SLAB, ItemTypes.CRIMSON_PRESSURE_PLATE, ItemTypes.WARPED_PRESSURE_PLATE, ItemTypes.CRIMSON_FENCE, ItemTypes.WARPED_FENCE, ItemTypes.CRIMSON_TRAPDOOR, ItemTypes.WARPED_TRAPDOOR, ItemTypes.CRIMSON_FENCE_GATE, ItemTypes.WARPED_FENCE_GATE, ItemTypes.CRIMSON_STAIRS, ItemTypes.WARPED_STAIRS, ItemTypes.CRIMSON_BUTTON, ItemTypes.WARPED_BUTTON, ItemTypes.CRIMSON_DOOR, ItemTypes.WARPED_DOOR, ItemTypes.CRIMSON_SIGN, ItemTypes.WARPED_SIGN, ItemTypes.WARPED_HANGING_SIGN, ItemTypes.CRIMSON_HANGING_SIGN);
        ItemTags.CHEST_BOATS.add(ItemTypes.OAK_CHEST_BOAT, ItemTypes.SPRUCE_CHEST_BOAT, ItemTypes.BIRCH_CHEST_BOAT, ItemTypes.JUNGLE_CHEST_BOAT, ItemTypes.ACACIA_CHEST_BOAT, ItemTypes.DARK_OAK_CHEST_BOAT, ItemTypes.PALE_OAK_CHEST_BOAT, ItemTypes.MANGROVE_CHEST_BOAT, ItemTypes.BAMBOO_CHEST_RAFT, ItemTypes.CHERRY_CHEST_BOAT);
        ItemTags.FISHES.add(ItemTypes.COD, ItemTypes.COOKED_COD, ItemTypes.SALMON, ItemTypes.COOKED_SALMON, ItemTypes.PUFFERFISH, ItemTypes.TROPICAL_FISH);
        ItemTags.CREEPER_DROP_MUSIC_DISCS.add(ItemTypes.MUSIC_DISC_13, ItemTypes.MUSIC_DISC_CAT, ItemTypes.MUSIC_DISC_BLOCKS, ItemTypes.MUSIC_DISC_CHIRP, ItemTypes.MUSIC_DISC_FAR, ItemTypes.MUSIC_DISC_MALL, ItemTypes.MUSIC_DISC_MELLOHI, ItemTypes.MUSIC_DISC_STAL, ItemTypes.MUSIC_DISC_STRAD, ItemTypes.MUSIC_DISC_WARD, ItemTypes.MUSIC_DISC_11, ItemTypes.MUSIC_DISC_WAIT);
        ItemTags.COALS.add(ItemTypes.COAL, ItemTypes.CHARCOAL);
        ItemTags.ARROWS.add(ItemTypes.ARROW, ItemTypes.TIPPED_ARROW, ItemTypes.SPECTRAL_ARROW);
        ItemTags.LECTERN_BOOKS.add(ItemTypes.WRITTEN_BOOK, ItemTypes.WRITABLE_BOOK);
        ItemTags.BOOKSHELF_BOOKS.add(ItemTypes.BOOK, ItemTypes.WRITTEN_BOOK, ItemTypes.ENCHANTED_BOOK, ItemTypes.WRITABLE_BOOK, ItemTypes.KNOWLEDGE_BOOK);
        ItemTags.BEACON_PAYMENT_ITEMS.add(ItemTypes.NETHERITE_INGOT, ItemTypes.EMERALD, ItemTypes.DIAMOND, ItemTypes.GOLD_INGOT, ItemTypes.IRON_INGOT);
        ItemTags.STONE_TOOL_MATERIALS.add(ItemTypes.COBBLESTONE, ItemTypes.BLACKSTONE, ItemTypes.COBBLED_DEEPSLATE);
        ItemTags.IRON_TOOL_MATERIALS.add(ItemTypes.IRON_INGOT);
        ItemTags.GOLD_TOOL_MATERIALS.add(ItemTypes.GOLD_INGOT);
        ItemTags.DIAMOND_TOOL_MATERIALS.add(ItemTypes.DIAMOND);
        ItemTags.NETHERITE_TOOL_MATERIALS.add(ItemTypes.NETHERITE_INGOT);
        copy(ItemTags.IGNORED_BY_PIGLIN_BABIES, ItemTags.REPAIRS_LEATHER_ARMOR);
        copy(ItemTags.IRON_TOOL_MATERIALS, ItemTags.REPAIRS_CHAIN_ARMOR);
        copy(ItemTags.IRON_TOOL_MATERIALS, ItemTags.REPAIRS_IRON_ARMOR);
        copy(ItemTags.GOLD_TOOL_MATERIALS, ItemTags.REPAIRS_GOLD_ARMOR);
        copy(ItemTags.DIAMOND_TOOL_MATERIALS, ItemTags.REPAIRS_DIAMOND_ARMOR);
        copy(ItemTags.NETHERITE_TOOL_MATERIALS, ItemTags.REPAIRS_NETHERITE_ARMOR);
        ItemTags.REPAIRS_TURTLE_HELMET.add(ItemTypes.TURTLE_SCUTE);
        ItemTags.REPAIRS_WOLF_ARMOR.add(ItemTypes.ARMADILLO_SCUTE);
        copy(ItemTags.STONE_TOOL_MATERIALS, ItemTags.STONE_CRAFTING_MATERIALS);
        ItemTags.FREEZE_IMMUNE_WEARABLES.add(ItemTypes.LEATHER_BOOTS, ItemTypes.LEATHER_LEGGINGS, ItemTypes.LEATHER_CHESTPLATE, ItemTypes.LEATHER_HELMET, ItemTypes.LEATHER_HORSE_ARMOR);
        ItemTags.CLUSTER_MAX_HARVESTABLES.add(ItemTypes.DIAMOND_PICKAXE, ItemTypes.GOLDEN_PICKAXE, ItemTypes.IRON_PICKAXE, ItemTypes.NETHERITE_PICKAXE, ItemTypes.STONE_PICKAXE, ItemTypes.WOODEN_PICKAXE);
        ItemTags.COMPASSES.add(ItemTypes.COMPASS, ItemTypes.RECOVERY_COMPASS);
        ItemTags.CREEPER_IGNITERS.add(ItemTypes.FLINT_AND_STEEL, ItemTypes.FIRE_CHARGE);
        ItemTags.NOTEBLOCK_TOP_INSTRUMENTS.add(ItemTypes.ZOMBIE_HEAD, ItemTypes.SKELETON_SKULL, ItemTypes.CREEPER_HEAD, ItemTypes.DRAGON_HEAD, ItemTypes.WITHER_SKELETON_SKULL, ItemTypes.PIGLIN_HEAD, ItemTypes.PLAYER_HEAD);
        ItemTags.FOOT_ARMOR.add(ItemTypes.LEATHER_BOOTS, ItemTypes.CHAINMAIL_BOOTS, ItemTypes.GOLDEN_BOOTS, ItemTypes.IRON_BOOTS, ItemTypes.DIAMOND_BOOTS, ItemTypes.NETHERITE_BOOTS);
        ItemTags.LEG_ARMOR.add(ItemTypes.LEATHER_LEGGINGS, ItemTypes.CHAINMAIL_LEGGINGS, ItemTypes.GOLDEN_LEGGINGS, ItemTypes.IRON_LEGGINGS, ItemTypes.DIAMOND_LEGGINGS, ItemTypes.NETHERITE_LEGGINGS);
        ItemTags.CHEST_ARMOR.add(ItemTypes.LEATHER_CHESTPLATE, ItemTypes.CHAINMAIL_CHESTPLATE, ItemTypes.GOLDEN_CHESTPLATE, ItemTypes.IRON_CHESTPLATE, ItemTypes.DIAMOND_CHESTPLATE, ItemTypes.NETHERITE_CHESTPLATE);
        ItemTags.HEAD_ARMOR.add(ItemTypes.LEATHER_HELMET, ItemTypes.CHAINMAIL_HELMET, ItemTypes.GOLDEN_HELMET, ItemTypes.IRON_HELMET, ItemTypes.DIAMOND_HELMET, ItemTypes.NETHERITE_HELMET, ItemTypes.TURTLE_HELMET);
        ItemTags.SKULLS.add(ItemTypes.PLAYER_HEAD, ItemTypes.CREEPER_HEAD, ItemTypes.ZOMBIE_HEAD, ItemTypes.SKELETON_SKULL, ItemTypes.WITHER_SKELETON_SKULL, ItemTypes.DRAGON_HEAD, ItemTypes.PIGLIN_HEAD);
        ItemTags.TRIM_MATERIALS.add(ItemTypes.AMETHYST_SHARD, ItemTypes.COPPER_INGOT, ItemTypes.DIAMOND, ItemTypes.EMERALD, ItemTypes.GOLD_INGOT, ItemTypes.IRON_INGOT, ItemTypes.LAPIS_LAZULI, ItemTypes.NETHERITE_INGOT, ItemTypes.QUARTZ, ItemTypes.REDSTONE, ItemTypes.RESIN_BRICK);
        ItemTags.DECORATED_POT_SHERDS.add(ItemTypes.ANGLER_POTTERY_SHERD, ItemTypes.ARCHER_POTTERY_SHERD, ItemTypes.ARMS_UP_POTTERY_SHERD, ItemTypes.BLADE_POTTERY_SHERD, ItemTypes.BREWER_POTTERY_SHERD, ItemTypes.BURN_POTTERY_SHERD, ItemTypes.DANGER_POTTERY_SHERD, ItemTypes.EXPLORER_POTTERY_SHERD, ItemTypes.FRIEND_POTTERY_SHERD, ItemTypes.HEART_POTTERY_SHERD, ItemTypes.HEARTBREAK_POTTERY_SHERD, ItemTypes.HOWL_POTTERY_SHERD, ItemTypes.MINER_POTTERY_SHERD, ItemTypes.MOURNER_POTTERY_SHERD, ItemTypes.PLENTY_POTTERY_SHERD, ItemTypes.PRIZE_POTTERY_SHERD, ItemTypes.SHEAF_POTTERY_SHERD, ItemTypes.SHELTER_POTTERY_SHERD, ItemTypes.SKULL_POTTERY_SHERD, ItemTypes.SNORT_POTTERY_SHERD, ItemTypes.FLOW_POTTERY_SHERD, ItemTypes.GUSTER_POTTERY_SHERD, ItemTypes.SCRAPE_POTTERY_SHERD);
        ItemTags.SWORDS.add(ItemTypes.DIAMOND_SWORD, ItemTypes.STONE_SWORD, ItemTypes.GOLDEN_SWORD, ItemTypes.NETHERITE_SWORD, ItemTypes.WOODEN_SWORD, ItemTypes.IRON_SWORD);
        ItemTags.AXES.add(ItemTypes.DIAMOND_AXE, ItemTypes.STONE_AXE, ItemTypes.GOLDEN_AXE, ItemTypes.NETHERITE_AXE, ItemTypes.WOODEN_AXE, ItemTypes.IRON_AXE);
        ItemTags.HOES.add(ItemTypes.DIAMOND_HOE, ItemTypes.STONE_HOE, ItemTypes.GOLDEN_HOE, ItemTypes.NETHERITE_HOE, ItemTypes.WOODEN_HOE, ItemTypes.IRON_HOE);
        ItemTags.PICKAXES.add(ItemTypes.DIAMOND_PICKAXE, ItemTypes.STONE_PICKAXE, ItemTypes.GOLDEN_PICKAXE, ItemTypes.NETHERITE_PICKAXE, ItemTypes.WOODEN_PICKAXE, ItemTypes.IRON_PICKAXE);
        ItemTags.SHOVELS.add(ItemTypes.DIAMOND_SHOVEL, ItemTypes.STONE_SHOVEL, ItemTypes.GOLDEN_SHOVEL, ItemTypes.NETHERITE_SHOVEL, ItemTypes.WOODEN_SHOVEL, ItemTypes.IRON_SHOVEL);
        ItemTags.VILLAGER_PLANTABLE_SEEDS.add(ItemTypes.WHEAT_SEEDS, ItemTypes.POTATO, ItemTypes.CARROT, ItemTypes.BEETROOT_SEEDS, ItemTypes.TORCHFLOWER_SEEDS, ItemTypes.PITCHER_POD);
        ItemTags.DYEABLE.add(ItemTypes.LEATHER_HELMET, ItemTypes.LEATHER_CHESTPLATE, ItemTypes.LEATHER_LEGGINGS, ItemTypes.LEATHER_BOOTS, ItemTypes.LEATHER_HORSE_ARMOR, ItemTypes.WOLF_ARMOR);
        copy(ItemTags.COALS, ItemTags.FURNACE_MINECART_FUEL);
        ItemTags.BUNDLES.add(ItemTypes.BUNDLE, ItemTypes.BLACK_BUNDLE, ItemTypes.BLUE_BUNDLE, ItemTypes.BROWN_BUNDLE, ItemTypes.CYAN_BUNDLE, ItemTypes.GRAY_BUNDLE, ItemTypes.GREEN_BUNDLE, ItemTypes.LIGHT_BLUE_BUNDLE, ItemTypes.LIGHT_GRAY_BUNDLE, ItemTypes.LIME_BUNDLE, ItemTypes.MAGENTA_BUNDLE, ItemTypes.ORANGE_BUNDLE, ItemTypes.PINK_BUNDLE, ItemTypes.PURPLE_BUNDLE, ItemTypes.RED_BUNDLE, ItemTypes.YELLOW_BUNDLE, ItemTypes.WHITE_BUNDLE);
        ItemTags.BOOK_CLONING_TARGET.add(ItemTypes.WRITABLE_BOOK);
        ItemTags.SKELETON_PREFERRED_WEAPONS.add(ItemTypes.BOW);
        ItemTags.DROWNED_PREFERRED_WEAPONS.add(ItemTypes.TRIDENT);
        ItemTags.PIGLIN_PREFERRED_WEAPONS.add(ItemTypes.CROSSBOW);
        copy(ItemTags.PIGLIN_PREFERRED_WEAPONS, ItemTags.PILLAGER_PREFERRED_WEAPONS);
        ItemTags.WITHER_SKELETON_DISLIKED_WEAPONS.add(ItemTypes.BOW, ItemTypes.CROSSBOW);
        ItemTags.ENCHANTABLE_FISHING.add(ItemTypes.FISHING_ROD);
        copy(ItemTags.DROWNED_PREFERRED_WEAPONS, ItemTags.ENCHANTABLE_TRIDENT);
        copy(ItemTags.SKELETON_PREFERRED_WEAPONS, ItemTags.ENCHANTABLE_BOW);
        copy(ItemTags.PIGLIN_PREFERRED_WEAPONS, ItemTags.ENCHANTABLE_CROSSBOW);
        ItemTags.ENCHANTABLE_MACE.add(ItemTypes.MACE);
        ItemTags.MAP_INVISIBILITY_EQUIPMENT.add(ItemTypes.CARVED_PUMPKIN);
        copy(ItemTags.MAP_INVISIBILITY_EQUIPMENT, ItemTags.GAZE_DISGUISE_EQUIPMENT);
        copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
        copy(BlockTags.DOORS, ItemTags.DOORS);
        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.TRAPDOORS, ItemTags.TRAPDOORS);
        copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
        copy(BlockTags.FENCES, ItemTags.FENCES);
        copy(BlockTags.DAMPENS_VIBRATIONS, ItemTags.DAMPENS_VIBRATIONS);
        ItemTags.PIGLIN_LOVED.addTag(ItemTags.GOLD_ORES).add(ItemTypes.GOLD_BLOCK, ItemTypes.GILDED_BLACKSTONE, ItemTypes.LIGHT_WEIGHTED_PRESSURE_PLATE, ItemTypes.GOLD_INGOT, ItemTypes.BELL, ItemTypes.CLOCK, ItemTypes.GOLDEN_CARROT, ItemTypes.GLISTERING_MELON_SLICE, ItemTypes.GOLDEN_APPLE, ItemTypes.ENCHANTED_GOLDEN_APPLE, ItemTypes.GOLDEN_HELMET, ItemTypes.GOLDEN_CHESTPLATE, ItemTypes.GOLDEN_LEGGINGS, ItemTypes.GOLDEN_BOOTS, ItemTypes.GOLDEN_HORSE_ARMOR, ItemTypes.GOLDEN_SWORD, ItemTypes.GOLDEN_PICKAXE, ItemTypes.GOLDEN_SHOVEL, ItemTypes.GOLDEN_AXE, ItemTypes.GOLDEN_HOE, ItemTypes.RAW_GOLD, ItemTypes.RAW_GOLD_BLOCK);
        ItemTags.WOLF_FOOD.addTag(ItemTags.MEAT).add(ItemTypes.COD, ItemTypes.COOKED_COD, ItemTypes.SALMON, ItemTypes.COOKED_SALMON, ItemTypes.TROPICAL_FISH, ItemTypes.PUFFERFISH, ItemTypes.RABBIT_STEW);
        ItemTags.HAPPY_GHAST_TEMPT_ITEMS.addTag(ItemTags.HAPPY_GHAST_FOOD).addTag(ItemTags.HARNESSES);
        ItemTags.PANDA_EATS_FROM_GROUND.addTag(ItemTags.PANDA_FOOD).add(ItemTypes.CAKE);
        ItemTags.STRIDER_TEMPT_ITEMS.addTag(ItemTags.STRIDER_FOOD).add(ItemTypes.WARPED_FUNGUS_ON_A_STICK);
        ItemTags.BOATS.addTag(ItemTags.CHEST_BOATS).add(ItemTypes.OAK_BOAT, ItemTypes.SPRUCE_BOAT, ItemTypes.BIRCH_BOAT, ItemTypes.JUNGLE_BOAT, ItemTypes.ACACIA_BOAT, ItemTypes.DARK_OAK_BOAT, ItemTypes.PALE_OAK_BOAT, ItemTypes.MANGROVE_BOAT, ItemTypes.BAMBOO_RAFT, ItemTypes.CHERRY_BOAT);
        ItemTags.WOODEN_TOOL_MATERIALS.addTag(ItemTags.PLANKS);
        ItemTags.TRIMMABLE_ARMOR.addTag(ItemTags.FOOT_ARMOR).addTag(ItemTags.LEG_ARMOR).addTag(ItemTags.CHEST_ARMOR).addTag(ItemTags.HEAD_ARMOR);
        ItemTags.DECORATED_POT_INGREDIENTS.addTag(ItemTags.DECORATED_POT_SHERDS).add(ItemTypes.BRICK);
        ItemTags.BREAKS_DECORATED_POTS.addTag(ItemTags.SWORDS).addTag(ItemTags.AXES).addTag(ItemTags.PICKAXES).addTag(ItemTags.SHOVELS).addTag(ItemTags.HOES).add(ItemTypes.TRIDENT, ItemTypes.MACE);
        ItemTags.VILLAGER_PICKS_UP.addTag(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(ItemTypes.BREAD, ItemTypes.WHEAT, ItemTypes.BEETROOT);
        ItemTags.ENCHANTABLE_FOOT_ARMOR.addTag(ItemTags.FOOT_ARMOR);
        ItemTags.ENCHANTABLE_LEG_ARMOR.addTag(ItemTags.LEG_ARMOR);
        ItemTags.ENCHANTABLE_CHEST_ARMOR.addTag(ItemTags.CHEST_ARMOR);
        ItemTags.ENCHANTABLE_HEAD_ARMOR.addTag(ItemTags.HEAD_ARMOR);
        ItemTags.ENCHANTABLE_SWORD.addTag(ItemTags.SWORDS);
        ItemTags.ENCHANTABLE_SHARP_WEAPON.addTag(ItemTags.SWORDS).addTag(ItemTags.AXES);
        ItemTags.ENCHANTABLE_MINING.addTag(ItemTags.AXES).addTag(ItemTags.PICKAXES).addTag(ItemTags.SHOVELS).addTag(ItemTags.HOES).add(ItemTypes.SHEARS);
        ItemTags.ENCHANTABLE_MINING_LOOT.addTag(ItemTags.AXES).addTag(ItemTags.PICKAXES).addTag(ItemTags.SHOVELS).addTag(ItemTags.HOES);
        ItemTags.ENCHANTABLE_DURABILITY.addTag(ItemTags.FOOT_ARMOR).addTag(ItemTags.LEG_ARMOR).addTag(ItemTags.CHEST_ARMOR).addTag(ItemTags.HEAD_ARMOR).addTag(ItemTags.SWORDS).addTag(ItemTags.AXES).addTag(ItemTags.PICKAXES).addTag(ItemTags.SHOVELS).addTag(ItemTags.HOES).add(ItemTypes.ELYTRA, ItemTypes.SHIELD, ItemTypes.BOW, ItemTypes.CROSSBOW, ItemTypes.TRIDENT, ItemTypes.FLINT_AND_STEEL, ItemTypes.SHEARS, ItemTypes.BRUSH, ItemTypes.FISHING_ROD, ItemTypes.CARROT_ON_A_STICK, ItemTypes.WARPED_FUNGUS_ON_A_STICK, ItemTypes.MACE);
        ItemTags.ENCHANTABLE_EQUIPPABLE.addTag(ItemTags.FOOT_ARMOR).addTag(ItemTags.LEG_ARMOR).addTag(ItemTags.CHEST_ARMOR).addTag(ItemTags.HEAD_ARMOR).addTag(ItemTags.SKULLS).add(ItemTypes.ELYTRA, ItemTypes.CARVED_PUMPKIN);
        copy(BlockTags.LOGS, ItemTags.LOGS);
        ItemTags.ENCHANTABLE_ARMOR.addTag(ItemTags.ENCHANTABLE_FOOT_ARMOR).addTag(ItemTags.ENCHANTABLE_LEG_ARMOR).addTag(ItemTags.ENCHANTABLE_CHEST_ARMOR).addTag(ItemTags.ENCHANTABLE_HEAD_ARMOR);
        ItemTags.ENCHANTABLE_FIRE_ASPECT.addTag(ItemTags.ENCHANTABLE_SWORD).add(ItemTypes.MACE);
        ItemTags.ENCHANTABLE_WEAPON.addTag(ItemTags.ENCHANTABLE_SHARP_WEAPON).add(ItemTypes.MACE);
        ItemTags.ENCHANTABLE_VANISHING.addTag(ItemTags.ENCHANTABLE_DURABILITY).addTag(ItemTags.SKULLS).add(ItemTypes.COMPASS, ItemTypes.CARVED_PUMPKIN);
        copy(BlockTags.COMPLETES_FIND_TREE_TUTORIAL, ItemTags.COMPLETES_FIND_TREE_TUTORIAL);

        // deprecated/legacy tags
        for (ItemType type : ItemTypes.getRegistry().getEntries()) {
            if (type.getComponents().has(ComponentTypes.JUKEBOX_PLAYABLE)) {
                ItemTags.MUSIC_DISCS.add(type);
            }
        }
        copy(BlockTags.TALL_FLOWERS, ItemTags.TALL_FLOWERS);
        copy(BlockTags.FLOWERS, ItemTags.FLOWERS);
        ItemTags.TRIM_TEMPLATES.add(ItemTypes.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE, ItemTypes.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE);
    }

    String name;
    Set<ItemType> states = new HashSet<>(); // o(1);
    boolean reallyEmpty;

    public ItemTags(final String name) {
        byName.put(name, this);
        this.name = name;
    }

    private static ItemTags bind(final String s) {
        return new ItemTags(s);
    }

    private static void copy(ItemTags src, ItemTags dst) {
        dst.states.addAll(src.states);
    }

    private static void copy(BlockTags tag, ItemTags itemTag) {
        for (StateType state : tag.getStates()) {
            itemTag.states.add(ItemTypes.getTypePlacingState(state));
        }
        itemTag.states.remove(null); // In case getTypePlacingState returned null
    }

    private ItemTags add(ItemType... state) {
        Collections.addAll(this.states, state);
        return this;
    }

    private ItemTags addTag(ItemTags tags) {
        if (tags.states.isEmpty()) {
            throw new IllegalArgumentException("Tag " + tags.name + " is empty when adding to " + this.name + ", you (packetevents updater) probably messed up the item tags order!!");
        }
        this.states.addAll(tags.states);
        return this;
    }

    public boolean contains(ItemType state) {
        return this.states.contains(state);
    }

    public String getName() {
        return this.name;
    }

    public ItemTags getByName(String name) {
        return byName.get(name);
    }

    public Set<ItemType> getStates() {
        return this.states;
    }

    @VisibleForTesting
    public boolean isReallyEmpty() {
        return this.reallyEmpty;
    }
}
