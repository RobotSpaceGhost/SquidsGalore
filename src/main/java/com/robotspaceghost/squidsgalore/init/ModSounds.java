package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;

import net.minecraft.util.ResourceLocation;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SquidsGalore.MOD_ID);

    public static final RegistryObject<SoundEvent> TELEPORT_INIT = SOUNDS.register("teleport_init",
            () -> new SoundEvent(new ResourceLocation(SquidsGalore.MOD_ID, "teleport_init")));

    public static final RegistryObject<SoundEvent> TELEPORT_INIT_QUICK = SOUNDS.register("teleport_init_quick",
            () -> new SoundEvent(new ResourceLocation(SquidsGalore.MOD_ID, "teleport_init_quick")));

    public static final RegistryObject<SoundEvent> TELEPORT_INIT_THICK = SOUNDS.register("teleport_init_thick",
            () -> new SoundEvent(new ResourceLocation(SquidsGalore.MOD_ID, "teleport_init_thick")));

    public static final RegistryObject<SoundEvent> TELEPORT_ARRIVAL = SOUNDS.register("teleport_arrival",
            () -> new SoundEvent(new ResourceLocation(SquidsGalore.MOD_ID, "teleport_arrival")));

    public static final RegistryObject<SoundEvent> BEARD_EQUIP = SOUNDS.register("beard_equip",
            () -> new SoundEvent(new ResourceLocation(SquidsGalore.MOD_ID, "beard_equip")));
}
