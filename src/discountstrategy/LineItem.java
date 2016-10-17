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
public class LineItem {
    private Product product;
    private int qty;

    public LineItem(String productID, int qty, DataStore db) {
        setProduct(db.findProductById(productID));
        setQty(qty);
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if (product.getName() == null || product.getProductId() == null || product.getDiscount() == null || product.getUnitCost() == 0) {
            throw new IllegalArgumentException("These fields cannot be set to null!");
        }
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        if (qty < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative!");
        }
        this.qty = qty;
    }
    
    public final double getSubtotal() {
        return qty * product.getUnitCost();
    }
    
    public final double getDiscountedTotal() {
        return qty * product.getDiscountAmount(qty);
    }
    
}
