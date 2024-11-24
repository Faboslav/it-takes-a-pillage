package com.izofar.takesapillage.mixin;

import com.izofar.takesapillage.entity.ClayGolem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CarvedPumpkinBlock.class)
public abstract class CarvedPumpkinBlockMixin
{
	@Inject(
		method = "canSpawnGolem",
		at = @At("HEAD"),
		cancellable = true
	)
	public void takesapillage$canDispense(
		LevelReader levelReader,
		BlockPos blockPos,
		CallbackInfoReturnable<Boolean> cir
	) {
		if (ClayGolem.getOrCreateClayGolemFull().find(levelReader, blockPos) != null) {
			cir.setReturnValue(true);
		}
	}

	@Inject(
		method = "onPlace",
		at = @At("HEAD")
	)
	private void takesapillage$customOnBlockAdded(
		BlockState blockState,
		Level level,
		BlockPos blockPos,
		BlockState oldBlockState,
		boolean bl,
		CallbackInfo ci
	) {
		if (!oldBlockState.is(blockState.getBlock())) {
			ClayGolem.trySpawnClayGolem(
				level,
				blockPos
			);
		}
	}
}
