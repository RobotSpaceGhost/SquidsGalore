package com.robotspaceghost.squidsgalore;

import com.robotspaceghost.squidsgalore.entities.*;
import com.robotspaceghost.squidsgalore.init.*;
import com.robotspaceghost.squidsgalore.util.BounceHandler;
import com.robotspaceghost.squidsgalore.util.GravityHandler;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
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

        ModSounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems. ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModParticles.PARTICLES.register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(BounceHandler.class);
        MinecraftForge.EVENT_BUS.register(GravityHandler.class);
        MinecraftForge.EVENT_BUS.register(this);
    }
    //func_233813 -> create();
    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.BABY_KRAKEN.get(), BabyKrakenEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntityTypes.DOMESTIC_SQUID.get(), DomesticSquidEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntityTypes.KRAKEN.get(), KrakenEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntityTypes.KRAKEN_TENTACLE.get(), KrakenTentacleEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntityTypes.BEARD_ENTITY.get(), BeardEntity.setCustomAttributes().func_233813_a_());


            ModSpecialPotions.registerBrewingRecipes();
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
