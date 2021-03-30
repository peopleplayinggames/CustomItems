package uk.ppgmediagroup.customitems;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import uk.ppgmediagroup.customitems.listeners.PlayerListener;
import uk.ppgmediagroup.customitems.recipes.RecipeManager;

import java.util.ArrayList;
import java.util.List;

public final class Core extends JavaPlugin {

    @Getter private static Core instance;
    @Getter private final String packURL = "https://ppg.yt/download/customitems-" + this.getDescription().getVersion() + ".zip";
    @Getter private final List<NamespacedKey> recipes = new ArrayList<>();
    @Getter private RecipeManager recipeManager;

    @Override
    public void onEnable() {
        instance = this;
        recipeManager = new RecipeManager();

        // listener
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);

        // woah it worked ima send a cool console message!
        System.out.println(
                "------------------------------------------\n" +
                "Loaded CustomItems " + getDescription().getVersion() + " by PPG.yt\n" +
                "------------------------------------------");
    }
}
