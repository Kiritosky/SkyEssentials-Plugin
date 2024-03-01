package me.jxstkirito.skyessentials.commands.TpaSystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TpaCommand implements CommandExecutor {

    public static Map<Player, Player> tpaRequests = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + " " + ChatColor.BOLD + "Only players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if(!player.hasPermission("SkyEssentials.Tpa")) {
            player.sendMessage(ChatColor.RED + " " + ChatColor.BOLD + "You do not have permission to use this command");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: " + ChatColor.AQUA + "/tpa <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatColor.RED + "Could not find player " + ChatColor.AQUA + args[0]);
            return true;
        }

        tpaRequests.put(target, player);
        target.sendMessage(ChatColor.BLUE + player.getName() + ChatColor.WHITE + " has sent you a teleport request. Use " + ChatColor.AQUA + "/tpaccept" + ChatColor.WHITE + " to accept.");
        player.sendMessage(ChatColor.BLUE + "Teleport request sent to " + ChatColor.AQUA + target.getName());

        return true;
    }
}