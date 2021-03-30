package uk.ppgmediagroup.customitems.recipes.impl;

import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.ppgmediagroup.customitems.Core;
import uk.ppgmediagroup.customitems.recipes.Recipe;

import java.util.Objects;

public class RoastDinner extends Recipe {

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
    public ShapedRecipe recipe() {
        NamespacedKey namespacedKey = new NamespacedKey(Core.getInstance(), "roastDinner");
        ShapedRecipe recipe = new ShapedRecipe(namespacedKey, getItem());
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

    @Override
    public void onConsume(PlayerItemConsumeEvent e) {
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
