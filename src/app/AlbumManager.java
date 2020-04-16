/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import entity.Artists;
import java.math.BigDecimal;
import repo.ArtistRepository;

/**
 *
 * @author vadam
 */
public class AlbumManager {
    
    public static void main(String [] args)
    {
        ArtistRepository artisti=new ArtistRepository();
        Artists Cineva=new Artists();
        Cineva.setCountry("Moldova");
        Cineva.setId(BigDecimal.valueOf(15));
        Cineva.setName("Cineva");
        artisti.create(Cineva);
        
    }
}
