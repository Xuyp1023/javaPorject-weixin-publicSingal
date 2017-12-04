package com.xyp.model.observ;

public class ObservTest {

    public static void main(String[] args) {

        ProductInterface product = new ProductService();

        CustomerInterface customer1 = new CustomerService(1l);
        CustomerInterface customer2 = new CustomerService(2l);
        CustomerInterface customer3 = new CustomerService(3l);
        CustomerInterface customer4 = new CustomerService(4l);

        product.zookeep(customer1);
        product.zookeep(customer2);
        product.zookeep(customer3);
        product.zookeep(customer4);

        product.publish("shangban.....");
    }

}
