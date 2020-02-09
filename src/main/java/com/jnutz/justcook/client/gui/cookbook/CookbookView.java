package com.jnutz.justcook.client.gui.cookbook;

import com.jnutz.justcook.client.gui.cookbook.recipe.RecipeListView;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class CookbookView extends BorderPane
{
    private final CookbookListView cookbookListView = new CookbookListView();
    
    private final RecipeListView recipeListView = new RecipeListView();
    
    public CookbookView()
    {
        setPadding(new Insets(10));
        
        init();
        addComponents();
    }
    
    private void init()
    {
    
    }
    
    private void addComponents()
    {
        Label tempLabel = new Label("Cookbook View");
        tempLabel.setPadding(new Insets(10));
    
        setLeft(tempLabel);
        setCenter(cookbookListView);
    }
}