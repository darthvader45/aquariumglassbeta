package com.aquariumglass.blocks;



import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.aquariumglass.AquariumGlass;
import com.aquariumglass.util.ElectricDamageSource;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockElectricFence extends BlockFence {

	public BlockElectricFence(String side,
			Material material) {
		super(side, material);
		this.setHardness(5.0F);
		this.setResistance(30);
		this.setBlockName("electricfence");
		this.setCreativeTab(AquariumGlass.aquariumTab);
	}
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((float)i + f, j, (float)k + f, (float)(i + 1) - f, (float)(j + 1) - f, (float)(k + 1) - f);
    }
	
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity){
		 final DamageSource dmgEFence = new ElectricDamageSource("efence");
		if(!entity.worldObj.isRemote){
		if(true && entity instanceof EntityPlayer || entity instanceof EntityItem || entity instanceof EntityMob || entity instanceof EntitySlime || entity instanceof EntityMagmaCube){
		entity.attackEntityFrom(dmgEFence, 4);
		world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, AquariumGlass.modid + ":" + "block.electricfence.shock", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
		
		}
		else {
			entity.attackEntityFrom(dmgEFence, 0);
			world.playSoundEffect((double)i + 0.5D, (double)j + 0.5D, (double)k + 0.5D, AquariumGlass.modid + ":" + "block.electricfence.shock", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
		}
		}
	}
	
public void randomDisplayTick(World world, int x, int y, int z, Random random){
    	
    	
    	
    	float f1 = (float)x + 0.6F;
    	float f2 = (float)y + 0.1F;
    	float f3 = (float)z + 0.6F;
    	float f4 = random.nextFloat() * 0.3F -0.3F;
    	float f5 = random.nextFloat() * 0.3F -0.3F;
    	float f6 = (float)y + 0.2F;
    	float f7 = (float)y + 0.3F;
    	float f8 = (float)y + 0.4F;
    	float f9 = (float)y + 0.5F;
    	float f10 = (float)y + 0.6F;
    	float f11 = (float)x + 0.6F;
    	float f12 = (float)z + 0.6F;
    	
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f2, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f6, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f7, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f8, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f9, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f10, (double)(f3+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f11+f4), (double)f6, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f11+f4), (double)f7, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f11+f4), (double)f8, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f11+f4), (double)f9, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f11+f4), (double)f10, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f11+f4), (double)f2, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f6, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f7, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f8, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f9, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f10, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	world.spawnParticle("reddust", (double)(f1+f4), (double)f2, (double)(f12+f5), 0.0D, 0.0D, 0.0D);
    	
    }
	
	public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_)
    {
        boolean flag = this.canConnectFenceTo(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ - 1);
        boolean flag1 = this.canConnectFenceTo(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ + 1);
        boolean flag2 = this.canConnectFenceTo(p_149743_1_, p_149743_2_ - 1, p_149743_3_, p_149743_4_);
        boolean flag3 = this.canConnectFenceTo(p_149743_1_, p_149743_2_ + 1, p_149743_3_, p_149743_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag || flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag2 || flag3 || !flag && !flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        boolean flag = this.canConnectFenceTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1);
        boolean flag1 = this.canConnectFenceTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1);
        boolean flag2 = this.canConnectFenceTo(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_);
        boolean flag3 = this.canConnectFenceTo(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        if (world.doesBlockHaveSolidTopSurface(world, x, y, z))
        {
            return true;
        }
        else
        {
            Block block = world.getBlock(x, y, z);
            return block == AquariumGlass.electricFence;
        }
    }
    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_)
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 11;
    }

    public static boolean func_149825_a(Block p_149825_0_)
    {
        return p_149825_0_ == Blocks.fence || p_149825_0_ == Blocks.nether_brick_fence;
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
        return true;
    }
}
