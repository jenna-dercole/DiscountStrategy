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
public class StartUp {

   
    public static void main(String[] args) {
        DataStore db = new InMemoryDatabase();
        Register register = new Register();
        
        //Sale #1:
        register.startNewSale("C100", db);
        register.addItemToSale("D457", 5);
        register.addItemToSale("A101", 2);
        register.endSale();
        
        //Sale #2:
        register.startNewSale("B411", db);
        register.addItemToSale("D457", 3);
        register.addItemToSale("A202", 1);
        register.addItemToSale("E412", 2);
        register.endSale();
    }
    
}
