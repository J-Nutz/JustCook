package com.jnutz.justcook.client.gui.login;

import com.jnutz.justcook.client.gui.container.AccessLevel;
import com.jnutz.justcook.client.gui.container.ProtectedView;
import com.jnutz.justcook.client.gui.container.PublicView;
import com.jnutz.justcook.client.gui.container.ViewPosition;
import com.jnutz.justcook.database.users.CurrentUser;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Timer;
import java.util.TimerTask;

import static com.jnutz.justcook.client.gui.container.ViewContainer.switchView;

public class Login extends BorderPane
{
    private VBox topBox = new VBox(5);
    private Label welcomeLabel = new Label("Welcome To Just Cook!");
    private Label loginLabel = new Label("Login Below");

    private VBox centerBox = new VBox(5);
    private TextField usernameTF = new TextField();
    private PasswordField passwordTF = new PasswordField();
    private Button loginBtn = new Button("Login");
    private Label errorLabel = new Label();

    private VBox bottomBox = new VBox(15);
    private Label newUserLabel = new Label("Don't Have An Account Yet?");
    private Button newUserBtn = new Button("Go Sign Up");
    private Label copyrightLabel = new Label("Copyright \u00a9 2020 Jonah Stieglitz & Noah Manders");

    private Font font14 = new Font(14);
    private Font font16 = new Font(16);

    private Timer errorMessageTimer = new Timer();

    public Login()
    {
        init();
        addComponents();
    }

    private void init()
    {
        setOnMousePressed(event -> Platform.runLater(super::requestFocus));

        setOnKeyReleased(event ->
        {
            if(event.getCode() == KeyCode.ENTER)
            {
                loginBtn.fire();
            }
        });

        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(30, 0, 30, 0));
        welcomeLabel.setFont(new Font(30));
        loginLabel.setFont(new Font(20));
        loginLabel.setPadding(new Insets(0, 0, 30, 0));

        centerBox.setAlignment(Pos.CENTER);

        usernameTF.setPromptText("Username");
        usernameTF.setMaxWidth(150);
        usernameTF.setFont(font14);

        passwordTF.setPromptText("Password");
        passwordTF.setMaxWidth(150);
        passwordTF.setFont(font14);

        loginBtn.setAlignment(Pos.CENTER);
        loginBtn.setFont(font16);
        loginBtn.setOnAction(event ->
        {
            //This needs to be called in this order due to the dependency of AccessLevel during loading of home screen
            CurrentUser.setAccessLevel(AccessLevel.MANAGER);
            switchView(PublicView.HOME);

            /*String username = usernameTF.getText();
            char[] password = passwordTF.getText().toCharArray();

            //Make sure username has input
            if(!username.isBlank())
            {
                //Make sure password has input
                if(password.length != 0)
                {
                    //Get User info for attempted login
                    User correctUser = UserDAO.getUser(username);

                    //Make sure user with specified username exists
                    if(correctUser != null)
                    {
                        //Make sure password matches user
                        if(Arrays.equals(UserDAO.getUserPassword(username), encrypt(password, correctUser.getSalt())))
                        {
                            Arrays.fill(password, '0');

                            switchView(View.HOME, View.Position.CENTER);

                            CurrentUser.setId(correctUser.getID());
                            CurrentUser.setAccessLevel(correctUser.getAccessLevel());

                            //TODO:
                            // Store access level of user and which panes they should have access to.
                            // Should only do this on login - Shouldn't be rechecking each time user goes back to the home screen
                        }
                        else
                        {
                            showErrorMessage("Incorrect Password");
                        }
                    }
                    else
                    {
                        showErrorMessage("No User Found With That Username");
                    }
                }
                else
                {
                    showErrorMessage("Must Enter A Password");
                }
            }
            else
            {
                showErrorMessage("Must Enter A Username");
            }*/
        });

        errorLabel.setPadding(new Insets(20, 0, 0 , 0));
        errorLabel.setFont(font16);
        errorLabel.setTextFill(Color.RED);

        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(15, 0, 15, 0));

        newUserLabel.setFont(font16);

        newUserBtn.setFont(font14);
        newUserBtn.setOnAction(e -> switchView(ProtectedView.BLANK, ViewPosition.CENTER));
        copyrightLabel.setPadding(new Insets(20, 0, 0, 0));
    }

    private void addComponents()
    {
        topBox.getChildren().addAll(welcomeLabel, loginLabel, new Separator(Orientation.HORIZONTAL));
        centerBox.getChildren().addAll(usernameTF, passwordTF, loginBtn, errorLabel);
        bottomBox.getChildren().addAll(new Separator(Orientation.HORIZONTAL), newUserLabel, newUserBtn, copyrightLabel);

        setTop(topBox);
        setCenter(centerBox);
        setBottom(bottomBox);
    }

    private void showErrorMessage(String errorMessage)
    {
        errorLabel.setText(errorMessage);

        //Timer to show error message and then remove after 6 seconds
        errorMessageTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(6000);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Platform.runLater(() -> errorLabel.setText(""));
                }
            }
        }, 0);
    }
}