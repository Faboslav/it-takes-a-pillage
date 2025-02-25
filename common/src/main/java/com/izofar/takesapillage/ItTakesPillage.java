package com.izofar.takesapillage;

import com.izofar.takesapillage.config.ItTakesPillageConfig;
import com.izofar.takesapillage.config.omegaconfig.OmegaConfig;
import com.izofar.takesapillage.entity.event.IronGolemOnEntitySpawn;
import com.izofar.takesapillage.event.AddItemGroupEntriesEvent;
import com.izofar.takesapillage.event.entity.EntitySpawnEvent;
import com.izofar.takesapillage.event.entity.RegisterEntityAttributesEvent;
import com.izofar.takesapillage.event.lifecycle.ServerLevelTickEvent;
import com.izofar.takesapillage.event.lifecycle.SetupEvent;
import com.izofar.takesapillage.init.*;
import com.izofar.takesapillage.world.PillageSiege;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItTakesPillage
{
	public static final String MOD_ID = "takesapillage";
	public static final Logger LOGGER = LogManager.getLogger();
	private static final ItTakesPillageConfig CONFIG = OmegaConfig.register(ItTakesPillageConfig.class);

	public static ItTakesPillageConfig getConfig() {
		return CONFIG;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static ResourceLocation makeId(String path) {
		return ItTakesPillage.makeId(MOD_ID, path);
	}

	public static ResourceLocation makeId(String id, String path) {
		/*? >=1.21 {*/
		return ResourceLocation.tryBuild(
			id,
			path
		);
		/*?} else {*/
		/*return new ResourceLocation(
			id,
			path
		);
		*//*?}*/
	}

	public static ResourceLocation makeVanillaId(String id) {
		/*? >=1.21 {*/
		return ResourceLocation.parse(
			id
		);
		/*?} else {*/
		/*return new ResourceLocation(
			id
		);
		*//*?}*/
	}

	public static void init() {
		ItTagesPillageTags.init();

		ItTakesPillageEntityTypes.ENTITY_TYPES.init();
		ItTakesPillageFeatures.FEATURES.init();
		ItTakesPillageInstruments.INSTRUMENTS.init();
		ItTakesPillageItemGroups.ITEM_GROUPS.init();
		ItTakesPillageItems.ITEMS.init();
		ItTakesPillageSoundEvents.SOUND_EVENTS.init();
		ItTakesPillageStructureTypes.STRUCTURE_TYPES.init();

		EntitySpawnEvent.EVENT.addListener(IronGolemOnEntitySpawn::handleEntitySpawn);
		RegisterEntityAttributesEvent.EVENT.addListener(ItTakesPillageEntityTypes::registerEntityAttributes);
		ServerLevelTickEvent.EVENT.addListener(ItTakesPillage::registerPillageSiege);
		AddItemGroupEntriesEvent.EVENT.addListener(ItTakesPillageItemGroups::addItemGroupEntries);
	}

	private static void registerPillageSiege(ServerLevelTickEvent event) {
		if (event.end()) {
			var level = event.getLevel();

			if (level != null && level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING) && level.dimension() == Level.OVERWORLD) {
				PillageSiege.PILLAGE_SIEGE.tick((ServerLevel) level, true, false);
			}
		}
	}
}
