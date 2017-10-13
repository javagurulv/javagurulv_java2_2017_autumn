package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.api.ProductListResponse;
import lv.javaguru.java2.businesslogic.ProductListService;
import lv.javaguru.java2.database.ProductDAO;

public class ProductListServiceImpl implements ProductListService {

    private ProductDAO productDAO;

    public ProductListServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductListResponse getProducts() {
        return new ProductListResponse(productDAO.getAll());
    }

}
