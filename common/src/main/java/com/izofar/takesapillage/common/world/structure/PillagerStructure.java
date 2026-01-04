package com.izofar.takesapillage.common.world.structure;

import com.izofar.takesapillage.common.init.ItTakesPillageStructureTypes;
import com.izofar.takesapillage.common.util.ModStructureUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;


import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import java.util.Optional;

/*? >= 1.21 {*/
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
/*?}*/

public final class PillagerStructure extends Structure
{
	//? if >= 1.21 {
	public static final MapCodec<PillagerStructure> CODEC = RecordCodecBuilder.mapCodec(instance ->
	//?} else {
	/*public static final Codec<PillagerStructure> CODEC = RecordCodecBuilder.<PillagerStructure>mapCodec(instance ->
	*///?}
		instance.group(PillagerStructure.settingsCodec(instance),
			StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(structure -> structure.startPool),
			ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(structure -> structure.startJigsawName),
			Codec.intRange(0, 30).fieldOf("size").forGetter(structure -> structure.size),
			Codec.intRange(0, 30).fieldOf("terrain_search_radius").forGetter(structure -> structure.terrainSearchRadius),
			Codec.intRange(0, 30).fieldOf("max_terrain_range").forGetter(structure -> structure.maxTerrainRange),
			HeightProvider.CODEC.fieldOf("start_height").forGetter(structure -> structure.startHeight),
			Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(structure -> structure.projectStartToHeightmap),
			//? >= 1.21.10 {
			JigsawStructure.MaxDistance.CODEC.fieldOf("max_distance_from_center").forGetter((structure) -> structure.maxDistanceFromCenter)
			//?} else {
			/*Codec.intRange(1, 128).fieldOf("max_distance_from_center").forGetter(structure -> structure.maxDistanceFromCenter)
			 *///?}
		).apply(instance, PillagerStructure::new));

	private final Holder<StructureTemplatePool> startPool;
	private final Optional<ResourceLocation> startJigsawName;
	private final int size;
	private final int terrainSearchRadius;
	private final int maxTerrainRange;
	private final HeightProvider startHeight;
	private final Optional<Heightmap.Types> projectStartToHeightmap;
	//? >= 1.21.10 {
	private final JigsawStructure.MaxDistance maxDistanceFromCenter;
	//?} else {
	/*private final int maxDistanceFromCenter;
	 *///?}

	public PillagerStructure(
		Structure.StructureSettings config,
		Holder<StructureTemplatePool> startPool,
		Optional<ResourceLocation> startJigsawName,
		int size,
		int terrainSearchRadius,
		int maxTerrainRange,
		HeightProvider startHeight,
		Optional<Heightmap.Types> projectStartToHeightmap,
		//? >= 1.21.10 {
		JigsawStructure.MaxDistance maxDistanceFromCenter
		//?} else {
		/*int maxDistanceFromCenter
		 *///?}
	) {
		super(config);
		this.startPool = startPool;
		this.startJigsawName = startJigsawName;
		this.size = size;
		this.terrainSearchRadius = terrainSearchRadius;
		this.maxTerrainRange = maxTerrainRange;
		this.startHeight = startHeight;
		this.projectStartToHeightmap = projectStartToHeightmap;
		this.maxDistanceFromCenter = maxDistanceFromCenter;
	}

	@Override
	public StructureType<?> type() {
		return ItTakesPillageStructureTypes.PILLAGER_STRUCTURE.get();
	}

	private static boolean checkLocation(
		Structure.GenerationContext context,
		int terrainSearchRadius,
		int maxTerrainRange
	) {
		int i = context.chunkPos().x >> 4;
		int j = context.chunkPos().z >> 4;
		WorldgenRandom worldgenrandom = new WorldgenRandom(new LegacyRandomSource(0L));
		worldgenrandom.setSeed((i ^ j << 4) ^ context.seed());
		return ModStructureUtils.isRelativelyFlat(context, terrainSearchRadius, maxTerrainRange)
			   && ModStructureUtils.isOnLand(context, terrainSearchRadius);
	}

	@Override
	public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext context) {
		if (!checkLocation(context, this.terrainSearchRadius, this.maxTerrainRange)) return Optional.empty();
		BlockPos blockpos = context.chunkPos().getMiddleBlockPosition(0);
		/*? >= 1.21 {*/
		return JigsawPlacement.addPieces(context, this.startPool, this.startJigsawName, this.size, blockpos, false, this.projectStartToHeightmap, this.maxDistanceFromCenter, PoolAliasLookup.EMPTY, JigsawStructure.DEFAULT_DIMENSION_PADDING, JigsawStructure.DEFAULT_LIQUID_SETTINGS);
		/*?} else {*/
		/*return JigsawPlacement.addPieces(context, this.startPool, this.startJigsawName, this.size, blockpos, false, this.projectStartToHeightmap, this.maxDistanceFromCenter);
		 *//*?}*/
	}
}
