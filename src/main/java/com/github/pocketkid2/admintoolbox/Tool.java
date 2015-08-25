package com.github.pocketkid2.admintoolbox;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// A class that represents a menu item or tool
public abstract class Tool {

	// The type of the item to show in the menu
	protected Material icon;

	// The name of the item to show in the menu
	protected String label;

	// The permission required to use this tool
	protected String permission;

	// Constructor
	public Tool() {
		icon = null;
		label = null;
	}

	// This method sets the defined icon and label and permission
	public abstract void setup();

	// This method sets the defined action for a certain player
	public abstract void execute(Player player);

	// Get the permission string
	public String getPerm() {
		return permission;
	}

	// This method returns an ItemStack that corresponds do this item
	public ItemStack item() {
		// Create a new item stack with the type
		ItemStack stack = new ItemStack(icon, 1);
		// Get the item meta
		ItemMeta meta = stack.getItemMeta();
		// Set the name
		meta.setDisplayName(label);
		// Put back the meta
		stack.setItemMeta(meta);
		// And return it
		return stack;
	}

	// Get the label of this tool
	public String getLabel() {
		return label;
	}
}
