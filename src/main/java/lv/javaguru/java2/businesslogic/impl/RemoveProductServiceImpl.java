package lv.javaguru.java2.businesslogic.impl;

import lv.javaguru.java2.businesslogic.RemoveProductService;
import lv.javaguru.java2.businesslogic.api.RemoveProductRequest;
import lv.javaguru.java2.businesslogic.api.RemoveProductResponse;
import lv.javaguru.java2.database.Database;

public class RemoveProductServiceImpl implements RemoveProductService {

    private Database database;

    public RemoveProductServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public RemoveProductResponse removeByTitle(RemoveProductRequest request) {
        boolean removed = database.removeProductByTitle(request.getTitle());
        return new RemoveProductResponse(removed);
    }

}
