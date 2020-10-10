package com.robotspaceghost.squidsgalore.blocks;

import net.minecraft.block.*;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import java.util.Random;
import javax.annotation.Nullable;



public class KrakenGlass extends Block {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public static final BooleanProperty INDIRECT = BooleanProperty.create("indirect");
    public KrakenGlass() {
         super(Block.Properties.from(Blocks.REDSTONE_LAMP)
                 .hardnessAndResistance(0.3f, 1.5f)
                 .sound(SoundType.GLASS)
                 .setRequiresTool()
                 .harvestLevel(2)
                 .harvestTool(ToolType.PICKAXE)
                 .notSolid());
        this.setDefaultState(this.getDefaultState().with(LIT, Boolean.FALSE).with(INDIRECT, Boolean.FALSE));

    }
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
    }

    public boolean isOnlyIndirectPowered(World world, BlockPos pos){
        if (world.isBlockPowered(pos)) return false;
        int uFlag = world.isBlockPowered(pos.offset(Direction.UP, 1)) ? 1 : 0;
        int dFlag = world.isBlockPowered(pos.offset(Direction.DOWN, 1)) ? 1 : 0;
        int eFlag = world.isBlockPowered(pos.offset(Direction.EAST, 1)) ? 1 : 0;
        int wFlag = world.isBlockPowered(pos.offset(Direction.WEST, 1)) ? 1 : 0;
        int nFlag = world.isBlockPowered(pos.offset(Direction.NORTH, 1)) ? 1 : 0;
        int sFlag = world.isBlockPowered(pos.offset(Direction.SOUTH, 1)) ? 1 : 0;

        return ((uFlag + dFlag + eFlag + wFlag + nFlag + sFlag) >= 1);
    }
    public void tickSurrounding(World world, BlockPos pos){
        world.getPendingBlockTicks().scheduleTick(pos, this, 4);
        world.getPendingBlockTicks().scheduleTick(pos.offset(Direction.UP, 1), this, 4);
        world.getPendingBlockTicks().scheduleTick(pos.offset(Direction.DOWN, 1), this, 4);
        world.getPendingBlockTicks().scheduleTick(pos.offset(Direction.EAST, 1), this, 4);
        world.getPendingBlockTicks().scheduleTick(pos.offset(Direction.WEST, 1), this, 4);
        world.getPendingBlockTicks().scheduleTick(pos.offset(Direction.NORTH, 1), this, 4);
        world.getPendingBlockTicks().scheduleTick(pos.offset(Direction.SOUTH, 1), this, 4);
    }
    public void notifyNeighborsNeighbor(World world, BlockPos pos, Block blockIn){
        world.notifyNeighborsOfStateChange(pos, blockIn);
        world.notifyNeighborsOfStateChange(pos.offset(Direction.UP, 1), blockIn);
        world.notifyNeighborsOfStateChange(pos.offset(Direction.DOWN, 1), blockIn);
        world.notifyNeighborsOfStateChange(pos.offset(Direction.EAST, 1), blockIn);
        world.notifyNeighborsOfStateChange(pos.offset(Direction.WEST, 1), blockIn);
        world.notifyNeighborsOfStateChange(pos.offset(Direction.NORTH, 1), blockIn);
        world.notifyNeighborsOfStateChange(pos.offset(Direction.SOUTH, 1), blockIn);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        boolean indirectFlag = isOnlyIndirectPowered(world,pos);
        boolean litFlag = world.isBlockPowered(pos);
        return this.getDefaultState().with(LIT, litFlag).with(INDIRECT,indirectFlag);
    }
    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            boolean litFlag = state.get(LIT);
            boolean indFlag = state.get(INDIRECT);
            if (litFlag != worldIn.isBlockPowered(pos)) {
                if (litFlag) {
                    tickSurrounding(worldIn, pos);
                } else {
                    worldIn.setBlockState(pos, state.func_235896_a_(LIT), 2);
                    notifyNeighborsNeighbor(worldIn,pos, blockIn);
                }
            }
            if (indFlag != isOnlyIndirectPowered(worldIn,pos)){
                if (indFlag) {
                    tickSurrounding(worldIn, pos);
                } else {
                    worldIn.setBlockState(pos, state.func_235896_a_(INDIRECT), 2);
                    notifyNeighborsNeighbor(worldIn,pos, blockIn);
                }
            }
        }
    }
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (state.get(LIT) && !worldIn.isBlockPowered(pos)) {
            worldIn.setBlockState(pos, state.func_235896_a_(LIT), 2);
            notifyNeighborsNeighbor(worldIn,pos, this);
        }
        if (state.get(INDIRECT) && (!isOnlyIndirectPowered(worldIn,pos))){
            worldIn.setBlockState(pos, state.func_235896_a_(INDIRECT), 2);
            notifyNeighborsNeighbor(worldIn,pos, this);
        }

    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(INDIRECT);
        builder.add(LIT);

    }
}


