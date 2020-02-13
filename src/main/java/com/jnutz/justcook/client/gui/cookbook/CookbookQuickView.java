package com.jnutz.justcook.client.gui.cookbook;

import com.jnutz.justcook.client.gui.Styling;
import com.jnutz.justcook.database.cookbook.Cookbook;
import com.jnutz.justcook.database.cookbook.recipes.RecipesDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CookbookQuickView extends GridPane
{
    private Cookbook cookbook;
    
    private Label nameLbl = new Label();
    private Label recipeCountLbl = new Label();
    
    public CookbookQuickView(Cookbook cookbook)
    {
        this.cookbook = cookbook;
        
        init();
        addComponents();
    }
    
    private void init()
    {
        setPrefSize(150, 80);
        setPadding(new Insets(10));
        setBorder(Styling.Border_Default);
        setAlignment(Pos.CENTER);
        setOnMouseEntered(event -> setCursor(Cursor.HAND));
        setOnMouseExited(event -> setCursor(Cursor.DEFAULT));
    
        nameLbl.setText(cookbook.getName());
        nameLbl.setFont(Styling.Font_16);
    
        recipeCountLbl.setText("Contains " + RecipesDAO.getRecipeCount(cookbook.getRecipeIndex()) + " Recipes");
        recipeCountLbl.setFont(Styling.Font_14);
    }
    
    private void addComponents()
    {
        this.add(nameLbl, 0, 0, 2, 1);
        
        this.add(recipeCountLbl, 0, 1, 2, 1);
    }
}