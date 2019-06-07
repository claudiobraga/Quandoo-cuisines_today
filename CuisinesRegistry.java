package de.quandoo.recruitment.registry.api;

import de.quandoo.recruitment.registry.model.Cuisine;
import de.quandoo.recruitment.registry.model.Customer;
import java.util.List;


/**
 * Created by Cláudio Braga on 04/06/2019.
 */
public interface CuisinesRegistry {

    void register(Customer customer, Cuisine cuisine);

    List<Cuisine> customerCuisines(Customer customer);

    List<Cuisine> topCuisines(int n);

    List<Customer> cuisineCustomers(Cuisine cuisine);

}
