package me.jxstkirito.skyessentials.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;



public class LeaveListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        System.out.println(ChatColor.YELLOW + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.YELLOW + " " + ChatColor.BOLD + "has left the server");
        event.setQuitMessage(ChatColor.YELLOW + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.YELLOW + " " + ChatColor.BOLD + "has left the server" );
    }

}

