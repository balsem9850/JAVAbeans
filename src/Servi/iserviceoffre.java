/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servi;

import Entites.service;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MSI
 */
public interface iserviceoffre {
   public void Addservice(service s) throws SQLException; 
   public List<service> afficherservice() throws SQLException;
   public void Deleteservice(int id) throws SQLException;
   public void Updateservice(service s) throws SQLException;
}

