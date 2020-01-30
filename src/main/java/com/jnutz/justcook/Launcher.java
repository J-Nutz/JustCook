package com.jnutz.justcook;

import com.jnutz.justcook.client.gui.login.Login;
import com.jnutz.justcook.database.Database;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application
{
    public static Database database;

    //Not called on JavaFX Application Thread
    @Override
    public void init() throws Exception
    {
        super.init();  //Does this need to be called? No implementation in parent class

        Dotenv env = Dotenv.configure().directory("./src/main").load();

        //Load up driver, connect to database and initialize all tables
        database = new Database(env.get("DATABASE_USERNAME"), env.get("DATABASE_PASSWORD"));
        database.initTables();
    }

    @Override
    public void start(Stage homeStage)
    {
        Login loginView = new Login();

        Scene homePage = new Scene(loginView);

        homeStage.setTitle("Just Cook");
        homeStage.setMaximized(true);
        homeStage.setResizable(false);
        homeStage.setScene(homePage);

        homeStage.show();
    }

    //Better than using setOnCloseRequest()
    @Override
    public void stop() throws Exception
    {
        super.stop(); //Does this need to be called? No implementation in parent class

        //TODO: Get any non-saved information

        //Close database & connections in background
        database.closeDatabase();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}