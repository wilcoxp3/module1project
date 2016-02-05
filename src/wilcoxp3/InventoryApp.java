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
    private static InventoryManager inventoryManager = new InventoryManager();

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
        String upc = sc.nextLine().trim();
        Product product = inventoryManager.getProduct(upc);
        if (product != null) {
            System.out.print("UPC: " + product.getUpc() + "\n"
                    + "Short Details: " + product.getShortDetails() + "\n"
                    + "Long Details: " + product.getLongDetails() + "\n"
                    + "Price: " + product.getPrice() + "\n"
                    + "Quantity in stock: " + product.getStock() + "\n");
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void addNewProduct() {

        Product product = new Product();

        System.out.print("Enter information about a new product below.\n"
                + "Enter new product UPC: ");
        product.setUpc(sc.nextLine().trim());
        System.out.println("Enter new product short details: ");
        product.setShortDetails(sc.nextLine());
        System.out.println("Enter new product long details: ");
        product.setLongDetails(sc.nextLine());
        System.out.println("Enter new product price: ");
        product.setPrice(sc.nextBigDecimal());
        sc.nextLine();
        System.out.println("Enter new product quantity in stock: ");
        product.setStock(sc.nextInt());
        sc.nextLine();

        inventoryManager.addProduct(product);
        System.out.println("New product entered successfully!");
    }

    public static void updateProductInfo() {

        Product product = new Product();
        String upc;
        System.out.print("Enter product information to update below.\n"
                + "Enter the UPC of the product to update: ");
        upc = sc.nextLine().trim();
        if (inventoryManager.getProduct(upc) != null) {
            product.setUpc(upc);
            System.out.println("Enter the updated short details: ");
            product.setShortDetails(sc.nextLine());
            System.out.println("Enter the updated long details: ");
            product.setLongDetails(sc.nextLine());
            System.out.println("Enter the updated price: ");
            product.setPrice(sc.nextBigDecimal());
            sc.nextLine();
            System.out.println("Enter the updated quantity in stock: ");
            product.setStock(sc.nextInt());
            sc.nextLine();

            inventoryManager.updateProduct(product);
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found.");
        }

    }

    public static void deleteProduct() {
        System.out.print("Enter the UPC of the product to delete.");
        inventoryManager.removeProduct(sc.nextLine().trim());
    }

}
