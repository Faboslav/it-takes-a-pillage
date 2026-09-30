package com.izofar.takesapillage.common.config;

public final class ItTakesPillageConfig
{
	public static final boolean ENABLE_PILLAGE_SIEGES_DEFAULT_VALUE = true;

	public static final boolean ENABLE_CLAY_GOLEM_DEFAULT_VALUE = true;
	public static final boolean REPLACE_IRON_GOLEMS_WITH_CLAY_GOLEMS_DEFAULT_VALUE = false;

	public static final boolean ENABLE_ARCHER_DEFAULT_VALUE = true;
	public static final boolean ENABLE_ARCHER_IN_RAIDS_DEFAULT_VALUE = true;

	public static final boolean ENABLE_LEGIONER_DEFAULT_VALUE = true;
	public static final boolean ENABLE_LEGIONER_IN_RAIDS_DEFAULT_VALUE = true;

	public static final boolean ENABLE_SKIRMISHER_DEFAULT_VALUE = true;
	public static final boolean ENABLE_SKIRMISHER_IN_RAIDS_DEFAULT_VALUE = true;

	public boolean enablePillageSieges = ENABLE_PILLAGE_SIEGES_DEFAULT_VALUE;

	public boolean enableClayGolem = ENABLE_CLAY_GOLEM_DEFAULT_VALUE;
	public boolean replaceIronGolemsWithClayGolems = REPLACE_IRON_GOLEMS_WITH_CLAY_GOLEMS_DEFAULT_VALUE;

	public boolean enableArcher = ENABLE_ARCHER_DEFAULT_VALUE;
	public boolean enableArcherInRaids = ENABLE_ARCHER_IN_RAIDS_DEFAULT_VALUE;

	public boolean enableLegioner = ENABLE_LEGIONER_DEFAULT_VALUE;
	public boolean enableLegionerInRaids = ENABLE_LEGIONER_IN_RAIDS_DEFAULT_VALUE;

	public boolean enableSkirmisher = ENABLE_SKIRMISHER_DEFAULT_VALUE;
	public boolean enableSkirmisherInRaids = ENABLE_SKIRMISHER_IN_RAIDS_DEFAULT_VALUE;

	public static void load() {
		ItTakesPillageConfigSerializer.load();
	}

	public static void save() {
		ItTakesPillageConfigSerializer.save();
	}
}