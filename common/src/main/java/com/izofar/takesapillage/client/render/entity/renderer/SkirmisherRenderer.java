package com.izofar.takesapillage.client.render.entity.renderer;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.client.render.entity.model.SkirmisherModel;
import com.izofar.takesapillage.entity.Skirmisher;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public final class SkirmisherRenderer extends MobRenderer<Skirmisher, SkirmisherModel>
{
	private static final ResourceLocation SKIRMISHER = ItTakesPillage.makeId("textures/entity/skirmisher.png");

	public SkirmisherRenderer(EntityRendererProvider.Context context) {
		super(context, new SkirmisherModel(SkirmisherModel.createBodyLayer().bakeRoot()), 0.5F);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	public ResourceLocation getTextureLocation(Skirmisher skirmisher) {
		return SKIRMISHER;
	}

	protected void scale(Skirmisher skirmisher, PoseStack stack, float f) {
		stack.scale(0.9375F, 0.9375F, 0.9375F);
	}
}
