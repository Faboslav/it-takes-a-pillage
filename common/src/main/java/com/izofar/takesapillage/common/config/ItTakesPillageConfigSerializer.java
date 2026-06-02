package com.izofar.takesapillage.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.izofar.takesapillage.common.ItTakesPillage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ItTakesPillageConfigSerializer
{
	private static final Path CONFIG_PATH = Path.of("config", ItTakesPillage.MOD_ID + ".json");
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	public static void load() {
		try {
			if (Files.exists(CONFIG_PATH)) {
				ItTakesPillageConfig config = ItTakesPillage.getConfig();
				ItTakesPillageConfig loadedConfig = GSON.fromJson(Files.readString(CONFIG_PATH), ItTakesPillageConfig.class);

				for (Field field : ItTakesPillageConfig.class.getDeclaredFields()) {
					if (Modifier.isStatic(field.getModifiers())) continue;
					field.setAccessible(true);
					field.set(config, field.get(loadedConfig));
				}
			} else {
				save();
			}
		} catch (Exception e) {
			ItTakesPillage.getLogger().error("Failed to save config.", e);
		}
	}

	public static void save() {
		try {
			Files.createDirectories(CONFIG_PATH.getParent());
			Files.writeString(CONFIG_PATH, GSON.toJson(ItTakesPillage.getConfig()));
		} catch (Exception e) {
			ItTakesPillage.getLogger().error("Failed to save config.", e);
		}
	}
}
