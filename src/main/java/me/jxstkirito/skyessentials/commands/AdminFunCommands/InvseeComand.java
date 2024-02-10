package me.jxstkirito.skyessentials.commands.AdminFunCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeComand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!(sender.hasPermission("SkyEssentials.Admin.invsee"))) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        }

        if (strings.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /invsee <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(strings[0]);
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }

        player.openInventory(target.getInventory());
        return true;
    }
}
