package com.robotspaceghost.squidsgalore.util;

import com.robotspaceghost.squidsgalore.entities.BeardEntity;
import com.robotspaceghost.squidsgalore.init.ModEffects;
import com.robotspaceghost.squidsgalore.init.ModEntityTypes;
import com.robotspaceghost.squidsgalore.init.ModItems;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.IdentityHashMap;

public class BeardHandler {
    private static final IdentityHashMap<Entity, BeardHandler> beardedEntities = new IdentityHashMap();
    public final LivingEntity entityLiving;
    public final BeardEntity beard;

    public BeardHandler(LivingEntity entityLiving, @Nullable BeardEntity beard) {
        this.entityLiving = entityLiving;
        if (beard != null) this.beard = beard;
        else {
            System.out.println("Creating new beard!");
            World worldIn = this.entityLiving.world;
            BlockPos pos = new BlockPos(this.entityLiving.getPosX(), this.entityLiving.getPosY(), this.entityLiving.getPosZ());
            this.beard = ModEntityTypes.BEARD_ENTITY.get().spawn(worldIn, null, null, null, pos, SpawnReason.EVENT, true, false);
        }
        if (this.beard != null){
            beardedEntities.put(entityLiving, this);
        }else{
            System.out.println("Unregistering in beard protect in init!");
            MinecraftForge.EVENT_BUS.unregister(this);
        }
    }



    @SubscribeEvent
    public void beardProtectEvent(LivingDamageEvent event){
        if (!this.entityLiving.world.isRemote && this.entityLiving == event.getEntityLiving()){
            System.out.println("damage event entity match!");
            this.beard.setHealth(Math.max(this.beard.getHealth() - event.getAmount(), 0));
            if (this.beard.getHealth() <= 0){
                System.out.println("Unregistering in beard protect!");
                MinecraftForge.EVENT_BUS.unregister(this);
                beardedEntities.remove(this.entityLiving);
            } //else this.beard.performHurtAnimation();
            event.setAmount(0);
            event.setCanceled(true);
        }
    }


    @SubscribeEvent
    public void playerShaveEvent(PlayerInteractEvent.RightClickItem event) {
        if (this.entityLiving instanceof PlayerEntity && this.entityLiving == event.getPlayer()) {
            PlayerEntity player = event.getPlayer();
            if (!event.getWorld().isRemote && event.getHand() == player.getActiveHand()) {
                if ((player.getHeldItemMainhand().getItem() == Items.SHEARS)) {
                    this.beard.remove();
                    ItemStack trimmedBeard = new ItemStack(ModItems.BEARD.get());
                    if (!player.addItemStackToInventory(trimmedBeard)) player.dropItem(trimmedBeard, false);
                    System.out.println("Unregistering in shear event!");
                    MinecraftForge.EVENT_BUS.unregister(this);
                    beardedEntities.remove(this.entityLiving);
                }
            }
        }
    }

    @SubscribeEvent
    public void aliveChecker(TickEvent.ServerTickEvent event){
        if (event.phase == TickEvent.Phase.END) {
            if (this.beard == null){
                System.out.println("Unregistering in alive checker because beard null!");
                MinecraftForge.EVENT_BUS.unregister(this);
                beardedEntities.remove(this.entityLiving);
            }
            else if (!this.entityLiving.isAlive() || !this.beard.isAlive()) {
                System.out.println("is beard alive?:" + this.beard.isAlive());
                System.out.println("beard unregister location:" + this.beard.getPosX() + "," + this.beard.getPosY() + "," + this.beard.getPosZ());
                if (this.beard.isAlive()){
                    System.out.println("setting health from :" + this.beard.getHealth() + " to 0");
                    this.beard.setHealth(0);
                }
                System.out.println("Unregistering in alive checker because beard dead/player dead!");
                System.out.println("unregistering with health:" + this.beard.getHealth());
                MinecraftForge.EVENT_BUS.unregister(this);
                beardedEntities.remove(this.entityLiving);
            }
        }
    }

    public static boolean addBeardHandler(LivingEntity entity, @Nullable BeardEntity beard) {
        if (entity.isAlive() && !(entity instanceof BeardEntity) && !(entity instanceof AnimalEntity) && (entity.getWidth() == .6f)) {
            BeardHandler handler = beardedEntities.get(entity);
            if (handler == null) {
                System.out.println("registering new beard");
                MinecraftForge.EVENT_BUS.register(new BeardHandler(entity, beard));
                return true;
            }
            else return(handler.beard == beard);
        }
        return false;
    }
}
