package br.imobox.com.imobox.model;

/**
 * Created by matheuscatossi on 15/11/17.
 */

public class Propertie {

    private String name;
    private String image;

    public Propertie(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
