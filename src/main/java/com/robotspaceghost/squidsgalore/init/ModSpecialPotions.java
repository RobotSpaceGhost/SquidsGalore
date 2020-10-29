package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModSpecialPotions {
    /*
    *  make a note that potions may act as splash potions if used in their boring vanilla forms, because the only way to have different splash effects
    *  is to lower the duration by a tick
    */
    public static Potion SQUID_INK_POTION = new Potion(new EffectInstance(ModEffects.SQUID_INK_EFFECT, ModItems.SQUID_INK.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("squid_ink_effect"));
    public static Potion MILK_BOTTLE_POTION = new Potion(new EffectInstance(ModEffects.MILK_BOTTLE_EFFECT, ModItems.MILK_BOTTLE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("milk_bottle_effect"));
    public static Potion BEARD_OIL_POTION = new Potion(new EffectInstance(ModEffects.BEARD_OIL_EFFECT, ModItems.BEARD_OIL.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("beard_oil_effect"));
    public static Potion SQUID_AIR_POTION = new Potion(new EffectInstance(ModEffects.SQUID_AIR_EFFECT, ModItems.SQUID_AIR.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("squid_air_effect"));
    public static Potion BACON_GREASE_POTION = new Potion(new EffectInstance(ModEffects.BACON_GREASE_EFFECT, ModItems.BACON_GREASE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("bacon_grease_effect"));
    public static Potion DILUTED_HONEY_POTION = new Potion(new EffectInstance(ModEffects.DILUTED_HONEY_EFFECT, ModItems.DILUTED_HONEY.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("diluted_honey_effect"));
    public static Potion PERFUME_POTION = new Potion(new EffectInstance(ModEffects.PERFUME_EFFECT, ModItems.PERFUME.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("perfume_effect"));
    public static Potion SLIME_BOTTLE_POTION = new Potion(new EffectInstance(ModEffects.SLIME_BOTTLE_EFFECT, ModItems.SLIME_BOTTLE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("slime_bottle_effect"));
    public static Potion GLUE_POTION = new Potion(new EffectInstance(ModEffects.GLUE_EFFECT, ModItems.GLUE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("glue_effect"));
    public static Potion MUTAGEN_POTION = new Potion(new EffectInstance(ModEffects.MUTAGEN_EFFECT, ModItems.MUTAGEN.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("mutagen_effect"));
    public static Potion BONE_HURTING_JUICE_POTION = new Potion(new EffectInstance(ModEffects.BONE_HURTING_JUICE_EFFECT, ModItems.BONE_HURTING_JUICE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("bone_hurting_juice_effect"));
    public static Potion INSTABILITY_POTION = new Potion(new EffectInstance(ModEffects.INSTABILITY_EFFECT, ModItems.INSTABILITY.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("instability_effect"));
    public static Potion NITRO_POTION = new Potion(new EffectInstance(ModEffects.NITRO_EFFECT, ModItems.NITRO.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("nitro_effect"));
    public static Potion LIQUID_DOOM_POTION = new Potion(new EffectInstance(ModEffects.LIQUID_DOOM_EFFECT, ModItems.LIQUID_DOOM.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("liquid_doom_effect"));
    public static Potion FLOWERING_POTION = new Potion(new EffectInstance(ModEffects.FLOWERING_EFFECT, ModItems.FLOWERING.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("flowering_effect"));
    public static Potion DMT_POTION = new Potion(new EffectInstance(ModEffects.DMT_EFFECT, ModItems.DMT.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("dmt_effect"));
    public static Potion NOTAVIBE_POTION = new Potion(new EffectInstance(ModEffects.NOTAVIBE_EFFECT, ModItems.NOTAVIBE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("notavibe_effect"));
    public static Potion CHLOROPHYLL_POTION = new Potion(new EffectInstance(ModEffects.CHLOROPHYLL_EFFECT, ModItems.CHLOROPHYLL.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("chlorophyll_effect"));
    public static Potion HOT_SAUCE_POTION = new Potion(new EffectInstance(ModEffects.HOT_SAUCE_EFFECT, ModItems.HOT_SAUCE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("hot_sauce_effect"));
    public static Potion COFFEE_POTION = new Potion(new EffectInstance(ModEffects.COFFEE_EFFECT, ModItems.COFFEE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("coffee_effect"));
    public static Potion SLUSHY_POTION = new Potion(new EffectInstance(ModEffects.SLUSHY_EFFECT, ModItems.SLUSHY.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("slushy_effect"));
    public static Potion REDSTONE_BOTTLE_POTION = new Potion(new EffectInstance(ModEffects.REDSTONE_BOTTLE_EFFECT, ModItems.REDSTONE_BOTTLE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("redstone_bottle_effect"));
    public static Potion GLOWSTONE_BOTTLE_POTION = new Potion(new EffectInstance(ModEffects.GLOWSTONE_BOTTLE_EFFECT, ModItems.GLOWSTONE_BOTTLE.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("glowstone_bottle_effect"));
    public static Potion INVISIBLE_INK_POTION = new Potion(new EffectInstance(ModEffects.INVISIBLE_INK_EFFECT, ModItems.INVISIBLE_INK.get().MILK_EFFECT_DURATION - 1,0,false,false)).setRegistryName(location("invisible_ink_effect"));
    public static Potion PETRICHOR_POTION = new Potion(new EffectInstance(ModEffects.PETRICHOR_EFFECT, ModItems.PETRICHOR.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("petrichor_effect"));
    public static Potion ACTIVATED_CHARCOAL_POTION = new Potion(new EffectInstance(ModEffects.ACTIVATED_CHARCOAL_EFFECT, ModItems.ACTIVATED_CHARCOAL.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("activated_charcoal_effect"));
    public static Potion MINERS_DELIGHT_POTION = new Potion(new EffectInstance(ModEffects.MINERS_DELIGHT_EFFECT, ModItems.MINERS_DELIGHT.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("miners_delight_effect"));
    public static Potion CRYSTAL_GEM_POTION = new Potion(new EffectInstance(ModEffects.CRYSTAL_GEM_EFFECT, ModItems.CRYSTAL_GEM.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("crystal_gem_effect"));
    public static Potion SALT_POTION = new Potion(new EffectInstance(ModEffects.SALT_EFFECT, ModItems.SALT.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("salt_effect"));
    public static Potion XP_BOOST_POTION = new Potion(new EffectInstance(ModEffects.XP_BOOST_EFFECT, ModItems.XP_BOOST.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("xp_boost_effect"));
    public static Potion HOURGLASS_POTION = new Potion(new EffectInstance(ModEffects.HOURGLASS_EFFECT, ModItems.HOURGLASS.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("hourglass_effect"));
    public static Potion KRAKEN_BREATH_POTION = new Potion(new EffectInstance(ModEffects.KRAKEN_BREATH_EFFECT, ModItems.KRAKEN_BREATH.get().MILK_EFFECT_DURATION - 1)).setRegistryName(location("kraken_breath_effect"));


    public static ResourceLocation location(String name){
        return new ResourceLocation(SquidsGalore.MOD_ID, name);
    }

    public static void registerBrewingRecipes(){
        //--------------------------
        // Squid ink brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_INK.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.SQUID_INK_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_INK.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.SQUID_INK_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_INK.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.SQUID_INK_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_INK.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SQUID_INK_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SQUID_INK_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.SQUID_INK_POTION));

        //--------------------------
        // Milk bottle brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MILK_BOTTLE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.MILK_BOTTLE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MILK_BOTTLE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.MILK_BOTTLE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MILK_BOTTLE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.MILK_BOTTLE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MILK_BOTTLE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.MILK_BOTTLE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.MILK_BOTTLE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.MILK_BOTTLE_POTION));

        //--------------------------
        // Beard Oil brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BEARD_OIL.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.BEARD_OIL_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BEARD_OIL.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.BEARD_OIL_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BEARD_OIL.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.BEARD_OIL_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BEARD_OIL.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.BEARD_OIL_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.BEARD_OIL_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.BEARD_OIL_POTION));

        //--------------------------
        // SQUID_AIR brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_AIR.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.SQUID_AIR_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_AIR.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.SQUID_AIR_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_AIR.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.SQUID_AIR_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_AIR.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SQUID_AIR_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SQUID_AIR_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.SQUID_AIR_POTION));

        //--------------------------
        // BACON_GREASE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BACON_GREASE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.BACON_GREASE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BACON_GREASE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.BACON_GREASE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BACON_GREASE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.BACON_GREASE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BACON_GREASE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.BACON_GREASE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.BACON_GREASE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.BACON_GREASE_POTION));

        //--------------------------
        // DILUTED_HONEY brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.DILUTED_HONEY.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.DILUTED_HONEY_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.DILUTED_HONEY.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.DILUTED_HONEY_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.DILUTED_HONEY.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.DILUTED_HONEY_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.DILUTED_HONEY.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.DILUTED_HONEY_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.DILUTED_HONEY_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.DILUTED_HONEY_POTION));

        //--------------------------
        // PERFUME brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.PERFUME.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.PERFUME_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.PERFUME.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.PERFUME_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.PERFUME.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.PERFUME_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.PERFUME.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.PERFUME_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.PERFUME_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.PERFUME_POTION));

        //--------------------------
        // SLIME_BOTTLE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SLIME_BOTTLE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.SLIME_BOTTLE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SLIME_BOTTLE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.SLIME_BOTTLE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SLIME_BOTTLE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.SLIME_BOTTLE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SLIME_BOTTLE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SLIME_BOTTLE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SLIME_BOTTLE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.SLIME_BOTTLE_POTION));

        //--------------------------
        // GLUE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.GLUE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.GLUE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.GLUE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.GLUE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.GLUE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.GLUE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.GLUE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.GLUE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.GLUE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.GLUE_POTION));

        //--------------------------
        // MUTAGEN brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MUTAGEN.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.MUTAGEN_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MUTAGEN.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.MUTAGEN_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MUTAGEN.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.MUTAGEN_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MUTAGEN.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.MUTAGEN_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.MUTAGEN_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.MUTAGEN_POTION));

        //--------------------------
        // BONE_HURTING_JUICE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BONE_HURTING_JUICE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.BONE_HURTING_JUICE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BONE_HURTING_JUICE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.BONE_HURTING_JUICE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BONE_HURTING_JUICE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.BONE_HURTING_JUICE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.BONE_HURTING_JUICE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.BONE_HURTING_JUICE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.BONE_HURTING_JUICE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.BONE_HURTING_JUICE_POTION));

        //--------------------------
        // INSTABILITY brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.INSTABILITY.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.INSTABILITY_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.INSTABILITY.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.INSTABILITY_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.INSTABILITY.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.INSTABILITY_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.INSTABILITY.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.INSTABILITY_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.INSTABILITY_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.INSTABILITY_POTION));

        //--------------------------
        // NITRO brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.NITRO.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.NITRO_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.NITRO.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.NITRO_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.NITRO.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.NITRO_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.NITRO.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.NITRO_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.NITRO_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.NITRO_POTION));

        //--------------------------
        // LIQUID_DOOM brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.LIQUID_DOOM.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.LIQUID_DOOM_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.LIQUID_DOOM.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.LIQUID_DOOM_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.LIQUID_DOOM.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.LIQUID_DOOM_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.LIQUID_DOOM.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.LIQUID_DOOM_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.LIQUID_DOOM_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.LIQUID_DOOM_POTION));

        //--------------------------
        // FLOWERING brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.FLOWERING.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.FLOWERING_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.FLOWERING.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.FLOWERING_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.FLOWERING.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.FLOWERING_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.FLOWERING.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.FLOWERING_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.FLOWERING_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.FLOWERING_POTION));

        //--------------------------
        // DMT brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.DMT.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.DMT_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.DMT.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.DMT_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.DMT.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.DMT_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.DMT.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.DMT_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.DMT_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.DMT_POTION));

        //--------------------------
        // NOTAVIBE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.NOTAVIBE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.NOTAVIBE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.NOTAVIBE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.NOTAVIBE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.NOTAVIBE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.NOTAVIBE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.NOTAVIBE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.NOTAVIBE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.NOTAVIBE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.NOTAVIBE_POTION));

        //--------------------------
        // CHLOROPHYLL brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.CHLOROPHYLL.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.CHLOROPHYLL_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.CHLOROPHYLL.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.CHLOROPHYLL_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.CHLOROPHYLL.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.CHLOROPHYLL_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.CHLOROPHYLL.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.CHLOROPHYLL_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.CHLOROPHYLL_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.CHLOROPHYLL_POTION));

        //--------------------------
        // HOT_SAUCE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.HOT_SAUCE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.HOT_SAUCE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.HOT_SAUCE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.HOT_SAUCE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.HOT_SAUCE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.HOT_SAUCE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.HOT_SAUCE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.HOT_SAUCE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.HOT_SAUCE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.HOT_SAUCE_POTION));

        //--------------------------
        // COFFEE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.COFFEE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.COFFEE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.COFFEE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.COFFEE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.COFFEE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.COFFEE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.COFFEE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.COFFEE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.COFFEE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.COFFEE_POTION));

        //--------------------------
        // SLUSHY brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SLUSHY.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.SLUSHY_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SLUSHY.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.SLUSHY_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SLUSHY.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.SLUSHY_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SLUSHY.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SLUSHY_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SLUSHY_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.SLUSHY_POTION));

        //--------------------------
        // REDSTONE_BOTTLE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.REDSTONE_BOTTLE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.REDSTONE_BOTTLE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.REDSTONE_BOTTLE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.REDSTONE_BOTTLE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.REDSTONE_BOTTLE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.REDSTONE_BOTTLE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.REDSTONE_BOTTLE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.REDSTONE_BOTTLE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.REDSTONE_BOTTLE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.REDSTONE_BOTTLE_POTION));

        //--------------------------
        // GLOWSTONE_BOTTLE brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.GLOWSTONE_BOTTLE.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.GLOWSTONE_BOTTLE_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.GLOWSTONE_BOTTLE.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.GLOWSTONE_BOTTLE_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.GLOWSTONE_BOTTLE.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.GLOWSTONE_BOTTLE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.GLOWSTONE_BOTTLE.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.GLOWSTONE_BOTTLE_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.GLOWSTONE_BOTTLE_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.GLOWSTONE_BOTTLE_POTION));

        //--------------------------
        // INVISIBLE_INK brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.INVISIBLE_INK.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.INVISIBLE_INK_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.INVISIBLE_INK.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.INVISIBLE_INK_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.INVISIBLE_INK.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.INVISIBLE_INK_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.INVISIBLE_INK.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.INVISIBLE_INK_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.INVISIBLE_INK_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.INVISIBLE_INK_POTION));

        //--------------------------
        // PETRICHOR brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.PETRICHOR.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.PETRICHOR_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.PETRICHOR.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.PETRICHOR_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.PETRICHOR.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.PETRICHOR_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.PETRICHOR.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.PETRICHOR_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.PETRICHOR_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.PETRICHOR_POTION));

        //--------------------------
        // ACTIVATED_CHARCOAL brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.ACTIVATED_CHARCOAL.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.ACTIVATED_CHARCOAL_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.ACTIVATED_CHARCOAL.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.ACTIVATED_CHARCOAL_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.ACTIVATED_CHARCOAL.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.ACTIVATED_CHARCOAL_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.ACTIVATED_CHARCOAL.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.ACTIVATED_CHARCOAL_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.ACTIVATED_CHARCOAL_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.ACTIVATED_CHARCOAL_POTION));

        //--------------------------
        // MINERS_DELIGHT brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MINERS_DELIGHT.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.MINERS_DELIGHT_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MINERS_DELIGHT.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.MINERS_DELIGHT_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MINERS_DELIGHT.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.MINERS_DELIGHT_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.MINERS_DELIGHT.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.MINERS_DELIGHT_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.MINERS_DELIGHT_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.MINERS_DELIGHT_POTION));

        //--------------------------
        // CRYSTAL_GEM brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.CRYSTAL_GEM.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.CRYSTAL_GEM_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.CRYSTAL_GEM.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.CRYSTAL_GEM_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.CRYSTAL_GEM.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.CRYSTAL_GEM_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.CRYSTAL_GEM.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.CRYSTAL_GEM_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.CRYSTAL_GEM_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.CRYSTAL_GEM_POTION));

        //--------------------------
        // SALT brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SALT.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.SALT_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SALT.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.SALT_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SALT.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.SALT_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SALT.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SALT_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SALT_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.SALT_POTION));

        //--------------------------
        // XP_BOOST brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.XP_BOOST.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.XP_BOOST_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.XP_BOOST.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.XP_BOOST_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.XP_BOOST.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.XP_BOOST_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.XP_BOOST.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.XP_BOOST_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.XP_BOOST_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.XP_BOOST_POTION));

        //--------------------------
        // HOURGLASS brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.HOURGLASS.get()),Ingredient.fromItems(Items.REDSTONE),new ItemStack(ModItems.HOURGLASS_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.HOURGLASS.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST),new ItemStack(ModItems.HOURGLASS_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.HOURGLASS.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.HOURGLASS_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.HOURGLASS.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.HOURGLASS_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.HOURGLASS_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.HOURGLASS_POTION));

        //--------------------------
        // Krakens Breath brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.REDSTONE), new ItemStack(ModItems.KRAKEN_BREATH_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST), new ItemStack(ModItems.KRAKEN_BREATH_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.FERMENTED_SPIDER_EYE), new ItemStack(ModItems.KRAKEN_BREATH_CORRUPTED.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_INK.get()),Ingredient.fromItems(Items.GLASS_BOTTLE),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), ModSpecialPotions.KRAKEN_BREATH_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.KRAKEN_BREATH_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.KRAKEN_BREATH_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.KRAKEN_BREATH_POTION));
    }

    @Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class potionRegistryClass {
        @SubscribeEvent
        public static void registerSpecialPotions(final RegistryEvent.Register<Potion> event){
            event.getRegistry().registerAll(
                    ModSpecialPotions.SQUID_INK_POTION,
                    ModSpecialPotions.MILK_BOTTLE_POTION,
                    ModSpecialPotions.BEARD_OIL_POTION,
                    ModSpecialPotions.SQUID_AIR_POTION,
                    ModSpecialPotions.BACON_GREASE_POTION,
                    ModSpecialPotions.DILUTED_HONEY_POTION,
                    ModSpecialPotions.PERFUME_POTION,
                    ModSpecialPotions.SLIME_BOTTLE_POTION,
                    ModSpecialPotions.GLUE_POTION,
                    ModSpecialPotions.MUTAGEN_POTION,
                    ModSpecialPotions.BONE_HURTING_JUICE_POTION,
                    ModSpecialPotions.INSTABILITY_POTION,
                    ModSpecialPotions.NITRO_POTION,
                    ModSpecialPotions.LIQUID_DOOM_POTION,
                    ModSpecialPotions.FLOWERING_POTION,
                    ModSpecialPotions.DMT_POTION,
                    ModSpecialPotions.NOTAVIBE_POTION,
                    ModSpecialPotions.CHLOROPHYLL_POTION,
                    ModSpecialPotions.HOT_SAUCE_POTION,
                    ModSpecialPotions.COFFEE_POTION,
                    ModSpecialPotions.SLUSHY_POTION,
                    ModSpecialPotions.REDSTONE_BOTTLE_POTION,
                    ModSpecialPotions.GLOWSTONE_BOTTLE_POTION,
                    ModSpecialPotions.INVISIBLE_INK_POTION,
                    ModSpecialPotions.PETRICHOR_POTION,
                    ModSpecialPotions.ACTIVATED_CHARCOAL_POTION,
                    ModSpecialPotions.MINERS_DELIGHT_POTION,
                    ModSpecialPotions.CRYSTAL_GEM_POTION,
                    ModSpecialPotions.SALT_POTION,
                    ModSpecialPotions.XP_BOOST_POTION,
                    ModSpecialPotions.HOURGLASS_POTION,
                    ModSpecialPotions.KRAKEN_BREATH_POTION
            );
        }
    }
}
