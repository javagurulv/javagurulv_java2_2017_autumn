package lv.javaguru.java2;

import lv.javaguru.java2.ui.AddProductView;
import lv.javaguru.java2.businesslogic.AddProductService;
import lv.javaguru.java2.businesslogic.impl.AddProductServiceImpl;
import lv.javaguru.java2.ui.View;
import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.database.InMemoryDatabase;
import lv.javaguru.java2.ui.PrintShoppingListView;
import lv.javaguru.java2.businesslogic.ProductListService;
import lv.javaguru.java2.businesslogic.impl.ProductListServiceImpl;
import lv.javaguru.java2.ui.RemoveProductView;
import lv.javaguru.java2.businesslogic.RemoveProductService;
import lv.javaguru.java2.businesslogic.impl.RemoveProductServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add product to list
        // 2. Remove product from list
        // 3. Print shopping list to console
        // 4. Exit

        Database database = new InMemoryDatabase();

        AddProductService addProductService = new AddProductServiceImpl(database);
        RemoveProductService removeProductService = new RemoveProductServiceImpl(database);
        ProductListService productListService = new ProductListServiceImpl(database);

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, new AddProductView(addProductService));
        commands.put(2, new RemoveProductView(removeProductService));
        commands.put(3, new PrintShoppingListView(productListService));

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            }

            View view = commands.get(menuItem);
            view.execute();
        }

    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add product to list");
        System.out.println("2. Remove product from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

}
