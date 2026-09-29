package com.ordana.immersive_weathering.reg;

import com.ordana.immersive_weathering.ImmersiveWeathering;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public final class ModTags {

    public static final TagKey<Block> ICE = TagKey.create(Registries.BLOCK, ImmersiveWeathering.res("ice"));
    public static final TagKey<Biome> ICY = TagKey.create(Registries.BIOME, ImmersiveWeathering.res("icy"));

    private ModTags() {
    }
}