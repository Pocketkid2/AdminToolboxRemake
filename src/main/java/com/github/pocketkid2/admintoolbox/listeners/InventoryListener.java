package com.github.pocketkid2.admintoolbox.listeners;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.pocketkid2.admintoolbox.AdminToolboxPlugin;
import com.github.pocketkid2.admintoolbox.Tool;

public class InventoryListener implements Listener {

	private AdminToolboxPlugin plugin;

	public InventoryListener(AdminToolboxPlugin pl) {
		plugin = pl;
	}

	// Called when you click an item in an inventory
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		// Check for player
		if (event.getWhoClicked() instanceof Player) {
			// Check inventory name
			if (event.getInventory().getName().equalsIgnoreCase("Admin Toolbox")) {
				// Cancel the click
				event.setCancelled(true);

				Player player = (Player) event.getWhoClicked();

				// Look through all the tools
				for (Tool t : plugin.toolbox.tools) {
					// If the item matches
					if (t.item().equals(event.getCurrentItem())) {
						// Execute it
						t.execute(player);

						// Tell the player
						player.sendMessage(ChatColor.AQUA + "You activated " + t.item().getItemMeta().getDisplayName());

						// If console logging is on
						if (plugin.log) {
							// Log it
							plugin.getLogger().info(player.getName() + " use the toolbox to activate: " + t.item().getItemMeta().getDisplayName());
						}

						// If we want to close the inventory, then set up a task
						// to do it.
						if (plugin.close) {
							new BukkitRunnable() {
								// This will close the inventory, but because of
								// API limitations cannot be called inside the
								@Override
								public void run() {
									player.closeInventory();
								}
							}.runTask(plugin);
						}
					}
				}
			}
		}
	}

}
