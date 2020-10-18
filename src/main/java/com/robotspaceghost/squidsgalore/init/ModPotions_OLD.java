package com.robotspaceghost.squidsgalore.init;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModPotions_OLD {
    public static Potion SQUID_INK_POTION = null;
        public static Potion SQUID_INK_POTION_LONG = null;
        public static Potion SQUID_INK_POTION_SPLASH = null;
        public static Potion SQUID_INK_POTION_LINGERING = null;
    public static Effect SQUID_INK_EFFECT = null;
        public static Effect SQUID_INK_EFFECT_LONG = null;
        public static Effect SQUID_INK_EFFECT_SPLASH = null;
        public static Effect SQUID_INK_EFFECT_LINGERING = null;

    private static Method brewing_mixes;
    private static void addMix(Potion start, Item ingredient, Potion result){
       if(brewing_mixes == null){
           brewing_mixes = ObfuscationReflectionHelper.findMethod(PotionBrewing.class, "addMix", Potion.class, Item.class, Potion.class);
           brewing_mixes.setAccessible(true);
       }
       try {
           brewing_mixes.invoke(null, start, ingredient, result);
       } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception){
           exception.printStackTrace();
       }
    }
    public static void addBrewingRecipes(){
        addMix(ModPotions_OLD.SQUID_INK_POTION, Items.REDSTONE, ModPotions_OLD.SQUID_INK_POTION);
        //addMix(ModPotions_OLD.SQUID_INK_POTION, Items.GUNPOWDER, ModPotions_OLD.SQUID_INK_POTION_SPLASH);
        //addMix(ModPotions_OLD.SQUID_INK_POTION, Items.DRAGON_BREATH, ModPotions_OLD.SQUID_INK_POTION_LINGERING);
    }
    public static class SquidInkEffect extends Effect{
       public SquidInkEffect(EffectType typeIn, int liquidColorIn) {
           super(typeIn, liquidColorIn);
       }
    }
}
