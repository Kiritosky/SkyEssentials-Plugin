package Listern;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListerner implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if (player.hasPlayedBefore()){
            e.setJoinMessage(ChatColor.YELLOW + " " + ChatColor.BOLD + "Welcome back to the server" + ChatColor.YELLOW + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.YELLOW + " " + ChatColor.BOLD + "have fun");
        } else {
            e.setJoinMessage(ChatColor.GREEN + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.GREEN + " " + ChatColor.BOLD + "Joined the first time everyone say Welcome");
        }
        System.out.println(ChatColor.YELLOW + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.YELLOW + " " + ChatColor.BOLD + "has joined the server");


    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){

        Player player = e.getPlayer();

        System.out.println(ChatColor.YELLOW + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.YELLOW + " " + ChatColor.BOLD + "has left the server");
        e.setQuitMessage(ChatColor.YELLOW + " " + ChatColor.BOLD + player.getDisplayName() + ChatColor.YELLOW + " " + ChatColor.BOLD + "has left the server" );

    }

}
