/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dayara.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dayara.dao.UsuariosDao;
import dayara.model.Usuarios;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author jorge
 */
public class AbmUsuariosController implements Initializable {

    @FXML
    private AnchorPane achorPaneUsuarios;
    @FXML
    private TableView<Usuarios> tableUsuarios;
    @FXML
    private TableColumn<Usuarios, String> tablaUsuariosColumnCodigo;
    @FXML
    private TableColumn<Usuarios, String> tablaUsuariosColumnUsuario;
    @FXML
    private JFXTextField tfBusqueda;
    @FXML
    private JFXTextField tfCodigo;
    @FXML
    private JFXTextField tfUsuario;
    @FXML
    private JFXTextField tfPassword;
    @FXML
    private JFXTextField tfConfirmPass;
    @FXML
    private JFXButton btnBuscar;
    @FXML
    private JFXButton btnNuevo;
    @FXML
    private JFXButton btnGuardar;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private Text txtMensaje;
    
 
    
    private List<Usuarios> listaUsuarios;
    
    private ObservableList<Usuarios> observableListaUsuarios;
    
    private final UsuariosDao usuarioDao = new UsuariosDao();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTablaUsuarios();
        
        tableUsuarios.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> seleccionarItemsTableCliente(newValue));
    }    
    
    private void cargarTablaUsuarios(){
        tablaUsuariosColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablaUsuariosColumnUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        
        listaUsuarios = usuarioDao.llenarTabla();
        
        observableListaUsuarios = FXCollections.observableArrayList(listaUsuarios);
        tableUsuarios.setItems(observableListaUsuarios);
    }

    private void seleccionarItemsTableCliente(Usuarios usuario) {
        tfCodigo.setText(String.valueOf(usuario.getId()));
        tfUsuario.setText(usuario.getUsuario());
        tfPassword.setPromptText("Password actual");
        tfConfirmPass.setPromptText("Ingrese nuevo password");
        
    }
    @FXML
    private void btnBuscarAction(){
        buscarPorFiltro();
    }
    @FXML
    private void btnNuevoAction(){
        limpiar();
        tfUsuario.requestFocus();

    }
    @FXML
    private void btnGuardarAction(){
        if (tfCodigo.getText().isEmpty()) {
            guardarUsuario();
        }else{
            modificarUsuario();
        }
    }
    @FXML
    private void btnCancelarAction(Event event){
        btnCancelar.getScene().getWindow().hide();
    }

    private void limpiar() {
        tfBusqueda.setText("");
        tfCodigo.setText("");
        tfUsuario.setText("");
        tfPassword.setText("");
        tfPassword.setPromptText("Password");
        tfConfirmPass.setText("");
        tfConfirmPass.setPromptText("Confirmar password");
        txtMensaje.setText("");
    }
    
    private void buscarPorFiltro(){
        tablaUsuariosColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tablaUsuariosColumnUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
                
        listaUsuarios = usuarioDao.recuperarPorFiltro(tfBusqueda.getText());
        
        observableListaUsuarios = FXCollections.observableArrayList(listaUsuarios);
        tableUsuarios.setItems(observableListaUsuarios);
    }

    private void guardarUsuario() {
        if(validarCampos()){
            if(tfPassword.getText() == null ? tfConfirmPass.getText() == null : tfPassword.getText().equals(tfConfirmPass.getText())){
                Usuarios usuario = new Usuarios(
                        tfUsuario.getText(),
                        tfPassword.getText(),
                        true);
                usuarioDao.guardar(usuario);
                limpiar();
                cargarTablaUsuarios();
            } else {
                txtMensaje.setText("Las contraseñas no coinciden");
                tfPassword.requestFocus();
                tfConfirmPass.setText("");
            }
        }
    }

    private void modificarUsuario() {
        if(validarCampos()){
            
            String verificar;
            
            verificar = usuarioDao.validarPassword(Integer.parseInt(tfCodigo.getText()));
            
            if(verificar == null ? tfPassword.getText() == null : verificar.equals(tfPassword.getText())){
                Usuarios usuario = new Usuarios(
                        Integer.parseInt(tfCodigo.getText()), 
                        tfConfirmPass.getText());
                usuarioDao.modificar(usuario);
                limpiar();
                cargarTablaUsuarios();
            }else{
                txtMensaje.setText("La contraseña actual no es valida");
                tfPassword.requestFocus();
                tfConfirmPass.setText("");
            }
        }
    }
    
    private boolean validarCampos(){
        boolean validar = false;
        if(tfUsuario.getText().isEmpty()){
            txtMensaje.setText("El campo usuario no debe estar vacio");
            tfUsuario.requestFocus();
        }else if(tfPassword.getText().isEmpty()){
            txtMensaje.setText("El campo password no debe estar vacio");
            tfPassword.requestFocus();
        }else if(tfConfirmPass.getText().isEmpty()){
            txtMensaje.setText("El campo confirmacion no debe estar vacio");
            tfConfirmPass.requestFocus();
        }else{
            validar = true;
        }
        return validar;
    }
}