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
import rndm_access.assorteddiscoveries.config.json.json_objects.JsonConfigCategory;
import rndm_access.assorteddiscoveries.config.json.json_objects.ConfigObject;
import rndm_access.assorteddiscoveries.config.json.json_objects.BooleanConfigEntry;

public record BooleanEntriesS2CPayload(List<JsonConfigCategory> configList) implements CustomPacketPayload {
    public static final Identifier CONFIG_PAYLOAD_ID = AssortedDiscoveries.makeModId("config");
    public static final CustomPacketPayload.Type<BooleanEntriesS2CPayload> ID = new CustomPacketPayload.Type<>(CONFIG_PAYLOAD_ID);
    public static final StreamCodec<ByteBuf, List<JsonConfigCategory>> PACKET_CODEC = new StreamCodec<>() {
        public @NonNull List<JsonConfigCategory> decode(ByteBuf byteBuf) {
            int listSize = byteBuf.readInt();
            List<JsonConfigCategory> list = new ArrayList<>(listSize);

            for (int i = 0; i < listSize; i++) {
                int categorySize = byteBuf.readInt();
                String categoryKey = ((FriendlyByteBuf) byteBuf).readUtf();
                JsonConfigCategory.Builder categoryBuilder = new JsonConfigCategory.Builder(categoryKey);

                for (int j = 0; j < categorySize; j++) {
                    String key = ((FriendlyByteBuf) byteBuf).readUtf();
                    boolean bool = byteBuf.readBoolean();
                    categoryBuilder.addEntry(new BooleanConfigEntry(key, bool, false));
                }
                list.add(categoryBuilder.build());
            }
            return list;
        }

        public void encode(ByteBuf byteBuf, List<JsonConfigCategory> list) {
            byteBuf.writeInt(list.size());

            for (JsonConfigCategory category : list) {
                String key = category.getKey();
                byteBuf.writeInt(category.getSize());
                ((FriendlyByteBuf) byteBuf).writeUtf(key);

                for (ConfigObject object : category.getConfigObjects()) {
                    key = object.getKey();
                    boolean value = ((BooleanConfigEntry) object).getValue();

                    ((FriendlyByteBuf) byteBuf).writeUtf(key);
                    byteBuf.writeBoolean(value);
                }
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
