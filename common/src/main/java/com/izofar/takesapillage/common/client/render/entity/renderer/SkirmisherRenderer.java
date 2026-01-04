package com.izofar.takesapillage.common.client.render.entity.renderer;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.client.render.entity.model.SkirmisherModel;
import com.izofar.takesapillage.common.entity.Skirmisher;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;

//? if <= 1.21.3 {
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
//?}

//? >= 1.21.3 {
/*import com.izofar.takesapillage.common.client.render.entity.state.SkirmisherRenderState;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.world.entity.monster.illager.AbstractIllager;
import net.minecraft.world.item.CrossbowItem;
*///?} else {
import com.izofar.takesapillage.common.init.ItTakesPillageEntityModelLayers;
//?}

//? >= 1.21.3 {
/*public final class SkirmisherRenderer extends MobRenderer<Skirmisher, SkirmisherRenderState, SkirmisherModel>
*///?} else {
public final class SkirmisherRenderer extends MobRenderer<Skirmisher, SkirmisherModel>
//?}
{
	private static final ResourceLocation TEXTURE = ItTakesPillage.makeId("textures/entity/skirmisher.png");
	public static final float SCALE = 0.9375F;

	public SkirmisherRenderer(EntityRendererProvider.Context context) {
		//? >= 1.21.3 {
		/*super(context, new SkirmisherModel(SkirmisherModel.createBodyLayer().bakeRoot()), 0.5F);
		//this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), this));
		this.addLayer(new ItemInHandLayer<>(this));
		*///?} else {
		super(context, new SkirmisherModel(context.bakeLayer(ItTakesPillageEntityModelLayers.SKIRMISHER)), 0.5F);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
		//?}
	}

	@Override
	protected void scale(
		//? >=1.21.3 {
		/*SkirmisherRenderState renderState,
		*///?} else {
		Skirmisher skirmisher,
		//?}
		PoseStack poseStack
		//? <1.21.3 {
		,float partialTickTime
		//?}
	) {
		poseStack.scale(SCALE, SCALE, SCALE);
	}

	//? >= 1.21.3 {
	/*@Override
	public SkirmisherRenderState createRenderState() {
		return new SkirmisherRenderState();
	}

	@Override
	public void extractRenderState(Skirmisher skirmisher, SkirmisherRenderState renderState, float partialTick) {
		super.extractRenderState(skirmisher, renderState, partialTick);
		renderState.skirmisher = skirmisher;
		//? if >= 1.21.11 {
		/^ArmedEntityRenderState.extractArmedEntityRenderState(skirmisher, renderState, this.itemModelResolver, partialTick);
		^///?} else {
		ArmedEntityRenderState.extractArmedEntityRenderState(skirmisher, renderState, this.itemModelResolver);
		//?}
		renderState.isRiding = skirmisher.isPassenger();
		renderState.mainArm = skirmisher.getMainArm();
		renderState.armPose = skirmisher.getArmPose();
		renderState.maxCrossbowChargeDuration = renderState.armPose == AbstractIllager.IllagerArmPose.CROSSBOW_CHARGE ? CrossbowItem.getChargeDuration(skirmisher.getUseItem(), skirmisher) : 0;
		renderState.ticksUsingItem = skirmisher.getTicksUsingItem();
		renderState.attackAnim = skirmisher.getAttackAnim(partialTick);
		renderState.isAggressive = skirmisher.isAggressive();
	}
	*///?}

	@Override
	//? >= 1.21.3 {
	/*public Identifier getTextureLocation(SkirmisherRenderState renderState)
	*///?} else {
	public ResourceLocation getTextureLocation(Skirmisher skirmisher)
	//?}
	{
		return TEXTURE;
	}
}
