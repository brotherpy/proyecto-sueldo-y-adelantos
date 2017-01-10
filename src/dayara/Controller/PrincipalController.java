/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import dayara.view.ControlarVentana;
import dayara.view.Login;
import dayara.view.ScreensController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Fabio
 */
public class PrincipalController implements Initializable, ControlarVentana {
    ScreensController mycontroller;
    
    
    @FXML
    private AnchorPane anchorPanePrincipal;
    @FXML
    private MenuItem MenuITemCatastroEmpleado;
    @FXML
    private MenuItem MenuITemCatastroUsuario;
    @FXML
    private MenuItem MenuITemMovimientosAdelantos;
    @FXML
    private JFXButton btnRegistrarFuncionario;
    @FXML
    private JFXButton btnSalir;
    @FXML
    private void btnActionRegistrarFuncionario() throws IOException{
        //generarVentana();
        mycontroller.setScreen(Login.screen3ID);
    }
    @FXML
    private void btnSalirAction(){
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void MenuITemCatastroEmpleadoAction()throws IOException{
        generarVentana();
    }
    @FXML
    private void MenuITemCatastroUsuarioAction()throws IOException{
        generarVentanaUsuario();
    }
    @FXML
    private void MenuITemMovimientosAdelantosAction()throws IOException{
        generarVentanaAdelantos();
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

    private void generarVentanaUsuario() throws IOException {
        AnchorPane ambUsuarios = (AnchorPane) FXMLLoader.load(getClass().getResource("/dayara/view/AbmUsuarios.fxml"));
        
        anchorPanePrincipal.getChildren().setAll(ambUsuarios);
    }

    private void generarVentanaAdelantos() throws IOException {
        AnchorPane movAdelanto = (AnchorPane) FXMLLoader.load(getClass().getResource("/dayara/view/MovAdelanto.fxml"));
        
        anchorPanePrincipal.getChildren().setAll(movAdelanto);
    }

    @Override
    public void setVentana(ScreensController screenPage) {
        mycontroller = screenPage;
    }
}
