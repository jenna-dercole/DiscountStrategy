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
public class InMemoryDatabase implements DataStore {
    private Customer[] customers = {
        new Customer("Smith", "John", "C100"),
        new Customer("Jones", "Dan", "D345"),
        new Customer("Severson", "Jolene", "E456"), 
        new Customer("Dercole", "Jenna", "B411")
    };
    
    private Product[] products = {
        new Product("A101", "Raspberry Hand Lotion", 15.99, new NoDiscount()),
        new Product("A202", "Girl's Tennis Shoes", 24.99, new PercentOffDiscount(.15)),
        new Product("D457", "Men's Reading Glasses", 18.99, new NoDiscount()),
        new Product("E412", "Basketball", 31.99, new PercentOffDiscount(.10)),
        new Product("P692", "Women's Bathrobe", 59.99, new PercentOffDiscount(.10)),
        new Product("B488", "Fleece Slippers", 17.99, new VolumeDiscount(.1, 3))
    };
    
    @Override
    public final Customer findCustomerById(String customerID) {
        Customer customer = null;
        for (Customer c : customers) {
            if(customerID.equals(c.getCustomerID())) {
                customer = c;
                break;
            };
        }
        return customer;
    }
    
    @Override
    public final Product findProductById(String productID) {
        Product product = null;
        for (Product p : products) {
            if(productID.equals(p.getProductId())) {
                product = p;
                break;
            };
        }
        return product;
    }

}


