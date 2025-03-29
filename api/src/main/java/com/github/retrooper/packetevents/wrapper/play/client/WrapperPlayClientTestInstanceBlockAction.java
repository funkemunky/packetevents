package com.github.retrooper.packetevents.wrapper.play.client;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.protocol.world.TestInstanceData;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;

public class WrapperPlayClientTestInstanceBlockAction extends PacketWrapper<WrapperPlayClientTestInstanceBlockAction> {

    private Vector3i position;
    private Action action;
    private TestInstanceData data;

    public WrapperPlayClientTestInstanceBlockAction(PacketReceiveEvent event) {
        super(event);
    }

    public WrapperPlayClientTestInstanceBlockAction(Vector3i position, Action action, TestInstanceData data) {
        super(PacketType.Play.Client.TEST_INSTANCE_BLOCK_ACTION);
        this.position = position;
        this.action = action;
        this.data = data;
    }

    @Override
    public void read() {
        this.position = this.readBlockPosition();
        this.action = this.readEnum(Action.class);
        this.data = TestInstanceData.read(this);
    }

    @Override
    public void write() {
        this.writeBlockPosition(this.position);
        this.writeEnum(this.action);
        TestInstanceData.write(this, this.data);
    }

    @Override
    public void copy(WrapperPlayClientTestInstanceBlockAction wrapper) {
        this.position = wrapper.position;
        this.action = wrapper.action;
        this.data = wrapper.data;
    }

    public Vector3i getPosition() {
        return this.position;
    }

    public void setPosition(Vector3i position) {
        this.position = position;
    }

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public TestInstanceData getData() {
        return this.data;
    }

    public void setData(TestInstanceData data) {
        this.data = data;
    }

    public enum Action {
        INIT,
        QUERY,
        SET,
        RESET,
        SAVE,
        EXPORT,
        RUN,
    }
}
