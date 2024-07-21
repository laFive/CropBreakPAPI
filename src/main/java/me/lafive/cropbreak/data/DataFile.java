package me.lafive.cropbreak.data;

import me.lafive.cropbreak.CropBreakPAPI;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DataFile {

    private File dataFile;
    private YamlConfiguration yml;

    public DataFile(CropBreakPAPI instance) {

        instance.getDataFolder().mkdir();
        dataFile = new File(instance.getDataFolder() + "/CropData.yml");

        /*
         * This is really ugly ik but im not making full error handling
         * for a plugin as simple as this
         */

        try {
            if (!dataFile.exists()) dataFile.createNewFile();
            yml = new YamlConfiguration();
            yml.load(dataFile);
        } catch (org.bukkit.configuration.InvalidConfigurationException e) {
            instance.getLogger().info("Invalid data file! Have you incorrectly modified it?");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getPlayerData(OfflinePlayer player) {
        if (yml.contains("Crops-Broken." + player.getUniqueId())) return yml.getInt("Crops-Broken." + player.getUniqueId());
        return 0;
    }

    public void setPlayerData(UUID u, int val) {
        yml.set("Crops-Broken." + u, val);
        try {
            yml.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
