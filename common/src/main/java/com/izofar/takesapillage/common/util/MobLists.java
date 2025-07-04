package com.izofar.takesapillage.common.util;

import com.google.common.collect.ImmutableList;
import com.izofar.takesapillage.common.init.ItTakesPillageEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.raid.Raider;

//? if >=1.21.5 {
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
//?} else {
/*import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.util.random.WeightedEntry;
*///?}


@SuppressWarnings("unchecked")
public final class MobLists
{
	public static final /*? >=1.21.5 {*/WeightedList<EntityType<? extends Raider>>/*?} else {*//*WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends AbstractIllager>>>*//*?}*/ PILLAGER_CAMP_LIST = createWeightedList(ImmutableList.of(createWeightedEntry(EntityType.PILLAGER, 15), createWeightedEntry(EntityType.PILLAGER, 15), createWeightedEntry(ItTakesPillageEntityTypes.SKIRMISHER.get(), 12), createWeightedEntry(ItTakesPillageEntityTypes.ARCHER.get(), 8), createWeightedEntry(EntityType.VINDICATOR, 5), createWeightedEntry(EntityType.WITCH, 3), createWeightedEntry(EntityType.EVOKER, 1)));
	public static final /*? >=1.21.5 {*/WeightedList<EntityType<? extends AbstractIllager>>/*?} else {*//*WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends AbstractIllager>>>*//*?}*/ PILLAGER_SIEGE_LIST = createWeightedList(ImmutableList.of(createWeightedEntry(EntityType.PILLAGER, 8), createWeightedEntry(ItTakesPillageEntityTypes.SKIRMISHER.get(), 6), createWeightedEntry(ItTakesPillageEntityTypes.ARCHER.get(), 6), createWeightedEntry(ItTakesPillageEntityTypes.LEGIONER.get(), 4), createWeightedEntry(EntityType.VINDICATOR, 3)));
	public static final /*? >=1.21.5 {*/WeightedList<EntityType<? extends AbstractIllager>>/*?} else {*//*WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends AbstractIllager>>>*//*?}*/ RANGED_ILLAGER_LIST = createWeightedList(ImmutableList.of(createWeightedEntry(EntityType.PILLAGER, 1), createWeightedEntry(ItTakesPillageEntityTypes.ARCHER.get(), 2)));
	public static final /*? >=1.21.5 {*/WeightedList<EntityType<? extends Animal>>/*?} else {*//*WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends Animal>>>*//*?}*/ LIVESTOCK_LIST = createWeightedList(ImmutableList.of(createWeightedEntry(EntityType.COW, 4), createWeightedEntry(EntityType.CHICKEN, 3), createWeightedEntry(EntityType.SHEEP, 6), createWeightedEntry(EntityType.DONKEY, 1), createWeightedEntry(EntityType.HORSE, 2)));
	public static final /*? >=1.21.5 {*/WeightedList<EntityType<? extends Mob>>/*?} else {*//*WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends Mob>>>*//*?}*/ PRISONER_LIST = createWeightedList(ImmutableList.of(createWeightedEntry(EntityType.IRON_GOLEM, 4), createWeightedEntry(EntityType.VILLAGER, 3), createWeightedEntry(ItTakesPillageEntityTypes.CLAY_GOLEM.get(), 3)));
	public static final /*? >=1.21.5 {*/WeightedList<EntityType<? extends Raider>>/*?} else {*//*WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends Raider>>>*//*?}*/ BASTILLE_LIST = createWeightedList(ImmutableList.of(createWeightedEntry(ItTakesPillageEntityTypes.LEGIONER.get(), 15), createWeightedEntry(ItTakesPillageEntityTypes.SKIRMISHER.get(), 12), createWeightedEntry(ItTakesPillageEntityTypes.ARCHER.get(), 8), createWeightedEntry(EntityType.PILLAGER, 7), createWeightedEntry(EntityType.VINDICATOR, 5), createWeightedEntry(EntityType.WITCH, 4), createWeightedEntry(EntityType.EVOKER, 1)));
	public static final /*? >=1.21.5 {*/WeightedList<EntityType<? extends Mob>>/*?} else {*//*WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends Mob>>>*//*?}*/ CAPTIVE_LIST = createWeightedList(ImmutableList.of(createWeightedEntry(EntityType.VILLAGER, 5), createWeightedEntry(ItTakesPillageEntityTypes.CLAY_GOLEM.get(), 3), createWeightedEntry(EntityType.IRON_GOLEM, 2)));

	//? >=1.21.5 {
	public static <T extends Mob> WeightedList<EntityType<? extends T>> createWeightedList(
		ImmutableList<Weighted<EntityType<? extends T>>> entries
	)
	//?} else {
	/*public static <T extends Mob> WeightedRandomList<WeightedEntry.Wrapper<EntityType<? extends T>>> createWeightedList(ImmutableList list)
	*///?}
	{
		//? >=1.21.5 {
		return WeightedList.of(entries);
		//?} else {
		/*return WeightedRandomList.create(list);
		*///?}
	}

	//? >=1.21.5 {
	public static <T extends Mob> Weighted<EntityType<? extends T>> createWeightedEntry(EntityType<? extends T> entityType, int weight)
	//?} else {
	/*public static WeightedEntry.Wrapper<EntityType<? extends Mob>> createWeightedEntry(EntityType<? extends Mob> entityType, int weight)
	*///?}
	{
		//? >=1.21.5 {
		return new Weighted<>(entityType, weight);
		//?} else {
		/*return WeightedEntry.wrap(entityType, weight);
		*///?}
	}
}
