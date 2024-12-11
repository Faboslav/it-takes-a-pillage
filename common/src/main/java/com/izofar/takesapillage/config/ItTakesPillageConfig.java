package com.izofar.takesapillage.config;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.config.annotation.Category;
import com.izofar.takesapillage.config.annotation.Description;
import com.izofar.takesapillage.config.omegaconfig.api.Config;

public final class ItTakesPillageConfig implements Config
{
	@Category("General")
	@Description("Replace all iron golems with clay golems")
	public boolean replaceIronGolemsWithClayGolems = false;

	@Description("Remove bad omen effect from game")
	public boolean removeBadOmen = false;

	@Description("Enabled pillage sieges")
	public boolean enablePillageSieges = true;

	@Category("Raids")
	@Description("Enable archer in raids")
	public boolean enableArcherInRaids = true;

	@Description("Enable legioner in raids")
	public boolean enableLegionerInRaids = true;

	@Description("Enable skirmisher in raids")
	public boolean enableSkirmisherInRaids = true;

	@Override
	public String getName() {
		return ItTakesPillage.MOD_ID;
	}
}
