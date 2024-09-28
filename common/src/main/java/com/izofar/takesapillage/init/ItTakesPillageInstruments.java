package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistries;
import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Instrument;

public final class ItTakesPillageInstruments
{
	public static final ResourcefulRegistry<Instrument> INSTRUMENTS = ResourcefulRegistries.create(BuiltInRegistries.INSTRUMENT, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<Instrument> RAID_HORN = INSTRUMENTS.register("raid_horn", () -> new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(2), 140, 256.0F));
}
