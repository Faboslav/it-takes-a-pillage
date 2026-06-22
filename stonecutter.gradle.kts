val IS_CI = System.getenv("CI") == "true"

plugins {
	id("dev.kikugie.stonecutter")
	id("net.neoforged.moddev") version "2.0.141" apply false
	id("net.fabricmc.fabric-loom") version "1.17-SNAPSHOT" apply false
	id("net.fabricmc.fabric-loom-remap") version "1.17-SNAPSHOT" apply false
}

stonecutter {
	parameters {
		filters.exclude("**/*.accesswidener")

		replacements.string(current.parsed >= "26.2") {
			replace("net.minecraft.advancements.CriteriaTriggers", "net.minecraft.advancements.triggers.CriteriaTriggers")
		}

		replacements.string(current.parsed >= "26.1") {
			replace("ServerWorldEvents", "ServerLevelEvents")
			replace("FabricTrackedDataRegistry", "FabricEntityDataRegistry")
			replace("EntityModelLayerRegistry", "ModelLayerRegistry")
			replace("net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents", "net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents")
			replace("ItemGroupEvents.MODIFY_ENTRIES_ALL", "CreativeModeTabEvents.MODIFY_OUTPUT_ALL")
			replace("net.minecraft.client.renderer.state.CameraRenderState", "net.minecraft.client.renderer.state.level.CameraRenderState")
			replace("chunkpos.x", "chunkpos.x()")
			replace("chunkPos().x", "chunkPos().x()")
			replace("chunkpos.y", "chunkpos.y()")
			replace("chunkPos.y()", "chunkPos().y()")
			replace("chunkpos.z", "chunkpos.z()")
			replace("chunkPos().z", "chunkPos().z()")
		}

		replacements.string(current.parsed >= "1.21.5") {
			replace("net.minecraft.world.entity.animal.Sheep", "net.minecraft.world.entity.animal.sheep.Sheep")
		}

		replacements.string(current.parsed >= "1.21.11") {
			replace("ResourceLocation", "Identifier")
			replace("net.minecraft.Util", "net.minecraft.util.Util")
			replace("net.minecraft.client.renderer.RenderType", "net.minecraft.client.renderer.rendertype.RenderTypes")
			replace("RenderType.lines()", "RenderTypes.lines()")
			replace("net.minecraft.world.level.GameRules", "net.minecraft.world.level.gamerules.GameRules")
			replace("net.minecraft.world.entity.animal.IronGolem", "net.minecraft.world.entity.animal.golem.IronGolem")
			replace("net.minecraft.world.entity.npc.Villager", "net.minecraft.world.entity.npc.villager.Villager")
			replace("net.minecraft.world.entity.monster.AbstractIllager", "net.minecraft.world.entity.monster.illager.AbstractIllager")
			replace("net.minecraft.world.entity.monster.Pillager", "net.minecraft.world.entity.monster.illager.Pillager")
			replace("net.minecraft.world.entity.monster.Vindicator", "net.minecraft.world.entity.monster.illager.Vindicator")
			replace("net.minecraft.world.entity.monster.Evoker", "net.minecraft.world.entity.monster.illager.Evoker")
			replace("net.minecraft.world.entity.animal.Chicken", "net.minecraft.world.entity.animal.chicken.Chicken")
			replace("net.minecraft.world.entity.animal.Cow", "net.minecraft.world.entity.animal.cow.Cow")
			replace("net.minecraft.world.entity.animal.horse.Donkey", "net.minecraft.world.entity.animal.equine.Donkey")
			replace("net.minecraft.world.entity.animal.horse.Horse", "net.minecraft.world.entity.animal.equine.Horse")
			replace("net.minecraft.world.entity.npc.AbstractVillager", "net.minecraft.world.entity.npc.villager.AbstractVillager")
			replace("net.minecraft.world.entity.projectile.AbstractArrow", "net.minecraft.world.entity.projectile.arrow.AbstractArrow")
			replace("net.minecraft.client.model.IllagerModel", "net.minecraft.client.model.monster.illager.IllagerModel")
		}
	}
}

if (IS_CI) stonecutter active null
else stonecutter active "26.2" /* [SC] DO NOT EDIT */
