package com.aquariumglass.blocks;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;



import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.aquariumglass.AquariumGlass;
import com.aquariumglass.tileentity.TileEntityAquariumGlass;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAquariumGlass extends BlockContainer {

	public BlockAquariumGlass() {
		super(Material.glass);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeGlass);
		this.setCreativeTab(AquariumGlass.aquariumTab);
		
	}

	
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int int1) {
		// TODO Auto-generated method stub
		return new TileEntityAquariumGlass();
		
	}

	public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.setDefaultDirection(world, x, y, z);
    }
	

	public void setDefaultDirection(World world, int x, int y, int z){
		if(!world.isRemote){
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x, y, z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4 = world.getBlock(x + 1, y, z);
			
			byte b0 = 3;
			
			if (b1.func_149730_j() && !b2.func_149730_j())
			{
				b0 = 3;
			}
			
			if (b2.func_149730_j() && !b1.func_149730_j())
			{
				b0 = 2;
			}
			
			if (b3.func_149730_j() && !b4.func_149730_j())
			{
				b0 = 5;
			}
			
			if (b4.func_149730_j() && !b3.func_149730_j())
			{
				b0 = 4;
			}
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
		
		
		
	}
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
			int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360F) + 0.5D) & 3;
	if(l == 0){
		world.setBlockMetadataWithNotify(x, y, z, 2, 2);
	}
	
	if(l == 1){
		world.setBlockMetadataWithNotify(x, y, z, 5, 2);
	}
	
	if(l == 2){
		world.setBlockMetadataWithNotify(x, y, z, 3, 2);
	}
	
	if(l == 3){
		world.setBlockMetadataWithNotify(x, y, z, 4, 2);
	}
	
	}
public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_){
	int l = p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_);
    this.func_150043_b(l);
}
private void func_150043_b(int p_150043_1_)
{
    int j = p_150043_1_ & 7;
   
    if (j == 2)
    {
        this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 0.125F);
    }
    else if (j == 3)
    {
        this.setBlockBounds(0F, 0F, .875F, 1F, 1F, 1F);
    }
    else if (j == 4)
    {
        this.setBlockBounds(0F, 0F, 0F, .125F, 1F, 1F);
    }
    else if (j == 5)
    {
        this.setBlockBounds(.875F, 0F , 0F, 1F, 1F, 1F);
    }
}
public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_)
{
    boolean flag  = this.canPaneConnectTo(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ - 1, NORTH);
    boolean flag1 = this.canPaneConnectTo(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ + 1, SOUTH);
    boolean flag2 = this.canPaneConnectTo(p_149743_1_, p_149743_2_ - 1, p_149743_3_, p_149743_4_, WEST );
    boolean flag3 = this.canPaneConnectTo(p_149743_1_, p_149743_2_ + 1, p_149743_3_, p_149743_4_, EAST );

    if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
    {
        if (flag2 && !flag3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }
        else if (!flag2 && flag3)
        {
            this.setBlockBounds(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }
    }
    else
    {
        this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
        super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
    }

    if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
    {
        if (flag && !flag1)
        {
            this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }
        else if (!flag && flag1)
        {
            this.setBlockBounds(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }
    }
    else
    {
        this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
    }
}
public boolean canPaneConnectTo(IBlockAccess world, int x, int y, int z, ForgeDirection dir)
{
    return canPaneConnectToBlock(world.getBlock(x, y, z)) || 
            world.isSideSolid(x, y, z, dir.getOpposite(), false);
}
public final boolean canPaneConnectToBlock(Block p_150098_1_)
{
    return p_150098_1_.func_149730_j() || p_150098_1_ == this || p_150098_1_ == Blocks.glass || p_150098_1_ == Blocks.stained_glass || p_150098_1_ == Blocks.stained_glass_pane || p_150098_1_ instanceof BlockAquariumGlass;
}

@SideOnly(Side.CLIENT)
public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
{
    return true;
}
}
