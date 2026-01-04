package com.izofar.takesapillage.common.versions;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import org.jetbrains.annotations.Nullable;

//? if < 1.21.9 {
import net.minecraft.world.entity.LivingEntity;
//?}

public final class VersionedEntity
{
	@Nullable
	public static EquipmentSlot getEquipmentSlotForItem(InteractionHand hand) {
		EquipmentSlot equipmentSlot = null;
		//? if >= 1.21.9 {
		/*equipmentSlot = hand.asEquipmentSlot();
		*///?} else if >=1.21.1 {
		/*equipmentSlot = LivingEntity.getSlotForHand(hand);
		*///?}

		return equipmentSlot;
	}
}
