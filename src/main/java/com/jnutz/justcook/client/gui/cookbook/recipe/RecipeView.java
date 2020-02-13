package com.jnutz.justcook.client.gui.cookbook.recipe;

import com.jnutz.justcook.client.gui.Styling;
import com.jnutz.justcook.database.cookbook.recipes.Recipe;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class RecipeView extends VBox
{
    public RecipeView(Recipe recipe)
    {
        setAlignment(Pos.CENTER);
        getChildren().add(new Label("Temporary Label!"));
        setBorder(Styling.Border_Default);
    }
}