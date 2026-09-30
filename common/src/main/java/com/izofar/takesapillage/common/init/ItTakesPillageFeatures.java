package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.util.MobLists;
import com.izofar.takesapillage.common.versions.VersionedEntityType;
import com.izofar.takesapillage.common.world.feature.MobFeature;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
//? if >=26.3 {
import com.mojang.serialization.MapCodec;
//?} else {
//import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
//?}

/**
 * @see Feature
 */
public abstract class ItTakesPillageFeatures
{
	//? if >=26.3 {
	public static final ResourcefulRegistry<MapCodec<? extends Feature>> FEATURES = ResourcefulRegistries.create(BuiltInRegistries.FEATURE_TYPE, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<MapCodec<? extends Feature>> ILLAGER = FEATURES.register("mob_feature_illager", () -> new MobFeature<>(() -> MobLists.PILLAGER_CAMP_LIST).codec());
	public static final RegistryEntry<MapCodec<? extends Feature>> RAVAGER = FEATURES.register("mob_feature_ravager", () -> new MobFeature<>(VersionedEntityType.RAVAGER).codec());
	public static final RegistryEntry<MapCodec<? extends Feature>> LIVESTOCK = FEATURES.register("mob_feature_livestock", () -> new MobFeature<>(() -> MobLists.LIVESTOCK_LIST).codec());
	public static final RegistryEntry<MapCodec<? extends Feature>> PRISONER = FEATURES.register("mob_feature_prisoner", () -> new MobFeature<>(() -> MobLists.PRISONER_LIST).codec());
	public static final RegistryEntry<MapCodec<? extends Feature>> ARCHER = FEATURES.register("mob_feature_archer", () -> new MobFeature<>(() -> MobLists.RANGED_ILLAGER_LIST).codec());
	public static final RegistryEntry<MapCodec<? extends Feature>> SOLDIER = FEATURES.register("mob_feature_soldier", () -> new MobFeature<>(() -> MobLists.BASTILLE_LIST).codec());
	public static final RegistryEntry<MapCodec<? extends Feature>> CAPTIVE = FEATURES.register("mob_feature_captive", () -> new MobFeature<>(() -> MobLists.CAPTIVE_LIST).codec());
	//?} else {
	/*public static final ResourcefulRegistry<Feature<?>> FEATURES = ResourcefulRegistries.create(BuiltInRegistries.FEATURE, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> ILLAGER = FEATURES.register("mob_feature_illager", () -> new MobFeature<>(() -> MobLists.PILLAGER_CAMP_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> RAVAGER = FEATURES.register("mob_feature_ravager", () -> new MobFeature<>(VersionedEntityType.RAVAGER));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> LIVESTOCK = FEATURES.register("mob_feature_livestock", () -> new MobFeature<>(() -> MobLists.LIVESTOCK_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> PRISONER = FEATURES.register("mob_feature_prisoner", () -> new MobFeature<>(() -> MobLists.PRISONER_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> ARCHER = FEATURES.register("mob_feature_archer", () -> new MobFeature<>(() -> MobLists.RANGED_ILLAGER_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> SOLDIER = FEATURES.register("mob_feature_soldier", () -> new MobFeature<>(() -> MobLists.BASTILLE_LIST));
	public static final RegistryEntry<Feature<NoneFeatureConfiguration>> CAPTIVE = FEATURES.register("mob_feature_captive", () -> new MobFeature<>(() -> MobLists.CAPTIVE_LIST));
	*///?}
}
