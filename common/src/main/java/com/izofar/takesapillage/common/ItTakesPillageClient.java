package com.izofar.takesapillage.common;

import com.izofar.takesapillage.common.config.client.gui.ItTakesPillageConfigScreen;
import com.izofar.takesapillage.common.event.client.RegisterEntityModelLayersEvent;
import com.izofar.takesapillage.common.event.client.RegisterEntityRenderersEvent;
import com.izofar.takesapillage.common.init.ItTakesPillageEntityModelLayers;
import com.izofar.takesapillage.common.init.ItTakesPillageEntityRenderers;
import com.izofar.takesapillage.common.platform.PlatformHooks;
import net.minecraft.client.gui.screens.Screen;

//? if <1.21.3 {
/*import com.izofar.takesapillage.common.event.client.RegisterItemPropertiesEvent;
import com.izofar.takesapillage.common.init.ItTakesPillageItems;
*///?}

public final class ItTakesPillageClient
{
	public static void init() {
		RegisterEntityRenderersEvent.EVENT.addListener(ItTakesPillageEntityRenderers::registerEntityRenderers);
		RegisterEntityModelLayersEvent.EVENT.addListener(ItTakesPillageEntityModelLayers::registerEntityModelLayers);
		//? if <1.21.3 {
		/*RegisterItemPropertiesEvent.EVENT.addListener(ItTakesPillageItems::registerItemProperties);
		*///?}
	}

	public static Screen getConfigScreen(Screen screen) {
		if(!PlatformHooks.PLATFORM_HELPER.isModLoaded("yet_another_config_lib_v3")) {
			return null;
		}

		return new ItTakesPillageConfigScreen().generateScreen(screen);
	}
}
