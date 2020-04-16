/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entity.Albums;
import entity.Artists;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import util.PersistenceUtil;

/**
 *
 * @author vadam
 */
public class AlbumRepository {
    public void create(Albums album)
    {
        EntityManager em=PersistenceUtil.getFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();        
}
    public Albums findById(int id)
    {
        EntityManager em=PersistenceUtil.getFactory().createEntityManager();
        Albums album= (Albums) em.createNamedQuery("Albums.findById").setParameter("id", id);
        return album;
    }
    public ArrayList<Albums> findByName(String nume)
    {
        EntityManager em=PersistenceUtil.getFactory().createEntityManager();
        ArrayList<Albums> albums=new ArrayList<Albums>();
        albums=(ArrayList<Albums>)em.createNamedQuery("Albums.findByName").setParameter("NAME", nume).getResultList();
        return albums;
    }
    
    public ArrayList<Albums> findByArtist(int id)
    {
        EntityManager em=PersistenceUtil.getFactory().createEntityManager();
        ArrayList<Albums> albums=new ArrayList<Albums>();
        albums=(ArrayList<Albums>)em.createNamedQuery("Albums.findByArtist").setParameter("artistId", id);
        return albums;
    }
}