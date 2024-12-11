package com.izofar.takesapillage.init.registry.neoforge;

import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistryType;
import net.minecraft.core.Registry;

/**
 * Event/registry related is code based on The Bumblezone/Resourceful Lib mods with permissions from the authors
 *
 * @author TelepathicGrunt
 * <a href="https://github.com/TelepathicGrunt/Bumblezone">https://github.com/TelepathicGrunt/Bumblezone</a>
 * @author ThatGravyBoat
 * <a href="https://github.com/Team-Resourceful/ResourcefulLib">https://github.com/Team-Resourceful/ResourcefulLib</a>
 */
public class ResourcefulRegistriesImpl
{
	public static <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
		return new NeoForgeResourcefulRegistry<>(registry, id);
	}

	@SuppressWarnings("unchecked")
	public static <D, T extends ResourcefulRegistry<D>> T create(ResourcefulRegistryType<D, T> type, String id) {
		throw new IllegalArgumentException("Unknown registry type: " + type);
	}
}
