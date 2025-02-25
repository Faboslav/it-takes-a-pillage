package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.entity.Archer;
import com.izofar.takesapillage.entity.ClayGolem;
import com.izofar.takesapillage.entity.Legioner;
import com.izofar.takesapillage.entity.Skirmisher;
import com.izofar.takesapillage.event.entity.RegisterEntityAttributesEvent;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistries;
import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import net.minecraft.SharedConstants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

/**
 * @see EntityType
 */
public final class ItTakesPillageEntityTypes
{
	public static final ResourcefulRegistry<EntityType<?>> ENTITY_TYPES = ResourcefulRegistries.create(BuiltInRegistries.ENTITY_TYPE, ItTakesPillage.MOD_ID);
	public static boolean previousCheckDataFixerSchema = SharedConstants.CHECK_DATA_FIXER_SCHEMA;

	public static final RegistryEntry<EntityType<ClayGolem>> CLAY_GOLEM;
	public static final RegistryEntry<EntityType<Archer>> ARCHER;
	public static final RegistryEntry<EntityType<Skirmisher>> SKIRMISHER;
	public static final RegistryEntry<EntityType<Legioner>> LEGIONER;

	public static void registerEntityAttributes(RegisterEntityAttributesEvent event) {
		event.register(ItTakesPillageEntityTypes.CLAY_GOLEM.get(), ClayGolem.createAttributes());
		event.register(ItTakesPillageEntityTypes.ARCHER.get(), Archer.createAttributes());
		event.register(ItTakesPillageEntityTypes.SKIRMISHER.get(), Skirmisher.createAttributes());
		event.register(ItTakesPillageEntityTypes.LEGIONER.get(), Legioner.createAttributes());
	}

	static {
		SharedConstants.CHECK_DATA_FIXER_SCHEMA = false;
		CLAY_GOLEM = ENTITY_TYPES.register("clay_golem", () -> EntityType.Builder.of(ClayGolem::new, MobCategory.MISC).sized(1.4F, 2.7F).clientTrackingRange(10).build((ItTakesPillage.makeId("clay_golem")).toString()));
		ARCHER = ENTITY_TYPES.register("archer", () -> EntityType.Builder.of(Archer::new, MobCategory.MONSTER).canSpawnFarFromPlayer().sized(0.6F, 1.95F).clientTrackingRange(8).build((ItTakesPillage.makeId("archer")).toString()));
		SKIRMISHER = ENTITY_TYPES.register("skirmisher", () -> EntityType.Builder.of(Skirmisher::new, MobCategory.MONSTER).canSpawnFarFromPlayer().sized(0.6F, 1.95F).clientTrackingRange(8).build((ItTakesPillage.makeId("skirmisher")).toString()));
		LEGIONER = ENTITY_TYPES.register("legioner", () -> EntityType.Builder.of(Legioner::new, MobCategory.MONSTER).canSpawnFarFromPlayer().sized(0.6F, 1.95F).clientTrackingRange(8).build((ItTakesPillage.makeId("legioner")).toString()));
		SharedConstants.CHECK_DATA_FIXER_SCHEMA = previousCheckDataFixerSchema;
	}
}
