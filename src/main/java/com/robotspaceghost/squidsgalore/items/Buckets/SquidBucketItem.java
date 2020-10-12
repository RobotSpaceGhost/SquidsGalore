package com.robotspaceghost.squidsgalore.items.Buckets;

import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.FishBucketItem;

import java.util.function.Supplier;

public class SquidBucketItem extends FishBucketItem {
    public SquidBucketItem(Supplier<? extends EntityType<?>> fishTypeIn, Supplier<? extends Fluid> p_i49022_2_, Properties builder) {
        super(fishTypeIn, p_i49022_2_, builder);
    }
}
