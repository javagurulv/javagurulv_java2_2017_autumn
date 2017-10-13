package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.AddProductService;
import lv.javaguru.java2.businesslogic.api.AddProductRequest;
import lv.javaguru.java2.businesslogic.api.AddProductResponse;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;

public class AddProductServiceImpl implements AddProductService {

    private ProductDAO productDAO;

    public AddProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest request) {
        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        productDAO.save(product);
        return new AddProductResponse(true);
    }

}
