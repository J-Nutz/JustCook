package com.jnutz.justcook.client.gui.menu;

import com.jnutz.justcook.client.gui.container.ProtectedView;
import com.jnutz.justcook.client.gui.container.PublicView;
import com.jnutz.justcook.client.gui.container.ViewContainer;
import com.jnutz.justcook.client.gui.container.ViewPosition;
import com.jnutz.justcook.database.users.CurrentUser;
import javafx.geometry.Insets;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Menu extends VBox
{
    private Font menuButtonFont = new Font(14);

    public Menu()
    {
        init();
        addComponents();
    }

    private void init()
    {
        loadMenuItems();

        setSpacing(20);
        setPadding(new Insets(25));
    }

    private void addComponents()
    {

    }

    private void loadMenuItems()
    {
        ToggleGroup menuButtonGroup = new ToggleGroup();

        //Adds a menu button for each of the accessible views of the current user
        for(ProtectedView protectedView : CurrentUser.getAccessibleViews())
        {
            ToggleButton menuButton = new ToggleButton(protectedView.name());

            menuButton.setFont(menuButtonFont);
            menuButton.setPrefWidth(100);
            menuButton.setMinWidth(85);

            menuButton.setOnAction((event) ->
                                   {
                                       System.out.println("Switching View");
                                       ViewContainer.switchProtectedView(protectedView, ViewPosition.CENTER);

                                       //Disables the currently selected button so it can't be spammed resulting in the selected view being re-created (n) amount of times
                                       menuButton.setDisable(true);
                                   });

            menuButtonGroup.getToggles().add(menuButton);
            this.getChildren().add(menuButton);
        }
    
        //Special home button implementation
        ToggleButton menuButtonHome = new ToggleButton("HOME");
    
        menuButtonHome.setFont(menuButtonFont);
        menuButtonHome.setPrefWidth(100);
        menuButtonHome.setMinWidth(85);
        menuButtonHome.setDisable(true);
    
        menuButtonHome.setOnAction((event) -> {
            menuButtonHome.setDisable(true);
            ViewContainer.switchPublicView(PublicView.HOME);
        });
    
        menuButtonGroup.getToggles().add(menuButtonHome);
        this.getChildren().add(0, menuButtonHome);
    
        //Special logout button implementation
        ToggleButton menuButtonLogout = new ToggleButton("LOGOUT");
    
        menuButtonLogout.setFont(menuButtonFont);
        menuButtonLogout.setPrefWidth(100);
        menuButtonLogout.setMinWidth(85);
    
        menuButtonLogout.setOnAction((event) -> {
            menuButtonGroup.selectToggle(null);
            ViewContainer.switchPublicView(PublicView.LOGIN);
            menuButtonHome.setDisable(true);
        });

        menuButtonGroup.getToggles().add(menuButtonLogout);
        this.getChildren().add(menuButtonLogout);

        //This Re-enables the previously selected button
        menuButtonGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue != newValue)
            {
                getChildren().forEach(node -> {
                    if(node instanceof ToggleButton)
                    {
                        ToggleButton toEnable = (ToggleButton) node;
                        toEnable.setDisable(false);
                    }
                });
            }
        });
    }
}