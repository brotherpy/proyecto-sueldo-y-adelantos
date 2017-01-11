/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dayara.dao.EmpleadoDao;
import dayara.model.Empleado;
import dayara.view.ControlarVentana;
import dayara.view.ScreensController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Jorge Fabio
 */
public class MovAdelantoController implements Initializable, ControlarVentana {
    ScreensController myController;
    @FXML
    private AnchorPane anchorPaneMovAdelanto;
    @FXML
    private TableView<Empleado> tableAdelantos;
    @FXML
    private TableColumn<Empleado, String> TablaAdelantoColumnAdelanto;
    @FXML
    private TableColumn<Empleado, String> TablaAdelantoColumnFecha;
    @FXML
    private TableColumn<Empleado, String> TablaAdelantoColumnMonto;
    @FXML
    private JFXTextField tfCodigo;
    @FXML
    private JFXTextField tfNombre;
    @FXML
    private JFXTextField tfApellido;
    @FXML
    private JFXComboBox jcbAdelantos;
    @FXML
    private JFXTextField tfMonto;
    @FXML
    private JFXDatePicker dpFechaAlta;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnCancelar;
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
         
    }
    
    public void llenarDatos(int codigo){
        System.out.println(codigo); //imprime el codigo que recibe de la ventana anterior
    }
    
    @FXML
    private void btnGuardarAction(){
        
    }
    
    @FXML
    private void btnCancelarAction(){
        
    }

    @Override
    public void setVentana(ScreensController screenPage) {
       myController = screenPage;
    }
}
