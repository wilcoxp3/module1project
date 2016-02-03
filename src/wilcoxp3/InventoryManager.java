/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import edu.lcc.citp.utility.CollectionFileStorageUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilcoxp3
 */
public class InventoryManager {

    public List<Product> getProductList() {

        List<Product> myProductList = new ArrayList<>();
        try {
            myProductList.addAll(CollectionFileStorageUtility.load(Product.class));
        } catch (IOException | ClassNotFoundException e) {
            //TODO print error message here
        }
        return myProductList;
    }

    public Product getProduct(String upc) {

        List<Product> myProductList = getProductList();

        for (Product p : myProductList) {
            if (upc.equalsIgnoreCase(p.getUpc())) {
                return p;
            }
        }

        return null;
    }

    public void addProduct(Product p) {

        List<Product> myProductList = getProductList();
        if (myProductList.contains(p)) {
            System.out.println("Product is already in database.");
        } else {
            myProductList.add(p);
            try {
                CollectionFileStorageUtility.save(myProductList, Product.class);
            } catch (IOException e) {
                //TODO print error message here
            }
        }
    }

    public void updateProduct(Product p) {

        List<Product> myProductList = getProductList();
        for (Product product: myProductList) {
            if (product.getUpc().equalsIgnoreCase(p.getUpc())) {
                product.setShortDetails(p.getShortDetails());
                product.setLongDetails(p.getLongDetails());
                product.setPrice(p.getPrice());
                product.setStock(p.getStock());
            } else {
                System.out.println("Product not found.");
            }
        }
        try {
            CollectionFileStorageUtility.save(getProductList(), Product.class);
        } catch (IOException e) {
            //TODO print error message here
        }
    }

    public void removeProduct(String upc) {
        
        List<Product> myProductList = getProductList();
        for (Product p: myProductList) {
            if (p.getUpc().equals(upc)) {
                myProductList.remove(p);
            } else {
                System.out.println("Product not found.");
            }
        }
        
        try {
            CollectionFileStorageUtility.save(myProductList, Product.class);
        } catch (IOException e) {
            //TODO print error message here
        }
    }

}
