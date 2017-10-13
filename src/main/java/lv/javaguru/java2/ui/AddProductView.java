package lv.javaguru.java2.ui;

import lv.javaguru.java2.businesslogic.api.AddProductRequest;
import lv.javaguru.java2.businesslogic.AddProductService;

import java.util.Scanner;

public class AddProductView implements View {

    private AddProductService addProductService;

    public AddProductView(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Add product to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product title:");
        String title = sc.nextLine();
        System.out.print("Enter product description:");
        String description = sc.nextLine();

        /////// Business Logic
        addProductService.addProduct(new AddProductRequest(title, description));
        /////// End of Business Logic

        System.out.println("Add product to list execution end!");
        System.out.println();
    }

}
