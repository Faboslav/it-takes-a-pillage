package com.izofar.takesapillage.forge;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.ItTakesPillageClient;
import com.izofar.takesapillage.config.ConfigScreenBuilder;
import com.izofar.takesapillage.event.client.RegisterEntityModelLayersEvent;
import com.izofar.takesapillage.event.client.RegisterEntityRenderersEvent;
import com.izofar.takesapillage.event.client.RegisterItemColorEvent;
import com.izofar.takesapillage.init.ItTakesPillageItems;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.item.DispenserAddedSpawnEgg;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@OnlyIn(Dist.CLIENT)
public final class ItTakesPillageForgeClient
{
	public static void init(IEventBus modEventBus, IEventBus eventBus) {
		ItTakesPillageClient.init();

		modEventBus.addListener(ItTakesPillageForgeClient::onClientSetup);
		modEventBus.addListener(ItTakesPillageForgeClient::onRegisterItemColors);
		modEventBus.addListener(ItTakesPillageForgeClient::onRegisterEntityRenderers);
		modEventBus.addListener(ItTakesPillageForgeClient::onRegisterEntityModelLayers);
	}

	private static void onClientSetup(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			if (ModList.get().isLoaded("cloth_config")) {
				ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
					new ConfigScreenHandler.ConfigScreenFactory(
						(mc, screen) -> ConfigScreenBuilder.createConfigScreen(ItTakesPillage.getConfig(), screen)
					)
				);
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
		ItTakesPillageItems.ITEMS.stream()
			.map(RegistryEntry::get)
			.filter(item -> item instanceof DispenserAddedSpawnEgg)
			.map(item -> (DispenserAddedSpawnEgg) item)
			.forEach(item -> event.register((stack, index) -> item.getColor(index), item));
	}
}
