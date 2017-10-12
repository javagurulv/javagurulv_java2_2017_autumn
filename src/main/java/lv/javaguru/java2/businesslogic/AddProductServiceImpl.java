package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Product;

public class AddProductServiceImpl implements AddProductService {

    private Database database;

    public AddProductServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addProduct(String title, String description) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        database.saveProduct(product);
    }

}
