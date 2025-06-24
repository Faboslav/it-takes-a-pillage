package com.izofar.takesapillage.common.client.render.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelPart;

//? >= 1.21.3 {
import com.izofar.takesapillage.common.client.render.entity.state.ArcherRenderState;
//?} else {
/*import com.izofar.takesapillage.common.entity.Archer;
*///?}

@Environment(EnvType.CLIENT)
//? >= 1.21.3 {
public class ArcherModel extends IllagerModel<ArcherRenderState>
//?} else {
/*public class ArcherModel extends IllagerModel<Archer>
*///?}
{
	public ArcherModel(ModelPart root) {
		super(root);
	}
}
