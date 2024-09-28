package com.izofar.takesapillage;

import com.izofar.takesapillage.event.client.RegisterEntityModelLayersEvent;
import com.izofar.takesapillage.event.client.RegisterEntityRenderersEvent;
import com.izofar.takesapillage.event.client.RegisterItemPropertiesEvent;
import com.izofar.takesapillage.init.ItTakesPillageEntityModelLayers;
import com.izofar.takesapillage.init.ItTakesPillageEntityRenderers;
import com.izofar.takesapillage.init.ItTakesPillageItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public final class ItTakesPillageClient
{
	@Environment(EnvType.CLIENT)
	public static void init() {
		RegisterEntityRenderersEvent.EVENT.addListener(ItTakesPillageEntityRenderers::registerEntityRenderers);
		RegisterEntityModelLayersEvent.EVENT.addListener(ItTakesPillageEntityModelLayers::registerEntityModelLayers);
		RegisterItemPropertiesEvent.EVENT.addListener(ItTakesPillageItems::registerItemProperties);
	}
}
