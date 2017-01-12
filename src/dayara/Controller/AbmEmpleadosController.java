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
import dayara.view.ControlarVentana;
import dayara.view.Login;
import dayara.view.ScreensController;
import javafx.scene.input.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jorge Fabio
 */
public class AbmEmpleadosController implements Initializable, ControlarVentana {
    ScreensController myController;
    
    
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
    //
    ///
    ///
    //inicializando elementos de adelanto
    ///
    ///
        @FXML
    private AnchorPane anchorPaneMovAdelanto;

   
    @FXML
    private JFXTextField tfMonto;

    @FXML
    private JFXDatePicker dpFechaAdelanto;


    @FXML
    private TableView<?> tableAdelantos;

    @FXML
    private TableColumn<?, ?> TablaAdelantoColumnAdelanto;

    @FXML
    private TableColumn<?, ?> TablaAdelantoColumnFecha;

    @FXML
    private TableColumn<?, ?> TablaAdelantoColumnMonto;
    
    ///
    ///fin de la inicializacion
    ///
 
    
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
         tfNombre.textProperty().addListener((ov, oldValue, newValue) ->{ //convertir a mayusculas
        tfNombre.setText(newValue.toUpperCase());
        });
       
        tfNombre.addEventFilter(KeyEvent.KEY_TYPED, validacionLetra(20)); //solo acepta letras hasta 20 caracteres
        tfCedula.addEventFilter(KeyEvent.KEY_TYPED, validacionNumerica(7));//validacion numerica aplicada a cedula limitando los digitos a 7
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
        dpFechaAlta.setValue(empleado.getFecAlta());
        tfSalario.setText(Utilidad.formatoValorS(empleado.getSalario()));
        
    }
    
    //**
    //Botones de accion
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
    @FXML
    private void btnAdelantosAction(Event event) {
     
       
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/dayara/view/MovAdelanto.fxml"));
             try {
            Loader.load();
            
        } catch (IOException ex) {
            Logger.getLogger(AbmEmpleadosController.class.getName()).log(Level.SEVERE, null, ex);
        }
             MovAdelantoController movAdelantoController = Loader.getController();
             movAdelantoController.tfCodigo.setText(tableEmpleados.getSelectionModel().getSelectedItem().getId()+"");
             
        Parent parent = Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.show();
        movAdelantoController.buscarPorFuncionario();
        movAdelantoController.cargarFuncionario();
      
             
     
        
    }
    
    
    
    //**
    //METODOS
    
    //validacion numerica incluso con maximo de campos
   
    public EventHandler<KeyEvent> validacionNumerica(final Integer max_Lengh) {
    return new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            JFXTextField fXTextField = (JFXTextField) e.getSource();                
            if (fXTextField.getText().length() >= max_Lengh) {                    
                e.consume();
            }
            if(e.getCharacter().matches("[0-9.]")){ 
                if(fXTextField.getText().contains(".") && e.getCharacter().matches("[.]")){
                    e.consume();
                }else if(fXTextField.getText().length() == 0 && e.getCharacter().matches("[.]")){
                    e.consume(); 
                }
            }else{
                e.consume();
            }
        }
    };
}    
    
    
    //validacion solo letras incluso maximo de campos
    
    public EventHandler<KeyEvent> validacionLetra(final Integer max_Lengh) {
    return new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            JFXTextField tfFXTextField = (JFXTextField) e.getSource();                
            if (tfFXTextField.getText().length() >= max_Lengh) {                    
                e.consume();
            }
            if(e.getCharacter().matches("[A-Za-z]")){ 
            }else{
                e.consume();
            }
        }
    };
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
    


    @Override
    public void setVentana(ScreensController screenPage) {
        myController = screenPage;
    }
}