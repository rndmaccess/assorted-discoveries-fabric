package rndm_access.assorteddiscoveries.config;

import io.netty.buffer.ByteBuf;
import org.jspecify.annotations.NonNull;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import rndm_access.assorteddiscoveries.config.json.deserializer.entries.BooleanConfigEntry;

public record BooleanEntriesS2CPayload(List<BooleanConfigEntry> configList) implements CustomPacketPayload {
    public static final Identifier CONFIG_PAYLOAD_ID = AssortedDiscoveries.makeModId("config");
    public static final CustomPacketPayload.Type<BooleanEntriesS2CPayload> ID = new CustomPacketPayload.Type<>(CONFIG_PAYLOAD_ID);
    public static final StreamCodec<ByteBuf, List<BooleanConfigEntry>> PACKET_CODEC = new StreamCodec<>() {
        public @NonNull List<BooleanConfigEntry> decode(ByteBuf byteBuf) {
            int listSize = byteBuf.readInt();
            List<BooleanConfigEntry> list = new ArrayList<>(listSize);

            for (int i = 0; i < listSize; i++) {
                String str = ((FriendlyByteBuf) byteBuf).readUtf();
                boolean bool = byteBuf.readBoolean();
                list.add(new BooleanConfigEntry(str, bool));
            }
            return list;
        }

        public void encode(ByteBuf byteBuf, List<BooleanConfigEntry> list) {
            byteBuf.writeInt(list.size());

            list.forEach(entry -> {
                String key = entry.getKey();
                boolean value = entry.getValue();

                ((FriendlyByteBuf) byteBuf).writeUtf(key);
                byteBuf.writeBoolean(value);
            });
        }
    };
    public static final StreamCodec<RegistryFriendlyByteBuf, BooleanEntriesS2CPayload> CODEC
            = StreamCodec.composite(PACKET_CODEC, BooleanEntriesS2CPayload::configList, BooleanEntriesS2CPayload::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
