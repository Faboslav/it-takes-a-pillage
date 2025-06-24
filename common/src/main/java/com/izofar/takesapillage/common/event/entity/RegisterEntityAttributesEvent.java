package com.izofar.takesapillage.common.event.entity;

import com.izofar.takesapillage.common.event.base.EventHandler;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.function.BiConsumer;

public record RegisterEntityAttributesEvent(
	BiConsumer<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> attributes)
{
	public static final EventHandler<RegisterEntityAttributesEvent> EVENT = new EventHandler<>();

	public void register(EntityType<? extends LivingEntity> entityType, AttributeSupplier.Builder builder) {
		attributes.accept(entityType, builder);
	}
}
