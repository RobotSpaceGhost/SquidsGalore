package com.robotspaceghost.squidsgalore.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.IdentityHashMap;

public class BounceHandler {
    //--------------------------------------
    // Yoinked and modified/updated from tinkers boots, but atleast im honest! Figured I ought implement my slime mechanic in a similar way to slime boots,
    //                                                                                                                          you know...
    //
    //                                                                                                                                          For consistency.
    //----------------------------------
    private static final IdentityHashMap<Entity, BounceHandler> bouncingEntities = new IdentityHashMap();
    public final LivingEntity entityLiving;
    private int timer;
    private boolean wasInAir;
    private double bounce;
    private int bounceTick;
    private double lastMovX;
    private double lastMovZ;

    public BounceHandler(LivingEntity entityLiving, double bounce) {
        this.entityLiving = entityLiving;
        this.timer = 0;
        this.wasInAir = false;
        this.bounce = bounce;
        this.bounceTick = (bounce != 0.0D) ? entityLiving.ticksExisted : 0;
        bouncingEntities.put(entityLiving, this);
    }

    @SubscribeEvent
    public void playerTickPost(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.player == this.entityLiving && !event.player.isElytraFlying()) {
            if (event.player.ticksExisted == this.bounceTick) {
                Vector3d vec3d = event.player.getMotion();
                event.player.setMotion(vec3d.x, this.bounce, vec3d.z);
                this.bounceTick = 0;
            }
            if (!this.entityLiving.func_233570_aj_() && this.entityLiving.ticksExisted != this.bounceTick && (this.lastMovX != this.entityLiving.getMotion().x || this.lastMovZ != this.entityLiving.getMotion().z)) {
                double f = 0.935D;
                Vector3d vec3d = this.entityLiving.getMotion();
                event.player.setMotion(vec3d.x / f, vec3d.y, vec3d.z / f);
                this.entityLiving.isAirBorne = true;
                this.lastMovX = this.entityLiving.getMotion().x;
                this.lastMovZ = this.entityLiving.getMotion().z;
            }
            if (this.wasInAir && this.entityLiving.func_233570_aj_()) {
                if (this.timer == 0) this.timer = this.entityLiving.ticksExisted;
                else if (this.entityLiving.ticksExisted - this.timer > 5) {
                    MinecraftForge.EVENT_BUS.unregister(this);
                    bouncingEntities.remove(this.entityLiving);
                }
            } else {
                this.timer = 0;
                this.wasInAir = true;
            }
        }

    }

//    public static void addBounceHandler(LivingEntity entity) {
//        addBounceHandler(entity, 0.0D);
//    }

    public static void addBounceHandler(LivingEntity entity, double bounce) {
        if (entity instanceof PlayerEntity && !(entity instanceof FakePlayer)) {
            BounceHandler handler = bouncingEntities.get(entity);
            if (handler == null) MinecraftForge.EVENT_BUS.register(new BounceHandler(entity, bounce));
            else if (bounce != 0.0D) {
                handler.bounce = bounce;
                handler.bounceTick = entity.ticksExisted;
            }
        }
    }
}
