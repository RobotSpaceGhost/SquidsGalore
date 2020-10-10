package com.robotspaceghost.squidsgalore.blocks;
import com.robotspaceghost.squidsgalore.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import javax.annotation.Nullable;
import java.util.Random;

public class GlowSquidSoul extends Block implements IWaterLoggable {
    public static final BooleanProperty LIT = RedstoneTorchBlock.LIT;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape SOUL_SHAPE = Block.makeCuboidShape(8.0D, 8.0D, 8.0D, 9.0D, 9.0D, 9.0D);

    public GlowSquidSoul() {
        super(Block.Properties.from(Blocks.REDSTONE_LAMP)
        .doesNotBlockMovement()
        .notSolid()
        .zeroHardnessAndResistance()

        /*
                .setRequiresTool()
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        */);
        this.setDefaultState(this.getDefaultState().with(LIT, Boolean.TRUE).with(WATERLOGGED, Boolean.FALSE));

    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
                return SOUL_SHAPE;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        FluidState fluidstate = context.getWorld().getFluidState(blockpos);
        return this.getDefaultState().with(LIT, Boolean.TRUE).with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER);


    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (stateIn.get(WATERLOGGED)) {
            worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
        }
        return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        return IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
    }

    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
    }

    /*
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isRemote) {
            boolean wet = state.get(WATERLOGGED);
            if (neighborIsGlowSquidSoul(worldIn,pos)) {
                clearGlowSquidSoul(worldIn, pos, blockIn, wet);
            }
        }
    }*/

    public void clearGlowSquidSoul(World worldIn, BlockPos pos, boolean wet){
        if (wet){
            worldIn.setBlockState(pos, Blocks.WATER.getDefaultState());
        }else{
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }

    public void clearSurroundingSouls(World worldIn, BlockPos pos, boolean clearCenter){
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                for (int k = -1; k < 2; k++){
                    BlockPos newPos = new BlockPos(pos.offset(Direction.EAST, i).offset(Direction.UP, j).offset(Direction.NORTH, k));
                    BlockState newState = worldIn.getBlockState(newPos);
                    Block newBlock = worldIn.getBlockState(newPos).getBlock();
                    if (!clearCenter && (i == 0) && (j == 0) && (k == 0)){
                        System.out.println(i + ", " + j + ", " + k);
                        System.out.println("center of soul found!");
                    }
                    else if (newBlock instanceof GlowSquidSoul){
                        ((GlowSquidSoul) newBlock).clearGlowSquidSoul(worldIn, newPos, ((GlowSquidSoul) newBlock).isWet(newState));
                    }
                }
            }
        }
    }
    /*
    public boolean neighborIsGlowSquidSoul(World worldIn, BlockPos pos){
        BlockState centerState = worldIn.getBlockState(pos).getBlock().getDefaultState();
        if (centerState != ModBlocks.GLOW_SQUID_SOUL.get().getDefaultState()) return false; //just in case?
        int uFlag = (worldIn.getBlockState(pos.offset(Direction.UP, 1)).getBlock().getDefaultState() == centerState) ? 1 : 0;
        int dFlag = (worldIn.getBlockState(pos.offset(Direction.DOWN, 1)).getBlock().getDefaultState() == centerState) ? 1 : 0;
        int eFlag = (worldIn.getBlockState(pos.offset(Direction.EAST, 1)).getBlock().getDefaultState() == centerState) ? 1 : 0;
        int wFlag = (worldIn.getBlockState(pos.offset(Direction.WEST, 1)).getBlock().getDefaultState() == centerState) ? 1 : 0;
        int nFlag = (worldIn.getBlockState(pos.offset(Direction.NORTH, 1)).getBlock().getDefaultState() == centerState) ? 1 : 0;
        int sFlag = (worldIn.getBlockState(pos.offset(Direction.SOUTH, 1)).getBlock().getDefaultState() == centerState)  ? 1 : 0;
        return ((uFlag + dFlag + eFlag + wFlag + nFlag + sFlag) >= 1);
    } */
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        ItemStack itemstack = useContext.getItem();
        return useContext.replacingClickedOnBlock() && itemstack.getItem() != this.asItem();
    }
    /*
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        boolean wet = state.get(WATERLOGGED);
        Block blockIn = worldIn.getBlockState(pos).getBlock();
        if (neighborIsGlowSquidSoul(worldIn,pos)) {
            clearGlowSquidSoul(worldIn, pos, blockIn, wet);
        }
    } */

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(LIT, WATERLOGGED);
    }
    public boolean isWet(BlockState state){
        return state.get(WATERLOGGED);
    }
    public boolean isTransparent(BlockState state) {
        return true;
    }

}