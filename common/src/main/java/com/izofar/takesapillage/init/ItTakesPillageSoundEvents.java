package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistries;
import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public final class ItTakesPillageSoundEvents
{
	public static final ResourcefulRegistry<SoundEvent> SOUND_EVENTS = ResourcefulRegistries.create(BuiltInRegistries.SOUND_EVENT, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<SoundEvent> CLAY_GOLEM_ATTACK = registerSoundEvent("entity.clay_golem.attack");
	public static final RegistryEntry<SoundEvent> CLAY_GOLEM_DAMAGE = registerSoundEvent("entity.clay_golem.damage");
	public static final RegistryEntry<SoundEvent> CLAY_GOLEM_DEATH = registerSoundEvent("entity.clay_golem.death");
	public static final RegistryEntry<SoundEvent> CLAY_GOLEM_HURT = registerSoundEvent("entity.clay_golem.hurt");
	public static final RegistryEntry<SoundEvent> CLAY_GOLEM_REPAIR = registerSoundEvent("entity.clay_golem.repair");
	public static final RegistryEntry<SoundEvent> CLAY_GOLEM_STEP = registerSoundEvent("entity.clay_golem.step");
	public static final RegistryEntry<SoundEvent> LEGIONER_AMBIENT = registerSoundEvent("entity.legioner.ambient");
	public static final RegistryEntry<SoundEvent> LEGIONER_CELEBRATE = registerSoundEvent("entity.legioner.celebrate");
	public static final RegistryEntry<SoundEvent> LEGIONER_DEATH = registerSoundEvent("entity.legioner.death");
	public static final RegistryEntry<SoundEvent> LEGIONER_HURT = registerSoundEvent("entity.legioner.hurt");
	public static final RegistryEntry<SoundEvent> BASTILLE_BLUES = registerSoundEvent("bastille_blues");

	private static RegistryEntry<SoundEvent> registerSoundEvent(String path) {
		return SOUND_EVENTS.register(path, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ItTakesPillage.MOD_ID, path)));
	}
}
