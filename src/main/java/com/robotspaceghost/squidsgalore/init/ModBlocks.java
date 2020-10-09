package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.blocks.InvertedKrakenGlass;
import com.robotspaceghost.squidsgalore.blocks.KrakenGlass;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SquidsGalore.MOD_ID);

    public static final RegistryObject<Block> KRAKEN_GLASS = BLOCKS.register("kraken_glass", KrakenGlass::new);
    public static final RegistryObject<Block> INVERTED_KRAKEN_GLASS = BLOCKS.register("inverted_kraken_glass", InvertedKrakenGlass::new);

}
