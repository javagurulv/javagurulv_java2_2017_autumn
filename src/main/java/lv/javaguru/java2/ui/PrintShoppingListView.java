package lv.javaguru.java2.ui;

import lv.javaguru.java2.businesslogic.api.ProductListResponse;
import lv.javaguru.java2.businesslogic.ProductListService;
import lv.javaguru.java2.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintShoppingListView implements View {

    @Autowired
    private ProductListService productListService;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print shopping list to console execution start!");

        /// BL
        ProductListResponse response = productListService.getProducts();
        // End of BL

        for (Product product : response.getProducts()) {
            System.out.println(product.getTitle() + "[" + product.getDescription() + "]");
        }

        System.out.println("Print shopping list to console execution end!");
        System.out.println();
    }

}
