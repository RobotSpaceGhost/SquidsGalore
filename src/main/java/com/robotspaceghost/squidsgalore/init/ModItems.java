package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.blocks.BlockItemBase;
import com.robotspaceghost.squidsgalore.items.*;
import com.robotspaceghost.squidsgalore.items.SquidBucketItem;
import com.robotspaceghost.squidsgalore.items.SquidMilk.*;
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

    //Squid Milk
    public static final RegistryObject<SquidInkItem> SQUID_INK = ITEMS.register("milk/squid_ink", SquidInkItem::new);
    public static final RegistryObject<SquidInkItem> SQUID_INK_LONG = ITEMS.register("milk/squid_ink_long",
            () -> new SquidInkItem(1));
    public static final RegistryObject<SquidInkItem> SQUID_INK_THICK = ITEMS.register("milk/squid_ink_thick",
            () -> new SquidInkItem(2));

    public static final RegistryObject<MilkBottleItem> MILK_BOTTLE = ITEMS.register("milk/milk_bottle", MilkBottleItem::new);
    public static final RegistryObject<MilkBottleItem> MILK_BOTTLE_LONG = ITEMS.register("milk/milk_bottle_long",
            () -> new MilkBottleItem(1));
    public static final RegistryObject<MilkBottleItem> MILK_BOTTLE_THICK = ITEMS.register("milk/milk_bottle_thick",
            () -> new MilkBottleItem(2));

    public static final RegistryObject<BeardOilItem> BEARD_OIL = ITEMS.register("milk/beard_oil", BeardOilItem::new);
    public static final RegistryObject<BeardOilItem> BEARD_OIL_LONG = ITEMS.register("milk/beard_oil_long",
            () -> new BeardOilItem(1));
    public static final RegistryObject<BeardOilItem> BEARD_OIL_THICK = ITEMS.register("milk/beard_oil_thick",
            () -> new BeardOilItem(2));

    public static final RegistryObject<SquidAirItem> SQUID_AIR = ITEMS.register("milk/squid_air", SquidAirItem::new);
    public static final RegistryObject<SquidAirItem> SQUID_AIR_LONG = ITEMS.register("milk/squid_air_long",
            () -> new SquidAirItem(1));
    public static final RegistryObject<SquidAirItem> SQUID_AIR_THICK = ITEMS.register("milk/squid_air_thick",
            () -> new SquidAirItem(2));

    public static final RegistryObject<BaconGreaseItem> BACON_GREASE = ITEMS.register("milk/bacon_grease", BaconGreaseItem::new);
    public static final RegistryObject<BaconGreaseItem> BACON_GREASE_LONG = ITEMS.register("milk/bacon_grease_long",
            () -> new BaconGreaseItem(1));
    public static final RegistryObject<BaconGreaseItem> BACON_GREASE_THICK = ITEMS.register("milk/bacon_grease_thick",
            () -> new BaconGreaseItem(2));

    public static final RegistryObject<DilutedHoneyItem> DILUTED_HONEY = ITEMS.register("milk/diluted_honey", DilutedHoneyItem::new);
    public static final RegistryObject<DilutedHoneyItem> DILUTED_HONEY_LONG = ITEMS.register("milk/diluted_honey_long",
            () -> new DilutedHoneyItem(1));
    public static final RegistryObject<DilutedHoneyItem> DILUTED_HONEY_THICK = ITEMS.register("milk/diluted_honey_thick",
            () -> new DilutedHoneyItem(2));

    public static final RegistryObject<PerfumeItem> PERFUME = ITEMS.register("milk/perfume", PerfumeItem::new);
    public static final RegistryObject<PerfumeItem> PERFUME_LONG = ITEMS.register("milk/perfume_long",
            () -> new PerfumeItem(1));
    public static final RegistryObject<PerfumeItem> PERFUME_THICK = ITEMS.register("milk/perfume_thick",
            () -> new PerfumeItem(2));

    public static final RegistryObject<GlueItem> GLUE = ITEMS.register("milk/glue", GlueItem::new);
    public static final RegistryObject<GlueItem> GLUE_LONG = ITEMS.register("milk/glue_long",
            () -> new GlueItem(1));
    public static final RegistryObject<GlueItem> GLUE_THICK = ITEMS.register("milk/glue_thick",
            () -> new GlueItem(2));

    public static final RegistryObject<MutagenItem> MUTAGEN = ITEMS.register("milk/mutagen", MutagenItem::new);
    public static final RegistryObject<MutagenItem> MUTAGEN_LONG = ITEMS.register("milk/mutagen_long",
            () -> new MutagenItem(1));
    public static final RegistryObject<MutagenItem> MUTAGEN_THICK = ITEMS.register("milk/mutagen_thick",
            () -> new MutagenItem(2));

    public static final RegistryObject<BoneHurtingJuiceItem> BONE_HURTING_JUICE = ITEMS.register("milk/bone_hurting_juice", BoneHurtingJuiceItem::new);
    public static final RegistryObject<BoneHurtingJuiceItem> BONE_HURTING_JUICE_LONG = ITEMS.register("milk/bone_hurting_juice_long",
            () -> new BoneHurtingJuiceItem(1));
    public static final RegistryObject<BoneHurtingJuiceItem> BONE_HURTING_JUICE_THICK = ITEMS.register("milk/bone_hurting_juice_thick",
            () -> new BoneHurtingJuiceItem(2));

    public static final RegistryObject<InstabilityItem> INSTABILITY = ITEMS.register("milk/instability", InstabilityItem::new);
    public static final RegistryObject<InstabilityItem> INSTABILITY_LONG = ITEMS.register("milk/instability_long",
            () -> new InstabilityItem(1));
    public static final RegistryObject<InstabilityItem> INSTABILITY_THICK = ITEMS.register("milk/instability_thick",
            () -> new InstabilityItem(2));

    public static final RegistryObject<NitroItem> NITRO = ITEMS.register("milk/nitro", NitroItem::new);
    public static final RegistryObject<NitroItem> NITRO_LONG = ITEMS.register("milk/nitro_long",
            () -> new NitroItem(1));
    public static final RegistryObject<NitroItem> NITRO_THICK = ITEMS.register("milk/nitro_thick",
            () -> new NitroItem(2));

    public static final RegistryObject<LiquidDoomItem> LIQUID_DOOM = ITEMS.register("milk/liquid_doom", LiquidDoomItem::new);
    public static final RegistryObject<LiquidDoomItem> LIQUID_DOOM_LONG = ITEMS.register("milk/liquid_doom_long",
            () -> new LiquidDoomItem(1));
    public static final RegistryObject<LiquidDoomItem> LIQUID_DOOM_THICK = ITEMS.register("milk/liquid_doom_thick",
            () -> new LiquidDoomItem(2));

    public static final RegistryObject<FloweringItem> FLOWERING = ITEMS.register("milk/flowering", FloweringItem::new);
    public static final RegistryObject<FloweringItem> FLOWERING_LONG = ITEMS.register("milk/flowering_long",
            () -> new FloweringItem(1));
    public static final RegistryObject<FloweringItem> FLOWERING_THICK = ITEMS.register("milk/flowering_thick",
            () -> new FloweringItem(2));

    public static final RegistryObject<DMTItem> DMT = ITEMS.register("milk/dmt", DMTItem::new);
    public static final RegistryObject<DMTItem> DMT_LONG = ITEMS.register("milk/dmt_long",
            () -> new DMTItem(1));
    public static final RegistryObject<DMTItem> DMT_THICK = ITEMS.register("milk/dmt_thick",
            () -> new DMTItem(2));

    public static final RegistryObject<NotavibeItem> NOTAVIBE = ITEMS.register("milk/notavibe", NotavibeItem::new);
    public static final RegistryObject<NotavibeItem> NOTAVIBE_LONG = ITEMS.register("milk/notavibe_long",
            () -> new NotavibeItem(1));
    public static final RegistryObject<NotavibeItem> NOTAVIBE_THICK = ITEMS.register("milk/notavibe_thick",
            () -> new NotavibeItem(2));

    public static final RegistryObject<ChlorophyllItem> CHLOROPHYLL = ITEMS.register("milk/chlorophyll", ChlorophyllItem::new);
    public static final RegistryObject<ChlorophyllItem> CHLOROPHYLL_LONG = ITEMS.register("milk/chlorophyll_long",
            () -> new ChlorophyllItem(1));
    public static final RegistryObject<ChlorophyllItem> CHLOROPHYLL_THICK = ITEMS.register("milk/chlorophyll_thick",
            () -> new ChlorophyllItem(2));

    public static final RegistryObject<HotSauceItem> HOT_SAUCE = ITEMS.register("milk/hot_sauce", HotSauceItem::new);
    public static final RegistryObject<HotSauceItem> HOT_SAUCE_LONG = ITEMS.register("milk/hot_sauce_long",
            () -> new HotSauceItem(1));
    public static final RegistryObject<HotSauceItem> HOT_SAUCE_THICK = ITEMS.register("milk/hot_sauce_thick",
            () -> new HotSauceItem(2));

    public static final RegistryObject<CoffeeItem> COFFEE = ITEMS.register("milk/coffee", CoffeeItem::new);
    public static final RegistryObject<CoffeeItem> COFFEE_LONG = ITEMS.register("milk/coffee_long",
            () -> new CoffeeItem(1));
    public static final RegistryObject<CoffeeItem> COFFEE_THICK = ITEMS.register("milk/coffee_thick",
            () -> new CoffeeItem(2));

    public static final RegistryObject<SlushyItem> SLUSHY = ITEMS.register("milk/slushy", SlushyItem::new);
    public static final RegistryObject<SlushyItem> SLUSHY_LONG = ITEMS.register("milk/slushy_long",
            () -> new SlushyItem(1));
    public static final RegistryObject<SlushyItem> SLUSHY_THICK = ITEMS.register("milk/slushy_thick",
            () -> new SlushyItem(2));

    public static final RegistryObject<RedstoneBottleItem> REDSTONE_BOTTLE = ITEMS.register("milk/redstone_bottle", RedstoneBottleItem::new);
    public static final RegistryObject<RedstoneBottleItem> REDSTONE_BOTTLE_LONG = ITEMS.register("milk/redstone_bottle_long",
            () -> new RedstoneBottleItem(1));
    public static final RegistryObject<RedstoneBottleItem> REDSTONE_BOTTLE_THICK = ITEMS.register("milk/redstone_bottle_thick",
            () -> new RedstoneBottleItem(2));

    public static final RegistryObject<GlowstoneBottleItem> GLOWSTONE_BOTTLE = ITEMS.register("milk/glowstone_bottle", GlowstoneBottleItem::new);
    public static final RegistryObject<GlowstoneBottleItem> GLOWSTONE_BOTTLE_LONG = ITEMS.register("milk/glowstone_bottle_long",
            () -> new GlowstoneBottleItem(1));
    public static final RegistryObject<GlowstoneBottleItem> GLOWSTONE_BOTTLE_THICK = ITEMS.register("milk/glowstone_bottle_thick",
            () -> new GlowstoneBottleItem(2));

    public static final RegistryObject<InvisibleInkItem> INVISIBLE_INK = ITEMS.register("milk/invisible_ink", InvisibleInkItem::new);
    public static final RegistryObject<InvisibleInkItem> INVISIBLE_INK_LONG = ITEMS.register("milk/invisible_ink_long",
            () -> new InvisibleInkItem(1));
    public static final RegistryObject<InvisibleInkItem> INVISIBLE_INK_THICK = ITEMS.register("milk/invisible_ink_thick",
            () -> new InvisibleInkItem(2));

    public static final RegistryObject<PetrichorItem> PETRICHOR = ITEMS.register("milk/petrichor", PetrichorItem::new);
    public static final RegistryObject<PetrichorItem> PETRICHOR_LONG = ITEMS.register("milk/petrichor_long",
            () -> new PetrichorItem(1));
    public static final RegistryObject<PetrichorItem> PETRICHOR_THICK = ITEMS.register("milk/petrichor_thick",
            () -> new PetrichorItem(2));

    public static final RegistryObject<ActivatedCharcoalItem> ACTIVATED_CHARCOAL = ITEMS.register("milk/activated_charcoal", ActivatedCharcoalItem::new);
    public static final RegistryObject<ActivatedCharcoalItem> ACTIVATED_CHARCOAL_LONG = ITEMS.register("milk/activated_charcoal_long",
            () -> new ActivatedCharcoalItem(1));
    public static final RegistryObject<ActivatedCharcoalItem> ACTIVATED_CHARCOAL_THICK = ITEMS.register("milk/activated_charcoal_thick",
            () -> new ActivatedCharcoalItem(2));

    public static final RegistryObject<MinersDelightItem> MINERS_DELIGHT = ITEMS.register("milk/miners_delight", MinersDelightItem::new);
    public static final RegistryObject<MinersDelightItem> MINERS_DELIGHT_LONG = ITEMS.register("milk/miners_delight_long",
            () -> new MinersDelightItem(1));
    public static final RegistryObject<MinersDelightItem> MINERS_DELIGHT_THICK = ITEMS.register("milk/miners_delight_thick",
            () -> new MinersDelightItem(2));

    public static final RegistryObject<CrystalGemItem> CRYSTAL_GEM = ITEMS.register("milk/crystal_gem", CrystalGemItem::new);
    public static final RegistryObject<CrystalGemItem> CRYSTAL_GEM_LONG = ITEMS.register("milk/crystal_gem_long",
            () -> new CrystalGemItem(1));
    public static final RegistryObject<CrystalGemItem> CRYSTAL_GEM_THICK = ITEMS.register("milk/crystal_gem_thick",
            () -> new CrystalGemItem(2));

    public static final RegistryObject<SaltItem> SALT = ITEMS.register("milk/salt", SaltItem::new);
    public static final RegistryObject<SaltItem> SALT_LONG = ITEMS.register("milk/salt_long",
            () -> new SaltItem(1));
    public static final RegistryObject<SaltItem> SALT_THICK = ITEMS.register("milk/salt_thick",
            () -> new SaltItem(2));

    public static final RegistryObject<XPBoostItem> XP_BOOST = ITEMS.register("milk/xp_boost", XPBoostItem::new);
    public static final RegistryObject<XPBoostItem> XP_BOOST_LONG = ITEMS.register("milk/xp_boost_long",
            () -> new XPBoostItem(1));
    public static final RegistryObject<XPBoostItem> XP_BOOST_THICK = ITEMS.register("milk/xp_boost_thick",
            () -> new XPBoostItem(2));

    public static final RegistryObject<HourglassItem> HOURGLASS = ITEMS.register("milk/hourglass", HourglassItem::new);
    public static final RegistryObject<HourglassItem> HOURGLASS_LONG = ITEMS.register("milk/hourglass_long",
            () -> new HourglassItem(1));
    public static final RegistryObject<HourglassItem> HOURGLASS_THICK = ITEMS.register("milk/hourglass_thick",
            () -> new HourglassItem(2));

    public static final RegistryObject<KrakenBreathItem> KRAKEN_BREATH = ITEMS.register("milk/kraken_breath", KrakenBreathItem::new);
    public static final RegistryObject<KrakenBreathItem> KRAKEN_BREATH_LONG = ITEMS.register("milk/kraken_breath_long",
            () -> new KrakenBreathItem(1));
    public static final RegistryObject<KrakenBreathItem> KRAKEN_BREATH_THICK = ITEMS.register("milk/kraken_breath_thick",
            () -> new KrakenBreathItem(2));
    public static final RegistryObject<KrakenBreathItem> KRAKEN_BREATH_CORRUPTED = ITEMS.register("milk/kraken_breath_thick_corrupted",
            () -> new KrakenBreathItem(3));

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
