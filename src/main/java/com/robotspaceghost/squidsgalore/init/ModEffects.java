package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEffects {
    public static Effect SQUID_INK_EFFECT =  new EffectBase(EffectType.HARMFUL, 0x0A0219).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "squid_ink_effect"));
    public static Effect MILK_EFFECT = null;
    public static Effect BEARD_OIL_EFFECT = null;
    public static Effect SQUID_AIR_EFFECT = null;
    public static Effect BACON_GREASE_EFFECT = null;
    public static Effect BACON_GREASE_SPLASH_EFFECT = null;
    public static Effect HONEY_EFFECT = null;
    public static Effect HONEY_SPLASH_EFFECT = null;
    public static Effect EDV_EFFECT = null;
    public static Effect EDV_SPLASH_EFFECT = null;
    public static Effect SLIME_EFFECT = null;
    public static Effect GLUE_EFFECT = null;
    public static Effect MUTAGEN_EFFECT = null;
    public static Effect MUTAGEN_SPLASH_EFFECT = null;
    public static Effect BHJ_EFFECT = null;
    public static Effect INSTABILITY_EFFECT = null;
    public static Effect NITRO_EFFECT = null;
    public static Effect DOOM_EFFECT = null;
    public static Effect FLOWERING_EFFECT = null;
    public static Effect FLOWERING_SPLASH_EFFECT = null;
    public static Effect DMT_EFFECT = null;
    public static Effect DMT_SPLASH_EFFECT = null;
    public static Effect NOTAVIBE_EFFECT = null;
    public static Effect CLOVER_EFFECT = null;
    public static Effect CLOVER_SPLASH_EFFECT = null;
    public static Effect HOT_SAUCE_EFFECT = null;
    public static Effect HOT_SAUCE_SPLASH_EFFECT = null;
    public static Effect COFFEE_EFFECT = null;
    public static Effect COFFEE_SPLASH_EFFECT = null;
    public static Effect SLUSHY_EFFECT = null;
    public static Effect SLUSHY_SPLASH_EFFECT = null;
    public static Effect REDSTONE_EFFECT = null;
    public static Effect REDSTONE_SPLASH_EFFECT = null;
    public static Effect GLOWSTONE_EFFECT = null;
    public static Effect INVISIBLE_INK_EFFECT = null;
    public static Effect PETRIFIED_EFFECT = null;
    public static Effect ACTIVATED_CHARCOAL_EFFECT = null;
    public static Effect ACTIVATED_CHARCOAL_SPLASH_EFFECT = null;
    public static Effect MINERS_DELIGHT_EFFECT = null;
    public static Effect MINERS_DELIGHT_SPLASH_EFFECT = null;
    public static Effect GEM_EFFECT = null;
    public static Effect GEM_SPLASH_EFFECT = null;
    public static Effect SALT_EFFECT = null;
    public static Effect SALT_SPLASH_EFFECT = null;
    public static Effect XP_BOOST_EFFECT = null;
    public static Effect HOUR_GLASS_EFFECT = null;
    public static Effect HOUR_GLASS_SPLASH_EFFECT = null;
    public static Effect KRAKEN_BREATH_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xCC49F3).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "kraken_breath_effect"));
    public static Effect OMEN_OF_THE_SEAS = new EffectBase(EffectType.HARMFUL, 0xCC49F3).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "omen_of_the_seas_effect"));

    public static class EffectBase extends Effect{
        public EffectBase(EffectType typeIn, int liquidColorIn) {
            super(typeIn, liquidColorIn);
        }
    }

    @Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class effectRegistryClass {
        @SubscribeEvent
        public static void registerEffects(final RegistryEvent.Register<Effect> event) {
            event.getRegistry().registerAll(
                    ModEffects.SQUID_INK_EFFECT,
                    ModEffects.KRAKEN_BREATH_EFFECT,
                    ModEffects.OMEN_OF_THE_SEAS
            );
        }
    }
}
