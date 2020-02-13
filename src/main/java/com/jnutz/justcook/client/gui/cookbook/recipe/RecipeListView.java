package com.jnutz.justcook.client.gui.cookbook.recipe;

import com.jnutz.justcook.client.gui.Styling;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;

public class RecipeListView extends FlowPane
{
    public RecipeListView()
    {
        
        init();
        addComponents();
    }
    
    private void init()
    {
        setPadding(new Insets(10));
        setVgap(10);
        setHgap(10);
        setPrefWrapLength(40);
    
        setBorder(Styling.Border_Default);
    }
    
    private void addComponents()
    {
    
    }
    
    private void addRecipes()
    {
    
    }
}