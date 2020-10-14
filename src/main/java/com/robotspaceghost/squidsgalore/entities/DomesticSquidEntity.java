package com.robotspaceghost.squidsgalore.entities;

import com.robotspaceghost.squidsgalore.entities.goals.SquidTemptGoal;
import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class DomesticSquidEntity extends ModWaterSquidEntity {
    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(ModItems.INK_ON_A_STICK.get(), Items.COD, Items.SALMON, Items.TROPICAL_FISH, Items.PUFFERFISH);
    public static final Item SQUID_MILK = ModItems.SQUID_INK.get();
    private static final SoundEvent milkedPass = SoundEvents.ENTITY_SQUID_SQUIRT;
    private static final SoundEvent milkedFail = SoundEvents.ENTITY_SQUID_HURT;
    private int milkTimer;
    private static final int milkTimerMax = 12000;
    private int availableMilks;
    private static final int maximumMilks = 6;
    private long worldTimeWhenMilked;
    public DomesticSquidEntity(EntityType<? extends DomesticSquidEntity> type, World worldIn) {
        super(type, worldIn);
    }
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.registerAttributes()
                .func_233815_a_(Attributes.MAX_HEALTH, 10.0D)
                .func_233815_a_(Attributes.MOVEMENT_SPEED, 0.25D)
                .func_233815_a_(Attributes.FOLLOW_RANGE, 10.0F);
    }
    @Override
    protected ItemStack getSquidBucket() {
        return new ItemStack(ModItems.BUCKET_OF_SQUID.get());
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new SquidTemptGoal(this, 1.3D,TEMPTATION_ITEMS));
    }


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
}
