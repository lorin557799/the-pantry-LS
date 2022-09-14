package org.liftoff.thepantry.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Ingredient extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "id")
    private RecipeIngredient recipeIngredient;

    public Ingredient() {
    }

    // getters and setters

    public RecipeIngredient getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(RecipeIngredient recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }
}
