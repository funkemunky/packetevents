/*
 * This file is part of packetevents - https://github.com/retrooper/packetevents
 * Copyright (C) 2024 retrooper and contributors
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

package com.github.retrooper.packetevents.util.adventure;

import com.github.retrooper.packetevents.PacketEvents;
import com.github.retrooper.packetevents.protocol.dialog.Dialog;
import com.github.retrooper.packetevents.protocol.nbt.NBT;
import com.github.retrooper.packetevents.protocol.nbt.NBTByte;
import com.github.retrooper.packetevents.protocol.nbt.NBTByteArray;
import com.github.retrooper.packetevents.protocol.nbt.NBTCompound;
import com.github.retrooper.packetevents.protocol.nbt.NBTDouble;
import com.github.retrooper.packetevents.protocol.nbt.NBTFloat;
import com.github.retrooper.packetevents.protocol.nbt.NBTInt;
import com.github.retrooper.packetevents.protocol.nbt.NBTIntArray;
import com.github.retrooper.packetevents.protocol.nbt.NBTList;
import com.github.retrooper.packetevents.protocol.nbt.NBTLong;
import com.github.retrooper.packetevents.protocol.nbt.NBTLongArray;
import com.github.retrooper.packetevents.protocol.nbt.NBTNumber;
import com.github.retrooper.packetevents.protocol.nbt.NBTShort;
import com.github.retrooper.packetevents.protocol.nbt.NBTString;
import com.github.retrooper.packetevents.protocol.nbt.NBTType;
import com.github.retrooper.packetevents.protocol.player.ClientVersion;
import com.github.retrooper.packetevents.util.UniqueIdUtil;
import com.github.retrooper.packetevents.wrapper.PacketWrapper;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.nbt.api.BinaryTagHolder;
import net.kyori.adventure.text.BlockNBTComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentBuilder;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.EntityNBTComponent;
import net.kyori.adventure.text.KeybindComponent;
import net.kyori.adventure.text.NBTComponent;
import net.kyori.adventure.text.ScoreComponent;
import net.kyori.adventure.text.SelectorComponent;
import net.kyori.adventure.text.StorageNBTComponent;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TranslatableComponent;
import net.kyori.adventure.text.TranslationArgument;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.DataComponentValue;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.ShadowColor;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.ComponentSerializer;
import net.kyori.adventure.text.serializer.gson.BackwardCompatUtil;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.github.retrooper.packetevents.util.adventure.AdventureIndexUtil.indexValueOrThrow;

public class AdventureNBTSerializer implements ComponentSerializer<Component, Component, NBT> {

    private final ClientVersion version;
    private final boolean downsampleColor;

    public AdventureNBTSerializer(ClientVersion version, boolean downsampleColor) {
        this.version = version;
        this.downsampleColor = downsampleColor;
    }

    @Deprecated
    public AdventureNBTSerializer(boolean downsampleColor) {
        this(PacketEvents.getAPI().getServerManager().getVersion().toClientVersion(), downsampleColor);
    }

    @Contract(value = "!null -> !null")
    @Deprecated
    @Override
    public @Nullable Component deserializeOrNull(@Nullable NBT input) {
        return this.deserializeOrNull(input, PacketWrapper.createDummyWrapper(this.version));
    }

    @Contract(value = "!null, _ -> !null")
    public @Nullable Component deserializeOrNull(@Nullable NBT input, PacketWrapper<?> wrapper) {
        return input != null ? this.deserialize(input, wrapper) : null;
    }

    @Contract(value = "_, !null -> !null")
    @Deprecated
    @Override
    public @Nullable Component deserializeOr(@Nullable NBT input, @Nullable Component fallback) {
        return this.deserializeOr(input, fallback, PacketWrapper.createDummyWrapper(this.version));
    }

    @Contract(value = "_, !null, _ -> !null")
    public @Nullable Component deserializeOr(@Nullable NBT input, @Nullable Component fallback, PacketWrapper<?> wrapper) {
        return input != null ? this.deserialize(input, wrapper) : fallback;
    }

    @Contract(value = "!null -> !null")
    @Deprecated
    @Override
    public @Nullable NBT serializeOrNull(@Nullable Component component) {
        return this.serializeOrNull(component, PacketWrapper.createDummyWrapper(this.version));
    }

    @Contract(value = "!null, _ -> !null")
    public @Nullable NBT serializeOrNull(@Nullable Component component, PacketWrapper<?> wrapper) {
        return component != null ? this.serialize(component, wrapper) : null;
    }

    @Contract(value = "_, !null -> !null")
    @Deprecated
    @Override
    public @Nullable NBT serializeOr(@Nullable Component component, @Nullable NBT fallback) {
        return this.serializeOr(component, fallback, PacketWrapper.createDummyWrapper(this.version));
    }

    @Contract(value = "_, !null, _ -> !null")
    public @Nullable NBT serializeOr(@Nullable Component component, @Nullable NBT fallback, PacketWrapper<?> wrapper) {
        return component != null ? this.serialize(component, wrapper) : fallback;
    }

    @Deprecated
    @Override
    public @NotNull Component deserialize(@NotNull NBT input) {
        return this.deserialize(input, PacketWrapper.createDummyWrapper(this.version));
    }

    public @NotNull Component deserialize(@NotNull NBT input, PacketWrapper<?> wrapper) {
        if (input.getType() == NBTType.STRING) { // Serialized as string
            return Component.text(((NBTString) input).getValue());
        }

        if (input.getType() == NBTType.BYTE && ((NBTByte) input).getAsByte() < 2) { // Serialized as boolean
            return Component.text(((NBTByte) input).getAsByte() == 1);
        }

        if (input instanceof NBTNumber) { // Serialized as number
            return Component.text(((NBTNumber) input).getAsInt());
        }

        // Serialized as tree
        NBTCompound compound = requireType(input, NBTType.COMPOUND);
        NBTReader reader = new NBTReader(compound);

        Function<NBT, String> textFunction = nbt -> {
            if (nbt.getType() == NBTType.STRING) {
                return ((NBTString) nbt).getValue();
            } else if (nbt.getType() == NBTType.BYTE && ((NBTByte) nbt).getAsByte() < 2) {
                return String.valueOf(((NBTByte) nbt).getAsByte() == 1);
            } else if (nbt instanceof NBTNumber) {
                return String.valueOf(((NBTNumber) nbt).getAsInt());
            } else {
                throw new IllegalStateException("Don't know how to deserialize " + nbt.getType() + " to text");
            }
        };

        String text = reader.read("text", textFunction);
        if (text == null) text = reader.read("", textFunction);

        String translate = reader.readUTF("translate", Function.identity());
        String translateFallback = reader.readUTF("fallback", Function.identity());
        List<? extends ComponentLike> translateWith;
        if (BackwardCompatUtil.IS_4_15_0_OR_NEWER) {
            NBTType<?> type = reader.type("with");
            if (type == NBTType.INT_ARRAY) {
                translateWith = reader.readIntArray("with", params -> {
                    List<TranslationArgument> args = new ArrayList<>(params.length);
                    for (int param : params) {
                        args.add(TranslationArgument.numeric(param));
                    }
                    return args;
                });
            } else if (type == NBTType.BYTE_ARRAY) {
                translateWith = reader.readByteArray("with", params -> {
                    List<TranslationArgument> args = new ArrayList<>(params.length);
                    for (byte param : params) {
                        args.add(TranslationArgument.bool(param != (byte) 0));
                    }
                    return args;
                });
            } else if (type == NBTType.LONG_ARRAY) {
                translateWith = reader.readLongArray("with", params -> {
                    List<TranslationArgument> args = new ArrayList<>(params.length);
                    for (long param : params) {
                        args.add(TranslationArgument.numeric(param));
                    }
                    return args;
                });
            } else {
                translateWith = reader.readList("with", tag -> this.deserializeTranslationArgumentList(tag, wrapper));
            }
        } else {
            translateWith = reader.readList("with", tag -> this.deserializeComponentList(tag, wrapper));
        }
        NBTReader score = reader.child("score");
        String selector = reader.readUTF("selector", Function.identity());
        String keybind = reader.readUTF("keybind", Function.identity());
        String nbt = reader.readUTF("nbt", Function.identity());
        boolean nbtInterpret = Optional.ofNullable(reader.readBoolean("interpret", Function.identity())).orElse(false);
        BlockNBTComponent.Pos nbtBlock = reader.readUTF("block", BlockNBTComponent.Pos::fromString);
        String nbtEntity = reader.readUTF("entity", Function.identity());
        Key nbtStorage = reader.readUTF("storage", Key::key);
        List<Component> extra = reader.readList("extra", tag -> this.deserializeComponentList(tag, wrapper));
        Component separator = reader.read("separator", tag -> this.deserialize(tag, wrapper));
        Style style = this.deserializeStyle(compound, wrapper);

        // build component from read values
        ComponentBuilder<?, ?> builder;
        if (text != null) {
            builder = Component.text().content(text);
        } else if (translate != null) {
            TranslatableComponent.Builder i18nBuilder;
            builder = i18nBuilder = Component.translatable().key(translate);
            if (translateWith != null) {
                if (BackwardCompatUtil.IS_4_15_0_OR_NEWER) {
                    i18nBuilder.arguments(translateWith);
                } else {
                    i18nBuilder.args(translateWith);
                }
            }
            if (BackwardCompatUtil.IS_4_13_0_OR_NEWER) {
                i18nBuilder.fallback(translateFallback);
            }
        } else if (score != null) {
            builder = Component.score()
                    .name(score.readUTF("name", Function.identity()))
                    .objective(score.readUTF("objective", Function.identity()));
        } else if (selector != null) {
            builder = Component.selector().pattern(selector).separator(separator);
        } else if (keybind != null) {
            builder = Component.keybind().keybind(keybind);
        } else if (nbt != null) {
            if (nbtBlock != null) {
                builder = Component.blockNBT()
                        .nbtPath(nbt).interpret(nbtInterpret).separator(separator)
                        .pos(nbtBlock);
            } else if (nbtEntity != null) {
                builder = Component.entityNBT()
                        .nbtPath(nbt).interpret(nbtInterpret).separator(separator)
                        .selector(nbtEntity);
            } else if (nbtStorage != null) {
                builder = Component.storageNBT()
                        .nbtPath(nbt).interpret(nbtInterpret).separator(separator)
                        .storage(nbtStorage);
            } else {
                throw new IllegalStateException("Illegal nbt component, block/entity/storage is missing");
            }
        } else {
            throw new IllegalStateException("Illegal nbt component, component type could not be determined");
        }

        builder.style(style);

        if (extra != null) {
            builder.append(extra);
        }

        return builder.build();
    }

    @Deprecated
    @Override
    public @NotNull NBT serialize(@NotNull Component component) {
        return this.serialize(component, PacketWrapper.createDummyWrapper(this.version));
    }

    public @NotNull NBT serialize(@NotNull Component component, PacketWrapper<?> wrapper) {
        if (component instanceof TextComponent && !component.hasStyling() && component.children().isEmpty()) {
            return new NBTString(((TextComponent) component).content());
        }

        return this.serializeComponent(component, wrapper);
    }

    private @NotNull NBTCompound serializeComponent(Component component, PacketWrapper<?> wrapper) {
        NBTWriter writer = new NBTWriter(new NBTCompound());

        // component parts
        if (component instanceof TextComponent) {
            // text content
            writer.writeUTF("text", ((TextComponent) component).content());
        } else if (component instanceof TranslatableComponent) {
            // translation key
            writer.writeUTF("translate", ((TranslatableComponent) component).key());

            // translation fallback
            if (BackwardCompatUtil.IS_4_13_0_OR_NEWER) {
                String fallback = ((TranslatableComponent) component).fallback();
                if (fallback != null) {
                    writer.writeUTF("fallback", fallback);
                }
            }

            // translation arguments
            List<Component> args = ((TranslatableComponent) component).args();
            if (!args.isEmpty()) {
                if (BackwardCompatUtil.IS_4_15_0_OR_NEWER) {
                    writer.writeList("with", NBTType.COMPOUND, this.serializeTranslationArgumentList(
                            ((TranslatableComponent) component).arguments(), wrapper));
                } else {
                    writer.writeList("with", NBTType.COMPOUND, this.serializeComponentList(args, wrapper));
                }
            }
        } else if (component instanceof ScoreComponent) {
            // nested compound
            NBTWriter score = writer.child("score");

            // score name
            String scoreName = ((ScoreComponent) component).name();
            score.writeUTF("name", scoreName);

            // score objective
            String scoreObjective = ((ScoreComponent) component).objective();
            score.writeUTF("objective", scoreObjective);
        } else if (component instanceof SelectorComponent) {
            // selector
            writer.writeUTF("selector", ((SelectorComponent) component).pattern());

            // separator
            Component separator = ((SelectorComponent) component).separator();
            if (separator != null) writer.write("separator", this.serialize(separator, wrapper));
        } else if (component instanceof KeybindComponent) {
            // keybind
            writer.writeUTF("keybind", ((KeybindComponent) component).keybind());
        } else if (component instanceof NBTComponent<?, ?>) {
            // nbt path
            String nbtPath = ((NBTComponent<?, ?>) component).nbtPath();
            writer.writeUTF("nbt", nbtPath);

            // interpret
            boolean interpret = ((NBTComponent<?, ?>) component).interpret();
            if (interpret) {
                writer.writeBoolean("interpret", true);
            }

            // separator
            Component separator = ((NBTComponent<?, ?>) component).separator();
            if (separator != null) writer.write("separator", this.serialize(separator, wrapper));

            if (component instanceof BlockNBTComponent) {
                // nbt block
                BlockNBTComponent.Pos pos = ((BlockNBTComponent) component).pos();
                writer.writeUTF("block", pos.asString());
            } else if (component instanceof EntityNBTComponent) {
                // nbt entity
                String selector = ((EntityNBTComponent) component).selector();
                writer.writeUTF("entity", selector);
            } else if (component instanceof StorageNBTComponent) {
                // nbt storage key
                Key storage = ((StorageNBTComponent) component).storage();
                writer.writeUTF("storage", storage.asString());
            }
        }

        if (component.hasStyling()) {
            this.serializeStyle(component.style(), wrapper).getTags().forEach(writer::write);
        }

        // component children
        List<Component> children = component.children();
        if (!children.isEmpty()) {
            writer.writeList("extra", NBTType.COMPOUND, this.serializeComponentList(children, wrapper));
        }

        return writer.compound;
    }

    // -------------------- Style --------------------
    @Deprecated
    public @NotNull Style deserializeStyle(NBTCompound input) {
        return this.deserializeStyle(input, PacketWrapper.createDummyWrapper(this.version));
    }

    @SuppressWarnings({"PatternValidation", "rawtypes"})
    public @NotNull Style deserializeStyle(NBTCompound input, PacketWrapper<?> wrapper) {
        if (input.isEmpty()) return Style.empty();

        Style.Builder style = Style.style();
        NBTReader reader = new NBTReader(input);

        reader.useUTF("font", value -> style.font(Key.key(value)));
        reader.useUTF("color", value -> {
            TextColor color = this.deserializeColor(value);
            if (color != null) style.color(color);
        });
        if (BackwardCompatUtil.IS_4_18_0_OR_NEWER) {
            reader.useNumber("shadow_color", num ->
                    style.shadowColor(ShadowColor.shadowColor(num.intValue())));
        }

        for (String decorationKey : TextDecoration.NAMES.keys()) {
            reader.useBoolean(decorationKey, value -> style.decoration(
                    indexValueOrThrow(TextDecoration.NAMES, decorationKey),
                    TextDecoration.State.byBoolean(value)));
        }
        reader.useUTF("insertion", style::insertion);

        boolean modernEvents = this.version.isNewerThanOrEquals(ClientVersion.V_1_21_5);
        NBTReader clickEvent = reader.child(modernEvents ? "click_event" : "clickEvent");
        if (clickEvent != null) {
            ClickEvent.Action action = clickEvent.readUTF("action", ClickEvent.Action.NAMES::value);
            ClickEvent value;
            if (!modernEvents) {
                value = ClickEvent.clickEvent(action, clickEvent.readUTF("value", Function.identity()));
            } else {
                switch (action) {
                    case OPEN_URL:
                        value = ClickEvent.openUrl(clickEvent.readUTF("url", Function.identity()));
                        break;
                    case OPEN_FILE:
                        value = ClickEvent.openFile(clickEvent.readUTF("path", Function.identity()));
                        break;
                    case RUN_COMMAND:
                        value = ClickEvent.runCommand(clickEvent.readUTF("command", Function.identity()));
                        break;
                    case SUGGEST_COMMAND:
                        value = ClickEvent.suggestCommand(clickEvent.readUTF("command", Function.identity()));
                        break;
                    case CHANGE_PAGE:
                        value = ClickEvent.changePage(clickEvent.readNumber("page", Number::intValue));
                        break;
                    case COPY_TO_CLIPBOARD:
                        value = ClickEvent.copyToClipboard(clickEvent.readUTF("value", Function.identity()));
                        break;
                    case SHOW_DIALOG:
                        NBT dialogTag = clickEvent.read("dialog", Function.identity());
                        value = ClickEvent.showDialog(Dialog.decode(dialogTag, wrapper));
                        break;
                    case CUSTOM:
                        Key key = clickEvent.readUTF("id", Key::key);
                        NBT payload = clickEvent.read("payload", Function.identity());
                        value = ClickEvent.custom(key, "0b"); // TODO snbt serialization
                        break;
                    default:
                        throw new UnsupportedOperationException("Unsupported clickevent: " + action);
                }
            }
            style.clickEvent(value);
        }

        NBTReader hoverEvent = reader.child(modernEvents ? "hover_event" : "hoverEvent");
        if (hoverEvent != null) {
            HoverEvent.Action action = hoverEvent.readUTF("action", HoverEvent.Action.NAMES::value);
            switch (action.toString()) {
                case "show_text":
                    style.hoverEvent(HoverEvent.showText(hoverEvent.read(modernEvents ? "value" : "contents",
                            tag -> this.deserialize(tag, wrapper))));
                    break;
                case "show_item":
                    if (!modernEvents && hoverEvent.type("contents") == NBTType.STRING) {
                        style.hoverEvent(HoverEvent.showItem(hoverEvent.readUTF("contents", Key::key), 1));
                        break;
                    }

                    NBTReader item = modernEvents ? hoverEvent : hoverEvent.child("contents");
                    Key itemId = item.readUTF("id", Key::key);
                    Integer count = item.readNumber("count", Number::intValue);
                    int nonNullCount = count == null ? 1 : count;

                    BinaryTagHolder tag = item.readUTF("tag", BinaryTagHolder::binaryTagHolder);
                    if (tag != null || !BackwardCompatUtil.IS_4_17_0_OR_NEWER) {
                        style.hoverEvent(HoverEvent.showItem(itemId, nonNullCount, tag));
                    } else {
                        Map<Key, DataComponentValue> components = item.readCompound("components", nbt -> {
                            Map<Key, DataComponentValue> map = new HashMap<>(nbt.size());
                            for (Map.Entry<String, NBT> entry : nbt.getTags().entrySet()) {
                                if (entry.getKey().startsWith("!")) { // removed component
                                    Key key = Key.key(entry.getKey().substring(1));
                                    map.put(key, DataComponentValue.removed());
                                    continue;
                                }
                                Key key = Key.key(entry.getKey());
                                map.put(key, new NbtTagHolder(entry.getValue()));
                            }
                            return map;
                        });
                        style.hoverEvent(HoverEvent.showItem(itemId, nonNullCount,
                                components == null ? Collections.emptyMap() : components));
                    }
                    break;
                case "show_entity":
                    NBTReader entity = modernEvents ? hoverEvent : hoverEvent.child("contents");
                    style.hoverEvent(HoverEvent.showEntity(
                            entity.readUTF(modernEvents ? "id" : "type", Key::key),
                            entity.readIntArray(modernEvents ? "uuid" : "id", UniqueIdUtil::fromIntArray),
                            entity.read("name", name -> this.deserialize(name, wrapper))));
                    break;
            }
        }

        return style.build();
    }

    @Deprecated
    public @NotNull NBTCompound serializeStyle(Style style) {
        return this.serializeStyle(style, PacketWrapper.createDummyWrapper(this.version));
    }

    public @NotNull NBTCompound serializeStyle(Style style, PacketWrapper<?> wrapper) {
        if (style.isEmpty()) return new NBTCompound();

        NBTWriter writer = new NBTWriter(new NBTCompound());

        Key font = style.font();
        if (font != null) writer.writeUTF("font", font.asString());

        TextColor color = style.color();
        if (color != null) writer.writeUTF("color", this.serializeColor(color));

        if (BackwardCompatUtil.IS_4_18_0_OR_NEWER) {
            ShadowColor shadowColor = style.shadowColor();
            if (shadowColor != null) writer.writeInt("shadow_color", shadowColor.value());
        }

        for (TextDecoration decoration : TextDecoration.NAMES.values()) {
            TextDecoration.State state = style.decoration(decoration);
            if (state != TextDecoration.State.NOT_SET) {
                writer.writeBoolean(decoration.toString(), state == TextDecoration.State.TRUE);
            }
        }

        String insertion = style.insertion();
        if (insertion != null) writer.writeUTF("insertion", insertion);

        ClickEvent clickEvent = style.clickEvent();
        if (clickEvent != null) {
            boolean modern = this.version.isNewerThanOrEquals(ClientVersion.V_1_21_5);
            NBTWriter child = writer.child(modern ? "click_event" : "clickEvent");
            child.writeUTF("action", clickEvent.action().toString());
            if (!modern) {
                child.writeUTF("value", clickEvent.value());
            } else {
                switch (clickEvent.action()) {
                    case OPEN_URL:
                        child.writeUTF("url", clickEvent.value());
                        break;
                    case OPEN_FILE:
                        child.writeUTF("path", clickEvent.value());
                        break;
                    case RUN_COMMAND:
                    case SUGGEST_COMMAND:
                        child.writeUTF("command", clickEvent.value());
                        break;
                    case CHANGE_PAGE:
                        if (BackwardCompatUtil.IS_4_22_0_OR_NEWER) {
                            child.writeInt("page", ((ClickEvent.Payload.Int) clickEvent.payload()).integer());
                        } else {
                            child.writeInt("page", Integer.parseInt(clickEvent.value()));
                        }
                        break;
                    case COPY_TO_CLIPBOARD:
                        child.writeUTF("value", clickEvent.value());
                        break;
                    case SHOW_DIALOG:
                        Dialog dialog = (Dialog) ((ClickEvent.Payload.Dialog) clickEvent.payload()).dialog();
                        child.write("dialog", Dialog.encode(wrapper, dialog));
                        break;
                    case CUSTOM:
                        child.writeUTF("id", ((ClickEvent.Payload.Custom) clickEvent.payload()).key().asString());
                        // TODO snbt deserialization
                        // child.write("payload", ((ClickEvent.Payload.Custom) clickEvent.payload()).data());
                        break;
                    default:
                        throw new UnsupportedOperationException("Unsupported clickevent: " + clickEvent);
                }
            }
        }

        HoverEvent<?> hoverEvent = style.hoverEvent();
        if (hoverEvent != null) {
            boolean modern = this.version.isNewerThanOrEquals(ClientVersion.V_1_21_5);
            NBTWriter child = writer.child(modern ? "hover_event" : "hoverEvent");
            child.writeUTF("action", hoverEvent.action().toString());
            switch (hoverEvent.action().toString()) {
                case "show_text":
                    child.write(modern ? "value" : "contents", this.serialize((Component) hoverEvent.value(), wrapper));
                    break;
                case "show_item":
                    HoverEvent.ShowItem item = (HoverEvent.ShowItem) hoverEvent.value();
                    Key itemId = item.item();
                    int count = item.count();
                    BinaryTagHolder nbt = item.nbt();
                    boolean emptyComps = !BackwardCompatUtil.IS_4_17_0_OR_NEWER || item.dataComponents().isEmpty();

                    // "modern" item stacks are no longer allowed to be inlined
                    if (!modern && count == 1 && nbt == null && emptyComps) {
                        child.writeUTF("contents", itemId.asString());
                    } else {
                        NBTWriter itemNBT = modern ? child : child.child("contents");
                        itemNBT.writeUTF("id", itemId.asString());
                        if (!modern || count != 1) {
                            itemNBT.writeInt("count", count);
                        }
                        if (nbt != null) {
                            itemNBT.writeUTF("tag", nbt.string());
                        }
                        if (!emptyComps) {
                            NBTWriter compsNbt = itemNBT.child("components");
                            for (Map.Entry<Key, DataComponentValue> entry : item.dataComponents().entrySet()) {
                                if (entry.getValue() == DataComponentValue.removed()) {
                                    // I don't think value matters here
                                    compsNbt.writeCompound("!" + entry.getKey(), new NBTCompound());
                                    continue;
                                }
                                if (entry.getValue() instanceof NbtTagHolder) {
                                    NBT compNbt = ((NbtTagHolder) entry.getValue()).getTag();
                                    compsNbt.write(entry.getKey().toString(), compNbt);
                                }
                                // unsupported entry component value, skip for now
                            }
                        }
                    }
                    break;
                case "show_entity":
                    HoverEvent.ShowEntity showEntity = (HoverEvent.ShowEntity) hoverEvent.value();
                    NBTWriter entity = modern ? child : child.child("contents");
                    entity.writeUTF(modern ? "id" : "type", showEntity.type().asString());
                    entity.writeIntArray(modern ? "uuid" : "id", UniqueIdUtil.toIntArray(showEntity.id()));
                    if (showEntity.name() != null) {
                        entity.write("name", this.serialize(showEntity.name(), wrapper));
                    }
                    break;
            }
        }

        return writer.compound;
    }
    // -------------------------------------------------

    // ------------------- TextColor -------------------
    private @Nullable TextColor deserializeColor(final @NotNull String value) {
        final TextColor color;
        if (value.startsWith(TextColor.HEX_PREFIX)) {
            color = TextColor.fromHexString(value);
        } else {
            color = NamedTextColor.NAMES.value(value);
        }

        if (color == null) return null;

        return this.downsampleColor ? NamedTextColor.nearestTo(color) : color;
    }

    @SuppressWarnings("ConstantConditions")
    private @NotNull String serializeColor(final @NotNull TextColor value) {
        if (value instanceof NamedTextColor) {
            return NamedTextColor.NAMES.key((NamedTextColor) value);
        } else if (this.downsampleColor) {
            return NamedTextColor.NAMES.key(NamedTextColor.nearestTo(value));
        } else {
            return String.format(Locale.ROOT, "%c%06X", TextColor.HEX_CHARACTER, value.value());
        }
    }
    // -------------------------------------------------

    // ---------------- Component List -----------------
    private @NotNull List<Component> deserializeComponentList(List<?> value, PacketWrapper<?> wrapper) {
        if (value.isEmpty()) return Collections.emptyList();

        List<Component> components = new ArrayList<>(value.size());
        for (Object nbt : value) {
            components.add(this.deserialize((NBT) nbt, wrapper));
        }

        return components;
    }

    private List<NBTCompound> serializeComponentList(List<Component> value, PacketWrapper<?> wrapper) {
        List<NBTCompound> components = new ArrayList<>(value.size());
        for (Component component : value) {
            components.add(this.serializeComponent(component, wrapper));
        }
        return components;
    }
    // -------------------------------------------------

    // ------------ TranslationArgument List ------------
    private @NotNull List<TranslationArgument> deserializeTranslationArgumentList(List<?> value, PacketWrapper<?> wrapper) {
        if (value.isEmpty()) return Collections.emptyList();

        List<TranslationArgument> arguments = new ArrayList<>(value.size());
        for (Object nbt : value) {
            if (nbt instanceof NBTByte) {
                arguments.add(TranslationArgument.bool(((NBTByte) nbt).getAsByte() != (byte) 0));
            } else if (nbt instanceof NBTNumber) {
                arguments.add(TranslationArgument.numeric(((NBTNumber) nbt).getAsInt()));
            } else if (nbt instanceof NBTString) {
                arguments.add(TranslationArgument.component(Component.text(((NBTString) nbt).getValue())));
            } else {
                arguments.add(TranslationArgument.component(this.deserialize(requireType((NBT) nbt, NBTType.COMPOUND), wrapper)));
            }
        }

        return arguments;
    }

    private List<NBTCompound> serializeTranslationArgumentList(List<TranslationArgument> value, PacketWrapper<?> wrapper) {
        List<NBTCompound> arguments = new ArrayList<>(value.size());
        for (TranslationArgument argument : value) {
            arguments.add(this.serializeComponent(argument.asComponent(), wrapper));
        }
        return arguments;
    }
    // -------------------------------------------------

    static class NBTReader {
        private final NBTCompound compound;

        public NBTReader(NBTCompound compound) {
            this.compound = compound;
        }

        public void useBoolean(String key, Consumer<Boolean> consumer) {
            useNumber(key, num -> consumer.accept(num.byteValue() != 0));
        }

        public <R> R readBoolean(String key, Function<Boolean, R> function) {
            return readNumber(key, num -> function.apply(num.byteValue() != 0));
        }

        public void useNumber(String key, Consumer<Number> consumer) {
            useTag(key, tag -> {
                if (tag instanceof NBTNumber) {
                    consumer.accept(((NBTNumber) tag).getAsNumber());
                } else {
                    throw new IllegalArgumentException("Expected number but got " + tag.getType());
                }
            });
        }

        public <R> R readNumber(String key, Function<Number, R> function) {
            return withTag(key, tag -> {
                if (tag instanceof NBTNumber) {
                    return function.apply(((NBTNumber) tag).getAsNumber());
                } else {
                    throw new IllegalArgumentException("Expected number but got " + tag.getType());
                }
            });
        }

        public void useUTF(String key, Consumer<String> consumer) {
            useTag(key, tag -> consumer.accept(requireType(tag, NBTType.STRING).getValue()));
        }

        public <R> R readUTF(String key, Function<String, R> function) {
            return withTag(key, tag -> function.apply(requireType(tag, NBTType.STRING).getValue()));
        }

        public void useByteArray(String key, Consumer<byte[]> consumer) {
            useTag(key, tag -> consumer.accept(requireType(tag, NBTType.BYTE_ARRAY).getValue()));
        }

        public <R> R readByteArray(String key, Function<byte[], R> function) {
            return withTag(key, tag -> function.apply(requireType(tag, NBTType.BYTE_ARRAY).getValue()));
        }

        public void useIntArray(String key, Consumer<int[]> consumer) {
            useTag(key, tag -> consumer.accept(requireType(tag, NBTType.INT_ARRAY).getValue()));
        }

        public <R> R readIntArray(String key, Function<int[], R> function) {
            return withTag(key, tag -> function.apply(requireType(tag, NBTType.INT_ARRAY).getValue()));
        }

        public void useLongArray(String key, Consumer<long[]> consumer) {
            useTag(key, tag -> consumer.accept(requireType(tag, NBTType.LONG_ARRAY).getValue()));
        }

        public <R> R readLongArray(String key, Function<long[], R> function) {
            return withTag(key, tag -> function.apply(requireType(tag, NBTType.LONG_ARRAY).getValue()));
        }

        public void useCompound(String key, Consumer<NBTCompound> consumer) {
            useTag(key, tag -> consumer.accept(requireType(tag, NBTType.COMPOUND)));
        }

        public <R> R readCompound(String key, Function<NBTCompound, R> function) {
            return withTag(key, tag -> function.apply(requireType(tag, NBTType.COMPOUND)));
        }

        public void useList(String key, Consumer<List<?>> consumer) {
            useTag(key, tag -> consumer.accept(requireType(tag, NBTType.LIST).getTags()));
        }

        public <R> R readList(String key, Function<List<?>, R> function) {
            return withTag(key, tag -> function.apply(requireType(tag, NBTType.LIST).getTags()));
        }

        public void use(String key, Consumer<NBT> consumer) {
            useTag(key, consumer);
        }

        public <R> R read(String key, Function<NBT, R> function) {
            return withTag(key, function);
        }

        public NBTReader child(String key) {
            return withTag(key, tag -> new NBTReader(requireType(tag, NBTType.COMPOUND)));
        }

        public NBTType<?> type(String key) {
            return withTag(key, NBT::getType);
        }

        private void useTag(String key, Consumer<NBT> consumer) {
            NBT tag = compound.getTagOrNull(key);
            if (tag != null) {
                consumer.accept(tag);
            }
        }

        private <R> R withTag(String key, Function<NBT, R> function) {
            NBT tag = compound.getTagOrNull(key);
            return tag == null ? null : function.apply(tag);
        }
    }

    static class NBTWriter {
        private final NBTCompound compound;

        public NBTWriter(NBTCompound compound) {
            this.compound = compound;
        }

        public void writeBoolean(String key, boolean value) {
            compound.setTag(key, new NBTByte(value ? (byte) 1 : (byte) 0));
        }

        public void writeByte(String key, byte value) {
            compound.setTag(key, new NBTByte(value));
        }

        public void writeShort(String key, short value) {
            compound.setTag(key, new NBTShort(value));
        }

        public void writeInt(String key, int value) {
            compound.setTag(key, new NBTInt(value));
        }

        public void writeLong(String key, long value) {
            compound.setTag(key, new NBTLong(value));
        }

        public void writeFloat(String key, float value) {
            compound.setTag(key, new NBTFloat(value));
        }

        public void writeDouble(String key, double value) {
            compound.setTag(key, new NBTDouble(value));
        }

        public void writeUTF(String key, String value) {
            compound.setTag(key, new NBTString(value));
        }

        public void writeByteArray(String key, byte[] value) {
            compound.setTag(key, new NBTByteArray(value));
        }

        public void writeIntArray(String key, int[] value) {
            compound.setTag(key, new NBTIntArray(value));
        }

        public void writeLongArray(String key, long[] value) {
            compound.setTag(key, new NBTLongArray(value));
        }

        public <T extends NBT> void writeList(String key, NBTType<T> innerType, List<T> value) {
            compound.setTag(key, new NBTList<>(innerType, value));
        }

        public void writeCompound(String key, NBTCompound value) {
            compound.setTag(key, value);
        }

        public void write(String key, NBT value) {
            compound.setTag(key, value);
        }

        public NBTWriter child(String key) {
            NBTCompound child = new NBTCompound();
            compound.setTag(key, child);
            return new NBTWriter(child);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends NBT> T requireType(NBT nbt, NBTType<T> required) {
        if (nbt.getType() != required) {
            throw new IllegalArgumentException("Expected " + required + " but got " + nbt.getType());
        }
        return (T) nbt;
    }
}
