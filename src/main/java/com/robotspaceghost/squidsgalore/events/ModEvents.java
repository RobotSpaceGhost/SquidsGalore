package com.robotspaceghost.squidsgalore.events;

import com.robotspaceghost.squidsgalore.SquidsGalore;
import com.robotspaceghost.squidsgalore.entities.BabyKrakenEntity;
import com.robotspaceghost.squidsgalore.init.ModBlocks;
import com.robotspaceghost.squidsgalore.init.ModEntityTypes;
import com.robotspaceghost.squidsgalore.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.DrawHighlightEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SquidsGalore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE,  value = Dist.CLIENT)
public class ModEvents {

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

    @SubscribeEvent
    public static void getSquidMilk(PlayerInteractEvent.EntityInteract event){
        Entity squid = event.getTarget();
        PlayerEntity player = event.getPlayer();
        World worldIn = event.getWorld();
        ItemStack milk = null;
        ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);
        ItemStack inkSac = new ItemStack(Items.INK_SAC);
        if (!event.getWorld().isRemote && squid.isAlive() && event.getHand() == player.getActiveHand()){
            if ((player.getHeldItemMainhand().getItem() == bottle.getItem())) {
                if (squid instanceof BabyKrakenEntity ) {
                    if(!player.getUniqueID().toString().equals(((BabyKrakenEntity) squid).getOwnerId())) squid.playSound(BabyKrakenEntity.milkedFail, 1.0f, 1.0f);
                    else milk = ((BabyKrakenEntity) squid).milkSquid();
                    if (milk == null && player.abilities.isCreativeMode) { milk = new ItemStack(BabyKrakenEntity.SQUID_MILK);}
                }
                //-----------------
                // other squids here
                //---------------
                if (milk != null){
                    if(!player.abilities.isCreativeMode) player.getHeldItemMainhand().shrink(1);
                    if (!player.addItemStackToInventory(milk)) player.dropItem(milk, false);
                }
            } else if (squid instanceof SquidEntity && !player.addItemStackToInventory(inkSac)) player.dropItem(inkSac, false);
        }
    }
    //InventoryHelper.spawnItemStack(worldIn, player.getPosX(), player.getPosY(), player.getPosZ(), new ItemStack(Items.GLASS_BOTTLE)); //useful for later
    @SubscribeEvent
    public static void spawnBabyKrakenFromBucket(PlayerInteractEvent event){
        World worldIn = event.getWorld();
        PlayerEntity player = event.getPlayer();
        BlockPos pos = event.getPos();
        if (!worldIn.isRemote() && player != null && event.getHand() == player.getActiveHand() && (player.getHeldItemMainhand().getItem() == ModItems.BUCKET_OF_BABY_KRAKEN.get())) {
            Entity entity = ModEntityTypes.BABY_KRAKEN.get().spawn(worldIn, player.getHeldItemMainhand(), null, pos, SpawnReason.BUCKET, true, false);
            if (entity instanceof BabyKrakenEntity) {
                ((BabyKrakenEntity) entity).setOwnerId(player.getUniqueID().toString());
                ((BabyKrakenEntity) entity).setFromBucket(true);
            }
            player.getHeldItemMainhand().shrink(1);
            player.setHeldItem(player.getActiveHand(), new ItemStack(Items.WATER_BUCKET.getItem()));

        }
    }
}
