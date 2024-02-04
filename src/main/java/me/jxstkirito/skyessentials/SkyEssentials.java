package me.jxstkirito.skyessentials;
import Commands.GodCommand;
import Listern.JoinLeaveListerner;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;


public final class SkyEssentials extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getServer().getLogger().log(Level.INFO,ChatColor.GREEN + "SkyEssentials plugin started");

        getServer().getPluginManager().registerEvents(new JoinLeaveListerner(), this);

        getCommand("god").setExecutor(new GodCommand());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getServer().getLogger().log(Level.INFO,ChatColor.RED + "SkyEssentials plugin stopped");
    }
}
