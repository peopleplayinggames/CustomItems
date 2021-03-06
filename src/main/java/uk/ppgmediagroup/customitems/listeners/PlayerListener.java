package uk.ppgmediagroup.customitems.listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.ppgmediagroup.customitems.Core;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.setResourcePack(Core.getInstance().getPackURL());

        for (NamespacedKey recipe : Core.getInstance().getRecipes()) {
            if (!player.hasDiscoveredRecipe(recipe)) {
                player.discoverRecipe(recipe);
            }
        }
    }

}
