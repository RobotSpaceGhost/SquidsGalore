package com.robotspaceghost.squidsgalore.entities;

import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class DomesticSquidEntity extends ModWaterSquidEntity {
    public DomesticSquidEntity(EntityType<? extends DomesticSquidEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected ItemStack getFishBucket() {
        return new ItemStack(ModItems.BUCKET_OF_SQUID.get());
    }
}
