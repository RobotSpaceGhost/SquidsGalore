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
    public static Potion SQUID_AIR_POTION = null;
    public static Potion BACON_GREASE_POTION = null;
    public static Potion DILUTED_HONEY_POTION = null;
    public static Potion PERFUME_POTION = null;
    public static Potion GLUE_POTION = null;
    public static Potion MUTAGEN_POTION = null;
    public static Potion BONE_HURTING_JUICE_POTION = null;
    public static Potion INSTABILITY_POTION = null;
    public static Potion NITRO_POTION = null;
    public static Potion LIQUID_DOOM_POTION = null;
    public static Potion FLOWERING_POTION = null;
    public static Potion DMT_POTION = null;
    public static Potion NOTAVIBE_POTION = null;
    public static Potion CHLOROPHYLL_POTION = null;
    public static Potion HOT_SAUCE_POTION = null;
    public static Potion COFFEE_POTION = null;
    public static Potion SLUSHY_POTION = null;
    public static Potion REDSTONE_BOTTLE_POTION = null;
    public static Potion GLOWSTONE_BOTTLE_POTION = null;
    public static Potion INVISIBLE_INK_POTION = null;
    public static Potion PETRICHOR_POTION = null;
    public static Potion ACTIVATED_CHARCOAL_POTION = null;
    public static Potion MINERS_DELIGHT_POTION = null;
    public static Potion CRYSTAL_GEM_POTION = null;
    public static Potion SALT_POTION = null;
    public static Potion XP_BOOST_POTION = null;
    public static Potion HOURGLASS_POTION = null;
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
//                    ModSpecialPotions.SQUID_AIR_POTION,
//                    ModSpecialPotions.BACON_GREASE_POTION,
//                    ModSpecialPotions.DILUTED_HONEY_POTION,
//                    ModSpecialPotions.PERFUME_POTION,
//                    ModSpecialPotions.GLUE_POTION,
//                    ModSpecialPotions.MUTAGEN_POTION,
//                    ModSpecialPotions.BONE_HURTING_JUICE_POTION,
//                    ModSpecialPotions.INSTABILITY_POTION,
//                    ModSpecialPotions.NITRO_POTION,
//                    ModSpecialPotions.LIQUID_DOOM_POTION,
//                    ModSpecialPotions.FLOWERING_POTION,
//                    ModSpecialPotions.DMT_POTION,
//                    ModSpecialPotions.NOTAVIBE_POTION,
//                    ModSpecialPotions.CHLOROPHYLL_POTION,
//                    ModSpecialPotions.HOT_SAUCE_POTION,
//                    ModSpecialPotions.COFFEE_POTION,
//                    ModSpecialPotions.SLUSHY_POTION,
//                    ModSpecialPotions.REDSTONE_BOTTLE_POTION,
//                    ModSpecialPotions.GLOWSTONE_BOTTLE_POTION,
//                    ModSpecialPotions.INVISIBLE_INK_POTION,
//                    ModSpecialPotions.PETRICHOR_POTION,
//                    ModSpecialPotions.ACTIVATED_CHARCOAL_POTION,
//                    ModSpecialPotions.MINERS_DELIGHT_POTION,
//                    ModSpecialPotions.CRYSTAL_GEM_POTION,
//                    ModSpecialPotions.SALT_POTION,
//                    ModSpecialPotions.XP_BOOST_POTION,
//                    ModSpecialPotions.HOURGLASS_POTION,
                    ModSpecialPotions.KRAKEN_BREATH_POTION
            );
        }
    }
}
