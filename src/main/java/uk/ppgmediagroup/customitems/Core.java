package uk.ppgmediagroup.customitems;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import uk.ppgmediagroup.customitems.listeners.PlayerListener;

import java.util.ArrayList;
import java.util.List;

public final class Core extends JavaPlugin {

    @Getter private static Core instance;
    @Getter private final String packURL = "https://ppg.yt/download/customitems-" + this.getDescription().getVersion() + ".zip";
    @Getter private final List<NamespacedKey> recipes = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        new RecipeManager();
        System.out.println("------------------------------------------\n" +
                "LOADED CUSTOMITEMS " + getDescription().getVersion() + " BY PPG.yt\n" +
                "------------------------------------------");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
