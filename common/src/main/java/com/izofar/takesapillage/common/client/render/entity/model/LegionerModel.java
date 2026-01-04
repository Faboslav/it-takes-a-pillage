package com.izofar.takesapillage.common.client.render.entity.model;

import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;

//? >= 1.21.3 {
/*import com.izofar.takesapillage.common.client.render.entity.state.LegionerRenderState;
*///?} else {
import com.izofar.takesapillage.common.entity.Legioner;
//?}

//? >= 1.21.3 {
/*public final class LegionerModel extends IllagerModel<LegionerRenderState>
*///?} else {
public class LegionerModel extends IllagerModel<Legioner>
 //?}
{
	private final ModelPart rightArm;
	private final ModelPart leftArm;

	public LegionerModel(ModelPart root) {
		super(root);
		this.leftArm = root.getChild("left_arm");
		this.rightArm = root.getChild("right_arm");
	}

	@Override
	//? >= 1.21.3 {
	/*public void setupAnim(LegionerRenderState renderState)
	*///?} else {
	public void setupAnim(
		Legioner legioner,
		float limbSwing,
		float limbSwingAmount,
		float ageInTicks,
		float netHeadYaw,
		float headPitch
	)
	//?}
	{
		//? >= 1.21.3 {
		/*var legioner = renderState.legioner;
		super.setupAnim(renderState);
		*///?} else {
		super.setupAnim(legioner, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		//?}
		
		if (legioner.isAlive() && legioner.isUsingShield()) {
			boolean flag = legioner.getMainArm() == HumanoidArm.RIGHT;
			if ((legioner.getShieldHand() == InteractionHand.MAIN_HAND) == flag) {
				this.poseRightArmShield();
			} else if ((legioner.getShieldHand() == InteractionHand.OFF_HAND) == flag) {
				this.poseLeftArmShield();
			}
		}
	}

	private void poseRightArmShield() {
		this.rightArm.xRot = this.rightArm.xRot * 0.5F - 0.9424779F;
		this.rightArm.yRot = (-(float) Math.PI / 6F);
	}

	private void poseLeftArmShield() {
		this.leftArm.xRot = this.leftArm.xRot * 0.5F - 0.9424779F;
		this.leftArm.yRot = ((float) Math.PI / 6F);
	}
}
