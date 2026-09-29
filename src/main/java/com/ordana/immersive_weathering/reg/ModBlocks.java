package com.ordana.immersive_weathering.reg;

import com.ordana.immersive_weathering.ImmersiveWeathering;
import com.ordana.immersive_weathering.blocks.IcicleBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(ImmersiveWeathering.MOD_ID);

    public static final DeferredBlock<Block> ICICLE = BLOCKS.register("icicle", () ->
            new IcicleBlock(Properties.ofFullCopy(Blocks.ICE)
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GLASS)
                    .noOcclusion()
                    .dynamicShape()));
}