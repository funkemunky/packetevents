package com.github.retrooper.packetevents.wrapper.play.client;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.util.Vector3i;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import org.jetbrains.annotations.ApiStatus;

//TODO Incomplete
@ApiStatus.Experimental
public class WrapperPlayClientTestInstanceBlockAction extends PacketWrapper<WrapperPlayClientTestInstanceBlockAction> {
    private Vector3i blockPosition;
    private Action action;
    //TODO IMPLEMENT TEST INSTANCE BLOCK DATA, so we can read it

    public WrapperPlayClientTestInstanceBlockAction(PacketReceiveEvent event) {
        super(event);
    }

    public WrapperPlayClientTestInstanceBlockAction(Vector3i blockPosition, Action action, String message) {
        super(PacketType.Play.Client.TEST_INSTANCE_BLOCK_ACTION);
        this.blockPosition = blockPosition;
        this.action = action;
    }

    @Override
    public void read() {
        this.blockPosition = readBlockPosition();
        this.action = readEnum(Action.class);

    }

    @Override
    public void write() {
        writeBlockPosition(blockPosition);
        writeEnum(action);

    }


    @Override
    public void copy(WrapperPlayClientTestInstanceBlockAction wrapper) {
        this.blockPosition = wrapper.blockPosition;
        this.action = wrapper.action;
    }

    public Vector3i getBlockPosition() {
        return blockPosition;
    }

    public void setBlockPosition(Vector3i blockPosition) {
        this.blockPosition = blockPosition;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }


    public enum Action {
        INIT,
        QUERY,
        SET,
        RESET,
        SAVE,
        EXPORT,
        RUN;

        public String getDisplayName() {
            return name().toLowerCase();
        }
    }
}
