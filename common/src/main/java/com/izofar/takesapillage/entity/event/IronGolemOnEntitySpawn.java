package com.izofar.takesapillage.entity.event;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.entity.ClayGolem;
import com.izofar.takesapillage.event.entity.EntitySpawnEvent;
import com.izofar.takesapillage.init.ItTakesPillageEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;

public final class IronGolemOnEntitySpawn
{
	public static boolean handleEntitySpawn(EntitySpawnEvent event) {
		if (
			event.spawnType() != MobSpawnType.NATURAL
			&& event.spawnType() != MobSpawnType.SPAWNER
			&& event.spawnType() != MobSpawnType.CHUNK_GENERATION
			&& event.spawnType() != MobSpawnType.STRUCTURE
		) {
			return false;
		}

		Mob entity = event.entity();

		if (entity.getType() != EntityType.IRON_GOLEM) {
			return false;
		}

		if (!ItTakesPillage.getConfig().replaceIronGolemsWithClayGolems) {
			return false;
		}

		var level = event.level();

		/*? >=1.21 {*/
		ClayGolem clayGolem = ItTakesPillageEntityTypes.CLAY_GOLEM.get().create(
			(ServerLevel) level,
			null,
			event.entity().blockPosition(),
			event.spawnType(),
			false,
			false
		);
		/*?} else {*/
			/*ClayGolem clayGolem = ItTakesPillageEntityTypes.CLAY_GOLEM.get().create(
				(ServerLevel) level,
				null,
				null,
				event.entity().blockPosition(),
				event.spawnType(),
				false,
				false
			);
		*//*?}*/

		if (clayGolem == null) {
			return false;
		}

		clayGolem.copyPosition(entity);
		clayGolem.yBodyRotO = entity.yBodyRotO;
		clayGolem.yBodyRot = entity.yBodyRot;
		clayGolem.yHeadRotO = entity.yHeadRotO;
		clayGolem.yHeadRot = entity.yHeadRot;
		clayGolem.setBaby(event.isBaby());
		level.addFreshEntity(clayGolem);

		return true;
	}
}
