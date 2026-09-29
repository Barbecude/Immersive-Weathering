package com.ordana.immersive_weathering.configs;

import net.neoforged.neoforge.common.ModConfigSpec;

public class CommonConfigs {

    public static final ModConfigSpec SERVER_SPEC;

    public static final ModConfigSpec.BooleanValue FALLING_ICICLES;
    public static final ModConfigSpec.IntValue ICICLE_RARITY;
    public static final ModConfigSpec.BooleanValue DISABLE_ICICLES;
    public static final ModConfigSpec.BooleanValue ICICLE_FOOD;
    public static final ModConfigSpec.BooleanValue ICICLE_FIRE_RESISTANCE;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.push("icicle");
        FALLING_ICICLES = builder.define("react_to_vibrations", true);
        ICICLE_RARITY = builder.defineInRange("spawn_rarity", 12, 1, 100);
        DISABLE_ICICLES = builder.define("disable_icicles", false);
        builder.pop();

        builder.push("food");
        ICICLE_FOOD = builder.define("icicle_food", true);
        ICICLE_FIRE_RESISTANCE = builder.define("icicle_fire_resistance", true);
        builder.pop();

        SERVER_SPEC = builder.build();
    }
}