/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vadam
 */
public class Catalog implements Serializable {

    private String name;
    private String path;
    private List<Document> documente = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public List<Document> getDocumente() {
        return documente;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDocumente(List<Document> documente) {
        this.documente = documente;
    }

    public Document findById(String id) {
        for (Document doc : documente) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }

    public void add(Document doc) {
        documente.add(doc);
    }

    @Override
    public String toString() {
        return "Catalog{" + "name=" + name + ", path=" + path + ", documente=" + documente + '}';
    }
}
