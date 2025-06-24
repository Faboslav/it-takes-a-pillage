plugins {
	id("fabric-loom")
	`multiloader-loader`
	id("dev.kikugie.j52j") version "2.0"
}

dependencies {
	minecraft("com.mojang:minecraft:${commonMod.mc}")
	mappings(loom.layered {
		officialMojangMappings()
		commonMod.depOrNull("parchment")?.let { parchmentVersion ->
			parchment("org.parchmentmc.data:parchment-${commonMod.mc}:$parchmentVersion@zip")
		}
	})

	modImplementation("net.fabricmc:fabric-loader:${commonMod.dep("fabric_loader")}")
	modApi("net.fabricmc.fabric-api:fabric-api:${commonMod.dep("fabric_api")}+${commonMod.mc}")

	// Required dependencies
	modImplementation(
		"com.teamresourceful.resourcefullib:resourcefullib-fabric-${commonMod.dep("resourceful_lib.mc")}:${
			commonMod.dep(
				"resourceful_lib.lib"
			)
		}"
	)

	modImplementation("dev.isxander:yet-another-config-lib:${commonMod.dep("yacl")}-fabric")

	// Optional dependencies
	modImplementation("com.terraformersmc:modmenu:${commonMod.dep("modmenu")}")
}

loom {
	accessWidenerPath = common.project.file("../../src/main/resources/${mod.id}.accesswidener")

	runs {
		getByName("client") {
			client()
			configName = "Fabric Client"
			ideConfigGenerated(true)
		}
		getByName("server") {
			server()
			configName = "Fabric Server"
			ideConfigGenerated(true)
		}
	}

	mixin {
		defaultRefmapName = "${mod.id}.refmap.json"
	}
}