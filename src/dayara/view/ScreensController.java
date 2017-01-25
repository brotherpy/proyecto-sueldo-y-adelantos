/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.view;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author brother
 */
public class ScreensController extends StackPane {
    //Contiene la pantalla a ser mostrada
    
    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController() {
    super();
    
    }
    
    //agregar screen
    
    public void addScreen(String name, Node screen){
        screens.put(name, screen);
        
    }
    
    //retorna el nodo con su nombre
    
    public Node getScreen(String name){
        return screens.get(name);
        
        
    }
    
    //cargar el fxml invocado e inyectar al controller la ventana
    
    public boolean loadScreen(String name, String resource){
        try {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlarVentana myScreenController = ((ControlarVentana) myLoader.getController());
            myScreenController.setVentana(this);
            addScreen(name, loadScreen);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ScreensController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    //metodo que trata de mostrar ventana con nombre predefinido
    //primero trata de asegurarse de que la ventana este cargada.
    //Si existe una ventana cargada entonces la segunda es cargada y finalmente la primera es removida
    //si no existe ventana cargada entonces simplemente se carga la ventana.
    
    public boolean setScreen(final String name){
        if (screens.get(name) != null) {//ya existe ventana cargada
          
          final DoubleProperty opacity = opacityProperty();
          
          
            if (!getChildren().isEmpty()) {    //si existe mas de una ventana
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(400), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        getChildren().remove(0);                    //saca la ventana activa
                        getChildren().add(0, screens.get(name));     //agrega la ventana nueva
                        Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                new KeyFrame(new Duration(600), new KeyValue(opacity, 1.0)));
                        fadeIn.play();
                    }
                }, new KeyValue(opacity, 0.0)));
                fade.play();

            } else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));       //no existe ventana abierta
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
             return true;
        }else {
            System.out.println("no se ha cargado nada");
            return false;
        }
       
    }
    
    //metodo que removera la ventana con el nombre dado de la coleccion de ventanas
    public boolean unloadScreen(String name){
        if (screens.remove(name) == null) {
            System.out.println("no existe ventana");
            return false;
        }else{
            return true;
        }
           
    }
    
    
}
