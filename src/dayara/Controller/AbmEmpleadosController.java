/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dayara.dao.EmpleadoDao;
import dayara.model.Empleado;
import dayara.util.Utilidad;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Jorge Fabio
 */
public class AbmEmpleadosController implements Initializable {
    @FXML
    private AnchorPane anchorPaneEmpleados;
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
    private JFXDatePicker dpFechaAlta;
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
    @FXML
    private JFXButton btnAdelantos;
    @FXML
    private Text txtMensaje;
    
 
    
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
        //tfFechaAlta.setText(String.valueOf(empleado.getFecAlta()));
        dpFechaAlta.setValue(empleado.getFecAlta());
        tfSalario.setText(Utilidad.formatoValorS(empleado.getSalario()));
        
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
        if (validarCampos()) {
            if (tfCodigo.getText().isEmpty()) {
                Empleado empleado = new Empleado(
                        tfNombre.getText(), 
                        tfApellido.getText(), 
                        Integer.parseInt(tfCedula.getText()), 
                        tfTelefono.getText(), 
                        dpFechaAlta.getValue(),
                        Utilidad.formatoValorD(tfSalario.getText()), 
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
                        dpFechaAlta.getValue(),
                        Utilidad.formatoValorD(tfSalario.getText()),
                        "",
                        true);
                empleadoDao.modificar(empleado);
                limpiar();
                cargarTablaEmpleados();
            }
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
        //tfFechaAlta.setText("");
        dpFechaAlta.setValue(LocalDate.now());//resetea el valor
        tfSalario.setText("");
        txtMensaje.setText("");
    }
    
    private void buscarPorFiltro(){
        TablaEmpleadoColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        TablaEmpleadoColumnNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        TablaEmpleadoColumnApellido.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        
        listaEmpleados = empleadoDao.recuperarPorFiltro(tfBusqueda.getText());
        
        observableListaEmpleado = FXCollections.observableArrayList(listaEmpleados);
        tableEmpleados.setItems(observableListaEmpleado);
    }
    
    private boolean validarCampos(){
        boolean validar = false;
        if(tfNombre.getText().isEmpty()){
            txtMensaje.setText("El campo nombre no debe estar vacio");
            tfNombre.requestFocus();
        }else if(tfApellido.getText().isEmpty()){
            txtMensaje.setText("El campo apellido no debe estar vacio");
            tfApellido.requestFocus();
        }else if(tfCedula.getText().isEmpty()){
            txtMensaje.setText("El campo cedula no debe estar vacio");
            tfCedula.requestFocus();
        }else if(tfTelefono.getText().isEmpty()){
            txtMensaje.setText("El campo telefono no debe estar vacio");
            tfTelefono.requestFocus();
        }else if(tfSalario.getText().isEmpty()){
            txtMensaje.setText("El campo salario no debe estar vacio");
            tfSalario.requestFocus();
        }else{
            validar = true;
        }
        return validar;
    }
    
    @FXML
    private void btnAdelantosAction() throws IOException {
        generarVentana();
    }
    
    private void generarVentana() throws IOException{
        
        AnchorPane ambEmpleados = (AnchorPane) FXMLLoader.load(getClass().getResource("/dayara/view/MovAdelanto.fxml"));
        
        anchorPaneEmpleados.getChildren().setAll(ambEmpleados);
    }
}
