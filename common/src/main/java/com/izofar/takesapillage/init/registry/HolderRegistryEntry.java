package com.izofar.takesapillage.init.registry;

import net.minecraft.core.Holder;

public interface HolderRegistryEntry<T> extends RegistryEntry<T>
{

	Holder<T> holder();

	@Override
	default T get() {
		return holder().value();
	}

}