package com.izofar.takesapillage.init.registry.forge;

import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;

public class ResourcefulRegistriesImpl
{
	public static <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
		return new ForgeResourcefulRegistry<>(registry, id);
	}
}
