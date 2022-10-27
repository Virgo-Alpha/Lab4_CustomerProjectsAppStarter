
package controllers;

import helpers.InputHelper;
import model.Customer;
import repositories.CustomerRepositoryImpl;
import repositories.CustomerRepositoryInterface;

/**
 *
 * @author benson
 */
public class CustomerController {
    
    CustomerRepositoryInterface customerRepository;
    
    private InputHelper inputHelper;

    public CustomerController() {
        this.inputHelper = new InputHelper();
        this.customerRepository = new CustomerRepositoryImpl();
    }

    
    public void run() {

        char LoadCustomers = inputHelper.readCharacter("Type Y to load Customers, N to continue", "Y, N");
        
        if(LoadCustomers == 'Y') {
            String filename = inputHelper.readString("Enter Filename to retrieve Customers: ");
            
            customerRepository.loadFromFile(filename);
        }
        
        char Option = inputHelper.readCharacter("Choose an option: ", "A, B, C, F");
        
        switch (Option) {
            case 'A':
                addCustomer();
                break;
            case 'B':
                deleteCustomer();
                break;
            case 'C':
                displayAllCustomers();
                break;
            case 'F':
                
                String myFile = inputHelper.readString("Enter Filename: ");
                
                customerRepository.saveToFile(myFile);
                break;
            default:
                break;
        }
    }
    
    private void addCustomer() {
        
        String id = inputHelper.readString("Enter your ID: ");
        String name = inputHelper.readString("Enter your name: ");
        int age = inputHelper.readInt("Enter your age: ");
        
        Customer customer = new Customer(id, name, age);
        
        customerRepository.insert(customer);
    }
    
    private void deleteCustomer() {
        
        String customerId = inputHelper.readString("Enter the customer ID: ");
        
        customerRepository.delete(customerId);
    }
    
    private void displayAllCustomers() {
        customerRepository.findAll();
    }

}
