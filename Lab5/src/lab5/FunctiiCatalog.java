/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author vadam
 */
public class FunctiiCatalog {

    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        try (var oos = new ObjectInputStream(
                new FileInputStream(path))) {
            return (Catalog) oos.readObject();
        }   
    }

    public static void view(Document doc) throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        String primeleCaractere = "";
        String input = doc.getLocation();
        if (input.length() > 4) {
            primeleCaractere = input.substring(0, 4);
        }
        /* verificam daca e link sau locatie fisier*/
        if ("http".equals(primeleCaractere)) {
            desktop.browse(new URI(input));
        } else {
            desktop.open(new File(input));
        }
    }
}
