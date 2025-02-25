package com.izofar.takesapillage.fabric;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.event.AddItemGroupEntriesEvent;
import com.izofar.takesapillage.event.entity.RegisterEntityAttributesEvent;
import com.izofar.takesapillage.event.lifecycle.ServerLevelTickEvent;
import com.izofar.takesapillage.event.lifecycle.SetupEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.registries.BuiltInRegistries;

public final class ItTakesPillageFabric implements ModInitializer
{
	@Override
	public void onInitialize() {
		ItTakesPillage.init();

		SetupEvent.EVENT.invoke(new SetupEvent(Runnable::run));
		ItemGroupEvents.MODIFY_ENTRIES_ALL.register((itemGroup, entries) ->
			AddItemGroupEntriesEvent.EVENT.invoke(
				new AddItemGroupEntriesEvent(
					AddItemGroupEntriesEvent.Type.toType(BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(itemGroup).orElse(null)),
					itemGroup,
					itemGroup.hasAnyItems(),
					entries::accept
				)
			)
		);
		ServerTickEvents.END_WORLD_TICK.register(world -> ServerLevelTickEvent.EVENT.invoke(new ServerLevelTickEvent(world, true)));
		RegisterEntityAttributesEvent.EVENT.invoke(new RegisterEntityAttributesEvent(FabricDefaultAttributeRegistry::register));
	}
}
