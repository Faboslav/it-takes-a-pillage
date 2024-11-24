package com.izofar.takesapillage.init.registry.neoforge;

import com.izofar.takesapillage.init.registry.HolderRegistryEntry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredHolder;

/**
 * Event/registry related is code based on The Bumblezone/Resourceful Lib mods with permissions from the authors
 *
 * @author TelepathicGrunt
 * <a href="https://github.com/TelepathicGrunt/Bumblezone">https://github.com/TelepathicGrunt/Bumblezone</a>
 * @author ThatGravyBoat
 * <a href="https://github.com/Team-Resourceful/ResourcefulLib">https://github.com/Team-Resourceful/ResourcefulLib</a>
 */
public class NeoForgeHolderRegistryEntry<R> implements HolderRegistryEntry<R>
{
    private final DeferredHolder<R, R> object;

    public NeoForgeHolderRegistryEntry(DeferredHolder<R, R> object) {
        this.object = object;
    }

    @Override
    public Holder<R> holder() {
        return object;
    }

    @Override
    public ResourceLocation getId() {
        return object.getId();
    }
}
