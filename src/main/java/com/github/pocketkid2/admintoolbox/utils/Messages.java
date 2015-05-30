package com.github.pocketkid2.admintoolbox.utils;

import org.bukkit.ChatColor;

public interface Messages {
	String WAND_ENABLED = ChatColor.AQUA + "The wand has been " + ChatColor.GREEN + "enabled" + ChatColor.AQUA + "!";
	String WAND_DISABLED = ChatColor.AQUA + "The wand has been " + ChatColor.RED + "disabled" + ChatColor.AQUA + "!";
	String WAND_ALREADY_ENABLED = ChatColor.AQUA + "The wand is already " + ChatColor.GREEN + "enabled" + ChatColor.AQUA + "!";
	String WAND_ALREADY_DISABLED = ChatColor.AQUA + "The wand is already " + ChatColor.RED + "disabled" + ChatColor.AQUA + "!";
	String GOT_WAND = ChatColor.AQUA + "Gave you an AdminToolbox wand!";
	String MUST_BE_PLAYER = ChatColor.RED + "You must be a player!";
	String NO_PERM = ChatColor.RED + "You don't have permission for that!";
}
