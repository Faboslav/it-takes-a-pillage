package com.izofar.takesapillage.client.render.entity.renderer;


import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.client.render.entity.model.LegionerModel;
import com.izofar.takesapillage.entity.Legioner;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public final class LegionerRenderer extends IllagerRenderer<Legioner>
{
	private static final ResourceLocation LEGIONER = ItTakesPillage.makeId("textures/entity/legioner.png");

	public LegionerRenderer(EntityRendererProvider.Context context) {
		super(context, new LegionerModel(context.bakeLayer(ModelLayers.PILLAGER)), 0.5F);
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
		this.model.getHat().visible = true;
	}

	public ResourceLocation getTextureLocation(Legioner archer) {
		return LEGIONER;
	}
}
