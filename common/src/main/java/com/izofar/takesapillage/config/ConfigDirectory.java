package com.izofar.takesapillage.config;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public final class ConfigDirectory
{
	@ExpectPlatform
	public static Path getConfigDirectory() {
		throw new AssertionError();
	}

	private ConfigDirectory() {
	}
}
