/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerprojects;

//import daos.CustomerDAOInterface;

import controllers.CustomerController;



//import daos.CustomerDAOTextFileImpl;
//import helpers.InputHelper;
//import java.util.List;
//import model.Customer;


public class CustomerProjectsApp {

    public static void main(String[] args) {
        
        CustomerController customerController = new CustomerController();
        
        customerController.run();

    }
}
