package me.jxstkirito.skyessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!(sender.hasPermission("SkyEssentials.tp"))) {
            player.sendMessage("You do not have permission to use this command");
            return true;
        } else {
            if (strings.length == 0) {
                player.sendMessage("Usage: /tp <player>");
                return true;
            }
            if (strings.length == 1) {
                Player target = player.getServer().getPlayer(strings[0]);
                if (target == null) {
                    player.sendMessage("Player not found");
                    return true;
                }
                player.teleport(target);
                player.sendMessage("Teleported to " + target.getName());
            }
        }



        return true;
    }
}
