package com.robotspaceghost.squidsgalore.entities;
import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public class BabyKrakenEntity extends CreatureEntity {
    /*
    todo: if killed by player semiperm debuff "Omen of the Seas"

    ofts: upon entering ocean biome, summon boss fight, for now blind player and summon a penisload of drowned and 2 guardians and 1 elder guardian

    */
    private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(BabyKrakenEntity.class, DataSerializers.BOOLEAN);
    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ModItems.INK_ON_A_STICK.get());
    protected static final DataParameter<Boolean> KRAKEN_SITTING = EntityDataManager.createKey(BabyKrakenEntity.class, DataSerializers.BOOLEAN);
    protected static final DataParameter<String> KRAKEN_MOM = EntityDataManager.createKey(BabyKrakenEntity.class, DataSerializers.STRING);
    public static final Item SQUID_MILK = ModItems.KRAKEN_BREATH.get();
    private static final SoundEvent milkedPass = SoundEvents.ENTITY_CAT_PURREOW;
    public static final SoundEvent milkedFail = SoundEvents.ENTITY_CAT_HISS;
    private int milkTimer;
    private static final int milkTimerMax = 12000;
    private int availableMilks;
    private static final int maximumMilks = 1;
    private long worldTimeWhenMilked;

    public BabyKrakenEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        availableMilks = maximumMilks;
        milkTimer = milkTimerMax;
        worldTimeWhenMilked = this.world.getDayTime();
    }
    //func_233815_a_ -> create()
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.registerAttributes()
                .func_233815_a_(Attributes.MAX_HEALTH, 30.0D)
                .func_233815_a_(Attributes.MOVEMENT_SPEED, 0.25D)
                .func_233815_a_(Attributes.FOLLOW_RANGE, 10.0F);
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.3D, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(3, new FollowKrakenMom(this, 1.0, 6,2));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 10.0f));
        this.goalSelector.addGoal(5, new LookAtGoal(this, this.getClass(), 5.0f));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));

    }

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

    //-----------------------------
    // audio
    //---------------------------
    protected SoundEvent getAmbientSound(){ return SoundEvents.ENTITY_SQUID_AMBIENT; }
    protected SoundEvent getDeathSound(){ return SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH_LAND; }
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) { return SoundEvents.ENTITY_CAT_HURT; }
    protected void playStepSound(BlockPos pos, BlockState blockIn) { playSound(SoundEvents.ENTITY_ENDERMITE_STEP, 0.15f, 1.0f); }
    protected void playSwimSound(float volume) { super.playSwimSound(volume); }

    //--------------------------------------------------
    //  Movement
    //----------------------------------------------
    @Override
    public void setAIMoveSpeed(float speedIn) {
        if (this.isSitting()) { super.setAIMoveSpeed(0);}
        else super.setAIMoveSpeed(speedIn);
    }
    @Override
    public void setMoveForward(float amount) {
        if (this.isSitting()) super.setMoveForward(0);
        else super.setMoveForward(amount);
    }
    @Override
    public void setMoveVertical(float amount) {
        if (this.isSitting()) super.setMoveVertical(0);
        else super.setMoveVertical(amount);
    }
    @Override
    public void setMoveStrafing(float amount) {
        if (this.isSitting()) super.setMoveStrafing(0);
        else super.setMoveStrafing(amount);
    }

    @Override
    public void travel(Vector3d moveVec) {
        super.travel(moveVec);
        if (this.isServerWorld() && this.isInWater()) {
            this.moveRelative(this.getAIMoveSpeed(), moveVec);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale(0.2D));
            this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));

        }
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) { return (player.getUniqueID().toString().equals(this.getOwnerId()) && super.canBeLeashedTo(player)); }
    public boolean isSitting(){ return this.dataManager.get(KRAKEN_SITTING); }
    public void sitOrStand(boolean isKrakenSitting){ this.dataManager.set(KRAKEN_SITTING, isKrakenSitting); }

    //--------------------------------------
    // owner data
    //---------------------------------
    public void setOwnerId(String ownerId) { this.dataManager.set(KRAKEN_MOM, ownerId); }
    public String getOwnerId() { return this.dataManager.get(KRAKEN_MOM); }
    public PlayerEntity getKrakenMom(){
        String owner = getOwnerId();
        if (owner.equals("None") || owner.equals("")) return null;
        return this.world.getPlayerByUuid(UUID.fromString(owner));
    }

    //---------------------------------------------------------------------
    // bucket data
    //---------------------------------------------------------------------
    private boolean isFromBucket() { return this.dataManager.get(FROM_BUCKET); }
    public void setFromBucket(boolean p_203706_1_) { this.dataManager.set(FROM_BUCKET, p_203706_1_); }
    protected ItemStack getSquidBucket() { return new ItemStack(ModItems.BUCKET_OF_BABY_KRAKEN.get()); }
    protected void setBucketData(ItemStack bucket) {
        if (this.hasCustomName()) {
            bucket.setDisplayName(this.getCustomName());
        }
    }
    //--------------------------
    // nbt data
    //----------------------
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FROM_BUCKET, false);
        this.dataManager.register(KRAKEN_SITTING, false);
        this.dataManager.register(KRAKEN_MOM, "None");
    }
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
        compound.putBoolean("KrakenSitting", this.isSitting());
        compound.putString("KrakenMom", this.getOwnerId());

    }
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
        this.sitOrStand(compound.getBoolean("KrakenSitting"));
        this.setOwnerId(compound.getString("KrakenMom"));

    }

    //---------------------------------------------------------------------------
    // player interaction
    //----------------------------------------------------------------
    @Override
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (itemstack.getItem() == Items.WATER_BUCKET && player.getUniqueID().toString().equals(this.getOwnerId()) && this.isAlive()) {
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
        }//short snippet for bucketing
        else if(!itemstack.isEmpty() &&  itemstack.getItem().isIn(ItemTags.FISHES) && this.isAlive()){
            if (!this.world.isRemote) {
                if (this.getHealth() < this.getMaxHealth() && !this.isPotionActive(Effects.REGENERATION)) {
                    this.playSound(SoundEvents.ENTITY_STRIDER_EAT, 1.0F, 1.0F);
                    this.addPotionEffect(new EffectInstance(Effects.REGENERATION, 80, 1));
                }else{
                    InventoryHelper.spawnItemStack(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), new ItemStack(itemstack.getItem()));
                    this.playSound(SoundEvents.ENTITY_FOX_SPIT, 1.0F, 1.0F);
                }
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                }
            }

            return this.world.isRemote ? ActionResultType.SUCCESS : ActionResultType.CONSUME;
        }//short snippet for feeding
        else if(itemstack.isEmpty() && player.getUniqueID().toString().equals(this.getOwnerId()) && this.isAlive()){
            if (!this.world.isRemote  && hand == player.getActiveHand()) {

                if (!this.isInWater()) {
                    if (this.isSitting()) {
                        this.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 0.2F, 1.0F);
                    } else this.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 0.2F, 1.0F);
                } else {
                    if (this.isSitting()) {
                        this.playSound(SoundEvents.BLOCK_BUBBLE_COLUMN_UPWARDS_INSIDE, 0.2F, 1.0F);

                    }else{
                        this.playSound(SoundEvents.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE, 0.2F, 1.0F);

                    }
                }
                this.sitOrStand(!this.isSitting());
            }
            return this.world.isRemote ? ActionResultType.FAIL : ActionResultType.PASS;
        }//short snippet for sitting
        return super.func_230254_b_(player, hand);
    }

    //-----------------------------------------
    // milk helper
    //-----------------------------------
    public ItemStack milkSquid(){
        if (!this.world.isRemote) {
            if (availableMilks > 0) {
                availableMilks--;
                if (availableMilks == 0){
                    worldTimeWhenMilked = this.world.getDayTime();
                    milkTimer = 0;
                }
                playSound(milkedPass, 1.0f, 1.0f);
                return new ItemStack(SQUID_MILK);
            }else{
                playSound(milkedFail, 1.0f, 1.0f);
            }
        }
        return null;
    }
    //---------------------------------------------------
    // every tick
    //---------------------------------------------
    @Override
    public void livingTick() {
        if (!this.world.isRemote){
            if (milkTimer < milkTimerMax){
                long curTime = this.world.getDayTime();
                if ((curTime >= worldTimeWhenMilked && ((curTime - worldTimeWhenMilked) >= milkTimerMax))
                    ||(curTime < worldTimeWhenMilked && (((24000 - (worldTimeWhenMilked % 24000)) + (curTime % 24000)) >= milkTimerMax ))){
                     milkTimer = milkTimerMax;
                }
                else milkTimer++;
            }
            if (milkTimer == milkTimerMax && (availableMilks != maximumMilks)){
                availableMilks = maximumMilks;
            }
        }
        super.livingTick();

    }
    //------------------------------------------------
    // on death
    //-----------------------------------------
//    @Override
//
//    protected void updateAITasks() {
//        super.updateAITasks();
//        int i = 20;
//        if ((this.ticksExisted + this.getEntityId()) % i == 0) {
//            Effect effect = Effects.BLINDNESS;
//            List<ServerPlayerEntity> list = ((ServerWorld)this.world).getPlayers((player) -> this.getRevengeTarget() == player && player.interactionManager.survivalOrAdventure());
//            int j = 2;
//            int k = 200;
//            int l = 20;
//
//            for(ServerPlayerEntity serverplayerentity : list) {
//                if (!serverplayerentity.isPotionActive(effect) || serverplayerentity.getActivePotionEffect(effect).getAmplifier() < j || serverplayerentity.getActivePotionEffect(effect).getDuration() < l) {
//                    serverplayerentity.getServerWorld().spawnParticle(serverplayerentity,ParticleTypes.ELDER_GUARDIAN,false, serverplayerentity.getPosX(), serverplayerentity.getPosY(), serverplayerentity.getPosZ(),1, 0.0D, 0.0D, 0.0D, 0);
//                    playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE,1,1);
//                    serverplayerentity.addPotionEffect(new EffectInstance(effect, k, j));
//                }
//            }
//        }
//
//    }


    @Override
    public void onDeath(DamageSource cause) {
        ServerPlayerEntity babyKiller = (ServerPlayerEntity) this.getRevengeTarget();
        Effect effect = Effects.BLINDNESS;
        int effectDuration = 200;
        int effectLevel = 2;
        if (!this.world.isRemote && babyKiller != null && babyKiller.interactionManager.survivalOrAdventure()){
            babyKiller.getServerWorld().spawnParticle(babyKiller,ParticleTypes.ELDER_GUARDIAN,false, babyKiller.getPosX(), babyKiller.getPosY(), babyKiller.getPosZ(),1, 0.0D, 0.0D, 0.0D, 0);
            playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE,1,1);
            babyKiller.addPotionEffect(new EffectInstance(effect,effectDuration,effectLevel));

        }
        if (this.getKrakenMom() != this.getRevengeTarget()){
            this.getKrakenMom().addItemStackToInventory(new ItemStack(ModItems.BABY_KRAKEN_EGG.get()));
        }
        super.onDeath(cause);
    }

    //--------------------------------------
    // custom goal
    //------------------------------------
    public class FollowKrakenMom extends Goal {
        private final BabyKrakenEntity babyKraken;
        private PlayerEntity krakenMom;
        private final double followSpeed;
        private final PathNavigator navigator;
        private int timeToRecalcPath;
        private final IWorldReader world;
        private final float maxDist;
        private final float minDist;
        private float oldWaterCost;

        public FollowKrakenMom(BabyKrakenEntity babyKrakenEntity, double followSpeedVal, float minimumDist, float maximumDist) {
            this.babyKraken = babyKrakenEntity;
            this.world = babyKrakenEntity.world;
            this.followSpeed = followSpeedVal;
            this.navigator = babyKrakenEntity.getNavigator();
            this.minDist = minimumDist;
            this.maxDist = maximumDist;
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
            if (!(babyKrakenEntity.getNavigator() instanceof GroundPathNavigator)) {
                throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
            }
        }

        public boolean shouldExecute() {
            if(babyKraken.isAlive() && !babyKraken.getEntityWorld().isRemote()) {
                PlayerEntity owner = babyKraken.getKrakenMom();
                if (owner == null) {
                    return false;
                } else if (owner.isSpectator()) {
                    return false;
                }else if(babyKraken.isSitting()){
                    return false;
                } else if (this.babyKraken.getDistanceSq(owner) < (double)(this.minDist * this.minDist)) {
                    return false;
                } else {
                    this.krakenMom = owner;
                    return true;
                }
            }
            return false;
        }

        public boolean shouldContinueExecuting() {
            if (this.navigator.noPath()) {
                return false;
            } else {
                return !(this.babyKraken.getDistanceSq(this.krakenMom) <= (double)(this.maxDist * this.maxDist));
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.timeToRecalcPath = 0;
            this.oldWaterCost = this.babyKraken.getPathPriority(PathNodeType.WATER);
            this.babyKraken.setPathPriority(PathNodeType.WATER, 0.0F);
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.krakenMom = null;
            this.navigator.clearPath();
            this.babyKraken.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            this.babyKraken.getLookController().setLookPositionWithEntity(this.krakenMom, 10.0F, (float)this.babyKraken.getVerticalFaceSpeed());
            if (--this.timeToRecalcPath <= 0) {
                this.timeToRecalcPath = 10;
                if (!this.babyKraken.getLeashed() && !this.babyKraken.isPassenger()) {
                    if (this.babyKraken.getDistanceSq(this.krakenMom) >= 144.0D) {
                        this.func_226330_g_();
                    } else {
                        this.navigator.tryMoveToEntityLiving(this.krakenMom, this.followSpeed);
                    }

                }
            }
        }

        //following three methods teleport func
        private void func_226330_g_() {
            BlockPos blockpos = this.krakenMom.func_233580_cy_();

            for(int i = 0; i < 10; ++i) {
                int j = this.func_226327_a_(-3, 3);
                int k = this.func_226327_a_(-1, 1);
                int l = this.func_226327_a_(-3, 3);
                boolean flag = this.func_226328_a_(blockpos.getX() + j, blockpos.getY() + k, blockpos.getZ() + l);
                if (flag) {
                    return;
                }
            }

        }

        private boolean func_226328_a_(int posX, int posY, int posZ) {
            if (Math.abs((double)posX - this.krakenMom.getPosX()) < 2.0D && Math.abs((double)posZ - this.krakenMom.getPosZ()) < 2.0D) {
                return false;
            } else if (!this.func_226329_a_(new BlockPos(posX, posY, posZ))) {
                return false;
            } else {
                this.babyKraken.setLocationAndAngles((double)posX + 0.5D, (double)posY, (double)posZ + 0.5D, this.babyKraken.rotationYaw, this.babyKraken.rotationPitch);
                this.navigator.clearPath();
                return true;
            }
        }

        private boolean func_226329_a_(BlockPos blockPos) {
            PathNodeType pathnodetype = WalkNodeProcessor.func_237231_a_(this.world, blockPos.func_239590_i_());
            if (pathnodetype != PathNodeType.WALKABLE) {
                return false;
            } else {
                BlockState blockstate = this.world.getBlockState(blockPos.down());
                if (blockstate.getBlock() instanceof LeavesBlock) {
                    return false;
                } else {
                    BlockPos blockpos = blockPos.subtract(this.babyKraken.func_233580_cy_());
                    return this.world.hasNoCollisions(this.babyKraken, this.babyKraken.getBoundingBox().offset(blockpos));
                }
            }
        }

        //rng func
        private int func_226327_a_(int minBound, int maxBound) {
            return this.babyKraken.getRNG().nextInt(maxBound - minBound + 1) + minBound;
        }

    }


    /*
        ------------------------
        start glowsquid func
        ----------------------
         */
    //public List entities;
    //public AxisAlignedBB aura;
    /*
            aura = new AxisAlignedBB(this.getPosX() - 1, this.getPosY() - 1, this.getPosZ() - 1, this.getPosX() + 2, this.getPosY() + 2, this.getPosZ() + 2);
            entities = world.getEntitiesWithinAABB(getClass(), aura);

            if (!entities.isEmpty() && (entities.size() >= 2)) {
                System.out.println("These Entities Are within Range!" + entities + "");
     }*/
    /*
    //change some stuff to !isremote probably
    public BlockPos soulLoc = new BlockPos(0,250,0);
    @Override
    public void livingTick() {
        super.livingTick();

        if (this.isAlive()) {
            BlockPos newSoulLoc = new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ());
            World worldIn = this.getEntityWorld();

            if ((soulLoc.getX() != newSoulLoc.getX()) || (soulLoc.getY() != newSoulLoc.getY()) || (soulLoc.getZ() != newSoulLoc.getZ())){
                if (worldIn.getBlockState(soulLoc).getBlock() instanceof GlowSquidSoul) {
                        ((GlowSquidSoul) worldIn.getBlockState(soulLoc).getBlock()).clearGlowSquidSoul(worldIn,soulLoc,(worldIn.getFluidState(soulLoc).getFluid() == Fluids.WATER));
                }
                soulLoc = new BlockPos(newSoulLoc); //change soul location
                if ((worldIn.getBlockState(soulLoc).getBlock().getDefaultState() == Blocks.AIR.getDefaultState()) ||
                   (worldIn.getBlockState(soulLoc).getBlock().getDefaultState() == Blocks.WATER.getDefaultState())){
                    if ((worldIn.getBlockState(soulLoc).getBlock().getDefaultState() == Blocks.WATER.getDefaultState())) {
                        worldIn.setBlockState(soulLoc, ModBlocks.GLOW_SQUID_SOUL.get().getDefaultState().with(BlockStateProperties.WATERLOGGED, true));
                    }else{
                        worldIn.setBlockState(soulLoc, ModBlocks.GLOW_SQUID_SOUL.get().getDefaultState());
                    }
                }
            }
        }
    }
    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        World worldIn = this.getEntityWorld();
        if (worldIn.getBlockState(soulLoc).getBlock() instanceof GlowSquidSoul) {
            ((GlowSquidSoul) worldIn.getBlockState(soulLoc).getBlock()).clearGlowSquidSoul(worldIn,soulLoc,(worldIn.getFluidState(soulLoc).getFluid() == Fluids.WATER));
        }
    }
    */
    /*
    ------------------------
    end glowsquid func
    ----------------------
     */

}
