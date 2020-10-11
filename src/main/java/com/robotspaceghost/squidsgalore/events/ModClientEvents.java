package com.robotspaceghost.squidsgalore.events;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import com.robotspaceghost.squidsgalore.init.ModBlocks;
import com.robotspaceghost.squidsgalore.init.ModEntityTypes;
import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.DrawHighlightEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE,  value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void removeGlowSquidSoulOutline(DrawHighlightEvent.HighlightBlock event){
        if (event.isCancelable()){
            World worldIn = event.getInfo().getRenderViewEntity().getEntityWorld();
            BlockPos targetPos = event.getTarget().getPos();
            BlockPos cameraPos = event.getInfo().getBlockPos();
            BlockState lookBlockState = worldIn.getBlockState(targetPos).getBlock().getDefaultState();
            PlayerEntity player = worldIn.getClosestPlayer(cameraPos.getX(),cameraPos.getY(),cameraPos.getZ(),2.0D,true);

            if (player != null && !player.isCreative() && lookBlockState == ModBlocks.GLOW_SQUID_SOUL.get().getBlock().getDefaultState()){
                event.setCanceled(true);
            }
        }
    }
    /*
    @SubscribeEvent
    public static void burnImmunity(LivingAttackEvent event){
        if (event.isCancelable()){
            if ((event.getEntity() instanceof ENTITYNAMEHERE) && (event.getSource() == DamageSource.LAVA || event.getSource() == DamageSource.HOT_FLOOR ||
                event.getSource() == DamageSource.IN_FIRE || event.getSource() == DamageSource.ON_FIRE)) {
                event.setCanceled(true);
            }
        }

    }
    */

}
