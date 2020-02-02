package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.home.Home;
import com.jnutz.justcook.client.gui.login.Login;
import com.jnutz.justcook.client.gui.menu.Menu;
import javafx.scene.layout.Pane;

//Enums for views that should be accessible to every user they contain the Pane object they represent
public enum PublicView
{
    LOGIN(new Login()),

    HOME(new Home()),

    MENU(new Menu()),

    ;

    private Pane viewPane;

    PublicView(Pane pane)
    {
        this.viewPane = pane;
    }

    public Pane getViewPane()
    {
        return this.viewPane;
    }
}