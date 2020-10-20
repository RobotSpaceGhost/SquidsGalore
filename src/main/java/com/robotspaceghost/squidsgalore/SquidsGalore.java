package com.robotspaceghost.squidsgalore;

import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import com.robotspaceghost.squidsgalore.entities.DomesticSquidEntity;
import com.robotspaceghost.squidsgalore.entities.KrakenEntity;
import com.robotspaceghost.squidsgalore.entities.KrakenTentacleEntity;
import com.robotspaceghost.squidsgalore.init.*;
import com.robotspaceghost.squidsgalore.items.SquidMilk.KrakenBreathItem;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("squidsg")
public class SquidsGalore
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "squidsg";

    public SquidsGalore() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems. ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModParticles.PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }
    //func_233813 -> create();
    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.BABY_KRAKEN.get(), BabyKrakenEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DOMESTIC_SQUID.get(), DomesticSquidEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntityTypes.KRAKEN.get(), KrakenEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntityTypes.KRAKEN_TENTACLE.get(), KrakenTentacleEntity.setCustomAttributes().func_233813_a_());

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
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) { }

    public static final ItemGroup TAB = new ItemGroup("squidTab"){
        @Override
        public ItemStack createIcon(){
            return new ItemStack(ModItems.BUCKET_OF_SQUID.get());
        }
    };

}
