package com.izofar.takesapillage.forge;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.event.entity.EntitySpawnEvent;
import com.izofar.takesapillage.event.entity.RegisterEntityAttributesEvent;
import com.izofar.takesapillage.event.lifecycle.ServerLevelTickEvent;
import com.izofar.takesapillage.event.lifecycle.SetupEvent;
import com.izofar.takesapillage.init.ItTakesPillageEntityTypes;
import com.izofar.takesapillage.util.CustomRaidMember;
import net.minecraft.world.entity.raid.Raid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(ItTakesPillage.MOD_ID)
public final class ItTakesPillageForge
{
	public ItTakesPillageForge() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus eventBus = MinecraftForge.EVENT_BUS;

		ItTakesPillage.init();

		if (FMLEnvironment.dist == Dist.CLIENT) {
			ItTakesPillageForgeClient.init(modEventBus, eventBus);
		}

		eventBus.addListener(ItTakesPillageForge::onLevelTickPost);
		eventBus.addListener(ItTakesPillageForge::onEntitySpawn);

		modEventBus.addListener(ItTakesPillageForge::onSetup);
		modEventBus.addListener(ItTakesPillageForge::onRegisterAttributes);
	}

	private static void onSetup(final FMLCommonSetupEvent event) {
		SetupEvent.EVENT.invoke(new SetupEvent(event::enqueueWork));

		event.enqueueWork(() -> {
			if (ItTakesPillage.getConfig().enableArcherInRaids) {
				Raid.RaiderType.create(
					CustomRaidMember.ARCHER_INTERNAL_NAME,
					ItTakesPillageEntityTypes.ARCHER.get(),
					CustomRaidMember.ARCHER_COUNT_IN_WAVES
				);
			}

			if (ItTakesPillage.getConfig().enableSkirmisherInRaids) {
				Raid.RaiderType.create(
					CustomRaidMember.SKIRMISHER_INTERNAL_NAME,
					ItTakesPillageEntityTypes.SKIRMISHER.get(),
					CustomRaidMember.SKIRMISHER_COUNT_IN_WAVES
				);
			}

			if (ItTakesPillage.getConfig().enableLegionerInRaids) {
				Raid.RaiderType.create(
					CustomRaidMember.LEGIONER_INTERNAL_NAME,
					ItTakesPillageEntityTypes.LEGIONER.get(),
					CustomRaidMember.LEGIONER_COUNT_IN_WAVES
				);
			}
		});
	}

	private static void onLevelTickPost(TickEvent.LevelTickEvent event) {
		if (
			event.phase != TickEvent.Phase.END
			|| event.level.isClientSide()
		) {
			return;
		}
		ServerLevelTickEvent.EVENT.invoke(new ServerLevelTickEvent(event.level, true));
	}

	private static void onRegisterAttributes(EntityAttributeCreationEvent event) {
		RegisterEntityAttributesEvent.EVENT.invoke(new RegisterEntityAttributesEvent((entity, builder) -> event.put(entity, builder.build())));
	}

	private static void onEntitySpawn(MobSpawnEvent.FinalizeSpawn event) {
		boolean cancel = EntitySpawnEvent.EVENT.invoke(new EntitySpawnEvent(event.getEntity(), event.getLevel(), event.getEntity().isBaby(), event.getSpawnType()), event.isCanceled());
		if (cancel) {
			event.setCanceled(true);
			event.setSpawnCancelled(true);
		}
	}
}
