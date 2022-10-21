
package repositories;

import java.util.List;
import model.Customer;


public interface CustomerRepositoryInterface {
    public void insert (Customer customer);
    public boolean delete (String customerId);
    public List<Customer> findAll();
    public void saveToFile(String filename);
    public void loadFromFile(String filename);

}
