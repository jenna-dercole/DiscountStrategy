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
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        this.qty = qty;
    }
    
    public final double getSubtotal(int qty, Product p) {
        return qty * p.getUnitCost();
    }
    
    public final double getDiscountedTotal() {
        return qty * product.getDiscountAmount(qty);
    }
    
}