package com.izofar.takesapillage.common.entity.event;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.entity.ClayGolem;
import com.izofar.takesapillage.common.event.entity.EntitySpawnEvent;
import com.izofar.takesapillage.common.init.ItTakesPillageEntityTypes;
import com.izofar.takesapillage.common.versions.VersionedEntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ServerLevelAccessor;

public final class IronGolemOnEntitySpawn
{
	public static boolean handleEntitySpawn(EntitySpawnEvent event) {
		if (
			event.spawnReason() != VersionedEntitySpawnReason.NATURAL
			&& event.spawnReason() != VersionedEntitySpawnReason.SPAWNER
			&& event.spawnReason() != VersionedEntitySpawnReason.CHUNK_GENERATION
			&& event.spawnReason() != VersionedEntitySpawnReason.STRUCTURE
		) {
			return false;
		}

		Mob entity = event.entity();

		if (entity.getType() != EntityType.IRON_GOLEM) {
			return false;
		}

		if (!ItTakesPillage.getConfig().enableClayGolem || !ItTakesPillage.getConfig().replaceIronGolemsWithClayGolems) {
			return false;
		}

		var level = event.worldAccess();
		ClayGolem clayGolem = ItTakesPillageEntityTypes.CLAY_GOLEM.get().create(entity.level()/*? >=1.21.3 {*/, event.spawnReason()/*?}*/);

		if (clayGolem == null) {
			return false;
		}

		//? if >=1.21.5 {
		clayGolem.snapTo(entity.getX(), entity.getY(), entity.getZ(), clayGolem.getRandom().nextFloat() * 360.0F, 0.0F);
		//?} else {
		/*clayGolem.moveTo(entity.getX(), entity.getY(), entity.getZ(), clayGolem.getRandom().nextFloat() * 360.0F, 0.0F);
		*///?}

		clayGolem.copyPosition(entity);
		clayGolem.yBodyRotO = entity.yBodyRotO;
		clayGolem.yBodyRot = entity.yBodyRot;
		clayGolem.yHeadRotO = entity.yHeadRotO;
		clayGolem.yHeadRot = entity.yHeadRot;
		clayGolem.setBaby(entity.isBaby());
		clayGolem.setNoAi(entity.isNoAi());
		clayGolem.setInvulnerable(entity.isInvulnerable());


		if(entity.hasCustomName()) {
			clayGolem.setCustomName(entity.getCustomName());
			clayGolem.setCustomNameVisible(entity.isCustomNameVisible());
		}

		if (entity.isPersistenceRequired()) {
			clayGolem.setPersistenceRequired();
		}

		clayGolem.setCanPickUpLoot(entity.canPickUpLoot());

		clayGolem.finalizeSpawn(
			(ServerLevelAccessor) level,
			level.getCurrentDifficultyAt(entity.blockPosition()),
			event.spawnReason(),
			/*? <1.21.1 {*/ /*null,*//*?}*/
			null
		);

		boolean spawnResult = level.addFreshEntity(clayGolem);

		if(!spawnResult) {
			entity.discard();
			return false;
		}

		return true;
	}
}
