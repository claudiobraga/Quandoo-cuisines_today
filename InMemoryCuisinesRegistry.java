package de.quandoo.recruitment.registry.api;

import de.quandoo.recruitment.registry.model.Cuisine;
import de.quandoo.recruitment.registry.model.Customer;

import java.util.LinkedList;
import java.util.List;

public class InMemoryCuisinesRegistry implements CuisinesRegistry{

    private List<Customer> italianCuisineCustomers = new LinkedList<Customer>();
    private List<Customer> frenchCuisineCustomers = new LinkedList<Customer>();
    private List<Customer> germanCuisineCustomers = new LinkedList<Customer>();

    private List<Cuisine> cuisineCustomers = new LinkedList<Cuisine>();

    private Cuisine italian=new Cuisine("italian");
    private Cuisine french=new Cuisine("french");
    private Cuisine german=new Cuisine("german");

    private String cuisineName;

    public InMemoryCuisinesRegistry() {
        cuisineCustomers.add(italian);
        cuisineCustomers.add(french);
        cuisineCustomers.add(german);
    }

    @Override
    public void register(final Customer userId, final Cuisine cuisine) {
        switch(cuisine.getName()){
            case "italian":
            case "Italian":
                italianCuisineCustomers.add(userId);
                break;
            case "french":
            case "French":
                frenchCuisineCustomers.add(userId);
                break;
            case "german":
            case "German":
                germanCuisineCustomers.add(userId);
                break;
            default:
                System.err.println("Unknown Cuisine, please check the properly Name.");
                break;
        }
    }

    @Override
    public List<Customer> cuisineCustomers(final Cuisine cuisine) {
        cuisineName=cuisine.getName();
        if(cuisineName.equalsIgnoreCase("italian")){
            return italianCuisineCustomers;
        }else if(cuisineName.equalsIgnoreCase("french")){
            return frenchCuisineCustomers;
        }else if(cuisineName.equalsIgnoreCase("german")){
            return germanCuisineCustomers;
        }else{
            return null;
        }
    }

    @Override
    public List<Cuisine> customerCuisines(final Customer customer) {
        List<Cuisine> cuisines = new LinkedList<Cuisine>();
        for(Customer a:italianCuisineCustomers){
            if(a.getUuid().equalsIgnoreCase(customer.getUuid())){
                cuisines.add(italian);
            }
        }

        for(Customer a:frenchCuisineCustomers){
            if(a.getUuid().equalsIgnoreCase(customer.getUuid())){
                cuisines.add(french);
            }
        }

        for(Customer a:germanCuisineCustomers){
            if(a.getUuid().equalsIgnoreCase(customer.getUuid())){
                cuisines.add(german);
            }
        }
        return cuisines;
    }

    @Override
    public List<Cuisine> topCuisines (final int n) {
        List<Cuisine> cuisines = new LinkedList<Cuisine>();

        if(italianCuisineCustomers.size()>=n){
            cuisines.add(italian);
        }
        if(frenchCuisineCustomers.size()>=n){
            cuisines.add(french);
        }
        if(germanCuisineCustomers.size()>=n){
            cuisines.add(german);
        }
        return cuisines;
    }

}
