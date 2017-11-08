package lv.javaguru.java2;

import lv.javaguru.java2.configs.SpringAppConfig;
import lv.javaguru.java2.ui.AddProductView;
import lv.javaguru.java2.ui.PrintShoppingListView;
import lv.javaguru.java2.ui.RemoveProductView;
import lv.javaguru.java2.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingListApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, applicationContext.getBean(AddProductView.class));
        commands.put(2, applicationContext.getBean(RemoveProductView.class));
        commands.put(3, applicationContext.getBean(PrintShoppingListView.class));

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
