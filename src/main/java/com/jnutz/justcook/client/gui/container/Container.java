package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.home.Home;
import com.jnutz.justcook.client.gui.login.Login;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class Container
{
    //Set default view to login screen
    public static final BorderPane container = new BorderPane(new Login());

    //Set view to specified Pane and specified position in BorderPane
    public static void switchView(View view, ViewPosition viewPosition)
    {
        if(viewPosition == ViewPosition.TOP)
        {
            container.setTop(getView(view));
        }
        else if(viewPosition == ViewPosition.BOTTOM)
        {
            container.setBottom(getView(view));
        }
        else if(viewPosition == ViewPosition.LEFT)
        {
            container.setLeft(getView(view));
        }
        else if(viewPosition == ViewPosition.RIGHT)
        {
            container.setRight(getView(view));
        }
        else if(viewPosition == ViewPosition.CENTER)
        {
            container.setCenter(getView(view));
        }
    }

    //Get actual Pane object from enum View
    private static Node getView(View view)
    {
        if(view == View.BLANK)
        {
            return null;
        }
        else if(view == View.LOGIN)
        {
            return new Login();
        }
        else if(view == View.HOME)
        {
            return new Home();
        }
        else
        {
            return new Login();
        }
    }

    //Enums for all Views of project
    public enum View
    {
        BLANK,

        LOGIN,

        HOME
    }

    //Enums for positions in BorderPane
    public enum ViewPosition
    {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        CENTER
    }
}