package com.jnutz.justcook.client.gui.cookbook;

import com.jnutz.justcook.client.gui.cookbook.recipe.RecipeQuickView;
import com.jnutz.justcook.database.cookbook.Cookbook;
import com.jnutz.justcook.database.cookbook.CookbooksDAO;
import com.jnutz.justcook.database.cookbook.recipes.Recipe;
import com.jnutz.justcook.database.cookbook.recipes.RecipesDAO;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
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
        setVgap(10);
        setHgap(10);
        setPrefWrapLength(40);
    
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    
    private void addComponents()
    {
        addCookbooks();
    }
    
    private void addCookbooks()
    {
        List<Cookbook> cookbooks = CookbooksDAO.getAllCookbooks();
        
        for(Cookbook cookbook : cookbooks)
        {
            CookbookQuickView cookbookQuickView = new CookbookQuickView(cookbook);
    
            cookbookQuickView.setOnMouseEntered(event -> setCursor(Cursor.HAND));
            cookbookQuickView.setOnMouseExited(event -> setCursor(Cursor.DEFAULT));
    
            getChildren().add(cookbookQuickView);
    
            cookbookQuickView.setOnMouseClicked(event -> {
                getChildren().clear();
        
                for(Recipe recipe : RecipesDAO.getRecipes(cookbook.getRecipeIndex()))
                {
                    RecipeQuickView recipeQuickView = new RecipeQuickView(recipe);
            
                    getChildren().add(recipeQuickView);
                }
            });
        }
    }
}