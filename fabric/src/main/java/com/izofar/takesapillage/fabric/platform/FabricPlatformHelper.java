package com.izofar.takesapillage.fabric.platform;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.platform.PlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public final class FabricPlatformHelper implements PlatformHelper
{
	@Override
	public boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}

	@Override
	public String getModVersion() {
		return FabricLoader.getInstance().getModContainer(ItTakesPillage.MOD_ID).map(modContainer -> modContainer.getMetadata().getVersion().toString()).orElse(null);
	}

	@Override
	public Path getConfigDirectory() {
		return FabricLoader.getInstance().getConfigDir();
	}
}
