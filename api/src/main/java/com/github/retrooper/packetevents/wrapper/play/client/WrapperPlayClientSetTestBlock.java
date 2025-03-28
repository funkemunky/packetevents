package com.github.retrooper.packetevents.wrapper.play.client;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

public class WrapperPlayClientSetTestBlock extends PacketWrapper<WrapperPlayClientSetTestBlock> {
    private Vector3i blockPosition;
    private TestBlockMode mode;
    private String message;

    public WrapperPlayClientSetTestBlock(PacketReceiveEvent event) {
        super(event);
    }

    public WrapperPlayClientSetTestBlock(Vector3i blockPosition, TestBlockMode mode, String message) {
        super(PacketType.Play.Client.SET_TEST_BLOCK);
        this.blockPosition = blockPosition;
        this.mode = mode;
        this.message = message;
    }

    @Override
    public void read() {
        this.blockPosition = readBlockPosition();
        this.mode = readEnum(TestBlockMode.class);
        this.message = readString();
    }

    @Override
    public void write() {
        writeBlockPosition(blockPosition);
        writeEnum(mode);
        writeString(message);
    }


    @Override
    public void copy(WrapperPlayClientSetTestBlock wrapper) {
        this.blockPosition = wrapper.blockPosition;
        this.mode = wrapper.mode;
        this.message = wrapper.message;
    }

    public Vector3i getBlockPosition() {
        return blockPosition;
    }

    public void setBlockPosition(Vector3i blockPosition) {
        this.blockPosition = blockPosition;
    }

    public TestBlockMode getMode() {
        return mode;
    }

    public void setMode(TestBlockMode mode) {
        this.mode = mode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum TestBlockMode {
        START,
        LOG,
        FAIL,
        ACCEPT;

        public String getDisplayName() {
            return name().toLowerCase();
        }
    }
}
