package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    Product save(Product product);

    Optional<Product> getById(Long id);

    Optional<Product> getByTitle(String title);

    void delete(Product product);

    List<Product> getAll();

}
