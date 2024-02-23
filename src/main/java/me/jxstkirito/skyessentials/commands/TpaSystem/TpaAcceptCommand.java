package me.jxstkirito.skyessentials.commands.TpaSystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaAcceptCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + " " + ChatColor.BOLD + "Only players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if (!TpaCommand.tpaRequests.containsKey(player)) {
            player.sendMessage(ChatColor.RED + "You have no teleport requests");
            return true;
        }

        Player requester = TpaCommand.tpaRequests.get(player);
        requester.teleport(player.getLocation());
        TpaCommand.tpaRequests.remove(player);
        player.sendMessage(ChatColor.GREEN + "Teleport request accepted");
        requester.sendMessage(ChatColor.GREEN + "Teleporting to " + player.getName());

        return true;
    }
}
