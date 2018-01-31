package ca.nexapp.starterkit.domain.ingredients;

import ca.nexapp.math.units.Mass;

public class MassIngredient implements Ingredient {

    private final String name;
    private final Mass mass;

    public MassIngredient(String name, Mass mass) {
        this.name = name;
        this.mass = mass;
    }

    @Override
    public String getName() {
        return name;
    }

    public Mass getMass() {
        return mass;
    }

    @Override
    public <E> E accept(IngredientVisitor<E> visitor) {
        return visitor.visit(this);
    }

}
