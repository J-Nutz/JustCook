package com.jnutz.justcook.client.gui.cookbook.recipe;

import com.jnutz.justcook.client.gui.Styling;
import com.jnutz.justcook.database.cookbook.recipes.Recipe;
import com.jnutz.justcook.database.cookbook.recipes.ingredients.Ingredient;
import com.jnutz.justcook.database.cookbook.recipes.ingredients.IngredientsDAO;
import com.jnutz.justcook.database.cookbook.recipes.steps.Step;
import com.jnutz.justcook.database.cookbook.recipes.steps.StepsDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.List;
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
        setSpacing(10);
        setPadding(new Insets(10));
        setBorder(Styling.Border_Default);
        setFillHeight(true);
    }
    
    private void addComponents()
    {
        addRecipeIngredients();
        addRecipeSteps();
    }
    
    private void addRecipeIngredients()
    {
        VBox ingredientContainer = new VBox();
    
        ingredientContainer.setBorder(Styling.Border_Default);
        ingredientContainer.setPadding(new Insets(10));
        ingredientContainer.setSpacing(10);
        ingredientContainer.setFillWidth(true);
        setHgrow(ingredientContainer, Priority.ALWAYS);
    
        Label titleLbl = new Label("INGREDIENTS");
    
        titleLbl.setFont(Styling.Font_14);
    
        ingredientContainer.getChildren()
                           .add(titleLbl);
    
        List<Ingredient> ingredients = Objects.requireNonNull(IngredientsDAO.getIngredients2(recipe.getRecipeIngredientsIndex()));
    
        ingredients.forEach((ingredient) -> {
            Label nameLbl = new Label("\t" + ingredient.getName());
            ingredientContainer.getChildren()
                               .add(nameLbl);
        });
    
        getChildren().add(ingredientContainer);
    }
    
    private void addRecipeSteps()
    {
        VBox stepContainer = new VBox();
    
        stepContainer.setBorder(Styling.Border_Default);
        stepContainer.setPadding(new Insets(10));
        stepContainer.setSpacing(10);
        stepContainer.setFillWidth(true);
        setHgrow(stepContainer, Priority.ALWAYS);
    
        Label titleLbl = new Label("STEPS");
    
        titleLbl.setFont(Styling.Font_14);
    
        stepContainer.getChildren()
                     .add(titleLbl);
    
        List<Step> steps = Objects.requireNonNull(StepsDAO.getSteps(recipe.getRecipeStepsIndex()));
    
        steps.forEach((step) -> {
            Label stepNumberLbl = new Label("\tStep: " + step.getNumber());
            Label stepDescription = new Label("\t\t" + step.getText());
        
            stepContainer.getChildren()
                         .addAll(stepNumberLbl, stepDescription);
        });
    
        getChildren().add(stepContainer);
    }
}