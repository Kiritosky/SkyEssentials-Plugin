package me.jxstkirito.skyessentials.trollMenu.Inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CreateInventory {

    public CreateInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null,27,"Troll Menu");

        inventory.setItem(10,new ItemStack(Material.RED_DYE));
        inventory.setItem(13,new ItemStack(Material.PLAYER_HEAD));
        inventory.setItem(16,new ItemStack(Material.GREEN_DYE));
        player.openInventory(inventory);


    }

}
