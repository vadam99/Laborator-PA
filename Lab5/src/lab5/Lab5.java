/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import com.sun.tools.javac.Main;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author vadam
 */
public class Lab5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, InvalidCatalogException, ClassNotFoundException, URISyntaxException {
        Lab5 app = new Lab5();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog
                = new Catalog("Java Resources", "D:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);
        FunctiiCatalog.save(catalog);
    }

    private void testLoadView() throws IOException, InvalidCatalogException, ClassNotFoundException, URISyntaxException {
        Catalog catalog = FunctiiCatalog.load("d:/java/catalog.ser");
        Document doc = catalog.findById("java1");
        FunctiiCatalog.view(doc);
    }
}
