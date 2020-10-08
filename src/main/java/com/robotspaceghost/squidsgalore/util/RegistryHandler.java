package com.robotspaceghost.squidsgalore.util;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.blocks.BlockItemBase;
import com.robotspaceghost.squidsgalore.blocks.KrakenGlass;
import com.robotspaceghost.squidsgalore.blocks.InvertedKrakenGlass;
import com.robotspaceghost.squidsgalore.items.ItemBase;
import com.robotspaceghost.squidsgalore.items.RawSquidMeat;
import com.robotspaceghost.squidsgalore.items.SquidMeat;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SquidsGalore.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SquidsGalore.MOD_ID);

    public static void init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //Buckets
    public static final RegistryObject<Item> BUCKET_OF_SQUID = ITEMS.register("bucket_of_squid",ItemBase::new);
    public static final RegistryObject<Item> BUCKET_OF_SALTY_SQUID = ITEMS.register("bucket_of_salty_squid",ItemBase::new);

    //Squid Milk

    //Food
    public static final RegistryObject<RawSquidMeat> RAW_SQUID_BEEF = ITEMS.register("raw_squid_beef", RawSquidMeat::new);
    public static final RegistryObject<SquidMeat> SQUID_BEEF = ITEMS.register("squid_beef", SquidMeat::new);
    public static final RegistryObject<RawSquidMeat> RAW_SQUIDCHOP = ITEMS.register("raw_squidchop",RawSquidMeat::new);
    public static final RegistryObject<SquidMeat> SQUIDCHOP = ITEMS.register("squidchop",SquidMeat::new);

    //Wand
    public static final RegistryObject<Item> INK_ON_A_STICK = ITEMS.register("ink_on_a_stick",ItemBase::new);

    //Book
    public static final RegistryObject<Item> SQUIDICTIONARY = ITEMS.register("squidictionary",ItemBase::new);

    //Blocks
    public static final RegistryObject<Block> KRAKEN_GLASS = BLOCKS.register("kraken_glass", KrakenGlass::new);
    public static final RegistryObject<Block> INVERTED_KRAKEN_GLASS = BLOCKS.register("inverted_kraken_glass", InvertedKrakenGlass::new);

    //Block Items
    public static final RegistryObject<Item> KRAKEN_GLASS_ITEM = ITEMS.register("kraken_glass", () -> new BlockItemBase(KRAKEN_GLASS.get()));
    public static final RegistryObject<Item> INVERTED_KRAKEN_GLASS_ITEM = ITEMS.register("inverted_kraken_glass", () -> new BlockItemBase(INVERTED_KRAKEN_GLASS.get()));



}
