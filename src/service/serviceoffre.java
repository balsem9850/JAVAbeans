/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entites.service;
import utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Servi.iserviceoffre;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MSI
 */
public class serviceoffre implements iserviceoffre{
    Connection cnx;
     Statement stm;
    private PreparedStatement pst;
    
   

    public serviceoffre(){
    cnx=MyDB.getInstance().getConnexion()  ;
    }
    
   
 public ObservableList<service> chercherservice(String desc)throws SQLException {
         ObservableList<service> fr = FXCollections.observableArrayList();
            String query="SELECT * FROM service where Descriptionser LIKE '%"+desc+"%'";    
         stm=cnx.createStatement();
       
 
            ResultSet rst=stm.executeQuery(query);
            
            
                  //List<service> servicess=new ArrayList<>();
        while(rst.next())
           
        {
       
        
       // s.setIdService(rst.getInt("IdService")); 
                    
                   /* s.setTypeser(rst.getString("Typeser"));
                    s.setDescriptionSer(rst.getString("DescriptionSer"));
                    s.setImageService(rst.getString("ImageService"));*/
                   service s = new service(rst.getInt("IdService"), rst.getString("Typeser"),rst.getString("DescriptionSer"), rst.getString("ImageService"));  
                     fr.add(s);
        
        }
        
    return fr;
    }
    
   public ObservableList<service> afficherservice()throws SQLException {
         ObservableList<service> fr = FXCollections.observableArrayList();
            String query="SELECT * FROM service";    
         stm=cnx.createStatement();
       
 
            ResultSet rst=stm.executeQuery(query);
            
            
                  //List<service> servicess=new ArrayList<>();
        while(rst.next())
           
        {
       
        
       // s.setIdService(rst.getInt("IdService")); 
                    
                   /* s.setTypeser(rst.getString("Typeser"));
                    s.setDescriptionSer(rst.getString("DescriptionSer"));
                    s.setImageService(rst.getString("ImageService"));*/
                   service s = new service(rst.getInt("IdService"), rst.getString("Typeser"),rst.getString("DescriptionSer"), rst.getString("ImageService"));  
                     fr.add(s);
        
        }
        
    return fr;
    }



    @Override
    public void Addservice(service s) throws SQLException {
  try {
           //  stm=cnx.createStatement();
        String query="INSERT INTO service(IdService,Typeser,DescriptionSer,ImageService) VALUES (?,?,?,?)";
                   
     
            pst=cnx.prepareStatement(query);
            
            pst.setInt(1,s.getIdService());
            pst.setString(2,s.getTypeser());
            pst.setString(3,s.getDescriptionSer());
            pst.setString(4,s.getImageService());
              
          
            pst.executeUpdate();
         
            System.out.println("Service ajouté");
      
        
        } catch (SQLException ex) {
            Logger.getLogger(iserviceoffre.class.getName()).log(Level.SEVERE, null, ex);
        }       }

   
    @Override
    public void Updateservice(service s) throws SQLException {
           /* Statement stm=cnx.createStatement();
       
        String query="UPDATE service SET value= '"+s.getIdService()+" ,"+s.getTypeser()+","+s.getDescriptionSer()+","+s.getImageService()+"')"
                    +"'WHERE IdService='"+s.getIdService()+"'";
      
        
        
        stm.executeUpdate(query); */  
    
         String req_mod = "update service set  Typeser = ? , DescriptionSer = ? , ImageService = ?  where IdService = ?";
        try {
             pst = cnx.prepareStatement(req_mod);
            pst.setString(1, s.getTypeser());
            pst.setString(2, s.getDescriptionSer());
            pst.setString(3, s.getImageService());
            pst.setInt(4, s.getIdService());

            
            pst.executeUpdate();
            System.out.println("Produit modifié avec succés!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
           
           
           
    
    }

    
    @Override
    public void Deleteservice(int id) throws SQLException {
 try {
            Statement stm=cnx.createStatement();
       
        String query="DELETE FROM service WHERE  IdService = '"+ id+"'";
      
        stm.executeUpdate(query);
        
        } catch (SQLException ex) {
            Logger.getLogger(serviceoffre.class.getName()).log(Level.SEVERE, null, ex);
        }       }

   
   

   
    
}