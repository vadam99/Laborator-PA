/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vadam
 */
public class ArtistController implements ArtistControllerDao {

    @Override
    public void create(String name, String country, int id) {
        Connection con = Database.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO artists (name,country,id) values(?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, country);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        }      
}

    @Override
    public void findByName(String name) {
        Connection con = Database.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT id,name,country from artists where name='" + name + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int nr = rs.getInt("id");
                String nume=rs.getString("name");
                String tara=rs.getString("country");
                System.out.println(nr + ", "+ nume+ "," + tara+ "\n");
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(ArtistController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
