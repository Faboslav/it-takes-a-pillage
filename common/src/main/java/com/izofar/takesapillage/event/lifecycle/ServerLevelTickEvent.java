package com.izofar.takesapillage.event.lifecycle;

import com.izofar.takesapillage.event.base.EventHandler;
import net.minecraft.world.level.Level;

public record ServerLevelTickEvent(Level level, boolean end)
{

	public static final EventHandler<ServerLevelTickEvent> EVENT = new EventHandler<>();

	public Level getLevel() {
		return level;
	}
}
