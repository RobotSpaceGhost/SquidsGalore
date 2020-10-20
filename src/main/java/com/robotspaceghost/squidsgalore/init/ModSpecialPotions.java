package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class ModSpecialPotions {
    public static Potion SQUID_INK_POTION = new Potion(new EffectInstance(ModEffects.SQUID_INK_EFFECT, ModItems.SQUID_INK.get().MILK_EFFECT_DURATION)).setRegistryName(location("squid_ink_effect"));

    public static Potion KRAKEN_BREATH_POTION = new Potion(new EffectInstance(ModEffects.KRAKEN_BREATH_EFFECT, ModItems.KRAKEN_BREATH.get().MILK_EFFECT_DURATION)).setRegistryName(location("kraken_breath_effect"));

    public static ResourceLocation location(String name){
        return new ResourceLocation(SquidsGalore.MOD_ID, name);
    }
    protected static class specialPotion extends Potion{

    }
}
