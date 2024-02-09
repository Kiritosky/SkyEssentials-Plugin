package me.jxstkirito.skyessentials.Commands.SinkCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!sender.hasPermission("SkyEssentials.feed")) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        } else {
            player.setFoodLevel(20);
            player.setSaturation(20);
            player.sendMessage(ChatColor.GREEN + "You got feeded");

            return true;
        }
    }
}
