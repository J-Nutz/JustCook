package com.jnutz.justcook.client.gui.container;

// Used to determine what the user has access to
// Ex. Line cook shouldn't have access to the payroll, scheduling, etc.

// TODO: Different access levels based on position to limit access even more
// Thinking it could have load time decrease and performance increase for certain access levels

public enum AccessLevel
{
    ALL(ProtectedView.values()), //TODO: Is this necessary? Shouldn't managers have access to everything?

    MANAGER(ProtectedView.PAYROLL, ProtectedView.RECIPES),

    EMPLOYEE(),

    COOK(ProtectedView.RECIPES),

    ;

    private ProtectedView[] accessibleProtectedViews;

    AccessLevel(ProtectedView... protectedViews)
    {
        accessibleProtectedViews = protectedViews;
    }

    public ProtectedView[] getAccessibleProtectedViews()
    {
        return accessibleProtectedViews;
    }
}