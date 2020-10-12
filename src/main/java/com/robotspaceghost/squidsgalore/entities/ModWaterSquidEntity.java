package com.robotspaceghost.squidsgalore.entities;

import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public abstract class ModWaterSquidEntity extends WaterMobEntity {
    private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(AbstractFishEntity.class, DataSerializers.BOOLEAN);
    public float squidPitch;
    public float prevSquidPitch;
    public float squidYaw;
    public float prevSquidYaw;
    public float squidRotation;
    public float prevSquidRotation;
    public float tentacleAngle;
    public float lastTentacleAngle;
    private float randomMotionSpeed;
    private float rotationVelocity;
    private float rotateSpeed;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public ModWaterSquidEntity(EntityType<? extends ModWaterSquidEntity> type, World worldIn) {
        super(type, worldIn);
        this.rand.setSeed(this.getEntityId());
        this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return sizeIn.height * 0.5F;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.3D, Ingredient.fromItems(ModItems.INK_ON_A_STICK.get()), false));
        this.goalSelector.addGoal(7, new ModWaterSquidEntity.MoveRandomGoal(this));
        this.goalSelector.addGoal(8, new ModWaterSquidEntity.FleeGoal());
    }

    public static AttributeModifierMap.MutableAttribute func_234176_m_() {
        return MobEntity.func_233666_p_().func_233815_a_(Attributes.MAX_HEALTH, 10.0D)
                .func_233815_a_(Attributes.MOVEMENT_SPEED, 0.25D)
                .func_233815_a_(Attributes.FOLLOW_RANGE, 10.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SQUID_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SQUID_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }


    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume() {
        return 0.4F;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public void livingTick() {
        super.livingTick();
        this.prevSquidPitch = this.squidPitch;
        this.prevSquidYaw = this.squidYaw;
        this.prevSquidRotation = this.squidRotation;
        this.lastTentacleAngle = this.tentacleAngle;
        this.squidRotation += this.rotationVelocity;
        if ((double)this.squidRotation > (Math.PI * 2D)) {
            if (this.world.isRemote) {
                this.squidRotation = ((float)Math.PI * 2F);
            } else {
                this.squidRotation = (float)((double)this.squidRotation - (Math.PI * 2D));
                if (this.rand.nextInt(10) == 0) {
                    this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
                }

                this.world.setEntityState(this, (byte)19);
            }
        }

        if (this.isInWaterOrBubbleColumn()) {
            if (this.squidRotation < (float)Math.PI) {
                float f = this.squidRotation / (float)Math.PI;
                this.tentacleAngle = MathHelper.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25F;
                if ((double)f > 0.75D) {
                    this.randomMotionSpeed = 1.0F;
                    this.rotateSpeed = 1.0F;
                } else {
                    this.rotateSpeed *= 0.8F;
                }
            } else {
                this.tentacleAngle = 0.0F;
                this.randomMotionSpeed *= 0.9F;
                this.rotateSpeed *= 0.99F;
            }

            if (!this.world.isRemote) {
                this.setMotion((double)(this.randomMotionVecX * this.randomMotionSpeed), (double)(this.randomMotionVecY * this.randomMotionSpeed), (double)(this.randomMotionVecZ * this.randomMotionSpeed));
            }

            Vector3d vector3d = this.getMotion();
            float f1 = MathHelper.sqrt(horizontalMag(vector3d));
            this.renderYawOffset += (-((float)MathHelper.atan2(vector3d.x, vector3d.z)) * (180F / (float)Math.PI) - this.renderYawOffset) * 0.1F;
            this.rotationYaw = this.renderYawOffset;
            this.squidYaw = (float)((double)this.squidYaw + Math.PI * (double)this.rotateSpeed * 1.5D);
            this.squidPitch += (-((float)MathHelper.atan2((double)f1, vector3d.y)) * (180F / (float)Math.PI) - this.squidPitch) * 0.1F;
        } else {
            this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * (float)Math.PI * 0.25F;
            if (!this.world.isRemote) {
                double d0 = this.getMotion().y;
                if (this.isPotionActive(Effects.LEVITATION)) {
                    d0 = 0.05D * (double)(this.getActivePotionEffect(Effects.LEVITATION).getAmplifier() + 1);
                } else if (!this.hasNoGravity()) {
                    d0 -= 0.08D;
                }

                this.setMotion(0.0D, d0 * (double)0.98F, 0.0D);
            }

            this.squidPitch = (float)((double)this.squidPitch + (double)(-90.0F - this.squidPitch) * 0.02D);
        }

    }
    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (super.attackEntityFrom(source, amount) && this.getRevengeTarget() != null) {
            this.squirtInk();
            return true;
        } else {
            return false;
        }
    }

    private Vector3d func_207400_b(Vector3d p_207400_1_) {
        Vector3d vector3d = p_207400_1_.rotatePitch(this.prevSquidPitch * ((float)Math.PI / 180F));
        return vector3d.rotateYaw(-this.prevRenderYawOffset * ((float)Math.PI / 180F));
    }

    private void squirtInk() {
        this.playSound(SoundEvents.ENTITY_SQUID_SQUIRT, this.getSoundVolume(), this.getSoundPitch());
        Vector3d vector3d = this.func_207400_b(new Vector3d(0.0D, -1.0D, 0.0D)).add(this.getPosX(), this.getPosY(), this.getPosZ());

        for(int i = 0; i < 30; ++i) {
            Vector3d vector3d1 = this.func_207400_b(new Vector3d((double)this.rand.nextFloat() * 0.6D - 0.3D, -1.0D, (double)this.rand.nextFloat() * 0.6D - 0.3D));
            Vector3d vector3d2 = vector3d1.scale(0.3D + (double)(this.rand.nextFloat() * 2.0F));
            ((ServerWorld)this.world).spawnParticle(ParticleTypes.SQUID_INK, vector3d.x, vector3d.y + 0.5D, vector3d.z, 0, vector3d2.x, vector3d2.y, vector3d2.z, (double)0.1F);
        }

    }

    public void travel(Vector3d p_213352_1_) {
        this.move(MoverType.SELF, this.getMotion());
    }

    public boolean preventDespawn() {
        return super.preventDespawn() || this.isFromBucket();
    }

    public static boolean func_223363_b(EntityType<? extends ModWaterSquidEntity> type, IWorld worldIn, SpawnReason reason, BlockPos p_223363_3_, Random randomIn) {
        return worldIn.getBlockState(p_223363_3_).isIn(Blocks.WATER) && worldIn.getBlockState(p_223363_3_.up()).isIn(Blocks.WATER);
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return !this.isFromBucket() && !this.hasCustomName();
    }
    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return true;
    }
    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk() {
        return 8;
    }
    //-----------------------------------------------------------------
    // bucket stuff
    //-------------------------------------------------------------
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

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    protected ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getHeldItem(p_230254_2_);
        if (itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
            this.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);
            ItemStack itemstack1 = this.getFishBucket();
            this.setBucketData(itemstack1);
            if (!this.world.isRemote) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity)p_230254_1_, itemstack1);
            }

            if (itemstack.isEmpty()) {
                p_230254_1_.setHeldItem(p_230254_2_, itemstack1);
            } else if (!p_230254_1_.inventory.addItemStackToInventory(itemstack1)) {
                p_230254_1_.dropItem(itemstack1, false);
            }

            this.remove();
            return ActionResultType.func_233537_a_(this.world.isRemote);
        } else {
            return super.func_230254_b_(p_230254_1_, p_230254_2_);
        }
    }

    /**
     * Add extra data to the bucket that just picked this fish up
     */
    protected void setBucketData(ItemStack bucket) {
        if (this.hasCustomName()) {
            bucket.setDisplayName(this.getCustomName());
        }

    }

    protected abstract ItemStack getFishBucket();

    //-----------------------------------------------------------------
    // end bucket stuff
    //-------------------------------------------------------------
    /**
     * Handler for {@link World#setEntityState}
     */
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 19) {
            this.squidRotation = 0.0F;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn) {
        this.randomMotionVecX = randomMotionVecXIn;
        this.randomMotionVecY = randomMotionVecYIn;
        this.randomMotionVecZ = randomMotionVecZIn;
    }

    public boolean hasMovementVector() {
        return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
    }

    class FleeGoal extends Goal {
        private int tickCounter;

        private FleeGoal() {
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            LivingEntity livingentity = ModWaterSquidEntity.this.getRevengeTarget();
            if (ModWaterSquidEntity.this.isInWater() && livingentity != null) {
                return ModWaterSquidEntity.this.getDistanceSq(livingentity) < 100.0D;
            } else {
                return false;
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.tickCounter = 0;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            ++this.tickCounter;
            LivingEntity livingentity = ModWaterSquidEntity.this.getRevengeTarget();
            if (livingentity != null) {
                Vector3d vector3d = new Vector3d(ModWaterSquidEntity.this.getPosX() - livingentity.getPosX(), ModWaterSquidEntity.this.getPosY() - livingentity.getPosY(), ModWaterSquidEntity.this.getPosZ() - livingentity.getPosZ());
                BlockState blockstate = ModWaterSquidEntity.this.world.getBlockState(new BlockPos(ModWaterSquidEntity.this.getPosX() + vector3d.x, ModWaterSquidEntity.this.getPosY() + vector3d.y, ModWaterSquidEntity.this.getPosZ() + vector3d.z));
                FluidState fluidstate = ModWaterSquidEntity.this.world.getFluidState(new BlockPos(ModWaterSquidEntity.this.getPosX() + vector3d.x, ModWaterSquidEntity.this.getPosY() + vector3d.y, ModWaterSquidEntity.this.getPosZ() + vector3d.z));
                if (fluidstate.isTagged(FluidTags.WATER) || blockstate.isAir()) {
                    double d0 = vector3d.length();
                    if (d0 > 0.0D) {
                        vector3d.normalize();
                        float f = 3.0F;
                        if (d0 > 5.0D) {
                            f = (float)((double)f - (d0 - 5.0D) / 5.0D);
                        }

                        if (f > 0.0F) {
                            vector3d = vector3d.scale((double)f);
                        }
                    }

                    if (blockstate.isAir()) {
                        vector3d = vector3d.subtract(0.0D, vector3d.y, 0.0D);
                    }

                    ModWaterSquidEntity.this.setMovementVector((float)vector3d.x / 20.0F, (float)vector3d.y / 20.0F, (float)vector3d.z / 20.0F);
                }

                if (this.tickCounter % 10 == 5) {
                    ModWaterSquidEntity.this.world.addParticle(ParticleTypes.BUBBLE, ModWaterSquidEntity.this.getPosX(), ModWaterSquidEntity.this.getPosY(), ModWaterSquidEntity.this.getPosZ(), 0.0D, 0.0D, 0.0D);
                }

            }
        }
    }

    class MoveRandomGoal extends Goal {
        private final ModWaterSquidEntity squid;

        public MoveRandomGoal(ModWaterSquidEntity p_i48823_2_) {
            this.squid = p_i48823_2_;
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            return true;
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            int i = this.squid.getIdleTime();
            if (i > 100) {
                this.squid.setMovementVector(0.0F, 0.0F, 0.0F);
            } else if (this.squid.getRNG().nextInt(50) == 0 || !this.squid.inWater || !this.squid.hasMovementVector()) {
                float f = this.squid.getRNG().nextFloat() * ((float)Math.PI * 2F);
                float f1 = MathHelper.cos(f) * 0.2F;
                float f2 = -0.1F + this.squid.getRNG().nextFloat() * 0.2F;
                float f3 = MathHelper.sin(f) * 0.2F;
                this.squid.setMovementVector(f1, f2, f3);
            }

        }
    }
}
