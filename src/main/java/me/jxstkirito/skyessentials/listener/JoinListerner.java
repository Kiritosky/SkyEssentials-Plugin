package me.jxstkirito.skyessentials.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListerner implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            event.setJoinMessage(ChatColor.YELLOW + " " + ChatColor.BOLD + "Welcome back to the server" + ChatColor.YELLOW + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.YELLOW + " " + ChatColor.BOLD + "have fun");
        } else {
            event.setJoinMessage(ChatColor.GREEN + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.GREEN + " " + ChatColor.BOLD + "Joined the first time everyone say Welcome");
        }
        System.out.println(ChatColor.YELLOW + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.YELLOW + " " + ChatColor.BOLD + "has joined the server");
    }
}

