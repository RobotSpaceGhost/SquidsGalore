package com.robotspaceghost.squidsgalore.items.SquidMilk;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class AbstractMilkItem extends Item {

    public AbstractMilkItem(Item.Properties properties){
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
            ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
            if (stack.isEmpty()) return itemstack;
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            if (!playerentity.inventory.addItemStackToInventory(itemstack)) playerentity.dropItem(itemstack, false);
        }
        return stack;

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



}
