/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vadam
 */
public class PersistenceUtil {
    
    public static EntityManagerFactory factory;
    private static PersistenceUtil object;
    private PersistenceUtil() {
    }
    
    public static PersistenceUtil getObject()
            {
                if(object==null)
                    object=new PersistenceUtil();
                return object;
            }
    public static EntityManagerFactory getFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        }
        return factory;
    }
}
