package com.jnutz.justcook;

import com.jnutz.justcook.client.gui.container.ViewContainer;
import com.jnutz.justcook.database.Database;
import io.github.cdimascio.dotenv.Dotenv;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application
{
    public static Database database;
    //private Server server;

    //Not called on JavaFX Application Thread
    @Override
    public void init() throws Exception
    {
        super.init();
    
        //Load .env file
        Dotenv env = Dotenv.configure().directory("./src/main").load();
    
        //Start TCP Server
        //server = Server.createTcpServer().start();
    
        //Load up driver, connect to database and initialize all tables
        database = new Database(env.get("DATABASE_USERNAME"), env.get("DATABASE_PASSWORD"));
        database.initTables();
    }

    @Override
    public void start(Stage homeStage)
    {
        Scene viewContainerScene = new Scene(ViewContainer.viewContainer);

        homeStage.setTitle("Just Cook");
        homeStage.setMaximized(true);
        homeStage.setResizable(false);
        homeStage.setScene(viewContainerScene);

        homeStage.show();
    }

    @Override
    public void stop() throws Exception
    {
        super.stop();
    
        //TODO: Get any non-saved information
    
        //Closes Connections & Database, then closes TCP Server
        database.closeDatabase();
        //server.stop();
    
        //Terminate application and resources
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}