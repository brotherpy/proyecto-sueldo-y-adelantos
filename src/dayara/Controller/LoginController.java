/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dayara.dao.LoginDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Renacer
 */
public class LoginController implements Initializable {
    @FXML
    private JFXTextField tfUser;
    @FXML
    private JFXPasswordField tfPass;
    @FXML
    private JFXButton btnIngresar;
    @FXML
    private Text txtMensaje;
    @FXML
    private void btnIngresarAction(ActionEvent event) throws IOException{

        LoginDao dao = new LoginDao();
        
        if(dao.validarIngreso(tfUser.getText(), tfPass.getText()) == 1){
            
            Parent parent = FXMLLoader.load(getClass().getResource("/dayara/view/Principal.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Ventana Principal");
            stage.show();
            
        }else{
            txtMensaje.setText("Usuario o Password erroneos");
        }
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
