package com.robotspaceghost.squidsgalore.entities;


import com.robotspaceghost.squidsgalore.init.ModSounds;
import com.robotspaceghost.squidsgalore.util.BeardHandler;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;


public class BeardEntity extends CreatureEntity {

    private LivingEntity beardParent;

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

    @Override
    public void setAIMoveSpeed(float speedIn) { super.setAIMoveSpeed(0); }
    @Override
    public void setMoveForward(float amount) { super.setMoveForward(0); }
    @Override
    public void setMoveVertical(float amount) { super.setMoveVertical(0); }
    @Override
    public void setMoveStrafing(float amount) { super.setMoveStrafing(0); }


    public LivingEntity getBeardParent(){
        return this.beardParent;
    }

    public void setBeardParent(LivingEntity entityIn){
        this.beardParent = entityIn;
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
        else if (this.beardParent != null) return this.beardParent.isInRangeToRenderDist(distance);
        else return super.isInRangeToRenderDist(distance);
    }

    @Override
    public void livingTick() {
        //super.livingTick();
        //if (this.beardParent == null) this.beardParent = this.world.getClosestPlayer(this,10D);
        if(this.beardParent == null){
            //this.beardParent = BeardHandler.getParentFromBeard(this.entityUniqueID);
            //this.beardParent = this.world.getClosestPlayer(this,10D);
            //System.out.println("Remote? : " + this.world.isRemote);
            //if (this.beardParent == null) this.setHealth(0);
            double R = 2;
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
                    this.beardParent = (LivingEntity) host;
                    break;
                }
            }
        } else {
            if (this.beardParent.isAlive()) {
                this.setPosition(this.beardParent.getPosX()
                        , this.beardParent.getPosY() + this.beardParent.getEyeHeight() - .68
                        , this.beardParent.getPosZ());
            }
            if (!this.beardParent.isAlive()) this.setHealth(0);
        }
    }

}
/*
if(this.beardParent == null){
            this.beardParent = BeardHandler.getParentFromBeard(this);
            if (this.beardParent == null) {
                double R = 10;
                AxisAlignedBB beardRad = new AxisAlignedBB(
                        this.getPosX() - R,
                        this.getPosY() - R,
                        this.getPosZ() - R,
                        this.getPosX() + R,
                        this.getPosY() + R,
                        this.getPosZ() + R
                );
                List<Entity> potentialHosts = this.world.getEntitiesWithinAABBExcludingEntity(this, beardRad);
                for (Entity host : potentialHosts) {
                    if (host instanceof LivingEntity && BeardHandler.addBeardHandler((LivingEntity) host, this)) {
                        this.beardParent = (LivingEntity) host;
                        break;
                    }
                }
            }
            if (this.beardParent == null) this.setHealth(0);
        }
 */