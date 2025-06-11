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

package com.github.retrooper.packetevents.protocol.dialog.input;

import com.github.retrooper.packetevents.util.mappings.VersionedRegistry;
import org.jetbrains.annotations.ApiStatus;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class InputControlTypes {

    private static final VersionedRegistry<InputControl.Type<?>> REGISTRY = new VersionedRegistry<>("input_control_type");

    private InputControlTypes() {
    }

    public static VersionedRegistry<InputControl.Type<?>> getRegistry() {
        return REGISTRY;
    }

    @ApiStatus.Internal
    public static <T extends InputControl> InputControl.Type<T> define(
            String name, InputControl.Decoder<T> decoder, InputControl.Encoder<T> encoder
    ) {
        return REGISTRY.define(name, data ->
                new StaticInputControlType<>(data, decoder, encoder));
    }

    public static final InputControl.Type<BooleanInputControl> BOOLEAN = define("boolean",
            BooleanInputControl::decode, BooleanInputControl::encode);
    public static final InputControl.Type<NumberRangeInputControl> NUMBER_RANGE = define("number_range",
            NumberRangeInputControl::decode, NumberRangeInputControl::encode);
    public static final InputControl.Type<SingleOptionInputControl> SINGLE_OPTION = define("single_option",
            SingleOptionInputControl::decode, SingleOptionInputControl::encode);
    public static final InputControl.Type<TextInputControl> TEXT = define("text",
            TextInputControl::decode, TextInputControl::encode);

    static {
        REGISTRY.unloadMappings();
    }
}
