package com.izofar.takesapillage.common.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

//? >=1.21.3 {
import net.minecraft.client.model.EntityModel;
import com.izofar.takesapillage.common.client.render.entity.state.ClayGolemRenderState;
//?} else {
/*import net.minecraft.client.model.HierarchicalModel;
import com.izofar.takesapillage.common.entity.ClayGolem;
*///?}

@Environment(EnvType.CLIENT)
//? >=1.21.3 {
public class ClayGolemModel extends EntityModel<ClayGolemRenderState>
//?} else {
/*public final class ClayGolemModel extends HierarchicalModel<ClayGolem>
*///?}
{
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart right_leg;
	private final ModelPart left_leg;

	public ClayGolemModel(ModelPart root) {
		//? >=1.21.3 {
		super(root);
		//?}

		this.root = root;
		this.head = root.getChild("head");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(36, 21).addBox(-4.0F, -11.0F, -5.5F, 8.0F, 9.0F, 8.0F).texOffs(0, 0).addBox(-1.0F, -5.0F, -7.5F, 2.0F, 3.0F, 2.0F), PartPose.offset(0.0F, -7.0F, 0.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -2.0F, -5.0F, 14.0F, 12.0F, 9.0F).texOffs(36, 38).addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -7.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(18, 21).addBox(-10.0F, -2.5F, -3.0F, 3.0F, 25.0F, 6.0F), PartPose.offset(0.0F, -7.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 21).addBox(7.0F, -2.5F, -3.0F, 3.0F, 25.0F, 6.0F), PartPose.offset(0.0F, -7.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(31, 49).addBox(-9.5F, -3.0F, -3.0F, 4.0F, 16.0F, 5.0F), PartPose.offset(4.0F, 11.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(46, 0).addBox(6.5F, -3.0F, -3.0F, 4.0F, 16.0F, 5.0F), PartPose.offset(-5.0F, 11.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	//? <1.21.3 {
	/*@Override
	public ModelPart root() {
		return this.root;
	}
	*///?}

	@Override
	//? >=1.21.3 {
	public void setupAnim(ClayGolemRenderState renderState)
	//?} else {
	/*public void setupAnim(ClayGolem clayGolem, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch)
	*///?}
	{
		//? >=1.21.3 {
		var clayGolem = renderState.clayGolem;
		var limbAngle = renderState.walkAnimationPos;
		var limbDistance = renderState.walkAnimationSpeed;
		var headYaw = renderState.yRot;
		var headPitch = renderState.xRot;
		//?}

		this.head.yRot = headYaw * 0.017453292F;
		this.head.xRot = headPitch * 0.017453292F;
		this.right_leg.xRot = -1.5F * Mth.triangleWave(limbAngle, 13.0F) * limbDistance;
		this.left_leg.xRot = 1.5F * Mth.triangleWave(limbAngle, 13.0F) * limbDistance;
		this.right_leg.yRot = 0.0F;
		this.left_leg.yRot = 0.0F;

		int i = clayGolem.getAttackAnimationTick();
		if (i > 0) {
			this.right_arm.xRot = -2.0F + 1.5F * Mth.triangleWave(i - headYaw, 10.0F);
			this.left_arm.xRot = -2.0F + 1.5F * Mth.triangleWave(i - headYaw, 10.0F);
		} else {
			int j = clayGolem.getOfferFlowerTick();
			if (j > 0) {
				this.right_arm.xRot = -0.8F + 0.025F * Mth.triangleWave(j, 70.0F);
				this.left_arm.xRot = 0.0F;
			} else {
				this.right_arm.xRot = (-0.2F + 1.5F * Mth.triangleWave(limbAngle, 13.0F)) * limbDistance;
				this.left_arm.xRot = (-0.2F - 1.5F * Mth.triangleWave(limbAngle, 13.0F)) * limbDistance;
			}
		}
	}

	public ModelPart getFlowerHoldingArm() {
		return this.right_arm;
	}
}
