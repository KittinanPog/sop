package com.example.firstservice;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<Customer>();

    public CustomerController() {
        customers.add(new Customer("1010", "John", "Male", 25));
        customers.add(new Customer("1018", "Peter", "Male", 24));
        customers.add(new Customer("1019", "Sara", "Female", 23));
        customers.add(new Customer("1110", "Rose", "Female", 23));
        customers.add(new Customer("1001", "Emma", "Female", 30));
    }
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customers;
    }

    @RequestMapping(value = "/customerbyid/{id}", method = RequestMethod.GET)
    public Customer getCustomerByID(@PathVariable("id") String id){
        for (Customer i : customers){
            if (i.getID().equals(id)){
                return i;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerbyname/{n}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable("n") String n){
        for (Customer i : customers){
            if (i.getName().equals(n)){
                return i;
            }
        }
        return null;
    }

    @RequestMapping(value = "/customerDelByid/{id}", method = RequestMethod.DELETE)
    public boolean delCustomerById(@PathVariable("id") String id){
        for (Customer i : customers){
            if(i.getID().equals(id)){
                customers.remove(i);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/customerDelByname/{n}", method = RequestMethod.DELETE)
    public boolean delCustomerByName(@PathVariable("n") String n){
        for (Customer i : customers){
            if(i.getName().equals(n)){
                customers.remove(i);
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public boolean addCustomer(@RequestParam("ID") String ID,@RequestParam("n") String n,@RequestParam("s") String s,@RequestParam("a") int a){
        customers.add(new Customer(ID, n, s, a));
        return true;
    }

    @RequestMapping(value = "/addCustomer2", method = RequestMethod.POST)
    public boolean addCustomer2(@RequestParam("ID") String ID,@RequestParam("n") String n,@RequestParam("s") String s,@RequestParam("a") int a){
        customers.add(new Customer(ID, n, s, a));
        return true;
    }
}
