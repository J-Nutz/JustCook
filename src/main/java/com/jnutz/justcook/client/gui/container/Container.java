package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.login.Login;
import javafx.scene.layout.BorderPane;

public class Container
{
    //TODO: Container.left should always be menu except on login and locked screen

    //Set default view to login screen
    public static final BorderPane container = new BorderPane(new Login());

    //Set view to specified Pane and specified position in BorderPane
    public static void switchView(ProtectedView protectedView, ViewPosition viewPosition)
    {
        if(viewPosition == ViewPosition.TOP)
        {
            container.setTop(protectedView.getViewPane());
        }
        else if(viewPosition == ViewPosition.BOTTOM)
        {
            container.setBottom(protectedView.getViewPane());
        }
        else if(viewPosition == ViewPosition.LEFT)
        {
            container.setLeft(protectedView.getViewPane());
        }
        else if(viewPosition == ViewPosition.RIGHT)
        {
            container.setRight(protectedView.getViewPane());
        }
        else if(viewPosition == ViewPosition.CENTER)
        {
            container.setCenter(protectedView.getViewPane());
        }
    }

    //Should only be used for switching to views that don't require an access level Ex. Home, Login, Lock Screen
    public static void switchView(PublicView publicView)
    {
        container.setCenter(publicView.getViewPane());
    }
}