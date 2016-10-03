package com.springapp.mvc.RowMapper;

import com.springapp.mvc.Models.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet resultSet, int thisRow) {

        Contact contact = null;
        try {
            contact = new Contact();
               contact.setId(resultSet.getInt("id"));
            contact.setName(resultSet.getString("name"));
            contact.setEmail(resultSet.getString("email"));
            contact.setTelephone(resultSet.getLong("telephone"));
            contact.setAddress(resultSet.getString("address"));
        } catch (Exception e) {
            return contact;
        }
        return contact;
    }
}