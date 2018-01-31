package ca.nexapp.starterkit.domain.ingredients;

public class UnitLessIngredient implements Ingredient {

    private final String name;

    public UnitLessIngredient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public <E> E accept(IngredientVisitor<E> visitor) {
        return visitor.visit(this);
    }

}
