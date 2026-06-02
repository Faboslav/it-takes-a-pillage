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
					.option(bool("enablePillageSieges", config.enablePillageSieges, () -> config.enablePillageSieges, value -> config.enablePillageSieges = value))
					.build())
				.build())
			.category(ConfigCategory.createBuilder()
				.name(Component.translatable("yacl3.config.takesapillage:takesapillage.category.mobs"))
				.group(group("mobs", "clay_golem")
					.option(bool("enableClayGolem", config.enableClayGolem, () -> config.enableClayGolem, value -> config.enableClayGolem = value))
					.option(bool("replaceIronGolemsWithClayGolems", config.replaceIronGolemsWithClayGolems, () -> config.replaceIronGolemsWithClayGolems, value -> config.replaceIronGolemsWithClayGolems = value))
					.build())
				.group(group("mobs", "archer")
					.option(bool("enableArcher", config.enableArcher, () -> config.enableArcher, value -> config.enableArcher = value))
					.option(bool("enableArcherInRaids", config.enableArcherInRaids, () -> config.enableArcherInRaids, value -> config.enableArcherInRaids = value))
					.build())
				.group(group("mobs", "legioner")
					.option(bool("enableLegioner", config.enableLegioner, () -> config.enableLegioner, value -> config.enableLegioner = value))
					.option(bool("enableLegionerInRaids", config.enableLegionerInRaids, () -> config.enableLegionerInRaids, value -> config.enableLegionerInRaids = value))
					.build())
				.group(group("mobs", "skirmisher")
					.option(bool("enableSkirmisher", config.enableSkirmisher, () -> config.enableSkirmisher, value -> config.enableSkirmisher = value))
					.option(bool("enableSkirmisherInRaids", config.enableSkirmisherInRaids, () -> config.enableSkirmisherInRaids, value -> config.enableSkirmisherInRaids = value))
					.build())
				.build())
			.save(ItTakesPillageConfig::save)
			.build()
			.generateScreen(parent);
		//?} else {
		/*return null;
		 *///?}
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