/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import java.io.BufferedReader;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author benson
 */
public class CustomerDAOTextFileImpl implements CustomerDAOInterface {

    /**
     *
     * @param filename
     * @param customers
     */
    @Override
    public void saveToFile(String filename, List<Customer> customers) {

        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Customer customer : customers) {
                String customerLine = customer.convertToCommaSeparatedString();

                bw.write(customerLine);

                bw.write("\n");
            }

        } catch (Exception e) {
            System.out.println("An error occurred");
        }
    }

    @Override
    public List<Customer> loadFromFile(String filename) {

        List<Customer> customers = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            
            while((line = br.readLine()) != null) {
                String [] tokens = line.split(",");
                
                String id = tokens[0];
                
                String name = tokens[1];
                
                int age = Integer.parseInt(tokens[2]);
                
                Customer customer = new Customer(id, name, age);
                
                customers.add(customer);
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return customers;

    }
}
