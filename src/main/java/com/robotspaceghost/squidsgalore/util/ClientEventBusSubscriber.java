package com.robotspaceghost.squidsgalore.util;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.client.render.BabyKrakenRenderer;
import com.robotspaceghost.squidsgalore.client.render.DomesticSquidRenderer;
import com.robotspaceghost.squidsgalore.init.ModEntityTypes;
import com.robotspaceghost.squidsgalore.items.ModSpawnEggItem;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
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

    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event){
        ModSpawnEggItem.initSpawnEggs();

    }
}
