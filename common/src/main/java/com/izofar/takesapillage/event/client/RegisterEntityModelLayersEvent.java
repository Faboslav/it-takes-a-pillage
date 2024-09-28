package com.izofar.takesapillage.event.client;

import com.izofar.takesapillage.event.base.EventHandler;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public record RegisterEntityModelLayersEvent(BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> registrar)
{
	public static final EventHandler<RegisterEntityModelLayersEvent> EVENT = new EventHandler<>();

	public void register(ModelLayerLocation location, Supplier<LayerDefinition> definition) {
		registrar.accept(location, definition);
	}
}
