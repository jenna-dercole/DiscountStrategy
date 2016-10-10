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
public interface DataStore {
    
    public Customer findCustomerById(String customerID);
    public Product findProductById(String productID);
       
}
