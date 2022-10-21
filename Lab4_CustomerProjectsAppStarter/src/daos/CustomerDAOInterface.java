/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import java.util.List;
import model.Customer;

/**
 *
 * @author benson
 */
public interface CustomerDAOInterface {
    public List<Customer> loadFromFile(String filename);
    
    public void saveToFile(String filename, List<Customer> customers);
    
}
