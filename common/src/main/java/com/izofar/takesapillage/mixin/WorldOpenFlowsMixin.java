package com.izofar.takesapillage.mixin;

import com.mojang.serialization.Lifecycle;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.worldselection.CreateWorldScreen;
import net.minecraft.client.gui.screens.worldselection.WorldOpenFlows;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(WorldOpenFlows.class)
public abstract class WorldOpenFlowsMixin
{
	@Inject(
		method = "confirmWorldCreation",
		at = @At("HEAD"),
		cancellable = true
	)
	private static void alwaysTreatAsStable(
		Minecraft client,
		CreateWorldScreen parent,
		Lifecycle lifecycle,
		Runnable loader,
		boolean bypassWarnings,
		CallbackInfo ci
	) {
		if (lifecycle != Lifecycle.stable()) {
			loader.run();
			ci.cancel();
		}
	}
}