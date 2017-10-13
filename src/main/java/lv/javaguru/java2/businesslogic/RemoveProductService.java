package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.businesslogic.api.RemoveProductRequest;
import lv.javaguru.java2.businesslogic.api.RemoveProductResponse;

public interface RemoveProductService {

    RemoveProductResponse removeByTitle(RemoveProductRequest request);

}
