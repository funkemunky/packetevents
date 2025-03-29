package com.github.retrooper.packetevents.wrapper.play.client;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

public class WrapperPlayClientSetTestBlock extends PacketWrapper<WrapperPlayClientSetTestBlock> {

    private Vector3i position;
    private TestBlockMode mode;
    private String message;

    public WrapperPlayClientSetTestBlock(PacketReceiveEvent event) {
        super(event);
    }

    public WrapperPlayClientSetTestBlock(Vector3i position, TestBlockMode mode, String message) {
        super(PacketType.Play.Client.SET_TEST_BLOCK);
        this.position = position;
        this.mode = mode;
        this.message = message;
    }

    @Override
    public void read() {
        this.position = this.readBlockPosition();
        this.mode = this.readEnum(TestBlockMode.class);
        this.message = this.readString();
    }

    @Override
    public void write() {
        this.writeBlockPosition(this.position);
        this.writeEnum(this.mode);
        this.writeString(this.message);
    }

    @Override
    public void copy(WrapperPlayClientSetTestBlock wrapper) {
        this.position = wrapper.position;
        this.mode = wrapper.mode;
        this.message = wrapper.message;
    }

    public Vector3i getPosition() {
        return this.position;
    }

    public void setPosition(Vector3i position) {
        this.position = position;
    }

    public TestBlockMode getMode() {
        return this.mode;
    }

    public void setMode(TestBlockMode mode) {
        this.mode = mode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum TestBlockMode {

        START,
        LOG,
        FAIL,
        ACCEPT,
    }
}
