package lv.javaguru.java2.ui;

import lv.javaguru.java2.businesslogic.RemoveProductResponse;
import lv.javaguru.java2.businesslogic.RemoveProductService;

import java.util.Scanner;

public class RemoveProductView implements View {

    private RemoveProductService removeProductService;

    public RemoveProductView(RemoveProductService removeProductService) {
        this.removeProductService = removeProductService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove product from list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        final String title = sc.nextLine();

        // BL
        RemoveProductResponse response = removeProductService.removeByTitle(title);
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
