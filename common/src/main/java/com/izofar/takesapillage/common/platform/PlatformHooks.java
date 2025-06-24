package com.izofar.takesapillage.common.platform;

import java.util.ServiceLoader;

public final class PlatformHooks
{
	public static final PlatformHelper PLATFORM_HELPER = load(PlatformHelper.class);

	public static <T> T load(Class<T> service) {
		T loadedService = ServiceLoader.load(service)
			.findFirst()
			.orElseThrow(() -> new NullPointerException("No implementation found for " + service.getName()));
		return loadedService;
	}
}
