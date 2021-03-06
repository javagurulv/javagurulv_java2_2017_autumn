package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.RemoveProductService;
import lv.javaguru.java2.businesslogic.api.RemoveProductRequest;
import lv.javaguru.java2.businesslogic.api.RemoveProductResponse;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class RemoveProductServiceImpl implements RemoveProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public RemoveProductResponse removeByTitle(RemoveProductRequest request) {
        Optional<Product> productOpt = productDAO.getByTitle(request.getTitle());
        if(productOpt.isPresent()) {
            Product product = productOpt.get();
            productDAO.delete(product);
            return new RemoveProductResponse(true);
        } else {
            return new RemoveProductResponse(false);
        }
    }

}
