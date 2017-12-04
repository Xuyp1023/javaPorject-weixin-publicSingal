package com.xyp.model.observ;

public class CustomerService implements CustomerInterface {

    private Long id;

    public CustomerService(Long id) {
        super();
        this.id = id;
    }

    @Override
    public void customerMessage(String message) {

        System.out.println("id = " + id + "     message :" + message);

    }

}
