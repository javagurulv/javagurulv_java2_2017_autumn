package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.database.Database;

public class RemoveProductServiceImpl implements RemoveProductService {

    private Database database;

    public RemoveProductServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public RemoveProductResponse removeByTitle(String title) {
        boolean removed = database.removeProductByTitle(title);
        return new RemoveProductResponse(removed);
    }

}
