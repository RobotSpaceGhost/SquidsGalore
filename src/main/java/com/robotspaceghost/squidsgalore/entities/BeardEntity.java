package com.robotspaceghost.squidsgalore.entities;


import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.init.ModSounds;
import jdk.nashorn.internal.ir.annotations.Ignore;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class BeardEntity extends CreatureEntity {

    protected static final DataParameter<Float> BEARD_PARENT = EntityDataManager.createKey(BabyKrakenEntity.class, DataSerializers.FLOAT);
    public BeardEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
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

    public void setOwnerId(float ownerId) { this.dataManager.set(BEARD_PARENT, ownerId); }
    public float getOwnerId() { return this.dataManager.get(BEARD_PARENT); }
    public LivingEntity getBeardParent(){
        int owner = (int) getOwnerId();
        return (LivingEntity) this.world.getEntityByID(owner);
    }
    protected void registerData() {
        super.registerData();
        this.dataManager.register(BEARD_PARENT, -1f);
    }
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putFloat("BeardParent", this.getOwnerId());
    }
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setOwnerId(compound.getFloat("BeardParent"));
    }


    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected void doBlockCollisions() { }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean isInRangeToRenderDist(double distance) {
        if (distance < 1) return false;
        else return super.isInRangeToRenderDist(distance);
    }

    @Override
    public void livingTick() {
        super.livingTick();
        //if (this.beardParent == null) this.beardParent = this.world.getClosestPlayer(this,10D);
        LivingEntity beardParent = this.getBeardParent();
        if (beardParent != null && beardParent.isAlive() && this.world.isRemote){
            this.setPosition(beardParent.getPosX()
            , beardParent.getPosY() + beardParent.getEyeHeight() - .68
            , beardParent.getPosZ());
        }
    }

//    @Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE,  value = Dist.CLIENT)
//    public static class beardEvents {
//        @SubscribeEvent
//        public static void noOwnerDamage(AttackEntityEvent event){
//            if (event.getTarget() instanceof BeardEntity){
//                BeardEntity beard = (BeardEntity) event.getTarget();
//                if (event.getEntityLiving() == beard.getBeardParent()){
//                    event.setCanceled(true);
//                }
//            }
//        }
//    }

}
