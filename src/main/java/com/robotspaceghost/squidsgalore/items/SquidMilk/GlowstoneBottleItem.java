package com.robotspaceghost.squidsgalore.items.SquidMilk;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.init.ModEffects;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class GlowstoneBottleItem extends AbstractMilkItem{
    public final Effect MILK_EFFECT = ModEffects.GLOWSTONE_BOTTLE_EFFECT;
    public final int MILK_EFFECT_DURATION =  5 * 60 * 20;
    public final int MILK_EFFECT_LEVEL = 0;
    public final boolean isLong;
    public final boolean isThick;


    public GlowstoneBottleItem(int variant){
        super(new Properties().maxStackSize(1));
        this.isLong = variant == 1;
        this.isThick = variant == 2;
    }
    public GlowstoneBottleItem(){
        super(new Properties().group(SquidsGalore.TAB).maxStackSize(1));
        this.isLong = false;
        this.isThick = false;
    }
    @Override
    public boolean hasEffect(ItemStack stack) {
        return this.isLong||this.isThick;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(
                     this.MILK_EFFECT,
                    ((this.isLong) ? this.MILK_EFFECT_DURATION * 2 : this.MILK_EFFECT_DURATION),
                    ((this.isThick) ? this.MILK_EFFECT_LEVEL + 1 : this.MILK_EFFECT_LEVEL)
            ));
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        String defaultDisplayName = stack.getDisplayName().getString();
        if (this.isLong && !defaultDisplayName.contains("Extended")) {
            stack.setDisplayName(ITextComponent.func_241827_a_(TextFormatting.RED + "Extended " + defaultDisplayName));
        }
        else if (this.isThick && !defaultDisplayName.contains("Inconspicuous")) {
            stack.setDisplayName(ITextComponent.func_241827_a_(TextFormatting.GOLD + "Inconspicuous " + defaultDisplayName));
        }
        tooltip.add(ITextComponent.func_241827_a_(TextFormatting.GRAY +"Bravo 6, going dark" ));
    }
}
