package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.event.client.RegisterItemPropertiesEvent;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistries;
import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import com.izofar.takesapillage.item.RavagerHornItem;
import com.izofar.takesapillage.mixin.SpawnEggItemAccessor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Supplier;

/*? >=1.21.3 {*/
/*import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
*//*?}*/

/*? >=1.21 {*/
/*?} else {*/
/*import net.minecraft.world.item.RecordItem;
 *//*?}*/

/**
 * @see net.minecraft.world.item.Items
 */
public final class ItTakesPillageItems
{
	public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<Item> ARCHER_SPAWN_EGG = registerSpawnEgg("archer_spawn_egg", ItTakesPillageEntityTypes.ARCHER, 0xFF243c38, 0xFF916751);
	public static final RegistryEntry<Item> SKIRMISHER_SPAWN_EGG = registerSpawnEgg("skirmisher_spawn_egg", ItTakesPillageEntityTypes.SKIRMISHER, 0x421b1e, 0xFF916751);
	public static final RegistryEntry<Item> LEGIONER_SPAWN_EGG = registerSpawnEgg("legioner_spawn_egg", ItTakesPillageEntityTypes.LEGIONER, 0xFF2b1a33, 0xFF916751);

	public static final RegistryEntry<Item> RAVAGER_HORN = ITEMS.register("ravager_horn", () -> new RavagerHornItem(new Item.Properties().stacksTo(1).durability(1), ItTagesPillageTags.RAVAGER_HORNS));
	/*? >=1.21 {*/
	public static final RegistryEntry<Item> BASTILLE_BLUES_MUSIC_DISC = ITEMS.register("music_disc_bastille_blues", () -> new Item((new Item.Properties()).stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ItTakesPillageJukeboxSongs.BASTILLE_BLUES)));
	/*?} else {*/
	/*public static final RegistryEntry<Item> BASTILLE_BLUES_MUSIC_DISC = ITEMS.register("music_disc_bastille_blues", () -> new RecordItem(4, ItTakesPillageSoundEvents.BASTILLE_BLUES.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3968));
	 *//*?}*/

	private static RegistryEntry<Item> registerSpawnEgg(
		String id,
		Supplier<? extends EntityType<? extends Mob>> typeIn,
		int primaryColorIn,
		int secondaryColorIn
	) {
		return ITEMS.register(id, () -> {
			/*? =1.21.4 {*/
			/*var spawnEgg = new SpawnEggItem(typeIn.get(), new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, ItTakesPillage.makeId(id))));
			 *//*?}*/
			/*? =1.21.3 {*/
			/*var spawnEgg = new SpawnEggItem(typeIn.get(), primaryColorIn, secondaryColorIn, new Item.Properties().stacksTo(64).setId(ResourceKey.create(Registries.ITEM, ItTakesPillage.makeId(id))));
			*//*?}*/
			/*? <=1.21.1 {*/
			var spawnEgg = new SpawnEggItem(typeIn.get(), primaryColorIn, secondaryColorIn, new Item.Properties().stacksTo(64));
			 /*?}*/
			var spawnEggMap = SpawnEggItemAccessor.takesapillage$getIdMap();
			spawnEggMap.put(typeIn.get(), spawnEgg);

			return spawnEgg;
		});
	}

	public static void registerItemProperties(RegisterItemPropertiesEvent event) {
		event.register(
			ItTakesPillageItems.RAVAGER_HORN.get(),
			ItTakesPillage.makeVanillaId("tooting"),
			(stack, level, livingEntity, unusedInt) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F:0.0F
		);
	}
}
