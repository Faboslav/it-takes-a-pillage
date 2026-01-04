package com.izofar.takesapillage.common.mixin;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.entity.Archer;
import com.izofar.takesapillage.common.entity.Legioner;
import com.izofar.takesapillage.common.entity.Skirmisher;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Raid.class)
public final class RaidMixin
{
	@Inject(
		method = "joinRaid",
		at = @At("HEAD"),
		cancellable = true
	)
	public void takesapillage$addRaider(
		//? >= 1.21.5 {
		/*ServerLevel serverLevel,
		*///?}
		int wave,
		Raider raider,
		BlockPos pos,
		boolean existing,
		CallbackInfo ci
	) {
		if (
			(
				raider instanceof Archer
				&& (
					!ItTakesPillage.getConfig().enableArcherInRaids
					|| !ItTakesPillage.getConfig().enableArcherInRaids
				)
			) || (
				raider instanceof Legioner
				&& (
					!ItTakesPillage.getConfig().enableLegioner
					|| !ItTakesPillage.getConfig().enableLegionerInRaids
				)
			) || (
				raider instanceof Skirmisher
				&& (
					!ItTakesPillage.getConfig().enableSkirmisher
					|| !ItTakesPillage.getConfig().enableSkirmisherInRaids
				)
			)
		) {
			ci.cancel();
		}
	}
}
