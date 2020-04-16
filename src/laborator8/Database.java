/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;

import java.beans.Statement;
import java.sql.*;

/**
 *
 * @author vadam
 */
//cod reutilizat din tema 1 de la SGBD, adaptat pentru singleton
public class Database {

    private static Database dbIsntance;
    private static Connection con;
    private static Statement stmt;

    private Database() {

    }

    public static Database getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new Database();
        }
        return dbIsntance;
    }

    public static Connection getConnection() {
        if(con==null){
        try {
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            String serverName = "DESKTOP-K7BQ2BQ";
            String serverPort = "1521";
            String sid = "XE";
            String url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + ":" + sid;
            String username = "student";
            String password = "STUDENT";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Succesfully connected to the database!");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the database driver " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Could not connect to the database " + e.getMessage());
        }
        }
        return con;
    }
    public static void closeConnection() throws SQLException
    {
        if(con!=null)
            con.close();
    }
}
