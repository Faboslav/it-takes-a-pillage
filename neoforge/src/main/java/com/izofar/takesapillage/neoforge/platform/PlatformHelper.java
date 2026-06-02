package com.izofar.takesapillage.neoforge.platform;

import net.neoforged.fml.ModList;

public final class PlatformHelper implements com.izofar.takesapillage.common.platform.PlatformHelper
{
	@Override
	public boolean isModLoaded(String modId) {
		return ModList.get().isLoaded(modId);
	}
}
