package com.ordana.immersive_weathering.reg;

import com.ordana.immersive_weathering.ImmersiveWeathering;
import com.ordana.immersive_weathering.entities.FallingIcicleEntity;
import com.ordana.immersive_weathering.entities.IcicleBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, ImmersiveWeathering.MOD_ID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ImmersiveWeathering.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<FallingIcicleEntity>> FALLING_ICICLE =
            ENTITY_TYPES.register("falling_icicle", () ->
                    EntityType.Builder.<FallingIcicleEntity>of(FallingIcicleEntity::new, MobCategory.MISC)
                            .sized(0.98F, 0.98F)
                            .clientTrackingRange(10)
                            .updateInterval(20)
                            .build("falling_icicle"));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IcicleBlockEntity>> ICICLE_TILE =
            BLOCK_ENTITY_TYPES.register("icicle", () ->
                    BlockEntityType.Builder.of(IcicleBlockEntity::new, ModBlocks.ICICLE.get()).build(null));
}