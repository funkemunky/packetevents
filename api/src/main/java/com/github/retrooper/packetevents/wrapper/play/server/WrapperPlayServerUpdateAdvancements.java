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

package com.github.retrooper.packetevents.wrapper.play.server;

import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.manager.server.ServerVersion;
import com.github.retrooper.packetevents.protocol.item.ItemStack;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.resources.ResourceLocation;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.Nullable;

public class WrapperPlayServerUpdateAdvancements extends PacketWrapper<WrapperPlayServerUpdateAdvancements> {
    private boolean reset;
    private AdvancementHolder[] advancements;
    private String[] removedAdvancements;
    private Map<String, List<AdvancementProgress>> progress;// key = advancement id
    private Optional<Boolean> showAdvancements = Optional.empty(); // 1.21.5+

    public WrapperPlayServerUpdateAdvancements(PacketSendEvent event) {
        super(event);
    }

    public WrapperPlayServerUpdateAdvancements(boolean reset, AdvancementHolder[] advancements, String[] removedAdvancements, Map<String, List<AdvancementProgress>> progress, Optional<Boolean> showAdvancements) {
        super(PacketType.Play.Server.UPDATE_ADVANCEMENTS);
        this.reset = reset;
        this.advancements = advancements;
        this.removedAdvancements = removedAdvancements;
        this.progress = progress;
        this.showAdvancements = showAdvancements;
    }

    @Override
    public void read() {
        reset = readBoolean();
        advancements = new AdvancementHolder[readVarInt()];
        for (int i = 0; i < advancements.length; i++) {
            ResourceLocation id = readIdentifier();
            advancements[i] = new AdvancementHolder(id, Advancement.read(this, serverVersion));
        }
        removedAdvancements = new String[readVarInt()];
        for (int i = 0; i < removedAdvancements.length; i++) {
            removedAdvancements[i] = readString();
        }
        progress = readMap(PacketWrapper::readString, packetWrapper -> {
            List<AdvancementProgress> list = new ArrayList<>();
            int size = packetWrapper.readVarInt();
            for (int i = 0; i < size; i++) {
                String criteria = packetWrapper.readString();
                Optional<Long> time = Optional.empty();
                if (readBoolean()) {
                    time = Optional.of(readLong());
                }
                list.add(new AdvancementProgress(criteria, time));
            }
            return list;
        });
        if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_21_5)) {
            showAdvancements = Optional.of(readBoolean());
        }
    }

    @Override
    public void write() {
        writeBoolean(reset);
        writeVarInt(advancements.length);
        for (AdvancementHolder advancementHolder : advancements) {
            writeIdentifier(advancementHolder.identifier);
            Advancement.write(this, serverVersion, advancementHolder.advancement);
        }
        writeVarInt(removedAdvancements.length);
        for (String removedAdvancement : removedAdvancements) {
            writeString(removedAdvancement);
        }
        writeMap(progress, PacketWrapper::writeString, (packetWrapper, progresses) -> {
            packetWrapper.writeVarInt(progresses.size());
            for (AdvancementProgress advancementProgress : progresses) {
                packetWrapper.writeString(advancementProgress.getCriteriaId());
                if (advancementProgress.getTime().isPresent()) {
                    packetWrapper.writeBoolean(true);
                    packetWrapper.writeLong(advancementProgress.getTime().get());
                } else {
                    packetWrapper.writeBoolean(false);
                }
            }
        });
        if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_21_5)) {
            writeBoolean(showAdvancements.orElse(false));
        }
    }

    @Override
    public void copy(WrapperPlayServerUpdateAdvancements wrapper) {
        this.reset = wrapper.reset;
        this.advancements = wrapper.advancements;
        this.removedAdvancements = wrapper.removedAdvancements;
        this.progress = wrapper.progress;
        this.showAdvancements = wrapper.showAdvancements;
    }

    public boolean isReset() {
        return reset;
    }

    public AdvancementHolder[] getAdvancements() {
        return advancements;
    }

    public String[] getRemovedAdvancements() {
        return removedAdvancements;
    }

    public Map<String, List<AdvancementProgress>> getProgress() {
        return progress;
    }

    public Optional<Boolean> getShowAdvancements() {
        return showAdvancements;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public void setAdvancements(AdvancementHolder[] advancements) {
        this.advancements = advancements;
    }

    public void setRemovedAdvancements(String[] removedAdvancements) {
        this.removedAdvancements = removedAdvancements;
    }

    public void setProgress(Map<String, List<AdvancementProgress>> progress) {
        this.progress = progress;
    }

    public void setShowAdvancements(Optional<Boolean> showAdvancements) {
        this.showAdvancements = showAdvancements;
    }

    public static class AdvancementHolder {
        private ResourceLocation identifier;
        private Advancement advancement;

        public AdvancementHolder(ResourceLocation identifier, Advancement advancement) {
            this.identifier = identifier;
            this.advancement = advancement;
        }

        public ResourceLocation getIdentifier() {
            return identifier;
        }

        public void setIdentifier(ResourceLocation identifier) {
            this.identifier = identifier;
        }

        public Advancement getAdvancement() {
            return advancement;
        }

        public void setAdvancement(Advancement advancement) {
            this.advancement = advancement;
        }
    }

    public static class Advancement {
        private @Nullable ResourceLocation parent;
        private AdvancementDisplay display;
        // 1.20.1-
        private Optional<String[]> criteria;
        private List<String[]> requirements;
        // 1.20+
        private Optional<Boolean> sendsTelemetryData;

        public Advancement(@Nullable ResourceLocation parent, AdvancementDisplay display, Optional<String[]> criteria, List<String[]> requirements, Optional<Boolean> sendsTelemetryData) {
            this.parent = parent;
            this.display = display;
            this.criteria = criteria;
            this.requirements = requirements;
            this.sendsTelemetryData = sendsTelemetryData;
        }

        public static Advancement read(PacketWrapper<?> wrapper, ServerVersion serverVersion) {
            ResourceLocation parentId = wrapper.readOptional(ResourceLocation::read);

            AdvancementDisplay display = wrapper.readOptional(AdvancementDisplay::read);
            Optional<String[]> criteria = Optional.empty();
            if (serverVersion.isOlderThanOrEquals(ServerVersion.V_1_20_1)) {
                String[] criteriaArray = new String[wrapper.readVarInt()];
                for (int j = 0; j < criteriaArray.length; j++) {
                    criteriaArray[j] = wrapper.readString();
                }
                criteria = Optional.of(criteriaArray);
            }
            List<String[]> requirements = new ArrayList<>();
            int requirementsSize = wrapper.readVarInt();
            for (int j = 0; j < requirementsSize; j++) {
                String[] requirement = new String[wrapper.readVarInt()];
                for (int k = 0; k < requirement.length; k++) {
                    requirement[k] = wrapper.readString();
                }
                requirements.add(requirement);
            }
            Optional<Boolean> sendsTelemetryData = Optional.empty();
            if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20)) {
                sendsTelemetryData = Optional.of(wrapper.readBoolean());
            }
            return new Advancement(parentId, display, criteria, requirements, sendsTelemetryData);
        }

        public static void write(PacketWrapper<?> packetWrapper, final ServerVersion serverVersion, Advancement advancement) {
            packetWrapper.writeOptional(advancement.getParent(), PacketWrapper::writeIdentifier);
            packetWrapper.writeOptional(advancement.getDisplay(), AdvancementDisplay::write);
            if (serverVersion.isOlderThanOrEquals(ServerVersion.V_1_20_1)) {
                String[] criteriaArray = advancement.getCriteria().orElse(new String[0]);
                packetWrapper.writeVarInt(criteriaArray.length);
                for (String criteria : criteriaArray) {
                    packetWrapper.writeString(criteria);
                }
            }
            packetWrapper.writeVarInt(advancement.getRequirements().size());
            for (String[] requirement : advancement.getRequirements()) {
                packetWrapper.writeVarInt(requirement.length);
                for (String s : requirement) {
                    packetWrapper.writeString(s);
                }
            }
            if (serverVersion.isNewerThanOrEquals(ServerVersion.V_1_20)) {
                packetWrapper.writeBoolean(advancement.isSendsTelemetryData().orElse(false));
            }
        }

        public @Nullable ResourceLocation getParent() {
            return parent;
        }

        public AdvancementDisplay getDisplay() {
            return display;
        }

        public Optional<String[]> getCriteria() {
            return criteria;
        }

        public List<String[]> getRequirements() {
            return requirements;
        }

        public Optional<Boolean> isSendsTelemetryData() {
            return sendsTelemetryData;
        }

        public void setParent(@Nullable ResourceLocation parent) {
            this.parent = parent;
        }

        public void setDisplay(AdvancementDisplay display) {
            this.display = display;
        }

        public void setCriteria(Optional<String[]> criteria) {
            this.criteria = criteria;
        }

        public void setRequirements(List<String[]> requirements) {
            this.requirements = requirements;
        }

        public void setSendsTelemetryData(Optional<Boolean> sendsTelemetryData) {
            this.sendsTelemetryData = sendsTelemetryData;
        }
    }

    public static class AdvancementDisplay {
        public static final int SHOW_BACKGROUND_TEXTURE = 0x01;
        public static final int SHOW_TOAST = 0x02;
        public static final int HIDDEN = 0x04;
        private Component title;
        private Component description;
        private ItemStack icon;
        private AdvancementType type;
        private boolean showToast;
        private boolean hidden;
        private @Nullable ResourceLocation background;
        private float x;
        private float y;

        public AdvancementDisplay(Component title, Component description, ItemStack icon, AdvancementType type, @Nullable ResourceLocation background, boolean showToast,
                                  boolean hidden, float x, float y) {
            this.title = title;
            this.description = description;
            this.icon = icon;
            this.type = type;
            this.showToast = showToast;
            this.hidden = hidden;
            this.background = background;
            this.x = x;
            this.y = y;
        }


        public static AdvancementDisplay read(PacketWrapper<?> wrapper) {
            Component title = wrapper.readComponent();
            Component description = wrapper.readComponent();
            ItemStack icon = wrapper.readItemStack();
            AdvancementType type = wrapper.readEnum(AdvancementType.class);
            int flags = wrapper.readInt();
            ResourceLocation background = (flags & SHOW_BACKGROUND_TEXTURE) != 0 ? ResourceLocation.read(wrapper) : null;
            boolean showToast = (flags & SHOW_TOAST) != 0;
            boolean hidden = (flags & HIDDEN) != 0;
            float x = wrapper.readFloat();
            float y = wrapper.readFloat();
            return new AdvancementDisplay(title, description, icon, type, background, showToast, hidden, x, y);
        }

        public static void write(PacketWrapper<?> wrapper, AdvancementDisplay display) {
            wrapper.writeComponent(display.title);
            wrapper.writeComponent(display.description);
            wrapper.writeItemStack(display.icon);
            wrapper.writeEnum(display.type);
            int flags = display.flags();
            wrapper.writeInt(flags);
            if (display.background != null) {
                ResourceLocation.write(wrapper, display.background);
            }
            wrapper.writeFloat(display.x);
            wrapper.writeFloat(display.y);
        }

        public int flags() {
            int flags = 0;
            if (background != null) {
                flags |= SHOW_BACKGROUND_TEXTURE;
            }
            if (showToast) {
                flags |= SHOW_TOAST;
            }
            if (hidden) {
                flags |= HIDDEN;
            }
            return flags;
        }

        public Component getTitle() {
            return title;
        }

        public Component getDescription() {
            return description;
        }

        public ItemStack getIcon() {
            return icon;
        }

        public AdvancementType getType() {
            return type;
        }

        public boolean isShowToast() {
            return showToast;
        }

        public boolean isHidden() {
            return hidden;
        }

        @Nullable
        public ResourceLocation getBackground() {
            return background;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public void setTitle(Component title) {
            this.title = title;
        }

        public void setDescription(Component description) {
            this.description = description;
        }

        public void setIcon(ItemStack icon) {
            this.icon = icon;
        }

        public void setType(AdvancementType type) {
            this.type = type;
        }

        public void setShowToast(boolean showToast) {
            this.showToast = showToast;
        }

        public void setHidden(boolean hidden) {
            this.hidden = hidden;
        }

        public void setBackground(@Nullable ResourceLocation background) {
            this.background = background;
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }
    }

    public enum AdvancementType {
        TASK, CHALLENGE, GOAL;

        public static AdvancementType getById(int id) {
            return values()[id];
        }

        public int getId() {
            return ordinal();
        }
    }

    public static class AdvancementProgress {
        private String criteriaId;
        private Optional<Long> time;

        public AdvancementProgress(String criteriaId, Optional<Long> time) {
            this.criteriaId = criteriaId;
            this.time = time;
        }

        public AdvancementProgress(String criteriaId) {
            this(criteriaId, Optional.empty());
        }

        public String getCriteriaId() {
            return criteriaId;
        }

        public Optional<Long> getTime() {
            return time;
        }

        public void setCriteriaId(String criteriaId) {
            this.criteriaId = criteriaId;
        }

        public void setTime(Optional<Long> time) {
            this.time = time;
        }
    }
}
