package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Instrument;

public final class ItTagesPillageTags
{
	public static void init() {
	}

	public static final TagKey<Instrument> RAVAGER_HORNS = TagKey.create(Registries.INSTRUMENT, new ResourceLocation(ItTakesPillage.MOD_ID, "ravager_horns"));
}
