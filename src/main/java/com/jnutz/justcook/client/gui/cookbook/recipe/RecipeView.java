package com.jnutz.justcook.client.gui.cookbook.recipe;

import com.jnutz.justcook.client.gui.Styling;
import com.jnutz.justcook.database.cookbook.recipes.Recipe;
import com.jnutz.justcook.database.cookbook.recipes.ingredients.IngredientsDAO;
import com.jnutz.justcook.database.cookbook.recipes.steps.StepsDAO;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class RecipeView extends HBox
{
    private Recipe recipe;
    
    public RecipeView(Recipe recipe)
    {
        this.recipe = recipe;
        
        init();
        addComponents();
    }
    
    private void init()
    {
        setAlignment(Pos.CENTER);
        setBorder(Styling.Border_Default);
    }
    
    private void addComponents()
    {
        addRecipeIngredients();
        addRecipeSteps();
    }
    
    private void addRecipeIngredients()
    {
        VBox ingredientContainer = new VBox();
        
        Objects.requireNonNull(IngredientsDAO.getIngredients(recipe.getRecipeIngredientsIndex()))
               .forEach((value) -> ingredientContainer.getChildren()
                                                      .add(new Label(value.getName())));
        
        getChildren().add(ingredientContainer);
    }
    
    private void addRecipeSteps()
    {
        VBox stepContainer = new VBox();
        
        StepsDAO.getSteps(recipe.getRecipeStepsIndex())
                .forEach((value) -> stepContainer.getChildren()
                                                 .addAll(new Label("Step: " + value.getNumber()), new Label(value.getText())));
        
        getChildren().add(stepContainer);
    }
}