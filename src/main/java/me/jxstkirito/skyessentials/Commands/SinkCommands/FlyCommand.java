package me.jxstkirito.skyessentials.Commands.SinkCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!(sender.hasPermission("SkyEssentials.fly"))) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        } else {
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You can no longer fly");
            } else {
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.BOLD + " " + ChatColor.GREEN + "You can now fly");
            }
        }
        return true;
    }
}
