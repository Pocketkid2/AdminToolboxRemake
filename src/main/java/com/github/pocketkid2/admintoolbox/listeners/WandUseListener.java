package com.github.pocketkid2.admintoolbox.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.pocketkid2.admintoolbox.AdminToolboxPlugin;

public class WandUseListener implements Listener {

	// Main class reference
	private AdminToolboxPlugin plugin;

	public WandUseListener(AdminToolboxPlugin pl) {
		plugin = pl;
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		// Check for right click
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			// Check for item
			if (event.hasItem()) {
				// Check if it matches the wand item
				if (event.getItem().getType() == plugin.material) {
					// Check if wand is enabled
					if (plugin.isWandOn(event.getPlayer())) {
						// Activate!
						plugin.activate(event.getPlayer());
					}
				}
			}
		}
	}

}
