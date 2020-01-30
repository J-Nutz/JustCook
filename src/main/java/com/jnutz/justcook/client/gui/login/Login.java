package com.jnutz.justcook.client.gui.login;

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
    private Label goToNewUserLabel = new Label("Don't Have An Account Yet?");
    private Button newUserBtn = new Button("Go Sign Up");
    private Label copyrightLabel = new Label("Copyright \u00a9 2020 Jonah Stieglitz & Noah Manders");

    private Font font14 = new Font(14);
    private Font font16 = new Font(16);

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
            String userName = usernameTF.getText();
            char[] password = passwordTF.getText().toCharArray();

            if(userName.isBlank())
            {
                errorLabel.setText("Must Enter A Username");
            }

            /*if(!userName.isEmpty() && password.length != 0)
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
            }*/
        });

        errorLabel.setPadding(new Insets(20, 0, 0 , 0));
        errorLabel.setFont(font16);
        errorLabel.setTextFill(Color.RED);

        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(15, 0, 15, 0));

        goToNewUserLabel.setFont(font16);

        newUserBtn.setFont(font14);
        //newUserBtn.setOnAction(e -> switchView(getParent(), View.SIGN_UP));
        copyrightLabel.setPadding(new Insets(20, 0, 0, 0));
    }

    private void addComponents()
    {
        topBox.getChildren().addAll(welcomeLabel, loginLabel, new Separator(Orientation.HORIZONTAL));
        centerBox.getChildren().addAll(usernameTF, passwordTF, loginBtn, errorLabel);
        bottomBox.getChildren().addAll(new Separator(Orientation.HORIZONTAL), goToNewUserLabel, newUserBtn, copyrightLabel);

        setTop(topBox);
        setCenter(centerBox);
        setBottom(bottomBox);
    }
}