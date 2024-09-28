package com.izofar.takesapillage.init.registry.fabric;

import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistryType;
import net.minecraft.core.Registry;

public class ResourcefulRegistriesImpl {
    public static <T> ResourcefulRegistry<T> create(Registry<T> registry, String id) {
        return new FabricResourcefulRegistry<>(registry, id);
    }

    @SuppressWarnings("unchecked")
    public static <D, T extends ResourcefulRegistry<D>> T create(ResourcefulRegistryType<D, T> type, String id) {
        throw new IllegalArgumentException("Unknown registry type: " + type);
    }
}
