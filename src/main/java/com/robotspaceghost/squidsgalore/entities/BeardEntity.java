package com.robotspaceghost.squidsgalore.entities;


import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.init.ModSounds;
import jdk.nashorn.internal.ir.annotations.Ignore;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class BeardEntity extends CreatureEntity {

    private LivingEntity beardParent;
    public BeardEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        beardParent = null;
    }
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.registerAttributes()
                .func_233815_a_(Attributes.MAX_HEALTH, 10.0D)
                .func_233815_a_(Attributes.MOVEMENT_SPEED, 0.0D)
                .func_233815_a_(Attributes.FOLLOW_RANGE, 0.0F);
    }


    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void collideWithEntity(Entity entityIn) { }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    @Override
    public boolean isPushedByWater() { return false; }
    @Override
    public boolean canDespawn(double distanceToClosestPlayer) { return false;}
    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 0;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return ModSounds.BEARD_EQUIP.get(); }

    @Override
    public boolean hasNoGravity() {
        return true;
    }
    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }
    public LivingEntity getBeardParent(){
        return this.beardParent;
    }
    public void setBeardParent(LivingEntity beardParent){
        this.beardParent = beardParent;
    }

    @Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE,  value = Dist.CLIENT)
    public static class beardEvents {
//        @SubscribeEvent
//        public static void noOwnerDamage(AttackEntityEvent event){
//            if (event.getTarget() instanceof BeardEntity){
//                BeardEntity beard = (BeardEntity) event.getEntityLiving();
//                if (event.getEntityLiving() == beard.getBeardParent()){
//                    event.setCanceled(true);
//                }
//            }
//        }
    }

}
