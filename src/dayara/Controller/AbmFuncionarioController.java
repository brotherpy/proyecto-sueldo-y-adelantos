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
    
    private List <Empleado> listaEmpleados;
    private ObservableList<Empleado> observableListaEmpleados;
    
    private final EmpleadoDao empl = new EmpleadoDao();
    

    @FXML
    void btnActionAdelanto(ActionEvent event) {

    }

    @FXML
    void btnActionCancelar(ActionEvent event) {

    }

    @FXML
    public void btnActionGuardar(){
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
        cargarTablaEmpleado();
        
        empleadoTable.getSelectionModel().selectedItemProperty().addListener(
        (Observable, oldValue, newValue) -> seleccionarItemTableEmpleados(newValue));
    }

    public void cargarTablaEmpleado(){
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tcApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        tcDocumento.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
        tcSalario.setCellValueFactory(new PropertyValueFactory<>("Salario"));
        
        listaEmpleados = empl.llenarTabla();
        
        observableListaEmpleados = FXCollections.observableArrayList(listaEmpleados);
        empleadoTable.setItems(observableListaEmpleados);
    }
    
    public void seleccionarItemTableEmpleados(Empleado empleado){
        tfNombre.setText(empleado.getNombre());
        tfApellido.setText(empleado.getApellido());
        tfDocumento.setText(String.valueOf(empleado.getCedula()));
        tfSalario.setText(String.valueOf(empleado.getSalario()));
        tfTelefono.setText(empleado.getTelefono());
    }
}
