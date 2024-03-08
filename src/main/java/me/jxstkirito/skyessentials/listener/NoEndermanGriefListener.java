package me.jxstkirito.skyessentials.listener;

import org.bukkit.entity.Enderman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class NoEndermanGriefListener implements Listener {

    @EventHandler
    public void onEndermanGrief(EntityChangeBlockEvent event) {
        if (event.getEntity() instanceof Enderman) {
            event.setCancelled(true);
        }
    }


}
