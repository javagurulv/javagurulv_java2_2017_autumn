package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.AddProductService;
import lv.javaguru.java2.businesslogic.ValidationError;
import lv.javaguru.java2.businesslogic.api.AddProductRequest;
import lv.javaguru.java2.businesslogic.api.AddProductResponse;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
class AddProductServiceImpl implements AddProductService {

    @Autowired private ProductDAO productDAO;
    @Autowired private ProductValidator productValidator;

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public AddProductResponse addProduct(AddProductRequest request) {

        Optional<ValidationError> errorOpt = productValidator.validate(
                request.getTitle(), request.getDescription()
        );
        if (errorOpt.isPresent()) {
            ValidationError error = errorOpt.get();
            return new AddProductResponse(false, error.getField(), error.getDescription());
        }

        Product product = new Product();
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        productDAO.save(product);
        return new AddProductResponse(true);
    }

}
