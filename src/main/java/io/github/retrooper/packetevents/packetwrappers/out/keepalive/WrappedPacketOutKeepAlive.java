/*
 * MIT License
 *
 * Copyright (c) 2020 retrooper
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.retrooper.packetevents.packetwrappers.out.keepalive;

import io.github.retrooper.packetevents.packet.PacketTypeClasses;
import io.github.retrooper.packetevents.packetwrappers.SendableWrapper;
import io.github.retrooper.packetevents.packetwrappers.WrappedPacket;
import io.github.retrooper.packetevents.utils.reflection.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WrappedPacketOutKeepAlive extends WrappedPacket implements SendableWrapper {
    private static Class<?> packetClass;
    private static Constructor<?> keepAliveConstructor;
    private static boolean integerMode;
    private long id;

    public WrappedPacketOutKeepAlive(Object packet) {
        super(packet);
    }

    public WrappedPacketOutKeepAlive(long id) {
        super();
    }

    public static void load() {
        packetClass = PacketTypeClasses.Server.KEEP_ALIVE;
        integerMode = Reflection.getField(packetClass, int.class, 0) != null;

        if (integerMode) {
            try {
                keepAliveConstructor = packetClass.getConstructor(int.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } else {
            try {
                keepAliveConstructor = packetClass.getConstructor(long.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void setup() {
        if(integerMode) {
            this.id = readInt(0);
        }
        else {
            this.id = readLong(0);
        }
    }

    /**
     * Get the Keep Alive ID.
     *
     * You may cast this down to an int if you are on 1.7.10 - 1.12.2.
     * On 1.13.2 - 1.16.2 a long is sent.
     *
     * @return Get Keep Alive ID
     */
    public long getId() {
        return id;
    }

    @Override
    public Object asNMSPacket() {
        if (integerMode) {
            try {
                return keepAliveConstructor.newInstance((int) id);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            try {
                return keepAliveConstructor.newInstance(id);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
