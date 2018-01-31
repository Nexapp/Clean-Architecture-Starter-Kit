package ca.nexapp.starterkit.domain.ingredients;

public interface IngredientVisitor<E> {

    E visit(UnitLessIngredient ingredient);

    E visit(MassIngredient ingredient);
}
