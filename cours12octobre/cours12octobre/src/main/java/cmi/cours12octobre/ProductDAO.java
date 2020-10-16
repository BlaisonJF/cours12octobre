package fr.2i.Cours12octobre.web.controller;
import java.util.list

public interface ProductDao {

    public List<Product> findAll();
    public Product findById(int code);
    public product save(Product product);
}