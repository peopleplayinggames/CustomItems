package uk.ppgmediagroup.customitems.recipes;

import lombok.Getter;
import uk.ppgmediagroup.customitems.recipes.impl.item.ChickenSword;
import uk.ppgmediagroup.customitems.recipes.impl.item.DragonSlayerSword;
import uk.ppgmediagroup.customitems.recipes.impl.projectile.EnderArrow;
import uk.ppgmediagroup.customitems.recipes.impl.item.RoastDinner;
import uk.ppgmediagroup.customitems.recipes.impl.projectile.FireArrow;

import java.util.ArrayList;
import java.util.List;

public class RecipeManager {

    @Getter
    private final List<Recipe> recipes = new ArrayList<>();

    public RecipeManager() {
        registerRecipes();
    }

    private void registerRecipes() {
        recipes.add(new RoastDinner()); // 1
        recipes.add(new EnderArrow()); // 2
        recipes.add(new ChickenSword()); // 3
        recipes.add(new DragonSlayerSword()); // 4
        recipes.add(new FireArrow()); // 5
    }

}
