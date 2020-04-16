/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborator8;



/**
 *
 * @author vadam
 */
public interface ArtistControllerDao {
    public void create(String name, String country, int id);
    public void findByName(String name);
}
