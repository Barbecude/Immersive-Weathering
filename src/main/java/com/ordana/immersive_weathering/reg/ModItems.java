package com.ordana.immersive_weathering.reg;

import com.ordana.immersive_weathering.ImmersiveWeathering;
import com.ordana.immersive_weathering.items.IcicleItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ImmersiveWeathering.MOD_ID);

    public static final DeferredItem<BlockItem> ICICLE = ITEMS.register("icicle", () ->
            new IcicleItem(ModBlocks.ICICLE.get(), new Item.Properties().food(ModFoods.ICICLE)));
}