package com.jnutz.justcook.client.gui.cookbook.recipe;

import com.jnutz.justcook.database.cookbook.recipes.Recipe;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class RecipeQuickView extends GridPane
{
    private Recipe recipe;
    
    private Label nameLbl = new Label();
    private Label categoryLbl = new Label();
    private Label stepCountLbl = new Label();
    private Label ingredientCountLbl = new Label();
    
    public RecipeQuickView(Recipe recipe)
    {
        this.recipe = recipe;
        
        init();
        addComponents();
    }
    
    private void init()
    {
        setPrefSize(150, 80);
        setPadding(new Insets(10));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT))); //TODO: Make a class that defines all commonly reused styles?
        setAlignment(Pos.CENTER);
        setOnMouseEntered(event -> setCursor(Cursor.HAND));
        setOnMouseExited(event -> setCursor(Cursor.DEFAULT));
    
        nameLbl.setText(recipe.getName());
        categoryLbl.setText(recipe.getCategory());
        //stepCountLbl.setText("Number Of Steps: " + recipe.getSteps().size());
        //ingredientCountLbl.setText("Number Of Ingredients: " + recipe.getIngredients().size());
    }
    
    private void addComponents()
    {
        this.add(nameLbl, 0, 0, 2, 1);
        
        this.add(categoryLbl, 0, 1, 2, 1);
        
        this.add(stepCountLbl, 0, 2, 2, 1);
        
        this.add(ingredientCountLbl, 0, 1, 2, 1);
    }
}