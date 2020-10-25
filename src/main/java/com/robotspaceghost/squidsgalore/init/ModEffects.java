package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.items.SquidMilk.MilkBottleItem;
import com.robotspaceghost.squidsgalore.items.SquidMilk.SquidInkItem;
import com.robotspaceghost.squidsgalore.util.BounceHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ModEffects {
    public static Effect SQUID_INK_EFFECT =  new EffectBase(EffectType.HARMFUL, 0x0A0219).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "squid_ink_effect"));
    public static Effect MILK_BOTTLE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "milk_bottle_effect"));
    public static Effect BEARD_OIL_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x262626);
    public static Effect SQUID_AIR_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect BACON_GREASE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xEFE8CC);
    public static Effect DILUTED_HONEY_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xD79800);
    public static Effect PERFUME_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x77FFA4);
    public static Effect SLIME_BOTTLE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x8CD782);
    public static Effect GLUE_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF);
    public static Effect MUTAGEN_EFFECT = new EffectBase(EffectType.HARMFUL, 0x005B08);
    public static Effect BONE_HURTING_JUICE_EFFECT = new EffectBase(EffectType.HARMFUL, 0xE0761F);
    public static Effect INSTABILITY_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x72056F);
    public static Effect NITRO_EFFECT = new EffectBase(EffectType.NEUTRAL, 0x5F0000);
    public static Effect LIQUID_DOOM_EFFECT = new EffectBase(EffectType.HARMFUL, 0x000000);
    public static Effect FLOWERING_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x3AA0FF);
    public static Effect DMT_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF);
    public static Effect NOTAVIBE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xCF044B);
    public static Effect CHLOROPHYLL_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x18CD14);
    public static Effect HOT_SAUCE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xE63600);
    public static Effect COFFEE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x490000);
    public static Effect SLUSHY_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x30CCB7);
    public static Effect REDSTONE_BOTTLE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x770000);
    public static Effect GLOWSTONE_BOTTLE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xC88B00);
    public static Effect INVISIBLE_INK_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x000000);
    public static Effect PETRICHOR_EFFECT = new EffectBase(EffectType.HARMFUL, 0x636363);
    public static Effect ACTIVATED_CHARCOAL_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0x181818);
    public static Effect MINERS_DELIGHT_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFD800);
    public static Effect CRYSTAL_GEM_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xE968D7);
    public static Effect SALT_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect XP_BOOST_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xB1FB23);
    public static Effect HOUR_GLASS_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xE5BB77);
    public static Effect KRAKEN_BREATH_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xCC49F3).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "kraken_breath_effect"));
    public static Effect OMEN_OF_THE_SEAS = new EffectBase(EffectType.HARMFUL, 0xCC49F3).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "omen_of_the_seas_effect"));

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

                    ModEffects.KRAKEN_BREATH_EFFECT,
                    ModEffects.OMEN_OF_THE_SEAS
            );
        }
    }
    @Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE,  value = Dist.CLIENT)
    public static class ModEffectEvents {
        @SubscribeEvent
        public static void onPotionAdded(PotionEvent.PotionAddedEvent event){
            if (!event.getEntity().world.isRemote) {
                LivingEntity targetEntity = event.getEntityLiving();
                EffectInstance potionEffect = event.getPotionEffect();
                int effectDuration = potionEffect.getDuration();

                if (potionEffect.getPotion() == ModEffects.SQUID_INK_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, potionEffect.getDuration(), potionEffect.getAmplifier()));
                }
                if (potionEffect.getPotion() == ModEffects.MILK_BOTTLE_EFFECT) {
                    targetEntity.clearActivePotions();
                    targetEntity.addPotionEffect(new EffectInstance(Effects.STRENGTH, potionEffect.getDuration(), potionEffect.getAmplifier()));
                }
                if (potionEffect.getPotion() == ModEffects.ACTIVATED_CHARCOAL_EFFECT) {
                    //int defaultDuration = ModItems.ACTIVATED_CHARCOAL.get().MILK_EFFECT_DURATION;
                    int defaultDuration = 200; //remove when made
                    if (effectDuration != defaultDuration && effectDuration != defaultDuration * 2){
                        Collection<EffectInstance> activeEffects = targetEntity.getActivePotionEffects();
                        List<Effect> activeBuffs = new ArrayList<>();
                        for (EffectInstance effect : activeEffects) if (effect.getPotion().isBeneficial()) activeBuffs.add(effect.getPotion());
                        for (Effect buff : activeBuffs) if (targetEntity.isPotionActive(buff)) targetEntity.removePotionEffect(buff);
                    }
                } //edit when potion made
                if (potionEffect.getPotion() == ModEffects.KRAKEN_BREATH_EFFECT) {
                    if (targetEntity instanceof ElderGuardianEntity)
                        targetEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, potionEffect.getAmplifier() + 2));
                    else if (targetEntity instanceof GuardianEntity)
                        targetEntity.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 1, potionEffect.getAmplifier() + 3));
                    else {
                        targetEntity.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, potionEffect.getDuration(), potionEffect.getAmplifier()));
                        targetEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, potionEffect.getDuration(), potionEffect.getAmplifier()));
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onPotionActive(TickEvent.PlayerTickEvent event){
            World worldIn = event.player.world;
            if (!worldIn.isRemote) {
                PlayerEntity player = event.player;
                if (player.isPotionActive(ModEffects.ACTIVATED_CHARCOAL_EFFECT)){
                    Collection<EffectInstance> activeEffects = player.getActivePotionEffects();
                    List<Effect> activeBuffs = new ArrayList<>();
                    for (EffectInstance effect : activeEffects) if (effect.getPotion().getEffectType() == EffectType.HARMFUL) activeBuffs.add(effect.getPotion());
                    for (Effect buff : activeBuffs) if (player.isPotionActive(buff)) player.removePotionEffect(buff);
                }
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
                    double PR = 4.25;
                    AxisAlignedBB PotionRadiusBB = new AxisAlignedBB(
                            thrownObject.getPosX()-PR,
                            thrownObject.getPosY()-PR,
                            0,
                            thrownObject.getPosX()+PR,
                            thrownObject.getPosY()+PR,
                            thrownObject.getPosZ()+PR
                    ); //might not need
                    if (potionEI.getPotion() == ModEffects.NITRO_EFFECT) {
                        worldIn.createExplosion(thrownObject,thrownObject.getPosX(),thrownObject.getPosY(),thrownObject.getPosZ(),2.5f, Explosion.Mode.BREAK);
                    }
                }
            }
        }
        @SubscribeEvent
        public static void slimeEffect(LivingFallEvent event){
            LivingEntity entity = event.getEntityLiving();
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
        }
    }
}
