package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;

public final class ItTagesPillageTags
{
	public static void init() {
	}

	public static final TagKey<Instrument> RAVAGER_HORNS = TagKey.create(Registries.INSTRUMENT, ItTakesPillage.makeId("ravager_horns"));
}
