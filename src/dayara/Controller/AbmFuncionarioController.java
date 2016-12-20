/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dayara.dao.EmpleadoDao;
import dayara.model.Empleado;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableColumn<Empleado, String> tcNombre;

    @FXML
    private TableColumn<Empleado, String> tcApellido;

    @FXML
    private TableColumn<Empleado, Integer> tcDocumento;

    @FXML
    private TableColumn<Empleado, Double> tcSalario;
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
    void btnActionLiquidacion(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
//observableList
    private EmpleadoDao busqueda;
    private List<Empleado> listempleado;
    private ObservableList<Empleado> obslistempleado;
    private void llenarTable() {
       tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
       tcApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
       tcDocumento.setCellValueFactory(new PropertyValueFactory<>("cedula"));
       tcSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
       listempleado = busqueda.llenarTabla();
       obslistempleado = FXCollections.observableArrayList(listempleado);
       empleadoTable.setItems(obslistempleado);
       
    }
     @FXML
    void btnActionGuardar(ActionEvent event) {
        llenarTable();

    }
    
}
