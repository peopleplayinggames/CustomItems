package uk.ppgmediagroup.customitems.recipes.impl.projectile;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import uk.ppgmediagroup.customitems.Core;
import uk.ppgmediagroup.customitems.recipes.Recipe;

public class EnderArrow extends Recipe {
    @Override
    public String getName() {
        return "ENDER_ARROW";
    }

    @Override
    public ItemStack getItem() {
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta itemMeta = arrow.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "Ender Arrow");
        itemMeta.setCustomModelData(2);
        arrow.setItemMeta(itemMeta);
        return arrow;
    }

    @Override
    public ShapedRecipe recipe(ItemStack itemStack) {
        itemStack.setAmount(4);
        NamespacedKey namespacedKey = new NamespacedKey(Core.getInstance(), "enderArrow");
        ShapedRecipe recipe = new ShapedRecipe(namespacedKey, itemStack);
        recipe.shape("GAG", "GBG", "GCG");
        recipe.setIngredient('A', Material.ENDER_PEARL);
        recipe.setIngredient('B', Material.END_ROD);
        recipe.setIngredient('C', Material.CHORUS_FRUIT);
        recipe.setIngredient('G', Material.AIR);

        return recipe;
    }

    @EventHandler
    public void onProjectileLaunch(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (e.getConsumable().hasItemMeta()) {
                if (e.getConsumable().getItemMeta().hasCustomModelData() && e.getConsumable().getItemMeta().getCustomModelData() == 2) {
                    e.getProjectile().setMetadata("enderArrow", new FixedMetadataValue(Core.getInstance(), "enderArrow"));
                    player.playEffect(EntityEffect.TELEPORT_ENDER);
                }
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity().getMetadata("enderArrow").size() > 0) {
            if (e.getEntity().getShooter() instanceof Player) {
                Player player = (Player) e.getEntity().getShooter();
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 10, 1);
                player.teleport(new Location(player.getWorld(), e.getEntity().getLocation().getX(), e.getEntity().getLocation().getY(), e.getEntity().getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch()));
                e.getEntity().remove();
                if (player.getInventory().getArmorContents().length == 0) {
                    player.damage(1);
                }
            }
        }
    }
}
