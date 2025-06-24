package com.izofar.takesapillage.common.client.render.entity.renderer;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.client.render.entity.model.ClayGolemModel;
import com.izofar.takesapillage.common.client.render.entity.renderer.layer.ClayGolemCrackinessLayer;
import com.izofar.takesapillage.common.client.render.entity.renderer.layer.ClayGolemFlowerLayer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import com.izofar.takesapillage.common.entity.ClayGolem;

//? if >= 1.21.3 {
import com.izofar.takesapillage.common.client.render.entity.state.ClayGolemRenderState;
//?}

//? if >= 1.21.3 {
public final class ClayGolemRenderer extends MobRenderer<ClayGolem, ClayGolemRenderState, ClayGolemModel>
//?} else {
/*public final class ClayGolemRenderer extends MobRenderer<ClayGolem, ClayGolemModel>
*///?}
{
	private static final ResourceLocation TEXTURE = ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem.png");

	public ClayGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ClayGolemModel(ClayGolemModel.createBodyLayer().bakeRoot()), 0.7F);
		this.addLayer(new ClayGolemCrackinessLayer(this));
		this.addLayer(new ClayGolemFlowerLayer(this));
	}

	//? if >= 1.21.3 {
	@Override
	public ClayGolemRenderState createRenderState() {
		return new ClayGolemRenderState();
	}

	@Override
	public void extractRenderState(ClayGolem clayGolem, ClayGolemRenderState renderState, float partialTick) {
		super.extractRenderState(clayGolem, renderState, partialTick);
		renderState.clayGolem = clayGolem;
	}
	//?}

	@Override
	//? if >=1.21.3 {
	protected void setupRotations(ClayGolemRenderState renderState, PoseStack poseStack, float bodyRot, float scale)
	//?} else if >=1.21 {
	/*protected void setupRotations(ClayGolem clayGolem, PoseStack poseStack, float pitch, float yaw, float roll, float i)
	*///?} else {
	/*protected void setupRotations(ClayGolem clayGolem, PoseStack poseStack, float pitch, float yaw, float roll)
	*///?}
	{
		//? if >=1.21.3 {
		super.setupRotations(renderState, poseStack, bodyRot, scale);
		var clayGolem = renderState.clayGolem;
		//?} else if >=1.21 {
		/*super.setupRotations(clayGolem, poseStack, pitch, yaw, roll, i);
		*///?} else {
		/*super.setupRotations(clayGolem, poseStack, pitch, yaw, roll);
		*///?}

		if (clayGolem.walkAnimation.speed() >= 0.01D) {
			//? if >=1.21.3 {
			float f1 = clayGolem.walkAnimation.position(renderState.walkAnimationSpeed) + 6.0F;
			//?} else {
			/*float f1 = clayGolem.walkAnimation.position(roll) + 6.0F;
			*///?}
			float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
			poseStack.mulPose(Axis.ZP.rotationDegrees(6.5F * f2));
		}
	}

	@Override
	//? if >= 1.21.3 {
	public ResourceLocation getTextureLocation(ClayGolemRenderState renderState)
	//?} else {
	/*public ResourceLocation getTextureLocation(ClayGolem clayGolem)
	 *///?}
	{
		return TEXTURE;
	}
}
