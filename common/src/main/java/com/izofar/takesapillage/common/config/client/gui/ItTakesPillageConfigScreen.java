package com.izofar.takesapillage.common.config.client.gui;

import com.izofar.takesapillage.common.ItTakesPillage;
import net.minecraft.client.gui.screens.Screen;

//? if yacl {
import com.izofar.takesapillage.common.config.ItTakesPillageConfig;
import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionGroup;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import net.minecraft.network.chat.Component;
import java.util.function.Consumer;
import java.util.function.Supplier;
//?}


public final class ItTakesPillageConfigScreen
{
	public Screen generateScreen(Screen parent) {
		//? if yacl {
		var config = ItTakesPillage.getConfig();

		return YetAnotherConfigLib.createBuilder()
			.title(Component.translatable("yacl3.config.takesapillage:takesapillage"))
			.category(ConfigCategory.createBuilder()
				.name(Component.translatable("yacl3.config.takesapillage:takesapillage.category.general"))
				.group(group("general", "pillage_siege")
					.option(bool("enablePillageSieges", ItTakesPillageConfig.ENABLE_PILLAGE_SIEGES_DEFAULT_VALUE, () -> config.enablePillageSieges, value -> config.enablePillageSieges = value))
					.build())
				.build())
			.category(ConfigCategory.createBuilder()
				.name(Component.translatable("yacl3.config.takesapillage:takesapillage.category.mobs"))
				.group(group("mobs", "clay_golem")
					.option(bool("enableClayGolem", ItTakesPillageConfig.ENABLE_CLAY_GOLEM_DEFAULT_VALUE, () -> config.enableClayGolem, value -> config.enableClayGolem = value))
					.option(bool("replaceIronGolemsWithClayGolems", ItTakesPillageConfig.REPLACE_IRON_GOLEMS_WITH_CLAY_GOLEMS_DEFAULT_VALUE, () -> config.replaceIronGolemsWithClayGolems, value -> config.replaceIronGolemsWithClayGolems = value))
					.build())
				.group(group("mobs", "archer")
					.option(bool("enableArcher", ItTakesPillageConfig.ENABLE_ARCHER_DEFAULT_VALUE, () -> config.enableArcher, value -> config.enableArcher = value))
					.option(bool("enableArcherInRaids", ItTakesPillageConfig.ENABLE_ARCHER_IN_RAIDS_DEFAULT_VALUE, () -> config.enableArcherInRaids, value -> config.enableArcherInRaids = value))
					.build())
				.group(group("mobs", "legioner")
					.option(bool("enableLegioner", ItTakesPillageConfig.ENABLE_LEGIONER_DEFAULT_VALUE, () -> config.enableLegioner, value -> config.enableLegioner = value))
					.option(bool("enableLegionerInRaids", ItTakesPillageConfig.ENABLE_LEGIONER_IN_RAIDS_DEFAULT_VALUE, () -> config.enableLegionerInRaids, value -> config.enableLegionerInRaids = value))
					.build())
				.group(group("mobs", "skirmisher")
					.option(bool("enableSkirmisher", ItTakesPillageConfig.ENABLE_SKIRMISHER_DEFAULT_VALUE, () -> config.enableSkirmisher, value -> config.enableSkirmisher = value))
					.option(bool("enableSkirmisherInRaids", ItTakesPillageConfig.ENABLE_SKIRMISHER_IN_RAIDS_DEFAULT_VALUE, () -> config.enableSkirmisherInRaids, value -> config.enableSkirmisherInRaids = value))
					.build())
				.build())
			.save(ItTakesPillageConfig::save)
			.build()
			.generateScreen(parent);
		//?} else {
		//return null;
		 //?}
	}

	//? if yacl {
	private static OptionGroup.Builder group(String category, String group) {
		return OptionGroup.createBuilder()
			.name(Component.translatable("yacl3.config.takesapillage:takesapillage.category." + category + ".group." + group));
	}

	private static Option<Boolean> bool(String key, boolean initialValue, Supplier<Boolean> getter, Consumer<Boolean> setter) {
		return Option.<Boolean>createBuilder()
			.name(Component.translatable("yacl3.config.takesapillage:takesapillage." + key))
			.binding(initialValue, getter, setter)
			.controller(opt -> BooleanControllerBuilder.create(opt).formatValue(val -> val ? Component.literal("Yes") : Component.literal("No")).coloured(true))
			.build();
	}
	//?}
}