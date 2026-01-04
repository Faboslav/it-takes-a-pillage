package com.izofar.takesapillage.common.versions;

import com.izofar.takesapillage.common.ItTakesPillage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public final class VersionedEntityTypeResourceId
{
	/*? >=1.21.3 {*/
	/*public static ResourceKey<EntityType<?>> create(String id) {
		return ResourceKey.create(Registries.ENTITY_TYPE, ItTakesPillage.makeId(id));
	}
	*//*?} else {*/
	public static String create(String id) {
		return id;
	}
	/*?}*/
}
