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
public class Register {
    private Receipt receipt;

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
    
    public final void endSale(Receipt r) {
        generateReceipt(r);
    }

    public final void addItemToSale(String productId, int qty) {
        receipt.addItemToReceipt(productId, qty);
    }
    
    public final void startNewSale(String customerID, DataStore db) {
        Receipt r = new Receipt(customerID, new InMemoryDatabase());
        Customer customer = db.findCustomerById(customerID);
    }
    
    public String generateReceipt(Receipt r) {
        StringBuilder sb = new StringBuilder();
        LineItem[] li = r.getLineItem();
        sb.append(r.getReceiptID() + "\n");
        sb.append(r.PROD_ID + "\t" + r.PROD_NAME + "\t" + 
                r.UNIT_COST + "\t" + r.QTY + "\t" + "\n");
        sb.append("-----------------------------------------------------------------" + "\n");
        for (LineItem i : li) {
          sb.append(i.getProduct().getProductId() + "\t" + i.getProduct().getName() +
               "\t" + i.getProduct().getUnitCost() + "\t" + i.getQty() + "\n");
        }
        return sb.toString();
    }
   
    public static void main(String[] args) {
        Register r = new Register();
        Receipt r2 = new Receipt("D345", new InMemoryDatabase());
        r.addItemToSale("A101", 1);
        System.out.println(r.generateReceipt(r2));
    }
}
