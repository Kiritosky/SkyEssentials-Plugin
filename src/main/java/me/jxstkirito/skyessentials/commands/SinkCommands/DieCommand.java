package me.jxstkirito.skyessentials.commands.SinkCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DieCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!(sender.hasPermission("SkyEssentials.die"))) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        } else {
            player.setHealth(0);
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You have opted to kill yourself");
        }
        return true;
    }
}
