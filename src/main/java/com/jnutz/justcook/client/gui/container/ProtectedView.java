package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.cookbook.Cookbook;
import com.jnutz.justcook.client.gui.home.FakePayRoll;
import javafx.scene.layout.Pane;

//Enums for views that shouldn't be accessible to every user, they contain the Pane object they represent
public enum ProtectedView
{
    BLANK(null),
    
    COOKBOOK(new Cookbook()),
    
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