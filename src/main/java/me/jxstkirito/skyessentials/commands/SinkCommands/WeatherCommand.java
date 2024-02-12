package me.jxstkirito.skyessentials.commands.SinkCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("SkyEssentials.weather")) {
            player.sendMessage(ChatColor.RED + "You don't have permission to use this command");
            return true;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("clear")) {
                player.getWorld().setStorm(false);
                player.sendMessage(ChatColor.GREEN + "Weather set to clear");
            } else if (args[0].equalsIgnoreCase("rain")) {
                player.getWorld().setStorm(true);
                player.getWorld().setThundering(false);
                player.sendMessage(ChatColor.GREEN + "Weather set to rain");
            } else if (args[0].equalsIgnoreCase("thunder")) {
                player.getWorld().setStorm(true);
                player.getWorld().setThundering(true);
                player.sendMessage(ChatColor.GREEN + "Weather set to thunder");
            } else {
                player.sendMessage(ChatColor.RED + "Invalid weather type");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Usage: /weather <clear|rain|thunder>");
        }

        return true;
    }
}
