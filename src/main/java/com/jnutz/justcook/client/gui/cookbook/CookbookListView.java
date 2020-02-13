package com.jnutz.justcook.client.gui.cookbook;

import com.jnutz.justcook.client.gui.cookbook.recipe.RecipeQuickView;
import com.jnutz.justcook.client.gui.cookbook.recipe.RecipeView;
import com.jnutz.justcook.database.cookbook.Cookbook;
import com.jnutz.justcook.database.cookbook.CookbooksDAO;
import com.jnutz.justcook.database.cookbook.recipes.Recipe;
import com.jnutz.justcook.database.cookbook.recipes.RecipesDAO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CookbookListView extends GridPane
{
    private Button backBtn = new Button("Back");
    private Cookbook currentCookbook;
    
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
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    
    private void addComponents()
    {
        addCookbooks();
    }
    
    private void addCookbooks()
    {
        getChildren().clear();
        add(backBtn, 0, 0, 1, 1);
    
        int column = 0;
        int row = 1;
    
        for(Cookbook cookbook : CookbooksDAO.getAllCookbooks())
        {
            for(int i = 1; i < 10; i++)
            {
                CookbookQuickView cookbookQuickView = new CookbookQuickView(cookbook);
                cookbookQuickView.setOnMouseClicked(event -> {
                    currentCookbook = cookbook;
                    addRecipes(cookbook);
                });
            
                add(cookbookQuickView, column, row);
            
                if(column == 9) //TODO: Temporary fix; Calculate sizes and base it on that
                {
                    column = 0;
                    row++;
                }
                else
                {
                    column++;
                }
            }
        }
    }
    
    private void addRecipes(Cookbook cookbook)
    {
        getChildren().clear();
        add(backBtn, 0, 0, 1, 1);
        
        backBtn.setOnAction(event -> addCookbooks());
        
        int column = 0;
        int row = 1;
        
        for(Recipe recipe : RecipesDAO.getRecipes(cookbook.getRecipeIndex()))
        {
            for(int i = 1; i < 20; i++)
            {
                RecipeQuickView recipeQuickView = new RecipeQuickView(recipe);
                recipeQuickView.setOnMouseClicked(event -> showRecipe(recipe));
                
                add(recipeQuickView, column, row);
                
                if(column == 9)  //TODO: Temporary fix; Calculate sizes and base it on that
                {
                    column = 0;
                    row++;
                }
                else
                {
                    column++;
                }
            }
        }
    }
    
    private void showRecipe(Recipe recipe)
    {
        getChildren().clear();
        add(backBtn, 0, 0, 1, 1);
        
        backBtn.setOnAction(event -> addRecipes(currentCookbook));
        
        RecipeView recipeView = new RecipeView(recipe);
        
        GridPane.setValignment(recipeView, VPos.CENTER);
        GridPane.setHalignment(recipeView, HPos.CENTER);
        GridPane.setVgrow(recipeView, Priority.ALWAYS);
        GridPane.setHgrow(recipeView, Priority.ALWAYS);
        
        add(recipeView, 0, 1);
    }
}