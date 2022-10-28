/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.upserve1;

import Entites.service;
import Service.serviceoffre;
import utils.MyDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author MSI
 */
public class OffreController implements Initializable {
Statement stm; Connection cnx;
    private PreparedStatement pst;
    
    @FXML
            
    
    
    serviceoffre ps = new serviceoffre();
    
   private TableView<service> TableProd;
    @FXML
    private TableColumn<service,Integer> collidsero;
    @FXML
    private TableColumn<service,String> colldescsero;
    @FXML
    private TableColumn<service, String> colltypesero;
    @FXML
    private TableColumn<service,String> collimgsero;
     ObservableList<service> service = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
       
        
        
    }
        
       
        
        
        
        
        // TODO

    @FXML
    private void selectitems(MouseEvent event) {
    }

     private ObservableList<service> afficherServiceList() throws SQLException {
         ObservableList<service> fr = FXCollections.observableArrayList();
            String query="SELECT * FROM service where IdService=87";    
         stm=cnx.createStatement();
       
 
            ResultSet rst=stm.executeQuery(query);
            
            
                  //List<service> servicess=new ArrayList<>();
        while(rst.next())
           
        {
            System.out.println("OK");
        
       // s.setIdService(rst.getInt("IdService")); 
                    
                   /* s.setTypeser(rst.getString("Typeser"));
                    s.setDescriptionSer(rst.getString("DescriptionSer"));
                    s.setImageService(rst.getString("ImageService"));*/
                   service s = new service(rst.getInt("IdService"), rst.getString("Typeser"),rst.getString("DescriptionSer"), rst.getString("ImageService"));  
                     fr.add(s);
        
        }
        
    return fr;
    }

        
    
}
