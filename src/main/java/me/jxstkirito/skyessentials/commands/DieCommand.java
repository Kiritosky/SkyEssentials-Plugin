package me.jxstkirito.skyessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DieCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!(sender.hasPermission("SkyEssentials.die"))) {
            player.sendMessage("You do not have permission to use this command");
            return true;
        } else {
            player.setHealth(0);
            player.sendMessage("You died");
        }
        return true;
    }
}
