package rndm_access.assorteddiscoveries.config;

import com.mojang.datafixers.util.Pair;
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

public record BooleanEntriesS2CPayload(List<Pair<String, Boolean>> configList) implements CustomPacketPayload {
    public static final Identifier CONFIG_PAYLOAD_ID = AssortedDiscoveries.makeModId("boolean_config_sync");
    public static final Type<BooleanEntriesS2CPayload> ID = new Type<>(CONFIG_PAYLOAD_ID);
    public static final StreamCodec<ByteBuf, List<Pair<String, Boolean>>> PACKET_CODEC = new StreamCodec<>() {
        public @NonNull List<Pair<String, Boolean>> decode(ByteBuf byteBuf) {
            int listSize = byteBuf.readInt();
            List<Pair<String, Boolean>> list = new ArrayList<>(listSize);

            for (int i = 0; i < listSize; i++) {
                String key = ((FriendlyByteBuf) byteBuf).readUtf();
                boolean bool = byteBuf.readBoolean();
                list.add(new Pair<>(key, bool));
            }
            return list;
        }

        public void encode(ByteBuf byteBuf, List<Pair<String, Boolean>> list) {
            byteBuf.writeInt(list.size());

            for (Pair<String, Boolean> entry : list) {
                String key = entry.getFirst();
                boolean value = entry.getSecond();

                ((FriendlyByteBuf) byteBuf).writeUtf(key);
                byteBuf.writeBoolean(value);
            }
        }
    };
    public static final StreamCodec<RegistryFriendlyByteBuf, BooleanEntriesS2CPayload> CODEC
            = StreamCodec.composite(PACKET_CODEC, BooleanEntriesS2CPayload::configList, BooleanEntriesS2CPayload::new);

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
