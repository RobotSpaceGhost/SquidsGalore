package com.robotspaceghost.squidsgalore.events;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.DrawHighlightEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE,  value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void removeGlowBlockOutline(DrawHighlightEvent.HighlightBlock event){
        if (event.isCancelable()){
            World worldIn = event.getInfo().getRenderViewEntity().getEntityWorld();
            BlockPos targetPos = event.getTarget().getPos();
            BlockPos cameraPos = event.getInfo().getBlockPos();
            BlockState lookBlockState = worldIn.getBlockState(targetPos).getBlock().getDefaultState();
            PlayerEntity player = worldIn.getClosestPlayer(cameraPos.getX(),cameraPos.getY(),cameraPos.getZ(),2.0D,true);

            if (player != null && !player.isCreative() && lookBlockState == ModBlocks.GLOW_BLOCK.get().getBlock().getDefaultState()){
                event.setCanceled(true);
            }
        }
    }
}
