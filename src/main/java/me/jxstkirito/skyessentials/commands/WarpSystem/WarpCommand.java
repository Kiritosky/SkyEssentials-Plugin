package me.jxstkirito.skyessentials.commands.WarpSystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WarpCommand implements CommandExecutor {

    private Map<String, Location> warps = new HashMap<>();
    private FileConfiguration config;
    private File configFile;

    public WarpCommand() {
        configFile = new File(Bukkit.getServer().getPluginManager().getPlugin("SkyEssentials").getDataFolder(), "warps.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile);
        loadWarps();
    }

    private void loadWarps() {
        for (String key : config.getKeys(false)) {
            warps.put(key, (Location) config.get(key));
        }
    }

    private void saveWarps() {
        for (Map.Entry<String, Location> entry : warps.entrySet()) {
            config.set(entry.getKey(), entry.getValue());
        }
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("SkyEssentials.warp")) {
            player.sendMessage(ChatColor.RED + " " + ChatColor.BOLD + "You don't have permission to use this command");
            return true;
        }

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("create")) {
                warps.put(args[1], player.getLocation());
                saveWarps();
                player.sendMessage(ChatColor.GREEN + "Warp " + args[1] + " created");
            } else if (args[0].equalsIgnoreCase("delete")) {
                if (warps.containsKey(args[1])) {
                    warps.remove(args[1]);
                    saveWarps();
                    player.sendMessage(ChatColor.GREEN + "Warp " + args[1] + " deleted");
                } else {
                    player.sendMessage(ChatColor.RED + "Warp " + args[1] + " does not exist");
                }
            } else if (args[0].equalsIgnoreCase("go")) {
                if (warps.containsKey(args[1])) {
                    player.teleport(warps.get(args[1]));
                    player.sendMessage(ChatColor.GREEN + "Teleported to warp " + args[1]);
                } else {
                    player.sendMessage(ChatColor.RED + "Warp " + args[1] + " does not exist");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid command");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Usage: /warp <create|delete|go> <warp>");
        }

        return true;
    }
}