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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        return null;
    }

    public void addProduct(Product p) {

    }

    public void updateProduct(Product p) {

        try {
        CollectionFileStorageUtility.save(getProductList(), Product.class);
        } catch (IOException e) {
            //TODO print error message here
        }
    }

    public void removeProduct(String upc) {

    }

}
