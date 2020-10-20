package com.robotspaceghost.squidsgalore.entities;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public abstract class AbstractSquidEntity extends AnimalEntity {
    private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(BabyKrakenEntity.class, DataSerializers.BOOLEAN);
    private Fluid livesIn;
    protected AbstractSquidEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }



    //--------------------------------
    // audio
    //--------------------------------

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SQUID_AMBIENT;
    }
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SQUID_HURT;
    }
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }
    protected float getSoundVolume() {
        return 0.4F;
    }

    //--------------------------------
    // end audio
    //-------------------------------
    //-----------------------------------
    // habitat and fluids
    //-----------------------------------
    public Fluid getHabitatFluid(){ return livesIn;}
    public void setHabitatFluid(){ livesIn = Fluids.WATER;}
    protected void updateAir(int airLeft) {
        if (this.isAlive() && ((livesIn == Fluids.WATER && this.isInWaterOrBubbleColumn())||(livesIn == Fluids.LAVA && !this.inLava))) {
            this.setAir(airLeft - 1);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAir(300);
        }

    }
    public void baseTick() {
        int airLeft = this.getAir();
        super.baseTick();
        this.updateAir(airLeft);
    }

    @Override
    protected void setOnFireFromLava() { if (livesIn != Fluids.LAVA) super.setOnFireFromLava();}

    @Override
    public void setFire(int seconds) { if (livesIn != Fluids.LAVA) super.setFire(seconds);}

    @Override
    public boolean canRenderOnFire() {
        return (livesIn != Fluids.LAVA && super.canRenderOnFire());
    }

    public boolean isPushedByWater() {
        return false;
    }

    //---------------------------------
    // end habitat and fluids
    //--------------------------------

    //------------------------------------------
    // buckets
    //---------------------------------------
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FROM_BUCKET, false);
    }

    private boolean isFromBucket() {
        return this.dataManager.get(FROM_BUCKET);
    }

    public void setFromBucket(boolean p_203706_1_) {
        this.dataManager.set(FROM_BUCKET, p_203706_1_);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }
    @Override
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {

        ItemStack itemstack = player.getHeldItem(hand);
        if (itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
            this.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);
            ItemStack bucketType = this.getSquidBucket();
            this.setBucketData(bucketType);
            if (!this.world.isRemote) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity)player, bucketType);
            }
            if (itemstack.isEmpty()) {
                player.setHeldItem(hand, bucketType);
            } else if (!player.inventory.addItemStackToInventory(bucketType)) {
                player.dropItem(bucketType, false);
            }

            this.remove();
            return this.world.isRemote ? ActionResultType.SUCCESS : ActionResultType.CONSUME;
        }
        return super.func_230254_b_(player,hand);
    }

    protected void setBucketData(ItemStack bucket) {
        if (this.hasCustomName()) {
            bucket.setDisplayName(this.getCustomName());
        }
    }

    protected abstract ItemStack getSquidBucket();
    //-----------------------------
    // end buckets
    //-----------------------------
    //------------------------------
    //  breeding
    //-----------------------------
    public abstract List<Item> getBreedItems();

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return (getBreedItems().contains(stack.getItem()));
    }

    //------------------------------
    //  breeding
    //-----------------------------
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }

}
