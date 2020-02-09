package com.jnutz.justcook.client.gui.cookbook;

import com.jnutz.justcook.database.cookbook.Cookbook;
import com.jnutz.justcook.database.cookbook.CookbooksDAO;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

public class CookbookListView extends FlowPane
{
    public CookbookListView()
    {
        
        init();
        addComponents();
    }
    
    private void init()
    {
        setPadding(new Insets(10));
        setVgap(4);
        setHgap(4);
        setPrefWrapLength(40);
        
        setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    
    private void addComponents()
    {
        addCookbooks();
    }
    
    private void addCookbooks()
    {
        List<Cookbook> cookbooks = CookbooksDAO.getAllCookbooks();
        
        System.out.println("Trying to add " + cookbooks.size() + " cookbooks");
        
        for(Cookbook cookbook : cookbooks)
        {
            CookbookQuickView cookbookQuickView = new CookbookQuickView(cookbook);
            
            System.out.println("Adding cookbook: " + cookbook.getName());
            
            getChildren().add(cookbookQuickView);
        }
    }
}