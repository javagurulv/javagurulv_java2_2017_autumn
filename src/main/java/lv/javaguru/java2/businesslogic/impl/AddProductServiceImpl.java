package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.AddProductService;
import lv.javaguru.java2.businesslogic.api.AddProductRequest;
import lv.javaguru.java2.businesslogic.api.AddProductResponse;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Product;

public class AddProductServiceImpl implements AddProductService {

    private Database database;

    public AddProductServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest request) {
        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        database.saveProduct(product);
        return new AddProductResponse(true);
    }

}
