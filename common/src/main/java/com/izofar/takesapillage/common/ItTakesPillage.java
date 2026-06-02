package com.izofar.takesapillage.common;

import com.izofar.takesapillage.common.config.ItTakesPillageConfig;
import com.izofar.takesapillage.common.entity.event.IronGolemOnEntitySpawn;
import com.izofar.takesapillage.common.event.AddItemGroupEntriesEvent;
import com.izofar.takesapillage.common.event.entity.EntitySpawnEvent;
import com.izofar.takesapillage.common.event.entity.RegisterEntityAttributesEvent;
import com.izofar.takesapillage.common.event.lifecycle.ServerLevelTickEvent;
import com.izofar.takesapillage.common.init.*;
import com.izofar.takesapillage.common.versions.VersionedGameRulesProvider;
import com.izofar.takesapillage.common.world.PillageSiege;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//? if <= 1.21.11 {
/*import com.izofar.takesapillage.common.event.lifecycle.SetupEvent;
*///?}

public class ItTakesPillage
{
	public static final String MOD_ID = "takesapillage";
	public static final Logger LOGGER = LogManager.getLogger();
	private static final ItTakesPillageConfig CONFIG = new ItTakesPillageConfig();

	public static ItTakesPillageConfig getConfig() {
		return CONFIG;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static Identifier makeId(String path) {
		return ItTakesPillage.makeId(MOD_ID, path);
	}

	public static Identifier makeId(String id, String path) {
		/*? >= 1.21 {*/
		return Identifier.tryBuild(
			id,
			path
		);
		/*?} else {*/
		/*return new Identifier(
			id,
			path
		);
		*//*?}*/
	}

	public static Identifier makeVanillaId(String id) {
		/*? >= 1.21 {*/
		return Identifier.parse(
			id
		);
		/*?} else {*/
		/*return new Identifier(
			id
		);
		*//*?}*/
	}

	public static void init() {
		ItTakesPillage.getConfig().load();
		ItTagesPillageTags.init();

		//? if <= 1.21.11 {
		/*SetupEvent.EVENT.addListener(ItTakesPillageItems::registerSpawnEggs);
		*///?}

		ItTakesPillageEntityTypes.ENTITY_TYPES.init();
		ItTakesPillageFeatures.FEATURES.init();
		//? if <1.21.3 {
		/*ItTakesPillageInstruments.INSTRUMENTS.init();
		*///?}
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

			if (level != null && VersionedGameRulesProvider.getBoolean((ServerLevel) level, VersionedGameRulesProvider.SPAWN_MOBS) && level.dimension() == Level.OVERWORLD) {
				//? if >= 1.21.9 {
				PillageSiege.PILLAGE_SIEGE.tick((ServerLevel) level, true);
				//?} else {
				/*PillageSiege.PILLAGE_SIEGE.tick((ServerLevel) level, true, false);
				*///?}
			}
		}
	}
}
