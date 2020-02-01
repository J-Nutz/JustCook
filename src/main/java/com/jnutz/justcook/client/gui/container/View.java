package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.home.Home;
import com.jnutz.justcook.client.gui.login.Login;
import javafx.scene.layout.Pane;

//Enums for all views of project containing the Pane object they represent
public enum View
{
    BLANK(null),

    LOGIN(new Login()),

    HOME(new Home()),

    RECIPES(null),

    PAYROLL(null),

    ;

    private Pane viewPane;

    View(Pane pane)
    {
        viewPane = pane;
    }

    public Pane getViewPane()
    {
        return this.viewPane;
    }

    //Enums for positions in BorderPane
    public enum Position
    {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        CENTER
    }
}