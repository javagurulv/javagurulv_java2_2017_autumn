package lv.javaguru.java2.businesslogic.api;

import lv.javaguru.java2.domain.Product;

import java.util.List;

public class ProductListResponse {

    private List<Product> products;

    public ProductListResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
