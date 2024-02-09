package me.jxstkirito.skyessentials.Commands.WorkbenchCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class AnvilCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (!(sender instanceof Player player)) return true;
        if (!sender.hasPermission("SkyEssentials.anvil")) {
            player.sendMessage(ChatColor.BOLD + " " + ChatColor.RED + "You do not have permission to use this command");
            return true;
        }
        Inventory anvil = Bukkit.createInventory(player, InventoryType.ANVIL);
        player.openInventory(anvil);
        player.sendMessage(ChatColor.GREEN + "You opened the anvil");

        return true;
    }
}
