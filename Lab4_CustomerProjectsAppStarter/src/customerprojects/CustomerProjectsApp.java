/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerprojects;

import daos.CustomerDAOInterface;
import daos.CustomerDAOTextFileImpl;
import java.util.List;
import model.Customer;

/**
 *
 * @author mga
 */
public class CustomerProjectsApp {

    public static void main(String[] args) {
        CustomerDAOInterface customerDAO = new CustomerDAOTextFileImpl();
//        List<Customer>customers = new ArrayList<>();
//                
//        customers.add(new Customer("C1", "Yoven", 29));
//        customers.add(new Customer("C2", "Yovin", 40));
//        customers.add(new Customer("C3", "Benson", 24));

          
        
        List <Customer> customers = customerDAO.loadFromFile("customers.txt");
        
        System.out.println(customers);

    }
}
