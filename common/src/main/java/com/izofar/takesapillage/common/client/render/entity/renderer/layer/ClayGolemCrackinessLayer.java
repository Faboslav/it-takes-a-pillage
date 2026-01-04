package com.izofar.takesapillage.common.client.render.entity.renderer.layer;

import com.google.common.collect.ImmutableMap;
import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.client.render.entity.model.ClayGolemModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import java.util.Map;

//? if >=1.21.10 {
import net.minecraft.client.renderer.SubmitNodeCollector;
//?} else {
/*import net.minecraft.client.renderer.MultiBufferSource;
*///?}

//? if >=1.21 {
import net.minecraft.world.entity.Crackiness;
//?} else {
/*import net.minecraft.world.entity.animal.IronGolem;
*///?}

//? if >=1.21.3 {
import com.izofar.takesapillage.common.client.render.entity.state.ClayGolemRenderState;
//?} else {
/*import com.izofar.takesapillage.common.entity.ClayGolem;
*///?}

//? if >=1.21.3 {
public final class ClayGolemCrackinessLayer extends RenderLayer<ClayGolemRenderState, ClayGolemModel>
//?} else {
/*public final class ClayGolemCrackinessLayer extends RenderLayer<ClayGolem, ClayGolemModel>
*///?}
{
	//? if >=1.21 {
	private static final Map<Crackiness.Level, ResourceLocation> resourceLocations = ImmutableMap.of(
		Crackiness.Level.LOW, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_low.png"),
		Crackiness.Level.MEDIUM, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_medium.png"),
		Crackiness.Level.HIGH, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_high.png")
	);
	//?} else {
	/*private static final Map<IronGolem.Crackiness, ResourceLocation> resourceLocations = ImmutableMap.of(
		IronGolem.Crackiness.LOW, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_low.png"),
		IronGolem.Crackiness.MEDIUM, ItTakesPillage.makeId( "textures/entity/clay_golem/clay_golem_crackiness_medium.png"),
		IronGolem.Crackiness.HIGH, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_high.png"));
	*///?}

	//? >=1.21.3 {
	public ClayGolemCrackinessLayer(RenderLayerParent<ClayGolemRenderState, ClayGolemModel> renderLayerParent) {
		super(renderLayerParent);
	}
	//?} else {
	/*public ClayGolemCrackinessLayer(RenderLayerParent<ClayGolem, ClayGolemModel> layer) {
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
		if (clayGolem.isInvisible()) {
			return;
		}

		//? if >=1.21 {
		Crackiness.Level crackiness = clayGolem.getCrackiness();

		if (crackiness != Crackiness.Level.NONE) {
			ResourceLocation resourcelocation = resourceLocations.get(crackiness);
			//? if >=1.21.9 {
			renderColoredCutoutModel(this.getParentModel(), resourcelocation, poseStack, submitNodeCollector, packedLight, clayGolemRenderState, -1, 1);
			//?} else if >=1.21.3 {
			/*renderColoredCutoutModel(this.getParentModel(), resourcelocation, poseStack, bufferSource, packedLight, renderState, -1);
			*///?} else {
			/*renderColoredCutoutModel(this.getParentModel(), resourcelocation, poseStack, bufferSource, packedLight, clayGolem, -1);
			*///?}
		}
		//?} else {
		/*IronGolem.Crackiness crackiness = clayGolem.getCrackiness();

		if (crackiness != IronGolem.Crackiness.NONE) {
			ResourceLocation resourcelocation = resourceLocations.get(crackiness);
			renderColoredCutoutModel(this.getParentModel(), resourcelocation, poseStack, bufferSource, packedLight, clayGolem, 1.0F, 1.0F, 1.0F);
		}
		*///?}
	}
}
