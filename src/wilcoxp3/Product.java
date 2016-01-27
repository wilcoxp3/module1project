/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wilcoxp3;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author wilcoxp3
 */
public class Product implements Comparable<Product>, Serializable {

    private String upc;
    private String shortDetails;
    private String longDetails;
    private BigDecimal price;
    private Integer stock;

    /**
     * @return the upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     * @param upc the upc to set
     */
    public void setUpc(String upc) {
        this.upc = upc;
    }

    /**
     * @return the shortDetails
     */
    public String getShortDetails() {
        return shortDetails;
    }

    /**
     * @param shortDetails the shortDetails to set
     */
    public void setShortDetails(String shortDetails) {
        this.shortDetails = shortDetails;
    }

    /**
     * @return the longDetails
     */
    public String getLongDetails() {
        return longDetails;
    }

    /**
     * @param longDetails the longDetails to set
     */
    public void setLongDetails(String longDetails) {
        this.longDetails = longDetails;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @param p
     * @return int the comparison of the two product's upcs
     */
    @Override
    public int compareTo(Product p) {
        return this.getUpc().compareTo(p.getUpc());
    }
}
