package com.izofar.takesapillage.common.client.render.entity.renderer.layer;

import com.izofar.takesapillage.common.client.render.entity.model.ClayGolemModel;
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

//? if >= 1.21.3 {
import com.izofar.takesapillage.common.client.render.entity.state.ClayGolemRenderState;
//?} else {
/*import com.izofar.takesapillage.common.entity.ClayGolem;
*///?}

@Environment(EnvType.CLIENT)
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

	//? >=1.21.3 {
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, ClayGolemRenderState renderState, float yRot, float xRot)
	//?} else {
	/*public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, ClayGolem clayGolem, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch)
	*///?}
	{
		//? >=1.21.3 {
		var clayGolem = renderState.clayGolem;
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
		Minecraft.getInstance().getBlockRenderer().renderSingleBlock(Blocks.POPPY.defaultBlockState(), poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
	}
}
