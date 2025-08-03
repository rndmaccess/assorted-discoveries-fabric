package rndm_access.assorteddiscoveries.config;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import rndm_access.assorteddiscoveries.AssortedDiscoveries;

import java.util.HashMap;
import java.util.Map;

public record BooleanEntriesS2CPayload(Map<String, Boolean> configMap) implements CustomPayload {
    public static final Identifier CONFIG_PAYLOAD_ID = AssortedDiscoveries.makeModId("config");
    public static final CustomPayload.Id<BooleanEntriesS2CPayload> ID = new CustomPayload.Id<>(CONFIG_PAYLOAD_ID);
    public static final PacketCodec<ByteBuf, Map<String, Boolean>> PACKET_CODEC = new PacketCodec<>() {
        public Map<String, Boolean> decode(ByteBuf byteBuf) {
            int size = byteBuf.readInt();
            Map<String, Boolean> hashMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                String str = ((PacketByteBuf) byteBuf).readString();
                boolean bool = byteBuf.readBoolean();
                hashMap.put(str, bool);
            }
            return hashMap;
        }

        public void encode(ByteBuf byteBuf, Map<String, Boolean> configMap) {
            byteBuf.writeInt(configMap.size());
            for (String key : configMap.keySet()) {
                ((PacketByteBuf) byteBuf).writeString(key);
                byteBuf.writeBoolean(configMap.get(key));
            }
        }
    };
    public static final PacketCodec<RegistryByteBuf, BooleanEntriesS2CPayload> CODEC
            = PacketCodec.tuple(PACKET_CODEC, BooleanEntriesS2CPayload::configMap, BooleanEntriesS2CPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
