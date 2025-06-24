package com.izofar.takesapillage.fabric.modcompat;

import com.izofar.takesapillage.common.config.ItTakesPillageConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;

public final class ModMenuCompat implements ModMenuApi
{
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return (parent) -> {
			if (!FabricLoader.getInstance().isModLoaded("yet_another_config_lib_v3")) {
				return null;
			}

			return ItTakesPillageConfig.HANDLER.generateGui().generateScreen(parent);
		};
	}
}