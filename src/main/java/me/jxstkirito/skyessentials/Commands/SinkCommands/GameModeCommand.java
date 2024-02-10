package me.jxstkirito.skyessentials.Commands.SinkCommands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (!(sender instanceof Player player)) {
            if (!(sender.hasPermission("SkyEssentials.gm"))) {
                sender.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You dont have permission to use this command");
            }
                return true;
            } else {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("1")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(ChatColor.GREEN + "You are now in Creative");
                    } else if (args[0].equalsIgnoreCase("0")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.GREEN + "You are now in Survival");
                    } else if (args[0].equalsIgnoreCase("2")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(ChatColor.GREEN + "You are now Spectating");
                    } else {
                        sender.sendMessage(ChatColor.RED + "Usage: /gm <0|1|2>");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Usage: /gm <0|1|2>");
                }

                return true;
            }
        }





}
