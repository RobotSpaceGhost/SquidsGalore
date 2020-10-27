package com.robotspaceghost.squidsgalore.items.SquidMilk;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.init.ModEffects;
import com.robotspaceghost.squidsgalore.init.ModParticles;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class KrakenBreathItem extends AbstractMilkItem {
    public final Effect MILK_EFFECT = ModEffects.KRAKEN_BREATH_EFFECT;
    public final int MILK_EFFECT_DURATION = 5 * 60 * 20;
    public final int MILK_EFFECT_LEVEL = 0;
    public final boolean isLong;
    public final boolean isThick;
    public final boolean isCorrupted;


    public KrakenBreathItem(int variant){
        super(new Item.Properties().maxStackSize(1));
        this.isLong = variant == 1;
        this.isThick = variant == 2;
        this.isCorrupted = variant == 3;
    }
    public KrakenBreathItem(){
        super(new Item.Properties().group(SquidsGalore.TAB).maxStackSize(1));
        this.isLong = false;
        this.isThick = false;
        this.isCorrupted = false;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return this.isLong||this.isThick;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote) {

            if (isCorrupted && entityLiving instanceof PlayerEntity && !entityLiving.world.getGameRules().getBoolean(GameRules.DISABLE_RAIDS)) {
                int corruptAmp = (!entityLiving.isPotionActive(ModEffects.OMEN_OF_THE_SEAS_EFFECT)) ? 0 : Objects.requireNonNull(entityLiving.getActivePotionEffect(ModEffects.OMEN_OF_THE_SEAS_EFFECT)).getAmplifier() + 1;
                entityLiving.addPotionEffect(new EffectInstance(ModEffects.OMEN_OF_THE_SEAS_EFFECT, 60 * 60 * 20 + 40 * 60 * 20, corruptAmp));
            } else {
                entityLiving.addPotionEffect(new EffectInstance(
                        this.MILK_EFFECT,
                        ((this.isLong) ? this.MILK_EFFECT_DURATION * 2 : this.MILK_EFFECT_DURATION),
                        ((this.isThick) ? this.MILK_EFFECT_LEVEL + 1 : this.MILK_EFFECT_LEVEL)
                ));
            }
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
        else if (this.isThick && !defaultDisplayName.contains("Thickened")) {
            stack.setDisplayName(ITextComponent.func_241827_a_(TextFormatting.GOLD + "Thickened " + defaultDisplayName));
        }
        else if (this.isCorrupted && !defaultDisplayName.contains("Corrupted")) {
            stack.setDisplayName(ITextComponent.func_241827_a_(TextFormatting.DARK_PURPLE + "Corrupted " + defaultDisplayName));
        }
        tooltip.add(ITextComponent.func_241827_a_(TextFormatting.GRAY + "Smells like salty mint" ));
    }
}
