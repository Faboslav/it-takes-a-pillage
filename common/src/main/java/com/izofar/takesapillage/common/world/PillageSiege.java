package com.izofar.takesapillage.common.world;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.util.MobLists;
import com.izofar.takesapillage.common.versions.VersionedEntitySpawnReason;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

//? if >= 1.21.1 {
/*import net.minecraft.core.registries.Registries;
*///?}

public final class PillageSiege implements CustomSpawner
{
	public static final PillageSiege PILLAGE_SIEGE = new PillageSiege();

	private boolean hasSetupSiege;
	private State siegeState = State.SIEGE_DONE;
	private int pillagersToSpawn;
	private int nextSpawnTime;
	private int spawnX;
	private int spawnY;
	private int spawnZ;

	//? if >= 1.21.9 {
	/*public void tick(ServerLevel serverLevel, boolean spawnMonsters)
	*///?} else if >=1.21.5 {
	/*public void tick(ServerLevel serverLevel, boolean spawnMonsters, boolean spawnAnimals)
	 *///?} else {
	public int tick(ServerLevel serverLevel, boolean spawnMonsters, boolean spawnAnimals)
	 //?}
	{
		if (
			//? if >=1.21.5 {
			/*serverLevel.isBrightOutside()
			*///?} else {
			serverLevel.isDay()
			//?}
			|| !ItTakesPillage.getConfig().enablePillageSieges
		) {
			this.siegeState = State.SIEGE_DONE;
			this.hasSetupSiege = false;
			return /*? <1.21.5 {*/0/*?}*/;
		}

		//? if >= 1.21.11 {
		/*long l = serverLevel.getDayTime() % 24000L;
		if (l == 12000L) {
			this.siegeState = serverLevel.random.nextInt(10) == 0 ? State.SIEGE_TONIGHT : State.SIEGE_DONE;
		}
		*///?} else {
		float f = serverLevel.getTimeOfDay(0.0F);
		if ((double) f == 0.5D) {
			this.siegeState = serverLevel.random.nextInt(10) == 0 ? State.SIEGE_TONIGHT:State.SIEGE_DONE;
		}
		//?}
		if (this.siegeState == State.SIEGE_DONE) {
			return /*? <1.21.5 {*/0/*?}*/;
		} else {
			if (!this.hasSetupSiege) {
				if (!this.tryToSetupSiege(serverLevel)) {
					return /*? <1.21.5 {*/0/*?}*/;
				}
				this.hasSetupSiege = true;
			}
			if (this.nextSpawnTime > 0) {
				--this.nextSpawnTime;
				return /*? <1.21.5 {*/0/*?}*/;
			} else {
				this.nextSpawnTime = 2;
				if (this.pillagersToSpawn > 0) {
					this.trySpawn(serverLevel);
					--this.pillagersToSpawn;
				} else {
					this.siegeState = State.SIEGE_DONE;
				}
				return /*? <1.21.5 {*/1/*?}*/;
			}
		}
	}

	private boolean tryToSetupSiege(ServerLevel serverLevel) {
		for (Player player : serverLevel.players()) {
			if (!player.isSpectator()) {
				BlockPos blockpos = player.blockPosition();
				if (serverLevel.isVillage(blockpos) && !serverLevel.getBiome(blockpos).is(BiomeTags.WITHOUT_ZOMBIE_SIEGES)) {
					for (int i = 0; i < 10; ++i) {
						float f = serverLevel.random.nextFloat() * ((float) Math.PI * 2F);
						this.spawnX = blockpos.getX() + Mth.floor(Mth.cos(f) * 32.0F);
						this.spawnY = blockpos.getY();
						this.spawnZ = blockpos.getZ() + Mth.floor(Mth.sin(f) * 32.0F);
						Vec3 siegeLocation = this.findRandomSpawnPos(serverLevel, new BlockPos(this.spawnX, this.spawnY, this.spawnZ));
						if (siegeLocation != null) {
							this.nextSpawnTime = 0;
							this.pillagersToSpawn = serverLevel.random.nextInt(6) + 4;
							break;
						}
					}
					//? if >= 1.21.11 {
					/*if (Mth.frac(serverLevel.getDayTime() / 24000.0D) > (11.0D / 24.0D))
					*///?} else {
					if (serverLevel.getTimeOfDay(serverLevel.dayTime()) > Mth.frac(11.0D / 24.0D))
					//?}
					{
						serverLevel.playSound(null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), SoundEvents.RAID_HORN.value(), SoundSource.NEUTRAL, 64.0F, 1.0F);
						serverLevel.playSound(null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), SoundEvents.BELL_BLOCK, SoundSource.BLOCKS, 2.0F, 1.0F);
						serverLevel.gameEvent(null, GameEvent.BLOCK_CHANGE, blockpos);
					}
					return true;
				}
			}
		}
		return false;
	}

	private void trySpawn(ServerLevel serverLevel) {
		Vec3 vec3 = findRandomSpawnPos(serverLevel, new BlockPos(this.spawnX, this.spawnY, this.spawnZ));
		if (vec3 != null) {
			AbstractIllager pillager;

			try {
				//? if >=1.21.5 {
				/*var entityType = MobLists.PILLAGER_SIEGE_LIST.getRandom(serverLevel.random).get();
				*///?} else if >=1.21.1 {
				/*var entityType = MobLists.PILLAGER_SIEGE_LIST.getRandom(serverLevel.random).get().data();
				*///?} else {
				var entityType = MobLists.PILLAGER_SIEGE_LIST.getRandom(serverLevel.random).get().getData();
				//?}
				pillager = entityType.create(serverLevel/*? >=1.21.3 {*//*, VersionedEntitySpawnReason.EVENT*//*?}*/);
				pillager.setPersistenceRequired();
				if (serverLevel.random.nextInt(6) < 1) {
					//? if >= 1.21.3 {
					/*pillager.setItemSlot(EquipmentSlot.HEAD, Raid.getOminousBannerInstance(pillager.registryAccess().lookupOrThrow(Registries.BANNER_PATTERN)));
					*///?} else if >=1.21.1 {
					/*pillager.setItemSlot(EquipmentSlot.HEAD, Raid.getLeaderBannerInstance(pillager.registryAccess().lookupOrThrow(Registries.BANNER_PATTERN)));
					*///?} else {
					pillager.setItemSlot(EquipmentSlot.HEAD, Raid.getLeaderBannerInstance());
					//?}
					pillager.setDropChance(EquipmentSlot.HEAD, 2.0F);
				}
				//? if >=1.21.1 {
				/*pillager.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(pillager.blockPosition()), VersionedEntitySpawnReason.EVENT, null);
				*///?} else {
				pillager.finalizeSpawn(serverLevel, serverLevel.getCurrentDifficultyAt(pillager.blockPosition()), VersionedEntitySpawnReason.EVENT, null, null);
				//?}
			} catch (Exception exception) {
				ItTakesPillage.getLogger().warn("Failed to create pillager for pillage siege at {}", vec3, exception);
				return;
			}
			//? if >=1.21.5 {
			/*pillager.snapTo(vec3.x, vec3.y, vec3.z, serverLevel.random.nextFloat() * 360.0F, 0.0F);
			*///?} else {
			pillager.moveTo(vec3.x, vec3.y, vec3.z, serverLevel.random.nextFloat() * 360.0F, 0.0F);
			//?}
			serverLevel.addFreshEntityWithPassengers(pillager);
		}
	}

	@Nullable
	private Vec3 findRandomSpawnPos(ServerLevel serverLevel, BlockPos blockPos) {
		for (int i = 0; i < 10; i++) {
			int j = blockPos.getX() + serverLevel.random.nextInt(16) - 8;
			int k = blockPos.getZ() + serverLevel.random.nextInt(16) - 8;
			int l = serverLevel.getHeight(Heightmap.Types.WORLD_SURFACE, j, k);
			BlockPos blockpos = new BlockPos(j, l, k);
			if (serverLevel.isVillage(blockpos) && Monster.checkMonsterSpawnRules(EntityType.PILLAGER, serverLevel, VersionedEntitySpawnReason.EVENT, blockpos, serverLevel.random))
				return Vec3.atBottomCenterOf(blockpos);
		}
		return null;
	}

	enum State
	{
		SIEGE_TONIGHT, SIEGE_DONE
	}
}
