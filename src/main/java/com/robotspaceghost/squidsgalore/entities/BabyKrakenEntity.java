package com.robotspaceghost.squidsgalore.entities;
import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BabyKrakenEntity extends CreatureEntity {
    /*
    todo: stareAtFlowerGoal, sitOnBedGoal make tameable, belong to spawning player, if killed by player semiperm debuff "Omen of the Seas"
    safg: stops for a moment to stare at flowers, like it stares at players
    sobg: like cats
    ofts: upon entering ocean biome, summon boss fight

    */
    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ModItems.INK_ON_A_STICK.get());
    public static final Item SQUID_MILK = Items.DRAGON_BREATH.getItem();
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

    @Override
    protected SoundEvent getAmbientSound(){
        return SoundEvents.ENTITY_SQUID_AMBIENT;

    }
    @Override
    protected SoundEvent getDeathSound(){
        return SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH_LAND;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_CAT_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        super.playSound(SoundEvents.ENTITY_ENDERMITE_STEP, 0.15f, 1.0f);
    }

    @Override
    protected void playSwimSound(float volume) {
        super.playSwimSound(volume);
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return super.canBeLeashedTo(player);
    }

    @Override
    public void livingTick() {
        if (!this.world.isRemote){
            if (milkTimer < milkTimerMax){
                if (Math.abs(this.world.getDayTime() - worldTimeWhenMilked) >= milkTimerMax) {
                    milkTimer = milkTimerMax;
                }
                else milkTimer++;
            }
            if (milkTimer == milkTimerMax){
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

    /*
    -----------------
    lava squid func start
    --------------------
     */
    /*
    @Override
    public boolean canRenderOnFire() {
        return false;
    }
    */
    /*
    ---------------------
    lava squid end func
    --------------------
     */
}
