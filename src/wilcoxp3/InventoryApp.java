package wilcoxp3;

/*
 * Paul Wilcox 
 * Module 1 Project 
 * This application allows the user to manage an
 * inventory of products. The user may add view a product's information, add a
 * new product to the inventory, update information for an existing product, or
 * delete a product from the inventory.
 */
import java.util.Scanner;

/**
 *
 * The InventoryApp class contains the main method for Inventory Manager
 * Application. It contains the user interface through which the user may view,
 * add, update, or delete product information.
 *
 * @author wilcoxp3
 */
public class InventoryApp {

    private static final Scanner sc = new Scanner(System.in);
    private static final InventoryManager inventoryManager = new InventoryManager();

    /**
     *
     * The main method for the Inventory Manager Application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Welcome to the Inventory Manager Application!");
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

    /**
     * This method allows the user to view information for an existing product
     * by entering the product's UPC.
     */
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

    /**
     * This method allows the user to add a new product to the inventory.
     */
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

    /**
     * This method allows the user to update the information of an existing
     * product.
     */
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

    /**
     * This method allows the user to delete a product from the inventory.
     */
    public static void deleteProduct() {
        System.out.print("Enter the UPC of the product to delete.");
        inventoryManager.removeProduct(sc.nextLine().trim());
    }

}
