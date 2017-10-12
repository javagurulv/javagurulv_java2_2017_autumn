package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database {

    private List<Product> products = new ArrayList<>();

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public boolean removeProductByTitle(String title) {
        Optional<Product> foundProduct = products.stream()
                .filter(p -> p.getTitle().equals(title))
                .findFirst();
        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            products.remove(product);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> cloned = new ArrayList<>();
        cloned.addAll(products);
        return cloned;
    }

}
