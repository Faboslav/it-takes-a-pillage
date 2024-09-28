package com.izofar.takesapillage.init;

import com.izofar.takesapillage.ItTakesPillage;
import com.izofar.takesapillage.event.client.RegisterItemPropertiesEvent;
import com.izofar.takesapillage.init.registry.RegistryEntry;
import com.izofar.takesapillage.init.registry.ResourcefulRegistries;
import com.izofar.takesapillage.init.registry.ResourcefulRegistry;
import com.izofar.takesapillage.item.DispenserAddedSpawnEgg;
import com.izofar.takesapillage.item.RavagerHornItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public final class ItTakesPillageItems
{
	public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, ItTakesPillage.MOD_ID);

	public static final RegistryEntry<Item> ARCHER_SPAWN_EGG = ITEMS.register("archer_spawn_egg", () -> new DispenserAddedSpawnEgg(ItTakesPillageEntityTypes.ARCHER, 0x243c38, 0x916751, new Item.Properties()));
	public static final RegistryEntry<Item> SKIRMISHER_SPAWN_EGG = ITEMS.register("skirmisher_spawn_egg", () -> new DispenserAddedSpawnEgg(ItTakesPillageEntityTypes.SKIRMISHER, 0x421b1e, 0x916751, new Item.Properties()));
	public static final RegistryEntry<Item> LEGIONER_SPAWN_EGG = ITEMS.register("legioner_spawn_egg", () -> new DispenserAddedSpawnEgg(ItTakesPillageEntityTypes.LEGIONER, 0x2b1a33, 0x916751, new Item.Properties()));

	public static final RegistryEntry<Item> RAVAGER_HORN = ITEMS.register("ravager_horn", () -> new RavagerHornItem(new Item.Properties().stacksTo(1).durability(1), ItTagesPillageTags.RAVAGER_HORNS));
	public static final RegistryEntry<Item> BASTILLE_BLUES_MUSIC_DISC = ITEMS.register("bastille_blues_music_disc", () -> new RecordItem(4, ItTakesPillageSoundEvents.BASTILLE_BLUES.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3968));

	public static void registerItemProperties(RegisterItemPropertiesEvent event) {
		event.register(
			ItTakesPillageItems.RAVAGER_HORN.get(),
			ItTakesPillage.makeVanillaId("tooting"),
			(stack, level, livingEntity, unusedInt) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F:0.0F
		);
	}
}
