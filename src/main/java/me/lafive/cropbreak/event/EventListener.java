package me.lafive.cropbreak.event;

import me.lafive.cropbreak.CropBreakPAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EventListener implements Listener {

    private CropBreakPAPI instance;

    public EventListener(CropBreakPAPI instance) {
        this.instance = instance;
    }

    @EventHandler(priority=EventPriority.LOW)
    public void handleBlockBreakEvent(BlockBreakEvent e) {
        if (e.isCancelled()) return;
        if (e.getBlock().getType().equals(Material.WHEAT) || e.getBlock().getType().equals(Material.CARROTS) || e.getBlock().getType().equals(Material.POTATOES)) {
            /*
             * We can make this cast safely without checking instanceof
             * as Material.WHEAT blockdata will always be instanceof
             * ageable
             */
            Ageable ageable = (Ageable) e.getBlock().getBlockData();
            // age of the wheat growth
            if (ageable.getAge() == ageable.getMaximumAge()) {
                instance.getDataFile().setPlayerData(e.getPlayer().getUniqueId(),
                        instance.getDataFile().getPlayerData(e.getPlayer()) + 1);
            }
        }
    }

}
