package com.xyp.model.observ;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements ProductInterface {

    List<CustomerInterface> customerList = new ArrayList<>();

    public ProductService(List<CustomerInterface> customerList) {
        super();
        this.customerList.addAll(customerList);
    }

    public ProductService() {
        super();
    }

    @Override
    public void publish(String message) {
        for (CustomerInterface customerInterface : customerList) {
            customerInterface.customerMessage(message);
        }
    }

    @Override
    public void zookeep(CustomerInterface customer) {

        customerList.add(customer);

    }

}
