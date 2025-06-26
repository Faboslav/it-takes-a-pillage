package com.izofar.takesapillage.common.config;

import com.izofar.takesapillage.common.ItTakesPillage;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.autogen.*;
import dev.isxander.yacl3.config.v2.api.autogen.Boolean;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;

import java.nio.file.Path;

public final class ItTakesPillageConfig
{
	public static ConfigClassHandler<ItTakesPillageConfig> HANDLER = ConfigClassHandler.createBuilder(ItTakesPillageConfig.class)
		.id(ItTakesPillage.makeId(ItTakesPillage.MOD_ID))
		.serializer(config -> GsonConfigSerializerBuilder.create(config).setPath(Path.of("config", ItTakesPillage.MOD_ID + ".json")).build())
		.build();

	private static final String GENERAL_CATEGORY = "general";
	private static final String MOBS_CATEGORY = "mobs";

	private static final String CLAY_GOLEM_GROUP = "clay_golem";
	private static final String ARCHER_GROUP = "archer";
	private static final String LEGIONER_GROUP = "legioner";
	private static final String SKIRMISHER_GROUP = "skirmisher";

	@SerialEntry()
	@AutoGen(category = GENERAL_CATEGORY)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean enablePillageSieges = true;

	@SerialEntry()
	@AutoGen(category = MOBS_CATEGORY, group = CLAY_GOLEM_GROUP)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean enableClayGolem = true;

	@SerialEntry()
	@AutoGen(category = MOBS_CATEGORY, group = CLAY_GOLEM_GROUP)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean replaceIronGolemsWithClayGolems = false;

	@SerialEntry()
	@AutoGen(category = MOBS_CATEGORY, group = ARCHER_GROUP)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean enableArcher = true;

	@SerialEntry()
	@AutoGen(category = MOBS_CATEGORY, group = ARCHER_GROUP)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean enableArcherInRaids = true;

	@SerialEntry()
	@AutoGen(category = MOBS_CATEGORY, group = LEGIONER_GROUP)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean enableLegioner = true;

	@SerialEntry()
	@AutoGen(category = MOBS_CATEGORY, group = LEGIONER_GROUP)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean enableLegionerInRaids = true;


	@SerialEntry()
	@AutoGen(category = MOBS_CATEGORY, group = SKIRMISHER_GROUP)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean enableSkirmisher = true;

	@SerialEntry()
	@AutoGen(category = MOBS_CATEGORY, group = SKIRMISHER_GROUP)
	@Boolean(formatter = Boolean.Formatter.YES_NO, colored = true)
	public boolean enableSkirmisherInRaids = true;

	public void load() {
		HANDLER.load();
	}
}
