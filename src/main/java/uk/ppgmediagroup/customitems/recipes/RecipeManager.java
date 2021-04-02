package uk.ppgmediagroup.customitems.recipes;

import lombok.Getter;
import uk.ppgmediagroup.customitems.recipes.impl.item.ChickenSword;
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
        recipes.add(new RoastDinner());
        recipes.add(new EnderArrow());
        recipes.add(new ChickenSword());
        // TODO: DragonSlayer Sword
        recipes.add(new FireArrow());
    }

}
