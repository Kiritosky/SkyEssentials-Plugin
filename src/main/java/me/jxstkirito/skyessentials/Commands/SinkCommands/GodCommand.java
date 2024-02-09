package me.jxstkirito.skyessentials.Commands.SinkCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!sender.hasPermission("SkyEssentials.god")) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        }

        if (player.isInvulnerable()){
                player.setInvulnerable(false);
                player.sendMessage(ChatColor.RED + "God Mode Disabled");
                player.setGlowing(false);
            }else {
                player.setInvulnerable(true);
                player.sendMessage(ChatColor.GREEN + "God Mode Enabled");
                player.setGlowing(true);
            }

        return true;
    }
}
