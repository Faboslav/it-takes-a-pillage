package com.izofar.takesapillage.neoforge;

import com.izofar.takesapillage.common.ItTakesPillageClient;
import com.izofar.takesapillage.common.config.ItTakesPillageConfig;
import com.izofar.takesapillage.common.event.client.RegisterEntityModelLayersEvent;
import com.izofar.takesapillage.common.event.client.RegisterEntityRenderersEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

//? if <1.21.3 {
/*import com.izofar.takesapillage.common.event.client.RegisterItemPropertiesEvent;
import net.minecraft.client.renderer.item.ItemProperties;
*///?}

public final class ItTakesPillageNeoForgeClient
{
	public static void init(IEventBus modEventBus, IEventBus eventBus) {
		ItTakesPillageClient.init();

		modEventBus.addListener(ItTakesPillageNeoForgeClient::onClientSetup);
		modEventBus.addListener(ItTakesPillageNeoForgeClient::onRegisterEntityRenderers);
		modEventBus.addListener(ItTakesPillageNeoForgeClient::onRegisterEntityModelLayers);
	}

	private static void onClientSetup(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			if (ModList.get().isLoaded("yet_another_config_lib_v3")) {
				ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (client, screen) -> {
					return ItTakesPillageConfig.HANDLER.generateGui().generateScreen(screen);
				});
			}

			//? if <1.21.3 {
			/*RegisterItemPropertiesEvent.EVENT.invoke(new RegisterItemPropertiesEvent(ItemProperties::register));
			*///?}
		});
	}

	private static void onRegisterEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		RegisterEntityRenderersEvent.EVENT.invoke(new RegisterEntityRenderersEvent(event::registerEntityRenderer));
	}

	private static void onRegisterEntityModelLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		RegisterEntityModelLayersEvent.EVENT.invoke(new RegisterEntityModelLayersEvent(event::registerLayerDefinition));
	}
}
