package com.izofar.takesapillage.fabric.platform;

import net.fabricmc.loader.api.FabricLoader;

public final class PlatformHelper implements com.izofar.takesapillage.common.platform.PlatformHelper
{
	@Override
	public boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}
}
