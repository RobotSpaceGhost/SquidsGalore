package com.robotspaceghost.squidsgalore.items.SquidMilk;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.sun.java.accessibility.util.java.awt.TextComponentTranslator;
import javafx.geometry.Side;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
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
import net.minecraft.util.text.Color;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.server.command.TextComponentHelper;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.List;

public class SquidInkItem extends Item {
    public final Effect MILK_EFFECT = Effects.BLINDNESS;
    public final int MILK_EFFECT_DURATION = 200;
    public final int MILK_EFFECT_LEVEL = 0;

    public SquidInkItem() {
        super(new Item.Properties().group(SquidsGalore.TAB));
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(this.MILK_EFFECT, this.MILK_EFFECT_DURATION, this.MILK_EFFECT_LEVEL));

            if (entityLiving instanceof PlayerEntity) {
                stack.shrink(1);
                if (!((PlayerEntity) entityLiving).addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE))) {
                    InventoryHelper.spawnItemStack(worldIn, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), new ItemStack(Items.GLASS_BOTTLE));
                }
            } else {
                InventoryHelper.spawnItemStack(worldIn, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), new ItemStack(Items.GLASS_BOTTLE));
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
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
