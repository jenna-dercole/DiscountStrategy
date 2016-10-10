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
public class NoDiscount implements DiscountStrategy {
    private int discountRate = 0;

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        if (discountRate < 0) {
            System.out.println("Rate must be above 0!");
        } else {
            this.discountRate = discountRate;
        }
    }
    
    public NoDiscount() {
        this.discountRate = 0;
    }
    
    @Override
    public final double getDiscountAmount(double productCost, int qty) {
        return discountRate;
    }
    
}
