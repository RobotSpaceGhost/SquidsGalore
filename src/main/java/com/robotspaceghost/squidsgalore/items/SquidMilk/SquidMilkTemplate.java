package com.robotspaceghost.squidsgalore.items.SquidMilk;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SquidMilkTemplate extends Item {
    public final Effect MILK_EFFECT = Effects.BLINDNESS;
    public final int MILK_EFFECT_DURATION = 200;
    public final int LONG_MILK_EFFECT_DURATION = 400;
    public final int MILK_EFFECT_LEVEL = 0;
    public boolean isLong;

    public SquidMilkTemplate() { this(false); }
    public SquidMilkTemplate(boolean Long){
        super(new Item.Properties().group(SquidsGalore.TAB).maxStackSize(1));
        this.isLong = Long;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(this.MILK_EFFECT,  ((this.isLong) ? this.LONG_MILK_EFFECT_DURATION : this.MILK_EFFECT_DURATION) , this.MILK_EFFECT_LEVEL));
        }
        if (stack.isEmpty()) return new ItemStack(Items.GLASS_BOTTLE);
        else {
            if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
                ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
                PlayerEntity playerentity = (PlayerEntity)entityLiving;
                if (!playerentity.inventory.addItemStackToInventory(itemstack)) playerentity.dropItem(itemstack, false);
            }
            return stack;
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) { return 32; }
    @Override
    public UseAction getUseAction(ItemStack stack) { return UseAction.DRINK; }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(ITextComponent.func_241827_a_(TextFormatting.GRAY +"To remove stains, be sure to use rubbing alcohol!" ));
    }
}
