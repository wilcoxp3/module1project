/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import java.util.Scanner;

/**
 *
 * @author wilcoxp3
 */
public class InventoryApp {

    private static Scanner sc = new Scanner(System.in);
    private InventoryManager inventoryManager = new InventoryManager();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Welcome to the inventory manager application!");
        String choice = new String();
        while (!choice.equalsIgnoreCase("5")) {
            System.out.print("What would you like to do?\n"
                    + "1 - View a product.\n"
                    + "2 - Add a product.\n"
                    + "3 - Update product information.\n"
                    + "4 - Delete a product.\n"
                    + "5 - Exit the applicaton.");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                viewProductInfo();
            } else if (choice.equalsIgnoreCase("2")) {
                addNewProduct();
            } else if (choice.equalsIgnoreCase("3")) {
                updateProductInfo();
            } else if (choice.equalsIgnoreCase("4")) {
                deleteProduct();
            } else if (choice.equalsIgnoreCase("5")) {
                System.out.println("Thank you for using the inventory manger "
                        + "application!");
            } else {
                System.out.println("Sorry, that is not a valid option.");
            }
        }
    }

    public static void viewProductInfo() {
        System.out.println("Enter product UPC to view details: ");
        
    }

    public static void addNewProduct() {
        System.out.println("addNewProduct");
    }

    public static void updateProductInfo() {
        System.out.println("updateProductInfo");
    }

    public static void deleteProduct() {
        System.out.println("deleteProduct");
    }

}
