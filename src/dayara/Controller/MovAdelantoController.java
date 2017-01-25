/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dayara.dao.DescuentosMovimientoDao;
import dayara.dao.DescuentosDao;
import dayara.dao.EmpleadoDao;
import dayara.model.DescuentoDetalle;
import dayara.model.DescuentoMovimiento;
import dayara.model.Descuentos;
import dayara.model.Empleado;
import dayara.view.ControlarVentana;
import dayara.view.Login;
import dayara.view.ScreensController;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private ComboBox <Descuentos> jcbAdelantos;
    @FXML
    private JFXTextField tfMonto;
    @FXML
    private JFXDatePicker dpFechaAdelanto;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private Text txtMensaje;
    
    //nueva interfaz
    @FXML
    private Button btnAtras;
    
    
    
    
    
    
    private final DescuentosDao daoDescuentos = new DescuentosDao();
    private final DescuentosMovimientoDao daoDescuentoMovimiento = new DescuentosMovimientoDao();
    private final EmpleadoDao daoEmpleado = new EmpleadoDao();
 
    
    private List<DescuentoDetalle> listaDescuentos;
    
    //para cargar el comboBox se crea una lista con los detalles de los descuentos
    private final List<Descuentos> listaConceptoDescuentos = daoDescuentos.recuperarTodo();
    //luego se crea una ObservableList del tipo de datos que va conener y se incializa con la lista creada
    //anterior mente
    private final ObservableList<Descuentos> comboList = FXCollections.observableArrayList(
            listaConceptoDescuentos
    );
    private ObservableList<DescuentoDetalle> observableListaDescuentos;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // se carga el comboBox al inicializar la ventana
        jcbAdelantos.setItems(comboList);
    }
    
    @FXML
    void btnGuardarAction(ActionEvent event) {
        DescuentoMovimiento mov = new DescuentoMovimiento();
        mov.setIdEmpleado(Integer.parseInt(tfCodigo.getText()));
        mov.setFecha(dpFechaAdelanto.getValue());
        mov.setIdAdelanto(jcbAdelantos.getSelectionModel().getSelectedIndex()+1);
        mov.setMonto(Double.parseDouble(tfMonto.getText()));
        mov.setEstado("PENDIENTE");
        daoDescuentoMovimiento.guardar(mov);
        limpiar();
        buscarPorFuncionario();
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
    
    public void cargarComboBox(){
    }

    private void limpiar() {
        tfMonto.setText("");
        dpFechaAdelanto.setValue(LocalDate.now());
        jcbAdelantos.setValue(null);
    }
    
      @FXML
    void btnAtrasAction(ActionEvent event) {
         myController.setScreen(Login.screen2ID);
    }

    @FXML
    void btnAtrasEntered(MouseEvent event) {

    }

    @FXML
    void btnAtrasExited(MouseEvent event) {

    }

}
