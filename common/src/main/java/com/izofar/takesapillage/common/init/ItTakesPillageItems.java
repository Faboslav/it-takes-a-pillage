package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.item.RavagerHornItem;
import com.izofar.takesapillage.common.mixin.SpawnEggItemAccessor;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.tags.InstrumentTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Function;
import java.util.function.Supplier;

//? if >=1.21.3 {
/*import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import com.teamresourceful.resourcefullib.common.registry.builtin.ResourcefulItemRegistry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
*///?} else {
import com.teamresourceful.resourcefullib.common.registry.ItemLikeResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
//?}

//? if >=1.21 {
//?} else {
import net.minecraft.world.item.RecordItem;
//?}

//? if <1.21.3 {
import com.izofar.takesapillage.common.event.client.RegisterItemPropertiesEvent;
//?}

/**
 * @see net.minecraft.world.item.Items
 */
public final class ItTakesPillageItems
{
	//? >=1.21.4 {
	/*public static final ResourcefulItemRegistry ITEMS = ResourcefulRegistries.createForItems(ItTakesPillage.MOD_ID);
	*///?} else {
	public static final ItemLikeResourcefulRegistry<Item> ITEMS = new ItemLikeResourcefulRegistry<>(BuiltInRegistries.ITEM, ItTakesPillage.MOD_ID);
	//?}

	public static final RegistryEntry<Item> ARCHER_SPAWN_EGG = registerSpawnEgg("archer_spawn_egg", ItTakesPillageEntityTypes.ARCHER, 0xFF243c38, 0xFF916751);
	public static final RegistryEntry<Item> CLAY_GOLEM_SPAWN_EGG = registerSpawnEgg("clay_golem_spawn_egg", ItTakesPillageEntityTypes.CLAY_GOLEM, 0xFF7A7A7A, 0xFF5B7C46);
	public static final RegistryEntry<Item> SKIRMISHER_SPAWN_EGG = registerSpawnEgg("skirmisher_spawn_egg", ItTakesPillageEntityTypes.SKIRMISHER, 0x421b1e, 0xFF916751);
	public static final RegistryEntry<Item> LEGIONER_SPAWN_EGG = registerSpawnEgg("legioner_spawn_egg", ItTakesPillageEntityTypes.LEGIONER, 0xFF2b1a33, 0xFF916751);

	public final static RegistryEntry<Item> RAVAGER_HORN = registerItem("ravager_horn",  (properties) -> new RavagerHornItem(InstrumentTags.GOAT_HORNS, properties), () -> (new Item.Properties()).stacksTo(1).durability(1));
	/*? >= 1.21 {*/
	/*public static final RegistryEntry<Item> BASTILLE_BLUES_MUSIC_DISC = registerItem("music_disc_bastille_blues", Item::new, () -> new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ItTakesPillageJukeboxSongs.BASTILLE_BLUES));
	*//*?} else {*/
	public static final RegistryEntry<Item> BASTILLE_BLUES_MUSIC_DISC = ITEMS.register("music_disc_bastille_blues", () -> new RecordItem(4, ItTakesPillageSoundEvents.BASTILLE_BLUES.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3968));
	 /*?}*/

	private static RegistryEntry<Item> registerItem(String id, Function<Item.Properties, Item> factory, Supplier<Item.Properties> getter) {
		//? >=1.21.4 {
		/*return ITEMS.register(id, factory, getter);
		*///?} else {
		return ITEMS.register(id, () -> factory.apply(getter.get()));
		 //?}
	}

	private static RegistryEntry<Item> registerSpawnEgg(
		String id,
		Supplier<? extends EntityType<? extends Mob>> typeIn,
		int primaryColorIn,
		int secondaryColorIn
	) {
		return ITEMS.register(id, () -> {
			//? if >= 1.21.9 {
			/*var spawnEgg = new SpawnEggItem(new Item.Properties().spawnEgg(typeIn.get()).stacksTo(64).setId(ResourceKey.create(Registries.ITEM, ItTakesPillage.makeId(id))));
			*///?} else if >=1.21.4 {
			/*var spawnEgg = new SpawnEggItem(typeIn.get(), new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, ItTakesPillage.makeId(id))));
			 *///?} else =1.21.3 {
			/*var spawnEgg = new SpawnEggItem(typeIn.get(), primaryColorIn, secondaryColorIn, new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, ItTakesPillage.makeId(id))));
			/*///?} else >=1.21.1 {
			/*var spawnEgg = new SpawnEggItem(typeIn.get(), primaryColorIn, secondaryColorIn, new Item.Properties().stacksTo(64));
			 *///?} else {
			var spawnEgg = new SpawnEggItem(typeIn.get(), primaryColorIn, secondaryColorIn, new Item.Properties().stacksTo(64));
			//?}

			var spawnEggMap = SpawnEggItemAccessor.takesapillage$getSpawnEggs();
			spawnEggMap.put(typeIn.get(), spawnEgg);

			return spawnEgg;
		});
	}

	//? if <1.21.3 {
	public static void registerItemProperties(RegisterItemPropertiesEvent event) {
		event.register(
			ItTakesPillageItems.RAVAGER_HORN.get(),
			ItTakesPillage.makeVanillaId("tooting"),
			(stack, level, livingEntity, unusedInt) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F:0.0F
		);
	}
	//?}
}
