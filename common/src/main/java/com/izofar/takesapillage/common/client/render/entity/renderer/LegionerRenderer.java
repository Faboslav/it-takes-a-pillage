package com.izofar.takesapillage.common.client.render.entity.renderer;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.client.render.entity.model.LegionerModel;
import com.izofar.takesapillage.common.entity.Legioner;
import com.izofar.takesapillage.common.init.ItTakesPillageEntityModelLayers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

//? >= 1.21.3 {
import com.izofar.takesapillage.common.client.render.entity.state.LegionerRenderState;
//?}

@Environment(EnvType.CLIENT)
//? >= 1.21.3 {
public final class LegionerRenderer extends IllagerRenderer<Legioner, LegionerRenderState>
//?} else {
/*public final class LegionerRenderer extends IllagerRenderer<Legioner>
*///?}
{
	private static final ResourceLocation TEXTURE = ItTakesPillage.makeId("textures/entity/legioner.png");

	public LegionerRenderer(EntityRendererProvider.Context context)
	{
		//? >= 1.21.3 {
		super(context, new LegionerModel(context.bakeLayer(ItTakesPillageEntityModelLayers.LEGIONER)), 0.5F);
		//?} else {
		/*super(context, new LegionerModel(context.bakeLayer(ItTakesPillageEntityModelLayers.LEGIONER)), 0.5F);
		 *///?}

		//? >= 1.21.3 {
		this.addLayer(new ItemInHandLayer<>(this));
		//?} else {
		/*this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
		 *///?}
		this.model.getHat().visible = true;
	}

	//? >= 1.21.3 {
	@Override
	public LegionerRenderState createRenderState() {
		return new LegionerRenderState();
	}

	@Override
	public void extractRenderState(Legioner legioner, LegionerRenderState renderState, float partialTick) {
		super.extractRenderState(legioner, renderState, partialTick);
		renderState.legioner = legioner;
	}
	//?}

	@Override
	//? >= 1.21.3 {
	public ResourceLocation getTextureLocation(LegionerRenderState renderState)
	//?} else {
	/*public ResourceLocation getTextureLocation(Legioner legioner)
	*///?}
	{
		return TEXTURE;
	}
}
