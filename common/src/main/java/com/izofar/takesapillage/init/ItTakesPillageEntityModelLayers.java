package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.client.render.entity.model.ClayGolemModel;
import com.izofar.takesapillage.event.client.RegisterEntityModelLayersEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

/**
 * @see net.minecraft.client.model.geom.ModelLayers
 */
@Environment(EnvType.CLIENT)
public final class ItTakesPillageEntityModelLayers
{
	public static final ModelLayerLocation CLAY_GOLEM = new ModelLayerLocation(new ResourceLocation(ItTakesPillage.MOD_ID, "clay_golem"), "main");
	public static final ModelLayerLocation SKIRMISHER = new ModelLayerLocation(new ResourceLocation(ItTakesPillage.MOD_ID, "skirmisher"), "main");
	public static final ModelLayerLocation LEGIONER = new ModelLayerLocation(new ResourceLocation(ItTakesPillage.MOD_ID, "legioner"), "main");


	public static void registerEntityModelLayers(RegisterEntityModelLayersEvent event) {
		event.register(CLAY_GOLEM, ClayGolemModel::createBodyLayer);
		event.register(SKIRMISHER, IllagerModel::createBodyLayer);
		event.register(LEGIONER, IllagerModel::createBodyLayer);
	}

	private ItTakesPillageEntityModelLayers() {
	}
}
