package com.github.pocketkid2.admintoolbox.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.pocketkid2.admintoolbox.AdminToolboxPlugin;
import com.github.pocketkid2.admintoolbox.utils.Messages;

public class AdminToolboxCommand implements CommandExecutor {

	// Main class reference
	private AdminToolboxPlugin plugin;

	public AdminToolboxCommand(AdminToolboxPlugin pl) {
		plugin = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Check for player
		if (!(sender instanceof Player)) {
			sender.sendMessage(Messages.MUST_BE_PLAYER);
			return true;
		}

		// Check for permission
		if (!(sender.hasPermission("admintoolbox.access"))) {
			sender.sendMessage(Messages.NO_PERM);
			return true;
		}

		// Get a player object
		Player player = (Player) sender;

		// Check for no arguments
		if (args.length == 0) {
			// Activate!
			plugin.activate((Player) sender);
			return true;
		}

		// Check for one argument
		if (args.length == 1) {
			// Check what the label is
			if (args[0].equalsIgnoreCase("wand")) {
				// Give them a wand
				player.getInventory().addItem(new ItemStack(plugin.material, 1));
				player.sendMessage(Messages.GOT_WAND);
				return true;
			} else if (args[0].equalsIgnoreCase("on")) {
				// If it's already on
				if (plugin.isWandOn(player)) {
					// Tell them
					player.sendMessage(Messages.WAND_ALREADY_ENABLED);
					return true;
				} else {
					// Otherwise, turn it on and tell them
					plugin.turnWandOn(player);
					player.sendMessage(Messages.WAND_ENABLED);
				}
			} else if (args[0].equalsIgnoreCase("off")) {
				// If it's already off
				if (!plugin.isWandOn(player)) {
					// Tell them
					player.sendMessage(Messages.WAND_ALREADY_DISABLED);
					return true;
				} else {
					// Otherwise, turn it on and tell them
					plugin.turnWandOff(player);
					player.sendMessage(Messages.WAND_DISABLED);
				}
			} else if (args[0].equalsIgnoreCase("toggle")) {
				// Toggle it
				plugin.toggleWand(player);
				player.sendMessage(plugin.isWandOn(player) ? Messages.WAND_ENABLED : Messages.WAND_DISABLED);
			}
		}
		return true;
	}

}
