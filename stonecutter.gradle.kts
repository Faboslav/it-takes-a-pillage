val IS_CI = System.getenv("CI") == "true"

plugins {
	id("dev.kikugie.stonecutter")
	id("net.neoforged.moddev") version "2.0.136" apply false
	id("fabric-loom") version "1.14-SNAPSHOT" apply false
}

stonecutter {
	parameters {
		filters.exclude("**/*.accesswidener")

		replacements.string(current.parsed >= "1.21.11") {
			replace("ResourceLocation", "Identifier")
			replace("net.minecraft.Util", "net.minecraft.util.Util")
			replace("net.minecraft.client.renderer.RenderType", "net.minecraft.client.renderer.rendertype.RenderTypes")
			replace("RenderType.lines()", "RenderTypes.lines()")
			replace("net.minecraft.world.level.GameRules", "net.minecraft.world.level.gamerules.GameRules")
			replace("net.minecraft.world.entity.animal.IronGolem", "net.minecraft.world.entity.animal.golem.IronGolem")
			replace("net.minecraft.world.entity.monster.AbstractIllager", "net.minecraft.world.entity.monster.illager.AbstractIllager")
			replace("net.minecraft.world.entity.npc.AbstractVillager", "net.minecraft.world.entity.npc.villager.AbstractVillager")
			replace("net.minecraft.world.entity.projectile.AbstractArrow", "net.minecraft.world.entity.projectile.arrow.AbstractArrow")
			replace("net.minecraft.client.model.IllagerModel", "net.minecraft.client.model.monster.illager.IllagerModel")
		}
	}
}

if (IS_CI) stonecutter active null
else stonecutter active "1.20.1" /* [SC] DO NOT EDIT */
