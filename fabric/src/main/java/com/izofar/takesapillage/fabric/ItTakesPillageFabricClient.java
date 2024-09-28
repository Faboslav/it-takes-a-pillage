package com.izofar.takesapillage.fabric;

import com.izofar.takesapillage.ItTakesPillageClient;
import com.izofar.takesapillage.event.client.RegisterEntityModelLayersEvent;
import com.izofar.takesapillage.event.client.RegisterEntityRenderersEvent;
import com.izofar.takesapillage.event.client.RegisterItemColorEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public final class ItTakesPillageFabricClient implements ClientModInitializer
{
	@Override
	@Environment(EnvType.CLIENT)
	public void onInitializeClient() {
		ItTakesPillageClient.init();

		RegisterEntityRenderersEvent.EVENT.invoke(new RegisterEntityRenderersEvent(EntityRendererRegistry::register));
		RegisterEntityModelLayersEvent.EVENT.invoke(new RegisterEntityModelLayersEvent((type, supplier) -> EntityModelLayerRegistry.registerModelLayer(type, supplier::get)));
		RegisterItemColorEvent.EVENT.invoke(
			new RegisterItemColorEvent(
				ColorProviderRegistry.ITEM::register,
				(state, level, pos, i) -> ColorProviderRegistry.BLOCK.get(state.getBlock()).getColor(state, level, pos, i)
			)
		);
	}
}

