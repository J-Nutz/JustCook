package com.jnutz.justcook.client.gui.login;

import com.jnutz.justcook.client.gui.Styling;
import com.jnutz.justcook.client.gui.container.*;
import com.jnutz.justcook.database.users.CurrentUser;
import com.jnutz.justcook.database.users.User;
import com.jnutz.justcook.database.users.UsersDAO;
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

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import static com.jnutz.justcook.client.gui.container.ViewContainer.switchPublicView;
import static com.jnutz.justcook.client.util.security.Encryption.encrypt;

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
        usernameTF.setFont(Styling.Font_14);
    
        passwordTF.setPromptText("Password");
        passwordTF.setMaxWidth(150);
        passwordTF.setFont(Styling.Font_14);
    
        //For easier testing
        usernameTF.setText("Jonah");
        passwordTF.setText("1234");
    
        loginBtn.setAlignment(Pos.CENTER);
        loginBtn.setFont(Styling.Font_16);
        loginBtn.setOnAction(event -> {
            String username = usernameTF.getText();
            char[] password = passwordTF.getText()
                                        .toCharArray();
        
            //Make sure username has input
            if(!username.isBlank())
            {
                //Make sure password has input
                if(password.length != 0)
                {
                    //Get User info for attempted login
                    User correctUser = UsersDAO.getUser(username);
    
                    //Make sure user with specified username exists
                    if(correctUser != null)
                    {
                        //Make sure password matches user
                        if(Arrays.equals(correctUser.getPassword(), encrypt(password, correctUser.getSalt())))
                        {
                            Arrays.fill(password, '0');
        
                            //This needs to be called in this order due to the dependency of AccessLevel during loading of menu screen
                            CurrentUser.login((short) 1, AccessLevel.MANAGER);
        
                            switchPublicView(PublicView.HOME);
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
            }
        });
    
        errorLabel.setPadding(new Insets(20, 0, 0, 0));
        errorLabel.setFont(Styling.Font_16);
        errorLabel.setTextFill(Color.RED);

        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(15, 0, 15, 0));
    
        newUserLabel.setFont(Styling.Font_16);
    
        newUserBtn.setFont(Styling.Font_14);
        newUserBtn.setOnAction(e -> ViewContainer.switchProtectedView(ProtectedView.BLANK, ViewPosition.CENTER));
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
    
    private void applyStyling()
    {
        //TODO: Figure out if this would be good, If so, find the best way to implement it for each class
        // Ideas So Far:
        // Each node gets a one liner like node.setStyle("All the styling to be done in one line");
    }
    
    private void showErrorMessage(String errorMessage)
    {
        errorLabel.setText(errorMessage);
        loginBtn.setDisable(true);
        
        //Timer to show error message and then remove after 6 seconds
        errorMessageTimer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                try
                {
                    //TODO: Do I want to do it this way or re enable button at same time as removing error label text?
                    Thread.sleep(3000);
                    Platform.runLater(() -> loginBtn.setDisable(false));
    
                    Thread.sleep(3000);
                    Platform.runLater(() -> errorLabel.setText(""));
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, 0);
    }
}