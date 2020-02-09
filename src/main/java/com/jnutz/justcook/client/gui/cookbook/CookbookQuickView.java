package com.jnutz.justcook.client.gui.cookbook;

import com.jnutz.justcook.database.cookbook.Cookbook;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
        setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setAlignment(Pos.CENTER);
        
        nameLbl.setText(cookbook.getName());
        recipeCountLbl.setText("Contains: " + cookbook.getRecipeIds().size() + " Recipes");
    }
    
    private void addComponents()
    {
        this.add(nameLbl, 0, 0, 2, 1);
        
        this.add(recipeCountLbl, 0, 1, 2, 1);
    }
}