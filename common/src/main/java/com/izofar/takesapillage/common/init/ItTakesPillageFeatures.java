package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.util.MobLists;
import com.izofar.takesapillage.common.world.feature.MobFeature;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
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

	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> ILLAGER = FEATURES.register("mob_feature_illager", () -> new MobFeature<>(() -> MobLists.PILLAGER_CAMP_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> RAVAGER = FEATURES.register("mob_feature_ravager", () -> new MobFeature<>(EntityType.RAVAGER));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> LIVESTOCK = FEATURES.register("mob_feature_livestock", () -> new MobFeature<>(() -> MobLists.LIVESTOCK_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> PRISONER = FEATURES.register("mob_feature_prisoner", () -> new MobFeature<>(() -> MobLists.PRISONER_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> ARCHER = FEATURES.register("mob_feature_archer", () -> new MobFeature<>(() -> MobLists.RANGED_ILLAGER_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> SOLDIER = FEATURES.register("mob_feature_soldier", () -> new MobFeature<>(() -> MobLists.BASTILLE_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> CAPTIVE = FEATURES.register("mob_feature_captive", () -> new MobFeature<>(() -> MobLists.CAPTIVE_LIST));
}
