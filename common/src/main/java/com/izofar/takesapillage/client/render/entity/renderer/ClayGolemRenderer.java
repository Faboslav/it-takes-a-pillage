package com.izofar.takesapillage.client.render.entity.renderer;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.client.render.entity.model.ClayGolemModel;
import com.izofar.takesapillage.client.render.entity.renderer.layer.ClayGolemCrackinessLayer;
import com.izofar.takesapillage.client.render.entity.renderer.layer.ClayGolemFlowerLayer;
import com.izofar.takesapillage.entity.ClayGolem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public final class ClayGolemRenderer extends MobRenderer<ClayGolem, ClayGolemModel>
{
	private static final ResourceLocation GOLEM_LOCATION = ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem.png");

	public ClayGolemRenderer(EntityRendererProvider.Context context) {
		super(context, new ClayGolemModel(ClayGolemModel.createBodyLayer().bakeRoot()), 0.7F);
		this.addLayer(new ClayGolemCrackinessLayer(this));
		this.addLayer(new ClayGolemFlowerLayer(this));
	}

	public ResourceLocation getTextureLocation(ClayGolem entity) {
		return GOLEM_LOCATION;
	}

	/*? >=1.21 {*/
	protected void setupRotations(ClayGolem entity, PoseStack stack, float pitch, float yaw, float roll, float i) {
		super.setupRotations(entity, stack, pitch, yaw, roll, i);
		/*?} else {*/
	/*protected void setupRotations(ClayGolem entity, PoseStack stack, float pitch, float yaw, float roll) {
		super.setupRotations(entity, stack, pitch, yaw, roll);
	 *//*?}*/
		if (entity.walkAnimation.speed() >= 0.01D) {
			float f1 = entity.walkAnimation.position(roll) + 6.0F;
			float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
			stack.mulPose(Axis.ZP.rotationDegrees(6.5F * f2));
		}
	}
}
