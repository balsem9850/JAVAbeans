/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.upserve1;

import Entites.service;
import Service.serviceoffre;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ConsulterServiceController implements Initializable {
    private Connection cnx;
    @FXML
    private TableView<service> TableProd;
    @FXML
    private TableColumn<service,Integer> collidser;
    @FXML
    private TableColumn<service,String> colldescser;
    @FXML
    private TableColumn<service,String> colltypeser;
    @FXML
    private TableColumn<service,String> collimgser;

    
    
    serviceoffre ps = new serviceoffre();
    ObservableList<service> service = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            afficherServiceList();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

   
    
    @FXML
    private void ajtservinterface(ActionEvent event) {
        
    }

    @FXML
    private void selectitems(MouseEvent event) throws IOException {
        
         /*Stage istage = new Stage();													
		Parent root = FXMLLoader.load(getClass().getResource("/upserve1/offre.fxml")); 
		Scene scene = new Scene(root,1000,700);											 
		
		istage.setScene(scene);
		istage.show();*/
         
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Demande service");
                alert.setContentText(" créer un contrat!");
                alert.show();
    }

    @FXML
    private void afficherServiceList() throws SQLException {
    serviceoffre ps = new serviceoffre();
        service = ps.afficherservice();
        collidser.setCellValueFactory(new PropertyValueFactory<>("IdService"));
        colldescser.setCellValueFactory(new PropertyValueFactory<>("DescriptionSer"));
        colltypeser.setCellValueFactory(new PropertyValueFactory<>("Typeser"));
        collimgser.setCellValueFactory(new PropertyValueFactory<>("ImageService"));
        

        TableProd.setItems(service);
    }
    

    /*@FXML
    private void load(ActionEvent event) {
        FXMLLoader LOADER = new FXMLLoader(getClass().getResource("/view/Monpanier.fxml"));

                    Parent root = LOADER.load();
//                    MonpanierController controller2 = LOADER.getController();
//                    controller2.initdata(TableProd.getSelectionModel().getSelectedItem());
                   //int selecteditem= tablePub.getSelectionModel().getSelectedItem().getId_publication();
                      // controller2.setId_pubtextfield(selecteditem);


                    Scene sc = new Scene(root);
                     // ModifieruserController cntr = LOADER.getController();
                      Stage window =(Stage)((Node) event.getSource()).getScene().getWindow() ;
                      window.setScene(sc);
                      window.show(); 
        
    }
*/
}