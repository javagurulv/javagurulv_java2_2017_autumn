package lv.javaguru.java2.ui;

import lv.javaguru.java2.businesslogic.api.RemoveProductRequest;
import lv.javaguru.java2.businesslogic.api.RemoveProductResponse;
import lv.javaguru.java2.businesslogic.RemoveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveProductView implements View {

    @Autowired
    private RemoveProductService removeProductService;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove product from list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        final String title = sc.nextLine();

        // BL
        RemoveProductResponse response = removeProductService.removeByTitle(new RemoveProductRequest(title));
        // End of BL

        if (response.isRemoved()) {
            System.out.println("Product with title " + title + " was found and will be removed from list!");
        } else {
            System.out.println("Product with title " + title + " not found and not be removed from list!");
        }
        System.out.println("Remove product from list execution end!");
        System.out.println();
    }
}
