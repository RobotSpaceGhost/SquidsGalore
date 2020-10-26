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
    public static Potion SQUID_INK_POTION = new Potion(new EffectInstance(ModEffects.SQUID_INK_EFFECT, ModItems.SQUID_INK.get().MILK_EFFECT_DURATION)).setRegistryName(location("squid_ink_effect"));
    public static Potion MILK_BOTTLE_POTION = new Potion(new EffectInstance(ModEffects.MILK_BOTTLE_EFFECT, ModItems.MILK_BOTTLE.get().MILK_EFFECT_DURATION)).setRegistryName(location("milk_bottle_effect"));
    public static Potion BEARD_OIL_POTION = new Potion(new EffectInstance(ModEffects.BEARD_OIL_EFFECT, ModItems.BEARD_OIL.get().MILK_EFFECT_DURATION)).setRegistryName(location("beard_oil_effect"));
    public static Potion SQUID_AIR_POTION = new Potion(new EffectInstance(ModEffects.SQUID_AIR_EFFECT, ModItems.SQUID_AIR.get().MILK_EFFECT_DURATION)).setRegistryName(location("squid_air_effect"));
    public static Potion BACON_GREASE_POTION = new Potion(new EffectInstance(ModEffects.BACON_GREASE_EFFECT, ModItems.BACON_GREASE.get().MILK_EFFECT_DURATION)).setRegistryName(location("bacon_grease_effect"));
    public static Potion DILUTED_HONEY_POTION = new Potion(new EffectInstance(ModEffects.DILUTED_HONEY_EFFECT, ModItems.DILUTED_HONEY.get().MILK_EFFECT_DURATION)).setRegistryName(location("diluted_honey_effect"));
    public static Potion PERFUME_POTION = new Potion(new EffectInstance(ModEffects.PERFUME_EFFECT, ModItems.PERFUME.get().MILK_EFFECT_DURATION)).setRegistryName(location("perfume_effect"));
    public static Potion GLUE_POTION = new Potion(new EffectInstance(ModEffects.GLUE_EFFECT, ModItems.GLUE.get().MILK_EFFECT_DURATION)).setRegistryName(location("glue_effect"));
    public static Potion MUTAGEN_POTION = new Potion(new EffectInstance(ModEffects.MUTAGEN_EFFECT, ModItems.MUTAGEN.get().MILK_EFFECT_DURATION)).setRegistryName(location("mutagen_effect"));
    public static Potion BONE_HURTING_JUICE_POTION = new Potion(new EffectInstance(ModEffects.BONE_HURTING_JUICE_EFFECT, ModItems.BONE_HURTING_JUICE.get().MILK_EFFECT_DURATION)).setRegistryName(location("bone_hurting_juice_effect"));
    public static Potion INSTABILITY_POTION = new Potion(new EffectInstance(ModEffects.INSTABILITY_EFFECT, ModItems.INSTABILITY.get().MILK_EFFECT_DURATION)).setRegistryName(location("instability_effect"));
    public static Potion NITRO_POTION = new Potion(new EffectInstance(ModEffects.NITRO_EFFECT, ModItems.NITRO.get().MILK_EFFECT_DURATION)).setRegistryName(location("nitro_effect"));
    public static Potion LIQUID_DOOM_POTION = new Potion(new EffectInstance(ModEffects.LIQUID_DOOM_EFFECT, ModItems.LIQUID_DOOM.get().MILK_EFFECT_DURATION)).setRegistryName(location("liquid_doom_effect"));
    public static Potion FLOWERING_POTION = new Potion(new EffectInstance(ModEffects.FLOWERING_EFFECT, ModItems.FLOWERING.get().MILK_EFFECT_DURATION)).setRegistryName(location("flowering_effect"));
    public static Potion DMT_POTION = new Potion(new EffectInstance(ModEffects.DMT_EFFECT, ModItems.DMT.get().MILK_EFFECT_DURATION)).setRegistryName(location("dmt_effect"));
    public static Potion NOTAVIBE_POTION = new Potion(new EffectInstance(ModEffects.NOTAVIBE_EFFECT, ModItems.NOTAVIBE.get().MILK_EFFECT_DURATION)).setRegistryName(location("notavibe_effect"));
    public static Potion CHLOROPHYLL_POTION = new Potion(new EffectInstance(ModEffects.CHLOROPHYLL_EFFECT, ModItems.CHLOROPHYLL.get().MILK_EFFECT_DURATION)).setRegistryName(location("chlorophyll_effect"));
    public static Potion HOT_SAUCE_POTION = new Potion(new EffectInstance(ModEffects.HOT_SAUCE_EFFECT, ModItems.HOT_SAUCE.get().MILK_EFFECT_DURATION)).setRegistryName(location("hot_sauce_effect"));
    public static Potion COFFEE_POTION = new Potion(new EffectInstance(ModEffects.COFFEE_EFFECT, ModItems.COFFEE.get().MILK_EFFECT_DURATION)).setRegistryName(location("coffee_effect"));
    public static Potion SLUSHY_POTION = new Potion(new EffectInstance(ModEffects.SLUSHY_EFFECT, ModItems.SLUSHY.get().MILK_EFFECT_DURATION)).setRegistryName(location("slushy_effect"));
    public static Potion REDSTONE_BOTTLE_POTION = new Potion(new EffectInstance(ModEffects.REDSTONE_BOTTLE_EFFECT, ModItems.REDSTONE_BOTTLE.get().MILK_EFFECT_DURATION)).setRegistryName(location("redstone_bottle_effect"));
    public static Potion GLOWSTONE_BOTTLE_POTION = new Potion(new EffectInstance(ModEffects.GLOWSTONE_BOTTLE_EFFECT, ModItems.GLOWSTONE_BOTTLE.get().MILK_EFFECT_DURATION)).setRegistryName(location("glowstone_bottle_effect"));
    public static Potion INVISIBLE_INK_POTION = new Potion(new EffectInstance(ModEffects.INVISIBLE_INK_EFFECT, ModItems.INVISIBLE_INK.get().MILK_EFFECT_DURATION)).setRegistryName(location("invisible_ink_effect"));
    public static Potion PETRICHOR_POTION = new Potion(new EffectInstance(ModEffects.PETRICHOR_EFFECT, ModItems.PETRICHOR.get().MILK_EFFECT_DURATION)).setRegistryName(location("petrichor_effect"));
    public static Potion ACTIVATED_CHARCOAL_POTION = new Potion(new EffectInstance(ModEffects.ACTIVATED_CHARCOAL_EFFECT, ModItems.ACTIVATED_CHARCOAL.get().MILK_EFFECT_DURATION)).setRegistryName(location("activated_charcoal_effect"));
    public static Potion MINERS_DELIGHT_POTION = new Potion(new EffectInstance(ModEffects.MINERS_DELIGHT_EFFECT, ModItems.MINERS_DELIGHT.get().MILK_EFFECT_DURATION)).setRegistryName(location("miners_delight_effect"));
    public static Potion CRYSTAL_GEM_POTION = new Potion(new EffectInstance(ModEffects.CRYSTAL_GEM_EFFECT, ModItems.CRYSTAL_GEM.get().MILK_EFFECT_DURATION)).setRegistryName(location("crystal_gem_effect"));
    public static Potion SALT_POTION = new Potion(new EffectInstance(ModEffects.SALT_EFFECT, ModItems.SALT.get().MILK_EFFECT_DURATION)).setRegistryName(location("salt_effect"));
    public static Potion XP_BOOST_POTION = new Potion(new EffectInstance(ModEffects.XP_BOOST_EFFECT, ModItems.XP_BOOST.get().MILK_EFFECT_DURATION)).setRegistryName(location("xp_boost_effect"));
    public static Potion HOURGLASS_POTION = new Potion(new EffectInstance(ModEffects.HOURGLASS_EFFECT, ModItems.HOURGLASS.get().MILK_EFFECT_DURATION)).setRegistryName(location("hourglass_effect"));
    public static Potion KRAKEN_BREATH_POTION = new Potion(new EffectInstance(ModEffects.KRAKEN_BREATH_EFFECT, ModItems.KRAKEN_BREATH.get().MILK_EFFECT_DURATION)).setRegistryName(location("kraken_breath_effect"));


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
        // Krakens Breath brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.REDSTONE), new ItemStack(ModItems.KRAKEN_BREATH_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST), new ItemStack(ModItems.KRAKEN_BREATH_THICK.get()));
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
