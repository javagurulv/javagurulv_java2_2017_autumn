package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Product;

import java.util.List;

public interface Database {

    void saveProduct(Product product);

    boolean removeProductByTitle(String title);

    List<Product> getAllProducts();

}
