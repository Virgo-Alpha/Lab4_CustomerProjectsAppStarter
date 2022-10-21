/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class Customer {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    private String name;
    private int age;

    public Customer(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    
    @Override
    public String toString(){
        return String.format("Customer[id = %s, name = %s, age = %d]", id, name, age);
    }
    
    public String convertToCommaSeparatedString(){
        return String.format("%s, %s, %d", id, name, age) ;
    }
    
}



