/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @admin
 */
public class MyDB {
    //Design Patter - Singleton

    public String url = "jdbc:mysql://localhost:3306/";
    public String login = "root";
    public String pwd = "";
    public Connection con;
    public static MyDB instance;

    private MyDB() {

        try {
            con = DriverManager.getConnection(url, login, pwd);
            Statement smt = con.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS upserve";
            smt.executeUpdate(sql);
            System.out.println("Database created or already exists ! ");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/upserve", login, pwd);
            System.out.println(" Connected ! ");
        }
        catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
//        finally {
//            cnx.close();
//        }
    }

    public Connection getConnexion() {
        return con;
    }

    public static MyDB getInstance() {
        if (instance == null) {
            instance = new MyDB();
        }
        return instance;
    }

}
