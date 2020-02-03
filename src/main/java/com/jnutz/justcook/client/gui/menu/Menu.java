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
    private ToggleGroup menuButtonGroup = new ToggleGroup();
    
    private ToggleButton menuButtonHome = new ToggleButton("HOME");
    private ToggleButton menuButtonLogout = new ToggleButton("LOGOUT");
    
    private Font menuButtonFont = new Font(14);
    
    public Menu()
    {
        init();
        addComponents();
    }
    
    private void init()
    {
        setSpacing(20);
        setPadding(new Insets(45));
        setStyle("-fx-border-color : black; -fx-border-width : 0 1 0 0 ");
        
        loadMenuItems();
        
        //Init the "Home" menu button
        applyStyling(menuButtonHome);
        menuButtonHome.setDisable(true);
        menuButtonHome.setOnAction((event) -> {
            menuButtonHome.setDisable(true);
            ViewContainer.switchPublicView(PublicView.HOME);
        });
        
        //Init the "Logout" menu button
        applyStyling(menuButtonLogout);
        menuButtonLogout.setOnAction((event) -> {
            menuButtonGroup.selectToggle(null);
            
            menuButtonHome.setDisable(true);
            
            ViewContainer.switchPublicView(PublicView.LOGIN);
        });
        
        //This re-enables the previously selected button
        menuButtonGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue != newValue)
            {
                this.getChildren().forEach(node -> {
                    if(node instanceof ToggleButton)
                    {
                        node.setDisable(false);
                    }
                });
            }
        });
    }
    
    private void addComponents()
    {
        menuButtonGroup.getToggles().addAll(menuButtonHome, menuButtonLogout);
        
        this.getChildren().add(0, menuButtonHome);
        this.getChildren().add(menuButtonLogout);
    }
    
    //Init the menu buttons that are dependant on the access level of the current user
    private void loadMenuItems()
    {
        //Adds a menu button for each of the accessible views of the current user
        for(ProtectedView protectedView : CurrentUser.getAccessibleViews())
        {
            ToggleButton menuButton = new ToggleButton(protectedView.name());
            
            applyStyling(menuButton);
            menuButton.setOnAction((event) -> {
                //Disables the currently selected button so it can't be spammed resulting in the selected view being re-created (n) amount of times
                menuButton.setDisable(true);
                
                ViewContainer.switchProtectedView(protectedView, ViewPosition.CENTER);
            });
            
            menuButtonGroup.getToggles().add(menuButton);
            this.getChildren().add(menuButton);
        }
    }
    
    private void applyStyling(ToggleButton button)
    {
        button.setFont(menuButtonFont);
        button.setPrefWidth(100);
        button.setMinWidth(85);
        button.setFocusTraversable(false);
    }
}