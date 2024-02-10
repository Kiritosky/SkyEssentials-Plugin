package me.jxstkirito.skyessentials.commands.AdminFunCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!(sender.hasPermission("SkyEssentials.Admin.vanish"))) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        }

        if (player.hasPermission("SkyEssentials.Admin.vanish")) {
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online != player) {
                    if (online.canSee(player)) {
                        online.hidePlayer(player);
                    } else {
                        online.showPlayer(player);
                    }
                }
            }
        }
        return true;
    }
}
