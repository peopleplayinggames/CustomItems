package uk.ppgmediagroup.customitems.utils;

import org.bukkit.inventory.ItemStack;
import uk.ppgmediagroup.customitems.recipes.Recipe;

public class RecipeChecker {

    public static boolean isItem(Recipe recipe, ItemStack itemStack) {

        if (recipe.getItem() != null) {
            if (recipe.getItem().hasItemMeta()) {
                if (recipe.getItem().getItemMeta().hasCustomModelData()) {
                    return recipe.getItem().getItemMeta().getCustomModelData() == itemStack.getItemMeta().getCustomModelData();
                }
            }
        }

        return false;
    }

}
