package com.robotspaceghost.squidsgalore.items.Buckets;

import com.robotspaceghost.squidsgalore.entities.AbstractSquidEntity;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import com.robotspaceghost.squidsgalore.entities.ModWaterSquidEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class SquidBucketItem extends BucketItem {
    private final EntityType<?> squidType;
    private final java.util.function.Supplier<? extends EntityType<?>> squidTypeSupplier;
    public SquidBucketItem(java.util.function.Supplier<? extends EntityType<?>> squidTypeIn, java.util.function.Supplier<? extends Fluid> fluid, Item.Properties builder) {
        super(fluid, builder);
        this.squidType = null;
        this.squidTypeSupplier = squidTypeIn;
    }

    public void onLiquidPlaced(World worldIn, ItemStack p_203792_2_, BlockPos pos) {
        if (!worldIn.isRemote) {
            this.placeSquid(worldIn, p_203792_2_, pos);
        }
    }

    protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
        worldIn.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY_FISH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    }

    private void placeSquid(World worldIn, ItemStack p_205357_2_, BlockPos pos) {
        Entity entity = getSquidType().spawn(worldIn, p_205357_2_, (PlayerEntity)null, pos, SpawnReason.BUCKET, true, false);
        if (entity != null) {
            if (entity instanceof BabyKrakenEntity) ((BabyKrakenEntity)entity).setFromBucket(true);
            else if (entity instanceof AbstractSquidEntity) ((AbstractFishEntity)entity).setFromBucket(true);
        }

    }

    protected EntityType<?> getSquidType() {
        return squidTypeSupplier.get();
    }
    protected Supplier<?> getSquidTypeSupplier(){return squidTypeSupplier;}
}
