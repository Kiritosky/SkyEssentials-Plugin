package me.jxstkirito.skyessentials.Commands.WorkbenchCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkbenchCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!sender.hasPermission("SkyEssentials.workbench")) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        }
        player.openWorkbench(null, true);
        player.sendMessage(ChatColor.GREEN + "You opened the workbench");

        return true;
    }

}
