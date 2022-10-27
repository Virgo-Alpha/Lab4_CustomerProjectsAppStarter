
package repositories;

import daos.CustomerDAOInterface;
import daos.CustomerDAOTextFileImpl;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerRepositoryImpl implements CustomerRepositoryInterface {
    
    private List<Customer> customers;
    private CustomerDAOInterface customerDAO;
    
    public CustomerRepositoryImpl(){
        this.customers = new ArrayList<>();
        this.customerDAO = new CustomerDAOTextFileImpl();
    }
    
    public CustomerRepositoryImpl(String filename){
        this();
        
        //TODO: load existing customers from a file (on the hard disk) into the field customers (in the RAM memory).
        //You will need to implement the loadFromFile method first
        loadFromFile(filename);
        
    }

    @Override
    public void insert(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean delete(String customerId) {
        
        return this.customers.removeIf(c -> customerId.equals(c.getId()));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void saveToFile(String filename) {
        this.customerDAO.saveToFile(filename, customers);
    }

    @Override
    public void loadFromFile(String filename) {
        this.customers = this.customerDAO.loadFromFile(filename);
    }
    
}
