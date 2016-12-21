/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Renacer
 */
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
    private AnchorPane anchorPrincipal;
    @FXML 
    private JFXButton btnRegistrarFuncionario;
    @FXML 
    private JFXTextField tfBusqueda;
    @FXML 
    private JFXButton btnBuscar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML//boton buscar funcionario
    private void btnActionBuscar (ActionEvent event) throws IOException{
        Parent buscar  = FXMLLoader.load(getClass().getResource("/dayara/view/AbmFuncionario.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(buscar);
        stage.setScene(scene);
        stage.setTitle("Buscar funcionario");
        stage.show();
        
    }
    @FXML //boton para registrar un funcionario
    private void btnActionRegistrarFuncionario(ActionEvent event) throws IOException{
        Parent registrar = FXMLLoader.load(getClass().getResource("/dayara/view/AltaFuncionario.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(registrar);
        stage.setScene(scene);
        stage.setTitle("Nuevo Funcionario");
        stage.show();
        
    }
    @FXML //boton que registra un nuevo usuario
    private void btnActionRegistrarUsuario(ActionEvent event){
    
    }
    @FXML //boton que tra                                                      e la lista de los usuarios
    private void btnActionListaUsuario(ActionEvent event){
        
    }
}
