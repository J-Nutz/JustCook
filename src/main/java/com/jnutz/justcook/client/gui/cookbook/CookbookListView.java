package com.jnutz.justcook.client.gui.cookbook;

import com.jnutz.justcook.client.gui.Styling;
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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class CookbookListView extends GridPane
{
    private BorderPane topContainer = new BorderPane();
    private Button backBtn = new Button("Back");
    private Label titleLbl = new Label("Cookbooks");
    
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
        setBorder(Styling.Border_Default);
        
        topContainer.setPadding(new Insets(10));
        
        backBtn.setFont(Styling.Font_14);
        
        titleLbl.setFont(Styling.Font_20);
    }
    
    private void addComponents()
    {
        topContainer.setCenter(titleLbl);
    
        add(topContainer, 0, 0, 9, 1);
    
        addCookbooks();
    }
    
    private void addCookbooks()
    {
        getChildren().removeIf((child) -> child != topContainer);
    
        topContainer.setLeft(null);
    
        titleLbl.setText("Cookbooks");
    
        int column = 0;
        int row = 1;
    
        for(Cookbook cookbook : CookbooksDAO.getAllCookbooks())
        {
            //Just for simulating a bunch of entries
            for(int i = 1; i < 10; i++)
            {
                CookbookQuickView cookbookQuickView = new CookbookQuickView(cookbook);
                cookbookQuickView.setOnMouseClicked(event -> {
                    currentCookbook = cookbook;
                    addRecipes(cookbook);
    
                    topContainer.setLeft(backBtn);
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
        getChildren().removeIf((child) -> child != topContainer);
    
        backBtn.setOnAction(event -> addCookbooks());
        titleLbl.setText(cookbook.getName());
        
        int column = 0;
        int row = 1;
        
        for(Recipe recipe : RecipesDAO.getRecipes(cookbook.getRecipeIndex()))
        {
            //Just for simulating a bunch of entries
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
        getChildren().removeIf((child) -> child != topContainer);
    
        backBtn.setOnAction(event -> addRecipes(currentCookbook));
        titleLbl.setText(recipe.getName());
        
        RecipeView recipeView = new RecipeView(recipe);
    
        //Make the recipe view take up the whole view
        GridPane.setValignment(recipeView, VPos.CENTER);
        GridPane.setHalignment(recipeView, HPos.CENTER);
        GridPane.setVgrow(recipeView, Priority.ALWAYS);
        GridPane.setHgrow(recipeView, Priority.ALWAYS);
        
        add(recipeView, 0, 1);
    }
}