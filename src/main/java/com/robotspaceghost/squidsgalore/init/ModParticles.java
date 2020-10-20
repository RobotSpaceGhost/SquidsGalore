package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SquidsGalore.MOD_ID);

    public static final RegistryObject<BasicParticleType> KRAKEN_PARTICLE = PARTICLES.register("kraken_particle", () -> new BasicParticleType(true));

}
