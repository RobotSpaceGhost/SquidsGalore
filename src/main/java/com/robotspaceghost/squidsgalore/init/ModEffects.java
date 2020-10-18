package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> EFFECTS = DeferredRegister.create(ForgeRegistries.POTIONS, SquidsGalore.MOD_ID);
}
