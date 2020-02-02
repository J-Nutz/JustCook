package com.jnutz.justcook.database.users;

import com.jnutz.justcook.client.gui.container.AccessLevel;
import com.jnutz.justcook.client.gui.container.ProtectedView;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class CurrentUser
{
    //TODO: Better way of storing this?
    // I think doing it this way is better than assigning each different view an access level
    // in it's defining class and then looping through each class and adding if access levels match

    ////////////////////////////////////////////////////////////////////////////

    private static short id;
    private static AccessLevel accessLevel;
    private static LinkedHashSet<ProtectedView> accessibleViews = new LinkedHashSet<>();

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

        setAccessibleViews();
    }

    public static AccessLevel getAccessLevel()
    {
        return accessLevel;
    }

    private static void setAccessibleViews()
    {
        accessibleViews.addAll(Arrays.asList(accessLevel.getAccessibleProtectedViews()));
    }

    public static LinkedHashSet<ProtectedView> getAccessibleViews()
    {
        return accessibleViews;
    }
}