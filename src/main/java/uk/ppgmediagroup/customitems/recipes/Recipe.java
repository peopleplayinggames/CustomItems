package uk.ppgmediagroup.customitems.recipes;

import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import uk.ppgmediagroup.customitems.Core;

public abstract class Recipe {

    public Recipe() {
        ShapedRecipe shapedRecipe = recipe(getItem());
        Bukkit.addRecipe(shapedRecipe);
        Core.getInstance().getRecipes().add(shapedRecipe.getKey());
    }

    public abstract String getName();
    public abstract ItemStack getItem();
    public abstract ShapedRecipe recipe(ItemStack itemStack);
    public abstract void onConsume(PlayerItemConsumeEvent e);


}
