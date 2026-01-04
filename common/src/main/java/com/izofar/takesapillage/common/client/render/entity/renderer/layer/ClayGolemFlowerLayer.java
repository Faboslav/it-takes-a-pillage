package com.izofar.takesapillage.common.client.render.entity.renderer.layer;

import com.izofar.takesapillage.common.client.render.entity.model.ClayGolemModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.block.Blocks;

//? if >=1.21.10 {
import net.minecraft.client.renderer.SubmitNodeCollector;
//?} else {
/*import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.Minecraft;
*///?}

//? if >= 1.21.3 {
import com.izofar.takesapillage.common.client.render.entity.state.ClayGolemRenderState;
//?} else {
/*import com.izofar.takesapillage.common.entity.ClayGolem;
*///?}

//? if >=1.21.3 {
public final class ClayGolemFlowerLayer extends RenderLayer<ClayGolemRenderState, ClayGolemModel>
//?} else {
/*public final class ClayGolemFlowerLayer extends RenderLayer<ClayGolem, ClayGolemModel>
*///?}
{
	//? >=1.21.3 {
	public ClayGolemFlowerLayer(RenderLayerParent<ClayGolemRenderState, ClayGolemModel> renderLayerParent) {
		super(renderLayerParent);
	}
	//?} else {
	/*public ClayGolemFlowerLayer(RenderLayerParent<ClayGolem, ClayGolemModel> layer) {
		super(layer);
	}*///?}

	//? if >=1.21.9 {
	public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int packedLight, ClayGolemRenderState clayGolemRenderState, float yRot, float xRot)
	//?} else if >=1.21.3 {
	/*public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, ClayGolemRenderState clayGolemRenderState, float yRot, float xRot)
	 *///?} else {
	/*public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T moobloom, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float yRot, float xRot)
	 *///?}
	{
		//? >=1.21.3 {
		var clayGolem = clayGolemRenderState.clayGolem;
		//?}
		if (clayGolem.getOfferFlowerTick() == 0 || clayGolem.isInvisible()) {
			return;
		}

		poseStack.pushPose();
		ModelPart modelpart = this.getParentModel().getFlowerHoldingArm();
		modelpart.translateAndRotate(poseStack);
		poseStack.translate(-1.0185D, 0.78D, -0.9375D);
		poseStack.translate(0.5D, 0.5D, 0.5D);
		poseStack.scale(0.5F, 0.5F, 0.5F);
		poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
		poseStack.translate(-0.5D, -0.5D, -0.5D);
		//? if >=1.21.10 {
		submitNodeCollector.submitBlock(poseStack, Blocks.POPPY.defaultBlockState(), packedLight, OverlayTexture.NO_OVERLAY, clayGolemRenderState.outlineColor);
		//?} else {
		/*Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.POPPY.defaultBlockState(), poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY);
		*///?}
		poseStack.popPose();
	}
}
