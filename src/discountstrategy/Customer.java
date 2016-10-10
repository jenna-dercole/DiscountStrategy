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
public class Customer {
    private String lastName;
    private String firstName;
    private String customerID;

    public final String getLastName() {
        return lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getCustomerID() {
        return customerID;
    }

    public final void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public final void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public final void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Customer(String lastName, String firstName, String customerID) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.customerID = customerID;
    }
       
}
