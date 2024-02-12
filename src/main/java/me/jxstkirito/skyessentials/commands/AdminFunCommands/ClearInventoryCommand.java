package me.jxstkirito.skyessentials.commands.AdminFunCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearInventoryCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("SkyEssentials.Admin.clearinventory")) {
            player.sendMessage(ChatColor.RED + " " + ChatColor.BOLD + "You do not have permission to use this command");
            return true;
        }

        if (args.length == 0) {
            player.getInventory().clear();
            player.sendMessage(ChatColor.GREEN + "Your inventory has been cleared");
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                player.sendMessage(ChatColor.RED + "Could not find player " + args[0]);
            } else {
                target.getInventory().clear();
                player.sendMessage(ChatColor.GREEN + target.getName() + "'s inventory has been cleared");
            }
        } else {
            player.sendMessage(ChatColor.RED + "Usage: /clearinventory [player]");
        }

        return true;
    }
}