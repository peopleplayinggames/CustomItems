package uk.ppgmediagroup.customitems.recipes;

import lombok.Getter;
import uk.ppgmediagroup.customitems.recipes.impl.RoastDinner;

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
    }

}
