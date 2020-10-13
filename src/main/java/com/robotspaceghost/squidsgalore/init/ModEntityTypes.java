package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import com.robotspaceghost.squidsgalore.entities.DomesticSquidEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SquidsGalore.MOD_ID);

    //Entity Types
    public static final RegistryObject<EntityType<BabyKrakenEntity>> BABY_KRAKEN = ENTITY_TYPES.register("baby_kraken",
            () -> EntityType.Builder.create(BabyKrakenEntity::new,  EntityClassification.CREATURE)
                    .size(1.0f, 0.75f)
                    .build(new ResourceLocation(SquidsGalore.MOD_ID, "baby_kraken").toString()));
    public static final RegistryObject<EntityType<DomesticSquidEntity>> DOMESTIC_SQUID = ENTITY_TYPES.register("domestic_squid",
            () -> EntityType.Builder.create(DomesticSquidEntity::new,  EntityClassification.CREATURE)
                    .size(1.0f, 0.75f)
                    .build(new ResourceLocation(SquidsGalore.MOD_ID, "domestic_squid").toString()));
}
