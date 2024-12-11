package com.izofar.takesapillage.client.render.entity.renderer.layer;

import com.google.common.collect.ImmutableMap;
import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.client.render.entity.model.ClayGolemModel;
import com.izofar.takesapillage.entity.ClayGolem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;



import java.util.Map;

/*? >=1.21 {*/
import net.minecraft.world.entity.Crackiness;
/*?} else {*/
/*import net.minecraft.world.entity.animal.IronGolem;
 
*//*?}*/

@Environment(EnvType.CLIENT)
public final class ClayGolemCrackinessLayer extends RenderLayer<ClayGolem, ClayGolemModel>
{
	/*? >=1.21 {*/
	private static final Map<Crackiness.Level, ResourceLocation> resourceLocations = ImmutableMap.of(
		Crackiness.Level.LOW, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_low.png"),
		Crackiness.Level.MEDIUM, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_medium.png"),
		Crackiness.Level.HIGH, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_high.png")
	);
	/*?} else {*/
	/*private static final Map<IronGolem.Crackiness, ResourceLocation> resourceLocations = ImmutableMap.of(
		IronGolem.Crackiness.LOW, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_low.png"),
		IronGolem.Crackiness.MEDIUM, ItTakesPillage.makeId( "textures/entity/clay_golem/clay_golem_crackiness_medium.png"),
		IronGolem.Crackiness.HIGH, ItTakesPillage.makeId("textures/entity/clay_golem/clay_golem_crackiness_high.png"));
	*//*?}*/

	public ClayGolemCrackinessLayer(RenderLayerParent<ClayGolem, ClayGolemModel> layer) {
		super(layer);
	}

	public void render(
		PoseStack stack,
		MultiBufferSource buffersource,
		int i,
		ClayGolem entity,
		float f0,
		float f1,
		float f2,
		float f3,
		float f4,
		float f5
	) {
		if (!entity.isInvisible()) {
			/*? >=1.21 {*/
			Crackiness.Level crackiness = entity.getCrackiness();

			if (crackiness != Crackiness.Level.NONE) {
				ResourceLocation resourcelocation = resourceLocations.get(crackiness);
				renderColoredCutoutModel(this.getParentModel(), resourcelocation, stack, buffersource, i, entity, -1);
			}
			/*?} else {*/
			/*IronGolem.Crackiness crackiness = entity.getCrackiness();

			if (crackiness != IronGolem.Crackiness.NONE) {
				ResourceLocation resourcelocation = resourceLocations.get(crackiness);
				renderColoredCutoutModel(this.getParentModel(), resourcelocation, stack, buffersource, i, entity, 1.0F, 1.0F, 1.0F);
			}
			*//*?}*/
		}
	}
}
