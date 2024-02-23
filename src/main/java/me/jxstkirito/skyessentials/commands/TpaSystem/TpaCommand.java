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

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /tpa <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatColor.RED + "Could not find player " + args[0]);
            return true;
        }

        tpaRequests.put(target, player);
        target.sendMessage(ChatColor.GREEN + player.getName() + " has sent you a teleport request. Use /tpaccept to accept.");
        player.sendMessage(ChatColor.GREEN + "Teleport request sent to " + target.getName());

        return true;
    }
}