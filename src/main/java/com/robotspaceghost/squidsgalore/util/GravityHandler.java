package com.robotspaceghost.squidsgalore.util;

import com.robotspaceghost.squidsgalore.init.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Collection;
import java.util.IdentityHashMap;

public class GravityHandler {
    private static final IdentityHashMap<Entity, GravityHandler> gravityEntities = new IdentityHashMap();
    public final LivingEntity entityLiving;


    public GravityHandler(LivingEntity entityLiving) {
        this.entityLiving = entityLiving;
        gravityEntities.put(entityLiving, this);
    }

    @SubscribeEvent
    public void playerTickPost(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player == this.entityLiving && !event.player.isElytraFlying()) {
            Collection<EffectInstance> activeEffects = this.entityLiving.getActivePotionEffects();
            if (activeEffects.isEmpty()){
                System.out.println("attempting to add gravity effect on glue end 2");
                if (this.entityLiving.addPotionEffect(new EffectInstance(ModEffects.GRAVITY_EFFECT, 5 * 20, 0, false, false, false))) {
                    System.out.println("success in removing");
                } else System.out.println("failed in removing");
                MinecraftForge.EVENT_BUS.unregister(this);
                gravityEntities.remove(this.entityLiving);
            }
        }
    }

    public static void addGravityHandler(LivingEntity entity) {
        if (entity instanceof PlayerEntity && !(entity instanceof FakePlayer)) {
            GravityHandler handler = gravityEntities.get(entity);
            if (handler == null) MinecraftForge.EVENT_BUS.register(new GravityHandler(entity));
        }
    }
}
