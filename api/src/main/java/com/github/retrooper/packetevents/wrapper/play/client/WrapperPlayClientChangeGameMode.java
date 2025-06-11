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

package com.github.retrooper.packetevents.wrapper.play.client;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.player.GameMode;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

public class WrapperPlayClientChangeGameMode extends PacketWrapper<WrapperPlayClientChangeGameMode> {

    private GameMode gamemode;

    public WrapperPlayClientChangeGameMode(PacketReceiveEvent event) {
        super(event);
    }

    public WrapperPlayClientChangeGameMode(GameMode gamemode) {
        super(PacketType.Play.Client.CHANGE_GAME_MODE);
        this.gamemode = gamemode;
    }

    @Override
    public void read() {
        this.gamemode = GameMode.getById(this.readVarInt());
    }

    @Override
    public void write() {
        this.writeVarInt(this.gamemode.getId());
    }

    @Override
    public void copy(WrapperPlayClientChangeGameMode wrapper) {
        this.gamemode = wrapper.gamemode;
    }

    public GameMode getGamemode() {
        return this.gamemode;
    }

    public void setGamemode(GameMode gamemode) {
        this.gamemode = gamemode;
    }
}
