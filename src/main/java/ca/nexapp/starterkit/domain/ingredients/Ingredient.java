package ca.nexapp.starterkit.domain.ingredients;

public interface Ingredient {

    String getName();

    <E> E accept(IngredientVisitor<E> visitor);
}
