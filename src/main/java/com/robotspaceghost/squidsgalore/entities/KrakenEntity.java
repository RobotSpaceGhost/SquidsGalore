package com.robotspaceghost.squidsgalore.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.world.World;

public class KrakenEntity extends MobEntity implements IMob {
    public KrakenEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    //func_233815_a_ -> create()
    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.registerAttributes()
                .func_233815_a_(Attributes.MAX_HEALTH, 5.0D)
                .func_233815_a_(Attributes.MOVEMENT_SPEED, 0.25D)
                .func_233815_a_(Attributes.FOLLOW_RANGE, 10.0F);
    }
}
