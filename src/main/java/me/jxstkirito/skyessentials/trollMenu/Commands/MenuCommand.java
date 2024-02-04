package me.jxstkirito.skyessentials.trollMenu.Commands;

import me.jxstkirito.skyessentials.trollMenu.Inventory.CreateInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;

        new CreateInventory(player);
    return true;
    }
}
