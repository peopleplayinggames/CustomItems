package uk.ppgmediagroup.customitems;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeManager {

    public RecipeManager() {
        loadRoastDinner();
    }

    private void loadRoastDinner() {
        ItemStack roastDinner = new ItemStack(Material.MUSHROOM_STEW);
        ItemMeta itemMeta = roastDinner.getItemMeta();
        itemMeta.setDisplayName(ChatColor.WHITE + "Roast Dinner");
        itemMeta.setCustomModelData(1);
        roastDinner.setItemMeta(itemMeta);

        NamespacedKey namespacedKey = new NamespacedKey(Core.getInstance(), "roastDinner");

        ShapedRecipe recipe = new ShapedRecipe(namespacedKey, roastDinner);
        recipe.shape("ABC", "DEF", "GHG");
        recipe.setIngredient('A', Material.ENCHANTED_GOLDEN_APPLE);
        recipe.setIngredient('B', Material.CARROT);
        recipe.setIngredient('C', Material.COOKED_MUTTON);
        recipe.setIngredient('D', Material.COOKED_PORKCHOP);
        recipe.setIngredient('E', Material.BAKED_POTATO);
        recipe.setIngredient('F', Material.COOKED_BEEF);
        recipe.setIngredient('G', Material.AIR);
        recipe.setIngredient('H', Material.BOWL);
        Bukkit.addRecipe(recipe);
        Core.getInstance().getRecipes().add(namespacedKey);

    }

}
