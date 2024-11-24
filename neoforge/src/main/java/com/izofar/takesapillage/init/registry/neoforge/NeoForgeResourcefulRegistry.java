package com.izofar.takesapillage.init.registry.neoforge;

import com.izofar.takesapillage.init.registry.HolderRegistryEntry;
import com.izofar.takesapillage.init.registry.RegistryEntries;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import net.minecraft.core.Registry;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * Event/registry related is code based on The Bumblezone/Resourceful Lib mods with permissions from the authors
 *
 * @author TelepathicGrunt
 * <a href="https://github.com/TelepathicGrunt/Bumblezone">https://github.com/TelepathicGrunt/Bumblezone</a>
 * @author ThatGravyBoat
 * <a href="https://github.com/Team-Resourceful/ResourcefulLib">https://github.com/Team-Resourceful/ResourcefulLib</a>
 */
public class NeoForgeResourcefulRegistry<T> implements ResourcefulRegistry<T>
{
    private final DeferredRegister<T> register;
    private final RegistryEntries<T> entries = new RegistryEntries<>();

    public NeoForgeResourcefulRegistry(Registry<T> registry, String id) {
        this.register = DeferredRegister.create(registry.key(), id);
    }

    @Override
    public <I extends T> RegistryEntry<I> register(String id, Supplier<I> supplier) {
        return this.entries.add(new NeoForgeRegistryEntry<>(register.register(id, supplier)));
    }

	@Override
	public HolderRegistryEntry<T> registerHolder(String id, Supplier<T> supplier) {
		return this.entries.add(new NeoForgeHolderRegistryEntry<>(register.register(id, supplier)));
	}

    @Override
    public Collection<RegistryEntry<T>> getEntries() {
        return this.entries.getEntries();
    }

    @Override
    public void init() {
        register.register(ModLoadingContext.get().getActiveContainer().getEventBus());
    }
}