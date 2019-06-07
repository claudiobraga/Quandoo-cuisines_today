package de.quandoo.recruitment.registry.api;

import de.quandoo.recruitment.registry.model.Cuisine;
import de.quandoo.recruitment.registry.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Cláudio Braga on 04/06/2019.
 */
public class Main {

    static Scanner keyboard=new Scanner(System.in);
    static boolean v=true;
    static int opt=0;
    static InMemoryCuisinesRegistry memoryRegister=new InMemoryCuisinesRegistry();
    static ArrayList<String> customerAll = new ArrayList<>();

    public static void main(String[] args) {
        do{
            dashboard();
            opt=keyboard.nextInt();
            switch (opt) {
                case 1:
                    System.out.printf("Insert a Customer Name: ");
                    String name=keyboard.next();
                    customerAll.add(name);
                    System.out.printf("Insert a Cuisine Name: ");
                    String cuisine=keyboard.next();
                    memoryRegister.register(new Customer(name), new Cuisine(cuisine));
                    keepgoing();
                    break;
                case 2:
                    System.out.println("Choose one of a Cuisine Names: ");
                    String cuisine1=keyboard.next();
                    List<Customer>list=memoryRegister.cuisineCustomers(new Cuisine(cuisine1));
                    if(list!=null){
                        System.out.println("#Customers List");
                        for(Customer a:list){
                            System.out.println("Name: "+a.getUuid());
                        }
                    }else{
                        System.out.println("#Doesn't exist this Cuisine");
                    }
                    keepgoing();
                    break;
                case 3:
                    System.out.println("Insert the customer Name to see the Cuisine ");
                    String nameCustomer=keyboard.next();
                    List<Cuisine>listCu=memoryRegister.customerCuisines(new Customer(nameCustomer));
                    if(listCu.isEmpty()==false){
                        System.out.println("#Cuisine Visited" + " by " + nameCustomer);
                        for(Cuisine a:listCu){
                            System.out.println("Cuisine: "+a.getName());
                        }
                    }else{
                        System.out.println("#Doesn't exist Cuisine visited" + " by " + nameCustomer);
                    }
                    keepgoing();
                    break;

                case 4:
                    System.out.println("Insert the maximum number of visit ");
                    int n=keyboard.nextInt();
                    List<Cuisine>listCu2=memoryRegister.topCuisines(n);

                    if(listCu2.isEmpty()==false){
                        System.out.println("#Top Cuisine Visited " + n + "x");
                        for(Cuisine a:listCu2){
                            System.out.println("Cuisine: "+a.getName());
                        }
                    }else{
                        System.out.println("#Doesn't exist Cuisine visited " + n + "x");

                    }
                    keepgoing();
                    break;
                case 5:
                    v=false;
                    System.out.println("SESSION FINISHED");
                    break;
                default:
                    System.out.println("Wrong Option!");
                    keepgoing();
                    break;
            }
        }while(v);
    }

    private static void dashboard(){
        System.out.println("DASHBOARD");
        System.out.println("1 - Visit's Cuisine");
        System.out.println("2 - Cuisine Customers");
        System.out.println("3 - Customer Cuisines");
        System.out.println("4 - Top Cuisine");
        System.out.println("5 - Log Off");
        System.out.printf("Insert an Number Option >");
    }

    private static void space(){
        for(int i=0;i<5;i++){
            System.out.println("");
        }
    }

    private static void keepgoing(){
        System.out.println("Insert any character and press [ENTER]");
        keyboard.next();
        space();
    }

}