package com.izofar.takesapillage.client.render.entity.renderer.layer;

import com.izofar.takesapillage.client.render.entity.model.ClayGolemModel;
import com.izofar.takesapillage.entity.ClayGolem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;

@Environment(EnvType.CLIENT)
public final class ClayGolemFlowerLayer extends RenderLayer<ClayGolem, ClayGolemModel>
{
	public ClayGolemFlowerLayer(RenderLayerParent<ClayGolem, ClayGolemModel> layer) {
		super(layer);
	}

	public void render(
		PoseStack stack,
		MultiBufferSource source,
		int p_117174_,
		ClayGolem golem,
		float p_117176_,
		float p_117177_,
		float p_117178_,
		float p_117179_,
		float p_117180_,
		float p_117181_
	) {
		if (golem.getOfferFlowerTick() == 0) return;
		stack.pushPose();
		ModelPart modelpart = this.getParentModel().getFlowerHoldingArm();
		modelpart.translateAndRotate(stack);
		stack.translate(-1.0185D, 0.78D, -0.9375D);
		stack.translate(0.5D, 0.5D, 0.5D);
		stack.scale(0.5F, 0.5F, 0.5F);
		stack.mulPose(Axis.XP.rotationDegrees(-90.0F));
		stack.translate(-0.5D, -0.5D, -0.5D);
		Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.POPPY.defaultBlockState(), stack, source, p_117174_, OverlayTexture.NO_OVERLAY);
		stack.popPose();
	}
}
