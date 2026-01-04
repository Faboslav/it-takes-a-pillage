package com.izofar.takesapillage.common.versions;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;


//? if >=1.21.11 {
/*import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRules;
*///?} else {
import net.minecraft.world.level.GameRules;
 //?}

public final class VersionedGameRulesProvider
{
	//? if >=1.21.11 {
	/*public static final GameRule<Boolean> SPAWN_MOBS = GameRules.SPAWN_MOBS;
	public static final GameRule<Boolean> RAIDS = GameRules.RAIDS;
	*///?} else {
	public static final GameRules.Key<GameRules.BooleanValue> SPAWN_MOBS = GameRules.RULE_DOMOBSPAWNING;
	public static final GameRules.Key<GameRules.BooleanValue> RAIDS = GameRules.RULE_DISABLE_RAIDS;
	//?}

	public static boolean getBoolean(
		Entity entity,
		//? if >=1.21.11 {
		/*GameRule<?> gameRule
		*///? } else {
		GameRules.Key<GameRules.BooleanValue> gameRule
		 //?}
	) {
		//? if >= 1.21.11 {
		/*return (Boolean) ((ServerLevel)entity.level()).getGameRules().get(gameRule);
		*///?} else {
		return ((ServerLevel) entity.level()).getGameRules().getBoolean(gameRule);
		 //?}
	}

	public static boolean getBoolean(
		ServerLevel serverLevel,
		//? if >=1.21.11 {
		/*GameRule<?> gameRule
		*///? } else {
		GameRules.Key<GameRules.BooleanValue> gameRule
		 //?}
	) {
		//? if >= 1.21.11 {
		/*return (Boolean) serverLevel.getGameRules().get(gameRule);
		*///?} else {
		return serverLevel.getGameRules().getBoolean(gameRule);
		 //?}
	}

	public static GameRules getGameRules(Entity entity) {
		GameRules gameRules;

		/*? >=1.21.3 {*/
		/*gameRules = ((ServerLevel)entity.level()).getGameRules();
		*//*?} else {*/
		gameRules = entity.level().getGameRules();
		 /*?}*/

		return gameRules;
	}
}