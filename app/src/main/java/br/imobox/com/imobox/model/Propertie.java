package br.imobox.com.imobox.model;

/**
 * Created by matheuscatossi on 15/11/17.
 */

public class Propertie {

    private int id;
    private String name;
    private String image;
    private double value;
    private boolean check;

    public Propertie(int id, String name, String image, double value) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Propertie(int id, String name, String image, double value, boolean check) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.check = check;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
