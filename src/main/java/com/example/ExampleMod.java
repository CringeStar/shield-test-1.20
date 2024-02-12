package com.example;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricBannerShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ExampleMod implements ModInitializer {

	public static final Item NETHERITE_SHIELD = new FabricShieldItem(new FabricItemSettings().maxDamage(2500), 10, 13, Items.NETHERITE_INGOT); // FabricShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)
	public static final Item NETHERITE_BANNER_SHIELD = new FabricBannerShieldItem(new FabricItemSettings().maxDamage(2500), 10, 13, Items.NETHERITE_INGOT); // FabricBannerShieldItem(settings.maxDamage(durability), cooldownTicks, enchantability, repairItem)


	@Override
	public void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.addAfter(Items.SHIELD,NETHERITE_SHIELD);
			entries.addAfter(Items.SHIELD,NETHERITE_BANNER_SHIELD);
		});

		Registry.register(Registries.ITEM, new Identifier("examplemod", "netherite_shield"), NETHERITE_SHIELD);
		Registry.register(Registries.ITEM, new Identifier("examplemod", "netherite_banner_shield"), NETHERITE_BANNER_SHIELD);

	}
}