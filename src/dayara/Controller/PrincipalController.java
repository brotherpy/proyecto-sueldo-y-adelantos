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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jorge Fabio
 */
public class PrincipalController implements Initializable {
@FXML
    private AnchorPane anchorPanePrincipal;
    @FXML
    private MenuItem MenuITemCatastroEmpleado;
    @FXML
    private JFXButton btnRegistrarFuncionario;
    @FXML
    private void btnActionRegistrarFuncionario() throws IOException{
        generarVentana();
    }
    @FXML
    private void MenuITemCatastroEmpleadoAction()throws IOException{
        generarVentana();
    }
    
    private void generarVentana() throws IOException{
        AnchorPane ambEmpleados = (AnchorPane) FXMLLoader.load(getClass().getResource("/dayara/view/AbmEmpleados.fxml"));
        
        anchorPanePrincipal.getChildren().setAll(ambEmpleados);
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
