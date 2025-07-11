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

package com.github.retrooper.packetevents.protocol.sound;

import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.util.mappings.VersionedRegistry;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NullMarked;

import java.util.Collection;

@NullMarked
public final class Sounds {

    private static final VersionedRegistry<Sound> REGISTRY = new VersionedRegistry<>("sound_event");

    private Sounds() {
    }

    public static VersionedRegistry<Sound> getRegistry() {
        return REGISTRY;
    }

    @ApiStatus.Internal
    public static Sound define(String name) {
        return define(name, new ResourceLocation(name), null);
    }

    @ApiStatus.Internal
    public static Sound define(String name, ResourceLocation soundId, @Nullable Float range) {
        return REGISTRY.define(name, data -> new StaticSound(data, soundId, range));
    }

    public static Sound getByNameOrCreate(String name) {
        Sound builtinSound = getByName(name);
        if (builtinSound == null) {
            return new StaticSound(new ResourceLocation(name), null);
        }
        return builtinSound;
    }

    public static @Nullable Sound getByName(String name) {
        return REGISTRY.getByName(name);
    }

    public static @Nullable Sound getById(ClientVersion version, int id) {
        return REGISTRY.getById(version, id);
    }

    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_PIGMAN_HURT = define("entity.zombie_pigman.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_PARROT_IMITATE_POLAR_BEAR = define("entity.parrot.imitate.polar_bear");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_PARROT_IMITATE_PANDA = define("entity.parrot.imitate.panda");
    @ApiStatus.Obsolete
    public static final Sound MUSIC_NETHER = define("music.nether");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_SWEET_BERRY_BUSH_PICK_FROM_BUSH = define("block.sweet_berry_bush.pick_from_bush");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_PARROT_IMITATE_ZOMBIE_PIGMAN = define("entity.parrot.imitate.zombie_pigman");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_PIGMAN_AMBIENT = define("entity.zombie_pigman.ambient");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_PIGMAN_DEATH = define("entity.zombie_pigman.death");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_PARROT_IMITATE_WOLF = define("entity.parrot.imitate.wolf");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_PARROT_IMITATE_ENDERMAN = define("entity.parrot.imitate.enderman");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_PIGMAN_ANGRY = define("entity.zombie_pigman.angry");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_TRIAL_SPAWNER_AMBIENT_CHARGED = define("block.trial_spawner.ambient_charged");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_TRIAL_SPAWNER_CHARGE_ACTIVATE = define("block.trial_spawner.charge_activate");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERDRAGON_FIREBALL_EXPLODE = define("entity.enderdragon_fireball.explode");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_ENDERCHEST_OPEN = define("block.enderchest.open");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERDRAGON_AMBIENT = define("entity.enderdragon.ambient");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_FIREWORK_LARGE_BLAST_FAR = define("entity.firework.large_blast_far");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERPEARL_THROW = define("entity.enderpearl.throw");
    @ApiStatus.Obsolete
    public static final Sound RECORD_FAR = define("record.far");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDEREYE_LAUNCH = define("entity.endereye.launch");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_CLOTH_HIT = define("block.cloth.hit");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SNOWMAN_DEATH = define("entity.snowman.death");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ARMORSTAND_BREAK = define("entity.armorstand.break");
    @ApiStatus.Obsolete
    public static final Sound RECORD_STRAD = define("record.strad");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_CLOTH_BREAK = define("block.cloth.break");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_NOTE_SNARE = define("block.note.snare");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_WOOD_BUTTON_CLICK_OFF = define("block.wood_button.click_off");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_LEASHKNOT_BREAK = define("entity.leashknot.break");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_MAGMACUBE_HURT = define("entity.magmacube.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SNOWMAN_AMBIENT = define("entity.snowman.ambient");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ARMORSTAND_HIT = define("entity.armorstand.hit");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_MAGMACUBE_JUMP = define("entity.magmacube.jump");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_PIG_DEATH = define("entity.zombie_pig.death");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_ATTACK_DOOR_WOOD = define("entity.zombie.attack_door_wood");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_NOTE_HARP = define("block.note.harp");
    @ApiStatus.Obsolete
    public static final Sound RECORD_BLOCKS = define("record.blocks");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_CLOTH_STEP = define("block.cloth.step");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_FIREWORK_SHOOT = define("entity.firework.shoot");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERDRAGON_FLAP = define("entity.enderdragon.flap");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_FIREWORK_TWINKLE_FAR = define("entity.firework.twinkle_far");
    @ApiStatus.Obsolete
    public static final Sound RECORD_MELLOHI = define("record.mellohi");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERMEN_SCREAM = define("entity.endermen.scream");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SMALL_MAGMACUBE_SQUISH = define("entity.small_magmacube.squish");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_IRONGOLEM_HURT = define("entity.irongolem.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_MAGMACUBE_DEATH = define("entity.magmacube.death");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERMEN_DEATH = define("entity.endermen.death");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_FIREWORK_BLAST_FAR = define("entity.firework.blast_far");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_WOOD_BUTTON_CLICK_ON = define("block.wood_button.click_on");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERDRAGON_HURT = define("entity.enderdragon.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_LEASHKNOT_PLACE = define("entity.leashknot.place");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_SLIME_BREAK = define("block.slime.break");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_WATERLILY_PLACE = define("block.waterlily.place");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ARMORSTAND_PLACE = define("entity.armorstand.place");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERDRAGON_SHOOT = define("entity.enderdragon.shoot");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_LIGHTNING_THUNDER = define("entity.lightning.thunder");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SMALL_MAGMACUBE_HURT = define("entity.small_magmacube.hurt");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_CLOTH_FALL = define("block.cloth.fall");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_PIG_AMBIENT = define("entity.zombie_pig.ambient");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_IRONGOLEM_ATTACK = define("entity.irongolem.attack");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_PIG_ANGRY = define("entity.zombie_pig.angry");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_FIREWORK_BLAST = define("entity.firework.blast");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SNOWMAN_SHOOT = define("entity.snowman.shoot");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_CLOTH_PLACE = define("block.cloth.place");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_SLIME_PLACE = define("block.slime.place");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_SLIME_FALL = define("block.slime.fall");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ITEMFRAME_REMOVE_ITEM = define("entity.itemframe.remove_item");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SNOWMAN_HURT = define("entity.snowman.hurt");
    @ApiStatus.Obsolete
    public static final Sound RECORD_STAL = define("record.stal");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SMALL_SLIME_DEATH = define("entity.small_slime.death");
    @ApiStatus.Obsolete
    public static final Sound RECORD_WARD = define("record.ward");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_IRONGOLEM_STEP = define("entity.irongolem.step");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_PIG_HURT = define("entity.zombie_pig.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_FIREWORK_LAUNCH = define("entity.firework.launch");
    @ApiStatus.Obsolete
    public static final Sound RECORD_MALL = define("record.mall");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERMEN_HURT = define("entity.endermen.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERMEN_STARE = define("entity.endermen.stare");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SMALL_SLIME_SQUISH = define("entity.small_slime.squish");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_FIREWORK_TWINKLE = define("entity.firework.twinkle");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_LIGHTNING_IMPACT = define("entity.lightning.impact");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_IRONGOLEM_DEATH = define("entity.irongolem.death");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_STONE_PRESSUREPLATE_CLICK_ON = define("block.stone_pressureplate.click_on");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EXPERIENCE_ORB_TOUCH = define("entity.experience_orb.touch");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_BOBBER_THROW = define("entity.bobber.throw");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERDRAGON_DEATH = define("entity.enderdragon.death");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_BOBBER_SPLASH = define("entity.bobber.splash");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERMEN_AMBIENT = define("entity.endermen.ambient");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_SLIME_STEP = define("block.slime.step");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_NOTE_PLING = define("block.note.pling");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ITEMFRAME_ROTATE_ITEM = define("entity.itemframe.rotate_item");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ITEMFRAME_BREAK = define("entity.itemframe.break");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_WOOD_PRESSUREPLATE_CLICK_OFF = define("block.wood_pressureplate.click_off");
    @ApiStatus.Obsolete
    public static final Sound RECORD_CAT = define("record.cat");
    @ApiStatus.Obsolete
    public static final Sound RECORD_WAIT = define("record.wait");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ITEMFRAME_ADD_ITEM = define("entity.itemframe.add_item");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_NOTE_HAT = define("block.note.hat");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_LINGERINGPOTION_THROW = define("entity.lingeringpotion.throw");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_VILLAGER_TRADING = define("entity.villager.trading");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_ENDERCHEST_CLOSE = define("block.enderchest.close");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ITEMFRAME_PLACE = define("entity.itemframe.place");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_FIREWORK_LARGE_BLAST = define("entity.firework.large_blast");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_MAGMACUBE_SQUISH = define("entity.magmacube.squish");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_STONE_PRESSUREPLATE_CLICK_OFF = define("block.stone_pressureplate.click_off");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_NOTE_BASS = define("block.note.bass");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SMALL_MAGMACUBE_DEATH = define("entity.small_magmacube.death");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ARMORSTAND_FALL = define("entity.armorstand.fall");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERDRAGON_GROWL = define("entity.enderdragon.growl");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_METAL_PRESSUREPLATE_CLICK_OFF = define("block.metal_pressureplate.click_off");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SMALL_SLIME_HURT = define("entity.small_slime.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_SMALL_SLIME_JUMP = define("entity.small_slime.jump");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ZOMBIE_BREAK_DOOR_WOOD = define("entity.zombie.break_door_wood");
    @ApiStatus.Obsolete
    public static final Sound RECORD_CHIRP = define("record.chirp");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_NOTE_BASEDRUM = define("block.note.basedrum");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_SLIME_HIT = define("block.slime.hit");
    @ApiStatus.Obsolete
    public static final Sound RECORD_13 = define("record.13");
    @ApiStatus.Obsolete
    public static final Sound RECORD_11 = define("record.11");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_METAL_PRESSUREPLATE_CLICK_ON = define("block.metal_pressureplate.click_on");
    @ApiStatus.Obsolete
    public static final Sound BLOCK_WOOD_PRESSUREPLATE_CLICK_ON = define("block.wood_pressureplate.click_on");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_ENDERMEN_TELEPORT = define("entity.endermen.teleport");
    @ApiStatus.Obsolete
    public static final Sound MUSIC_OVERWORLD_JUNGLE_AND_FOREST = define("music.overworld.jungle_and_forest");
    @ApiStatus.Obsolete
    public static final Sound ITEM_BRUSH_BRUSHING = define("item.brush.brushing");
    @ApiStatus.Obsolete
    public static final Sound ITEM_BRUSH_BRUSH_SAND_COMPLETED = define("item.brush.brush_sand_completed");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_GENERIC_WIND_BURST = define("entity.generic.wind_burst");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_POLAR_BEAR_BABY_AMBIENT = define("entity.polar_bear.baby_ambient");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_VINDICATION_ILLAGER_DEATH = define("entity.vindication_illager.death");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_VINDICATION_ILLAGER_AMBIENT = define("entity.vindication_illager.ambient");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EVOCATION_ILLAGER_HURT = define("entity.evocation_illager.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EVOCATION_ILLAGER_PREPARE_ATTACK = define("entity.evocation_illager.prepare_attack");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EVOCATION_FANGS_ATTACK = define("entity.evocation_fangs.attack");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EVOCATION_ILLAGER_CAST_SPELL = define("entity.evocation_illager.cast_spell");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EVOCATION_ILLAGER_PREPARE_SUMMON = define("entity.evocation_illager.prepare_summon");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EVOCATION_ILLAGER_AMBIENT = define("entity.evocation_illager.ambient");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EVOCATION_ILLAGER_PREPARE_WOLOLO = define("entity.evocation_illager.prepare_wololo");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_VINDICATION_ILLAGER_HURT = define("entity.vindication_illager.hurt");
    @ApiStatus.Obsolete
    public static final Sound ENTITY_EVOCATION_ILLAGER_DEATH = define("entity.evocation_illager.death");

    public static final Sound ENTITY_ALLAY_AMBIENT_WITH_ITEM = define("entity.allay.ambient_with_item");
    public static final Sound ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM = define("entity.allay.ambient_without_item");
    public static final Sound ENTITY_ALLAY_DEATH = define("entity.allay.death");
    public static final Sound ENTITY_ALLAY_HURT = define("entity.allay.hurt");
    public static final Sound ENTITY_ALLAY_ITEM_GIVEN = define("entity.allay.item_given");
    public static final Sound ENTITY_ALLAY_ITEM_TAKEN = define("entity.allay.item_taken");
    public static final Sound ENTITY_ALLAY_ITEM_THROWN = define("entity.allay.item_thrown");
    public static final Sound AMBIENT_CAVE = define("ambient.cave");
    public static final Sound AMBIENT_BASALT_DELTAS_ADDITIONS = define("ambient.basalt_deltas.additions");
    public static final Sound AMBIENT_BASALT_DELTAS_LOOP = define("ambient.basalt_deltas.loop");
    public static final Sound AMBIENT_BASALT_DELTAS_MOOD = define("ambient.basalt_deltas.mood");
    public static final Sound AMBIENT_CRIMSON_FOREST_ADDITIONS = define("ambient.crimson_forest.additions");
    public static final Sound AMBIENT_CRIMSON_FOREST_LOOP = define("ambient.crimson_forest.loop");
    public static final Sound AMBIENT_CRIMSON_FOREST_MOOD = define("ambient.crimson_forest.mood");
    public static final Sound AMBIENT_NETHER_WASTES_ADDITIONS = define("ambient.nether_wastes.additions");
    public static final Sound AMBIENT_NETHER_WASTES_LOOP = define("ambient.nether_wastes.loop");
    public static final Sound AMBIENT_NETHER_WASTES_MOOD = define("ambient.nether_wastes.mood");
    public static final Sound AMBIENT_SOUL_SAND_VALLEY_ADDITIONS = define("ambient.soul_sand_valley.additions");
    public static final Sound AMBIENT_SOUL_SAND_VALLEY_LOOP = define("ambient.soul_sand_valley.loop");
    public static final Sound AMBIENT_SOUL_SAND_VALLEY_MOOD = define("ambient.soul_sand_valley.mood");
    public static final Sound AMBIENT_WARPED_FOREST_ADDITIONS = define("ambient.warped_forest.additions");
    public static final Sound AMBIENT_WARPED_FOREST_LOOP = define("ambient.warped_forest.loop");
    public static final Sound AMBIENT_WARPED_FOREST_MOOD = define("ambient.warped_forest.mood");
    public static final Sound AMBIENT_UNDERWATER_ENTER = define("ambient.underwater.enter");
    public static final Sound AMBIENT_UNDERWATER_EXIT = define("ambient.underwater.exit");
    public static final Sound AMBIENT_UNDERWATER_LOOP = define("ambient.underwater.loop");
    public static final Sound AMBIENT_UNDERWATER_LOOP_ADDITIONS = define("ambient.underwater.loop.additions");
    public static final Sound AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE = define("ambient.underwater.loop.additions.rare");
    public static final Sound AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE = define("ambient.underwater.loop.additions.ultra_rare");
    public static final Sound BLOCK_AMETHYST_BLOCK_BREAK = define("block.amethyst_block.break");
    public static final Sound BLOCK_AMETHYST_BLOCK_CHIME = define("block.amethyst_block.chime");
    public static final Sound BLOCK_AMETHYST_BLOCK_FALL = define("block.amethyst_block.fall");
    public static final Sound BLOCK_AMETHYST_BLOCK_HIT = define("block.amethyst_block.hit");
    public static final Sound BLOCK_AMETHYST_BLOCK_PLACE = define("block.amethyst_block.place");
    public static final Sound BLOCK_AMETHYST_BLOCK_RESONATE = define("block.amethyst_block.resonate");
    public static final Sound BLOCK_AMETHYST_BLOCK_STEP = define("block.amethyst_block.step");
    public static final Sound BLOCK_AMETHYST_CLUSTER_BREAK = define("block.amethyst_cluster.break");
    public static final Sound BLOCK_AMETHYST_CLUSTER_FALL = define("block.amethyst_cluster.fall");
    public static final Sound BLOCK_AMETHYST_CLUSTER_HIT = define("block.amethyst_cluster.hit");
    public static final Sound BLOCK_AMETHYST_CLUSTER_PLACE = define("block.amethyst_cluster.place");
    public static final Sound BLOCK_AMETHYST_CLUSTER_STEP = define("block.amethyst_cluster.step");
    public static final Sound BLOCK_ANCIENT_DEBRIS_BREAK = define("block.ancient_debris.break");
    public static final Sound BLOCK_ANCIENT_DEBRIS_STEP = define("block.ancient_debris.step");
    public static final Sound BLOCK_ANCIENT_DEBRIS_PLACE = define("block.ancient_debris.place");
    public static final Sound BLOCK_ANCIENT_DEBRIS_HIT = define("block.ancient_debris.hit");
    public static final Sound BLOCK_ANCIENT_DEBRIS_FALL = define("block.ancient_debris.fall");
    public static final Sound BLOCK_ANVIL_BREAK = define("block.anvil.break");
    public static final Sound BLOCK_ANVIL_DESTROY = define("block.anvil.destroy");
    public static final Sound BLOCK_ANVIL_FALL = define("block.anvil.fall");
    public static final Sound BLOCK_ANVIL_HIT = define("block.anvil.hit");
    public static final Sound BLOCK_ANVIL_LAND = define("block.anvil.land");
    public static final Sound BLOCK_ANVIL_PLACE = define("block.anvil.place");
    public static final Sound BLOCK_ANVIL_STEP = define("block.anvil.step");
    public static final Sound BLOCK_ANVIL_USE = define("block.anvil.use");
    public static final Sound ENTITY_ARMADILLO_EAT = define("entity.armadillo.eat");
    public static final Sound ENTITY_ARMADILLO_HURT = define("entity.armadillo.hurt");
    public static final Sound ENTITY_ARMADILLO_HURT_REDUCED = define("entity.armadillo.hurt_reduced");
    public static final Sound ENTITY_ARMADILLO_AMBIENT = define("entity.armadillo.ambient");
    public static final Sound ENTITY_ARMADILLO_STEP = define("entity.armadillo.step");
    public static final Sound ENTITY_ARMADILLO_DEATH = define("entity.armadillo.death");
    public static final Sound ENTITY_ARMADILLO_ROLL = define("entity.armadillo.roll");
    public static final Sound ENTITY_ARMADILLO_LAND = define("entity.armadillo.land");
    public static final Sound ENTITY_ARMADILLO_SCUTE_DROP = define("entity.armadillo.scute_drop");
    public static final Sound ENTITY_ARMADILLO_UNROLL_FINISH = define("entity.armadillo.unroll_finish");
    public static final Sound ENTITY_ARMADILLO_PEEK = define("entity.armadillo.peek");
    public static final Sound ENTITY_ARMADILLO_UNROLL_START = define("entity.armadillo.unroll_start");
    public static final Sound ENTITY_ARMADILLO_BRUSH = define("entity.armadillo.brush");
    public static final Sound ITEM_ARMOR_EQUIP_CHAIN = define("item.armor.equip_chain");
    public static final Sound ITEM_ARMOR_EQUIP_DIAMOND = define("item.armor.equip_diamond");
    public static final Sound ITEM_ARMOR_EQUIP_ELYTRA = define("item.armor.equip_elytra");
    public static final Sound ITEM_ARMOR_EQUIP_GENERIC = define("item.armor.equip_generic");
    public static final Sound ITEM_ARMOR_EQUIP_GOLD = define("item.armor.equip_gold");
    public static final Sound ITEM_ARMOR_EQUIP_IRON = define("item.armor.equip_iron");
    public static final Sound ITEM_ARMOR_EQUIP_LEATHER = define("item.armor.equip_leather");
    public static final Sound ITEM_ARMOR_EQUIP_NETHERITE = define("item.armor.equip_netherite");
    public static final Sound ITEM_ARMOR_EQUIP_TURTLE = define("item.armor.equip_turtle");
    public static final Sound ITEM_ARMOR_EQUIP_WOLF = define("item.armor.equip_wolf");
    public static final Sound ITEM_ARMOR_UNEQUIP_WOLF = define("item.armor.unequip_wolf");
    public static final Sound ENTITY_ARMOR_STAND_BREAK = define("entity.armor_stand.break");
    public static final Sound ENTITY_ARMOR_STAND_FALL = define("entity.armor_stand.fall");
    public static final Sound ENTITY_ARMOR_STAND_HIT = define("entity.armor_stand.hit");
    public static final Sound ENTITY_ARMOR_STAND_PLACE = define("entity.armor_stand.place");
    public static final Sound ENTITY_ARROW_HIT = define("entity.arrow.hit");
    public static final Sound ENTITY_ARROW_HIT_PLAYER = define("entity.arrow.hit_player");
    public static final Sound ENTITY_ARROW_SHOOT = define("entity.arrow.shoot");
    public static final Sound ITEM_AXE_STRIP = define("item.axe.strip");
    public static final Sound ITEM_AXE_SCRAPE = define("item.axe.scrape");
    public static final Sound ITEM_AXE_WAX_OFF = define("item.axe.wax_off");
    public static final Sound ENTITY_AXOLOTL_ATTACK = define("entity.axolotl.attack");
    public static final Sound ENTITY_AXOLOTL_DEATH = define("entity.axolotl.death");
    public static final Sound ENTITY_AXOLOTL_HURT = define("entity.axolotl.hurt");
    public static final Sound ENTITY_AXOLOTL_IDLE_AIR = define("entity.axolotl.idle_air");
    public static final Sound ENTITY_AXOLOTL_IDLE_WATER = define("entity.axolotl.idle_water");
    public static final Sound ENTITY_AXOLOTL_SPLASH = define("entity.axolotl.splash");
    public static final Sound ENTITY_AXOLOTL_SWIM = define("entity.axolotl.swim");
    public static final Sound BLOCK_AZALEA_BREAK = define("block.azalea.break");
    public static final Sound BLOCK_AZALEA_FALL = define("block.azalea.fall");
    public static final Sound BLOCK_AZALEA_HIT = define("block.azalea.hit");
    public static final Sound BLOCK_AZALEA_PLACE = define("block.azalea.place");
    public static final Sound BLOCK_AZALEA_STEP = define("block.azalea.step");
    public static final Sound BLOCK_AZALEA_LEAVES_BREAK = define("block.azalea_leaves.break");
    public static final Sound BLOCK_AZALEA_LEAVES_FALL = define("block.azalea_leaves.fall");
    public static final Sound BLOCK_AZALEA_LEAVES_HIT = define("block.azalea_leaves.hit");
    public static final Sound BLOCK_AZALEA_LEAVES_PLACE = define("block.azalea_leaves.place");
    public static final Sound BLOCK_AZALEA_LEAVES_STEP = define("block.azalea_leaves.step");
    public static final Sound BLOCK_BAMBOO_BREAK = define("block.bamboo.break");
    public static final Sound BLOCK_BAMBOO_FALL = define("block.bamboo.fall");
    public static final Sound BLOCK_BAMBOO_HIT = define("block.bamboo.hit");
    public static final Sound BLOCK_BAMBOO_PLACE = define("block.bamboo.place");
    public static final Sound BLOCK_BAMBOO_STEP = define("block.bamboo.step");
    public static final Sound BLOCK_BAMBOO_SAPLING_BREAK = define("block.bamboo_sapling.break");
    public static final Sound BLOCK_BAMBOO_SAPLING_HIT = define("block.bamboo_sapling.hit");
    public static final Sound BLOCK_BAMBOO_SAPLING_PLACE = define("block.bamboo_sapling.place");
    public static final Sound BLOCK_BAMBOO_WOOD_BREAK = define("block.bamboo_wood.break");
    public static final Sound BLOCK_BAMBOO_WOOD_FALL = define("block.bamboo_wood.fall");
    public static final Sound BLOCK_BAMBOO_WOOD_HIT = define("block.bamboo_wood.hit");
    public static final Sound BLOCK_BAMBOO_WOOD_PLACE = define("block.bamboo_wood.place");
    public static final Sound BLOCK_BAMBOO_WOOD_STEP = define("block.bamboo_wood.step");
    public static final Sound BLOCK_BAMBOO_WOOD_DOOR_CLOSE = define("block.bamboo_wood_door.close");
    public static final Sound BLOCK_BAMBOO_WOOD_DOOR_OPEN = define("block.bamboo_wood_door.open");
    public static final Sound BLOCK_BAMBOO_WOOD_TRAPDOOR_CLOSE = define("block.bamboo_wood_trapdoor.close");
    public static final Sound BLOCK_BAMBOO_WOOD_TRAPDOOR_OPEN = define("block.bamboo_wood_trapdoor.open");
    public static final Sound BLOCK_BAMBOO_WOOD_BUTTON_CLICK_OFF = define("block.bamboo_wood_button.click_off");
    public static final Sound BLOCK_BAMBOO_WOOD_BUTTON_CLICK_ON = define("block.bamboo_wood_button.click_on");
    public static final Sound BLOCK_BAMBOO_WOOD_PRESSURE_PLATE_CLICK_OFF = define("block.bamboo_wood_pressure_plate.click_off");
    public static final Sound BLOCK_BAMBOO_WOOD_PRESSURE_PLATE_CLICK_ON = define("block.bamboo_wood_pressure_plate.click_on");
    public static final Sound BLOCK_BAMBOO_WOOD_FENCE_GATE_CLOSE = define("block.bamboo_wood_fence_gate.close");
    public static final Sound BLOCK_BAMBOO_WOOD_FENCE_GATE_OPEN = define("block.bamboo_wood_fence_gate.open");
    public static final Sound BLOCK_BARREL_CLOSE = define("block.barrel.close");
    public static final Sound BLOCK_BARREL_OPEN = define("block.barrel.open");
    public static final Sound BLOCK_BASALT_BREAK = define("block.basalt.break");
    public static final Sound BLOCK_BASALT_STEP = define("block.basalt.step");
    public static final Sound BLOCK_BASALT_PLACE = define("block.basalt.place");
    public static final Sound BLOCK_BASALT_HIT = define("block.basalt.hit");
    public static final Sound BLOCK_BASALT_FALL = define("block.basalt.fall");
    public static final Sound ENTITY_BAT_AMBIENT = define("entity.bat.ambient");
    public static final Sound ENTITY_BAT_DEATH = define("entity.bat.death");
    public static final Sound ENTITY_BAT_HURT = define("entity.bat.hurt");
    public static final Sound ENTITY_BAT_LOOP = define("entity.bat.loop");
    public static final Sound ENTITY_BAT_TAKEOFF = define("entity.bat.takeoff");
    public static final Sound BLOCK_BEACON_ACTIVATE = define("block.beacon.activate");
    public static final Sound BLOCK_BEACON_AMBIENT = define("block.beacon.ambient");
    public static final Sound BLOCK_BEACON_DEACTIVATE = define("block.beacon.deactivate");
    public static final Sound BLOCK_BEACON_POWER_SELECT = define("block.beacon.power_select");
    public static final Sound ENTITY_BEE_DEATH = define("entity.bee.death");
    public static final Sound ENTITY_BEE_HURT = define("entity.bee.hurt");
    public static final Sound ENTITY_BEE_LOOP_AGGRESSIVE = define("entity.bee.loop_aggressive");
    public static final Sound ENTITY_BEE_LOOP = define("entity.bee.loop");
    public static final Sound ENTITY_BEE_STING = define("entity.bee.sting");
    public static final Sound ENTITY_BEE_POLLINATE = define("entity.bee.pollinate");
    public static final Sound BLOCK_BEEHIVE_DRIP = define("block.beehive.drip");
    public static final Sound BLOCK_BEEHIVE_ENTER = define("block.beehive.enter");
    public static final Sound BLOCK_BEEHIVE_EXIT = define("block.beehive.exit");
    public static final Sound BLOCK_BEEHIVE_SHEAR = define("block.beehive.shear");
    public static final Sound BLOCK_BEEHIVE_WORK = define("block.beehive.work");
    public static final Sound BLOCK_BELL_USE = define("block.bell.use");
    public static final Sound BLOCK_BELL_RESONATE = define("block.bell.resonate");
    public static final Sound BLOCK_BIG_DRIPLEAF_BREAK = define("block.big_dripleaf.break");
    public static final Sound BLOCK_BIG_DRIPLEAF_FALL = define("block.big_dripleaf.fall");
    public static final Sound BLOCK_BIG_DRIPLEAF_HIT = define("block.big_dripleaf.hit");
    public static final Sound BLOCK_BIG_DRIPLEAF_PLACE = define("block.big_dripleaf.place");
    public static final Sound BLOCK_BIG_DRIPLEAF_STEP = define("block.big_dripleaf.step");
    public static final Sound ENTITY_BLAZE_AMBIENT = define("entity.blaze.ambient");
    public static final Sound ENTITY_BLAZE_BURN = define("entity.blaze.burn");
    public static final Sound ENTITY_BLAZE_DEATH = define("entity.blaze.death");
    public static final Sound ENTITY_BLAZE_HURT = define("entity.blaze.hurt");
    public static final Sound ENTITY_BLAZE_SHOOT = define("entity.blaze.shoot");
    public static final Sound ENTITY_BOAT_PADDLE_LAND = define("entity.boat.paddle_land");
    public static final Sound ENTITY_BOAT_PADDLE_WATER = define("entity.boat.paddle_water");
    public static final Sound ENTITY_BOGGED_AMBIENT = define("entity.bogged.ambient");
    public static final Sound ENTITY_BOGGED_DEATH = define("entity.bogged.death");
    public static final Sound ENTITY_BOGGED_HURT = define("entity.bogged.hurt");
    public static final Sound ENTITY_BOGGED_SHEAR = define("entity.bogged.shear");
    public static final Sound ENTITY_BOGGED_STEP = define("entity.bogged.step");
    public static final Sound BLOCK_BONE_BLOCK_BREAK = define("block.bone_block.break");
    public static final Sound BLOCK_BONE_BLOCK_FALL = define("block.bone_block.fall");
    public static final Sound BLOCK_BONE_BLOCK_HIT = define("block.bone_block.hit");
    public static final Sound BLOCK_BONE_BLOCK_PLACE = define("block.bone_block.place");
    public static final Sound BLOCK_BONE_BLOCK_STEP = define("block.bone_block.step");
    public static final Sound ITEM_BONE_MEAL_USE = define("item.bone_meal.use");
    public static final Sound ITEM_BOOK_PAGE_TURN = define("item.book.page_turn");
    public static final Sound ITEM_BOOK_PUT = define("item.book.put");
    public static final Sound BLOCK_BLASTFURNACE_FIRE_CRACKLE = define("block.blastfurnace.fire_crackle");
    public static final Sound ITEM_BOTTLE_EMPTY = define("item.bottle.empty");
    public static final Sound ITEM_BOTTLE_FILL = define("item.bottle.fill");
    public static final Sound ITEM_BOTTLE_FILL_DRAGONBREATH = define("item.bottle.fill_dragonbreath");
    public static final Sound ENTITY_BREEZE_CHARGE = define("entity.breeze.charge");
    public static final Sound ENTITY_BREEZE_DEFLECT = define("entity.breeze.deflect");
    public static final Sound ENTITY_BREEZE_INHALE = define("entity.breeze.inhale");
    public static final Sound ENTITY_BREEZE_IDLE_GROUND = define("entity.breeze.idle_ground");
    public static final Sound ENTITY_BREEZE_IDLE_AIR = define("entity.breeze.idle_air");
    public static final Sound ENTITY_BREEZE_SHOOT = define("entity.breeze.shoot");
    public static final Sound ENTITY_BREEZE_JUMP = define("entity.breeze.jump");
    public static final Sound ENTITY_BREEZE_LAND = define("entity.breeze.land");
    public static final Sound ENTITY_BREEZE_SLIDE = define("entity.breeze.slide");
    public static final Sound ENTITY_BREEZE_DEATH = define("entity.breeze.death");
    public static final Sound ENTITY_BREEZE_HURT = define("entity.breeze.hurt");
    public static final Sound ENTITY_BREEZE_WHIRL = define("entity.breeze.whirl");
    public static final Sound ENTITY_BREEZE_WIND_BURST = define("entity.breeze.wind_burst");
    public static final Sound BLOCK_BREWING_STAND_BREW = define("block.brewing_stand.brew");
    public static final Sound ITEM_BRUSH_BRUSHING_GENERIC = define("item.brush.brushing.generic");
    public static final Sound ITEM_BRUSH_BRUSHING_SAND = define("item.brush.brushing.sand");
    public static final Sound ITEM_BRUSH_BRUSHING_GRAVEL = define("item.brush.brushing.gravel");
    public static final Sound ITEM_BRUSH_BRUSHING_SAND_COMPLETE = define("item.brush.brushing.sand.complete");
    public static final Sound ITEM_BRUSH_BRUSHING_GRAVEL_COMPLETE = define("item.brush.brushing.gravel.complete");
    public static final Sound BLOCK_BUBBLE_COLUMN_BUBBLE_POP = define("block.bubble_column.bubble_pop");
    public static final Sound BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT = define("block.bubble_column.upwards_ambient");
    public static final Sound BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE = define("block.bubble_column.upwards_inside");
    public static final Sound BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT = define("block.bubble_column.whirlpool_ambient");
    public static final Sound BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE = define("block.bubble_column.whirlpool_inside");
    public static final Sound ITEM_BUCKET_EMPTY = define("item.bucket.empty");
    public static final Sound ITEM_BUCKET_EMPTY_AXOLOTL = define("item.bucket.empty_axolotl");
    public static final Sound ITEM_BUCKET_EMPTY_FISH = define("item.bucket.empty_fish");
    public static final Sound ITEM_BUCKET_EMPTY_LAVA = define("item.bucket.empty_lava");
    public static final Sound ITEM_BUCKET_EMPTY_POWDER_SNOW = define("item.bucket.empty_powder_snow");
    public static final Sound ITEM_BUCKET_EMPTY_TADPOLE = define("item.bucket.empty_tadpole");
    public static final Sound ITEM_BUCKET_FILL = define("item.bucket.fill");
    public static final Sound ITEM_BUCKET_FILL_AXOLOTL = define("item.bucket.fill_axolotl");
    public static final Sound ITEM_BUCKET_FILL_FISH = define("item.bucket.fill_fish");
    public static final Sound ITEM_BUCKET_FILL_LAVA = define("item.bucket.fill_lava");
    public static final Sound ITEM_BUCKET_FILL_POWDER_SNOW = define("item.bucket.fill_powder_snow");
    public static final Sound ITEM_BUCKET_FILL_TADPOLE = define("item.bucket.fill_tadpole");
    public static final Sound ITEM_BUNDLE_DROP_CONTENTS = define("item.bundle.drop_contents");
    public static final Sound ITEM_BUNDLE_INSERT = define("item.bundle.insert");
    public static final Sound ITEM_BUNDLE_REMOVE_ONE = define("item.bundle.remove_one");
    public static final Sound BLOCK_CAKE_ADD_CANDLE = define("block.cake.add_candle");
    public static final Sound BLOCK_CALCITE_BREAK = define("block.calcite.break");
    public static final Sound BLOCK_CALCITE_STEP = define("block.calcite.step");
    public static final Sound BLOCK_CALCITE_PLACE = define("block.calcite.place");
    public static final Sound BLOCK_CALCITE_HIT = define("block.calcite.hit");
    public static final Sound BLOCK_CALCITE_FALL = define("block.calcite.fall");
    public static final Sound ENTITY_CAMEL_AMBIENT = define("entity.camel.ambient");
    public static final Sound ENTITY_CAMEL_DASH = define("entity.camel.dash");
    public static final Sound ENTITY_CAMEL_DASH_READY = define("entity.camel.dash_ready");
    public static final Sound ENTITY_CAMEL_DEATH = define("entity.camel.death");
    public static final Sound ENTITY_CAMEL_EAT = define("entity.camel.eat");
    public static final Sound ENTITY_CAMEL_HURT = define("entity.camel.hurt");
    public static final Sound ENTITY_CAMEL_SADDLE = define("entity.camel.saddle");
    public static final Sound ENTITY_CAMEL_SIT = define("entity.camel.sit");
    public static final Sound ENTITY_CAMEL_STAND = define("entity.camel.stand");
    public static final Sound ENTITY_CAMEL_STEP = define("entity.camel.step");
    public static final Sound ENTITY_CAMEL_STEP_SAND = define("entity.camel.step_sand");
    public static final Sound BLOCK_CAMPFIRE_CRACKLE = define("block.campfire.crackle");
    public static final Sound BLOCK_CANDLE_AMBIENT = define("block.candle.ambient");
    public static final Sound BLOCK_CANDLE_BREAK = define("block.candle.break");
    public static final Sound BLOCK_CANDLE_EXTINGUISH = define("block.candle.extinguish");
    public static final Sound BLOCK_CANDLE_FALL = define("block.candle.fall");
    public static final Sound BLOCK_CANDLE_HIT = define("block.candle.hit");
    public static final Sound BLOCK_CANDLE_PLACE = define("block.candle.place");
    public static final Sound BLOCK_CANDLE_STEP = define("block.candle.step");
    public static final Sound ENTITY_CAT_AMBIENT = define("entity.cat.ambient");
    public static final Sound ENTITY_CAT_STRAY_AMBIENT = define("entity.cat.stray_ambient");
    public static final Sound ENTITY_CAT_DEATH = define("entity.cat.death");
    public static final Sound ENTITY_CAT_EAT = define("entity.cat.eat");
    public static final Sound ENTITY_CAT_HISS = define("entity.cat.hiss");
    public static final Sound ENTITY_CAT_BEG_FOR_FOOD = define("entity.cat.beg_for_food");
    public static final Sound ENTITY_CAT_HURT = define("entity.cat.hurt");
    public static final Sound ENTITY_CAT_PURR = define("entity.cat.purr");
    public static final Sound ENTITY_CAT_PURREOW = define("entity.cat.purreow");
    public static final Sound BLOCK_CAVE_VINES_BREAK = define("block.cave_vines.break");
    public static final Sound BLOCK_CAVE_VINES_FALL = define("block.cave_vines.fall");
    public static final Sound BLOCK_CAVE_VINES_HIT = define("block.cave_vines.hit");
    public static final Sound BLOCK_CAVE_VINES_PLACE = define("block.cave_vines.place");
    public static final Sound BLOCK_CAVE_VINES_STEP = define("block.cave_vines.step");
    public static final Sound BLOCK_CAVE_VINES_PICK_BERRIES = define("block.cave_vines.pick_berries");
    public static final Sound BLOCK_CHAIN_BREAK = define("block.chain.break");
    public static final Sound BLOCK_CHAIN_FALL = define("block.chain.fall");
    public static final Sound BLOCK_CHAIN_HIT = define("block.chain.hit");
    public static final Sound BLOCK_CHAIN_PLACE = define("block.chain.place");
    public static final Sound BLOCK_CHAIN_STEP = define("block.chain.step");
    public static final Sound BLOCK_CHERRY_WOOD_BREAK = define("block.cherry_wood.break");
    public static final Sound BLOCK_CHERRY_WOOD_FALL = define("block.cherry_wood.fall");
    public static final Sound BLOCK_CHERRY_WOOD_HIT = define("block.cherry_wood.hit");
    public static final Sound BLOCK_CHERRY_WOOD_PLACE = define("block.cherry_wood.place");
    public static final Sound BLOCK_CHERRY_WOOD_STEP = define("block.cherry_wood.step");
    public static final Sound BLOCK_CHERRY_SAPLING_BREAK = define("block.cherry_sapling.break");
    public static final Sound BLOCK_CHERRY_SAPLING_FALL = define("block.cherry_sapling.fall");
    public static final Sound BLOCK_CHERRY_SAPLING_HIT = define("block.cherry_sapling.hit");
    public static final Sound BLOCK_CHERRY_SAPLING_PLACE = define("block.cherry_sapling.place");
    public static final Sound BLOCK_CHERRY_SAPLING_STEP = define("block.cherry_sapling.step");
    public static final Sound BLOCK_CHERRY_LEAVES_BREAK = define("block.cherry_leaves.break");
    public static final Sound BLOCK_CHERRY_LEAVES_FALL = define("block.cherry_leaves.fall");
    public static final Sound BLOCK_CHERRY_LEAVES_HIT = define("block.cherry_leaves.hit");
    public static final Sound BLOCK_CHERRY_LEAVES_PLACE = define("block.cherry_leaves.place");
    public static final Sound BLOCK_CHERRY_LEAVES_STEP = define("block.cherry_leaves.step");
    public static final Sound BLOCK_CHERRY_WOOD_HANGING_SIGN_STEP = define("block.cherry_wood_hanging_sign.step");
    public static final Sound BLOCK_CHERRY_WOOD_HANGING_SIGN_BREAK = define("block.cherry_wood_hanging_sign.break");
    public static final Sound BLOCK_CHERRY_WOOD_HANGING_SIGN_FALL = define("block.cherry_wood_hanging_sign.fall");
    public static final Sound BLOCK_CHERRY_WOOD_HANGING_SIGN_HIT = define("block.cherry_wood_hanging_sign.hit");
    public static final Sound BLOCK_CHERRY_WOOD_HANGING_SIGN_PLACE = define("block.cherry_wood_hanging_sign.place");
    public static final Sound BLOCK_CHERRY_WOOD_DOOR_CLOSE = define("block.cherry_wood_door.close");
    public static final Sound BLOCK_CHERRY_WOOD_DOOR_OPEN = define("block.cherry_wood_door.open");
    public static final Sound BLOCK_CHERRY_WOOD_TRAPDOOR_CLOSE = define("block.cherry_wood_trapdoor.close");
    public static final Sound BLOCK_CHERRY_WOOD_TRAPDOOR_OPEN = define("block.cherry_wood_trapdoor.open");
    public static final Sound BLOCK_CHERRY_WOOD_BUTTON_CLICK_OFF = define("block.cherry_wood_button.click_off");
    public static final Sound BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON = define("block.cherry_wood_button.click_on");
    public static final Sound BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF = define("block.cherry_wood_pressure_plate.click_off");
    public static final Sound BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON = define("block.cherry_wood_pressure_plate.click_on");
    public static final Sound BLOCK_CHERRY_WOOD_FENCE_GATE_CLOSE = define("block.cherry_wood_fence_gate.close");
    public static final Sound BLOCK_CHERRY_WOOD_FENCE_GATE_OPEN = define("block.cherry_wood_fence_gate.open");
    public static final Sound BLOCK_CHEST_CLOSE = define("block.chest.close");
    public static final Sound BLOCK_CHEST_LOCKED = define("block.chest.locked");
    public static final Sound BLOCK_CHEST_OPEN = define("block.chest.open");
    public static final Sound ENTITY_CHICKEN_AMBIENT = define("entity.chicken.ambient");
    public static final Sound ENTITY_CHICKEN_DEATH = define("entity.chicken.death");
    public static final Sound ENTITY_CHICKEN_EGG = define("entity.chicken.egg");
    public static final Sound ENTITY_CHICKEN_HURT = define("entity.chicken.hurt");
    public static final Sound ENTITY_CHICKEN_STEP = define("entity.chicken.step");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_BREAK = define("block.chiseled_bookshelf.break");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_FALL = define("block.chiseled_bookshelf.fall");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_HIT = define("block.chiseled_bookshelf.hit");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_INSERT = define("block.chiseled_bookshelf.insert");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_INSERT_ENCHANTED = define("block.chiseled_bookshelf.insert.enchanted");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_STEP = define("block.chiseled_bookshelf.step");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_PICKUP = define("block.chiseled_bookshelf.pickup");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_PICKUP_ENCHANTED = define("block.chiseled_bookshelf.pickup.enchanted");
    public static final Sound BLOCK_CHISELED_BOOKSHELF_PLACE = define("block.chiseled_bookshelf.place");
    public static final Sound BLOCK_CHORUS_FLOWER_DEATH = define("block.chorus_flower.death");
    public static final Sound BLOCK_CHORUS_FLOWER_GROW = define("block.chorus_flower.grow");
    public static final Sound ITEM_CHORUS_FRUIT_TELEPORT = define("item.chorus_fruit.teleport");
    public static final Sound BLOCK_COBWEB_BREAK = define("block.cobweb.break");
    public static final Sound BLOCK_COBWEB_STEP = define("block.cobweb.step");
    public static final Sound BLOCK_COBWEB_PLACE = define("block.cobweb.place");
    public static final Sound BLOCK_COBWEB_HIT = define("block.cobweb.hit");
    public static final Sound BLOCK_COBWEB_FALL = define("block.cobweb.fall");
    public static final Sound ENTITY_COD_AMBIENT = define("entity.cod.ambient");
    public static final Sound ENTITY_COD_DEATH = define("entity.cod.death");
    public static final Sound ENTITY_COD_FLOP = define("entity.cod.flop");
    public static final Sound ENTITY_COD_HURT = define("entity.cod.hurt");
    public static final Sound BLOCK_COMPARATOR_CLICK = define("block.comparator.click");
    public static final Sound BLOCK_COMPOSTER_EMPTY = define("block.composter.empty");
    public static final Sound BLOCK_COMPOSTER_FILL = define("block.composter.fill");
    public static final Sound BLOCK_COMPOSTER_FILL_SUCCESS = define("block.composter.fill_success");
    public static final Sound BLOCK_COMPOSTER_READY = define("block.composter.ready");
    public static final Sound BLOCK_CONDUIT_ACTIVATE = define("block.conduit.activate");
    public static final Sound BLOCK_CONDUIT_AMBIENT = define("block.conduit.ambient");
    public static final Sound BLOCK_CONDUIT_AMBIENT_SHORT = define("block.conduit.ambient.short");
    public static final Sound BLOCK_CONDUIT_ATTACK_TARGET = define("block.conduit.attack.target");
    public static final Sound BLOCK_CONDUIT_DEACTIVATE = define("block.conduit.deactivate");
    public static final Sound BLOCK_COPPER_BULB_BREAK = define("block.copper_bulb.break");
    public static final Sound BLOCK_COPPER_BULB_STEP = define("block.copper_bulb.step");
    public static final Sound BLOCK_COPPER_BULB_PLACE = define("block.copper_bulb.place");
    public static final Sound BLOCK_COPPER_BULB_HIT = define("block.copper_bulb.hit");
    public static final Sound BLOCK_COPPER_BULB_FALL = define("block.copper_bulb.fall");
    public static final Sound BLOCK_COPPER_BULB_TURN_ON = define("block.copper_bulb.turn_on");
    public static final Sound BLOCK_COPPER_BULB_TURN_OFF = define("block.copper_bulb.turn_off");
    public static final Sound BLOCK_COPPER_BREAK = define("block.copper.break");
    public static final Sound BLOCK_COPPER_STEP = define("block.copper.step");
    public static final Sound BLOCK_COPPER_PLACE = define("block.copper.place");
    public static final Sound BLOCK_COPPER_HIT = define("block.copper.hit");
    public static final Sound BLOCK_COPPER_FALL = define("block.copper.fall");
    public static final Sound BLOCK_COPPER_DOOR_CLOSE = define("block.copper_door.close");
    public static final Sound BLOCK_COPPER_DOOR_OPEN = define("block.copper_door.open");
    public static final Sound BLOCK_COPPER_GRATE_BREAK = define("block.copper_grate.break");
    public static final Sound BLOCK_COPPER_GRATE_STEP = define("block.copper_grate.step");
    public static final Sound BLOCK_COPPER_GRATE_PLACE = define("block.copper_grate.place");
    public static final Sound BLOCK_COPPER_GRATE_HIT = define("block.copper_grate.hit");
    public static final Sound BLOCK_COPPER_GRATE_FALL = define("block.copper_grate.fall");
    public static final Sound BLOCK_COPPER_TRAPDOOR_CLOSE = define("block.copper_trapdoor.close");
    public static final Sound BLOCK_COPPER_TRAPDOOR_OPEN = define("block.copper_trapdoor.open");
    public static final Sound BLOCK_CORAL_BLOCK_BREAK = define("block.coral_block.break");
    public static final Sound BLOCK_CORAL_BLOCK_FALL = define("block.coral_block.fall");
    public static final Sound BLOCK_CORAL_BLOCK_HIT = define("block.coral_block.hit");
    public static final Sound BLOCK_CORAL_BLOCK_PLACE = define("block.coral_block.place");
    public static final Sound BLOCK_CORAL_BLOCK_STEP = define("block.coral_block.step");
    public static final Sound ENTITY_COW_AMBIENT = define("entity.cow.ambient");
    public static final Sound ENTITY_COW_DEATH = define("entity.cow.death");
    public static final Sound ENTITY_COW_HURT = define("entity.cow.hurt");
    public static final Sound ENTITY_COW_MILK = define("entity.cow.milk");
    public static final Sound ENTITY_COW_STEP = define("entity.cow.step");
    public static final Sound BLOCK_CRAFTER_CRAFT = define("block.crafter.craft");
    public static final Sound BLOCK_CRAFTER_FAIL = define("block.crafter.fail");
    public static final Sound ENTITY_CREEPER_DEATH = define("entity.creeper.death");
    public static final Sound ENTITY_CREEPER_HURT = define("entity.creeper.hurt");
    public static final Sound ENTITY_CREEPER_PRIMED = define("entity.creeper.primed");
    public static final Sound BLOCK_CROP_BREAK = define("block.crop.break");
    public static final Sound ITEM_CROP_PLANT = define("item.crop.plant");
    public static final Sound ITEM_CROSSBOW_HIT = define("item.crossbow.hit");
    public static final Sound ITEM_CROSSBOW_LOADING_END = define("item.crossbow.loading_end");
    public static final Sound ITEM_CROSSBOW_LOADING_MIDDLE = define("item.crossbow.loading_middle");
    public static final Sound ITEM_CROSSBOW_LOADING_START = define("item.crossbow.loading_start");
    public static final Sound ITEM_CROSSBOW_QUICK_CHARGE_1 = define("item.crossbow.quick_charge_1");
    public static final Sound ITEM_CROSSBOW_QUICK_CHARGE_2 = define("item.crossbow.quick_charge_2");
    public static final Sound ITEM_CROSSBOW_QUICK_CHARGE_3 = define("item.crossbow.quick_charge_3");
    public static final Sound ITEM_CROSSBOW_SHOOT = define("item.crossbow.shoot");
    public static final Sound BLOCK_DECORATED_POT_BREAK = define("block.decorated_pot.break");
    public static final Sound BLOCK_DECORATED_POT_FALL = define("block.decorated_pot.fall");
    public static final Sound BLOCK_DECORATED_POT_HIT = define("block.decorated_pot.hit");
    public static final Sound BLOCK_DECORATED_POT_INSERT = define("block.decorated_pot.insert");
    public static final Sound BLOCK_DECORATED_POT_INSERT_FAIL = define("block.decorated_pot.insert_fail");
    public static final Sound BLOCK_DECORATED_POT_STEP = define("block.decorated_pot.step");
    public static final Sound BLOCK_DECORATED_POT_PLACE = define("block.decorated_pot.place");
    public static final Sound BLOCK_DECORATED_POT_SHATTER = define("block.decorated_pot.shatter");
    public static final Sound BLOCK_DEEPSLATE_BRICKS_BREAK = define("block.deepslate_bricks.break");
    public static final Sound BLOCK_DEEPSLATE_BRICKS_FALL = define("block.deepslate_bricks.fall");
    public static final Sound BLOCK_DEEPSLATE_BRICKS_HIT = define("block.deepslate_bricks.hit");
    public static final Sound BLOCK_DEEPSLATE_BRICKS_PLACE = define("block.deepslate_bricks.place");
    public static final Sound BLOCK_DEEPSLATE_BRICKS_STEP = define("block.deepslate_bricks.step");
    public static final Sound BLOCK_DEEPSLATE_BREAK = define("block.deepslate.break");
    public static final Sound BLOCK_DEEPSLATE_FALL = define("block.deepslate.fall");
    public static final Sound BLOCK_DEEPSLATE_HIT = define("block.deepslate.hit");
    public static final Sound BLOCK_DEEPSLATE_PLACE = define("block.deepslate.place");
    public static final Sound BLOCK_DEEPSLATE_STEP = define("block.deepslate.step");
    public static final Sound BLOCK_DEEPSLATE_TILES_BREAK = define("block.deepslate_tiles.break");
    public static final Sound BLOCK_DEEPSLATE_TILES_FALL = define("block.deepslate_tiles.fall");
    public static final Sound BLOCK_DEEPSLATE_TILES_HIT = define("block.deepslate_tiles.hit");
    public static final Sound BLOCK_DEEPSLATE_TILES_PLACE = define("block.deepslate_tiles.place");
    public static final Sound BLOCK_DEEPSLATE_TILES_STEP = define("block.deepslate_tiles.step");
    public static final Sound BLOCK_DISPENSER_DISPENSE = define("block.dispenser.dispense");
    public static final Sound BLOCK_DISPENSER_FAIL = define("block.dispenser.fail");
    public static final Sound BLOCK_DISPENSER_LAUNCH = define("block.dispenser.launch");
    public static final Sound ENTITY_DOLPHIN_AMBIENT = define("entity.dolphin.ambient");
    public static final Sound ENTITY_DOLPHIN_AMBIENT_WATER = define("entity.dolphin.ambient_water");
    public static final Sound ENTITY_DOLPHIN_ATTACK = define("entity.dolphin.attack");
    public static final Sound ENTITY_DOLPHIN_DEATH = define("entity.dolphin.death");
    public static final Sound ENTITY_DOLPHIN_EAT = define("entity.dolphin.eat");
    public static final Sound ENTITY_DOLPHIN_HURT = define("entity.dolphin.hurt");
    public static final Sound ENTITY_DOLPHIN_JUMP = define("entity.dolphin.jump");
    public static final Sound ENTITY_DOLPHIN_PLAY = define("entity.dolphin.play");
    public static final Sound ENTITY_DOLPHIN_SPLASH = define("entity.dolphin.splash");
    public static final Sound ENTITY_DOLPHIN_SWIM = define("entity.dolphin.swim");
    public static final Sound ENTITY_DONKEY_AMBIENT = define("entity.donkey.ambient");
    public static final Sound ENTITY_DONKEY_ANGRY = define("entity.donkey.angry");
    public static final Sound ENTITY_DONKEY_CHEST = define("entity.donkey.chest");
    public static final Sound ENTITY_DONKEY_DEATH = define("entity.donkey.death");
    public static final Sound ENTITY_DONKEY_EAT = define("entity.donkey.eat");
    public static final Sound ENTITY_DONKEY_HURT = define("entity.donkey.hurt");
    public static final Sound ENTITY_DONKEY_JUMP = define("entity.donkey.jump");
    public static final Sound BLOCK_DRIPSTONE_BLOCK_BREAK = define("block.dripstone_block.break");
    public static final Sound BLOCK_DRIPSTONE_BLOCK_STEP = define("block.dripstone_block.step");
    public static final Sound BLOCK_DRIPSTONE_BLOCK_PLACE = define("block.dripstone_block.place");
    public static final Sound BLOCK_DRIPSTONE_BLOCK_HIT = define("block.dripstone_block.hit");
    public static final Sound BLOCK_DRIPSTONE_BLOCK_FALL = define("block.dripstone_block.fall");
    public static final Sound BLOCK_POINTED_DRIPSTONE_BREAK = define("block.pointed_dripstone.break");
    public static final Sound BLOCK_POINTED_DRIPSTONE_STEP = define("block.pointed_dripstone.step");
    public static final Sound BLOCK_POINTED_DRIPSTONE_PLACE = define("block.pointed_dripstone.place");
    public static final Sound BLOCK_POINTED_DRIPSTONE_HIT = define("block.pointed_dripstone.hit");
    public static final Sound BLOCK_POINTED_DRIPSTONE_FALL = define("block.pointed_dripstone.fall");
    public static final Sound BLOCK_POINTED_DRIPSTONE_LAND = define("block.pointed_dripstone.land");
    public static final Sound BLOCK_POINTED_DRIPSTONE_DRIP_LAVA = define("block.pointed_dripstone.drip_lava");
    public static final Sound BLOCK_POINTED_DRIPSTONE_DRIP_WATER = define("block.pointed_dripstone.drip_water");
    public static final Sound BLOCK_POINTED_DRIPSTONE_DRIP_LAVA_INTO_CAULDRON = define("block.pointed_dripstone.drip_lava_into_cauldron");
    public static final Sound BLOCK_POINTED_DRIPSTONE_DRIP_WATER_INTO_CAULDRON = define("block.pointed_dripstone.drip_water_into_cauldron");
    public static final Sound BLOCK_BIG_DRIPLEAF_TILT_DOWN = define("block.big_dripleaf.tilt_down");
    public static final Sound BLOCK_BIG_DRIPLEAF_TILT_UP = define("block.big_dripleaf.tilt_up");
    public static final Sound ENTITY_DROWNED_AMBIENT = define("entity.drowned.ambient");
    public static final Sound ENTITY_DROWNED_AMBIENT_WATER = define("entity.drowned.ambient_water");
    public static final Sound ENTITY_DROWNED_DEATH = define("entity.drowned.death");
    public static final Sound ENTITY_DROWNED_DEATH_WATER = define("entity.drowned.death_water");
    public static final Sound ENTITY_DROWNED_HURT = define("entity.drowned.hurt");
    public static final Sound ENTITY_DROWNED_HURT_WATER = define("entity.drowned.hurt_water");
    public static final Sound ENTITY_DROWNED_SHOOT = define("entity.drowned.shoot");
    public static final Sound ENTITY_DROWNED_STEP = define("entity.drowned.step");
    public static final Sound ENTITY_DROWNED_SWIM = define("entity.drowned.swim");
    public static final Sound ITEM_DYE_USE = define("item.dye.use");
    public static final Sound ENTITY_EGG_THROW = define("entity.egg.throw");
    public static final Sound ENTITY_ELDER_GUARDIAN_AMBIENT = define("entity.elder_guardian.ambient");
    public static final Sound ENTITY_ELDER_GUARDIAN_AMBIENT_LAND = define("entity.elder_guardian.ambient_land");
    public static final Sound ENTITY_ELDER_GUARDIAN_CURSE = define("entity.elder_guardian.curse");
    public static final Sound ENTITY_ELDER_GUARDIAN_DEATH = define("entity.elder_guardian.death");
    public static final Sound ENTITY_ELDER_GUARDIAN_DEATH_LAND = define("entity.elder_guardian.death_land");
    public static final Sound ENTITY_ELDER_GUARDIAN_FLOP = define("entity.elder_guardian.flop");
    public static final Sound ENTITY_ELDER_GUARDIAN_HURT = define("entity.elder_guardian.hurt");
    public static final Sound ENTITY_ELDER_GUARDIAN_HURT_LAND = define("entity.elder_guardian.hurt_land");
    public static final Sound ITEM_ELYTRA_FLYING = define("item.elytra.flying");
    public static final Sound BLOCK_ENCHANTMENT_TABLE_USE = define("block.enchantment_table.use");
    public static final Sound BLOCK_ENDER_CHEST_CLOSE = define("block.ender_chest.close");
    public static final Sound BLOCK_ENDER_CHEST_OPEN = define("block.ender_chest.open");
    public static final Sound ENTITY_ENDER_DRAGON_AMBIENT = define("entity.ender_dragon.ambient");
    public static final Sound ENTITY_ENDER_DRAGON_DEATH = define("entity.ender_dragon.death");
    public static final Sound ENTITY_DRAGON_FIREBALL_EXPLODE = define("entity.dragon_fireball.explode");
    public static final Sound ENTITY_ENDER_DRAGON_FLAP = define("entity.ender_dragon.flap");
    public static final Sound ENTITY_ENDER_DRAGON_GROWL = define("entity.ender_dragon.growl");
    public static final Sound ENTITY_ENDER_DRAGON_HURT = define("entity.ender_dragon.hurt");
    public static final Sound ENTITY_ENDER_DRAGON_SHOOT = define("entity.ender_dragon.shoot");
    public static final Sound ENTITY_ENDER_EYE_DEATH = define("entity.ender_eye.death");
    public static final Sound ENTITY_ENDER_EYE_LAUNCH = define("entity.ender_eye.launch");
    public static final Sound ENTITY_ENDERMAN_AMBIENT = define("entity.enderman.ambient");
    public static final Sound ENTITY_ENDERMAN_DEATH = define("entity.enderman.death");
    public static final Sound ENTITY_ENDERMAN_HURT = define("entity.enderman.hurt");
    public static final Sound ENTITY_ENDERMAN_SCREAM = define("entity.enderman.scream");
    public static final Sound ENTITY_ENDERMAN_STARE = define("entity.enderman.stare");
    public static final Sound ENTITY_ENDERMAN_TELEPORT = define("entity.enderman.teleport");
    public static final Sound ENTITY_ENDERMITE_AMBIENT = define("entity.endermite.ambient");
    public static final Sound ENTITY_ENDERMITE_DEATH = define("entity.endermite.death");
    public static final Sound ENTITY_ENDERMITE_HURT = define("entity.endermite.hurt");
    public static final Sound ENTITY_ENDERMITE_STEP = define("entity.endermite.step");
    public static final Sound ENTITY_ENDER_PEARL_THROW = define("entity.ender_pearl.throw");
    public static final Sound BLOCK_END_GATEWAY_SPAWN = define("block.end_gateway.spawn");
    public static final Sound BLOCK_END_PORTAL_FRAME_FILL = define("block.end_portal_frame.fill");
    public static final Sound BLOCK_END_PORTAL_SPAWN = define("block.end_portal.spawn");
    public static final Sound ENTITY_EVOKER_AMBIENT = define("entity.evoker.ambient");
    public static final Sound ENTITY_EVOKER_CAST_SPELL = define("entity.evoker.cast_spell");
    public static final Sound ENTITY_EVOKER_CELEBRATE = define("entity.evoker.celebrate");
    public static final Sound ENTITY_EVOKER_DEATH = define("entity.evoker.death");
    public static final Sound ENTITY_EVOKER_FANGS_ATTACK = define("entity.evoker_fangs.attack");
    public static final Sound ENTITY_EVOKER_HURT = define("entity.evoker.hurt");
    public static final Sound ENTITY_EVOKER_PREPARE_ATTACK = define("entity.evoker.prepare_attack");
    public static final Sound ENTITY_EVOKER_PREPARE_SUMMON = define("entity.evoker.prepare_summon");
    public static final Sound ENTITY_EVOKER_PREPARE_WOLOLO = define("entity.evoker.prepare_wololo");
    public static final Sound ENTITY_EXPERIENCE_BOTTLE_THROW = define("entity.experience_bottle.throw");
    public static final Sound ENTITY_EXPERIENCE_ORB_PICKUP = define("entity.experience_orb.pickup");
    public static final Sound BLOCK_FENCE_GATE_CLOSE = define("block.fence_gate.close");
    public static final Sound BLOCK_FENCE_GATE_OPEN = define("block.fence_gate.open");
    public static final Sound ITEM_FIRECHARGE_USE = define("item.firecharge.use");
    public static final Sound ENTITY_FIREWORK_ROCKET_BLAST = define("entity.firework_rocket.blast");
    public static final Sound ENTITY_FIREWORK_ROCKET_BLAST_FAR = define("entity.firework_rocket.blast_far");
    public static final Sound ENTITY_FIREWORK_ROCKET_LARGE_BLAST = define("entity.firework_rocket.large_blast");
    public static final Sound ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR = define("entity.firework_rocket.large_blast_far");
    public static final Sound ENTITY_FIREWORK_ROCKET_LAUNCH = define("entity.firework_rocket.launch");
    public static final Sound ENTITY_FIREWORK_ROCKET_SHOOT = define("entity.firework_rocket.shoot");
    public static final Sound ENTITY_FIREWORK_ROCKET_TWINKLE = define("entity.firework_rocket.twinkle");
    public static final Sound ENTITY_FIREWORK_ROCKET_TWINKLE_FAR = define("entity.firework_rocket.twinkle_far");
    public static final Sound BLOCK_FIRE_AMBIENT = define("block.fire.ambient");
    public static final Sound BLOCK_FIRE_EXTINGUISH = define("block.fire.extinguish");
    public static final Sound ENTITY_FISH_SWIM = define("entity.fish.swim");
    public static final Sound ENTITY_FISHING_BOBBER_RETRIEVE = define("entity.fishing_bobber.retrieve");
    public static final Sound ENTITY_FISHING_BOBBER_SPLASH = define("entity.fishing_bobber.splash");
    public static final Sound ENTITY_FISHING_BOBBER_THROW = define("entity.fishing_bobber.throw");
    public static final Sound ITEM_FLINTANDSTEEL_USE = define("item.flintandsteel.use");
    public static final Sound BLOCK_FLOWERING_AZALEA_BREAK = define("block.flowering_azalea.break");
    public static final Sound BLOCK_FLOWERING_AZALEA_FALL = define("block.flowering_azalea.fall");
    public static final Sound BLOCK_FLOWERING_AZALEA_HIT = define("block.flowering_azalea.hit");
    public static final Sound BLOCK_FLOWERING_AZALEA_PLACE = define("block.flowering_azalea.place");
    public static final Sound BLOCK_FLOWERING_AZALEA_STEP = define("block.flowering_azalea.step");
    public static final Sound ENTITY_FOX_AGGRO = define("entity.fox.aggro");
    public static final Sound ENTITY_FOX_AMBIENT = define("entity.fox.ambient");
    public static final Sound ENTITY_FOX_BITE = define("entity.fox.bite");
    public static final Sound ENTITY_FOX_DEATH = define("entity.fox.death");
    public static final Sound ENTITY_FOX_EAT = define("entity.fox.eat");
    public static final Sound ENTITY_FOX_HURT = define("entity.fox.hurt");
    public static final Sound ENTITY_FOX_SCREECH = define("entity.fox.screech");
    public static final Sound ENTITY_FOX_SLEEP = define("entity.fox.sleep");
    public static final Sound ENTITY_FOX_SNIFF = define("entity.fox.sniff");
    public static final Sound ENTITY_FOX_SPIT = define("entity.fox.spit");
    public static final Sound ENTITY_FOX_TELEPORT = define("entity.fox.teleport");
    public static final Sound BLOCK_SUSPICIOUS_SAND_BREAK = define("block.suspicious_sand.break");
    public static final Sound BLOCK_SUSPICIOUS_SAND_STEP = define("block.suspicious_sand.step");
    public static final Sound BLOCK_SUSPICIOUS_SAND_PLACE = define("block.suspicious_sand.place");
    public static final Sound BLOCK_SUSPICIOUS_SAND_HIT = define("block.suspicious_sand.hit");
    public static final Sound BLOCK_SUSPICIOUS_SAND_FALL = define("block.suspicious_sand.fall");
    public static final Sound BLOCK_SUSPICIOUS_GRAVEL_BREAK = define("block.suspicious_gravel.break");
    public static final Sound BLOCK_SUSPICIOUS_GRAVEL_STEP = define("block.suspicious_gravel.step");
    public static final Sound BLOCK_SUSPICIOUS_GRAVEL_PLACE = define("block.suspicious_gravel.place");
    public static final Sound BLOCK_SUSPICIOUS_GRAVEL_HIT = define("block.suspicious_gravel.hit");
    public static final Sound BLOCK_SUSPICIOUS_GRAVEL_FALL = define("block.suspicious_gravel.fall");
    public static final Sound BLOCK_FROGLIGHT_BREAK = define("block.froglight.break");
    public static final Sound BLOCK_FROGLIGHT_FALL = define("block.froglight.fall");
    public static final Sound BLOCK_FROGLIGHT_HIT = define("block.froglight.hit");
    public static final Sound BLOCK_FROGLIGHT_PLACE = define("block.froglight.place");
    public static final Sound BLOCK_FROGLIGHT_STEP = define("block.froglight.step");
    public static final Sound BLOCK_FROGSPAWN_STEP = define("block.frogspawn.step");
    public static final Sound BLOCK_FROGSPAWN_BREAK = define("block.frogspawn.break");
    public static final Sound BLOCK_FROGSPAWN_FALL = define("block.frogspawn.fall");
    public static final Sound BLOCK_FROGSPAWN_HATCH = define("block.frogspawn.hatch");
    public static final Sound BLOCK_FROGSPAWN_HIT = define("block.frogspawn.hit");
    public static final Sound BLOCK_FROGSPAWN_PLACE = define("block.frogspawn.place");
    public static final Sound ENTITY_FROG_AMBIENT = define("entity.frog.ambient");
    public static final Sound ENTITY_FROG_DEATH = define("entity.frog.death");
    public static final Sound ENTITY_FROG_EAT = define("entity.frog.eat");
    public static final Sound ENTITY_FROG_HURT = define("entity.frog.hurt");
    public static final Sound ENTITY_FROG_LAY_SPAWN = define("entity.frog.lay_spawn");
    public static final Sound ENTITY_FROG_LONG_JUMP = define("entity.frog.long_jump");
    public static final Sound ENTITY_FROG_STEP = define("entity.frog.step");
    public static final Sound ENTITY_FROG_TONGUE = define("entity.frog.tongue");
    public static final Sound BLOCK_ROOTS_BREAK = define("block.roots.break");
    public static final Sound BLOCK_ROOTS_STEP = define("block.roots.step");
    public static final Sound BLOCK_ROOTS_PLACE = define("block.roots.place");
    public static final Sound BLOCK_ROOTS_HIT = define("block.roots.hit");
    public static final Sound BLOCK_ROOTS_FALL = define("block.roots.fall");
    public static final Sound BLOCK_FURNACE_FIRE_CRACKLE = define("block.furnace.fire_crackle");
    public static final Sound ENTITY_GENERIC_BIG_FALL = define("entity.generic.big_fall");
    public static final Sound ENTITY_GENERIC_BURN = define("entity.generic.burn");
    public static final Sound ENTITY_GENERIC_DEATH = define("entity.generic.death");
    public static final Sound ENTITY_GENERIC_DRINK = define("entity.generic.drink");
    public static final Sound ENTITY_GENERIC_EAT = define("entity.generic.eat");
    public static final Sound ENTITY_GENERIC_EXPLODE = define("entity.generic.explode");
    public static final Sound ENTITY_GENERIC_EXTINGUISH_FIRE = define("entity.generic.extinguish_fire");
    public static final Sound ENTITY_GENERIC_HURT = define("entity.generic.hurt");
    public static final Sound ENTITY_GENERIC_SMALL_FALL = define("entity.generic.small_fall");
    public static final Sound ENTITY_GENERIC_SPLASH = define("entity.generic.splash");
    public static final Sound ENTITY_GENERIC_SWIM = define("entity.generic.swim");
    public static final Sound ENTITY_GHAST_AMBIENT = define("entity.ghast.ambient");
    public static final Sound ENTITY_GHAST_DEATH = define("entity.ghast.death");
    public static final Sound ENTITY_GHAST_HURT = define("entity.ghast.hurt");
    public static final Sound ENTITY_GHAST_SCREAM = define("entity.ghast.scream");
    public static final Sound ENTITY_GHAST_SHOOT = define("entity.ghast.shoot");
    public static final Sound ENTITY_GHAST_WARN = define("entity.ghast.warn");
    public static final Sound BLOCK_GILDED_BLACKSTONE_BREAK = define("block.gilded_blackstone.break");
    public static final Sound BLOCK_GILDED_BLACKSTONE_FALL = define("block.gilded_blackstone.fall");
    public static final Sound BLOCK_GILDED_BLACKSTONE_HIT = define("block.gilded_blackstone.hit");
    public static final Sound BLOCK_GILDED_BLACKSTONE_PLACE = define("block.gilded_blackstone.place");
    public static final Sound BLOCK_GILDED_BLACKSTONE_STEP = define("block.gilded_blackstone.step");
    public static final Sound BLOCK_GLASS_BREAK = define("block.glass.break");
    public static final Sound BLOCK_GLASS_FALL = define("block.glass.fall");
    public static final Sound BLOCK_GLASS_HIT = define("block.glass.hit");
    public static final Sound BLOCK_GLASS_PLACE = define("block.glass.place");
    public static final Sound BLOCK_GLASS_STEP = define("block.glass.step");
    public static final Sound ITEM_GLOW_INK_SAC_USE = define("item.glow_ink_sac.use");
    public static final Sound ENTITY_GLOW_ITEM_FRAME_ADD_ITEM = define("entity.glow_item_frame.add_item");
    public static final Sound ENTITY_GLOW_ITEM_FRAME_BREAK = define("entity.glow_item_frame.break");
    public static final Sound ENTITY_GLOW_ITEM_FRAME_PLACE = define("entity.glow_item_frame.place");
    public static final Sound ENTITY_GLOW_ITEM_FRAME_REMOVE_ITEM = define("entity.glow_item_frame.remove_item");
    public static final Sound ENTITY_GLOW_ITEM_FRAME_ROTATE_ITEM = define("entity.glow_item_frame.rotate_item");
    public static final Sound ENTITY_GLOW_SQUID_AMBIENT = define("entity.glow_squid.ambient");
    public static final Sound ENTITY_GLOW_SQUID_DEATH = define("entity.glow_squid.death");
    public static final Sound ENTITY_GLOW_SQUID_HURT = define("entity.glow_squid.hurt");
    public static final Sound ENTITY_GLOW_SQUID_SQUIRT = define("entity.glow_squid.squirt");
    public static final Sound ENTITY_GOAT_AMBIENT = define("entity.goat.ambient");
    public static final Sound ENTITY_GOAT_DEATH = define("entity.goat.death");
    public static final Sound ENTITY_GOAT_EAT = define("entity.goat.eat");
    public static final Sound ENTITY_GOAT_HURT = define("entity.goat.hurt");
    public static final Sound ENTITY_GOAT_LONG_JUMP = define("entity.goat.long_jump");
    public static final Sound ENTITY_GOAT_MILK = define("entity.goat.milk");
    public static final Sound ENTITY_GOAT_PREPARE_RAM = define("entity.goat.prepare_ram");
    public static final Sound ENTITY_GOAT_RAM_IMPACT = define("entity.goat.ram_impact");
    public static final Sound ENTITY_GOAT_HORN_BREAK = define("entity.goat.horn_break");
    /**
     * Removed with 1.21.2
     */
    @ApiStatus.Obsolete
    public static final Sound ITEM_GOAT_HORN_PLAY = define("item.goat_horn.play");
    public static final Sound ENTITY_GOAT_SCREAMING_AMBIENT = define("entity.goat.screaming.ambient");
    public static final Sound ENTITY_GOAT_SCREAMING_DEATH = define("entity.goat.screaming.death");
    public static final Sound ENTITY_GOAT_SCREAMING_EAT = define("entity.goat.screaming.eat");
    public static final Sound ENTITY_GOAT_SCREAMING_HURT = define("entity.goat.screaming.hurt");
    public static final Sound ENTITY_GOAT_SCREAMING_LONG_JUMP = define("entity.goat.screaming.long_jump");
    public static final Sound ENTITY_GOAT_SCREAMING_MILK = define("entity.goat.screaming.milk");
    public static final Sound ENTITY_GOAT_SCREAMING_PREPARE_RAM = define("entity.goat.screaming.prepare_ram");
    public static final Sound ENTITY_GOAT_SCREAMING_RAM_IMPACT = define("entity.goat.screaming.ram_impact");
    /**
     * Removed with 1.21.2
     */
    @ApiStatus.Obsolete
    public static final Sound ENTITY_GOAT_SCREAMING_HORN_BREAK = define("entity.goat.screaming.horn_break");
    public static final Sound ENTITY_GOAT_STEP = define("entity.goat.step");
    public static final Sound BLOCK_GRASS_BREAK = define("block.grass.break");
    public static final Sound BLOCK_GRASS_FALL = define("block.grass.fall");
    public static final Sound BLOCK_GRASS_HIT = define("block.grass.hit");
    public static final Sound BLOCK_GRASS_PLACE = define("block.grass.place");
    public static final Sound BLOCK_GRASS_STEP = define("block.grass.step");
    public static final Sound BLOCK_GRAVEL_BREAK = define("block.gravel.break");
    public static final Sound BLOCK_GRAVEL_FALL = define("block.gravel.fall");
    public static final Sound BLOCK_GRAVEL_HIT = define("block.gravel.hit");
    public static final Sound BLOCK_GRAVEL_PLACE = define("block.gravel.place");
    public static final Sound BLOCK_GRAVEL_STEP = define("block.gravel.step");
    public static final Sound BLOCK_GRINDSTONE_USE = define("block.grindstone.use");
    public static final Sound BLOCK_GROWING_PLANT_CROP = define("block.growing_plant.crop");
    public static final Sound ENTITY_GUARDIAN_AMBIENT = define("entity.guardian.ambient");
    public static final Sound ENTITY_GUARDIAN_AMBIENT_LAND = define("entity.guardian.ambient_land");
    public static final Sound ENTITY_GUARDIAN_ATTACK = define("entity.guardian.attack");
    public static final Sound ENTITY_GUARDIAN_DEATH = define("entity.guardian.death");
    public static final Sound ENTITY_GUARDIAN_DEATH_LAND = define("entity.guardian.death_land");
    public static final Sound ENTITY_GUARDIAN_FLOP = define("entity.guardian.flop");
    public static final Sound ENTITY_GUARDIAN_HURT = define("entity.guardian.hurt");
    public static final Sound ENTITY_GUARDIAN_HURT_LAND = define("entity.guardian.hurt_land");
    public static final Sound BLOCK_HANGING_ROOTS_BREAK = define("block.hanging_roots.break");
    public static final Sound BLOCK_HANGING_ROOTS_FALL = define("block.hanging_roots.fall");
    public static final Sound BLOCK_HANGING_ROOTS_HIT = define("block.hanging_roots.hit");
    public static final Sound BLOCK_HANGING_ROOTS_PLACE = define("block.hanging_roots.place");
    public static final Sound BLOCK_HANGING_ROOTS_STEP = define("block.hanging_roots.step");
    public static final Sound BLOCK_HANGING_SIGN_STEP = define("block.hanging_sign.step");
    public static final Sound BLOCK_HANGING_SIGN_BREAK = define("block.hanging_sign.break");
    public static final Sound BLOCK_HANGING_SIGN_FALL = define("block.hanging_sign.fall");
    public static final Sound BLOCK_HANGING_SIGN_HIT = define("block.hanging_sign.hit");
    public static final Sound BLOCK_HANGING_SIGN_PLACE = define("block.hanging_sign.place");
    public static final Sound BLOCK_HEAVY_CORE_BREAK = define("block.heavy_core.break");
    public static final Sound BLOCK_HEAVY_CORE_FALL = define("block.heavy_core.fall");
    public static final Sound BLOCK_HEAVY_CORE_HIT = define("block.heavy_core.hit");
    public static final Sound BLOCK_HEAVY_CORE_PLACE = define("block.heavy_core.place");
    public static final Sound BLOCK_HEAVY_CORE_STEP = define("block.heavy_core.step");
    public static final Sound BLOCK_NETHER_WOOD_HANGING_SIGN_STEP = define("block.nether_wood_hanging_sign.step");
    public static final Sound BLOCK_NETHER_WOOD_HANGING_SIGN_BREAK = define("block.nether_wood_hanging_sign.break");
    public static final Sound BLOCK_NETHER_WOOD_HANGING_SIGN_FALL = define("block.nether_wood_hanging_sign.fall");
    public static final Sound BLOCK_NETHER_WOOD_HANGING_SIGN_HIT = define("block.nether_wood_hanging_sign.hit");
    public static final Sound BLOCK_NETHER_WOOD_HANGING_SIGN_PLACE = define("block.nether_wood_hanging_sign.place");
    public static final Sound BLOCK_BAMBOO_WOOD_HANGING_SIGN_STEP = define("block.bamboo_wood_hanging_sign.step");
    public static final Sound BLOCK_BAMBOO_WOOD_HANGING_SIGN_BREAK = define("block.bamboo_wood_hanging_sign.break");
    public static final Sound BLOCK_BAMBOO_WOOD_HANGING_SIGN_FALL = define("block.bamboo_wood_hanging_sign.fall");
    public static final Sound BLOCK_BAMBOO_WOOD_HANGING_SIGN_HIT = define("block.bamboo_wood_hanging_sign.hit");
    public static final Sound BLOCK_BAMBOO_WOOD_HANGING_SIGN_PLACE = define("block.bamboo_wood_hanging_sign.place");
    public static final Sound BLOCK_TRIAL_SPAWNER_BREAK = define("block.trial_spawner.break");
    public static final Sound BLOCK_TRIAL_SPAWNER_STEP = define("block.trial_spawner.step");
    public static final Sound BLOCK_TRIAL_SPAWNER_PLACE = define("block.trial_spawner.place");
    public static final Sound BLOCK_TRIAL_SPAWNER_HIT = define("block.trial_spawner.hit");
    public static final Sound BLOCK_TRIAL_SPAWNER_FALL = define("block.trial_spawner.fall");
    public static final Sound BLOCK_TRIAL_SPAWNER_SPAWN_MOB = define("block.trial_spawner.spawn_mob");
    public static final Sound BLOCK_TRIAL_SPAWNER_ABOUT_TO_SPAWN_ITEM = define("block.trial_spawner.about_to_spawn_item");
    public static final Sound BLOCK_TRIAL_SPAWNER_SPAWN_ITEM = define("block.trial_spawner.spawn_item");
    public static final Sound BLOCK_TRIAL_SPAWNER_SPAWN_ITEM_BEGIN = define("block.trial_spawner.spawn_item_begin");
    public static final Sound BLOCK_TRIAL_SPAWNER_DETECT_PLAYER = define("block.trial_spawner.detect_player");
    public static final Sound BLOCK_TRIAL_SPAWNER_OMINOUS_ACTIVATE = define("block.trial_spawner.ominous_activate");
    public static final Sound BLOCK_TRIAL_SPAWNER_AMBIENT = define("block.trial_spawner.ambient");
    public static final Sound BLOCK_TRIAL_SPAWNER_AMBIENT_OMINOUS = define("block.trial_spawner.ambient_ominous");
    public static final Sound BLOCK_TRIAL_SPAWNER_OPEN_SHUTTER = define("block.trial_spawner.open_shutter");
    public static final Sound BLOCK_TRIAL_SPAWNER_CLOSE_SHUTTER = define("block.trial_spawner.close_shutter");
    public static final Sound BLOCK_TRIAL_SPAWNER_EJECT_ITEM = define("block.trial_spawner.eject_item");
    public static final Sound ITEM_HOE_TILL = define("item.hoe.till");
    public static final Sound ENTITY_HOGLIN_AMBIENT = define("entity.hoglin.ambient");
    public static final Sound ENTITY_HOGLIN_ANGRY = define("entity.hoglin.angry");
    public static final Sound ENTITY_HOGLIN_ATTACK = define("entity.hoglin.attack");
    public static final Sound ENTITY_HOGLIN_CONVERTED_TO_ZOMBIFIED = define("entity.hoglin.converted_to_zombified");
    public static final Sound ENTITY_HOGLIN_DEATH = define("entity.hoglin.death");
    public static final Sound ENTITY_HOGLIN_HURT = define("entity.hoglin.hurt");
    public static final Sound ENTITY_HOGLIN_RETREAT = define("entity.hoglin.retreat");
    public static final Sound ENTITY_HOGLIN_STEP = define("entity.hoglin.step");
    public static final Sound BLOCK_HONEY_BLOCK_BREAK = define("block.honey_block.break");
    public static final Sound BLOCK_HONEY_BLOCK_FALL = define("block.honey_block.fall");
    public static final Sound BLOCK_HONEY_BLOCK_HIT = define("block.honey_block.hit");
    public static final Sound BLOCK_HONEY_BLOCK_PLACE = define("block.honey_block.place");
    public static final Sound BLOCK_HONEY_BLOCK_SLIDE = define("block.honey_block.slide");
    public static final Sound BLOCK_HONEY_BLOCK_STEP = define("block.honey_block.step");
    public static final Sound ITEM_HONEYCOMB_WAX_ON = define("item.honeycomb.wax_on");
    public static final Sound ITEM_HONEY_BOTTLE_DRINK = define("item.honey_bottle.drink");
    public static final Sound ITEM_GOAT_HORN_SOUND_0 = define("item.goat_horn.sound.0");
    public static final Sound ITEM_GOAT_HORN_SOUND_1 = define("item.goat_horn.sound.1");
    public static final Sound ITEM_GOAT_HORN_SOUND_2 = define("item.goat_horn.sound.2");
    public static final Sound ITEM_GOAT_HORN_SOUND_3 = define("item.goat_horn.sound.3");
    public static final Sound ITEM_GOAT_HORN_SOUND_4 = define("item.goat_horn.sound.4");
    public static final Sound ITEM_GOAT_HORN_SOUND_5 = define("item.goat_horn.sound.5");
    public static final Sound ITEM_GOAT_HORN_SOUND_6 = define("item.goat_horn.sound.6");
    public static final Sound ITEM_GOAT_HORN_SOUND_7 = define("item.goat_horn.sound.7");
    public static final Sound ENTITY_HORSE_AMBIENT = define("entity.horse.ambient");
    public static final Sound ENTITY_HORSE_ANGRY = define("entity.horse.angry");
    public static final Sound ENTITY_HORSE_ARMOR = define("entity.horse.armor");
    public static final Sound ENTITY_HORSE_BREATHE = define("entity.horse.breathe");
    public static final Sound ENTITY_HORSE_DEATH = define("entity.horse.death");
    public static final Sound ENTITY_HORSE_EAT = define("entity.horse.eat");
    public static final Sound ENTITY_HORSE_GALLOP = define("entity.horse.gallop");
    public static final Sound ENTITY_HORSE_HURT = define("entity.horse.hurt");
    public static final Sound ENTITY_HORSE_JUMP = define("entity.horse.jump");
    public static final Sound ENTITY_HORSE_LAND = define("entity.horse.land");
    public static final Sound ENTITY_HORSE_SADDLE = define("entity.horse.saddle");
    public static final Sound ENTITY_HORSE_STEP = define("entity.horse.step");
    public static final Sound ENTITY_HORSE_STEP_WOOD = define("entity.horse.step_wood");
    public static final Sound ENTITY_HOSTILE_BIG_FALL = define("entity.hostile.big_fall");
    public static final Sound ENTITY_HOSTILE_DEATH = define("entity.hostile.death");
    public static final Sound ENTITY_HOSTILE_HURT = define("entity.hostile.hurt");
    public static final Sound ENTITY_HOSTILE_SMALL_FALL = define("entity.hostile.small_fall");
    public static final Sound ENTITY_HOSTILE_SPLASH = define("entity.hostile.splash");
    public static final Sound ENTITY_HOSTILE_SWIM = define("entity.hostile.swim");
    public static final Sound ENTITY_HUSK_AMBIENT = define("entity.husk.ambient");
    public static final Sound ENTITY_HUSK_CONVERTED_TO_ZOMBIE = define("entity.husk.converted_to_zombie");
    public static final Sound ENTITY_HUSK_DEATH = define("entity.husk.death");
    public static final Sound ENTITY_HUSK_HURT = define("entity.husk.hurt");
    public static final Sound ENTITY_HUSK_STEP = define("entity.husk.step");
    public static final Sound ENTITY_ILLUSIONER_AMBIENT = define("entity.illusioner.ambient");
    public static final Sound ENTITY_ILLUSIONER_CAST_SPELL = define("entity.illusioner.cast_spell");
    public static final Sound ENTITY_ILLUSIONER_DEATH = define("entity.illusioner.death");
    public static final Sound ENTITY_ILLUSIONER_HURT = define("entity.illusioner.hurt");
    public static final Sound ENTITY_ILLUSIONER_MIRROR_MOVE = define("entity.illusioner.mirror_move");
    public static final Sound ENTITY_ILLUSIONER_PREPARE_BLINDNESS = define("entity.illusioner.prepare_blindness");
    public static final Sound ENTITY_ILLUSIONER_PREPARE_MIRROR = define("entity.illusioner.prepare_mirror");
    public static final Sound ITEM_INK_SAC_USE = define("item.ink_sac.use");
    public static final Sound BLOCK_IRON_DOOR_CLOSE = define("block.iron_door.close");
    public static final Sound BLOCK_IRON_DOOR_OPEN = define("block.iron_door.open");
    public static final Sound ENTITY_IRON_GOLEM_ATTACK = define("entity.iron_golem.attack");
    public static final Sound ENTITY_IRON_GOLEM_DAMAGE = define("entity.iron_golem.damage");
    public static final Sound ENTITY_IRON_GOLEM_DEATH = define("entity.iron_golem.death");
    public static final Sound ENTITY_IRON_GOLEM_HURT = define("entity.iron_golem.hurt");
    public static final Sound ENTITY_IRON_GOLEM_REPAIR = define("entity.iron_golem.repair");
    public static final Sound ENTITY_IRON_GOLEM_STEP = define("entity.iron_golem.step");
    public static final Sound BLOCK_IRON_TRAPDOOR_CLOSE = define("block.iron_trapdoor.close");
    public static final Sound BLOCK_IRON_TRAPDOOR_OPEN = define("block.iron_trapdoor.open");
    public static final Sound ENTITY_ITEM_FRAME_ADD_ITEM = define("entity.item_frame.add_item");
    public static final Sound ENTITY_ITEM_FRAME_BREAK = define("entity.item_frame.break");
    public static final Sound ENTITY_ITEM_FRAME_PLACE = define("entity.item_frame.place");
    public static final Sound ENTITY_ITEM_FRAME_REMOVE_ITEM = define("entity.item_frame.remove_item");
    public static final Sound ENTITY_ITEM_FRAME_ROTATE_ITEM = define("entity.item_frame.rotate_item");
    public static final Sound ENTITY_ITEM_BREAK = define("entity.item.break");
    public static final Sound ENTITY_ITEM_PICKUP = define("entity.item.pickup");
    public static final Sound BLOCK_LADDER_BREAK = define("block.ladder.break");
    public static final Sound BLOCK_LADDER_FALL = define("block.ladder.fall");
    public static final Sound BLOCK_LADDER_HIT = define("block.ladder.hit");
    public static final Sound BLOCK_LADDER_PLACE = define("block.ladder.place");
    public static final Sound BLOCK_LADDER_STEP = define("block.ladder.step");
    public static final Sound BLOCK_LANTERN_BREAK = define("block.lantern.break");
    public static final Sound BLOCK_LANTERN_FALL = define("block.lantern.fall");
    public static final Sound BLOCK_LANTERN_HIT = define("block.lantern.hit");
    public static final Sound BLOCK_LANTERN_PLACE = define("block.lantern.place");
    public static final Sound BLOCK_LANTERN_STEP = define("block.lantern.step");
    public static final Sound BLOCK_LARGE_AMETHYST_BUD_BREAK = define("block.large_amethyst_bud.break");
    public static final Sound BLOCK_LARGE_AMETHYST_BUD_PLACE = define("block.large_amethyst_bud.place");
    public static final Sound BLOCK_LAVA_AMBIENT = define("block.lava.ambient");
    public static final Sound BLOCK_LAVA_EXTINGUISH = define("block.lava.extinguish");
    public static final Sound BLOCK_LAVA_POP = define("block.lava.pop");
    /**
     * Removed with 1.21.6
     */
    @ApiStatus.Obsolete
    public static final Sound ENTITY_LEASH_KNOT_BREAK = define("entity.leash_knot.break");
    /**
     * Removed with 1.21.6
     */
    @ApiStatus.Obsolete
    public static final Sound ENTITY_LEASH_KNOT_PLACE = define("entity.leash_knot.place");
    public static final Sound BLOCK_LEVER_CLICK = define("block.lever.click");
    public static final Sound ENTITY_LIGHTNING_BOLT_IMPACT = define("entity.lightning_bolt.impact");
    public static final Sound ENTITY_LIGHTNING_BOLT_THUNDER = define("entity.lightning_bolt.thunder");
    public static final Sound ENTITY_LINGERING_POTION_THROW = define("entity.lingering_potion.throw");
    public static final Sound ENTITY_LLAMA_AMBIENT = define("entity.llama.ambient");
    public static final Sound ENTITY_LLAMA_ANGRY = define("entity.llama.angry");
    public static final Sound ENTITY_LLAMA_CHEST = define("entity.llama.chest");
    public static final Sound ENTITY_LLAMA_DEATH = define("entity.llama.death");
    public static final Sound ENTITY_LLAMA_EAT = define("entity.llama.eat");
    public static final Sound ENTITY_LLAMA_HURT = define("entity.llama.hurt");
    public static final Sound ENTITY_LLAMA_SPIT = define("entity.llama.spit");
    public static final Sound ENTITY_LLAMA_STEP = define("entity.llama.step");
    public static final Sound ENTITY_LLAMA_SWAG = define("entity.llama.swag");
    public static final Sound ENTITY_MAGMA_CUBE_DEATH_SMALL = define("entity.magma_cube.death_small");
    public static final Sound BLOCK_LODESTONE_BREAK = define("block.lodestone.break");
    public static final Sound BLOCK_LODESTONE_STEP = define("block.lodestone.step");
    public static final Sound BLOCK_LODESTONE_PLACE = define("block.lodestone.place");
    public static final Sound BLOCK_LODESTONE_HIT = define("block.lodestone.hit");
    public static final Sound BLOCK_LODESTONE_FALL = define("block.lodestone.fall");
    public static final Sound ITEM_LODESTONE_COMPASS_LOCK = define("item.lodestone_compass.lock");
    public static final Sound ITEM_MACE_SMASH_AIR = define("item.mace.smash_air");
    public static final Sound ITEM_MACE_SMASH_GROUND = define("item.mace.smash_ground");
    public static final Sound ITEM_MACE_SMASH_GROUND_HEAVY = define("item.mace.smash_ground_heavy");
    public static final Sound ENTITY_MAGMA_CUBE_DEATH = define("entity.magma_cube.death");
    public static final Sound ENTITY_MAGMA_CUBE_HURT = define("entity.magma_cube.hurt");
    public static final Sound ENTITY_MAGMA_CUBE_HURT_SMALL = define("entity.magma_cube.hurt_small");
    public static final Sound ENTITY_MAGMA_CUBE_JUMP = define("entity.magma_cube.jump");
    public static final Sound ENTITY_MAGMA_CUBE_SQUISH = define("entity.magma_cube.squish");
    public static final Sound ENTITY_MAGMA_CUBE_SQUISH_SMALL = define("entity.magma_cube.squish_small");
    public static final Sound BLOCK_MANGROVE_ROOTS_BREAK = define("block.mangrove_roots.break");
    public static final Sound BLOCK_MANGROVE_ROOTS_FALL = define("block.mangrove_roots.fall");
    public static final Sound BLOCK_MANGROVE_ROOTS_HIT = define("block.mangrove_roots.hit");
    public static final Sound BLOCK_MANGROVE_ROOTS_PLACE = define("block.mangrove_roots.place");
    public static final Sound BLOCK_MANGROVE_ROOTS_STEP = define("block.mangrove_roots.step");
    public static final Sound BLOCK_MEDIUM_AMETHYST_BUD_BREAK = define("block.medium_amethyst_bud.break");
    public static final Sound BLOCK_MEDIUM_AMETHYST_BUD_PLACE = define("block.medium_amethyst_bud.place");
    public static final Sound BLOCK_METAL_BREAK = define("block.metal.break");
    public static final Sound BLOCK_METAL_FALL = define("block.metal.fall");
    public static final Sound BLOCK_METAL_HIT = define("block.metal.hit");
    public static final Sound BLOCK_METAL_PLACE = define("block.metal.place");
    public static final Sound BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF = define("block.metal_pressure_plate.click_off");
    public static final Sound BLOCK_METAL_PRESSURE_PLATE_CLICK_ON = define("block.metal_pressure_plate.click_on");
    public static final Sound BLOCK_METAL_STEP = define("block.metal.step");
    public static final Sound ENTITY_MINECART_INSIDE_UNDERWATER = define("entity.minecart.inside.underwater");
    public static final Sound ENTITY_MINECART_INSIDE = define("entity.minecart.inside");
    public static final Sound ENTITY_MINECART_RIDING = define("entity.minecart.riding");
    public static final Sound ENTITY_MOOSHROOM_CONVERT = define("entity.mooshroom.convert");
    public static final Sound ENTITY_MOOSHROOM_EAT = define("entity.mooshroom.eat");
    public static final Sound ENTITY_MOOSHROOM_MILK = define("entity.mooshroom.milk");
    public static final Sound ENTITY_MOOSHROOM_SUSPICIOUS_MILK = define("entity.mooshroom.suspicious_milk");
    public static final Sound ENTITY_MOOSHROOM_SHEAR = define("entity.mooshroom.shear");
    public static final Sound BLOCK_MOSS_CARPET_BREAK = define("block.moss_carpet.break");
    public static final Sound BLOCK_MOSS_CARPET_FALL = define("block.moss_carpet.fall");
    public static final Sound BLOCK_MOSS_CARPET_HIT = define("block.moss_carpet.hit");
    public static final Sound BLOCK_MOSS_CARPET_PLACE = define("block.moss_carpet.place");
    public static final Sound BLOCK_MOSS_CARPET_STEP = define("block.moss_carpet.step");
    public static final Sound BLOCK_PINK_PETALS_BREAK = define("block.pink_petals.break");
    public static final Sound BLOCK_PINK_PETALS_FALL = define("block.pink_petals.fall");
    public static final Sound BLOCK_PINK_PETALS_HIT = define("block.pink_petals.hit");
    public static final Sound BLOCK_PINK_PETALS_PLACE = define("block.pink_petals.place");
    public static final Sound BLOCK_PINK_PETALS_STEP = define("block.pink_petals.step");
    public static final Sound BLOCK_MOSS_BREAK = define("block.moss.break");
    public static final Sound BLOCK_MOSS_FALL = define("block.moss.fall");
    public static final Sound BLOCK_MOSS_HIT = define("block.moss.hit");
    public static final Sound BLOCK_MOSS_PLACE = define("block.moss.place");
    public static final Sound BLOCK_MOSS_STEP = define("block.moss.step");
    public static final Sound BLOCK_MUD_BREAK = define("block.mud.break");
    public static final Sound BLOCK_MUD_FALL = define("block.mud.fall");
    public static final Sound BLOCK_MUD_HIT = define("block.mud.hit");
    public static final Sound BLOCK_MUD_PLACE = define("block.mud.place");
    public static final Sound BLOCK_MUD_STEP = define("block.mud.step");
    public static final Sound BLOCK_MUD_BRICKS_BREAK = define("block.mud_bricks.break");
    public static final Sound BLOCK_MUD_BRICKS_FALL = define("block.mud_bricks.fall");
    public static final Sound BLOCK_MUD_BRICKS_HIT = define("block.mud_bricks.hit");
    public static final Sound BLOCK_MUD_BRICKS_PLACE = define("block.mud_bricks.place");
    public static final Sound BLOCK_MUD_BRICKS_STEP = define("block.mud_bricks.step");
    public static final Sound BLOCK_MUDDY_MANGROVE_ROOTS_BREAK = define("block.muddy_mangrove_roots.break");
    public static final Sound BLOCK_MUDDY_MANGROVE_ROOTS_FALL = define("block.muddy_mangrove_roots.fall");
    public static final Sound BLOCK_MUDDY_MANGROVE_ROOTS_HIT = define("block.muddy_mangrove_roots.hit");
    public static final Sound BLOCK_MUDDY_MANGROVE_ROOTS_PLACE = define("block.muddy_mangrove_roots.place");
    public static final Sound BLOCK_MUDDY_MANGROVE_ROOTS_STEP = define("block.muddy_mangrove_roots.step");
    public static final Sound ENTITY_MULE_AMBIENT = define("entity.mule.ambient");
    public static final Sound ENTITY_MULE_ANGRY = define("entity.mule.angry");
    public static final Sound ENTITY_MULE_CHEST = define("entity.mule.chest");
    public static final Sound ENTITY_MULE_DEATH = define("entity.mule.death");
    public static final Sound ENTITY_MULE_EAT = define("entity.mule.eat");
    public static final Sound ENTITY_MULE_HURT = define("entity.mule.hurt");
    public static final Sound ENTITY_MULE_JUMP = define("entity.mule.jump");
    public static final Sound MUSIC_CREATIVE = define("music.creative");
    public static final Sound MUSIC_CREDITS = define("music.credits");
    public static final Sound MUSIC_DISC_5 = define("music_disc.5");
    public static final Sound MUSIC_DISC_11 = define("music_disc.11");
    public static final Sound MUSIC_DISC_13 = define("music_disc.13");
    public static final Sound MUSIC_DISC_BLOCKS = define("music_disc.blocks");
    public static final Sound MUSIC_DISC_CAT = define("music_disc.cat");
    public static final Sound MUSIC_DISC_CHIRP = define("music_disc.chirp");
    public static final Sound MUSIC_DISC_FAR = define("music_disc.far");
    public static final Sound MUSIC_DISC_MALL = define("music_disc.mall");
    public static final Sound MUSIC_DISC_MELLOHI = define("music_disc.mellohi");
    public static final Sound MUSIC_DISC_PIGSTEP = define("music_disc.pigstep");
    public static final Sound MUSIC_DISC_STAL = define("music_disc.stal");
    public static final Sound MUSIC_DISC_STRAD = define("music_disc.strad");
    public static final Sound MUSIC_DISC_WAIT = define("music_disc.wait");
    public static final Sound MUSIC_DISC_WARD = define("music_disc.ward");
    public static final Sound MUSIC_DISC_OTHERSIDE = define("music_disc.otherside");
    public static final Sound MUSIC_DISC_RELIC = define("music_disc.relic");
    public static final Sound MUSIC_DRAGON = define("music.dragon");
    public static final Sound MUSIC_END = define("music.end");
    public static final Sound MUSIC_GAME = define("music.game");
    public static final Sound MUSIC_MENU = define("music.menu");
    public static final Sound MUSIC_NETHER_BASALT_DELTAS = define("music.nether.basalt_deltas");
    public static final Sound MUSIC_NETHER_CRIMSON_FOREST = define("music.nether.crimson_forest");
    public static final Sound MUSIC_OVERWORLD_DEEP_DARK = define("music.overworld.deep_dark");
    public static final Sound MUSIC_OVERWORLD_DRIPSTONE_CAVES = define("music.overworld.dripstone_caves");
    public static final Sound MUSIC_OVERWORLD_GROVE = define("music.overworld.grove");
    public static final Sound MUSIC_OVERWORLD_JAGGED_PEAKS = define("music.overworld.jagged_peaks");
    public static final Sound MUSIC_OVERWORLD_LUSH_CAVES = define("music.overworld.lush_caves");
    public static final Sound MUSIC_OVERWORLD_SWAMP = define("music.overworld.swamp");
    public static final Sound MUSIC_OVERWORLD_FOREST = define("music.overworld.forest");
    public static final Sound MUSIC_OVERWORLD_OLD_GROWTH_TAIGA = define("music.overworld.old_growth_taiga");
    public static final Sound MUSIC_OVERWORLD_MEADOW = define("music.overworld.meadow");
    public static final Sound MUSIC_OVERWORLD_CHERRY_GROVE = define("music.overworld.cherry_grove");
    public static final Sound MUSIC_NETHER_NETHER_WASTES = define("music.nether.nether_wastes");
    public static final Sound MUSIC_OVERWORLD_FROZEN_PEAKS = define("music.overworld.frozen_peaks");
    public static final Sound MUSIC_OVERWORLD_SNOWY_SLOPES = define("music.overworld.snowy_slopes");
    public static final Sound MUSIC_NETHER_SOUL_SAND_VALLEY = define("music.nether.soul_sand_valley");
    public static final Sound MUSIC_OVERWORLD_STONY_PEAKS = define("music.overworld.stony_peaks");
    public static final Sound MUSIC_NETHER_WARPED_FOREST = define("music.nether.warped_forest");
    public static final Sound MUSIC_OVERWORLD_FLOWER_FOREST = define("music.overworld.flower_forest");
    public static final Sound MUSIC_OVERWORLD_DESERT = define("music.overworld.desert");
    public static final Sound MUSIC_OVERWORLD_BADLANDS = define("music.overworld.badlands");
    public static final Sound MUSIC_OVERWORLD_JUNGLE = define("music.overworld.jungle");
    public static final Sound MUSIC_OVERWORLD_SPARSE_JUNGLE = define("music.overworld.sparse_jungle");
    public static final Sound MUSIC_OVERWORLD_BAMBOO_JUNGLE = define("music.overworld.bamboo_jungle");
    public static final Sound MUSIC_UNDER_WATER = define("music.under_water");
    public static final Sound BLOCK_NETHER_BRICKS_BREAK = define("block.nether_bricks.break");
    public static final Sound BLOCK_NETHER_BRICKS_STEP = define("block.nether_bricks.step");
    public static final Sound BLOCK_NETHER_BRICKS_PLACE = define("block.nether_bricks.place");
    public static final Sound BLOCK_NETHER_BRICKS_HIT = define("block.nether_bricks.hit");
    public static final Sound BLOCK_NETHER_BRICKS_FALL = define("block.nether_bricks.fall");
    public static final Sound BLOCK_NETHER_WART_BREAK = define("block.nether_wart.break");
    public static final Sound ITEM_NETHER_WART_PLANT = define("item.nether_wart.plant");
    public static final Sound BLOCK_NETHER_WOOD_BREAK = define("block.nether_wood.break");
    public static final Sound BLOCK_NETHER_WOOD_FALL = define("block.nether_wood.fall");
    public static final Sound BLOCK_NETHER_WOOD_HIT = define("block.nether_wood.hit");
    public static final Sound BLOCK_NETHER_WOOD_PLACE = define("block.nether_wood.place");
    public static final Sound BLOCK_NETHER_WOOD_STEP = define("block.nether_wood.step");
    public static final Sound BLOCK_NETHER_WOOD_DOOR_CLOSE = define("block.nether_wood_door.close");
    public static final Sound BLOCK_NETHER_WOOD_DOOR_OPEN = define("block.nether_wood_door.open");
    public static final Sound BLOCK_NETHER_WOOD_TRAPDOOR_CLOSE = define("block.nether_wood_trapdoor.close");
    public static final Sound BLOCK_NETHER_WOOD_TRAPDOOR_OPEN = define("block.nether_wood_trapdoor.open");
    public static final Sound BLOCK_NETHER_WOOD_BUTTON_CLICK_OFF = define("block.nether_wood_button.click_off");
    public static final Sound BLOCK_NETHER_WOOD_BUTTON_CLICK_ON = define("block.nether_wood_button.click_on");
    public static final Sound BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF = define("block.nether_wood_pressure_plate.click_off");
    public static final Sound BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_ON = define("block.nether_wood_pressure_plate.click_on");
    public static final Sound BLOCK_NETHER_WOOD_FENCE_GATE_CLOSE = define("block.nether_wood_fence_gate.close");
    public static final Sound BLOCK_NETHER_WOOD_FENCE_GATE_OPEN = define("block.nether_wood_fence_gate.open");
    public static final Sound INTENTIONALLY_EMPTY = define("intentionally_empty");
    public static final Sound BLOCK_PACKED_MUD_BREAK = define("block.packed_mud.break");
    public static final Sound BLOCK_PACKED_MUD_FALL = define("block.packed_mud.fall");
    public static final Sound BLOCK_PACKED_MUD_HIT = define("block.packed_mud.hit");
    public static final Sound BLOCK_PACKED_MUD_PLACE = define("block.packed_mud.place");
    public static final Sound BLOCK_PACKED_MUD_STEP = define("block.packed_mud.step");
    public static final Sound BLOCK_STEM_BREAK = define("block.stem.break");
    public static final Sound BLOCK_STEM_STEP = define("block.stem.step");
    public static final Sound BLOCK_STEM_PLACE = define("block.stem.place");
    public static final Sound BLOCK_STEM_HIT = define("block.stem.hit");
    public static final Sound BLOCK_STEM_FALL = define("block.stem.fall");
    public static final Sound BLOCK_NYLIUM_BREAK = define("block.nylium.break");
    public static final Sound BLOCK_NYLIUM_STEP = define("block.nylium.step");
    public static final Sound BLOCK_NYLIUM_PLACE = define("block.nylium.place");
    public static final Sound BLOCK_NYLIUM_HIT = define("block.nylium.hit");
    public static final Sound BLOCK_NYLIUM_FALL = define("block.nylium.fall");
    public static final Sound BLOCK_NETHER_SPROUTS_BREAK = define("block.nether_sprouts.break");
    public static final Sound BLOCK_NETHER_SPROUTS_STEP = define("block.nether_sprouts.step");
    public static final Sound BLOCK_NETHER_SPROUTS_PLACE = define("block.nether_sprouts.place");
    public static final Sound BLOCK_NETHER_SPROUTS_HIT = define("block.nether_sprouts.hit");
    public static final Sound BLOCK_NETHER_SPROUTS_FALL = define("block.nether_sprouts.fall");
    public static final Sound BLOCK_FUNGUS_BREAK = define("block.fungus.break");
    public static final Sound BLOCK_FUNGUS_STEP = define("block.fungus.step");
    public static final Sound BLOCK_FUNGUS_PLACE = define("block.fungus.place");
    public static final Sound BLOCK_FUNGUS_HIT = define("block.fungus.hit");
    public static final Sound BLOCK_FUNGUS_FALL = define("block.fungus.fall");
    public static final Sound BLOCK_WEEPING_VINES_BREAK = define("block.weeping_vines.break");
    public static final Sound BLOCK_WEEPING_VINES_STEP = define("block.weeping_vines.step");
    public static final Sound BLOCK_WEEPING_VINES_PLACE = define("block.weeping_vines.place");
    public static final Sound BLOCK_WEEPING_VINES_HIT = define("block.weeping_vines.hit");
    public static final Sound BLOCK_WEEPING_VINES_FALL = define("block.weeping_vines.fall");
    public static final Sound BLOCK_WART_BLOCK_BREAK = define("block.wart_block.break");
    public static final Sound BLOCK_WART_BLOCK_STEP = define("block.wart_block.step");
    public static final Sound BLOCK_WART_BLOCK_PLACE = define("block.wart_block.place");
    public static final Sound BLOCK_WART_BLOCK_HIT = define("block.wart_block.hit");
    public static final Sound BLOCK_WART_BLOCK_FALL = define("block.wart_block.fall");
    public static final Sound BLOCK_NETHERITE_BLOCK_BREAK = define("block.netherite_block.break");
    public static final Sound BLOCK_NETHERITE_BLOCK_STEP = define("block.netherite_block.step");
    public static final Sound BLOCK_NETHERITE_BLOCK_PLACE = define("block.netherite_block.place");
    public static final Sound BLOCK_NETHERITE_BLOCK_HIT = define("block.netherite_block.hit");
    public static final Sound BLOCK_NETHERITE_BLOCK_FALL = define("block.netherite_block.fall");
    public static final Sound BLOCK_NETHERRACK_BREAK = define("block.netherrack.break");
    public static final Sound BLOCK_NETHERRACK_STEP = define("block.netherrack.step");
    public static final Sound BLOCK_NETHERRACK_PLACE = define("block.netherrack.place");
    public static final Sound BLOCK_NETHERRACK_HIT = define("block.netherrack.hit");
    public static final Sound BLOCK_NETHERRACK_FALL = define("block.netherrack.fall");
    public static final Sound BLOCK_NOTE_BLOCK_BASEDRUM = define("block.note_block.basedrum");
    public static final Sound BLOCK_NOTE_BLOCK_BASS = define("block.note_block.bass");
    public static final Sound BLOCK_NOTE_BLOCK_BELL = define("block.note_block.bell");
    public static final Sound BLOCK_NOTE_BLOCK_CHIME = define("block.note_block.chime");
    public static final Sound BLOCK_NOTE_BLOCK_FLUTE = define("block.note_block.flute");
    public static final Sound BLOCK_NOTE_BLOCK_GUITAR = define("block.note_block.guitar");
    public static final Sound BLOCK_NOTE_BLOCK_HARP = define("block.note_block.harp");
    public static final Sound BLOCK_NOTE_BLOCK_HAT = define("block.note_block.hat");
    public static final Sound BLOCK_NOTE_BLOCK_PLING = define("block.note_block.pling");
    public static final Sound BLOCK_NOTE_BLOCK_SNARE = define("block.note_block.snare");
    public static final Sound BLOCK_NOTE_BLOCK_XYLOPHONE = define("block.note_block.xylophone");
    public static final Sound BLOCK_NOTE_BLOCK_IRON_XYLOPHONE = define("block.note_block.iron_xylophone");
    public static final Sound BLOCK_NOTE_BLOCK_COW_BELL = define("block.note_block.cow_bell");
    public static final Sound BLOCK_NOTE_BLOCK_DIDGERIDOO = define("block.note_block.didgeridoo");
    public static final Sound BLOCK_NOTE_BLOCK_BIT = define("block.note_block.bit");
    public static final Sound BLOCK_NOTE_BLOCK_BANJO = define("block.note_block.banjo");
    public static final Sound BLOCK_NOTE_BLOCK_IMITATE_ZOMBIE = define("block.note_block.imitate.zombie");
    public static final Sound BLOCK_NOTE_BLOCK_IMITATE_SKELETON = define("block.note_block.imitate.skeleton");
    public static final Sound BLOCK_NOTE_BLOCK_IMITATE_CREEPER = define("block.note_block.imitate.creeper");
    public static final Sound BLOCK_NOTE_BLOCK_IMITATE_ENDER_DRAGON = define("block.note_block.imitate.ender_dragon");
    public static final Sound BLOCK_NOTE_BLOCK_IMITATE_WITHER_SKELETON = define("block.note_block.imitate.wither_skeleton");
    public static final Sound BLOCK_NOTE_BLOCK_IMITATE_PIGLIN = define("block.note_block.imitate.piglin");
    public static final Sound ENTITY_OCELOT_HURT = define("entity.ocelot.hurt");
    public static final Sound ENTITY_OCELOT_AMBIENT = define("entity.ocelot.ambient");
    public static final Sound ENTITY_OCELOT_DEATH = define("entity.ocelot.death");
    public static final Sound ITEM_OMINOUS_BOTTLE_DISPOSE = define("item.ominous_bottle.dispose");
    public static final Sound ENTITY_PAINTING_BREAK = define("entity.painting.break");
    public static final Sound ENTITY_PAINTING_PLACE = define("entity.painting.place");
    public static final Sound ENTITY_PANDA_PRE_SNEEZE = define("entity.panda.pre_sneeze");
    public static final Sound ENTITY_PANDA_SNEEZE = define("entity.panda.sneeze");
    public static final Sound ENTITY_PANDA_AMBIENT = define("entity.panda.ambient");
    public static final Sound ENTITY_PANDA_DEATH = define("entity.panda.death");
    public static final Sound ENTITY_PANDA_EAT = define("entity.panda.eat");
    public static final Sound ENTITY_PANDA_STEP = define("entity.panda.step");
    public static final Sound ENTITY_PANDA_CANT_BREED = define("entity.panda.cant_breed");
    public static final Sound ENTITY_PANDA_AGGRESSIVE_AMBIENT = define("entity.panda.aggressive_ambient");
    public static final Sound ENTITY_PANDA_WORRIED_AMBIENT = define("entity.panda.worried_ambient");
    public static final Sound ENTITY_PANDA_HURT = define("entity.panda.hurt");
    public static final Sound ENTITY_PANDA_BITE = define("entity.panda.bite");
    public static final Sound ENTITY_PARROT_AMBIENT = define("entity.parrot.ambient");
    public static final Sound ENTITY_PARROT_DEATH = define("entity.parrot.death");
    public static final Sound ENTITY_PARROT_EAT = define("entity.parrot.eat");
    public static final Sound ENTITY_PARROT_FLY = define("entity.parrot.fly");
    public static final Sound ENTITY_PARROT_HURT = define("entity.parrot.hurt");
    public static final Sound ENTITY_PARROT_IMITATE_BLAZE = define("entity.parrot.imitate.blaze");
    public static final Sound ENTITY_PARROT_IMITATE_BOGGED = define("entity.parrot.imitate.bogged");
    public static final Sound ENTITY_PARROT_IMITATE_BREEZE = define("entity.parrot.imitate.breeze");
    public static final Sound ENTITY_PARROT_IMITATE_CREEPER = define("entity.parrot.imitate.creeper");
    public static final Sound ENTITY_PARROT_IMITATE_DROWNED = define("entity.parrot.imitate.drowned");
    public static final Sound ENTITY_PARROT_IMITATE_ELDER_GUARDIAN = define("entity.parrot.imitate.elder_guardian");
    public static final Sound ENTITY_PARROT_IMITATE_ENDER_DRAGON = define("entity.parrot.imitate.ender_dragon");
    public static final Sound ENTITY_PARROT_IMITATE_ENDERMITE = define("entity.parrot.imitate.endermite");
    public static final Sound ENTITY_PARROT_IMITATE_EVOKER = define("entity.parrot.imitate.evoker");
    public static final Sound ENTITY_PARROT_IMITATE_GHAST = define("entity.parrot.imitate.ghast");
    public static final Sound ENTITY_PARROT_IMITATE_GUARDIAN = define("entity.parrot.imitate.guardian");
    public static final Sound ENTITY_PARROT_IMITATE_HOGLIN = define("entity.parrot.imitate.hoglin");
    public static final Sound ENTITY_PARROT_IMITATE_HUSK = define("entity.parrot.imitate.husk");
    public static final Sound ENTITY_PARROT_IMITATE_ILLUSIONER = define("entity.parrot.imitate.illusioner");
    public static final Sound ENTITY_PARROT_IMITATE_MAGMA_CUBE = define("entity.parrot.imitate.magma_cube");
    public static final Sound ENTITY_PARROT_IMITATE_PHANTOM = define("entity.parrot.imitate.phantom");
    public static final Sound ENTITY_PARROT_IMITATE_PIGLIN = define("entity.parrot.imitate.piglin");
    public static final Sound ENTITY_PARROT_IMITATE_PIGLIN_BRUTE = define("entity.parrot.imitate.piglin_brute");
    public static final Sound ENTITY_PARROT_IMITATE_PILLAGER = define("entity.parrot.imitate.pillager");
    public static final Sound ENTITY_PARROT_IMITATE_RAVAGER = define("entity.parrot.imitate.ravager");
    public static final Sound ENTITY_PARROT_IMITATE_SHULKER = define("entity.parrot.imitate.shulker");
    public static final Sound ENTITY_PARROT_IMITATE_SILVERFISH = define("entity.parrot.imitate.silverfish");
    public static final Sound ENTITY_PARROT_IMITATE_SKELETON = define("entity.parrot.imitate.skeleton");
    public static final Sound ENTITY_PARROT_IMITATE_SLIME = define("entity.parrot.imitate.slime");
    public static final Sound ENTITY_PARROT_IMITATE_SPIDER = define("entity.parrot.imitate.spider");
    public static final Sound ENTITY_PARROT_IMITATE_STRAY = define("entity.parrot.imitate.stray");
    public static final Sound ENTITY_PARROT_IMITATE_VEX = define("entity.parrot.imitate.vex");
    public static final Sound ENTITY_PARROT_IMITATE_VINDICATOR = define("entity.parrot.imitate.vindicator");
    public static final Sound ENTITY_PARROT_IMITATE_WARDEN = define("entity.parrot.imitate.warden");
    public static final Sound ENTITY_PARROT_IMITATE_WITCH = define("entity.parrot.imitate.witch");
    public static final Sound ENTITY_PARROT_IMITATE_WITHER = define("entity.parrot.imitate.wither");
    public static final Sound ENTITY_PARROT_IMITATE_WITHER_SKELETON = define("entity.parrot.imitate.wither_skeleton");
    public static final Sound ENTITY_PARROT_IMITATE_ZOGLIN = define("entity.parrot.imitate.zoglin");
    public static final Sound ENTITY_PARROT_IMITATE_ZOMBIE = define("entity.parrot.imitate.zombie");
    public static final Sound ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER = define("entity.parrot.imitate.zombie_villager");
    public static final Sound ENTITY_PARROT_STEP = define("entity.parrot.step");
    public static final Sound ENTITY_PHANTOM_AMBIENT = define("entity.phantom.ambient");
    public static final Sound ENTITY_PHANTOM_BITE = define("entity.phantom.bite");
    public static final Sound ENTITY_PHANTOM_DEATH = define("entity.phantom.death");
    public static final Sound ENTITY_PHANTOM_FLAP = define("entity.phantom.flap");
    public static final Sound ENTITY_PHANTOM_HURT = define("entity.phantom.hurt");
    public static final Sound ENTITY_PHANTOM_SWOOP = define("entity.phantom.swoop");
    public static final Sound ENTITY_PIG_AMBIENT = define("entity.pig.ambient");
    public static final Sound ENTITY_PIG_DEATH = define("entity.pig.death");
    public static final Sound ENTITY_PIG_HURT = define("entity.pig.hurt");
    public static final Sound ENTITY_PIG_SADDLE = define("entity.pig.saddle");
    public static final Sound ENTITY_PIG_STEP = define("entity.pig.step");
    public static final Sound ENTITY_PIGLIN_ADMIRING_ITEM = define("entity.piglin.admiring_item");
    public static final Sound ENTITY_PIGLIN_AMBIENT = define("entity.piglin.ambient");
    public static final Sound ENTITY_PIGLIN_ANGRY = define("entity.piglin.angry");
    public static final Sound ENTITY_PIGLIN_CELEBRATE = define("entity.piglin.celebrate");
    public static final Sound ENTITY_PIGLIN_DEATH = define("entity.piglin.death");
    public static final Sound ENTITY_PIGLIN_JEALOUS = define("entity.piglin.jealous");
    public static final Sound ENTITY_PIGLIN_HURT = define("entity.piglin.hurt");
    public static final Sound ENTITY_PIGLIN_RETREAT = define("entity.piglin.retreat");
    public static final Sound ENTITY_PIGLIN_STEP = define("entity.piglin.step");
    public static final Sound ENTITY_PIGLIN_CONVERTED_TO_ZOMBIFIED = define("entity.piglin.converted_to_zombified");
    public static final Sound ENTITY_PIGLIN_BRUTE_AMBIENT = define("entity.piglin_brute.ambient");
    public static final Sound ENTITY_PIGLIN_BRUTE_ANGRY = define("entity.piglin_brute.angry");
    public static final Sound ENTITY_PIGLIN_BRUTE_DEATH = define("entity.piglin_brute.death");
    public static final Sound ENTITY_PIGLIN_BRUTE_HURT = define("entity.piglin_brute.hurt");
    public static final Sound ENTITY_PIGLIN_BRUTE_STEP = define("entity.piglin_brute.step");
    public static final Sound ENTITY_PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED = define("entity.piglin_brute.converted_to_zombified");
    public static final Sound ENTITY_PILLAGER_AMBIENT = define("entity.pillager.ambient");
    public static final Sound ENTITY_PILLAGER_CELEBRATE = define("entity.pillager.celebrate");
    public static final Sound ENTITY_PILLAGER_DEATH = define("entity.pillager.death");
    public static final Sound ENTITY_PILLAGER_HURT = define("entity.pillager.hurt");
    public static final Sound BLOCK_PISTON_CONTRACT = define("block.piston.contract");
    public static final Sound BLOCK_PISTON_EXTEND = define("block.piston.extend");
    public static final Sound ENTITY_PLAYER_ATTACK_CRIT = define("entity.player.attack.crit");
    public static final Sound ENTITY_PLAYER_ATTACK_KNOCKBACK = define("entity.player.attack.knockback");
    public static final Sound ENTITY_PLAYER_ATTACK_NODAMAGE = define("entity.player.attack.nodamage");
    public static final Sound ENTITY_PLAYER_ATTACK_STRONG = define("entity.player.attack.strong");
    public static final Sound ENTITY_PLAYER_ATTACK_SWEEP = define("entity.player.attack.sweep");
    public static final Sound ENTITY_PLAYER_ATTACK_WEAK = define("entity.player.attack.weak");
    public static final Sound ENTITY_PLAYER_BIG_FALL = define("entity.player.big_fall");
    public static final Sound ENTITY_PLAYER_BREATH = define("entity.player.breath");
    public static final Sound ENTITY_PLAYER_BURP = define("entity.player.burp");
    public static final Sound ENTITY_PLAYER_DEATH = define("entity.player.death");
    public static final Sound ENTITY_PLAYER_HURT = define("entity.player.hurt");
    public static final Sound ENTITY_PLAYER_HURT_DROWN = define("entity.player.hurt_drown");
    public static final Sound ENTITY_PLAYER_HURT_FREEZE = define("entity.player.hurt_freeze");
    public static final Sound ENTITY_PLAYER_HURT_ON_FIRE = define("entity.player.hurt_on_fire");
    public static final Sound ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH = define("entity.player.hurt_sweet_berry_bush");
    public static final Sound ENTITY_PLAYER_LEVELUP = define("entity.player.levelup");
    public static final Sound ENTITY_PLAYER_SMALL_FALL = define("entity.player.small_fall");
    public static final Sound ENTITY_PLAYER_SPLASH = define("entity.player.splash");
    public static final Sound ENTITY_PLAYER_SPLASH_HIGH_SPEED = define("entity.player.splash.high_speed");
    public static final Sound ENTITY_PLAYER_SWIM = define("entity.player.swim");
    public static final Sound ENTITY_PLAYER_TELEPORT = define("entity.player.teleport");
    public static final Sound ENTITY_POLAR_BEAR_AMBIENT = define("entity.polar_bear.ambient");
    public static final Sound ENTITY_POLAR_BEAR_AMBIENT_BABY = define("entity.polar_bear.ambient_baby");
    public static final Sound ENTITY_POLAR_BEAR_DEATH = define("entity.polar_bear.death");
    public static final Sound ENTITY_POLAR_BEAR_HURT = define("entity.polar_bear.hurt");
    public static final Sound ENTITY_POLAR_BEAR_STEP = define("entity.polar_bear.step");
    public static final Sound ENTITY_POLAR_BEAR_WARNING = define("entity.polar_bear.warning");
    public static final Sound BLOCK_POLISHED_DEEPSLATE_BREAK = define("block.polished_deepslate.break");
    public static final Sound BLOCK_POLISHED_DEEPSLATE_FALL = define("block.polished_deepslate.fall");
    public static final Sound BLOCK_POLISHED_DEEPSLATE_HIT = define("block.polished_deepslate.hit");
    public static final Sound BLOCK_POLISHED_DEEPSLATE_PLACE = define("block.polished_deepslate.place");
    public static final Sound BLOCK_POLISHED_DEEPSLATE_STEP = define("block.polished_deepslate.step");
    public static final Sound BLOCK_PORTAL_AMBIENT = define("block.portal.ambient");
    public static final Sound BLOCK_PORTAL_TRAVEL = define("block.portal.travel");
    public static final Sound BLOCK_PORTAL_TRIGGER = define("block.portal.trigger");
    public static final Sound BLOCK_POWDER_SNOW_BREAK = define("block.powder_snow.break");
    public static final Sound BLOCK_POWDER_SNOW_FALL = define("block.powder_snow.fall");
    public static final Sound BLOCK_POWDER_SNOW_HIT = define("block.powder_snow.hit");
    public static final Sound BLOCK_POWDER_SNOW_PLACE = define("block.powder_snow.place");
    public static final Sound BLOCK_POWDER_SNOW_STEP = define("block.powder_snow.step");
    /**
     * Removed with 1.21.6
     */
    @ApiStatus.Obsolete
    public static final Sound ENTITY_PUFFER_FISH_AMBIENT = define("entity.puffer_fish.ambient");
    public static final Sound ENTITY_PUFFER_FISH_BLOW_OUT = define("entity.puffer_fish.blow_out");
    public static final Sound ENTITY_PUFFER_FISH_BLOW_UP = define("entity.puffer_fish.blow_up");
    public static final Sound ENTITY_PUFFER_FISH_DEATH = define("entity.puffer_fish.death");
    public static final Sound ENTITY_PUFFER_FISH_FLOP = define("entity.puffer_fish.flop");
    public static final Sound ENTITY_PUFFER_FISH_HURT = define("entity.puffer_fish.hurt");
    public static final Sound ENTITY_PUFFER_FISH_STING = define("entity.puffer_fish.sting");
    public static final Sound BLOCK_PUMPKIN_CARVE = define("block.pumpkin.carve");
    public static final Sound ENTITY_RABBIT_AMBIENT = define("entity.rabbit.ambient");
    public static final Sound ENTITY_RABBIT_ATTACK = define("entity.rabbit.attack");
    public static final Sound ENTITY_RABBIT_DEATH = define("entity.rabbit.death");
    public static final Sound ENTITY_RABBIT_HURT = define("entity.rabbit.hurt");
    public static final Sound ENTITY_RABBIT_JUMP = define("entity.rabbit.jump");
    public static final Sound EVENT_RAID_HORN = define("event.raid.horn");
    public static final Sound ENTITY_RAVAGER_AMBIENT = define("entity.ravager.ambient");
    public static final Sound ENTITY_RAVAGER_ATTACK = define("entity.ravager.attack");
    public static final Sound ENTITY_RAVAGER_CELEBRATE = define("entity.ravager.celebrate");
    public static final Sound ENTITY_RAVAGER_DEATH = define("entity.ravager.death");
    public static final Sound ENTITY_RAVAGER_HURT = define("entity.ravager.hurt");
    public static final Sound ENTITY_RAVAGER_STEP = define("entity.ravager.step");
    public static final Sound ENTITY_RAVAGER_STUNNED = define("entity.ravager.stunned");
    public static final Sound ENTITY_RAVAGER_ROAR = define("entity.ravager.roar");
    public static final Sound BLOCK_NETHER_GOLD_ORE_BREAK = define("block.nether_gold_ore.break");
    public static final Sound BLOCK_NETHER_GOLD_ORE_FALL = define("block.nether_gold_ore.fall");
    public static final Sound BLOCK_NETHER_GOLD_ORE_HIT = define("block.nether_gold_ore.hit");
    public static final Sound BLOCK_NETHER_GOLD_ORE_PLACE = define("block.nether_gold_ore.place");
    public static final Sound BLOCK_NETHER_GOLD_ORE_STEP = define("block.nether_gold_ore.step");
    public static final Sound BLOCK_NETHER_ORE_BREAK = define("block.nether_ore.break");
    public static final Sound BLOCK_NETHER_ORE_FALL = define("block.nether_ore.fall");
    public static final Sound BLOCK_NETHER_ORE_HIT = define("block.nether_ore.hit");
    public static final Sound BLOCK_NETHER_ORE_PLACE = define("block.nether_ore.place");
    public static final Sound BLOCK_NETHER_ORE_STEP = define("block.nether_ore.step");
    public static final Sound BLOCK_REDSTONE_TORCH_BURNOUT = define("block.redstone_torch.burnout");
    public static final Sound BLOCK_RESPAWN_ANCHOR_AMBIENT = define("block.respawn_anchor.ambient");
    public static final Sound BLOCK_RESPAWN_ANCHOR_CHARGE = define("block.respawn_anchor.charge");
    public static final Sound BLOCK_RESPAWN_ANCHOR_DEPLETE = define("block.respawn_anchor.deplete");
    public static final Sound BLOCK_RESPAWN_ANCHOR_SET_SPAWN = define("block.respawn_anchor.set_spawn");
    public static final Sound BLOCK_ROOTED_DIRT_BREAK = define("block.rooted_dirt.break");
    public static final Sound BLOCK_ROOTED_DIRT_FALL = define("block.rooted_dirt.fall");
    public static final Sound BLOCK_ROOTED_DIRT_HIT = define("block.rooted_dirt.hit");
    public static final Sound BLOCK_ROOTED_DIRT_PLACE = define("block.rooted_dirt.place");
    public static final Sound BLOCK_ROOTED_DIRT_STEP = define("block.rooted_dirt.step");
    public static final Sound ENTITY_SALMON_AMBIENT = define("entity.salmon.ambient");
    public static final Sound ENTITY_SALMON_DEATH = define("entity.salmon.death");
    public static final Sound ENTITY_SALMON_FLOP = define("entity.salmon.flop");
    public static final Sound ENTITY_SALMON_HURT = define("entity.salmon.hurt");
    public static final Sound BLOCK_SAND_BREAK = define("block.sand.break");
    public static final Sound BLOCK_SAND_FALL = define("block.sand.fall");
    public static final Sound BLOCK_SAND_HIT = define("block.sand.hit");
    public static final Sound BLOCK_SAND_PLACE = define("block.sand.place");
    public static final Sound BLOCK_SAND_STEP = define("block.sand.step");
    public static final Sound BLOCK_SCAFFOLDING_BREAK = define("block.scaffolding.break");
    public static final Sound BLOCK_SCAFFOLDING_FALL = define("block.scaffolding.fall");
    public static final Sound BLOCK_SCAFFOLDING_HIT = define("block.scaffolding.hit");
    public static final Sound BLOCK_SCAFFOLDING_PLACE = define("block.scaffolding.place");
    public static final Sound BLOCK_SCAFFOLDING_STEP = define("block.scaffolding.step");
    public static final Sound BLOCK_SCULK_SPREAD = define("block.sculk.spread");
    public static final Sound BLOCK_SCULK_CHARGE = define("block.sculk.charge");
    public static final Sound BLOCK_SCULK_BREAK = define("block.sculk.break");
    public static final Sound BLOCK_SCULK_FALL = define("block.sculk.fall");
    public static final Sound BLOCK_SCULK_HIT = define("block.sculk.hit");
    public static final Sound BLOCK_SCULK_PLACE = define("block.sculk.place");
    public static final Sound BLOCK_SCULK_STEP = define("block.sculk.step");
    public static final Sound BLOCK_SCULK_CATALYST_BLOOM = define("block.sculk_catalyst.bloom");
    public static final Sound BLOCK_SCULK_CATALYST_BREAK = define("block.sculk_catalyst.break");
    public static final Sound BLOCK_SCULK_CATALYST_FALL = define("block.sculk_catalyst.fall");
    public static final Sound BLOCK_SCULK_CATALYST_HIT = define("block.sculk_catalyst.hit");
    public static final Sound BLOCK_SCULK_CATALYST_PLACE = define("block.sculk_catalyst.place");
    public static final Sound BLOCK_SCULK_CATALYST_STEP = define("block.sculk_catalyst.step");
    public static final Sound BLOCK_SCULK_SENSOR_CLICKING = define("block.sculk_sensor.clicking");
    public static final Sound BLOCK_SCULK_SENSOR_CLICKING_STOP = define("block.sculk_sensor.clicking_stop");
    public static final Sound BLOCK_SCULK_SENSOR_BREAK = define("block.sculk_sensor.break");
    public static final Sound BLOCK_SCULK_SENSOR_FALL = define("block.sculk_sensor.fall");
    public static final Sound BLOCK_SCULK_SENSOR_HIT = define("block.sculk_sensor.hit");
    public static final Sound BLOCK_SCULK_SENSOR_PLACE = define("block.sculk_sensor.place");
    public static final Sound BLOCK_SCULK_SENSOR_STEP = define("block.sculk_sensor.step");
    public static final Sound BLOCK_SCULK_SHRIEKER_BREAK = define("block.sculk_shrieker.break");
    public static final Sound BLOCK_SCULK_SHRIEKER_FALL = define("block.sculk_shrieker.fall");
    public static final Sound BLOCK_SCULK_SHRIEKER_HIT = define("block.sculk_shrieker.hit");
    public static final Sound BLOCK_SCULK_SHRIEKER_PLACE = define("block.sculk_shrieker.place");
    public static final Sound BLOCK_SCULK_SHRIEKER_SHRIEK = define("block.sculk_shrieker.shriek");
    public static final Sound BLOCK_SCULK_SHRIEKER_STEP = define("block.sculk_shrieker.step");
    public static final Sound BLOCK_SCULK_VEIN_BREAK = define("block.sculk_vein.break");
    public static final Sound BLOCK_SCULK_VEIN_FALL = define("block.sculk_vein.fall");
    public static final Sound BLOCK_SCULK_VEIN_HIT = define("block.sculk_vein.hit");
    public static final Sound BLOCK_SCULK_VEIN_PLACE = define("block.sculk_vein.place");
    public static final Sound BLOCK_SCULK_VEIN_STEP = define("block.sculk_vein.step");
    public static final Sound ENTITY_SHEEP_AMBIENT = define("entity.sheep.ambient");
    public static final Sound ENTITY_SHEEP_DEATH = define("entity.sheep.death");
    public static final Sound ENTITY_SHEEP_HURT = define("entity.sheep.hurt");
    public static final Sound ENTITY_SHEEP_SHEAR = define("entity.sheep.shear");
    public static final Sound ENTITY_SHEEP_STEP = define("entity.sheep.step");
    public static final Sound ITEM_SHIELD_BLOCK = define("item.shield.block");
    public static final Sound ITEM_SHIELD_BREAK = define("item.shield.break");
    public static final Sound BLOCK_SHROOMLIGHT_BREAK = define("block.shroomlight.break");
    public static final Sound BLOCK_SHROOMLIGHT_STEP = define("block.shroomlight.step");
    public static final Sound BLOCK_SHROOMLIGHT_PLACE = define("block.shroomlight.place");
    public static final Sound BLOCK_SHROOMLIGHT_HIT = define("block.shroomlight.hit");
    public static final Sound BLOCK_SHROOMLIGHT_FALL = define("block.shroomlight.fall");
    public static final Sound ITEM_SHOVEL_FLATTEN = define("item.shovel.flatten");
    public static final Sound ENTITY_SHULKER_AMBIENT = define("entity.shulker.ambient");
    public static final Sound BLOCK_SHULKER_BOX_CLOSE = define("block.shulker_box.close");
    public static final Sound BLOCK_SHULKER_BOX_OPEN = define("block.shulker_box.open");
    public static final Sound ENTITY_SHULKER_BULLET_HIT = define("entity.shulker_bullet.hit");
    public static final Sound ENTITY_SHULKER_BULLET_HURT = define("entity.shulker_bullet.hurt");
    public static final Sound ENTITY_SHULKER_CLOSE = define("entity.shulker.close");
    public static final Sound ENTITY_SHULKER_DEATH = define("entity.shulker.death");
    public static final Sound ENTITY_SHULKER_HURT = define("entity.shulker.hurt");
    public static final Sound ENTITY_SHULKER_HURT_CLOSED = define("entity.shulker.hurt_closed");
    public static final Sound ENTITY_SHULKER_OPEN = define("entity.shulker.open");
    public static final Sound ENTITY_SHULKER_SHOOT = define("entity.shulker.shoot");
    public static final Sound ENTITY_SHULKER_TELEPORT = define("entity.shulker.teleport");
    public static final Sound ENTITY_SILVERFISH_AMBIENT = define("entity.silverfish.ambient");
    public static final Sound ENTITY_SILVERFISH_DEATH = define("entity.silverfish.death");
    public static final Sound ENTITY_SILVERFISH_HURT = define("entity.silverfish.hurt");
    public static final Sound ENTITY_SILVERFISH_STEP = define("entity.silverfish.step");
    public static final Sound ENTITY_SKELETON_AMBIENT = define("entity.skeleton.ambient");
    public static final Sound ENTITY_SKELETON_CONVERTED_TO_STRAY = define("entity.skeleton.converted_to_stray");
    public static final Sound ENTITY_SKELETON_DEATH = define("entity.skeleton.death");
    public static final Sound ENTITY_SKELETON_HORSE_AMBIENT = define("entity.skeleton_horse.ambient");
    public static final Sound ENTITY_SKELETON_HORSE_DEATH = define("entity.skeleton_horse.death");
    public static final Sound ENTITY_SKELETON_HORSE_HURT = define("entity.skeleton_horse.hurt");
    public static final Sound ENTITY_SKELETON_HORSE_SWIM = define("entity.skeleton_horse.swim");
    public static final Sound ENTITY_SKELETON_HORSE_AMBIENT_WATER = define("entity.skeleton_horse.ambient_water");
    public static final Sound ENTITY_SKELETON_HORSE_GALLOP_WATER = define("entity.skeleton_horse.gallop_water");
    public static final Sound ENTITY_SKELETON_HORSE_JUMP_WATER = define("entity.skeleton_horse.jump_water");
    public static final Sound ENTITY_SKELETON_HORSE_STEP_WATER = define("entity.skeleton_horse.step_water");
    public static final Sound ENTITY_SKELETON_HURT = define("entity.skeleton.hurt");
    public static final Sound ENTITY_SKELETON_SHOOT = define("entity.skeleton.shoot");
    public static final Sound ENTITY_SKELETON_STEP = define("entity.skeleton.step");
    public static final Sound ENTITY_SLIME_ATTACK = define("entity.slime.attack");
    public static final Sound ENTITY_SLIME_DEATH = define("entity.slime.death");
    public static final Sound ENTITY_SLIME_HURT = define("entity.slime.hurt");
    public static final Sound ENTITY_SLIME_JUMP = define("entity.slime.jump");
    public static final Sound ENTITY_SLIME_SQUISH = define("entity.slime.squish");
    public static final Sound BLOCK_SLIME_BLOCK_BREAK = define("block.slime_block.break");
    public static final Sound BLOCK_SLIME_BLOCK_FALL = define("block.slime_block.fall");
    public static final Sound BLOCK_SLIME_BLOCK_HIT = define("block.slime_block.hit");
    public static final Sound BLOCK_SLIME_BLOCK_PLACE = define("block.slime_block.place");
    public static final Sound BLOCK_SLIME_BLOCK_STEP = define("block.slime_block.step");
    public static final Sound BLOCK_SMALL_AMETHYST_BUD_BREAK = define("block.small_amethyst_bud.break");
    public static final Sound BLOCK_SMALL_AMETHYST_BUD_PLACE = define("block.small_amethyst_bud.place");
    public static final Sound BLOCK_SMALL_DRIPLEAF_BREAK = define("block.small_dripleaf.break");
    public static final Sound BLOCK_SMALL_DRIPLEAF_FALL = define("block.small_dripleaf.fall");
    public static final Sound BLOCK_SMALL_DRIPLEAF_HIT = define("block.small_dripleaf.hit");
    public static final Sound BLOCK_SMALL_DRIPLEAF_PLACE = define("block.small_dripleaf.place");
    public static final Sound BLOCK_SMALL_DRIPLEAF_STEP = define("block.small_dripleaf.step");
    public static final Sound BLOCK_SOUL_SAND_BREAK = define("block.soul_sand.break");
    public static final Sound BLOCK_SOUL_SAND_STEP = define("block.soul_sand.step");
    public static final Sound BLOCK_SOUL_SAND_PLACE = define("block.soul_sand.place");
    public static final Sound BLOCK_SOUL_SAND_HIT = define("block.soul_sand.hit");
    public static final Sound BLOCK_SOUL_SAND_FALL = define("block.soul_sand.fall");
    public static final Sound BLOCK_SOUL_SOIL_BREAK = define("block.soul_soil.break");
    public static final Sound BLOCK_SOUL_SOIL_STEP = define("block.soul_soil.step");
    public static final Sound BLOCK_SOUL_SOIL_PLACE = define("block.soul_soil.place");
    public static final Sound BLOCK_SOUL_SOIL_HIT = define("block.soul_soil.hit");
    public static final Sound BLOCK_SOUL_SOIL_FALL = define("block.soul_soil.fall");
    public static final Sound PARTICLE_SOUL_ESCAPE = define("particle.soul_escape");
    public static final Sound BLOCK_SPORE_BLOSSOM_BREAK = define("block.spore_blossom.break");
    public static final Sound BLOCK_SPORE_BLOSSOM_FALL = define("block.spore_blossom.fall");
    public static final Sound BLOCK_SPORE_BLOSSOM_HIT = define("block.spore_blossom.hit");
    public static final Sound BLOCK_SPORE_BLOSSOM_PLACE = define("block.spore_blossom.place");
    public static final Sound BLOCK_SPORE_BLOSSOM_STEP = define("block.spore_blossom.step");
    public static final Sound ENTITY_STRIDER_AMBIENT = define("entity.strider.ambient");
    public static final Sound ENTITY_STRIDER_HAPPY = define("entity.strider.happy");
    public static final Sound ENTITY_STRIDER_RETREAT = define("entity.strider.retreat");
    public static final Sound ENTITY_STRIDER_DEATH = define("entity.strider.death");
    public static final Sound ENTITY_STRIDER_HURT = define("entity.strider.hurt");
    public static final Sound ENTITY_STRIDER_STEP = define("entity.strider.step");
    public static final Sound ENTITY_STRIDER_STEP_LAVA = define("entity.strider.step_lava");
    public static final Sound ENTITY_STRIDER_EAT = define("entity.strider.eat");
    public static final Sound ENTITY_STRIDER_SADDLE = define("entity.strider.saddle");
    public static final Sound ENTITY_SLIME_DEATH_SMALL = define("entity.slime.death_small");
    public static final Sound ENTITY_SLIME_HURT_SMALL = define("entity.slime.hurt_small");
    public static final Sound ENTITY_SLIME_JUMP_SMALL = define("entity.slime.jump_small");
    public static final Sound ENTITY_SLIME_SQUISH_SMALL = define("entity.slime.squish_small");
    public static final Sound BLOCK_SMITHING_TABLE_USE = define("block.smithing_table.use");
    public static final Sound BLOCK_SMOKER_SMOKE = define("block.smoker.smoke");
    public static final Sound ENTITY_SNIFFER_STEP = define("entity.sniffer.step");
    public static final Sound ENTITY_SNIFFER_EAT = define("entity.sniffer.eat");
    public static final Sound ENTITY_SNIFFER_IDLE = define("entity.sniffer.idle");
    public static final Sound ENTITY_SNIFFER_HURT = define("entity.sniffer.hurt");
    public static final Sound ENTITY_SNIFFER_DEATH = define("entity.sniffer.death");
    public static final Sound ENTITY_SNIFFER_DROP_SEED = define("entity.sniffer.drop_seed");
    public static final Sound ENTITY_SNIFFER_SCENTING = define("entity.sniffer.scenting");
    public static final Sound ENTITY_SNIFFER_SNIFFING = define("entity.sniffer.sniffing");
    public static final Sound ENTITY_SNIFFER_SEARCHING = define("entity.sniffer.searching");
    public static final Sound ENTITY_SNIFFER_DIGGING = define("entity.sniffer.digging");
    public static final Sound ENTITY_SNIFFER_DIGGING_STOP = define("entity.sniffer.digging_stop");
    public static final Sound ENTITY_SNIFFER_HAPPY = define("entity.sniffer.happy");
    public static final Sound BLOCK_SNIFFER_EGG_PLOP = define("block.sniffer_egg.plop");
    public static final Sound BLOCK_SNIFFER_EGG_CRACK = define("block.sniffer_egg.crack");
    public static final Sound BLOCK_SNIFFER_EGG_HATCH = define("block.sniffer_egg.hatch");
    public static final Sound ENTITY_SNOWBALL_THROW = define("entity.snowball.throw");
    public static final Sound BLOCK_SNOW_BREAK = define("block.snow.break");
    public static final Sound BLOCK_SNOW_FALL = define("block.snow.fall");
    public static final Sound ENTITY_SNOW_GOLEM_AMBIENT = define("entity.snow_golem.ambient");
    public static final Sound ENTITY_SNOW_GOLEM_DEATH = define("entity.snow_golem.death");
    public static final Sound ENTITY_SNOW_GOLEM_HURT = define("entity.snow_golem.hurt");
    public static final Sound ENTITY_SNOW_GOLEM_SHOOT = define("entity.snow_golem.shoot");
    public static final Sound ENTITY_SNOW_GOLEM_SHEAR = define("entity.snow_golem.shear");
    public static final Sound BLOCK_SNOW_HIT = define("block.snow.hit");
    public static final Sound BLOCK_SNOW_PLACE = define("block.snow.place");
    public static final Sound BLOCK_SNOW_STEP = define("block.snow.step");
    public static final Sound ENTITY_SPIDER_AMBIENT = define("entity.spider.ambient");
    public static final Sound ENTITY_SPIDER_DEATH = define("entity.spider.death");
    public static final Sound ENTITY_SPIDER_HURT = define("entity.spider.hurt");
    public static final Sound ENTITY_SPIDER_STEP = define("entity.spider.step");
    public static final Sound ENTITY_SPLASH_POTION_BREAK = define("entity.splash_potion.break");
    public static final Sound ENTITY_SPLASH_POTION_THROW = define("entity.splash_potion.throw");
    public static final Sound BLOCK_SPONGE_BREAK = define("block.sponge.break");
    public static final Sound BLOCK_SPONGE_FALL = define("block.sponge.fall");
    public static final Sound BLOCK_SPONGE_HIT = define("block.sponge.hit");
    public static final Sound BLOCK_SPONGE_PLACE = define("block.sponge.place");
    public static final Sound BLOCK_SPONGE_STEP = define("block.sponge.step");
    public static final Sound BLOCK_SPONGE_ABSORB = define("block.sponge.absorb");
    public static final Sound ITEM_SPYGLASS_USE = define("item.spyglass.use");
    public static final Sound ITEM_SPYGLASS_STOP_USING = define("item.spyglass.stop_using");
    public static final Sound ENTITY_SQUID_AMBIENT = define("entity.squid.ambient");
    public static final Sound ENTITY_SQUID_DEATH = define("entity.squid.death");
    public static final Sound ENTITY_SQUID_HURT = define("entity.squid.hurt");
    public static final Sound ENTITY_SQUID_SQUIRT = define("entity.squid.squirt");
    public static final Sound BLOCK_STONE_BREAK = define("block.stone.break");
    public static final Sound BLOCK_STONE_BUTTON_CLICK_OFF = define("block.stone_button.click_off");
    public static final Sound BLOCK_STONE_BUTTON_CLICK_ON = define("block.stone_button.click_on");
    public static final Sound BLOCK_STONE_FALL = define("block.stone.fall");
    public static final Sound BLOCK_STONE_HIT = define("block.stone.hit");
    public static final Sound BLOCK_STONE_PLACE = define("block.stone.place");
    public static final Sound BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF = define("block.stone_pressure_plate.click_off");
    public static final Sound BLOCK_STONE_PRESSURE_PLATE_CLICK_ON = define("block.stone_pressure_plate.click_on");
    public static final Sound BLOCK_STONE_STEP = define("block.stone.step");
    public static final Sound ENTITY_STRAY_AMBIENT = define("entity.stray.ambient");
    public static final Sound ENTITY_STRAY_DEATH = define("entity.stray.death");
    public static final Sound ENTITY_STRAY_HURT = define("entity.stray.hurt");
    public static final Sound ENTITY_STRAY_STEP = define("entity.stray.step");
    public static final Sound BLOCK_SWEET_BERRY_BUSH_BREAK = define("block.sweet_berry_bush.break");
    public static final Sound BLOCK_SWEET_BERRY_BUSH_PLACE = define("block.sweet_berry_bush.place");
    public static final Sound BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES = define("block.sweet_berry_bush.pick_berries");
    public static final Sound ENTITY_TADPOLE_DEATH = define("entity.tadpole.death");
    public static final Sound ENTITY_TADPOLE_FLOP = define("entity.tadpole.flop");
    public static final Sound ENTITY_TADPOLE_GROW_UP = define("entity.tadpole.grow_up");
    public static final Sound ENTITY_TADPOLE_HURT = define("entity.tadpole.hurt");
    public static final Sound ENCHANT_THORNS_HIT = define("enchant.thorns.hit");
    public static final Sound ENTITY_TNT_PRIMED = define("entity.tnt.primed");
    public static final Sound ITEM_TOTEM_USE = define("item.totem.use");
    public static final Sound ITEM_TRIDENT_HIT = define("item.trident.hit");
    public static final Sound ITEM_TRIDENT_HIT_GROUND = define("item.trident.hit_ground");
    public static final Sound ITEM_TRIDENT_RETURN = define("item.trident.return");
    public static final Sound ITEM_TRIDENT_RIPTIDE_1 = define("item.trident.riptide_1");
    public static final Sound ITEM_TRIDENT_RIPTIDE_2 = define("item.trident.riptide_2");
    public static final Sound ITEM_TRIDENT_RIPTIDE_3 = define("item.trident.riptide_3");
    public static final Sound ITEM_TRIDENT_THROW = define("item.trident.throw");
    public static final Sound ITEM_TRIDENT_THUNDER = define("item.trident.thunder");
    public static final Sound BLOCK_TRIPWIRE_ATTACH = define("block.tripwire.attach");
    public static final Sound BLOCK_TRIPWIRE_CLICK_OFF = define("block.tripwire.click_off");
    public static final Sound BLOCK_TRIPWIRE_CLICK_ON = define("block.tripwire.click_on");
    public static final Sound BLOCK_TRIPWIRE_DETACH = define("block.tripwire.detach");
    public static final Sound ENTITY_TROPICAL_FISH_AMBIENT = define("entity.tropical_fish.ambient");
    public static final Sound ENTITY_TROPICAL_FISH_DEATH = define("entity.tropical_fish.death");
    public static final Sound ENTITY_TROPICAL_FISH_FLOP = define("entity.tropical_fish.flop");
    public static final Sound ENTITY_TROPICAL_FISH_HURT = define("entity.tropical_fish.hurt");
    public static final Sound BLOCK_TUFF_BREAK = define("block.tuff.break");
    public static final Sound BLOCK_TUFF_STEP = define("block.tuff.step");
    public static final Sound BLOCK_TUFF_PLACE = define("block.tuff.place");
    public static final Sound BLOCK_TUFF_HIT = define("block.tuff.hit");
    public static final Sound BLOCK_TUFF_FALL = define("block.tuff.fall");
    public static final Sound BLOCK_TUFF_BRICKS_BREAK = define("block.tuff_bricks.break");
    public static final Sound BLOCK_TUFF_BRICKS_FALL = define("block.tuff_bricks.fall");
    public static final Sound BLOCK_TUFF_BRICKS_HIT = define("block.tuff_bricks.hit");
    public static final Sound BLOCK_TUFF_BRICKS_PLACE = define("block.tuff_bricks.place");
    public static final Sound BLOCK_TUFF_BRICKS_STEP = define("block.tuff_bricks.step");
    public static final Sound BLOCK_POLISHED_TUFF_BREAK = define("block.polished_tuff.break");
    public static final Sound BLOCK_POLISHED_TUFF_FALL = define("block.polished_tuff.fall");
    public static final Sound BLOCK_POLISHED_TUFF_HIT = define("block.polished_tuff.hit");
    public static final Sound BLOCK_POLISHED_TUFF_PLACE = define("block.polished_tuff.place");
    public static final Sound BLOCK_POLISHED_TUFF_STEP = define("block.polished_tuff.step");
    public static final Sound ENTITY_TURTLE_AMBIENT_LAND = define("entity.turtle.ambient_land");
    public static final Sound ENTITY_TURTLE_DEATH = define("entity.turtle.death");
    public static final Sound ENTITY_TURTLE_DEATH_BABY = define("entity.turtle.death_baby");
    public static final Sound ENTITY_TURTLE_EGG_BREAK = define("entity.turtle.egg_break");
    public static final Sound ENTITY_TURTLE_EGG_CRACK = define("entity.turtle.egg_crack");
    public static final Sound ENTITY_TURTLE_EGG_HATCH = define("entity.turtle.egg_hatch");
    public static final Sound ENTITY_TURTLE_HURT = define("entity.turtle.hurt");
    public static final Sound ENTITY_TURTLE_HURT_BABY = define("entity.turtle.hurt_baby");
    public static final Sound ENTITY_TURTLE_LAY_EGG = define("entity.turtle.lay_egg");
    public static final Sound ENTITY_TURTLE_SHAMBLE = define("entity.turtle.shamble");
    public static final Sound ENTITY_TURTLE_SHAMBLE_BABY = define("entity.turtle.shamble_baby");
    public static final Sound ENTITY_TURTLE_SWIM = define("entity.turtle.swim");
    public static final Sound UI_BUTTON_CLICK = define("ui.button.click");
    public static final Sound UI_LOOM_SELECT_PATTERN = define("ui.loom.select_pattern");
    public static final Sound UI_LOOM_TAKE_RESULT = define("ui.loom.take_result");
    public static final Sound UI_CARTOGRAPHY_TABLE_TAKE_RESULT = define("ui.cartography_table.take_result");
    public static final Sound UI_STONECUTTER_TAKE_RESULT = define("ui.stonecutter.take_result");
    public static final Sound UI_STONECUTTER_SELECT_RECIPE = define("ui.stonecutter.select_recipe");
    public static final Sound UI_TOAST_CHALLENGE_COMPLETE = define("ui.toast.challenge_complete");
    public static final Sound UI_TOAST_IN = define("ui.toast.in");
    public static final Sound UI_TOAST_OUT = define("ui.toast.out");
    public static final Sound BLOCK_VAULT_ACTIVATE = define("block.vault.activate");
    public static final Sound BLOCK_VAULT_AMBIENT = define("block.vault.ambient");
    public static final Sound BLOCK_VAULT_BREAK = define("block.vault.break");
    public static final Sound BLOCK_VAULT_CLOSE_SHUTTER = define("block.vault.close_shutter");
    public static final Sound BLOCK_VAULT_DEACTIVATE = define("block.vault.deactivate");
    public static final Sound BLOCK_VAULT_EJECT_ITEM = define("block.vault.eject_item");
    public static final Sound BLOCK_VAULT_FALL = define("block.vault.fall");
    public static final Sound BLOCK_VAULT_HIT = define("block.vault.hit");
    public static final Sound BLOCK_VAULT_INSERT_ITEM = define("block.vault.insert_item");
    public static final Sound BLOCK_VAULT_INSERT_ITEM_FAIL = define("block.vault.insert_item_fail");
    public static final Sound BLOCK_VAULT_OPEN_SHUTTER = define("block.vault.open_shutter");
    public static final Sound BLOCK_VAULT_PLACE = define("block.vault.place");
    public static final Sound BLOCK_VAULT_STEP = define("block.vault.step");
    public static final Sound ENTITY_VEX_AMBIENT = define("entity.vex.ambient");
    public static final Sound ENTITY_VEX_CHARGE = define("entity.vex.charge");
    public static final Sound ENTITY_VEX_DEATH = define("entity.vex.death");
    public static final Sound ENTITY_VEX_HURT = define("entity.vex.hurt");
    public static final Sound ENTITY_VILLAGER_AMBIENT = define("entity.villager.ambient");
    public static final Sound ENTITY_VILLAGER_CELEBRATE = define("entity.villager.celebrate");
    public static final Sound ENTITY_VILLAGER_DEATH = define("entity.villager.death");
    public static final Sound ENTITY_VILLAGER_HURT = define("entity.villager.hurt");
    public static final Sound ENTITY_VILLAGER_NO = define("entity.villager.no");
    public static final Sound ENTITY_VILLAGER_TRADE = define("entity.villager.trade");
    public static final Sound ENTITY_VILLAGER_YES = define("entity.villager.yes");
    public static final Sound ENTITY_VILLAGER_WORK_ARMORER = define("entity.villager.work_armorer");
    public static final Sound ENTITY_VILLAGER_WORK_BUTCHER = define("entity.villager.work_butcher");
    public static final Sound ENTITY_VILLAGER_WORK_CARTOGRAPHER = define("entity.villager.work_cartographer");
    public static final Sound ENTITY_VILLAGER_WORK_CLERIC = define("entity.villager.work_cleric");
    public static final Sound ENTITY_VILLAGER_WORK_FARMER = define("entity.villager.work_farmer");
    public static final Sound ENTITY_VILLAGER_WORK_FISHERMAN = define("entity.villager.work_fisherman");
    public static final Sound ENTITY_VILLAGER_WORK_FLETCHER = define("entity.villager.work_fletcher");
    public static final Sound ENTITY_VILLAGER_WORK_LEATHERWORKER = define("entity.villager.work_leatherworker");
    public static final Sound ENTITY_VILLAGER_WORK_LIBRARIAN = define("entity.villager.work_librarian");
    public static final Sound ENTITY_VILLAGER_WORK_MASON = define("entity.villager.work_mason");
    public static final Sound ENTITY_VILLAGER_WORK_SHEPHERD = define("entity.villager.work_shepherd");
    public static final Sound ENTITY_VILLAGER_WORK_TOOLSMITH = define("entity.villager.work_toolsmith");
    public static final Sound ENTITY_VILLAGER_WORK_WEAPONSMITH = define("entity.villager.work_weaponsmith");
    public static final Sound ENTITY_VINDICATOR_AMBIENT = define("entity.vindicator.ambient");
    public static final Sound ENTITY_VINDICATOR_CELEBRATE = define("entity.vindicator.celebrate");
    public static final Sound ENTITY_VINDICATOR_DEATH = define("entity.vindicator.death");
    public static final Sound ENTITY_VINDICATOR_HURT = define("entity.vindicator.hurt");
    public static final Sound BLOCK_VINE_BREAK = define("block.vine.break");
    public static final Sound BLOCK_VINE_FALL = define("block.vine.fall");
    public static final Sound BLOCK_VINE_HIT = define("block.vine.hit");
    public static final Sound BLOCK_VINE_PLACE = define("block.vine.place");
    public static final Sound BLOCK_VINE_STEP = define("block.vine.step");
    public static final Sound BLOCK_LILY_PAD_PLACE = define("block.lily_pad.place");
    public static final Sound ENTITY_WANDERING_TRADER_AMBIENT = define("entity.wandering_trader.ambient");
    public static final Sound ENTITY_WANDERING_TRADER_DEATH = define("entity.wandering_trader.death");
    public static final Sound ENTITY_WANDERING_TRADER_DISAPPEARED = define("entity.wandering_trader.disappeared");
    public static final Sound ENTITY_WANDERING_TRADER_DRINK_MILK = define("entity.wandering_trader.drink_milk");
    public static final Sound ENTITY_WANDERING_TRADER_DRINK_POTION = define("entity.wandering_trader.drink_potion");
    public static final Sound ENTITY_WANDERING_TRADER_HURT = define("entity.wandering_trader.hurt");
    public static final Sound ENTITY_WANDERING_TRADER_NO = define("entity.wandering_trader.no");
    public static final Sound ENTITY_WANDERING_TRADER_REAPPEARED = define("entity.wandering_trader.reappeared");
    public static final Sound ENTITY_WANDERING_TRADER_TRADE = define("entity.wandering_trader.trade");
    public static final Sound ENTITY_WANDERING_TRADER_YES = define("entity.wandering_trader.yes");
    public static final Sound ENTITY_WARDEN_AGITATED = define("entity.warden.agitated");
    public static final Sound ENTITY_WARDEN_AMBIENT = define("entity.warden.ambient");
    public static final Sound ENTITY_WARDEN_ANGRY = define("entity.warden.angry");
    public static final Sound ENTITY_WARDEN_ATTACK_IMPACT = define("entity.warden.attack_impact");
    public static final Sound ENTITY_WARDEN_DEATH = define("entity.warden.death");
    public static final Sound ENTITY_WARDEN_DIG = define("entity.warden.dig");
    public static final Sound ENTITY_WARDEN_EMERGE = define("entity.warden.emerge");
    public static final Sound ENTITY_WARDEN_HEARTBEAT = define("entity.warden.heartbeat");
    public static final Sound ENTITY_WARDEN_HURT = define("entity.warden.hurt");
    public static final Sound ENTITY_WARDEN_LISTENING = define("entity.warden.listening");
    public static final Sound ENTITY_WARDEN_LISTENING_ANGRY = define("entity.warden.listening_angry");
    public static final Sound ENTITY_WARDEN_NEARBY_CLOSE = define("entity.warden.nearby_close");
    public static final Sound ENTITY_WARDEN_NEARBY_CLOSER = define("entity.warden.nearby_closer");
    public static final Sound ENTITY_WARDEN_NEARBY_CLOSEST = define("entity.warden.nearby_closest");
    public static final Sound ENTITY_WARDEN_ROAR = define("entity.warden.roar");
    public static final Sound ENTITY_WARDEN_SNIFF = define("entity.warden.sniff");
    public static final Sound ENTITY_WARDEN_SONIC_BOOM = define("entity.warden.sonic_boom");
    public static final Sound ENTITY_WARDEN_SONIC_CHARGE = define("entity.warden.sonic_charge");
    public static final Sound ENTITY_WARDEN_STEP = define("entity.warden.step");
    public static final Sound ENTITY_WARDEN_TENDRIL_CLICKS = define("entity.warden.tendril_clicks");
    public static final Sound BLOCK_HANGING_SIGN_WAXED_INTERACT_FAIL = define("block.hanging_sign.waxed_interact_fail");
    public static final Sound BLOCK_SIGN_WAXED_INTERACT_FAIL = define("block.sign.waxed_interact_fail");
    public static final Sound BLOCK_WATER_AMBIENT = define("block.water.ambient");
    public static final Sound WEATHER_RAIN = define("weather.rain");
    public static final Sound WEATHER_RAIN_ABOVE = define("weather.rain.above");
    public static final Sound BLOCK_WET_GRASS_BREAK = define("block.wet_grass.break");
    public static final Sound BLOCK_WET_GRASS_FALL = define("block.wet_grass.fall");
    public static final Sound BLOCK_WET_GRASS_HIT = define("block.wet_grass.hit");
    public static final Sound BLOCK_WET_GRASS_PLACE = define("block.wet_grass.place");
    public static final Sound BLOCK_WET_GRASS_STEP = define("block.wet_grass.step");
    public static final Sound BLOCK_WET_SPONGE_BREAK = define("block.wet_sponge.break");
    public static final Sound BLOCK_WET_SPONGE_DRIES = define("block.wet_sponge.dries");
    public static final Sound BLOCK_WET_SPONGE_FALL = define("block.wet_sponge.fall");
    public static final Sound BLOCK_WET_SPONGE_HIT = define("block.wet_sponge.hit");
    public static final Sound BLOCK_WET_SPONGE_PLACE = define("block.wet_sponge.place");
    public static final Sound BLOCK_WET_SPONGE_STEP = define("block.wet_sponge.step");
    public static final Sound ENTITY_WIND_CHARGE_WIND_BURST = define("entity.wind_charge.wind_burst");
    public static final Sound ENTITY_WIND_CHARGE_THROW = define("entity.wind_charge.throw");
    public static final Sound ENTITY_WITCH_AMBIENT = define("entity.witch.ambient");
    public static final Sound ENTITY_WITCH_CELEBRATE = define("entity.witch.celebrate");
    public static final Sound ENTITY_WITCH_DEATH = define("entity.witch.death");
    public static final Sound ENTITY_WITCH_DRINK = define("entity.witch.drink");
    public static final Sound ENTITY_WITCH_HURT = define("entity.witch.hurt");
    public static final Sound ENTITY_WITCH_THROW = define("entity.witch.throw");
    public static final Sound ENTITY_WITHER_AMBIENT = define("entity.wither.ambient");
    public static final Sound ENTITY_WITHER_BREAK_BLOCK = define("entity.wither.break_block");
    public static final Sound ENTITY_WITHER_DEATH = define("entity.wither.death");
    public static final Sound ENTITY_WITHER_HURT = define("entity.wither.hurt");
    public static final Sound ENTITY_WITHER_SHOOT = define("entity.wither.shoot");
    public static final Sound ENTITY_WITHER_SKELETON_AMBIENT = define("entity.wither_skeleton.ambient");
    public static final Sound ENTITY_WITHER_SKELETON_DEATH = define("entity.wither_skeleton.death");
    public static final Sound ENTITY_WITHER_SKELETON_HURT = define("entity.wither_skeleton.hurt");
    public static final Sound ENTITY_WITHER_SKELETON_STEP = define("entity.wither_skeleton.step");
    public static final Sound ENTITY_WITHER_SPAWN = define("entity.wither.spawn");
    public static final Sound ITEM_WOLF_ARMOR_BREAK = define("item.wolf_armor.break");
    public static final Sound ITEM_WOLF_ARMOR_CRACK = define("item.wolf_armor.crack");
    public static final Sound ITEM_WOLF_ARMOR_DAMAGE = define("item.wolf_armor.damage");
    public static final Sound ITEM_WOLF_ARMOR_REPAIR = define("item.wolf_armor.repair");
    public static final Sound ENTITY_WOLF_AMBIENT = define("entity.wolf.ambient");
    public static final Sound ENTITY_WOLF_DEATH = define("entity.wolf.death");
    public static final Sound ENTITY_WOLF_GROWL = define("entity.wolf.growl");
    /**
     * Removed with 1.21.5
     */
    @ApiStatus.Obsolete
    public static final Sound ENTITY_WOLF_HOWL = define("entity.wolf.howl");
    public static final Sound ENTITY_WOLF_HURT = define("entity.wolf.hurt");
    public static final Sound ENTITY_WOLF_PANT = define("entity.wolf.pant");
    public static final Sound ENTITY_WOLF_SHAKE = define("entity.wolf.shake");
    public static final Sound ENTITY_WOLF_STEP = define("entity.wolf.step");
    public static final Sound ENTITY_WOLF_WHINE = define("entity.wolf.whine");
    public static final Sound BLOCK_WOODEN_DOOR_CLOSE = define("block.wooden_door.close");
    public static final Sound BLOCK_WOODEN_DOOR_OPEN = define("block.wooden_door.open");
    public static final Sound BLOCK_WOODEN_TRAPDOOR_CLOSE = define("block.wooden_trapdoor.close");
    public static final Sound BLOCK_WOODEN_TRAPDOOR_OPEN = define("block.wooden_trapdoor.open");
    public static final Sound BLOCK_WOODEN_BUTTON_CLICK_OFF = define("block.wooden_button.click_off");
    public static final Sound BLOCK_WOODEN_BUTTON_CLICK_ON = define("block.wooden_button.click_on");
    public static final Sound BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF = define("block.wooden_pressure_plate.click_off");
    public static final Sound BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON = define("block.wooden_pressure_plate.click_on");
    public static final Sound BLOCK_WOOD_BREAK = define("block.wood.break");
    public static final Sound BLOCK_WOOD_FALL = define("block.wood.fall");
    public static final Sound BLOCK_WOOD_HIT = define("block.wood.hit");
    public static final Sound BLOCK_WOOD_PLACE = define("block.wood.place");
    public static final Sound BLOCK_WOOD_STEP = define("block.wood.step");
    public static final Sound BLOCK_WOOL_BREAK = define("block.wool.break");
    public static final Sound BLOCK_WOOL_FALL = define("block.wool.fall");
    public static final Sound BLOCK_WOOL_HIT = define("block.wool.hit");
    public static final Sound BLOCK_WOOL_PLACE = define("block.wool.place");
    public static final Sound BLOCK_WOOL_STEP = define("block.wool.step");
    public static final Sound ENTITY_ZOGLIN_AMBIENT = define("entity.zoglin.ambient");
    public static final Sound ENTITY_ZOGLIN_ANGRY = define("entity.zoglin.angry");
    public static final Sound ENTITY_ZOGLIN_ATTACK = define("entity.zoglin.attack");
    public static final Sound ENTITY_ZOGLIN_DEATH = define("entity.zoglin.death");
    public static final Sound ENTITY_ZOGLIN_HURT = define("entity.zoglin.hurt");
    public static final Sound ENTITY_ZOGLIN_STEP = define("entity.zoglin.step");
    public static final Sound ENTITY_ZOMBIE_AMBIENT = define("entity.zombie.ambient");
    public static final Sound ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR = define("entity.zombie.attack_wooden_door");
    public static final Sound ENTITY_ZOMBIE_ATTACK_IRON_DOOR = define("entity.zombie.attack_iron_door");
    public static final Sound ENTITY_ZOMBIE_BREAK_WOODEN_DOOR = define("entity.zombie.break_wooden_door");
    public static final Sound ENTITY_ZOMBIE_CONVERTED_TO_DROWNED = define("entity.zombie.converted_to_drowned");
    public static final Sound ENTITY_ZOMBIE_DEATH = define("entity.zombie.death");
    public static final Sound ENTITY_ZOMBIE_DESTROY_EGG = define("entity.zombie.destroy_egg");
    public static final Sound ENTITY_ZOMBIE_HORSE_AMBIENT = define("entity.zombie_horse.ambient");
    public static final Sound ENTITY_ZOMBIE_HORSE_DEATH = define("entity.zombie_horse.death");
    public static final Sound ENTITY_ZOMBIE_HORSE_HURT = define("entity.zombie_horse.hurt");
    public static final Sound ENTITY_ZOMBIE_HURT = define("entity.zombie.hurt");
    public static final Sound ENTITY_ZOMBIE_INFECT = define("entity.zombie.infect");
    public static final Sound ENTITY_ZOMBIFIED_PIGLIN_AMBIENT = define("entity.zombified_piglin.ambient");
    public static final Sound ENTITY_ZOMBIFIED_PIGLIN_ANGRY = define("entity.zombified_piglin.angry");
    public static final Sound ENTITY_ZOMBIFIED_PIGLIN_DEATH = define("entity.zombified_piglin.death");
    public static final Sound ENTITY_ZOMBIFIED_PIGLIN_HURT = define("entity.zombified_piglin.hurt");
    public static final Sound ENTITY_ZOMBIE_STEP = define("entity.zombie.step");
    public static final Sound ENTITY_ZOMBIE_VILLAGER_AMBIENT = define("entity.zombie_villager.ambient");
    public static final Sound ENTITY_ZOMBIE_VILLAGER_CONVERTED = define("entity.zombie_villager.converted");
    public static final Sound ENTITY_ZOMBIE_VILLAGER_CURE = define("entity.zombie_villager.cure");
    public static final Sound ENTITY_ZOMBIE_VILLAGER_DEATH = define("entity.zombie_villager.death");
    public static final Sound ENTITY_ZOMBIE_VILLAGER_HURT = define("entity.zombie_villager.hurt");
    public static final Sound ENTITY_ZOMBIE_VILLAGER_STEP = define("entity.zombie_villager.step");
    public static final Sound EVENT_MOB_EFFECT_BAD_OMEN = define("event.mob_effect.bad_omen");
    public static final Sound EVENT_MOB_EFFECT_TRIAL_OMEN = define("event.mob_effect.trial_omen");
    public static final Sound EVENT_MOB_EFFECT_RAID_OMEN = define("event.mob_effect.raid_omen");

    // Added with 1.21
    public static final Sound MUSIC_DISC_CREATOR = define("music_disc.creator");
    public static final Sound MUSIC_DISC_CREATOR_MUSIC_BOX = define("music_disc.creator_music_box");
    public static final Sound MUSIC_DISC_PRECIPICE = define("music_disc.precipice");
    public static final Sound BLOCK_VAULT_REJECT_REWARDED_PLAYER = define("block.vault.reject_rewarded_player");

    // added with 1.21.2
    public static final Sound UI_HUD_BUBBLE_POP = define("ui.hud.bubble_pop");
    public static final Sound ITEM_BUNDLE_INSERT_FAIL = define("item.bundle.insert_fail");
    public static final Sound ENTITY_CREAKING_AMBIENT = define("entity.creaking.ambient");
    public static final Sound ENTITY_CREAKING_ACTIVATE = define("entity.creaking.activate");
    public static final Sound ENTITY_CREAKING_DEACTIVATE = define("entity.creaking.deactivate");
    public static final Sound ENTITY_CREAKING_ATTACK = define("entity.creaking.attack");
    public static final Sound ENTITY_CREAKING_DEATH = define("entity.creaking.death");
    public static final Sound ENTITY_CREAKING_STEP = define("entity.creaking.step");
    public static final Sound ENTITY_CREAKING_FREEZE = define("entity.creaking.freeze");
    public static final Sound ENTITY_CREAKING_UNFREEZE = define("entity.creaking.unfreeze");
    public static final Sound ENTITY_CREAKING_SPAWN = define("entity.creaking.spawn");
    public static final Sound ENTITY_CREAKING_SWAY = define("entity.creaking.sway");
    public static final Sound BLOCK_CREAKING_HEART_BREAK = define("block.creaking_heart.break");
    public static final Sound BLOCK_CREAKING_HEART_FALL = define("block.creaking_heart.fall");
    public static final Sound BLOCK_CREAKING_HEART_HIT = define("block.creaking_heart.hit");
    public static final Sound BLOCK_CREAKING_HEART_HURT = define("block.creaking_heart.hurt");
    public static final Sound BLOCK_CREAKING_HEART_PLACE = define("block.creaking_heart.place");
    public static final Sound BLOCK_CREAKING_HEART_STEP = define("block.creaking_heart.step");
    public static final Sound BLOCK_CREAKING_HEART_IDLE = define("block.creaking_heart.idle");
    public static final Sound BLOCK_CREAKING_HEART_SPAWN = define("block.creaking_heart.spawn");
    public static final Sound BLOCK_PALE_HANGING_MOSS_IDLE = define("block.pale_hanging_moss.idle");
    public static final Sound ENTITY_PARROT_IMITATE_CREAKING = define("entity.parrot.imitate.creaking");
    public static final Sound BLOCK_SPAWNER_BREAK = define("block.spawner.break");
    public static final Sound BLOCK_SPAWNER_FALL = define("block.spawner.fall");
    public static final Sound BLOCK_SPAWNER_HIT = define("block.spawner.hit");
    public static final Sound BLOCK_SPAWNER_PLACE = define("block.spawner.place");
    public static final Sound BLOCK_SPAWNER_STEP = define("block.spawner.step");

    // added with 1.21.4
    public static final Sound ENTITY_CREAKING_TWITCH = define("entity.creaking.twitch");
    public static final Sound BLOCK_EYEBLOSSOM_OPEN_LONG = define("block.eyeblossom.open_long");
    public static final Sound BLOCK_EYEBLOSSOM_OPEN = define("block.eyeblossom.open");
    public static final Sound BLOCK_EYEBLOSSOM_CLOSE_LONG = define("block.eyeblossom.close_long");
    public static final Sound BLOCK_EYEBLOSSOM_CLOSE = define("block.eyeblossom.close");
    public static final Sound BLOCK_EYEBLOSSOM_IDLE = define("block.eyeblossom.idle");
    public static final Sound BLOCK_RESIN_BREAK = define("block.resin.break");
    public static final Sound BLOCK_RESIN_FALL = define("block.resin.fall");
    public static final Sound BLOCK_RESIN_PLACE = define("block.resin.place");
    public static final Sound BLOCK_RESIN_STEP = define("block.resin.step");
    public static final Sound BLOCK_RESIN_BRICKS_BREAK = define("block.resin_bricks.break");
    public static final Sound BLOCK_RESIN_BRICKS_FALL = define("block.resin_bricks.fall");
    public static final Sound BLOCK_RESIN_BRICKS_HIT = define("block.resin_bricks.hit");
    public static final Sound BLOCK_RESIN_BRICKS_PLACE = define("block.resin_bricks.place");
    public static final Sound BLOCK_RESIN_BRICKS_STEP = define("block.resin_bricks.step");

    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_CACTUS_FLOWER_BREAK = define("block.cactus_flower.break");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_CACTUS_FLOWER_PLACE = define("block.cactus_flower.place");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_DEADBUSH_IDLE = define("block.deadbush.idle");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_FIREFLY_BUSH_IDLE = define("block.firefly_bush.idle");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_IRON_BREAK = define("block.iron.break");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_IRON_STEP = define("block.iron.step");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_IRON_PLACE = define("block.iron.place");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_IRON_HIT = define("block.iron.hit");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_IRON_FALL = define("block.iron.fall");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_LEAF_LITTER_BREAK = define("block.leaf_litter.break");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_LEAF_LITTER_STEP = define("block.leaf_litter.step");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_LEAF_LITTER_PLACE = define("block.leaf_litter.place");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_LEAF_LITTER_HIT = define("block.leaf_litter.hit");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_LEAF_LITTER_FALL = define("block.leaf_litter.fall");
    /**
     * Added with 1.21.5
     */
    public static final Sound BLOCK_SAND_IDLE = define("block.sand.idle");
    /**
     * Added with 1.21.5, removed with 1.21.6
     */
    @ApiStatus.Obsolete
    public static final Sound BLOCK_SAND_WIND = define("block.sand.wind");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_PUGLIN_AMBIENT = define("entity.wolf_puglin.ambient");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_PUGLIN_DEATH = define("entity.wolf_puglin.death");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_PUGLIN_GROWL = define("entity.wolf_puglin.growl");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_PUGLIN_HURT = define("entity.wolf_puglin.hurt");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_PUGLIN_PANT = define("entity.wolf_puglin.pant");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_PUGLIN_WHINE = define("entity.wolf_puglin.whine");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_SAD_AMBIENT = define("entity.wolf_sad.ambient");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_SAD_DEATH = define("entity.wolf_sad.death");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_SAD_GROWL = define("entity.wolf_sad.growl");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_SAD_HURT = define("entity.wolf_sad.hurt");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_SAD_PANT = define("entity.wolf_sad.pant");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_SAD_WHINE = define("entity.wolf_sad.whine");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_ANGRY_AMBIENT = define("entity.wolf_angry.ambient");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_ANGRY_DEATH = define("entity.wolf_angry.death");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_ANGRY_GROWL = define("entity.wolf_angry.growl");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_ANGRY_HURT = define("entity.wolf_angry.hurt");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_ANGRY_PANT = define("entity.wolf_angry.pant");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_ANGRY_WHINE = define("entity.wolf_angry.whine");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_GRUMPY_AMBIENT = define("entity.wolf_grumpy.ambient");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_GRUMPY_DEATH = define("entity.wolf_grumpy.death");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_GRUMPY_GROWL = define("entity.wolf_grumpy.growl");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_GRUMPY_HURT = define("entity.wolf_grumpy.hurt");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_GRUMPY_PANT = define("entity.wolf_grumpy.pant");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_GRUMPY_WHINE = define("entity.wolf_grumpy.whine");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_BIG_AMBIENT = define("entity.wolf_big.ambient");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_BIG_DEATH = define("entity.wolf_big.death");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_BIG_GROWL = define("entity.wolf_big.growl");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_BIG_HURT = define("entity.wolf_big.hurt");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_BIG_PANT = define("entity.wolf_big.pant");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_BIG_WHINE = define("entity.wolf_big.whine");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_CUTE_AMBIENT = define("entity.wolf_cute.ambient");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_CUTE_DEATH = define("entity.wolf_cute.death");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_CUTE_GROWL = define("entity.wolf_cute.growl");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_CUTE_HURT = define("entity.wolf_cute.hurt");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_CUTE_PANT = define("entity.wolf_cute.pant");
    /**
     * Added with 1.21.5
     */
    public static final Sound ENTITY_WOLF_CUTE_WHINE = define("entity.wolf_cute.whine");

    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRIED_GHAST_BREAK = define("block.dried_ghast.break");
    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRIED_GHAST_STEP = define("block.dried_ghast.step");
    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRIED_GHAST_FALL = define("block.dried_ghast.fall");
    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRIED_GHAST_AMBIENT = define("block.dried_ghast.ambient");
    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRIED_GHAST_AMBIENT_WATER = define("block.dried_ghast.ambient_water");
    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRIED_GHAST_PLACE = define("block.dried_ghast.place");
    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRIED_GHAST_PLACE_IN_WATER = define("block.dried_ghast.place_in_water");
    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRIED_GHAST_TRANSITION = define("block.dried_ghast.transition");
    /**
     * Added with 1.21.6
     */
    public static final Sound BLOCK_DRY_GRASS_AMBIENT = define("block.dry_grass.ambient");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_GHASTLING_AMBIENT = define("entity.ghastling.ambient");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_GHASTLING_DEATH = define("entity.ghastling.death");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_GHASTLING_HURT = define("entity.ghastling.hurt");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_GHASTLING_SPAWN = define("entity.ghastling.spawn");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_HAPPY_GHAST_AMBIENT = define("entity.happy_ghast.ambient");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_HAPPY_GHAST_DEATH = define("entity.happy_ghast.death");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_HAPPY_GHAST_HURT = define("entity.happy_ghast.hurt");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_HAPPY_GHAST_RIDING = define("entity.happy_ghast.riding");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_HAPPY_GHAST_EQUIP = define("entity.happy_ghast.equip");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_HAPPY_GHAST_UNEQUIP = define("entity.happy_ghast.unequip");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_HAPPY_GHAST_HARNESS_GOGGLES_UP = define("entity.happy_ghast.harness_goggles_up");
    /**
     * Added with 1.21.6
     */
    public static final Sound ENTITY_HAPPY_GHAST_HARNESS_GOGGLES_DOWN = define("entity.happy_ghast.harness_goggles_down");
    /**
     * Added with 1.21.6
     */
    public static final Sound ITEM_HORSE_ARMOR_UNEQUIP = define("item.horse_armor.unequip");
    /**
     * Added with 1.21.6
     */
    public static final Sound ITEM_LEAD_UNTIED = define("item.lead.untied");
    /**
     * Added with 1.21.6
     */
    public static final Sound ITEM_LEAD_TIED = define("item.lead.tied");
    /**
     * Added with 1.21.6
     */
    public static final Sound ITEM_LEAD_BREAK = define("item.lead.break");
    /**
     * Added with 1.21.6
     */
    public static final Sound ITEM_LLAMA_CARPET_UNEQUIP = define("item.llama_carpet.unequip");
    /**
     * Added with 1.21.6
     */
    public static final Sound MUSIC_DISC_TEARS = define("music_disc.tears");
    /**
     * Added with 1.21.6
     */
    public static final Sound ITEM_SHEARS_SNIP = define("item.shears.snip");
    /**
     * Added with 1.21.6
     */
    public static final Sound ITEM_SADDLE_UNEQUIP = define("item.saddle.unequip");

    /**
     * Returns an immutable view of the sounds.
     *
     * @return Sounds
     */
    public static Collection<Sound> values() {
        return REGISTRY.getEntries();
    }

    static {
        REGISTRY.unloadMappings();
    }
}
