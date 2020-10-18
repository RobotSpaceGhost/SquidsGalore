package com.robotspaceghost.squidsgalore.items.SquidMilk;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.world.World;

public class SquidMilkTemplate extends Item {
    public final Effect MILK_EFFECT = null;
    public final int MILK_EFFECT_DURATION = 0;
    public final int MILK_EFFECT_LEVEL = 0;

    public SquidMilkTemplate(Effect effect, int duration, int level) {
        super(new Properties().group(SquidsGalore.TAB));
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        //entityLiving.addPotionEffect(new EffectInstance(this.MILK_EFFECT,this.MILK_EFFECT_DURATION,this.MILK_EFFECT_LEVEL));
        return super.onItemUseFinish(stack, worldIn, entityLiving);//remove
    }
}
