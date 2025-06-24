package com.izofar.takesapillage.common.client.render.entity.renderer;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.client.render.entity.model.ArcherModel;
import com.izofar.takesapillage.common.entity.Archer;
import com.izofar.takesapillage.common.init.ItTakesPillageEntityModelLayers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

//? >= 1.21.3 {
import com.izofar.takesapillage.common.client.render.entity.state.ArcherRenderState;
//?}

@Environment(EnvType.CLIENT)
//? >= 1.21.3 {
public final class ArcherRenderer extends IllagerRenderer<Archer, ArcherRenderState>
//?} else {
/*public final class ArcherRenderer extends IllagerRenderer<Archer>
*///?}
{
	private static final ResourceLocation TEXTURE = ItTakesPillage.makeId("textures/entity/archer.png");

	public ArcherRenderer(EntityRendererProvider.Context context)
	{
		//? >= 1.21.3 {
		super(context, new ArcherModel(context.bakeLayer(ItTakesPillageEntityModelLayers.ARCHER)), 0.5F);
		//?} else {
		/*super(context, new ArcherModel(context.bakeLayer(ItTakesPillageEntityModelLayers.ARCHER)), 0.5F);
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
	public ArcherRenderState createRenderState() {
		return new ArcherRenderState();
	}

	@Override
	public void extractRenderState(Archer archer, ArcherRenderState renderState, float partialTick) {
		super.extractRenderState(archer, renderState, partialTick);
		renderState.archer = archer;
	}
	//?}

	@Override
	//? >= 1.21.3 {
	public ResourceLocation getTextureLocation(ArcherRenderState renderState)
	//?} else {
	/*public ResourceLocation getTextureLocation(Archer archer)
	*///?}
	{
		return TEXTURE;
	}
}
