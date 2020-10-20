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
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_INK.get()),Ingredient.fromItems(Items.FERMENTED_SPIDER_EYE),new ItemStack(ModItems.SQUID_INK_CORRUPT.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.SQUID_INK.get()),Ingredient.fromItems(Items.GUNPOWDER),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SQUID_INK_POTION));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModSpecialPotions.SQUID_INK_POTION).getItem()),
                Ingredient.fromItems(Items.DRAGON_BREATH), PotionUtils.addPotionToItemStack(new ItemStack(Items.LINGERING_POTION), ModSpecialPotions.SQUID_INK_POTION));

        //--------------------------
        // Krakens Breath brewing recipes
        //-------------------------
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.REDSTONE), new ItemStack(ModItems.KRAKEN_BREATH_LONG.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.GLOWSTONE_DUST), new ItemStack(ModItems.KRAKEN_BREATH_THICK.get()));
        BrewingRecipeRegistry.addRecipe(Ingredient.fromItems(ModItems.KRAKEN_BREATH.get()),Ingredient.fromItems(Items.FERMENTED_SPIDER_EYE), new ItemStack(ModItems.KRAKEN_BREATH_CORRUPT.get()));
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
                    ModSpecialPotions.KRAKEN_BREATH_POTION
            );
        }
    }
}
