package com.jnutz.justcook.client.gui.container;

// Used to determine what the user has access to
// Ex. Line cook shouldn't have access to the payroll, scheduling, etc.

// TODO: Different access levels based on position to limit access even more
// Thinking it could have load time decrease and performance increase for certain access levels

public enum AccessLevel
{
    ALL(View.values()), //TODO: Is this necessary? Shouldn't managers have access to everything?

    MANAGER(View.HOME, View.PAYROLL, View.RECIPES),

    EMPLOYEE(View.HOME),

    COOK(View.HOME, View.RECIPES),

    ;

    private View[] accessibleViews;

    AccessLevel(View... views)
    {
        accessibleViews = views;
    }

    public View[] getAccessibleViews()
    {
        return accessibleViews;
    }
}