package com.ordana.immersive_weathering.reg;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties ICICLE = new FoodProperties.Builder()
            .nutrition(0)
            .saturationModifier(0F)
            .alwaysEdible()
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 80, 1, false, false), 1F)
            .build();

    public static final FoodProperties ICICLE_NO_EFFECT = new FoodProperties.Builder()
            .nutrition(0)
            .saturationModifier(0F)
            .alwaysEdible()
            .fast()
            .build();
}