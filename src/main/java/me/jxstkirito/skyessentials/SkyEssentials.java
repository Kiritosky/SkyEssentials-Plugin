package me.jxstkirito.skyessentials;

import me.jxstkirito.skyessentials.Commands.SinkCommands.*;
import me.jxstkirito.skyessentials.Commands.WorkbenchCommands.AnvilCommand;
import me.jxstkirito.skyessentials.Commands.WorkbenchCommands.EnderchestCommand;
import me.jxstkirito.skyessentials.Commands.WorkbenchCommands.WorkbenchCommand;
import me.jxstkirito.skyessentials.listener.JoinListerner;
import me.jxstkirito.skyessentials.listener.LeaveListener;
import me.jxstkirito.skyessentials.listener.NoCreeperDamageListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;


public final class SkyEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getLogger().log(Level.INFO,ChatColor.GREEN + "SkyEssentials plugin started");
        getServer().getPluginManager().registerEvents(new JoinListerner(), this);
        getServer().getPluginManager().registerEvents(new LeaveListener(), this);
        getServer().getPluginManager().registerEvents(new NoCreeperDamageListener(), this);
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("gm").setExecutor(new GameModeCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("die").setExecutor(new DieCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("tp").setExecutor(new TpCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("wb").setExecutor(new WorkbenchCommand());
        getCommand("enderchest").setExecutor(new EnderchestCommand());
        getCommand("anvil").setExecutor(new AnvilCommand());
    }

    @Override
    public void onDisable() {
        getServer().getLogger().log(Level.INFO,ChatColor.RED + "SkyEssentials plugin stopped");
    }
}
