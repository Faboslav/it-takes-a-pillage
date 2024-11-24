package com.izofar.takesapillage.client.render.entity.renderer;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.entity.Archer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public final class ArcherRenderer extends IllagerRenderer<Archer>
{
	private static final ResourceLocation ARCHER = ItTakesPillage.makeId("textures/entity/archer.png");

	public ArcherRenderer(EntityRendererProvider.Context context) {
		super(context, new IllagerModel<>(context.bakeLayer(ModelLayers.EVOKER)), 0.5F);
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
		this.model.getHat().visible = true;
	}

	public ResourceLocation getTextureLocation(Archer archer) {
		return ARCHER;
	}
}
