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
import dayara.dao.AdelantoMovimientoDao;
import dayara.dao.DescuentosDao;
import dayara.dao.EmpleadoDao;
import dayara.model.DescuentoDetalle;
import dayara.model.Empleado;
import dayara.view.ControlarVentana;
import dayara.view.ScreensController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javax.swing.DefaultComboBoxModel;

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
    private TableView<DescuentoDetalle> tableAdelantos;
    @FXML
    private TableColumn<DescuentoDetalle, String> TablaAdelantoColumnAdelanto;
    @FXML
    private TableColumn<DescuentoDetalle, String> TablaAdelantoColumnFecha;
    @FXML
    private TableColumn<DescuentoDetalle, String> TablaAdelantoColumnMonto;
    @FXML
    public JFXTextField tfCodigo;
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
    
 
    
    private List<DescuentoDetalle> listaDescuentos;
    
    private ObservableList<DescuentoDetalle> observableListaDescuentos;
    
    private final DescuentosDao daoDescuentos = new DescuentosDao();
    private final AdelantoMovimientoDao daoDescuentoMovimiento = new AdelantoMovimientoDao();
    private final EmpleadoDao daoEmpleado = new EmpleadoDao();
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
    
    public void buscarPorFuncionario(){
        
        TablaAdelantoColumnAdelanto.setCellValueFactory(new PropertyValueFactory<>("concepto"));
        TablaAdelantoColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        TablaAdelantoColumnMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        
        listaDescuentos = daoDescuentoMovimiento.recuperarTodoPorFuncionario(Integer.parseInt(tfCodigo.getText()));
        
        observableListaDescuentos = FXCollections.observableArrayList(listaDescuentos);
        tableAdelantos.setItems(observableListaDescuentos);
        
    }
    
    public void cargarFuncionario(){
        Empleado emp = daoEmpleado.recuperarPorCodigo(Integer.parseInt(tfCodigo.getText()));
        tfNombre.setText(emp.getNombre());
        tfApellido.setText(emp.getApellido());
    }
}
