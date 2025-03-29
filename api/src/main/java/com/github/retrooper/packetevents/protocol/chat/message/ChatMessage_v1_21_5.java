package com.github.retrooper.packetevents.protocol.chat.message;

import com.github.retrooper.packetevents.protocol.chat.ChatType;
import com.github.retrooper.packetevents.protocol.chat.LastSeenMessages;
import com.github.retrooper.packetevents.protocol.chat.filter.FilterMask;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

//We'll extend ChatMessage_v1_19_3 for now, hopefully no breaking changes in the future
public class ChatMessage_v1_21_5 extends ChatMessage_v1_19_3 {

    int globalIndex;

    public ChatMessage_v1_21_5(int globalIndex, UUID senderUUID, int index, byte[] signature, String plainContent,
                               Instant timestamp, long salt, LastSeenMessages.Packed lastSeenMessagesPacked, @Nullable Component unsignedChatContent,
                               FilterMask filterMask, ChatType.Bound chatFormatting) {
        super(senderUUID, index, signature, plainContent, timestamp, salt, lastSeenMessagesPacked, unsignedChatContent, filterMask, chatFormatting);
        this.globalIndex = globalIndex;
    }

    public int getGlobalIndex() {
        return this.globalIndex;
    }

    public void setGlobalIndex(int globalIndex) {
        this.globalIndex = globalIndex;
    }
}
