package com.ordana.immersive_weathering;

import com.ordana.immersive_weathering.configs.CommonConfigs;
import com.ordana.immersive_weathering.reg.ModBlocks;
import com.ordana.immersive_weathering.reg.ModEntities;
import com.ordana.immersive_weathering.reg.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.FallingBlockRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ImmersiveWeathering.MOD_ID)
public class ImmersiveWeathering {

    public static final String MOD_ID = "immersive_weathering";
    public static final Logger LOGGER = LogManager.getLogger();

    public static ResourceLocation res(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public ImmersiveWeathering(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfigs.SERVER_SPEC);

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModEntities.BLOCK_ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientInit.init(modEventBus);
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModItems.ICICLE.get());
        }
    }

    private static class ClientInit {
        @SuppressWarnings("removal")
        public static void init(IEventBus modEventBus) {
            modEventBus.addListener((FMLClientSetupEvent event) ->
                    event.enqueueWork(() -> ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICICLE.get(), RenderType.cutout())));
            modEventBus.addListener((EntityRenderersEvent.RegisterRenderers event) ->
                    event.registerEntityRenderer(ModEntities.FALLING_ICICLE.get(), FallingBlockRenderer::new));
        }
    }
}