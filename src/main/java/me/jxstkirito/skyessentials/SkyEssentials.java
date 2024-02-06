package me.jxstkirito.skyessentials;

import me.jxstkirito.skyessentials.commands.FeedCommand;
import me.jxstkirito.skyessentials.commands.GameModeCommand;
import me.jxstkirito.skyessentials.commands.GodCommand;
import me.jxstkirito.skyessentials.commands.HealCommand;
import me.jxstkirito.skyessentials.listener.JoinListerner;
import me.jxstkirito.skyessentials.listener.LeaveListener;
import me.jxstkirito.skyessentials.trollMenu.Commands.MenuCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;


public final class SkyEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getLogger().log(Level.INFO,ChatColor.GREEN + "SkyEssentials plugin started");
        getServer().getPluginManager().registerEvents(new JoinListerner(), this);
        getServer().getPluginManager().registerEvents(new LeaveListener(), this);
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("trollmenu").setExecutor(new MenuCommand());
        getCommand("gm").setExecutor(new GameModeCommand());
        getCommand("heal").setExecutor(new HealCommand());
    }

    @Override
    public void onDisable() {
        getServer().getLogger().log(Level.INFO,ChatColor.RED + "SkyEssentials plugin stopped");
    }
}
