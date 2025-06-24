package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.client.render.entity.model.ArcherModel;
import com.izofar.takesapillage.common.client.render.entity.model.ClayGolemModel;
import com.izofar.takesapillage.common.client.render.entity.model.LegionerModel;
import com.izofar.takesapillage.common.client.render.entity.model.SkirmisherModel;
import com.izofar.takesapillage.common.event.client.RegisterEntityModelLayersEvent;
import net.minecraft.client.model.geom.ModelLayerLocation;

/**
 * @see net.minecraft.client.model.geom.ModelLayers
 */
public final class ItTakesPillageEntityModelLayers
{
	public static final ModelLayerLocation ARCHER = new ModelLayerLocation(ItTakesPillage.makeId("archer"), "main");
	public static final ModelLayerLocation CLAY_GOLEM = new ModelLayerLocation(ItTakesPillage.makeId("clay_golem"), "main");
	public static final ModelLayerLocation LEGIONER = new ModelLayerLocation(ItTakesPillage.makeId("legioner"), "main");
	public static final ModelLayerLocation SKIRMISHER = new ModelLayerLocation(ItTakesPillage.makeId("skirmisher"), "main");


	public static void registerEntityModelLayers(RegisterEntityModelLayersEvent event) {
		event.register(ARCHER, ArcherModel::createBodyLayer);
		event.register(CLAY_GOLEM, ClayGolemModel::createBodyLayer);
		event.register(LEGIONER, LegionerModel::createBodyLayer);
		event.register(SKIRMISHER, SkirmisherModel::createBodyLayer);
	}

	private ItTakesPillageEntityModelLayers() {
	}
}
