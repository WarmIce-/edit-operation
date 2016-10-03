package com.springapp.mvc.DAO.service;


import com.springapp.mvc.Models.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> list();
    public void insertorUpdate(Contact contact);
    public Contact getById(int contactId);
    public void delete(int contactId);

}
