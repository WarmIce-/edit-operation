package com.springapp.mvc.DAO.service;


import com.springapp.mvc.Models.Contact;

import java.util.List;

public interface ContactService {

    /*in interface , all the methods and fields are public by default!!*/
    List<Contact> list();

    void insertorUpdate(Contact contact);

    Contact getById(int contactId);

    boolean delete(int contactId);

}
