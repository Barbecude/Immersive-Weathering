package com.ordana.immersive_weathering.mixins;

import com.llamalad7.mixinextras.sugar.Local;
import com.ordana.immersive_weathering.blocks.IcicleBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerLevel.class)
public abstract class ServerLevelMixin {

    @Inject(method = "tickChunk",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getFluidState()Lnet/minecraft/world/level/material/FluidState;"),
            slice = @Slice(
                    from = @At(
                            value = "CONSTANT",
                            args = "stringValue=randomTick"
                    )
            ),
            require = 1
    )
    private void iw$icicleFromIceTick(LevelChunk chunk, int randomTickSpeed, CallbackInfo ci,
                                      @Local(ordinal = 0) BlockPos pos, @Local(ordinal = 0) BlockState state) {
        IcicleBlock.trySpawnFromIce(pos, state, (ServerLevel) (Object) this);
    }

    @Inject(method = "tickChunk",
            require = 1,
            at = @At(value = "TAIL"))
    private void iw$iciclePrecipitationTick(LevelChunk levelChunk, int randomTickSpeed, CallbackInfo ci) {
        IcicleBlock.performSkyAccessTick((ServerLevel) (Object) this, levelChunk, randomTickSpeed);
    }
}