package com.github.pocketkid2.admintoolbox;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.pocketkid2.admintoolbox.commands.AdminToolboxCommand;
import com.github.pocketkid2.admintoolbox.listeners.InventoryListener;
import com.github.pocketkid2.admintoolbox.listeners.WandUseListener;

public class AdminToolboxPlugin extends JavaPlugin {

	// Whether to log all ATB uses to the console
	public boolean log;

	// Whether to close the toolbox after you click something
	public boolean close;

	// The material to use for the wand
	public Material material;

	// The toolbox class that holds all the tools
	public Toolbox toolbox;

	// This is to keep the warnings away until I find the best way to parse item
	// types from names instead of ID's
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		// Save config
		saveDefaultConfig();

		// Create a new toolbox
		toolbox = new Toolbox(this).setup();

		// Get values from config (defaults are set here too)
		log = getConfig().getBoolean("console-log", false);
		material = Material.getMaterial(getConfig().getInt("wand-id", 369));
		close = getConfig().getBoolean("close-toolbox", true);

		// Log values from config
		getLogger().info("console log is set to " + String.valueOf(log));
		getLogger().info("wand material is set to " + material.toString());
		getLogger().info("close inventory is set to " + String.valueOf(close));

		// Register Command
		getCommand("admintoolbox").setExecutor(new AdminToolboxCommand(this));

		// Register Listeners
		getServer().getPluginManager().registerEvents(new WandUseListener(this), this);
		getServer().getPluginManager().registerEvents(new InventoryListener(this), this);

		// Log status
		getLogger().info("Done!");
	}

	@Override
	public void onDisable() {

		// Log status
		getLogger().info("Done!");
	}

	// Check for permission, and open the inventory!
	public void activate(Player player) {
		// Check for permission
		if (!(player.hasPermission("admintoolbox.access"))) {
			player.sendMessage(ChatColor.RED + "You can't open the toolbox!");
			return;
		}

		// Assemble the inventory
		Inventory inv = Bukkit.createInventory(player, InventoryType.CHEST, "Admin Toolbox");
		// For every tool in the toolbox
		for (Tool t : toolbox.tools) {
			// If we have access to that tool
			if (player.hasPermission(t.getPerm())) {
				// Add the item stack to the inventory
				inv.addItem(t.item());
			}
		}
		// If toolbox is empty, notify the player
		if (isEmpty(inv)) {
			player.sendMessage(ChatColor.RED + "You don't have access to any tools!");
		} else {
			// Show it to the player!
			player.openInventory(inv);
		}
	}

	// Check if the player has the wand turned off in it's metadata
	public boolean isWandOn(Player player) {
		// Check if metadata for the player exists
		if (player.hasMetadata("wand")) {
			// Check through each metadata value
			for (MetadataValue value : player.getMetadata("wand")) {
				// If the name of the owning plugin is us
				if (value.getOwningPlugin().getName().equalsIgnoreCase(getName())) {
					// Return the boolean value inside
					return value.asBoolean();
				}
			}
		}
		// If it doesn't exist, create it
		player.setMetadata("wand", new FixedMetadataValue(this, true));
		// And return the default value
		return true;
	}

	public void turnWandOn(Player player) {
		// Set a new metadatavalue
		player.setMetadata("wand", new FixedMetadataValue(this, true));
	}

	public void turnWandOff(Player player) {
		// Set a new metadatavalue
		player.setMetadata("wand", new FixedMetadataValue(this, false));
	}

	public void toggleWand(Player player) {
		// If it is on
		if (isWandOn(player)) {
			// Turn it off
			turnWandOff(player);
		} else {
			// Turn it on
			turnWandOn(player);
		}
	}

	// Return true if inventory is empty
	public boolean isEmpty(Inventory inv) {
		// Number of empty slots
		int count = 0;
		// For each slot
		for (ItemStack item : inv.getContents()) {
			// If it's empty
			if (item == null) {
				// Increase count
				count++;
			}
		}
		// If count is same as max inventory size
		if (count == inv.getSize()) {
			// The inventory is empty
			return true;
		} else {
			// The inventory is not empty
			return false;
		}
	}

}
