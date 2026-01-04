package com.izofar.takesapillage.common.world.feature;

import com.google.common.collect.ImmutableList;
import com.izofar.takesapillage.common.util.MobLists;
import com.izofar.takesapillage.common.versions.VersionedEntitySpawnReason;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import java.util.function.Supplier;

//? if >=1.21.5 {
/*import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
*///?} else {
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
//?}

public class MobFeature<T extends Mob> extends Feature<NoneFeatureConfiguration>
{
	//? if >=1.21.5 {
	/*private final Supplier<WeightedList<EntityType<? extends T>>> entityTypes;
	*///?} else {
	private final Supplier<WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends T>>>> entityTypes;
	//?}

	public MobFeature(
		//? if >=1.21.5 {
		/*Supplier<WeightedList<EntityType<? extends T>>> entityTypes
		*///?} else {
		Supplier<WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends T>>>> entityTypes
		//?}
	) {
		super(NoneFeatureConfiguration.CODEC);
		this.entityTypes = entityTypes;
	}

	public MobFeature(EntityType<? extends T> entityType) {
		super(NoneFeatureConfiguration.CODEC);
		this.entityTypes = () -> MobLists.createWeightedList(ImmutableList.of(MobLists.createWeightedEntry(entityType, 1)));
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		BlockPos position = context.origin().below();
		//? if >=1.21.5 {
		/*var entityType = this.entityTypes.get().getRandom(context.random()).get();
		 *///?} else if >=1.21.1 {
		/*var entityType = this.entityTypes.get().getRandom(context.random()).get().data();
		*///?} else {
		var entityType = this.entityTypes.get().getRandom(context.random()).get().getData();
		//?}
		var entity = entityType.create(context.level().getLevel()/*? >=1.21.3 {*//*, VersionedEntitySpawnReason.STRUCTURE*//*?}*/);

		if (entity == null) {
			return false;
		}

		//? >=1.21.5 {
		/*entity.snapTo(position.getX() + 0.5D, position.getY(), position.getZ() + 0.5D, 0.0F, 0.0F);
		*///?} else {
		entity.moveTo(position.getX() + 0.5D, position.getY(), position.getZ() + 0.5D, 0.0F, 0.0F);
		//?}
		//? if >=1.21.1 {
		/*entity.finalizeSpawn(context.level(), context.level().getCurrentDifficultyAt(position), VersionedEntitySpawnReason.STRUCTURE, null);
		*///?} else {
		entity.finalizeSpawn(context.level(), context.level().getCurrentDifficultyAt(position), VersionedEntitySpawnReason.STRUCTURE, null, null);
		//?}

		entity.setPersistenceRequired();
		context.level().addFreshEntity(entity);
		return true;
	}
}