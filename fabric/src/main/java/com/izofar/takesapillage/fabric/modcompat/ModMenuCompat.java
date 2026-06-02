package com.izofar.takesapillage.fabric.modcompat;

//? if modMenu {
import com.izofar.takesapillage.common.ItTakesPillageClient;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;

public final class ModMenuCompat implements ModMenuApi
{
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return (screen) -> {
			if (!FabricLoader.getInstance().isModLoaded("yet_another_config_lib_v3")) {
				return null;
			}

			return ItTakesPillageClient.getConfigScreen(screen);
		};
	}
}
//?}