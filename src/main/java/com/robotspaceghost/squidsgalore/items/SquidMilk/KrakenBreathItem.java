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

public class KrakenBreathItem extends AbstractMilkItem {
    public final Effect MILK_EFFECT = null;
    public final int MILK_EFFECT_DURATION = 0;
    public final int LONG_MILK_EFFECT_DURATION = 0;
    public final int MILK_EFFECT_LEVEL = 0;
    public boolean isLong;

    public KrakenBreathItem() {
        this(false);
    }
    public KrakenBreathItem(boolean Long){
        super();
        this.isLong = Long;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            //entityLiving.addPotionEffect(new EffectInstance(this.MILK_EFFECT,  ((this.isLong) ? this.LONG_MILK_EFFECT_DURATION : this.MILK_EFFECT_DURATION) , this.MILK_EFFECT_LEVEL));
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(ITextComponent.func_241827_a_(TextFormatting.GRAY + "Smells like salty mint" ));
    }
}
