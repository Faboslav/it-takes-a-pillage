package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistries;
import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import com.izofar.takesapillage.world.structure.PillagerStructure;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;

public final class ItTakesPillageStructureTypes
{
	public static final ResourcefulRegistry<StructureType<?>> STRUCTURE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.STRUCTURE_TYPE, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<StructureType<PillagerStructure>> PILLAGER_STRUCTURE = STRUCTURE_TYPES.register("pillager_structure", () -> () -> PillagerStructure.CODEC);
}
