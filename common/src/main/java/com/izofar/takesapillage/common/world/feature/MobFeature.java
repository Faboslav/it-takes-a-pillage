package com.izofar.takesapillage.common.world.feature;

import com.google.common.collect.ImmutableList;
import com.izofar.takesapillage.common.util.MobLists;
import com.izofar.takesapillage.common.versions.VersionedEntitySpawnReason;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import java.util.function.Supplier;

//? if >=26.3 {
import com.mojang.serialization.MapCodec;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
//?} else {
/*import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
*///?}

//? if >=1.21.5 {
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
//?} else {
/*import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
*///?}

public class MobFeature<T extends Mob>
//? if >=26.3 {
implements Feature
//?} else {
//extends Feature<NoneFeatureConfiguration>
//?}
{
	//? if >=1.21.5 {
	private final Supplier<WeightedList<EntityType<? extends T>>> entityTypes;
	//?} else {
	//private final Supplier<WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends T>>>> entityTypes;
	//?}
	//? if >=26.3 {
	private final MapCodec<MobFeature<T>> codec = MapCodec.unit(() -> this);
	//?}

	public MobFeature(
		//? if >=1.21.5 {
		Supplier<WeightedList<EntityType<? extends T>>> entityTypes
		//?} else {
		//Supplier<WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends T>>>> entityTypes
		//?}
	) {
		//? if <26.3 {
		//super(NoneFeatureConfiguration.CODEC);
		//?}
		this.entityTypes = entityTypes;
	}

	public MobFeature(EntityType<? extends T> entityType) {
		//? if <26.3 {
		//super(NoneFeatureConfiguration.CODEC);
		//?}
		this.entityTypes = () -> MobLists.createWeightedList(ImmutableList.of(MobLists.createWeightedEntry(entityType, 1)));
	}

	//? if >=26.3 {
	@Override
	public boolean place(WorldGenLevel level, ChunkGenerator chunkGenerator, RandomSource random, BlockPos origin) {
		BlockPos position = origin.below();
		var entityType = this.entityTypes.get().getRandom(random).get();
		var entity = entityType.create(level.getLevel(), VersionedEntitySpawnReason.STRUCTURE);

		if (entity == null) {
			return false;
		}

		entity.snapTo(position.getX() + 0.5D, position.getY(), position.getZ() + 0.5D, 0.0F, 0.0F);
		entity.finalizeSpawn(level, level.getCurrentDifficultyAt(position), VersionedEntitySpawnReason.STRUCTURE, null);

		entity.setPersistenceRequired();
		level.addFreshEntity(entity);
		return true;
	}

	@Override
	public MapCodec<? extends Feature> codec() {
		return this.codec;
	}
	//?} else if >=1.21.5 {
	/*@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos position = context.origin().below();
		var entityType = this.entityTypes.get().getRandom(context.random()).get();
		var entity = entityType.create(context.level().getLevel(), VersionedEntitySpawnReason.STRUCTURE);

		if (entity == null) {
			return false;
		}

		entity.snapTo(position.getX() + 0.5D, position.getY(), position.getZ() + 0.5D, 0.0F, 0.0F);
		entity.finalizeSpawn(context.level(), context.level().getCurrentDifficultyAt(position), VersionedEntitySpawnReason.STRUCTURE, null);

		entity.setPersistenceRequired();
		context.level().addFreshEntity(entity);
		return true;
	}
	*///?} else if >=1.21.3 {
	/*@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos position = context.origin().below();
		var entityType = this.entityTypes.get().getRandom(context.random()).get().data();
		var entity = entityType.create(context.level().getLevel(), VersionedEntitySpawnReason.STRUCTURE);

		if (entity == null) {
			return false;
		}

		entity.moveTo(position.getX() + 0.5D, position.getY(), position.getZ() + 0.5D, 0.0F, 0.0F);
		entity.finalizeSpawn(context.level(), context.level().getCurrentDifficultyAt(position), VersionedEntitySpawnReason.STRUCTURE, null);

		entity.setPersistenceRequired();
		context.level().addFreshEntity(entity);
		return true;
	}
	*///?} else if >=1.21.1 {
	/*@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos position = context.origin().below();
		var entityType = this.entityTypes.get().getRandom(context.random()).get().data();
		var entity = entityType.create(context.level().getLevel());

		if (entity == null) {
			return false;
		}

		entity.moveTo(position.getX() + 0.5D, position.getY(), position.getZ() + 0.5D, 0.0F, 0.0F);
		entity.finalizeSpawn(context.level(), context.level().getCurrentDifficultyAt(position), VersionedEntitySpawnReason.STRUCTURE, null);

		entity.setPersistenceRequired();
		context.level().addFreshEntity(entity);
		return true;
	}
	*///?} else {
	/*@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos position = context.origin().below();
		var entityType = this.entityTypes.get().getRandom(context.random()).get().getData();
		var entity = entityType.create(context.level().getLevel());

		if (entity == null) {
			return false;
		}

		entity.moveTo(position.getX() + 0.5D, position.getY(), position.getZ() + 0.5D, 0.0F, 0.0F);
		entity.finalizeSpawn(context.level(), context.level().getCurrentDifficultyAt(position), VersionedEntitySpawnReason.STRUCTURE, null, null);

		entity.setPersistenceRequired();
		context.level().addFreshEntity(entity);
		return true;
	}
	*///?}
}
