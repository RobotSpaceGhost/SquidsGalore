package com.robotspaceghost.squidsgalore.util;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.render.BabyKrakenRenderer;
import com.robotspaceghost.squidsgalore.client.render.DomesticSquidRenderer;
import com.robotspaceghost.squidsgalore.client.render.KrakenRenderer;
import com.robotspaceghost.squidsgalore.client.render.KrakenTentacleRenderer;
import com.robotspaceghost.squidsgalore.init.*;
import com.robotspaceghost.squidsgalore.items.ModSpawnEggItem;
import com.robotspaceghost.squidsgalore.particles.KrakenParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BABY_KRAKEN.get(), BabyKrakenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DOMESTIC_SQUID.get(), DomesticSquidRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.KRAKEN.get(), KrakenRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.KRAKEN_TENTACLE.get(), KrakenTentacleRenderer::new);
    }
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticles(ParticleFactoryRegisterEvent event){
        Minecraft.getInstance().particles.registerFactory(ModParticles.KRAKEN_PARTICLE.get(), new KrakenParticle.Factory());
    }
    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event){
        ModSpawnEggItem.initSpawnEggs();

    }
}
