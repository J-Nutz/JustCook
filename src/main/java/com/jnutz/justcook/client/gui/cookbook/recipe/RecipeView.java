package com.jnutz.justcook.client.gui.cookbook.recipe;

import com.jnutz.justcook.database.cookbook.recipes.Recipe;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class RecipeView extends VBox
{
    public RecipeView(Recipe recipe)
    {
        setAlignment(Pos.CENTER);
        getChildren().add(new Label("Temporary Label!"));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
}