package com.izofar.takesapillage.neoforge;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.event.entity.EntitySpawnEvent;
import com.izofar.takesapillage.event.entity.RegisterEntityAttributesEvent;
import com.izofar.takesapillage.event.lifecycle.ServerLevelTickEvent;
import com.izofar.takesapillage.event.lifecycle.SetupEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

@Mod(ItTakesPillage.MOD_ID)
public final class ItTakesPillageNeoForge
{
	public ItTakesPillageNeoForge(ModContainer modContainer, IEventBus modEventBus) {
		var eventBus = NeoForge.EVENT_BUS;

		ItTakesPillage.init();

		if (FMLEnvironment.dist == Dist.CLIENT) {
			ItTakesPillageNeoForgeClient.init(modEventBus, eventBus);
		}

		eventBus.addListener(ItTakesPillageNeoForge::onLevelTickPost);
		eventBus.addListener(ItTakesPillageNeoForge::onEntitySpawn);

		modEventBus.addListener(ItTakesPillageNeoForge::onSetup);
		modEventBus.addListener(ItTakesPillageNeoForge::onRegisterAttributes);
	}

	private static void onSetup(final FMLCommonSetupEvent event) {
		// SetupEvent.EVENT.invoke(new SetupEvent(event::enqueueWork));
	}

	private static void onLevelTickPost(LevelTickEvent.Post event) {
		if (event.getLevel().isClientSide()) {
			return;
		}

		ServerLevelTickEvent.EVENT.invoke(new ServerLevelTickEvent(event.getLevel(), true));
	}

	private static void onRegisterAttributes(EntityAttributeCreationEvent event) {
		RegisterEntityAttributesEvent.EVENT.invoke(new RegisterEntityAttributesEvent((entity, builder) -> event.put(entity, builder.build())));
	}

	private static void onEntitySpawn(FinalizeSpawnEvent event) {
		boolean cancel = EntitySpawnEvent.EVENT.invoke(new EntitySpawnEvent(event.getEntity(), event.getLevel(), event.getEntity().isBaby(), event.getSpawnType()), event.isCanceled());
		if (cancel) {
			event.setCanceled(true);
			event.setSpawnCancelled(true);
		}
	}
}
