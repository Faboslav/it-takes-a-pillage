package com.izofar.takesapillage.neoforge;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.ItTakesPillageClient;
import com.izofar.takesapillage.config.ConfigScreenBuilder;
import com.izofar.takesapillage.event.client.RegisterEntityModelLayersEvent;
import com.izofar.takesapillage.event.client.RegisterEntityRenderersEvent;
import com.izofar.takesapillage.event.client.RegisterItemColorEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public final class ItTakesPillageNeoForgeClient
{
	public static void init(IEventBus modEventBus, IEventBus eventBus) {
		ItTakesPillageClient.init();

		modEventBus.addListener(ItTakesPillageNeoForgeClient::onClientSetup);
		modEventBus.addListener(ItTakesPillageNeoForgeClient::onRegisterItemColors);
		modEventBus.addListener(ItTakesPillageNeoForgeClient::onRegisterEntityRenderers);
		modEventBus.addListener(ItTakesPillageNeoForgeClient::onRegisterEntityModelLayers);
	}

	private static void onClientSetup(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			if (ModList.get().isLoaded("cloth_config")) {
				ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (client, screen) -> {
					return ConfigScreenBuilder.createConfigScreen(ItTakesPillage.getConfig(), screen);
				});
			}
		});
	}

	private static void onRegisterEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		RegisterEntityRenderersEvent.EVENT.invoke(new RegisterEntityRenderersEvent(event::registerEntityRenderer));
	}

	private static void onRegisterEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		RegisterEntityModelLayersEvent.EVENT.invoke(new RegisterEntityModelLayersEvent(event::registerLayerDefinition));
	}

	private static void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
		RegisterItemColorEvent.EVENT.invoke(new RegisterItemColorEvent(event::register, event.getBlockColors()::getColor));
	}
}
