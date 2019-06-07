package de.quandoo.recruitment.registry.model;

/**
 * Created by Cláudio Braga on 04/06/2019.
 */
public class Customer {

    private final String uuid;

    public Customer(final String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

}
