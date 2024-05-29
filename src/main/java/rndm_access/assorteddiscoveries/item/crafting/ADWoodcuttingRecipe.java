package rndm_access.assorteddiscoveries.item.crafting;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;
import rndm_access.assorteddiscoveries.core.ADBlocks;
import rndm_access.assorteddiscoveries.core.ADRecipeSerializers;
import rndm_access.assorteddiscoveries.core.ADRecipeTypes;

import java.util.Objects;

public class ADWoodcuttingRecipe implements Recipe<Inventory> {
    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final String group;
    private final RecipeType<?> type;
    private final RecipeSerializer<?> serializer;

    public ADWoodcuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        this.type = ADRecipeTypes.WOODCUTTING;
        this.serializer = ADRecipeSerializers.WOODCUTTING;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return this.ingredient.test(inventory.getStack(0));
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return this.result;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> ingredients = DefaultedList.of();
        ingredients.add(this.ingredient);
        return ingredients;
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ADBlocks.WOODCUTTER);
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
        return this.result.copy();
    }

    public interface RecipeFactory<T extends ADWoodcuttingRecipe> {
        T create(String group, Ingredient ingredient, ItemStack result);
    }

    public static class Serializer<T extends ADWoodcuttingRecipe> implements RecipeSerializer<T> {
        private final RecipeFactory<T> recipeFactory;
        private final Codec<T> codec;

        public Serializer(RecipeFactory<T> recipeFactory) {
            this.recipeFactory = recipeFactory;
            this.codec = RecordCodecBuilder.create((instance) -> {
                Products.P3<RecordCodecBuilder.Mu<T>, String, Ingredient, ItemStack> temp = instance.group(
                        Codecs.createStrictOptionalFieldCodec(Codec.STRING, "group", "")
                                .forGetter((recipe) -> recipe.group),
                        Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient")
                                .forGetter((recipe) -> recipe.ingredient),
                        ItemStack.CUTTING_RECIPE_RESULT_CODEC
                                .forGetter((recipe) -> recipe.result));
                Objects.requireNonNull(recipeFactory);
                return temp.apply(instance, recipeFactory::create);
            });
        }

        @Override
        public Codec<T> codec() {
            return this.codec;
        }

        @Override
        public T read(PacketByteBuf packetByteBuf) {
            String string = packetByteBuf.readString();
            Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
            ItemStack itemStack = packetByteBuf.readItemStack();
            return this.recipeFactory.create(string, ingredient, itemStack);
        }

        @Override
        public void write(PacketByteBuf packetByteBuf, T cuttingRecipe) {
            packetByteBuf.writeString(cuttingRecipe.group);
            cuttingRecipe.getIngredient().write(packetByteBuf);
            packetByteBuf.writeItemStack(cuttingRecipe.result);
        }
    }
}
