package io.github.retrooper.packetevents.utils;

import io.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.enums.ServerVersion;

public class BaseBlockUtils {
    private static final ServerVersion version = PacketEvents.getServerVersion();

    public static String getPosXFieldName() {
        return "a";
    }

    public static String getPosYFieldName() {
        if (version == ServerVersion.v_1_8) {
            return "b";
        } else if (version == ServerVersion.v_1_8_3
                || version == ServerVersion.v_1_8_8
                || version == ServerVersion.v_1_9) {
            return "c";
        }
        //1.9.4 and higher
        return "b";
    }

    public static String getPosZFieldName() {
        if (version == ServerVersion.v_1_8) {
            return "c";
        } else if (version == ServerVersion.v_1_8_3 || version == ServerVersion.v_1_8_8 || version == ServerVersion.v_1_9) {
            return "d";
        }
        return "c";
    }
}