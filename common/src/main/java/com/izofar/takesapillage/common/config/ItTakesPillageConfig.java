package com.izofar.takesapillage.common.config;

import com.izofar.takesapillage.common.ItTakesPillage;

public final class ItTakesPillageConfig
{
	public boolean enablePillageSieges = true;
	public boolean enableClayGolem = true;
	public boolean replaceIronGolemsWithClayGolems = false;
	public boolean enableArcher = true;
	public boolean enableArcherInRaids = true;
	public boolean enableLegioner = true;
	public boolean enableLegionerInRaids = true;
	public boolean enableSkirmisher = true;
	public boolean enableSkirmisherInRaids = true;

	public static void load() {
		ItTakesPillageConfigSerializer.load();
	}

	public static void save() {
		ItTakesPillageConfigSerializer.save();
	}
}