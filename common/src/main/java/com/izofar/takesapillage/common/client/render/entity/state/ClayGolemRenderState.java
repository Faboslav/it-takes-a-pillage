//? >= 1.21.3 {
package com.izofar.takesapillage.common.client.render.entity.state;

import com.izofar.takesapillage.common.entity.ClayGolem;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

//? if >= 26.1 {
import net.minecraft.client.renderer.block.BlockModelRenderState;
//?}

public final class ClayGolemRenderState extends LivingEntityRenderState
{
	public ClayGolem clayGolem;
	//? if >= 26.1 {
	public final BlockModelRenderState poppyFlowerModel;
	//?}

	public ClayGolemRenderState() {
		//? if >= 26.1 {
		this.poppyFlowerModel = new BlockModelRenderState();
		//?}
	}
}
//?}