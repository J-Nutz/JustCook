package com.jnutz.justcook.client.gui.container;

import com.jnutz.justcook.client.gui.home.Home;
import com.jnutz.justcook.client.gui.login.Login;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class Container//extends BorderPane
{
    //Set default view to login screen
    public static final BorderPane container = new BorderPane(new Login());

    public static void switchView(View view, Position position)
    {
        if(position == Position.TOP)
        {
            container.setTop(getSelectedView(view));
        }
        else if(position == Position.BOTTOM)
        {
            container.setBottom(getSelectedView(view));
        }
        else if(position == Position.LEFT)
        {
            container.setLeft(getSelectedView(view));
        }
        else if(position == Position.RIGHT)
        {
            container.setRight(getSelectedView(view));
        }
        else if(position == Position.CENTER)
        {
            container.setCenter(getSelectedView(view));
        }
    }

    private static Node getSelectedView(View view)
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
            //Default to login screen
            return new Login();
        }
    }

    public enum View
    {
        BLANK,

        LOGIN,

        HOME
    }

    public enum Position
    {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        CENTER
    }
}