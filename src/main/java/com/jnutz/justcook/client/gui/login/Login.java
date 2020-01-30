package com.jnutz.justcook.client.gui.login;

import com.jnutz.justcook.database.users.User;
import com.jnutz.justcook.database.users.UserDAO;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Arrays;

import static com.jnutz.justcook.client.util.security.Encryption.encrypt;

public class Login extends BorderPane
{
    private VBox topBox;
    private Label welcomeLabel;
    private Label loginLabel;

    private VBox centerBox;
    private TextField usernameTF;
    private PasswordField passwordTF;
    private Button loginBtn;

    private VBox bottomBox;
    private Label goToNewUserLabel;
    private Button newUserBtn;
    private Label copyrightLabel;

    public Login()
    {
        topBox = new VBox(5);
        welcomeLabel = new Label("Welcome To Just Cook!");
        loginLabel = new Label("Login Below");

        centerBox = new VBox(5);
        usernameTF = new TextField();
        passwordTF = new PasswordField();
        loginBtn = new Button("Login");

        bottomBox = new VBox(15);
        goToNewUserLabel = new Label("Don't Have An Account Yet?");
        newUserBtn = new Button("Go Sign Up");
        copyrightLabel = new Label("Copyright \u00a9 2020 Jonah Stieglitz & Noah Manders");

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
        usernameTF.setFont(new Font(14));

        passwordTF.setPromptText("Password");
        passwordTF.setMaxWidth(150);
        passwordTF.setFont(new Font(14));

        loginBtn.setAlignment(Pos.CENTER);
        loginBtn.setFont(new Font(15));
        loginBtn.setOnAction(event ->
        {
            String userName = usernameTF.getText();
            char[] password = passwordTF.getText().toCharArray();

            if(!userName.isEmpty() && password.length != 0)
            {
                User correctUser = UserDAO.getUser(userName);
                User attemptedUser = new User();

                if(correctUser != null)
                {
                    attemptedUser.setUsername(userName);
                    attemptedUser.setPassword(encrypt(password, correctUser.getSalt()));
                    attemptedUser.setSalt(correctUser.getSalt());

                    //String[] loginAttemptResult = InputValidator.validLogin(attemptedUser);
                    boolean validLogin = true; //Boolean.parseBoolean(loginAttemptResult[0]);
                    //String loginResultMessage = loginAttemptResult[1];

                    // Set password[] to all zeroes (Security)
                    Arrays.fill(password, '0');

                    if(validLogin)
                    {
                        //LoggedInUserTable.setLoggedInUser(attemptedUser);
                        //switchView(getParent(), View.HOME);
                    }
                    else
                    {
                        //showErrorMessage(centerBox, loginResultMessage);
                    }
                }
                else
                {
                    //showErrorMessage(centerBox, "User Not Found");
                }
            }
            else
            {
                if(userName.isEmpty())
                {
                    //showErrorMessage(centerBox, "Username Not Entered");
                }
                else if(password.length == 0)
                {
                    //showErrorMessage(centerBox, "Password Not Entered");
                }
            }
        });

        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(15, 0, 15, 0));

        goToNewUserLabel.setFont(new Font(16));

        newUserBtn.setFont(new Font(14));
        //newUserBtn.setOnAction(e -> switchView(getParent(), View.SIGN_UP));
        copyrightLabel.setPadding(new Insets(20, 0, 0, 0));
    }

    private void addComponents()
    {
        topBox.getChildren().addAll(welcomeLabel, loginLabel, new Separator(Orientation.HORIZONTAL));
        centerBox.getChildren().addAll(usernameTF, passwordTF, loginBtn);
        bottomBox.getChildren().addAll(new Separator(Orientation.HORIZONTAL), goToNewUserLabel, newUserBtn, copyrightLabel);

        setTop(topBox);
        setCenter(centerBox);
        setBottom(bottomBox);
    }
}