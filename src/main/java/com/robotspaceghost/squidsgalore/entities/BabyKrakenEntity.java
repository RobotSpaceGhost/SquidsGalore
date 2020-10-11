package com.robotspaceghost.squidsgalore.entities;
import com.robotspaceghost.squidsgalore.blocks.GlowSquidSoul;
import com.robotspaceghost.squidsgalore.init.ModBlocks;
import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import java.util.List;


public class BabyKrakenEntity extends AnimalEntity {
    /*
    todo: stareAtFlowerGoal, sitOnBedGoal make tameable, belong to spawning player, if killed by player semiperm debuff "Omen of the Seas"
    safg: stops for a moment to stare at flowers, like it stares at players
    sobg: like cats
    ofts: upon entering ocean biome, summon boss fight

    */
    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ModItems.INK_ON_A_STICK.get());

    public BabyKrakenEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
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
        //this.goalSelector.addGoal(6, new );
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
    /*
    ------------------------
    start glowsquid func
    ----------------------
     */
    //public List entities;
    //public AxisAlignedBB aura;
    public BlockPos soulLoc = new BlockPos(0,250,0);

    @Override
    public void livingTick() {
        super.livingTick();

        if (this.isAlive()) {
            BlockPos newSoulLoc = new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ());
            World worldIn = this.getEntityWorld();
            /*
            aura = new AxisAlignedBB(this.getPosX() - 1, this.getPosY() - 1, this.getPosZ() - 1, this.getPosX() + 2, this.getPosY() + 2, this.getPosZ() + 2);
            entities = world.getEntitiesWithinAABB(getClass(), aura);

            if (!entities.isEmpty() && (entities.size() >= 2)) {
                System.out.println("These Entities Are within Range!" + entities + "");
            }*/
            if ((soulLoc.getX() != newSoulLoc.getX()) || (soulLoc.getY() != newSoulLoc.getY()) || (soulLoc.getZ() != newSoulLoc.getZ())){
                if (worldIn.getBlockState(soulLoc).getBlock() instanceof GlowSquidSoul) {
                        ((GlowSquidSoul) worldIn.getBlockState(soulLoc).getBlock()).clearGlowSquidSoul(worldIn,soulLoc,(worldIn.getFluidState(soulLoc).getFluid() == Fluids.WATER));
                }
                soulLoc = new BlockPos(newSoulLoc); //change soul location
                if ((worldIn.getBlockState(soulLoc).getBlock().getDefaultState() == Blocks.AIR.getDefaultState()) ||
                   (worldIn.getBlockState(soulLoc).getBlock().getDefaultState() == Blocks.WATER.getDefaultState())){
                    worldIn.setBlockState(soulLoc, ModBlocks.GLOW_SQUID_SOUL.get().getDefaultState());
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
/*
------------------------
end glowsquid func
----------------------
 */
    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return null;
    }
}
