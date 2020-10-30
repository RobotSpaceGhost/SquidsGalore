package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.entities.AbstractSquidEntity;

import com.robotspaceghost.squidsgalore.util.BounceHandler;

import com.robotspaceghost.squidsgalore.util.GravityHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ThrowableEntity;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.*;

import net.minecraft.util.*;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

import net.minecraft.util.text.ITextComponent;

import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;

import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraftforge.fml.common.Mod;


import java.util.*;



public class ModEffects {
    public static Effect SQUID_INK_EFFECT =  new EffectBase(EffectType.HARMFUL, 0x0A0219).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "squid_ink_effect"));
    public static Effect MILK_BOTTLE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "milk_bottle_effect"));
    public static Effect BEARD_OIL_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x262626).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "beard_oil_effect"));
    public static Effect SQUID_AIR_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "squid_air_effect"));
    public static Effect BACON_GREASE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xEFE8CC).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "bacon_grease_effect"));
    public static Effect DILUTED_HONEY_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xD79800).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "diluted_honey_effect"));
    public static Effect PERFUME_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x77FFA4).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "perfume_effect"));
    public static Effect SLIME_BOTTLE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x8CD782).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "slime_bottle_effect"));
    public static Effect GRAVITY_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x000000).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "gravity_effect"));
    public static Effect GLUE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "glue_effect"));
    public static Effect MUTAGEN_EFFECT = new EffectBase(EffectType.HARMFUL, 0x005B08).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "mutagen_effect"));
    public static Effect BONE_HURTING_JUICE_EFFECT = new EffectBase(EffectType.HARMFUL, 0xE0761F).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "bone_hurting_juice_effect"));
    public static Effect INSTABILITY_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x72056F).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "instability_effect"));
    public static Effect NITRO_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x5F0000).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "nitro_effect"));
    public static Effect LIQUID_DOOM_EFFECT = new EffectBase(EffectType.HARMFUL, 0x000000).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "liquid_doom_effect"));
    public static Effect FLOWERING_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x3AA0FF).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "flowering_effect"));
    public static Effect DMT_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "dmt_effect"));
    public static Effect NOTAVIBE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xCF044B).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "notavibe_effect"));
    public static Effect CHLOROPHYLL_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x18CD14).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "chlorophyll_effect"));
    public static Effect HOT_SAUCE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xE63600).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "hot_sauce_effect"));
    public static Effect COFFEE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x490000).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "coffee_effect"));
    public static Effect SLUSHY_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x30CCB7).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "slushy_effect"));
    public static Effect REDSTONE_BOTTLE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x770000).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "redstone_bottle_effect"));
    public static Effect GLOWSTONE_BOTTLE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xC88B00).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "glowstone_bottle_effect"));
    public static Effect INVISIBLE_INK_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x000000).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "invisible_ink_effect"));
    public static Effect PETRICHOR_EFFECT = new EffectBase(EffectType.HARMFUL, 0x636363).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "petrichor_effect"));
    public static Effect ACTIVATED_CHARCOAL_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x181818).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "activated_charcoal_effect"));
    public static Effect MINERS_DELIGHT_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFD800).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "miners_delight_effect"));
    public static Effect CRYSTAL_GEM_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xE968D7).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "crystal_gem_effect"));
    public static Effect SALT_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "salt_effect"));
    public static Effect XP_BOOST_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xB1FB23).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "xp_boost_effect"));
    public static Effect HOURGLASS_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xE5BB77).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "hourglass_effect"));
    public static Effect KRAKEN_BREATH_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xCC49F3).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "kraken_breath_effect"));
    public static Effect OMEN_OF_THE_SEAS_EFFECT = new EffectBase(EffectType.HARMFUL, 0xCC49F3).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "omen_of_the_seas_effect"));

    public static class EffectBase extends Effect{
        public EffectBase(EffectType typeIn, int liquidColorIn) {
            super(typeIn, liquidColorIn);
        }
    }

    @Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class effectRegistryClass {
        @SubscribeEvent
        public static void registerEffects(final RegistryEvent.Register<Effect> event) {
            event.getRegistry().registerAll(
                    ModEffects.SQUID_INK_EFFECT,
                    ModEffects.MILK_BOTTLE_EFFECT,
                    ModEffects.BEARD_OIL_EFFECT,
                    ModEffects.SQUID_AIR_EFFECT,
                    ModEffects.BACON_GREASE_EFFECT,
                    ModEffects.DILUTED_HONEY_EFFECT,
                    ModEffects.PERFUME_EFFECT,
                    ModEffects.SLIME_BOTTLE_EFFECT,
                    ModEffects.GLUE_EFFECT,
                    ModEffects.GRAVITY_EFFECT,
                    ModEffects.MUTAGEN_EFFECT,
                    ModEffects.BONE_HURTING_JUICE_EFFECT,
                    ModEffects.INSTABILITY_EFFECT,
                    ModEffects.NITRO_EFFECT,
                    ModEffects.LIQUID_DOOM_EFFECT,
                    ModEffects.FLOWERING_EFFECT,
                    ModEffects.DMT_EFFECT,
                    ModEffects.NOTAVIBE_EFFECT,
                    ModEffects.CHLOROPHYLL_EFFECT,
                    ModEffects.HOT_SAUCE_EFFECT,
                    ModEffects.COFFEE_EFFECT,
                    ModEffects.SLUSHY_EFFECT,
                    ModEffects.REDSTONE_BOTTLE_EFFECT,
                    ModEffects.GLOWSTONE_BOTTLE_EFFECT,
                    ModEffects.INVISIBLE_INK_EFFECT,
                    ModEffects.PETRICHOR_EFFECT,
                    ModEffects.ACTIVATED_CHARCOAL_EFFECT,
                    ModEffects.MINERS_DELIGHT_EFFECT,
                    ModEffects.CRYSTAL_GEM_EFFECT,
                    ModEffects.SALT_EFFECT,
                    ModEffects.XP_BOOST_EFFECT,
                    ModEffects.HOURGLASS_EFFECT,
                    ModEffects.KRAKEN_BREATH_EFFECT,
                    ModEffects.OMEN_OF_THE_SEAS_EFFECT
            );
        }
    }

    @Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE,  value = Dist.CLIENT)
    public static class ModEffectEvents {
        @SubscribeEvent
        public static void onPotionAdded(PotionEvent.PotionAddedEvent event) {
            LivingEntity targetEntity = event.getEntityLiving();
            EffectInstance potionEffect = event.getPotionEffect();
            World worldIn = event.getEntity().world;
            int effectDuration = potionEffect.getDuration();
            if (!worldIn.isRemote) {
                if (potionEffect.getPotion() == ModEffects.SQUID_INK_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, potionEffect.getDuration(), potionEffect.getAmplifier()));
                }//done!!
                if (potionEffect.getPotion() == ModEffects.MILK_BOTTLE_EFFECT) {
                    Collection<EffectInstance> activeEffects = targetEntity.getActivePotionEffects();
                    List<Effect> removableEffects = new ArrayList<>();
                    for (EffectInstance effect : activeEffects)
                        if (effect.getPotion() != ModEffects.MILK_BOTTLE_EFFECT && effect.getPotion() != ModEffects.GLUE_EFFECT) removableEffects.add(effect.getPotion());
                    for (Effect removableEffect : removableEffects)
                        if (targetEntity.isPotionActive(removableEffect)) targetEntity.removePotionEffect(removableEffect);
                    if (targetEntity.isPotionActive(ModEffects.GLUE_EFFECT)){
                        if (Objects.requireNonNull(targetEntity.getActivePotionEffect(ModEffects.GLUE_EFFECT)).getAmplifier() > 0){
                            targetEntity.addPotionEffect(new EffectInstance(ModEffects.GRAVITY_EFFECT, 5 * 20, 0, false, false, true));
                        }
                        targetEntity.removePotionEffect(ModEffects.GLUE_EFFECT);
                    }
                    targetEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, potionEffect.getDuration(), potionEffect.getAmplifier()));
                }//done!!
                if (potionEffect.getPotion() == ModEffects.BEARD_OIL_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, potionEffect.getDuration(), potionEffect.getAmplifier() + 1));
                }//done!!!
                if (potionEffect.getPotion() == ModEffects.SQUID_AIR_EFFECT) {
                    int defaultDuration = ModItems.SQUID_AIR.get().MILK_EFFECT_DURATION;
                    if (effectDuration != defaultDuration && effectDuration != defaultDuration * 2) {
                        targetEntity.addPotionEffect(new EffectInstance(Effects.LEVITATION, Math.min(potionEffect.getDuration(), 10 * 20), 1));
                    } else {
                        targetEntity.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, potionEffect.getDuration(), potionEffect.getAmplifier()));
                        targetEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, potionEffect.getDuration(), potionEffect.getAmplifier()));
                        targetEntity.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 10, potionEffect.getAmplifier()));
                        targetEntity.setAir(targetEntity.getMaxAir());
                    }
                }//done!!!
                if (potionEffect.getPotion() == ModEffects.BACON_GREASE_EFFECT) {
                    int defaultDuration = ModItems.BACON_GREASE.get().MILK_EFFECT_DURATION;
                    if (effectDuration == defaultDuration || effectDuration == defaultDuration * 2) {
                        targetEntity.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, potionEffect.getDuration(), potionEffect.getAmplifier()));
                        targetEntity.addPotionEffect(new EffectInstance(Effects.SATURATION, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    }
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                } //ongoing todo
                if (potionEffect.getPotion() == ModEffects.DILUTED_HONEY_EFFECT) {
                    int defaultDuration = ModItems.DILUTED_HONEY.get().MILK_EFFECT_DURATION;
                    if (effectDuration != defaultDuration && effectDuration != defaultDuration * 2) {
                        targetEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    }
                    targetEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    if (targetEntity.isPotionActive(Effects.POISON)) targetEntity.removePotionEffect(Effects.POISON);
                } //needs testing
                if (potionEffect.getPotion() == ModEffects.PERFUME_EFFECT) {
                    //targetEntity.addPotionEffect(new EffectInstance(Effects.DUMMY, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//complex villager stuff todo later
                if (potionEffect.getPotion() == ModEffects.GLUE_EFFECT) {
                    int defaultDuration = ModItems.GLUE.get().MILK_EFFECT_DURATION;
                    if (effectDuration != defaultDuration && effectDuration != defaultDuration * 2) {
                        targetEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, potionEffect.getDuration(), potionEffect.getAmplifier() + 4));
                    } else
                        targetEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, potionEffect.getDuration(), 0));
                    if (potionEffect.getAmplifier() > 0) GravityHandler.addGravityHandler(targetEntity);
                }//done?
                if (potionEffect.getPotion() == ModEffects.MUTAGEN_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.WEAKNESS, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    targetEntity.addPotionEffect(new EffectInstance(Effects.HUNGER, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    if (!(targetEntity instanceof AbstractSquidEntity || targetEntity instanceof SquidEntity || targetEntity instanceof VillagerEntity)){
                        targetEntity.addPotionEffect(new EffectInstance(Effects.POISON, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    }
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                } //complex conversion ritual, todo later
                if (potionEffect.getPotion() == ModEffects.BONE_HURTING_JUICE_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.WEAKNESS, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    targetEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, potionEffect.getAmplifier()));
                } //needs testing
                if (potionEffect.getPotion() == ModEffects.INSTABILITY_EFFECT) {
                    int defaultDuration = ModItems.INSTABILITY.get().MILK_EFFECT_DURATION;
                    if (effectDuration != defaultDuration && effectDuration != defaultDuration / 2) {
                        potionEffect.setPotionDurationMax(true);
                        double d0 = targetEntity.getPosX();
                        double d1 = targetEntity.getPosY();
                        double d2 = targetEntity.getPosZ();
                        for(int i = 0; i < 16; ++i) {
                            double d3 = targetEntity.getPosX() + (targetEntity.getRNG().nextDouble() - 0.5D) * 16.0D;
                            double d4 = MathHelper.clamp(targetEntity.getPosY() + (double)(targetEntity.getRNG().nextInt(16) - 8), 0.0D, (worldIn.func_234938_ad_() - 1));
                            double d5 = targetEntity.getPosZ() + (targetEntity.getRNG().nextDouble() - 0.5D) * 16.0D;
                            if (targetEntity.isPassenger()) {
                                targetEntity.stopRiding();
                            }
                            if (targetEntity.attemptTeleport(d3, d4, d5, true)) {
                                SoundEvent soundevent = targetEntity instanceof FoxEntity ? SoundEvents.ENTITY_FOX_TELEPORT : SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT;
                                worldIn.playSound(null, d0, d1, d2, soundevent, SoundCategory.PLAYERS, 1.0F, 1.0F);
                                targetEntity.playSound(soundevent, 1.0F, 1.0F);
                                break;
                            }
                        }
                    }
                    else {
                        if (potionEffect.getAmplifier() == 0) targetEntity.addPotionEffect(new EffectInstance(Effects.NAUSEA, potionEffect.getDuration() + (3 * 20), potionEffect.getAmplifier()));
                        SoundEvent teleportSound = (effectDuration == defaultDuration/2) ? ModSounds.TELEPORT_INIT_QUICK.get()
                                : (potionEffect.getAmplifier() == 0) ? ModSounds.TELEPORT_INIT.get() : ModSounds.TELEPORT_INIT_THICK.get();
                        worldIn.playSound(null, targetEntity.getPosX(), targetEntity.getPosY(), targetEntity.getPosZ(), teleportSound, SoundCategory.PLAYERS, 1.0F, 1.0F);
                        targetEntity.playSound(teleportSound, 1.0F, 1.0F);
                    }
                }//done!
                if (potionEffect.getPotion() == ModEffects.NITRO_EFFECT) {
                    //targetEntity.addPotionEffect(new EffectInstance(Effects.DUMMY, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//drink only stuff, explosion portion done todo
                if (potionEffect.getPotion() == ModEffects.LIQUID_DOOM_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.WITHER, potionEffect.getDuration(), potionEffect.getAmplifier()));
                }//needs testing
                if (potionEffect.getPotion() == ModEffects.FLOWERING_EFFECT) {
                    //targetEntity.addPotionEffect(new EffectInstance(Effects.DUMMY, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//complex, todo
                if (potionEffect.getPotion() == ModEffects.DMT_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.NAUSEA, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    targetEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 1, potionEffect.getAmplifier()));
                    targetEntity.addPotionEffect(new EffectInstance(Effects.HUNGER, potionEffect.getDuration(), potionEffect.getAmplifier()));
                }//complex conversion stuff, todo
                if (potionEffect.getPotion() == ModEffects.NOTAVIBE_EFFECT) {
                    if (potionEffect.getAmplifier() == 0) targetEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, 0));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//repelling stuff, todo
                if (potionEffect.getPotion() == ModEffects.CHLOROPHYLL_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.LUCK, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//bonemeal area splash todo
                if (potionEffect.getPotion() == ModEffects.HOT_SAUCE_EFFECT) {
                    int defaultDuration = ModItems.HOT_SAUCE.get().MILK_EFFECT_DURATION;
                    if (effectDuration != defaultDuration && effectDuration != defaultDuration * 2) {
                        targetEntity.setFire(Math.min(potionEffect.getDuration(), 10 * 20));
                    } else targetEntity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, potionEffect.getDuration(), potionEffect.getAmplifier()));
                }//needs testing
                if (potionEffect.getPotion() == ModEffects.COFFEE_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.SPEED, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    targetEntity.addPotionEffect(new EffectInstance(Effects.HASTE, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//grow pumpkins, todo
                if (potionEffect.getPotion() == ModEffects.SLUSHY_EFFECT) {
                    //targetEntity.addPotionEffect(new EffectInstance(Effects.DUMMY, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//frost walker stuff, splash effect ice, todo
                if (potionEffect.getPotion() == ModEffects.GLOWSTONE_BOTTLE_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, potionEffect.getDuration(), 0));
                    if (potionEffect.getAmplifier() == 0) targetEntity.addPotionEffect(new EffectInstance(Effects.GLOWING, potionEffect.getDuration(), 0));
                }//needs testing
                if (potionEffect.getPotion() == ModEffects.INVISIBLE_INK_EFFECT) {
                    if (potionEffect.getAmplifier() > 0) targetEntity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, potionEffect.getDuration(), 0,false,false));
                    else targetEntity.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, potionEffect.getDuration()));
                }//needs testing
                if (potionEffect.getPotion() == ModEffects.PETRICHOR_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, potionEffect.getDuration(), 4));
                    targetEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, potionEffect.getDuration(), 9));
                    targetEntity.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, potionEffect.getDuration(), 9));
                }//needs testing
                if (potionEffect.getPotion() == ModEffects.ACTIVATED_CHARCOAL_EFFECT) {
                    int defaultDuration = ModItems.ACTIVATED_CHARCOAL.get().MILK_EFFECT_DURATION;
                    if (effectDuration != defaultDuration && effectDuration != defaultDuration * 2) {
                        Collection<EffectInstance> activeEffects = targetEntity.getActivePotionEffects();
                        List<Effect> activeBuffs = new ArrayList<>();
                        for (EffectInstance effect : activeEffects)
                            if (effect.getPotion().isBeneficial()) activeBuffs.add(effect.getPotion());
                        for (Effect buff : activeBuffs)
                            if (targetEntity.isPotionActive(buff)) targetEntity.removePotionEffect(buff);
                    }
                }
                if (potionEffect.getPotion() == ModEffects.CRYSTAL_GEM_EFFECT) {
                    //targetEntity.addPotionEffect(new EffectInstance(Effects.DUMMY, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//drink only resistance and thorns, fusion effect splash, todo
                if (potionEffect.getPotion() == ModEffects.SALT_EFFECT) {
                    //targetEntity.addPotionEffect(new EffectInstance(Effects.DUMMY, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//splash team stuff, food stuff, todo
                if (potionEffect.getPotion() == ModEffects.HOURGLASS_EFFECT) {
                    //targetEntity.addPotionEffect(new EffectInstance(Effects.DUMMY, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    System.out.println(potionEffect.getPotion().getName() + "needs work");
                }//drink only, and splash random effects,todo
                if (potionEffect.getPotion() == ModEffects.KRAKEN_BREATH_EFFECT) {
                    if (targetEntity instanceof ElderGuardianEntity)
                        targetEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, potionEffect.getAmplifier() + 2));
                    else if (targetEntity instanceof GuardianEntity)
                        targetEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, potionEffect.getAmplifier() + 3));
                    else {
                        targetEntity.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, potionEffect.getDuration(), potionEffect.getAmplifier()));
                        targetEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    }
                } //done!
                if (potionEffect.getPotion() == ModEffects.OMEN_OF_THE_SEAS_EFFECT && !targetEntity.world.getGameRules().getBoolean(GameRules.DISABLE_RAIDS)) {
                    ServerPlayerEntity omenRecipient = (ServerPlayerEntity) targetEntity;
                    omenRecipient.getServerWorld().spawnParticle(omenRecipient, ModParticles.KRAKEN_PARTICLE.get(), false, omenRecipient.getPosX(), omenRecipient.getPosY(), omenRecipient.getPosZ(), 1, 0.0D, 0.0D, 0.0D, 0);
                    omenRecipient.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 50, 0));
                }//ongoing effect for boss battle, todo
            }

        }
        @SubscribeEvent
        public static void onPotionActive(TickEvent.PlayerTickEvent event){
            World worldIn = event.player.world;
            PlayerEntity player = event.player;
            if (!worldIn.isRemote) {
                if (player.isPotionActive(ModEffects.ACTIVATED_CHARCOAL_EFFECT)){
                    int charcoalDuration = Objects.requireNonNull(player.getActivePotionEffect(ModEffects.ACTIVATED_CHARCOAL_EFFECT)).getDuration();
                    int charcoalLevel = Objects.requireNonNull(player.getActivePotionEffect(ModEffects.ACTIVATED_CHARCOAL_EFFECT)).getAmplifier();
                    Collection<EffectInstance> activeEffects = player.getActivePotionEffects();
                    List<Effect> activeDebuffs = new ArrayList<>();
                    for (EffectInstance effect : activeEffects) if (effect.getPotion().getEffectType() == EffectType.HARMFUL) activeDebuffs.add(effect.getPotion());
                    for (Effect debuff : activeDebuffs){
                        if (player.isPotionActive(debuff)) {
                            player.removePotionEffect(debuff);
                            if (charcoalLevel > 0){
                                if (player.isPotionActive(Effects.STRENGTH)){
                                    int strengthLevel = Objects.requireNonNull(player.getActivePotionEffect(Effects.STRENGTH)).getAmplifier();
                                    if (strengthLevel < 9) player.addPotionEffect(new EffectInstance(Effects.STRENGTH, charcoalDuration, strengthLevel + 1));
                                }else  player.addPotionEffect(new EffectInstance(Effects.STRENGTH, charcoalDuration, 0));
                            }
                        }
                    }
                }
            }
            if (player.isPotionActive(ModEffects.GLUE_EFFECT)){
                if( Objects.requireNonNull(player.getActivePotionEffect(ModEffects.GLUE_EFFECT)).getAmplifier() > 0){
                    if (Objects.requireNonNull(player.getActivePotionEffect(ModEffects.GLUE_EFFECT)).getDuration() > 3 && player.isAirBorne
                            && player.collidedHorizontally && player.isSneaking() && !player.hasNoGravity()){
                        player.setNoGravity(true);
                        player.setMotion(0, 0, 0);
                        player.playSound(SoundEvents.ENTITY_SLIME_SQUISH, .5f, .75f);
                    }
                    else if (!player.isSneaking()) {
                        if (player.hasNoGravity()){
                            if (worldIn.getBlockState(player.func_233580_cy_().offset(player.getHorizontalFacing(), 1)).isAir()){
                                Vector3d jumpDir = player.getLookVec().normalize();
                                player.setMotion(jumpDir.x * .5D, 0 ,jumpDir.z * .5D);
                                player.jump();
                                player.playSound(SoundEvents.ENTITY_SLIME_JUMP, .5f,.75f);
                            }else if (worldIn.getBlockState(player.func_233580_cy_().offset(player.getHorizontalFacing(), 1).offset(Direction.UP, 1)).isAir()){
                                player.jump();
                                player.playSound(SoundEvents.ENTITY_SLIME_JUMP_SMALL, 1, 1);
                            }
                        }
                        player.setNoGravity(false);
                    }
                    if(player.hasNoGravity()){
                        BlockPos stickPos;
                        boolean stuck = false;
                        for (int i = -1; i < 2; i++) {
                            if (stuck) break;
                            for (int j = -1; j < 2; j++) {
                                if (stuck) break;
                                for (int k = 0; k < 3; k++) {
                                    stickPos = new BlockPos(player.getPosX() + i, player.getPosY() + k, player.getPosZ() + j);
                                    if (!worldIn.getBlockState(stickPos).isAir()) {
                                        stuck = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!stuck) player.setNoGravity(false);
                    }
                    if (Objects.requireNonNull(player.getActivePotionEffect(ModEffects.GLUE_EFFECT)).getDuration() < 3) player.setNoGravity(false);
                }
            }
            if (player.isPotionActive(ModEffects.GRAVITY_EFFECT)){
                player.setNoGravity(false);
                player.removeActivePotionEffect(ModEffects.GRAVITY_EFFECT);
            }
        }

        @SubscribeEvent
        public static void onPotionTermination(PotionEvent.PotionExpiryEvent event){
            World worldIn = event.getEntity().getEntityWorld();
            LivingEntity targetEntity = event.getEntityLiving();
            EffectInstance potionEffect = event.getPotionEffect();
            if (potionEffect != null) {
                if (potionEffect.getPotion() == ModEffects.INSTABILITY_EFFECT) {
                   if (targetEntity instanceof PlayerEntity) {
                       ServerPlayerEntity serverPlayer = (ServerPlayerEntity) targetEntity;
                       ServerWorld spawnWorld = serverPlayer.server.getWorld(serverPlayer.func_241141_L_());
                       if (spawnWorld != null) {
                           BlockPos spawnLoc = serverPlayer.func_241140_K_();
                           Optional<Vector3d> maybeSpawn = Optional.empty();
                           if (spawnLoc != null) {
                               maybeSpawn = PlayerEntity.func_234567_a_(spawnWorld, spawnLoc, false, true);
                           }
                           double d3 = -1;
                           double d4 = -1;
                           double d5 = -1;
                           boolean flag = false;

                           if (maybeSpawn.isPresent()){
                               d3 = maybeSpawn.get().getX() ;
                               d4 =  maybeSpawn.get().getY();
                               d5 =  maybeSpawn.get().getZ();
                               if (targetEntity.isPassenger()) targetEntity.stopRiding();
                               if (!worldIn.isRemote) flag = targetEntity.attemptTeleport(d3, d4, d5, true);
                           }
                           if (!flag){
                               d3 = spawnWorld.getWorldInfo().getSpawnX();
                               d4 = spawnWorld.getWorldInfo().getSpawnY();
                               d5 = spawnWorld.getWorldInfo().getSpawnZ();
                               if (targetEntity.isPassenger()) targetEntity.stopRiding();
                               if (!worldIn.isRemote) flag = targetEntity.attemptTeleport(d3, d4, d5, true);
                               serverPlayer.sendMessage(ITextComponent.func_241827_a_("Respawn point missing or obstructed!"), serverPlayer.getUniqueID());
                           }
                           if (flag){
                               worldIn.playSound(null, d3, d4, d5, ModSounds.TELEPORT_ARRIVAL.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
                               targetEntity.playSound(ModSounds.TELEPORT_ARRIVAL.get(), 1.0F, 1.0F);
                           } else serverPlayer.sendMessage(ITextComponent.func_241827_a_("World spawn obstructed!"), serverPlayer.getUniqueID());
                       }
                   }
                }
            }
        }

        @SubscribeEvent
        public static void onPotionCleared(PotionEvent.PotionRemoveEvent event){
            World worldIn = event.getEntity().getEntityWorld();
            LivingEntity targetEntity = event.getEntityLiving();
            EffectInstance potionEffect = event.getPotionEffect();
            if (potionEffect != null) {
                //do something
            }
        }
        @SubscribeEvent
        public static void onPotionImpact(ProjectileImpactEvent.Throwable event){
            World worldIn = event.getThrowable().world;
            if (!worldIn.isRemote) {
                ThrowableEntity thrownObject = event.getThrowable();
                Potion potion = (thrownObject instanceof PotionEntity) ? PotionUtils.getPotionFromItem(((PotionEntity) thrownObject).getItem()) : null;
                EffectInstance potionEI = (potion != null && !potion.getEffects().isEmpty()) ? potion.getEffects().get(0) : null;
                if (potionEI != null) {
//                    double PR = 4.25;
//                    AxisAlignedBB PotionRadiusBB = new AxisAlignedBB(
//                            thrownObject.getPosX()-PR,
//                            thrownObject.getPosY()-PR,
//                            0,
//                            thrownObject.getPosX()+PR,
//                            thrownObject.getPosY()+PR,
//                            thrownObject.getPosZ()+PR
//                    ); //might not need
                    if (potionEI.getPotion() == ModEffects.NITRO_EFFECT) {
                        worldIn.createExplosion(thrownObject,thrownObject.getPosX(),thrownObject.getPosY(),thrownObject.getPosZ(),2.5f, Explosion.Mode.BREAK);
                    }
                }
            }
        }
        @SubscribeEvent
        public static void glueKnockback(LivingKnockBackEvent event){
            if (!event.getEntityLiving().getEntityWorld().isRemote && event.getEntityLiving().isPotionActive(ModEffects.GLUE_EFFECT)){
                event.setCanceled(true);
            }
        }

        @SubscribeEvent
        public static void effectFallHandler(LivingFallEvent event){
            LivingEntity entity = event.getEntityLiving();
            World worldIn = entity.getEntityWorld();
            if (entity.isPotionActive(ModEffects.SLIME_BOTTLE_EFFECT)) {
                if (!(entity instanceof PlayerEntity) && event.getDistance() > 2.0F) {
                    event.setDamageMultiplier(0.0F);
                    if (!entity.isAirBorne){
                        entity.addVelocity(0, (event.getDistance() * .8) - entity.getMotion().y, 0);
                        entity.velocityChanged = true;
                        entity.tick();
                        entity.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0F, 1.0F);
                    }
                }
                else if (!entity.isSneaking() && event.getDistance() > 2.0F) {
                    event.setDamageMultiplier(0.0F);
                    entity.fallDistance = 0.0F;
                    if (entity.world.isRemote) {
                        entity.setMotion(entity.getMotion().x, entity.getMotion().y * -0.9D, entity.getMotion().z);
                        entity.isAirBorne = true;
                        entity.func_230245_c_(false);
                        double f = 0.9500000000000001D;
                        entity.setMotion(entity.getMotion().x / f, entity.getMotion().y, entity.getMotion().z / f);
                    } else event.setCanceled(true);
                    entity.playSound(SoundEvents.ENTITY_SLIME_JUMP, 1.0F, 1.0F);
                    BounceHandler.addBounceHandler(entity, entity.getMotion().y);
                } else if (!entity.world.isRemote && entity.isSneaking()) event.setDamageMultiplier(0.2F);
            }
            else if (entity.isPotionActive(ModEffects.GLUE_EFFECT) ) {
                if (Objects.requireNonNull(entity.getActivePotionEffect(ModEffects.GLUE_EFFECT)).getAmplifier() > 0) {
                    BlockPos stickPos;
                    boolean stuck = false;
                    for (int i = -1; i < 2; i++) {
                        if (stuck) break;
                        for (int j = -1; j < 2; j++) {
                            if (stuck) break;
                            for (int k = 0; k < 3; k++) {
                                stickPos = new BlockPos(entity.getPosX() + i, entity.getPosY() + k, entity.getPosZ() + j);
                                if (!worldIn.getBlockState(stickPos).isAir()) {
                                    stuck = true;
                                    break;
                                }
                            }
                        }
                    }
                    event.setCanceled(stuck);
                }
            }
        }
    }
//    private static final String PROTOCOL_VERSION = "1";
//    public static final SimpleChannel GRAVITY_PACKET = NetworkRegistry.newSimpleChannel(
//            new ResourceLocation(SquidsGalore.MOD_ID, "main"),
//            () -> PROTOCOL_VERSION,
//            PROTOCOL_VERSION::equals,
//            PROTOCOL_VERSION::equals
//    );
//    public static void handle(boolean msg, Supplier<NetworkEvent.Context> ctx) {
//        ctx.get().enqueueWork(() -> {
//            // Work that needs to be threadsafe (most work)
//            ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
//            if (sender != null) sender.setNoGravity(msg);
//        });
//        ctx.get().setPacketHandled(true);
//    }
}
