package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.client.render.entity.renderer.ArcherRenderer;
import com.izofar.takesapillage.common.client.render.entity.renderer.ClayGolemRenderer;
import com.izofar.takesapillage.common.client.render.entity.renderer.LegionerRenderer;
import com.izofar.takesapillage.common.client.render.entity.renderer.SkirmisherRenderer;
import com.izofar.takesapillage.common.event.client.RegisterEntityRenderersEvent;

/**
 * @see net.minecraft.client.renderer.entity.EntityRenderers
 */
public final class ItTakesPillageEntityRenderers
{
	public static void registerEntityRenderers(RegisterEntityRenderersEvent event) {
		event.register(ItTakesPillageEntityTypes.CLAY_GOLEM.get(), ClayGolemRenderer::new);
		event.register(ItTakesPillageEntityTypes.ARCHER.get(), ArcherRenderer::new);
		event.register(ItTakesPillageEntityTypes.SKIRMISHER.get(), SkirmisherRenderer::new);
		event.register(ItTakesPillageEntityTypes.LEGIONER.get(), LegionerRenderer::new);
	}

	private ItTakesPillageEntityRenderers() {
	}
}
