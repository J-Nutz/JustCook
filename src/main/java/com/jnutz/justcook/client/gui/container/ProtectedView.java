package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.home.FakePayRoll;
import com.jnutz.justcook.client.gui.home.FakeRecipes;
import javafx.scene.layout.Pane;

//Enums for views that shouldn't be accessible to every user they contain the Pane object they represent
public enum ProtectedView
{
    BLANK(null),

    RECIPES(new FakeRecipes()),

    PAYROLL(new FakePayRoll()),

    ;

    private Pane viewPane;

    ProtectedView(Pane pane)
    {
        viewPane = pane;
    }

    public Pane getViewPane()
    {
        return this.viewPane;
    }
}