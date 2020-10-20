package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.blocks.BlockItemBase;
import com.robotspaceghost.squidsgalore.items.*;
import com.robotspaceghost.squidsgalore.items.SquidBucketItem;
import com.robotspaceghost.squidsgalore.items.SquidMilk.KrakenBreathItem;
import com.robotspaceghost.squidsgalore.items.SquidMilk.SquidInkItem;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SquidsGalore.MOD_ID);

    //Spawn Eggs
    public static final RegistryObject<ModSpawnEggItem> BABY_KRAKEN_EGG = ITEMS.register("eggs/baby_kraken_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.BABY_KRAKEN, 0x100F10, 0x9E05AF, new Item.Properties().group(SquidsGalore.TAB)));
    public static final RegistryObject<ModSpawnEggItem> DOMESTIC_SQUID_EGG = ITEMS.register("eggs/domestic_squid_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.DOMESTIC_SQUID, 7375001,2243405,  new Item.Properties().group(SquidsGalore.TAB)));
    //Buckets
    public static final RegistryObject<SquidBucketItem> BUCKET_OF_BABY_KRAKEN = ITEMS.register("buckets/bucket_of_baby_kraken",
            () -> new SquidBucketItem((ModEntityTypes.BABY_KRAKEN), () -> Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(SquidsGalore.TAB)));

    public static final RegistryObject<SquidBucketItem> BUCKET_OF_SQUID = ITEMS.register("buckets/bucket_of_squid",
            () -> new SquidBucketItem((ModEntityTypes.DOMESTIC_SQUID), () -> Fluids.WATER, (new Item.Properties()).maxStackSize(1).group(SquidsGalore.TAB)));

    public static final RegistryObject<Item> BUCKET_OF_SALTY_SQUID = ITEMS.register("buckets/bucket_of_salty_squid",ItemBase::new);

    //Squid Milk Drinkable
    public static final RegistryObject<SquidInkItem> SQUID_INK = ITEMS.register("milk/squid_ink", SquidInkItem::new);
    public static final RegistryObject<SquidInkItem> SQUID_INK_LONG = ITEMS.register("milk/squid_ink_long",
            () -> new SquidInkItem(1));
    public static final RegistryObject<SquidInkItem> SQUID_INK_THICK = ITEMS.register("milk/squid_ink_thick",
            () -> new SquidInkItem(2));

    public static final RegistryObject<KrakenBreathItem> KRAKEN_BREATH = ITEMS.register("milk/kraken_breath", KrakenBreathItem::new);
    public static final RegistryObject<KrakenBreathItem> KRAKEN_BREATH_LONG = ITEMS.register("milk/kraken_breath_long",
            () -> new KrakenBreathItem(1));
    public static final RegistryObject<KrakenBreathItem> KRAKEN_BREATH_THICK = ITEMS.register("milk/kraken_breath_thick",
            () -> new KrakenBreathItem(2));

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

    //GlowSquidSoul OnlyCreative
    public static final RegistryObject<Item> GLOW_SQUID_SOUL_ITEM = ITEMS.register("glow_squid_soul",
            () -> new BlockItemBase(ModBlocks.GLOW_SQUID_SOUL.get()));

    //------------------------------------------
    // base classes
    //---------------------------------------
    public static class ItemBase extends Item {
        public ItemBase(){
            super(new Item.Properties().group(SquidsGalore.TAB));
        }
    }
    public static class RawSquidMeat extends Item {
        public RawSquidMeat() {
            super(new Item.Properties().group(SquidsGalore.TAB).food(new Food.Builder().hunger(3).saturation(1.8f).meat().build()));
        }
    }
    public static class SquidMeat extends Item {
        public SquidMeat() {
            super(new Item.Properties().group(SquidsGalore.TAB).food(new Food.Builder().hunger(8).saturation(12.8f).meat().build()));
        }
    }
}
