package com.springapp.mvc.Models;


public class Contact {
    private int id;
    private String name;
    private String email;
    private String address;
    private Long telephone;

    public Contact() {
    }

    public Contact( int id,String name, String email, String address, Long telephone) {

        this.name = name;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
}
