/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Renacer
 */
public class Login extends Application{
    
    //inicio de implementacion de cambio de ventana
    public static String screen1ID = "login";
    public static String screen1File = "/dayara/view/Login.fxml";
    public static String screen2ID = "principal";
    public static String screen2File = "/dayara/view/Principal.fxml";
    public static String screen3ID = "abm";
    public static String screen3File = "/dayara/view/AbmEmpleados.fxml";
    public static String screen4ID= "Adelanto";
    public static String screen4File = "/dayara/view/MovAdelanto.fxml";

  
      @Override
    public void start(Stage primaryStage) {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Login.screen1ID, Login.screen1File);
        mainContainer.loadScreen(Login.screen2ID, Login.screen2File);
        mainContainer.loadScreen(Login.screen3ID, Login.screen3File);
        mainContainer.loadScreen(Login.screen4ID, Login.screen4File);
//        
        mainContainer.setScreen(Login.screen1ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
       
        primaryStage.show();
        
    }
  
}
