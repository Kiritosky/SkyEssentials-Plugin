package me.jxstkirito.skyessentials.Commands.AdminFunCommands;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FireCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if(!(sender instanceof Player player)) return true;
        if (!(sender.hasPermission("SkyEssentials.Admin.burn"))) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        } else {
            if (strings.length == 0) {
                player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "Usage: /burn <player>");
                return true;
            }
            if (strings.length == 1) {
                Player target = player.getServer().getPlayer(strings[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "Player not found");
                    return true;
                }
                target.setFireTicks(100);
                player.sendMessage(ChatColor.BOLD + " " + ChatColor.GREEN + "You set " + target.getName() + " on fire");
            }
        }


        return true;
    }
}
