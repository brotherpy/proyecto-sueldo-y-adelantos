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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
//    @FXML
//    private JFXButton btnRegistrarFuncionario;
    @FXML
    private JFXButton btnSalir;
    
    @FXML
    private ImageView btnEmpleado;
    
    
    
    //parte nueva interfaz
    @FXML
    private Button btnFuncionario;
    @FXML
    private Button btnMovimientos;
    @FXML
    private Button btnUser;
    
    @FXML
    private Label lblAviso;
   

    
    
    
    @FXML
    private void btnFuncionarioAction() throws IOException{
        //generarVentana();
        mycontroller.setScreen(Login.screen3ID);
       
    }
     @FXML
    void btnMovimientosAction(ActionEvent event) {
         mycontroller.setScreen(Login.screen4ID);
    }
     @FXML
    void btnUserAction(ActionEvent event) {
         mycontroller.setScreen(Login.screen5ID);
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
    // mouse over comportamiento cuando el mouse esta encima
    @FXML
    void btnChange(MouseEvent event) {
       
        btnFuncionario.setStyle("-fx-background-image: url(/dayara/images/ funcionarioGreen.png); "
                + "-fx-background-size: 250, 250; -fx-background-repeat: no-repeat; "
                + "-fx-background-position: center; -fx-border-radius: 5px; -fx-background-color: #FFF;");
        
        lblAviso.setText("Realiza las operaciones concernientes a Funcionario");
        
      
    }
    //vuelta a lo normal cuando el mouse sale
    @FXML
    void btnChangeOriginal(MouseEvent event) {
        btnFuncionario.setStyle("-fx-background-image: url(/dayara/images/ FuncionarioRed.png); "
                + "-fx-background-size: 230, 230; -fx-background-repeat: no-repeat; "
                + "-fx-background-position: center; -fx-border-radius: 5px; -fx-background-color: #FFF;");
        lblAviso.setText("");
        
    }
   
    @FXML
    void btnChangeMovimiento(MouseEvent event) {
        btnMovimientos.setStyle("-fx-background-image: url(/dayara/images/ movimientoGreen.png); "
                + "-fx-background-size: 250, 250; -fx-background-repeat: no-repeat; "
                + "-fx-background-position: center; -fx-border-radius: 5px; -fx-background-color: #FFF;");
        lblAviso.setText("Otorga adelanto, liquidacion, revisa informes de pago.");

    }



    @FXML
    void btnChangeOriginalMovimiento(MouseEvent event) {
         btnMovimientos.setStyle("-fx-background-image: url(/dayara/images/ movimientoRed.png); "
                + "-fx-background-size: 230, 230; -fx-background-repeat: no-repeat; "
                + "-fx-background-position: center; -fx-border-radius: 5px; -fx-background-color: #FFF;");
         lblAviso.setText("");

    }
     
    
    @FXML
    void btnChangeUser(MouseEvent event) {
         btnUser.setStyle("-fx-background-image: url(/dayara/images/ userGreen.png); "
                + "-fx-background-size: 250, 250; -fx-background-repeat: no-repeat; "
                + "-fx-background-position: center; -fx-border-radius: 5px; -fx-background-color: #FFF;");
         lblAviso.setText("Agrega y edita Usuarios del Sistema");

    }

    
    @FXML
    void btnChangeOriginalUser(MouseEvent event) {
        btnUser.setStyle("-fx-background-image: url(/dayara/images/ userRed.png); "
                + "-fx-background-size: 230, 230; -fx-background-repeat: no-repeat; "
                + "-fx-background-position: center; -fx-border-radius: 5px; -fx-background-color: #FFF;");
        lblAviso.setText("");

    }

  
     
    
}
