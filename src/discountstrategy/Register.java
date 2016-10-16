/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author Jenna
 */
public class Register {
    private Receipt receipt;

    public final Receipt getReceipt() {
        return receipt;
    }
    
    public final void endSale(){
        generateReceipt();
    }

    public final void addItemToSale(String productId, int qty) {
        receipt.addItemToReceipt(productId, qty);
    }
    
    public final void startNewSale(String customerID, DataStore db) {
        receipt = new Receipt(customerID, db);
        Customer customer = db.findCustomerById(customerID);
    }
    
    public void generateReceipt() {
        
        System.out.println(receipt.RECEIPT_ID + receipt.getReceiptID() + "\n");
        System.out.println("Hello " + receipt.getCustomer().getFirstName() + " " 
                        + receipt.getCustomer().getLastName());
        System.out.println(receipt.PROD_ID + "\t\t" + receipt.PROD_NAME + "\t" + 
                receipt.UNIT_COST + "\t" +receipt.QTY + "\t\t" + receipt.SUBTOTAL + "\t" + receipt.DISCOUNT_AMT);
        System.out.println("---------------------------------------------------------------------------------------" + "\n");
        
        LineItem[] li = receipt.getLineItem();
        
        for (LineItem i : li) {
            String productID = i.getProduct().getProductId();
            String productName = i.getProduct().getName();
            double unitCost = i.getProduct().getUnitCost();
            int qty = i.getQty();
            System.out.println(productID + "\t" + productName + 
                    "\t" + unitCost + "\t\t" + qty + "\t\t" + "$" + new DecimalFormat("#.##").format(i.getSubtotal()) +
                    "\t\t" + "$" + new DecimalFormat("#.##").format(i.getDiscountedTotal())); 
        }
        
        System.out.println(receipt.TOTAL_SAVED + ": $" + new DecimalFormat("#.##").format(receipt.getDiscountTotal()));
        System.out.println(receipt.GRAND_TOTAL + ": $" + new DecimalFormat("#.##").format(receipt.getGrandTotal())); 
        System.out.println(receipt.END_MESSAGE);
        System.out.println("\n");
   
    }
    
   
    
}
