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
public class PercentOffDiscount implements DiscountStrategy {
    private double percentOff;
    
    public PercentOffDiscount(double percentValue) {
        setPercentOff(percentValue);
    }

    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        if (percentOff < 0) {
           throw new IllegalArgumentException("Percentage cannot be less than 0!");
        } else {
            this.percentOff = percentOff;
        }
    }

    @Override
    public final double getDiscountAmount(double productCost, int qty) {
        return productCost * qty * percentOff;
    }
    
}
