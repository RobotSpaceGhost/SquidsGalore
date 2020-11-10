package com.robotspaceghost.squidsgalore.entities;


import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.init.ModSounds;
import com.robotspaceghost.squidsgalore.util.BeardHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class BeardEntity extends CreatureEntity {

    protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.createKey(TameableEntity.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    public LivingEntity beardParent;

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
    protected void doBlockCollisions() { }

    @Override
    public void applyEntityCollision(Entity entityIn) { }



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

    @Override
    public void setAIMoveSpeed(float speedIn) { super.setAIMoveSpeed(0); }
    @Override
    public void setMoveForward(float amount) { super.setMoveForward(0); }
    @Override
    public void setMoveVertical(float amount) { super.setMoveVertical(0); }
    @Override
    public void setMoveStrafing(float amount) { super.setMoveStrafing(0); }


    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

//    @Override
//    public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
//        super.setLocationAndAngles(x, y, z, this.rotationYaw, this.rotationPitch);
//    }

//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public void rotateTowards(double yaw, double pitch) {
//        double d0 = pitch * 0.15D;
//        double d1 = yaw * 0.15D;
//        this.rotationPitch = (float)((double)this.rotationPitch + d0);
//        this.rotationYaw = (float)((double)this.rotationYaw + d1);
//        this.rotationPitch = MathHelper.clamp(this.rotationPitch, -90.0F, 90.0F);
//        this.prevRotationPitch = (float)((double)this.prevRotationPitch + d0);
//        this.prevRotationYaw = (float)((double)this.prevRotationYaw + d1);
//        this.prevRotationPitch = MathHelper.clamp(this.prevRotationPitch, -90.0F, 90.0F);
//    }


    @Override
    public double getMountedYOffset() {
        if (this.beardParent != null) return (this.beardParent.getEyeHeight() - .68);
        return super.getMountedYOffset();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean isInRangeToRenderDist(double distance) {
        if (distance < 1) return false;
        else if (this.beardParent != null) return this.beardParent.isInRangeToRenderDist(distance);
        else return false;
    }

    public LivingEntity getBeardParent(){
        UUID uuid = this.getOwnerId();
        if (uuid != null) {
            System.out.println(uuid.toString());
            if (this.world.getPlayerByUuid(uuid) != null) return this.world.getPlayerByUuid(uuid);
            double R = 8;
            AxisAlignedBB beardRad = new AxisAlignedBB(
                    this.getPosX() - R,
                    this.getPosY() - R,
                    this.getPosZ() - R,
                    this.getPosX() + R,
                    this.getPosY() + R,
                    this.getPosZ() + R
            );
            List<Entity> potentialHosts = this.world.getEntitiesWithinAABBExcludingEntity(this,beardRad);
            for (Entity host : potentialHosts) {
                if (!(host instanceof BeardEntity) && (host instanceof LivingEntity)) {
                    System.out.println("Potential Host:" + host.getUniqueID().toString());
                    if (host.getUniqueID().toString().equals(uuid.toString())){
                        System.out.println("found host!");
                        return (LivingEntity) host;
                    }
                }
            }
        }
        return null;
    }

    public void setBeardParent(LivingEntity entityIn){
        if (entityIn != null) {
            this.setOwnerId(entityIn.getUniqueID());
            this.beardParent = entityIn;
        }
    }

    @Nullable
    public UUID getOwnerId() {
        return this.dataManager.get(OWNER_UNIQUE_ID).orElse(null);
    }

    public void setOwnerId(@Nullable UUID p_184754_1_) {
        this.dataManager.set(OWNER_UNIQUE_ID, Optional.ofNullable(p_184754_1_));
    }
    protected void registerData() {
        super.registerData();
        this.dataManager.register(OWNER_UNIQUE_ID, Optional.empty());
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        if (this.getOwnerId() != null) compound.putUniqueId("Owner", this.getOwnerId());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        UUID uuid = (compound.hasUniqueId("Owner")) ? compound.getUniqueId("Owner") : null;
        if (uuid != null) { this.setOwnerId(uuid);}
    }


    @Override
    public void livingTick() {
        super.livingTick();
        if(this.beardParent == null){
            this.setBeardParent(this.getBeardParent());
            if (!this.world.isRemote) BeardHandler.addBeardHandler(this.beardParent, this);
        }
        else {
            if (this.beardParent.isAlive()) {
                this.startRiding(this.beardParent);

                //this.setPosition(this.beardParent.getPosX(), this.beardParent.getPosY() + this.beardParent.getEyeHeight() - .68, this.beardParent.getPosZ());

            }
           if (!this.beardParent.isAlive()){
               if (!(this.beardParent instanceof PlayerEntity)) this.setHealth(0);
           }
        }
    }

    @Override
    protected void onDeathUpdate() {
        if (this.beardParent != null){
            BeardHandler.unregisterBeard(this.beardParent);
        }
        super.onDeathUpdate();
    }
}
