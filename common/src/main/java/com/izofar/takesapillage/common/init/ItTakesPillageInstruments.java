//? if <1.21.3 {
package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Instrument;

public final class ItTakesPillageInstruments
{
	public static final ResourcefulRegistry<Instrument> INSTRUMENTS = ResourcefulRegistries.create(BuiltInRegistries.INSTRUMENT, ItTakesPillage.MOD_ID);
	public static final RegistryEntry<Instrument> RAID_HORN = INSTRUMENTS.register("raid_horn", () -> new Instrument(SoundEvents.GOAT_HORN_SOUND_VARIANTS.get(2), 140, 256.0F));
}
//?}
