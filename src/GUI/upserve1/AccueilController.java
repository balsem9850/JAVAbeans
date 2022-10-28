/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.upserve1;

import static com.sun.javafx.application.PlatformImpl.exit;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Platform.exit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AccueilController implements Initializable {



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
    }    

    private void interfacedemeneagement(MouseEvent event)throws Exception {
        Stage istage = new Stage();													
		Parent root = FXMLLoader.load(getClass().getResource("/GUI/upserve1/demenagementservice.fxml")); 
		Scene scene = new Scene(root,800,480);											 
		scene.getStylesheets().add(getClass().getResource("accueil.css").toExternalForm());
		istage.setScene(scene);
		istage.show();
                
    }


    @FXML
    private void ajtservinterface(ActionEvent event) throws IOException {
    
         Stage istage = new Stage();													
		Parent root = FXMLLoader.load(getClass().getResource("/GUI/upserve1/Gestionservice.fxml")); 
		Scene scene = new Scene(root,1000,700);											 
		
		istage.setScene(scene);
		istage.show();
    }

    @FXML
    private void consulterservice(ActionEvent event) throws IOException {
       Stage istage = new Stage();													
		Parent root = FXMLLoader.load(getClass().getResource("/GUI/upserve1/ConsulterService.fxml")); 
		Scene scene = new Scene(root,1100,780);											 
		
		istage.setScene(scene);
		istage.show(); 
        
    }

    
}
 

