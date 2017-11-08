package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.api.ProductListResponse;
import lv.javaguru.java2.businesslogic.ProductListService;
import lv.javaguru.java2.database.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ProductListServiceImpl implements ProductListService {

    @Autowired private ProductDAO productDAO;

    @Override
    public ProductListResponse getProducts() {
        return new ProductListResponse(productDAO.getAll());
    }

}
