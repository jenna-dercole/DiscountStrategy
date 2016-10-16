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
public class Receipt {
    private static int receiptID;
    private Customer customer;
    private DataStore db;
    private LineItem[] lineItems;
    public final static String RECEIPT_ID = "RECEIPT_ID: ";
    public final static String PROD_ID = "PROD_ID";
    public final static String PROD_NAME = "PROD_NAME";
    public final static String UNIT_COST = "UNIT_COST";
    public final static String QTY = "QTY";
    public final static String SUBTOTAL = "SUBTOTAL";
    public final static String DISCOUNT_AMT = "DISCOUNT_AMT";
    public final static String GRAND_TOTAL = "GRAND TOTAL";
    public final static String TOTAL_SAVED = "TOTAL_SAVED";
    public final static String END_MESSAGE = "THANK YOU FOR SHOPPING AT KOHL'S!";
    

    public static final int getReceiptID() {
        return receiptID;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public final DataStore getDb() {
        return db;
    }

    public final void setDb(DataStore db) {
        this.db = db;
    }

    public final LineItem[] getLineItem() {
        return lineItems;
    }

    public final void setLineItem(LineItem[] lineItem) {
        this.lineItems = lineItem;
    }

    public Receipt(String customerId, DataStore db){
        customer = db.findCustomerById(customerId);
        this.db = db;
        lineItems = new LineItem[0];
        receiptID++;
    }
    
    
    public final void addItemToReceipt(String productId, int qty) {
        LineItem item = new LineItem(productId, qty, db);
        addItemToArray(lineItems, item);
    }

    public final void addItemToArray(LineItem[] array, LineItem item) {
        LineItem[] temp = new LineItem[array.length + 1];
        System.arraycopy(array, 0, temp, 0, array.length);
        temp[temp.length - 1] = item;
        array = temp;
        lineItems = array;
    }
    
    public final double getDiscountTotal() {
        double discountTotal = 0;
        for (LineItem li: lineItems) {
            discountTotal += li.getDiscountedTotal();
        }
            return discountTotal;
        }
    
    public final double getGrandTotal() {
        double grandTotal = 0;
        for (LineItem li: lineItems) {
            grandTotal += li.getSubtotal();
        }
        return grandTotal - getDiscountTotal();
    }
        
    }
    


