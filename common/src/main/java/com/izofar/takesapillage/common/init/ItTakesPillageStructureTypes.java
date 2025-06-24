package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.world.structure.PillagerStructure;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;

public final class ItTakesPillageStructureTypes
{
	public static final ResourcefulRegistry<StructureType<?>> STRUCTURE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.STRUCTURE_TYPE, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<StructureType<PillagerStructure>> PILLAGER_STRUCTURE = STRUCTURE_TYPES.register("pillager_structure", () -> () -> PillagerStructure.CODEC);
}
