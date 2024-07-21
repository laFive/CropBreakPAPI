package me.lafive.cropbreak.placeholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.lafive.cropbreak.CropBreakPAPI;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class CropPlaceHolder extends PlaceholderExpansion {

    private CropBreakPAPI instance;

    public CropPlaceHolder(CropBreakPAPI instance) {
        this.instance = instance;
    }

    @Override
    public @NotNull String getIdentifier() {
        // cba to type the full plugin name out every time so using this as identifier
        return "CropPAPI";
    }

    @Override
    public @NotNull String getAuthor() {
        return "laFive";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true; //
    }

    @Override
    public String onRequest(OfflinePlayer player, @NotNull String params) {

        // PLACEHOLDER IS %croppapi_cropsbroken%

        if (params.equalsIgnoreCase("cropsbroken")) {
            return instance.getDataFile().getPlayerData(player) + "";
        }

        return null;
    }

}
