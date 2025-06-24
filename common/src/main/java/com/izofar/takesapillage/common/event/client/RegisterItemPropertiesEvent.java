//? if <1.21.3 {
/*package com.izofar.takesapillage.common.event.client;

import com.izofar.takesapillage.common.event.base.EventHandler;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.apache.logging.log4j.util.TriConsumer;

public record RegisterItemPropertiesEvent(TriConsumer<Item, ResourceLocation, ClampedItemPropertyFunction> registrar)
{
	public static final EventHandler<RegisterItemPropertiesEvent> EVENT = new EventHandler<>();

	public void register(Item item, ResourceLocation id, ClampedItemPropertyFunction function) {
		registrar.accept(item, id, function);
	}
}
*///?}
