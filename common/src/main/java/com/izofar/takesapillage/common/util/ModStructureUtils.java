package com.izofar.takesapillage.common.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;

public abstract class ModStructureUtils
{
	public static boolean isRelativelyFlat(
		Structure.GenerationContext context,
		int chunkSearchRadius,
		int maxTerrainHeightVariation
	) {
		ChunkPos chunkpos = context.chunkPos();
		int chunkStep = Math.max(chunkSearchRadius, 1);
		int maxTerrainHeight = Integer.MIN_VALUE;
		int minTerrainHeight = Integer.MAX_VALUE;
		for (int chunkX = chunkpos.x() - chunkSearchRadius; chunkX <= chunkpos.x() + chunkSearchRadius; chunkX += chunkStep) {
			for (int chunkZ = chunkpos.z() - chunkSearchRadius; chunkZ <= chunkpos.z() + chunkSearchRadius; chunkZ += chunkStep) {
				BlockPos blockpos = new BlockPos((chunkX << 4) + 7, 0, (chunkZ << 4) + 7);
				int height = context.chunkGenerator().getBaseHeight(blockpos.getX(), blockpos.getZ(), Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
				maxTerrainHeight = Math.max(maxTerrainHeight, height);
				minTerrainHeight = Math.min(minTerrainHeight, height);
				boolean isCorner = chunkSearchRadius == 0 || (chunkX != chunkpos.x() && chunkZ != chunkpos.z());
				if (isCorner && !context.chunkGenerator().getBaseColumn(blockpos.getX(), blockpos.getZ(), context.heightAccessor(), context.randomState()).getBlock(height - 1).getFluidState().isEmpty())
					return false;
				if (maxTerrainHeight - minTerrainHeight >= maxTerrainHeightVariation)
					return false;
			}
		}
		return maxTerrainHeight - minTerrainHeight <= maxTerrainHeightVariation;
	}

}
