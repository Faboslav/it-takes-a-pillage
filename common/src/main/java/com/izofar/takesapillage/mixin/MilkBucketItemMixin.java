package com.izofar.takesapillage.mixin;

import com.izofar.takesapillage.ItTakesPillage;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MilkBucketItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;

@Mixin(MilkBucketItem.class)
public class MilkBucketItemMixin
{
	@Inject(
		method = "finishUsingItem",
		at = @At("HEAD"),
		cancellable = true
	)
	private void takesapillage$finishUsingItem(
		ItemStack stack,
		Level level,
		LivingEntity entity,
		CallbackInfoReturnable<ItemStack> cir
	) {
		if (!ItTakesPillage.getConfig().removeBadOmen) {
			if (entity instanceof ServerPlayer serverPlayer) {
				CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
				serverPlayer.awardStat(Stats.ITEM_USED.get(stack.getItem()));
			}

			if (entity instanceof Player && !((Player) entity).getAbilities().instabuild) {
				stack.shrink(1);
			}

			if (!level.isClientSide) {
				var activeEffects = entity.getActiveEffects();

				for (var activeEffect : activeEffects) {
					/*? >=1.21 {*/
					if (activeEffect.getEffect().value() != MobEffects.BAD_OMEN) {
					/*?} else {*/
					/*if (activeEffect.getEffect() != MobEffects.BAD_OMEN) {
					*//*?}*/
						entity.onEffectRemoved(activeEffect);
					}
				}
			}

			cir.setReturnValue(stack.isEmpty() ? new ItemStack(Items.BUCKET):stack);
		}
	}
}
