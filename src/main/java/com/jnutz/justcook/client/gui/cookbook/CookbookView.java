package com.jnutz.justcook.client.gui.cookbook;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class CookbookView extends BorderPane
{
    private final CookbookListView cookbookListView = new CookbookListView();
    
    public CookbookView()
    {
        
        init();
        addComponents();
    }
    
    private void init()
    {
        setPadding(new Insets(10));
    }
    
    private void addComponents()
    {
        setCenter(cookbookListView);
    }
}