package com.izofar.takesapillage.common.versions;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;

//? if < 1.21.9 {
/*import net.minecraft.world.entity.LivingEntity;
*///?}

public final class VersionedEntity
{
	public static EquipmentSlot getEquipmentSlotForItem(InteractionHand hand) {
		EquipmentSlot equipmentSlot;
		//? if >= 1.21.9 {
		equipmentSlot = hand.asEquipmentSlot();
		//?} else {
		/*equipmentSlot = LivingEntity.getSlotForHand(hand);
		*///?}

		return equipmentSlot;
	}
}
