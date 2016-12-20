/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dayara.model.Empleado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author brother
 */
public class AbmFuncionarioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Empleado> empleadoTable;
    
    @FXML
    private TableColumn<Empleado, String> Nombre;

    @FXML
    private TableColumn<Empleado, String> Apellido;

    @FXML
    private TableColumn<Empleado, String> Documento;

    @FXML
    private TableColumn<Empleado, Double> Salario;
    @FXML
    private JFXTextField tfNombre;

    @FXML
    private JFXTextField tfApellido;

    @FXML
    private JFXTextField tfDocumento;

    @FXML
    private JFXTextField tfSalario;

    @FXML
    private JFXTextField tfTelefono;

    @FXML
    private JFXTextArea tfObservacion;

    @FXML
    private JFXButton btnRegistrarFuncionario;

    @FXML
    private JFXButton btnRegistrarFuncionario1;

    @FXML
    void btnActionAdelanto(ActionEvent event) {

    }

    @FXML
    void btnActionCancelar(ActionEvent event) {

    }

    @FXML
    void btnActionEditar(ActionEvent event) {

    }

    @FXML
    void btnActionEliminar(ActionEvent event) {

    }

    @FXML
    void btnActionGuardar(ActionEvent event) {

    }

    @FXML
    void btnActionLiquidacion(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
