package com.jnutz.justcook.client.gui.cookbook;

import com.jnutz.justcook.client.gui.cookbook.recipe.RecipeListView;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class CookbookView extends BorderPane
{
    private final RecipeListView recipeListView = new RecipeListView();
    
    public CookbookView()
    {
        
        init();
        addComponents();
    }
    
    private void init()
    {
    
    }
    
    private void addComponents()
    {
        setLeft(new Label("CookbookView"));
        setCenter(recipeListView);
    }
}