package com.robotspaceghost.squidsgalore.entities;
import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;


public class BabyKrakenEntity extends CreatureEntity {
    /*
    todo: stareAtFlowerGoal, sitOnBedGoal make tameable, belong to spawning player, if killed by player semiperm debuff "Omen of the Seas"
    safg: stops for a moment to stare at flowers, like it stares at players
    sobg: like cats
    ofts: upon entering ocean biome, summon boss fight

    */
    private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(BabyKrakenEntity.class, DataSerializers.BOOLEAN);
    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ModItems.INK_ON_A_STICK.get());
    protected static boolean sitting;
    private static PlayerEntity owner; //make final
    private static boolean onOwnerHead;
    public static final Item SQUID_MILK = ModItems.KRAKEN_BREATH.get();
    private static final SoundEvent milkedPass = SoundEvents.ENTITY_CAT_PURREOW;
    private static final SoundEvent milkedFail = SoundEvents.ENTITY_CAT_HISS;
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
        onOwnerHead = false;
    }
    //func_233815_a_ -> create()
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.registerAttributes()
                .func_233815_a_(Attributes.MAX_HEALTH, 10.0D)
                .func_233815_a_(Attributes.MOVEMENT_SPEED, 0.25D)
                .func_233815_a_(Attributes.FOLLOW_RANGE, 10.0F);
    }

    @Override
    protected void registerGoals(){
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.3D, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this,1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 10.0f));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return 0;
    }
    //-----------------------------
    // audio
    //---------------------------
    protected SoundEvent getAmbientSound(){ return SoundEvents.ENTITY_SQUID_AMBIENT; }
    protected SoundEvent getDeathSound(){
        return SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH_LAND;
    }
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CAT_HURT;
    }
    protected void playStepSound(BlockPos pos, BlockState blockIn) { playSound(SoundEvents.ENTITY_ENDERMITE_STEP, 0.15f, 1.0f); }
    protected void playSwimSound(float volume) {
        super.playSwimSound(volume);
    }
    //-------------------------
    // end audio
    //---------------------
    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean isPushedByWater() { return false; }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) { return false;}
    //--------------------------------------------------
    //  owner commands
    //----------------------------------------------
    public boolean isSitting(){
        return sitting;
    }
    public void sitOrStand(){
        if (sitting) this.getCollisionBox(this).grow(.1);
        else this.getCollisionBox(this).shrink(.1);
        sitting = !this.isSitting();
        System.out.println("Changed sitting to " + sitting);
    }

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
    //----------------------------------
    //  end owner commands
    //-------------------------------------------
    //---------------------------------------------------------------------
    // bucket info
    //---------------------------------------------------------------------
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
        //short snippet for breeding
        else if(!itemstack.isEmpty() && itemstack.getItem().isIn(ItemTags.FISHES) && this.isAlive()){
            if (!this.world.isRemote) {
                this.playSound(SoundEvents.ENTITY_STRIDER_EAT, 1.0F, 1.0F);
            }
            if (!player.abilities.isCreativeMode) {
                itemstack.shrink(1);
            }
            return this.world.isRemote ? ActionResultType.SUCCESS : ActionResultType.CONSUME;
        }else if(itemstack.isEmpty() && this.isAlive()){
            if (!this.world.isRemote && hand ==  player.getActiveHand()) { // Todo: add owner check here
                if (this.isSitting()){
                    this.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 0.2F, 1.0F);
                }
                else this.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 0.2F, 1.0F);
                this.sitOrStand();
            }
            return this.world.isRemote ? ActionResultType.FAIL : ActionResultType.PASS;
        }//short snippet for sitting
        return super.func_230254_b_(player, hand);
    }


    protected void setBucketData(ItemStack bucket) {
        if (this.hasCustomName()) {
            bucket.setDisplayName(this.getCustomName());
        }
    }
    protected ItemStack getSquidBucket() {
        return new ItemStack(ModItems.BUCKET_OF_BABY_KRAKEN.get());
    }

    //---------------------------------------------------------------------------
    // end bucket info
    //----------------------------------------------------------------
    @Override
    public void livingTick() {

    //--------------------------------------------------------------------
    // milk info
    //---------------------------------------------------------
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
        //--------------------------------------------------------------------
        // end milk info
        //---------------------------------------------------------
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
