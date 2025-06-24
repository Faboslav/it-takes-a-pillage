package com.izofar.takesapillage.fabric;

import com.izofar.takesapillage.common.ItTakesPillageClient;
import com.izofar.takesapillage.common.event.client.RegisterEntityModelLayersEvent;
import com.izofar.takesapillage.common.event.client.RegisterEntityRenderersEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

//? if <1.21.3 {
/*import com.izofar.takesapillage.common.event.client.RegisterItemPropertiesEvent;
import net.minecraft.client.renderer.item.ItemProperties;
*///?}

public final class ItTakesPillageFabricClient implements ClientModInitializer
{
	@Override
	public void onInitializeClient() {
		ItTakesPillageClient.init();

		RegisterEntityRenderersEvent.EVENT.invoke(new RegisterEntityRenderersEvent(EntityRendererRegistry::register));
		RegisterEntityModelLayersEvent.EVENT.invoke(new RegisterEntityModelLayersEvent((type, supplier) -> EntityModelLayerRegistry.registerModelLayer(type, supplier::get)));

		//? if <1.21.3 {
		/*RegisterItemPropertiesEvent.EVENT.invoke(new RegisterItemPropertiesEvent(ItemProperties::register));
		*///?}
	}
}

