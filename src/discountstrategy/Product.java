/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author Jenna
 */
public class Product {
    private String productId;
    private String name;
    private double unitCost;
    private DiscountStrategy discount;

    public Product(String productId, String name, double unitCost, DiscountStrategy discount) {
        setProductId(productId);
        setName(name);
        setUnitCost(unitCost);
        setDiscount(discount);
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        this.productId = productId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }
    
    public final double getDiscountAmount(int qty) {
        return discount.getDiscountAmount(unitCost, qty);
    }

    public final void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }

}
