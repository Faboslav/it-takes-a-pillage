package com.izofar.takesapillage.common.versions;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.chicken.Chicken;
import net.minecraft.world.entity.animal.cow.Cow;
import net.minecraft.world.entity.animal.equine.Donkey;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.entity.animal.golem.IronGolem;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.illager.Evoker;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.entity.npc.villager.Villager;

//? if >=26.2 {
import net.minecraft.world.entity.EntityTypes;
//?}

public class VersionedEntityType
{
	//? if >= 26.2 {
	public static final EntityType<Ravager> RAVAGER = EntityTypes.RAVAGER;
	public static final EntityType<Pillager> PILLAGER = EntityTypes.PILLAGER;
	public static final EntityType<Vindicator> VINDICATOR = EntityTypes.VINDICATOR;
	public static final EntityType<Evoker> EVOKER = EntityTypes.EVOKER;
	public static final EntityType<Villager> VILLAGER = EntityTypes.VILLAGER;
	public static final EntityType<Witch> WITCH = EntityTypes.WITCH;
	public static final EntityType<Cow> COW = EntityTypes.COW;
	public static final EntityType<Sheep> SHEEP = EntityTypes.SHEEP;
	public static final EntityType<Donkey> DONKEY = EntityTypes.DONKEY;
	public static final EntityType<Horse> HORSE = EntityTypes.HORSE;
	public static final EntityType<Chicken> CHICKEN = EntityTypes.CHICKEN;
	public static final EntityType<IronGolem> IRON_GOLEM = EntityTypes.IRON_GOLEM;
	//?} else {
	/*public static final EntityType<Ravager> RAVAGER = EntityType.RAVAGER;
	public static final EntityType<Pillager> PILLAGER = EntityType.PILLAGER;
	public static final EntityType<Vindicator> VINDICATOR = EntityType.VINDICATOR;
	public static final EntityType<Evoker> EVOKER = EntityType.EVOKER;
	public static final EntityType<Villager> VILLAGER = EntityType.VILLAGER;
	public static final EntityType<Witch> WITCH = EntityType.WITCH;
	public static final EntityType<Cow> COW = EntityType.COW;
	public static final EntityType<Sheep> SHEEP = EntityType.SHEEP;
	public static final EntityType<Donkey> DONKEY = EntityType.DONKEY;
	public static final EntityType<Horse> HORSE = EntityType.HORSE;
	public static final EntityType<Chicken> CHICKEN = EntityType.CHICKEN;
	public static final EntityType<IronGolem> IRON_GOLEM = EntityType.IRON_GOLEM;
	*///?}
}
