package com.robotspaceghost.squidsgalore.init;

import com.robotspaceghost.squidsgalore.SquidsGalore;
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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEffects {
    public static Effect SQUID_INK_EFFECT =  new EffectBase(EffectType.HARMFUL, 0x0A0219).setRegistryName(new ResourceLocation(SquidsGalore.MOD_ID, "squid_ink_effect"));
    public static Effect MILK_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect BEARD_OIL_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect SQUID_AIR_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect BACON_GREASE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect HONEY_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect EDV_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect SLIME_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect GLUE_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF);
    public static Effect MUTAGEN_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF);
    public static Effect BHJ_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF);
    public static Effect INSTABILITY_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect NITRO_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect DOOM_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF);
    public static Effect FLOWERING_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect DMT_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF);
    public static Effect NOTAVIBE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect CLOVER_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect CLOVER_SPLASH_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect HOT_SAUCE_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect COFFEE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect SLUSHY_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect REDSTONE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect GLOWSTONE_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect INVISIBLE_INK_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect PETRIFIED_EFFECT = new EffectBase(EffectType.HARMFUL, 0xFFFFFF);
    public static Effect ACTIVATED_CHARCOAL_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect MINERS_DELIGHT_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect GEM_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect GEM_SPLASH_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect SALT_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect SALT_SPLASH_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect XP_BOOST_EFFECT = new EffectBase(EffectType.BENEFICIAL, 0xFFFFFF);
    public static Effect HOUR_GLASS_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
    public static Effect HOUR_GLASS_SPLASH_EFFECT = new EffectBase(EffectType.NEUTRAL, 0xFFFFFF);
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
                if (potionEffect.getPotion() == ModEffects.SQUID_INK_EFFECT) {
                    targetEntity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, potionEffect.getDuration(), potionEffect.getAmplifier()));
                }
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
                if (player.isPotionActive(ModEffects.SQUID_INK_EFFECT)){
                    //do stuff
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
                    if (potionEI.getPotion() == ModEffects.NITRO_EFFECT) {
                        worldIn.createExplosion(thrownObject,thrownObject.getPosX(),thrownObject.getPosY(),thrownObject.getPosZ(),2.5f, Explosion.Mode.BREAK);
                    }
                }
            }
        }
        @SubscribeEvent
        public static void slimeEffect(LivingFallEvent event){
            LivingEntity entity = event.getEntityLiving();
            if (entity.isPotionActive(ModEffects.SLIME_EFFECT)) {
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
