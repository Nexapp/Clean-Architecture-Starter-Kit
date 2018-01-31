package ca.nexapp.starterkit.domain.recipes;

import java.util.List;

import ca.nexapp.starterkit.domain.ingredients.Ingredient;

public class Recipe {

    public final String name;
    public final List<Ingredient> ingredients;

    public Recipe(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }
}
