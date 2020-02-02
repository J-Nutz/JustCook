package com.jnutz.justcook.client.gui.home;

import com.jnutz.justcook.client.gui.container.ProtectedView;
import com.jnutz.justcook.client.gui.container.ViewPosition;
import com.jnutz.justcook.database.users.CurrentUser;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import static com.jnutz.justcook.client.gui.container.Container.switchView;

public class Home extends BorderPane
{
    public Home()
    {
        VBox tempMenu = new VBox();

        tempMenu.setPadding(new Insets(5));
        tempMenu.setSpacing(5);

        for(Pane pane : CurrentUser.getPermittedViews())
        {
            tempMenu.getChildren().add(pane);
        }

        for(ProtectedView protectedView : CurrentUser.getAccessibleViews())
        {
            Button menuButton = new Button(protectedView.name());

            menuButton.setOnAction((event) -> switchView(protectedView, ViewPosition.CENTER));

            tempMenu.getChildren().add(menuButton);
        }

        setLeft(tempMenu);

        int example = 131240;

        String asString = String.valueOf(example);

        String[] asArray = asString.split("");

        String answer = "";

        for(int i = asArray.length - 1; i > 0; i--)
        {
            answer = answer.concat(asArray[i]);
        }

        System.out.println(answer);
    }
}