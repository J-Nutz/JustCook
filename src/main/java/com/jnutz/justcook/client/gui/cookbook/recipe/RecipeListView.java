package com.jnutz.justcook.client.gui.cookbook.recipe;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
    
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    
    private void addComponents()
    {
    
    }
    
    private void addRecipes()
    {
    
    }
}