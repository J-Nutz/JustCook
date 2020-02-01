package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.login.Login;
import javafx.scene.layout.BorderPane;

public class Container
{
    //Set default view to login screen
    public static final BorderPane container = new BorderPane(new Login());

    //Set view to specified Pane and specified position in BorderPane
    public static void switchView(View view, View.Position viewPosition)
    {
        if(viewPosition == View.Position.TOP)
        {
            container.setTop(view.getViewPane());
        }
        else if(viewPosition == View.Position.BOTTOM)
        {
            container.setBottom(view.getViewPane());
        }
        else if(viewPosition == View.Position.LEFT)
        {
            container.setLeft(view.getViewPane());
        }
        else if(viewPosition == View.Position.RIGHT)
        {
            container.setRight(view.getViewPane());
        }
        else if(viewPosition == View.Position.CENTER)
        {
            container.setCenter(view.getViewPane());
        }
    }
}