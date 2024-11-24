package com.izofar.takesapillage.config.neoforge;

import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public final class ConfigDirectoryImpl
{
	/**
	 * @see com.izofar.takesapillage.config.ConfigDirectory#getConfigDirectory()
	 */
	public static Path getConfigDirectory() {
		return FMLPaths.CONFIGDIR.get();
	}
}
