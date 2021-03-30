package uk.ppgmediagroup.customitems.listeners;

import org.bukkit.EntityEffect;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.ppgmediagroup.customitems.Core;

import java.util.Objects;

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

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e) {
        if (Objects.requireNonNull(e.getItem().getItemMeta()).getCustomModelData() == 1) {
            Player player = e.getPlayer();
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30 * 20, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120 * 20, 5));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600 * 20, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600 * 20, 0));
            player.playEffect(EntityEffect.LOVE_HEARTS);
        }
    }

}
