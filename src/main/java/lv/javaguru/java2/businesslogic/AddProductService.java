package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.api.AddProductRequest;
import lv.javaguru.java2.businesslogic.api.AddProductResponse;

public interface AddProductService {

    AddProductResponse addProduct(AddProductRequest request);

}
