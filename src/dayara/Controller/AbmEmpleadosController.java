/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dayara.dao.EmpleadoDao;
import dayara.model.Empleado;
import dayara.util.Utilidad;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Jorge Fabio
 */
public class AbmEmpleadosController implements Initializable {
    @FXML
    private AnchorPane anchorPaneEmpleado;
    @FXML
    private TableView<Empleado> tableEmpleados;
    @FXML
    private TableColumn<Empleado, String> TablaEmpleadoColumnCodigo;
    @FXML
    private TableColumn<Empleado, String> TablaEmpleadoColumnNombre;
    @FXML
    private TableColumn<Empleado, String> TablaEmpleadoColumnApellido;
    @FXML
    private JFXTextField tfBusqueda;
    @FXML
    private JFXTextField tfCodigo;
    @FXML
    private JFXTextField tfNombre;
    @FXML
    private JFXTextField tfApellido;
    @FXML
    private JFXTextField tfCedula;
    @FXML
    private JFXTextField tfTelefono;
    @FXML
    private JFXTextField tfFechaAlta;
    @FXML
    private JFXTextField tfSalario;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnNuevo;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnCancelar;
    
    
    private List<Empleado> listaEmpleados;
    
    private ObservableList<Empleado> observableListaEmpleado;
    
    private final EmpleadoDao empleadoDao = new EmpleadoDao();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTablaEmpleados();
        
        tableEmpleados.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> seleccionarItemsTableCliente(newValue));
    }    
    
    private void cargarTablaEmpleados(){
        TablaEmpleadoColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        TablaEmpleadoColumnNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        TablaEmpleadoColumnApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        
        listaEmpleados = empleadoDao.llenarTabla();
        
        observableListaEmpleado = FXCollections.observableArrayList(listaEmpleados);
        tableEmpleados.setItems(observableListaEmpleado);
    }

    private void seleccionarItemsTableCliente(Empleado empleado) {
        tfCodigo.setText(String.valueOf(empleado.getId()));
        tfNombre.setText(empleado.getNombre());
        tfApellido.setText(empleado.getApellido());
        tfCedula.setText(String.valueOf(empleado.getCedula()));
        tfTelefono.setText(String.valueOf(empleado.getTelefono()));
        tfFechaAlta.setText(String.valueOf(empleado.getFecAlta()));
        tfSalario.setText(String.valueOf(empleado.getSalario()));
        
    }
    @FXML
    private void btnBuscarAction(){
        buscarPorFiltro();
    }
    @FXML
    private void btnNuevoAction(){
        limpiar();
        tfNombre.requestFocus();

    }
    @FXML
    private void btnGuardarAction(){
        if (tfCodigo.getText().isEmpty()) {
            Empleado empleado = new Empleado(
                    tfNombre.getText(), 
                    tfApellido.getText(), 
                    Integer.parseInt(tfCedula.getText()), 
                    tfTelefono.getText(), 
                    Utilidad.deStringADate(tfFechaAlta.getText()),
                    Double.parseDouble(tfSalario.getText()), 
                    "", 
                    true);
            empleadoDao.guardar(empleado);
            limpiar();
            cargarTablaEmpleados();
        }else{
            Empleado empleado = new Empleado(
                    Integer.parseInt(tfCodigo.getText()), 
                    tfNombre.getText(), 
                    tfApellido.getText(), 
                    Integer.parseInt(tfCedula.getText()), 
                    tfTelefono.getText(),
                    Utilidad.deStringADate(tfFechaAlta.getText()),
                    Double.parseDouble(tfSalario.getText()),
                    "",
                    true);
            empleadoDao.modificar(empleado);
            limpiar();
            cargarTablaEmpleados();
        }
    }
    @FXML
    private void btnCancelarAction(Event event){
        btnCancelar.getScene().getWindow().hide();
    }

    private void limpiar() {
        tfBusqueda.setText("");
        tfCodigo.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
        tfCedula.setText("");
        tfTelefono.setText("");
        tfFechaAlta.setText("");
        tfSalario.setText("");
    }
    
    private void buscarPorFiltro(){
        TablaEmpleadoColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        TablaEmpleadoColumnNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        TablaEmpleadoColumnApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        
        listaEmpleados = empleadoDao.recuperarPorFiltro(tfBusqueda.getText());
        
        observableListaEmpleado = FXCollections.observableArrayList(listaEmpleados);
        tableEmpleados.setItems(observableListaEmpleado);
    }
}
