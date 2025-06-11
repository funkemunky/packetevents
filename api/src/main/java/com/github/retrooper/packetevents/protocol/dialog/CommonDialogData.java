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

package com.github.retrooper.packetevents.protocol.dialog;

import com.github.retrooper.packetevents.protocol.dialog.input.DialogInput;
import net.kyori.adventure.text.Component;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

import java.util.List;

@NullMarked
public final class CommonDialogData {

    private final Component title;
    private final @Nullable Component externalTitle;
    private final boolean canCloseWithEscape;
    private final boolean pause;
    private final DialogAction afterAction;
    private final List<DialogBody> body;
    private final List<DialogInput> inputs;

    public CommonDialogData(
            Component title, @Nullable Component externalTitle, boolean canCloseWithEscape, boolean pause,
            DialogAction afterAction, List<DialogBody> body, List<DialogInput> inputs
    ) {
        if (pause && !afterAction.isWillUnpause()) {
            throw new IllegalArgumentException("Dialogs that pause the game must use after_action "
                    + "values that unpause it after user action!");
        }
        this.title = title;
        this.externalTitle = externalTitle;
        this.canCloseWithEscape = canCloseWithEscape;
        this.pause = pause;
        this.afterAction = afterAction;
        this.body = body;
        this.inputs = inputs;
    }

    public Component getTitle() {
        return this.title;
    }

    public @Nullable Component getExternalTitle() {
        return this.externalTitle;
    }

    public boolean isCanCloseWithEscape() {
        return this.canCloseWithEscape;
    }

    public boolean isPause() {
        return this.pause;
    }

    public DialogAction getAfterAction() {
        return this.afterAction;
    }

    public List<DialogBody> getBody() {
        return this.body;
    }

    public List<DialogInput> getInputs() {
        return this.inputs;
    }
}
