package fr.2i.Cours12octobre.web.controller;

import java.io.Serializable;

@JsonIgnoreProperties(value = {"designation","prix"})
public class Product implements Serializable {

    @JsonIgnore // équivalent de @transient
    private int code;
    private String designation;
    private double prix;

    public Product() {
    }

    public Product(int code,String designation, double prix) {
        this.code = code;
        this.designation = designation;
        this.prix;
    }

    public int getCode() {
        return code;
    }

    public String getDesignation(){
        return designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}