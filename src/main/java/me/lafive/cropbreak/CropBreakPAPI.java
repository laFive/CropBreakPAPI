package me.lafive.cropbreak;

import me.lafive.cropbreak.data.DataFile;
import me.lafive.cropbreak.event.EventListener;
import me.lafive.cropbreak.placeholder.CropPlaceHolder;
import org.bukkit.plugin.java.JavaPlugin;

public class CropBreakPAPI extends JavaPlugin {

    private DataFile dataFile;

    @Override
    public void onEnable() {
        // Surely theres a better way of doing this?
        // Whatever it works
        if (getServer().getPluginManager().getPlugin("PlaceHolderAPI") == null) {
            getLogger().info("PlaceHolderAPI not found! Plugin shutting down...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        dataFile = new DataFile(this);
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        new CropPlaceHolder(this).register();
        getLogger().info("Plugin enabled successfully!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin shut down.");
    }

    public DataFile getDataFile() {
        return this.dataFile;
    }

}
