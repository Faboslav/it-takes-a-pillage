package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public final class ItTakesPillageDamageTypes
{
	public static final ResourceKey<DamageType> ARCHER_SNIPE = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ItTakesPillage.MOD_ID, "archer_snipe"));
	public static final ResourceKey<DamageType> LEGIONER_SLAY = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ItTakesPillage.MOD_ID, "legioner_slay"));
	public static final ResourceKey<DamageType> SKIRMISHER_HACK = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ItTakesPillage.MOD_ID, "skirmisher_hack"));
}