package uk.ppgmediagroup.customitems.recipes.impl.item;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.ppgmediagroup.customitems.Core;
import uk.ppgmediagroup.customitems.recipes.Recipe;
import uk.ppgmediagroup.customitems.utils.RecipeChecker;

import java.util.Objects;

public class RoastDinner extends Recipe {

    @Override
    public String getName() {
        return "ROAST_DINNER";
    }

    @Override
    public ItemStack getItem() {
        ItemStack roastDinner = new ItemStack(Material.MUSHROOM_STEW);
        ItemMeta itemMeta = roastDinner.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "Roast Dinner");
        itemMeta.setCustomModelData(1);
        roastDinner.setItemMeta(itemMeta);
        return roastDinner;
    }

    @Override
    public ShapedRecipe recipe(ItemStack itemStack) {
        NamespacedKey namespacedKey = new NamespacedKey(Core.getInstance(), "roastDinner");
        ShapedRecipe recipe = new ShapedRecipe(namespacedKey, itemStack);
        recipe.shape("ABC", "DEF", "GHG");
        recipe.setIngredient('A', Material.ENCHANTED_GOLDEN_APPLE);
        recipe.setIngredient('B', Material.CARROT);
        recipe.setIngredient('C', Material.COOKED_MUTTON);
        recipe.setIngredient('D', Material.COOKED_PORKCHOP);
        recipe.setIngredient('E', Material.BAKED_POTATO);
        recipe.setIngredient('F', Material.COOKED_BEEF);
        recipe.setIngredient('G', Material.AIR);
        recipe.setIngredient('H', Material.BOWL);

        return recipe;
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e) {
        if (RecipeChecker.isItem(this, e.getItem())) {
            Player player = e.getPlayer();
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30 * 20, 2));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120 * 20, 4));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600 * 20, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600 * 20, 0));
            player.playEffect(EntityEffect.TOTEM_RESURRECT);
            player.setHealth(20);
            player.setSaturation(20);
            player.setFoodLevel(20);
        }
    }

}
