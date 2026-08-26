package rndm_access.assorteddiscoveries.util;

import net.minecraft.world.level.block.Block;

import java.util.Objects;

public record BlockPair(Block left, Block right) {
    public BlockPair {
        Objects.requireNonNull(left, "Left block cannot be null");
        Objects.requireNonNull(right, "Right block cannot be null");
    }
}
