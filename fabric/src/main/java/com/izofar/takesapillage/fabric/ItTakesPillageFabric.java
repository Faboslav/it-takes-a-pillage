package com.izofar.takesapillage.fabric;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.event.entity.RegisterEntityAttributesEvent;
import com.izofar.takesapillage.event.lifecycle.ServerLevelTickEvent;
import com.izofar.takesapillage.event.lifecycle.SetupEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public final class ItTakesPillageFabric implements ModInitializer
{
	@Override
	public void onInitialize() {
		ItTakesPillage.init();

		SetupEvent.EVENT.invoke(new SetupEvent(Runnable::run));
		ServerTickEvents.END_WORLD_TICK.register(world -> ServerLevelTickEvent.EVENT.invoke(new ServerLevelTickEvent(world, true)));
		RegisterEntityAttributesEvent.EVENT.invoke(new RegisterEntityAttributesEvent(FabricDefaultAttributeRegistry::register));
	}
}
