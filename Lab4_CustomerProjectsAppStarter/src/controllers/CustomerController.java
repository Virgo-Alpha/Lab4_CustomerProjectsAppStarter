package controllers;

import helpers.InputHelper;
import java.util.List;
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

        if (LoadCustomers == 'Y') {
            String filename = inputHelper.readString("Enter Filename to retrieve Customers: ");

            customerRepository.loadFromFile(filename);
        }

        boolean canContinue = true;

        while (canContinue) {
            
            System.out.print("Choose an option: \n");
            System.out.print("A - Add New Customer \n");
            System.out.print("B - Remove Customer \n");
            System.out.print("C - Display All Customers \n");
            System.out.print("F - Finish \n");
            char option = inputHelper.readCharacter("Choose an option: ", "A, B, C, F");

            switch (option) {
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

                    canContinue = false;
                    break;

            }

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

        if (customerRepository.delete(customerId)) {
            System.out.println(customerId + " successfully deleted");
        } else {
            System.out.println(customerId + " could not be found");
        }
    }

    private void displayAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        for (Customer c : customers) {
            System.out.println(c);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
