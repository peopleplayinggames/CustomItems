package uk.ppgmediagroup.customitems.recipes;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public abstract class Recipe {

    public abstract ItemStack getItem();
    public abstract ShapedRecipe recipe();
    public abstract void onConsume(PlayerItemConsumeEvent e);

}
