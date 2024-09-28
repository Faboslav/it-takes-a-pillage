package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistries;
import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import com.izofar.takesapillage.util.MobLists;
import com.izofar.takesapillage.world.feature.MobFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

/**
 * @see Feature
 */
public abstract class ItTakesPillageFeatures
{
	public static final ResourcefulRegistry<Feature<?>> FEATURES = ResourcefulRegistries.create(BuiltInRegistries.FEATURE, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> ILLAGER = FEATURES.register("mob_feature_illager", () -> new MobFeature(() -> MobLists.PILLAGER_CAMP_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> RAVAGER = FEATURES.register("mob_feature_ravager", () -> new MobFeature(EntityType.RAVAGER));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> LIVESTOCK = FEATURES.register("mob_feature_livestock", () -> new MobFeature(() -> MobLists.LIVESTOCK_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> PRISONER = FEATURES.register("mob_feature_prisoner", () -> new MobFeature(() -> MobLists.PRISONER_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> ARCHER = FEATURES.register("mob_feature_archer", () -> new MobFeature(() -> MobLists.RANGED_ILLAGER_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> SOLDIER = FEATURES.register("mob_feature_soldier", () -> new MobFeature(() -> MobLists.BASTILLE_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> CAPTIVE = FEATURES.register("mob_feature_captive", () -> new MobFeature(() -> MobLists.CAPTIVE_LIST));
}
