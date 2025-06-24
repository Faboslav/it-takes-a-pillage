package com.izofar.takesapillage.common.init;

import com.izofar.takesapillage.common.ItTakesPillage;
import com.izofar.takesapillage.common.event.AddItemGroupEntriesEvent;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import java.util.List;
import java.util.stream.Stream;

//? >= 1.21.1 {
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CustomData;
//?}

/**
 * @see net.minecraft.world.item.CreativeModeTabs
 */
public class ItTakesPillageItemGroups
{
	public static final ResourcefulRegistry<CreativeModeTab> ITEM_GROUPS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, ItTakesPillage.MOD_ID);
	public static final List<RegistryEntry<Item>> CUSTOM_CREATIVE_TAB_ITEMS = ItTakesPillageItems.ITEMS.stream().toList();

	public static final RegistryEntry<CreativeModeTab> MAIN_TAB = ITEM_GROUPS.register("main_tab", () ->
		CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
			.title((Component.translatable("item_group." + ItTakesPillage.MOD_ID + ".main_tab")))
			.icon(() -> {
				ItemStack iconStack = ItTakesPillageItems.RAVAGER_HORN.get().getDefaultInstance();
				CompoundTag nbtCompound = new CompoundTag();
				nbtCompound.putBoolean("isCreativeTabIcon", true);
				//? >= 1.21.1 {
				iconStack.set(DataComponents.CUSTOM_DATA, CustomData.of(nbtCompound));
				//?}
				return iconStack;
			})
			.displayItems((itemDisplayParameters, entries) ->
				CUSTOM_CREATIVE_TAB_ITEMS.stream().map(item -> item.get().getDefaultInstance()).forEach(entries::accept)
			).build());

	public static void addItemGroupEntries(AddItemGroupEntriesEvent event) {
		if (event.type() == AddItemGroupEntriesEvent.Type.SPAWN_EGGS) {
			Stream.of(
				ItTakesPillageItems.ARCHER_SPAWN_EGG,
				ItTakesPillageItems.SKIRMISHER_SPAWN_EGG,
				ItTakesPillageItems.LEGIONER_SPAWN_EGG
			).map(item -> item.get().getDefaultInstance()).forEach(event::add);
		} else if (event.type() == AddItemGroupEntriesEvent.Type.TOOLS) {
			Stream.of(
				ItTakesPillageItems.RAVAGER_HORN,
				ItTakesPillageItems.BASTILLE_BLUES_MUSIC_DISC
			).map(item -> item.get().getDefaultInstance()).forEach(event::add);
		}
	}
}
