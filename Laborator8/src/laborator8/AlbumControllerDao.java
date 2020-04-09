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
public interface AlbumControllerDao {
    public void create(int id, String name, int artistId, int releaseYear);
    public void findByArtist(int artistId);
}
