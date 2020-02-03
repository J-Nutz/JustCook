package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.login.Login;
import com.jnutz.justcook.database.users.CurrentUser;
import javafx.scene.layout.BorderPane;

public class ViewContainer
{
    //TODO: Container.left should always be menu except on login and locked screen

    //Set default view to login screen
    public static final BorderPane viewContainer = new BorderPane(new Login());

    //Set view to specified Pane and specified position in BorderPane
    public static void switchProtectedView(ProtectedView protectedView, ViewPosition viewPosition)
    {
        if(viewPosition == ViewPosition.TOP)
        {
            viewContainer.setTop(protectedView.getViewPane());
        }
        else if(viewPosition == ViewPosition.BOTTOM)
        {
            viewContainer.setBottom(protectedView.getViewPane());
        }
        else if(viewPosition == ViewPosition.LEFT)
        {
            viewContainer.setLeft(protectedView.getViewPane());
        }
        else if(viewPosition == ViewPosition.RIGHT)
        {
            viewContainer.setRight(protectedView.getViewPane());
        }
        else if(viewPosition == ViewPosition.CENTER)
        {
            viewContainer.setCenter(protectedView.getViewPane());
        }
    }

    //Should only be used for switching to views that don't require an access level Ex. Home, Login, Lock Screen
    public static void switchPublicView(PublicView publicView)
    {
        if(publicView == PublicView.HOME)
        {
            viewContainer.setLeft(PublicView.MENU.getViewPane());
            viewContainer.setCenter(publicView.getViewPane());
        }
        else if(publicView == PublicView.LOGIN)
        {
            CurrentUser.logout();

            viewContainer.setLeft(null);
            viewContainer.setCenter(publicView.getViewPane());
        }
    }
}