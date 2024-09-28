package com.izofar.takesapillage.util;

import com.google.common.collect.ImmutableList;
import com.izofar.takesapillage.init.ItTakesPillageEntityTypes;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.AbstractIllager;

public final class MobLists
{
	public static final WeightedRandomList<MobWeightedEntry<EntityType<? extends AbstractIllager>>> PILLAGER_CAMP_LIST = WeightedRandomList.create(ImmutableList.of(new MobWeightedEntry(EntityType.PILLAGER, 15), new MobWeightedEntry(ItTakesPillageEntityTypes.SKIRMISHER.get(), 12), new MobWeightedEntry(ItTakesPillageEntityTypes.ARCHER.get(), 8), new MobWeightedEntry(EntityType.VINDICATOR, 5), new MobWeightedEntry(EntityType.WITCH, 3), new MobWeightedEntry(EntityType.EVOKER, 1)));
	public static final WeightedRandomList<MobWeightedEntry<EntityType<? extends AbstractIllager>>> PILLAGER_SIEGE_LIST = WeightedRandomList.create(ImmutableList.of(new MobWeightedEntry(EntityType.PILLAGER, 8), new MobWeightedEntry(ItTakesPillageEntityTypes.SKIRMISHER.get(), 6), new MobWeightedEntry(ItTakesPillageEntityTypes.ARCHER.get(), 6), new MobWeightedEntry(ItTakesPillageEntityTypes.LEGIONER.get(), 4), new MobWeightedEntry(EntityType.VINDICATOR, 3)));
	public static final WeightedRandomList<MobWeightedEntry<EntityType<? extends AbstractIllager>>> RANGED_ILLAGER_LIST = WeightedRandomList.create(ImmutableList.of(new MobWeightedEntry(EntityType.PILLAGER, 1), new MobWeightedEntry(ItTakesPillageEntityTypes.ARCHER.get(), 2)));
	public static final WeightedRandomList<MobWeightedEntry<EntityType<? extends Animal>>> LIVESTOCK_LIST = WeightedRandomList.create(ImmutableList.of(new MobWeightedEntry(EntityType.COW, 4), new MobWeightedEntry(EntityType.CHICKEN, 3), new MobWeightedEntry(EntityType.SHEEP, 6), new MobWeightedEntry(EntityType.DONKEY, 1), new MobWeightedEntry(EntityType.HORSE, 2)));
	public static final WeightedRandomList<MobWeightedEntry<EntityType<? extends Mob>>> PRISONER_LIST = WeightedRandomList.create(ImmutableList.of(new MobWeightedEntry(EntityType.IRON_GOLEM, 4), new MobWeightedEntry(EntityType.VILLAGER, 3), new MobWeightedEntry(ItTakesPillageEntityTypes.CLAY_GOLEM.get(), 3)));
	public static final WeightedRandomList<MobWeightedEntry<EntityType<? extends AbstractIllager>>> BASTILLE_LIST = WeightedRandomList.create(ImmutableList.of(new MobWeightedEntry(ItTakesPillageEntityTypes.LEGIONER.get(), 15), new MobWeightedEntry(ItTakesPillageEntityTypes.SKIRMISHER.get(), 12), new MobWeightedEntry(ItTakesPillageEntityTypes.ARCHER.get(), 8), new MobWeightedEntry(EntityType.PILLAGER, 7), new MobWeightedEntry(EntityType.VINDICATOR, 5), new MobWeightedEntry(EntityType.WITCH, 4), new MobWeightedEntry(EntityType.EVOKER, 1)));
	public static final WeightedRandomList<MobWeightedEntry<EntityType<? extends Mob>>> CAPTIVE_LIST = WeightedRandomList.create(ImmutableList.of(new MobWeightedEntry(EntityType.VILLAGER, 5), new MobWeightedEntry(ItTakesPillageEntityTypes.CLAY_GOLEM.get(), 3), new MobWeightedEntry(EntityType.IRON_GOLEM, 2)));
}
