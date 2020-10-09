package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.blocks.BlockItemBase;
import com.robotspaceghost.squidsgalore.items.ItemBase;
import com.robotspaceghost.squidsgalore.items.ModSpawnEggItem;
import com.robotspaceghost.squidsgalore.items.RawSquidMeat;
import com.robotspaceghost.squidsgalore.items.SquidMeat;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SquidsGalore.MOD_ID);

    //Spawn Eggs
    public static final RegistryObject<ModSpawnEggItem> BABY_KRAKEN_EGG = ITEMS.register("baby_kraken_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.BABY_KRAKEN, 0x100F10, 0x9E05AF, new Item.Properties().group(SquidsGalore.TAB)));
    //Buckets
    public static final RegistryObject<Item> BUCKET_OF_SQUID = ITEMS.register("bucket_of_squid", ItemBase::new);
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

    //Block Items
    public static final RegistryObject<Item> KRAKEN_GLASS_ITEM = ITEMS.register("kraken_glass",
            () -> new BlockItemBase(ModBlocks.KRAKEN_GLASS.get()));
    public static final RegistryObject<Item> INVERTED_KRAKEN_GLASS_ITEM = ITEMS.register("inverted_kraken_glass",
            () -> new BlockItemBase(ModBlocks.INVERTED_KRAKEN_GLASS.get()));

    //GlowBlock OnlyCreative
    public static final RegistryObject<Item> GLOW_BLOCK_ITEM = ITEMS.register("glow_block",
            () -> new BlockItemBase(ModBlocks.GLOW_BLOCK.get()));

}
