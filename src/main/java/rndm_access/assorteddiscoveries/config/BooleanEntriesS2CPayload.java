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
import rndm_access.assorteddiscoveries.config.json.EntryPair;

public record BooleanEntriesS2CPayload(List<EntryPair<Boolean>> configList) implements CustomPacketPayload {
    public static final Identifier CONFIG_PAYLOAD_ID = AssortedDiscoveries.makeModId("config");
    public static final CustomPacketPayload.Type<BooleanEntriesS2CPayload> ID = new CustomPacketPayload.Type<>(CONFIG_PAYLOAD_ID);
    public static final StreamCodec<ByteBuf, List<EntryPair<Boolean>>> PACKET_CODEC = new StreamCodec<>() {
        public @NonNull List<EntryPair<Boolean>> decode(ByteBuf byteBuf) {
            int listSize = byteBuf.readInt();
            List<EntryPair<Boolean>> list = new ArrayList<>(listSize);

            for (int i = 0; i < listSize; i++) {
                String str = ((FriendlyByteBuf) byteBuf).readUtf();
                boolean bool = byteBuf.readBoolean();
                list.add(new EntryPair<>(str, bool));
            }
            return list;
        }

        public void encode(ByteBuf byteBuf, List<EntryPair<Boolean>> list) {
            byteBuf.writeInt(list.size());

            list.forEach(entryPair -> {
                String key = entryPair.key();
                boolean value = entryPair.value();

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
