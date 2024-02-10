package me.jxstkirito.skyessentials;

import me.jxstkirito.skyessentials.commands.AdminFunCommands.FireCommand;
import me.jxstkirito.skyessentials.commands.AdminFunCommands.InvseeComand;
import me.jxstkirito.skyessentials.commands.AdminFunCommands.VanishCommand;
import me.jxstkirito.skyessentials.commands.SinkCommands.*;
import me.jxstkirito.skyessentials.commands.WorkbenchCommands.AnvilCommand;
import me.jxstkirito.skyessentials.commands.WorkbenchCommands.EnderchestCommand;
import me.jxstkirito.skyessentials.commands.WorkbenchCommands.WorkbenchCommand;
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
        getCommand("Workbench").setExecutor(new WorkbenchCommand());
        getCommand("Enderchest").setExecutor(new EnderchestCommand());
        getCommand("Anvil").setExecutor(new AnvilCommand());
        getCommand("Burn").setExecutor(new FireCommand());
        getCommand("invsee").setExecutor(new InvseeComand());
        getCommand("vanish").setExecutor(new VanishCommand());
    }

    @Override
    public void onDisable() {
        getServer().getLogger().log(Level.INFO,ChatColor.RED + "SkyEssentials plugin stopped");
    }
}
