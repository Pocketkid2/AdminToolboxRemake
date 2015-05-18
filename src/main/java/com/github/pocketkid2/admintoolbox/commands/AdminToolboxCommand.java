package com.github.pocketkid2.admintoolbox.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.github.pocketkid2.admintoolbox.AdminToolboxPlugin;

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
			sender.sendMessage(ChatColor.RED + "You must be a player!");
			return true;
		}

		// Check for permission
		if (!(sender.hasPermission("admintoolbox.access"))) {
			sender.sendMessage(ChatColor.RED + "You don't have permission for that!");
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
				player.sendMessage(ChatColor.AQUA + "Gave you an AdminToolbox wand!");
				return true;
			} else if (args[0].equalsIgnoreCase("on")) {
				// If it's already on
				if (plugin.isWandOn(player)) {
					// Tell them
					player.sendMessage(ChatColor.AQUA + "The wand is already enabled!");
					return true;
				} else {
					// Otherwise, turn it on and tell them
					plugin.turnWandOn(player);
					player.sendMessage(ChatColor.AQUA + "The wand has been enabled!");
				}
			} else if (args[0].equalsIgnoreCase("off")) {
				// If it's already off
				if (!plugin.isWandOn(player)) {
					// Tell them
					player.sendMessage(ChatColor.AQUA + "The wand is already disabled!");
					return true;
				} else {
					// Otherwise, turn it on and tell them
					plugin.turnWandOff(player);
					player.sendMessage(ChatColor.AQUA + "The wand has been disabled!");
				}
			} else if (args[0].equalsIgnoreCase("toggle")) {
				// Toggle it
				plugin.toggleWand(player);
				player.sendMessage(ChatColor.AQUA + "The wand has been toggled " + (plugin.isWandOn(player) ? "on" : "off") + "!");
			}
		}
		return true;
	}

}
