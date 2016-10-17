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
        if (lastName == null || lastName.equals("")) {
            throw new IllegalArgumentException("Last name cannot be empty!");
        } else if (lastName.length() > 50) {
            throw new IllegalArgumentException("Last name cannot be greater than 50 characters!");
        } else if (lastName.trim().equals("")) {
            throw new IllegalArgumentException("Last name cannot be all spaces!");
        } else if (lastName.indexOf(" ") == 0) {
            throw new IllegalArgumentException("Last name cannot start with a space!");
        } else if (lastName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Last name cannot contain a number!");
        }
        this.lastName = lastName;
    }

    public final void setFirstName(String firstName) {
        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException("Last name cannot be empty!");
        } else if (firstName.length() > 50) {
            throw new IllegalArgumentException("Last name cannot be greater than 50 characters!");
        } else if (firstName.trim().equals("")) {
            throw new IllegalArgumentException("Last name cannot be all spaces!");
        } else if (firstName.indexOf(" ") == 0) {
            throw new IllegalArgumentException("Last name cannot start with a space!");
        } else if (firstName.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Last name cannot contain a number!");
        }
        this.firstName = firstName;
    }

    public final void setCustomerID(String customerID) {
        if (customerID.length() == 0 ) {
            throw new IllegalArgumentException("CustomerID cannot be empty!");
        } else if (customerID.startsWith("-")) {
            throw new IllegalArgumentException("CustomerID cannot be negative!");
        }
        this.customerID = customerID;
    }

    public Customer(String lastName, String firstName, String customerID) {
        setLastName(lastName);
        setFirstName(firstName);
        setCustomerID(customerID);
    }
       
}
