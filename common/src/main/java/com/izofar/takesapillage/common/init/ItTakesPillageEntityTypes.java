package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.entity.Archer;
import com.izofar.takesapillage.common.entity.ClayGolem;
import com.izofar.takesapillage.common.entity.Legioner;
import com.izofar.takesapillage.common.entity.Skirmisher;
import com.izofar.takesapillage.common.event.entity.RegisterEntityAttributesEvent;
import com.izofar.takesapillage.common.versions.VersionedEntityTypeResourceId;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
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
		CLAY_GOLEM = ENTITY_TYPES.register("clay_golem", () -> EntityType.Builder.of(ClayGolem::new, MobCategory.MISC).sized(1.4F, 2.7F).clientTrackingRange(10).build((VersionedEntityTypeResourceId.create("clay_golem"))));
		ARCHER = ENTITY_TYPES.register("archer", () -> EntityType.Builder.of(Archer::new, MobCategory.MONSTER).canSpawnFarFromPlayer().sized(0.6F, 1.95F)/*? >=1.21.1 {*//*.passengerAttachments(2.0F).ridingOffset(-0.6F)*//*?}*/.clientTrackingRange(8).build((VersionedEntityTypeResourceId.create("archer"))));
		SKIRMISHER = ENTITY_TYPES.register("skirmisher", () -> EntityType.Builder.of(Skirmisher::new, MobCategory.MONSTER).canSpawnFarFromPlayer().sized(0.6F, 1.95F)/*? >=1.21.1 {*//*.passengerAttachments(2.0F).ridingOffset(-0.6F)*//*?}*/.clientTrackingRange(8).build((VersionedEntityTypeResourceId.create("skirmisher"))));
		LEGIONER = ENTITY_TYPES.register("legioner", () -> EntityType.Builder.of(Legioner::new, MobCategory.MONSTER).canSpawnFarFromPlayer().sized(0.6F, 1.95F)/*? >=1.21.1 {*//*.passengerAttachments(2.0F).ridingOffset(-0.6F)*//*?}*/.clientTrackingRange(8).build((VersionedEntityTypeResourceId.create("legioner"))));
		SharedConstants.CHECK_DATA_FIXER_SCHEMA = previousCheckDataFixerSchema;
	}
}
