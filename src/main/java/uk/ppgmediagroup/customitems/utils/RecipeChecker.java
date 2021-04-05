package uk.ppgmediagroup.customitems.utils;

import org.bukkit.inventory.ItemStack;
import uk.ppgmediagroup.customitems.recipes.Recipe;

public class RecipeChecker {

    public static boolean isItem(Recipe recipe, ItemStack itemStack) {

        if (itemStack != null) {
            if (itemStack.hasItemMeta()) {
                if (itemStack.getItemMeta().hasCustomModelData()) {
                    return recipe.getItem().getItemMeta().getCustomModelData() == itemStack.getItemMeta().getCustomModelData();
                }
            }
        }

        return false;
    }

}
