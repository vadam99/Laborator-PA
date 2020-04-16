/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entity.Artists;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.PersistenceUtil;

/**
 *
 * @author vadam
 */
public class ArtistRepository {

    public void create(Artists artist) {
        EntityManager em = PersistenceUtil.getFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
        PersistenceUtil.factory.close();
    }
    public Artists findById(BigDecimal id)
    {
        EntityManager em=PersistenceUtil.getFactory().createEntityManager();
        Artists artist= (Artists) em.createNamedQuery("Artists.findById").setParameter("id", id).getSingleResult();
        return artist;
    }
    public ArrayList<Artists> findByName(String nume)
    {
        EntityManager em=PersistenceUtil.getFactory().createEntityManager();
        ArrayList<Artists> artists;
      //  artists = new ArrayList<>();
        artists=(ArrayList<Artists>)em.createNamedQuery("Artists.findByname").setParameter("NAME", nume).getResultList();
        return artists;
    }
}
