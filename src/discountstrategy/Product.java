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
        if (productId.length() > 30 || productId == null || productId.startsWith("-")) {
            throw new IllegalArgumentException("Invalid value for productId!");
        }
        this.productId = productId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name.length() > 75 || name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name must not be empty and be less than 75 characters!");
        }
        this.name = name;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        if (unitCost < 0) {
            throw new IllegalArgumentException("Unit cost cannot be less than 0!");
        }
        this.unitCost = unitCost;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }
    
    public final double getDiscountAmount(int qty) {
        return discount.getDiscountAmount(unitCost, qty);
    }

    public final void setDiscount(DiscountStrategy discount) {
        if (discount == null) {
            throw new IllegalArgumentException("Discount cannot be null!");
        }
        this.discount = discount;
    }

}
