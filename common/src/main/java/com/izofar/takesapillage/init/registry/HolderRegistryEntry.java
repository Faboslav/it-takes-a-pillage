package com.izofar.takesapillage.init.registry;

import net.minecraft.core.Holder;

/**
 * Event/registry related is code based on The Bumblezone/Resourceful Lib mods with permissions from the authors
 *
 * @author TelepathicGrunt
 * <a href="https://github.com/TelepathicGrunt/Bumblezone">https://github.com/TelepathicGrunt/Bumblezone</a>
 * @author ThatGravyBoat
 * <a href="https://github.com/Team-Resourceful/ResourcefulLib">https://github.com/Team-Resourceful/ResourcefulLib</a>
 */
public interface HolderRegistryEntry<T> extends RegistryEntry<T>
{
	Holder<T> holder();

	@Override
	default T get() {
		return holder().value();
	}
}