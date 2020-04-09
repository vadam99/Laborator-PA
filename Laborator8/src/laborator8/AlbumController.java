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
public class AlbumController implements AlbumControllerDao {

    @Override
    public void create(int id, String name, int artistId, int releaseYear) {
        Connection con = Database.getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO albums (id,name,artist_id,release_year) values(?,?,?,?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, artistId);
            pstmt.setInt(4, releaseYear);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlbumController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Override
    public void findByArtist(int artistId) {
        Connection con = Database.getConnection();
        try {
            Statement stmt = con.createStatement();
            String sql = "SELECT name from albums where artist_id='" +artistId+ "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String nume = rs.getString("name");
                System.out.println(nume+ "\n");
            }
            System.out.println();
        } catch (SQLException ex) {
            Logger.getLogger(AlbumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
