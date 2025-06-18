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

package com.github.retrooper.packetevents.wrapper.common.server;

import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketTypeCommon;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPong;

/**
 * This packet is currently used by mods to synchronize the client with the server.
 * It is not used by the vanilla server.
 * Most likely added as a replacement to the removed Window Confirmation packet.
 *
 * @see WrapperPlayClientPong
 */
public class WrapperCommonServerPing<T extends WrapperCommonServerPing<T>> extends PacketWrapper<T> {

    private int id;

    public WrapperCommonServerPing(PacketSendEvent event) {
        super(event);
    }

    public WrapperCommonServerPing(PacketTypeCommon packetType, int id) {
        super(packetType);
        this.id = id;
    }

    @Override
    public void read() {
        this.id = this.readInt();
    }

    @Override
    public void write() {
        this.writeInt(this.id);
    }

    @Override
    public void copy(T wrapper) {
        this.id = wrapper.getId();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
