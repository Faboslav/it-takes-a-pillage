package com.izofar.takesapillage.init;

import com.izofar.takesapillage.client.render.entity.renderer.ArcherRenderer;
import com.izofar.takesapillage.client.render.entity.renderer.ClayGolemRenderer;
import com.izofar.takesapillage.client.render.entity.renderer.LegionerRenderer;
import com.izofar.takesapillage.client.render.entity.renderer.SkirmisherRenderer;
import com.izofar.takesapillage.event.client.RegisterEntityRenderersEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * @see net.minecraft.client.renderer.entity.EntityRenderers
 */
@Environment(EnvType.CLIENT)
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
