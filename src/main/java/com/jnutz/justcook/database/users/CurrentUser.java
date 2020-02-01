package com.jnutz.justcook.database.users;

import com.jnutz.justcook.client.gui.container.AccessLevel;
import com.jnutz.justcook.client.gui.container.View;
import javafx.scene.layout.Pane;

import java.util.LinkedHashSet;

public class CurrentUser
{
    //TODO: Better way of storing this?
    // I think doing it this way is better than assigning each different view an access level
    // in it's defining class and then looping through each class and adding if access levels match

    ////////////////////////////////////////////////////////////////////////////

    private static short id;
    private static AccessLevel accessLevel;
    private static LinkedHashSet<Pane> permittedViews = new LinkedHashSet<>();

    public static void setId(short newId)
    {
        id = newId;
    }

    public static short getId()
    {
        return id;
    }

    public static void setAccessLevel(AccessLevel newAccessLevel)
    {
        accessLevel = newAccessLevel;

        addPermittedViews();
    }

    public static AccessLevel getAccessLevel()
    {
        return accessLevel;
    }

    public static LinkedHashSet<Pane> getPermittedViews()
    {
        return permittedViews;
    }

    private static void addPermittedViews()
    {
        for(View view : accessLevel.getAccessibleViews())
        {
            permittedViews.add(view.getViewPane());
        }
    }
}