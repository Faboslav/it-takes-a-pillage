package com.izofar.takesapillage.mixin;

import com.izofar.takesapillage.init.ItTakesPillageEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.GolemSensor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Optional;

@Mixin(GolemSensor.class)
public abstract class ClayGolemSensorMixin
{
	@Inject(
		method = "doTick(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;)V",
		at = @At(value = "RETURN")
	)
	private void takesapillage$doTick(ServerLevel serverLevel, LivingEntity livingEntity, CallbackInfo ci) {
		takesapillage$checkForNearbyClayGolem(livingEntity);
	}

	private static void takesapillage$checkForNearbyClayGolem(LivingEntity livingEntity) {
		Optional<List<LivingEntity>> optional = livingEntity.getBrain().getMemory(MemoryModuleType.NEAREST_LIVING_ENTITIES);
		if (optional.isPresent()) {
			boolean flag = optional.get().stream().anyMatch((target) -> target.getType().equals(ItTakesPillageEntityTypes.CLAY_GOLEM.get()));
			if (flag) {
				GolemSensor.golemDetected(livingEntity);
			}

		}
	}
}
