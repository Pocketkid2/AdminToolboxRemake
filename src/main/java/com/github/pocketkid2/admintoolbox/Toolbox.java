package com.github.pocketkid2.admintoolbox;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

// The class that represents the collection of menu items, or the toolbox
public class Toolbox {

	// A list of all the tools in this toolbox
	public List<Tool> tools;

	// Main class reference
	public AdminToolboxPlugin plugin;

	// Constructor
	public Toolbox(AdminToolboxPlugin pl) {
		plugin = pl;
	}

	// This method is where all the tools are added
	public Toolbox setup() {
		// Setup list
		tools = new ArrayList<Tool>();

		// -----------------
		// GAMEMODE SURVIVAL
		// A grass block that changes your gamemode into survival
		// -----------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.GRASS;
				label = ChatColor.GREEN + "Survival Mode";
				permission = "admintoolbox.use.gamemode";
			}

			@Override
			public void execute(Player player) {
				player.setGameMode(GameMode.SURVIVAL);
			}

		});

		// -----------------
		// GAMEMODE CREATIVE
		// A grass block that changes your gamemode into creative
		// -----------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.GRASS;
				label = ChatColor.GREEN + "Creative Mode";
				permission = "admintoolbox.use.gamemode";
			}

			@Override
			public void execute(Player player) {
				player.setGameMode(GameMode.CREATIVE);
			}

		});

		// ------------------
		// GAMEMODE ADVENTURE
		// A grass block that changes your gamemode into adventure
		// ------------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.GRASS;
				label = ChatColor.GREEN + "Adventure Mode";
				permission = "admintoolbox.use.gamemode";
			}

			@Override
			public void execute(Player player) {
				player.setGameMode(GameMode.ADVENTURE);
			}

		});

		// ------------------
		// GAMEMODE SPECTATOR
		// A grass block that changes your gamemode into spectator
		// ------------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.GRASS;
				label = ChatColor.GREEN + "Spectator Mode";
				permission = "admintoolbox.use.gamemode";
			}

			@Override
			public void execute(Player player) {
				player.setGameMode(GameMode.SPECTATOR);
			}

		});

		// ------------
		// TIME MORNING
		// Set the time to morning
		// ------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.WATCH;
				label = ChatColor.GOLD + "Time Morning";
				permission = "admintoolbox.use.time";
			}

			@Override
			public void execute(Player player) {
				player.getWorld().setTime(0);
			}

		});

		// ---------
		// TIME NOON
		// Set the time to morning
		// ---------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.WATCH;
				label = ChatColor.GOLD + "Time Noon";
				permission = "admintoolbox.use.time";
			}

			@Override
			public void execute(Player player) {
				player.getWorld().setTime(6000);
			}

		});

		// ------------
		// TIME EVENING
		// Set the time to morning
		// ------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.WATCH;
				label = ChatColor.GOLD + "Time Evening";
				permission = "admintoolbox.use.time";
			}

			@Override
			public void execute(Player player) {
				player.getWorld().setTime(12000);
			}

		});

		// -------------
		// TIME MIDNIGHT
		// Set the time to morning
		// -------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.WATCH;
				label = ChatColor.GOLD + "Time Midnight";
				permission = "admintoolbox.use.time";
			}

			@Override
			public void execute(Player player) {
				player.getWorld().setTime(18000);
			}

		});

		// -----------
		// GO TO SPAWN
		// Teleports you to the world's spawn
		// -----------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.COMPASS;
				label = ChatColor.DARK_AQUA + "Go To Spawn";
				permission = "admintoolbox.use.spawn";
			}

			@Override
			public void execute(Player player) {
				player.teleport(player.getWorld().getSpawnLocation());
			}

		});

		// -----------
		// WEATHER SUN
		// Set's the weather in your world to sunny/clear
		// -----------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.DOUBLE_PLANT;
				label = ChatColor.GRAY + "Weather Sun";
				permission = "admintoolbox.use.weather";
			}

			@Override
			public void execute(Player player) {
				player.getWorld().setStorm(false);
				player.getWorld().setThundering(false);
			}

		});

		// -----------
		// WEATHER RAIN
		// Set's the weather in your world to rainy
		// -----------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.GHAST_TEAR;
				label = ChatColor.GRAY + "Weather Rain";
				permission = "admintoolbox.use.weather";
			}

			@Override
			public void execute(Player player) {
				player.getWorld().setStorm(true);
				player.getWorld().setThundering(false);
			}

		});

		// -----------
		// WEATHER THUNDER
		// Set's the weather in your world to thunder
		// -----------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.SNOW_BALL;
				label = ChatColor.GRAY + "Weather Thunder";
				permission = "admintoolbox.use.weather";
			}

			@Override
			public void execute(Player player) {
				player.getWorld().setStorm(true);
				player.getWorld().setThundering(true);
			}

		});

		// --------------
		// NIGHTVISION ON
		// Gives you a night vision potion effect
		// --------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.EYE_OF_ENDER;
				label = ChatColor.RED + "Night Vision On";
				permission = "admintoolbox.use.nightvision";
			}

			@Override
			public void execute(Player player) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 99999999, 0, false, false), true);
			}

		});

		// --------------
		// NIGHTVISION OFF
		// Takes away the night vision potion effect
		// --------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.EYE_OF_ENDER;
				label = ChatColor.RED + "Night Vision Off";
				permission = "admintoolbox.use.nightvision";
			}

			@Override
			public void execute(Player player) {
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
			}
		});

		// --------------
		// INVISIBILITY ON
		// Gives you an invisibility potion effect
		// --------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.MAGMA_CREAM;
				label = ChatColor.RED + "Invisibility On";
				permission = "admintoolbox.use.invisibility";
			}

			@Override
			public void execute(Player player) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999999, 0, false, false), true);
			}

		});

		// --------------
		// INVISIBILITY OFF
		// Takes away the invisibility potion effect
		// --------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.MAGMA_CREAM;
				label = ChatColor.RED + "Invisibility Off";
				permission = "admintoolbox.use.invisibility";
			}

			@Override
			public void execute(Player player) {
				player.removePotionEffect(PotionEffectType.INVISIBILITY);
			}
		});

		// -----------------
		// RELOAD THE SERVER
		// Reloads all plugins on the server
		// -----------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.SLIME_BALL;
				label = ChatColor.BOLD + "Reload the Server";
				permission = "admintoolbox.use.reload";
			}

			@Override
			public void execute(Player player) {
				new BukkitRunnable() {

					@Override
					public void run() {
						player.getServer().reload();
					}

				}.runTaskLater(plugin, 20);
			}

		});

		// ---------------
		// STOP THE SERVER
		// Stops the server completely
		// ---------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.SLIME_BALL;
				label = ChatColor.BOLD + "Stop the Server";
				permission = "admintoolbox.use.stop";
			}

			@Override
			public void execute(Player player) {
				new BukkitRunnable() {

					@Override
					public void run() {
						player.getServer().shutdown();
					}

				}.runTaskLater(plugin, 20);
			}

		});

		// -----------------------
		// PORTABLE CRAFTING TABLE
		// Opens a crafting view, without needing the actual block
		// -----------------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.WORKBENCH;
				label = ChatColor.BLUE + "Portable Crafting Table";
				permission = "admintoolbox.use.crafting";
			}

			@Override
			public void execute(Player player) {
				new BukkitRunnable() {

					@Override
					public void run() {
						player.closeInventory();
						player.openWorkbench(null, true);
					}

				}.runTaskLater(plugin, 1);
			}

		});

		// --------------------
		// PORTABLE ENDER CHEST
		// Opens your ender chest for access without needing the actual block
		// --------------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.ENDER_CHEST;
				label = ChatColor.BLUE + "Portable Ender Chest";
				permission = "admintoolbox.use.enderchest";
			}

			@Override
			public void execute(Player player) {
				new BukkitRunnable() {

					@Override
					public void run() {
						player.closeInventory();
						player.openInventory(player.getEnderChest());
					}

				}.runTaskLater(plugin, 1);
			}

		});

		/*-
		// ----------------
		// PORTABLE FURNACE
		// Opens a furnace that you can use, without needing the actual block
		// NOTE: Items are lost when you close this inventory
		// ----------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.FURNACE;
				label = ChatColor.BLUE + "Portable Furnace";
			}

			@Override
			public void execute(Player player) {
				new BukkitRunnable() {

					@Override
					public void run() {
						Inventory inv = Bukkit.createInventory(player, InventoryType.FURNACE, "Portable Furnace");
						player.closeInventory();
						player.openInventory(inv);
					}

				}.runTaskLater(plugin, 1);
			}

		});

		// ----------------
		// PORTABLE BREWING
		// Opens a brewing stand that you can use, without needing the actual
		// block
		// NOTE: Items are lost when you close this inventory
		// ----------------
		tools.add(new Tool() {

			@Override
			public void setup() {
				icon = Material.BREWING_STAND_ITEM;
				label = ChatColor.BLUE + "Portable Brewing Stand";
			}

			@Override
			public void execute(Player player) {
				new BukkitRunnable() {

					@Override
					public void run() {
						Inventory inv = Bukkit.createInventory(player, InventoryType.BREWING, "Portable Brewing");
						player.closeInventory();
						player.openInventory(inv);
					}

				}.runTaskLater(plugin, 1);
			}

		});
		 */

		// Before we go, call all the setup() methods
		for (Tool t : tools) {
			t.setup();
		}

		return this;
	}
}