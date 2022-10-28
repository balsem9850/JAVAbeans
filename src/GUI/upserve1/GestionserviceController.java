/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.upserve1;

import Entites.service;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import Service.serviceoffre; 
import java.io.FileNotFoundException;
import static java.lang.Integer.parseInt;
import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import utils.MyDB;


/**
 * FXML Controller class
 *
 * @author MSI
 */
public class GestionserviceController implements Initializable {
  
     Connection cnx=MyDB.getInstance().getConnexion();
 private PreparedStatement pst;
    @FXML
    private Button ajouterservice;
    @FXML
    private TextField idser;
    @FXML
    private TextField descser;
    @FXML
    private TextField imgser;
    @FXML
    private ChoiceBox<String> typeser;
    private String[] choice={"menage","info","jardinage"};
    
    
    @FXML
    private Button afficherservice;
    int index = -1;
    @FXML
    private TableView<service> TableProd;
    @FXML
    private TableColumn<service, Integer> collidser;
    @FXML
    private TableColumn<service, String> colldescser;
    @FXML
    private TableColumn<service, String> colltypeser;
    @FXML
    private TableColumn<service,String> collimgser;
    serviceoffre ps = new serviceoffre();
    ObservableList<service> service = FXCollections.observableArrayList();
    @FXML
    private Button supprimerservice;
    @FXML
    private Button modifierservice;
    @FXML
    private TextField Searchfield;
    @FXML
    private Label errid;
    @FXML
    private Label errdesc;
    @FXML
    private Label errtype;
    @FXML
    private Label errimg;
    /**
     * Initializes the controller class.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeser.getItems().addAll(choice);
        try {
             refreshtable();
         } catch (SQLException ex) {
             Logger.getLogger(GestionserviceController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        idser.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.isEmpty()) {
                    errid.setText("Champs vide!");
                } else {
                    errid.setText("   ");
                }
            }

        });
        
         descser.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.isEmpty()) {
                    errdesc.setText("Champs vide!");
                } else {
                    errdesc.setText("   ");
                }
            }

        });
        
        
        
        
    }   
    
     private boolean validateid() {
        if ((idser.getText().trim().length() > 0) ) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Remplissez vos champs svp  ");
            alert.setHeaderText(null);
            alert.setContentText("Error");
            alert.showAndWait();

            return false;
        }
    }
     
     private boolean validatedesc() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(descser.getText());
        if (m.find() && m.group().equals(descser.getText())) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Valider la description");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez entrer description");
            alert.showAndWait();

            return false;
        }
    }
    
    

    @FXML
    private void ajouterservice(ActionEvent event) throws FileNotFoundException, SQLException {
        serviceoffre pss = new serviceoffre();
        
     service s = new service(Integer.parseInt(idser.getText()),typeser.getValue(), descser.getText(), imgser.getText());

               try{
                   
               if ((validateid()) & (validatedesc())){
                
                pss.Addservice(s);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ajout du produit");
                alert.setContentText("Produit ajouté!");
                alert.show();
               }
            }catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
    
    }
    
      @FXML
    private void afficherservice() throws  SQLException {
        serviceoffre ps= new serviceoffre();
        
                service =ps.chercherservice (Searchfield.getText());

        
        collidser.setCellValueFactory(new PropertyValueFactory<>("IdService"));
        colldescser.setCellValueFactory(new PropertyValueFactory<>("DescriptionSer"));
        colltypeser.setCellValueFactory(new PropertyValueFactory<>("Typeser"));
        collimgser.setCellValueFactory(new PropertyValueFactory<>("ImageService"));
        

        TableProd.setItems(service);
        
    }

    

    @FXML
    private void supprimerservice(ActionEvent event) throws SQLException {
        if (TableProd.getSelectionModel().getSelectedItem() != null) {
            ps.Deleteservice(TableProd.getSelectionModel().getSelectedItem().getIdService());
            service.remove(service);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Produit supprimé!");
            alert.show();
            afficherservice();
    }
  
   
    
    }

    @FXML
    private void modifierservice() throws SQLException {
     
        if (TableProd.getSelectionModel().getSelectedItem() != null) {
            service s = new service(TableProd.getSelectionModel().getSelectedItem().getIdService(),typeser.getValue(), descser.getText(), imgser.getText());
        serviceoffre pss = new serviceoffre();
        pss.Updateservice(s);
        String description = descser.getText();
        String type = typeser.getValue();
        String image=imgser.getText();
        refreshtable();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification du produit");
        alert.setContentText("Produit modifié!");
        alert.show();
     }
        
        
        
        
    }
     /** String description = descser.getText();
        String type = typeser.getValue();
        String image=imgser.getText();
     int indi = TableProd.getSelectionModel().getSelectedItem().getIdService();
        PreparedStatement stm = cnx.prepareStatement("update service set TotalEnStock='" + type + "',disponibilite='" + description + "',image='" + image +"'where refProd='" + indi + "'");
        stm.execute();
        afficherservice();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification du produit");
        alert.setContentText("Produit modifié!");
        alert.show();
        
    }**/
      /** private void select_items(MouseEvent event) {
        index = TableProd.getSelectionModel().getSelectedIndex();

        if (index <= -1) {

            return;
        }

        typeser.setValue(colltypeser.getCellData(index));
        descser.setText(colldescser.getCellData(index));
    }**/
      
    public void refreshtable() throws SQLException
    {
        serviceoffre ps= new serviceoffre();
        service =ps.afficherservice();
        
        collidser.setCellValueFactory(new PropertyValueFactory<>("IdService"));
        colldescser.setCellValueFactory(new PropertyValueFactory<>("DescriptionSer"));
        colltypeser.setCellValueFactory(new PropertyValueFactory<>("Typeser"));
        collimgser.setCellValueFactory(new PropertyValueFactory<>("ImageService"));
        

        TableProd.setItems(service);
    }
    @FXML
    private void selectitems(MouseEvent event) {
        index = TableProd.getSelectionModel().getSelectedIndex();

        if (index <= -1) {

            return;
        }
        
        typeser.setValue(colltypeser.getCellData(index));
        descser.setText(colldescser.getCellData(index));
        imgser.setText(collimgser.getCellData(index));
    }
   
    
    
}