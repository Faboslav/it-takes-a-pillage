package com.izofar.takesapillage.modcompat.fabric;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.config.ConfigScreenBuilder;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;

public final class ModMenuCompat implements ModMenuApi
{
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return (parent) -> {
			if (FabricLoader.getInstance().isModLoaded("cloth-config")) {
				return ConfigScreenBuilder.createConfigScreen(ItTakesPillage.getConfig(), parent);
			}

			return null;
		};
	}
}