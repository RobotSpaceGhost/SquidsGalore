package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.entities.DomesticSquidEntity;
import com.robotspaceghost.squidsgalore.items.ModSpawnEggItem;
import com.robotspaceghost.squidsgalore.particles.KrakenParticle;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SquidsGalore.MOD_ID);

    public static final RegistryObject<BasicParticleType> KRAKEN_PARTICLE = PARTICLES.register("kraken_particle", () -> new BasicParticleType(true));

}
