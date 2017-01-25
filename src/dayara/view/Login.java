/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.view;

import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
    public static String screen5ID = "abmUsuario";
    public static String screen5File = "/dayara/view/AbmUsuarios.fxml";

  
      @Override
    public void start(Stage primaryStage) {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Login.screen1ID, Login.screen1File);
        mainContainer.loadScreen(Login.screen2ID, Login.screen2File);
        mainContainer.loadScreen(Login.screen3ID, Login.screen3File);
        mainContainer.loadScreen(Login.screen4ID, Login.screen4File);
        mainContainer.loadScreen(Login.screen5ID, Login.screen5File);
//        
        mainContainer.setScreen(Login.screen1ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
       
        primaryStage.show();
        
        
        
        //ventana de dialogo al cerrar
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
                
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Cierre del Sistema");
                alert.setHeaderText("Esta accion cierra el Sistema. Desea Salir?");
                alert.initOwner(primaryStage);
                
                Optional<ButtonType> result = alert.showAndWait();
               
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
            }
        });
        
    }
  
}
