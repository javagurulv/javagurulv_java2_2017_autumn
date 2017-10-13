package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.api.ProductListResponse;
import lv.javaguru.java2.businesslogic.ProductListService;
import lv.javaguru.java2.database.Database;

public class ProductListServiceImpl implements ProductListService {

    private Database database;

    public ProductListServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public ProductListResponse getProducts() {
        return new ProductListResponse(database.getAllProducts());
    }

}
