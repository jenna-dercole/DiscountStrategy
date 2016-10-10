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
public class VolumeDiscount implements DiscountStrategy {
    private double percentValue = .10;
    private int qtyThreshold = 2;
    
    public VolumeDiscount(double percentValue, int qtyThreshold) {
        setPercentValue(percentValue);
        setQtyThreshold(qtyThreshold);
    }
    
    @Override
    public final double getDiscountAmount(double productCost, int qty) {
        double discountAmt = 0;
        
        if (qty >= qtyThreshold) {
            discountAmt = productCost * qty * percentValue;
        }
        
        return discountAmt;
    }

    public final double getPercentValue() {
        return percentValue;
    }

    public final void setPercentValue(double percentValue) {
        this.percentValue = percentValue;
    }

    public final int getQtyThreshold() {
        return qtyThreshold;
    }

    public final void setQtyThreshold(int qtyThreshold) {
        this.qtyThreshold = qtyThreshold;
    }
    
    
    public static void main(String[] args) {
        DiscountStrategy ds = new VolumeDiscount(.2,3);
        double amt = ds.getDiscountAmount(100, 2);
        if(amt == 0) {
            System.out.println("test passed");
        } else {
            System.out.println("amt is incorrect, got " + amt + ", expected 0");
        }
    }
}
