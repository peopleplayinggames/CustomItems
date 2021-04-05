package uk.ppgmediagroup.customitems.recipes.impl.projectile;

import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import uk.ppgmediagroup.customitems.Core;
import uk.ppgmediagroup.customitems.recipes.Recipe;
import uk.ppgmediagroup.customitems.utils.RecipeChecker;

public class FireArrow extends Recipe {

    @Override
    public String getName() {
        return "FIRE_ARROW";
    }

    @Override
    public ItemStack getItem() {
        ItemStack arrow = new ItemStack(Material.ARROW);
        ItemMeta itemMeta = arrow.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "Fire Arrow");
        itemMeta.setCustomModelData(5);
        arrow.setItemMeta(itemMeta);
        return arrow;
    }

    @Override
    public ShapedRecipe recipe(ItemStack itemStack) {
        itemStack.setAmount(4);
        NamespacedKey namespacedKey = new NamespacedKey(Core.getInstance(), "fireArrow");
        ShapedRecipe recipe = new ShapedRecipe(namespacedKey, itemStack);
        recipe.shape("GAG", "GBG", "GCG");
        recipe.setIngredient('A', Material.MAGMA_CREAM);
        recipe.setIngredient('B', Material.STICK);
        recipe.setIngredient('C', Material.FEATHER);
        recipe.setIngredient('G', Material.AIR);

        return recipe;
    }

    @EventHandler
    public void onProjectileLaunch(EntityShootBowEvent e) {
        if (RecipeChecker.isItem(this, e.getConsumable())) {
            Arrow arrow = (Arrow) e.getProjectile();
            arrow.setFireTicks(20 * 20);
        }
    }

}
