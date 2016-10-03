package com.springapp.mvc.DAO.serviceImpl;

import com.springapp.mvc.DAO.service.ContactService;
import com.springapp.mvc.Models.Contact;
import com.springapp.mvc.RowMapper.ContactRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class ContactServiceImpl extends JdbcTemplate implements ContactService {
    private JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }


    @Override
    public List<Contact> list() {
     String sql="SELECT * FROM Contact";
       List<Contact>ContactList= getJdbcTemplate().query(sql,new ContactRowMapper());
        return ContactList;


    }
@Override
    public void insertorUpdate(Contact contact) {
    if (contact.getId() > 0) {
        String sql = "UPDATE `Contact` SET `name`=?, `email`=?,`telephone`=?,`address`=? WHERE `id`=?";
        String name=contact.getName();
        String email=contact.getEmail();
        Long telephone=contact.getTelephone();
        String address=contact.getAddress();
        int id=contact.getId();
        Object[] args = {name, email, telephone, address,id};
        getJdbcTemplate().update(sql, args);

    }else {
        String sql = "INSERT INTO `Contact`(`name`,`email`,`telephone`,`address`) VALUES (?,?,?,?)";
        String name = contact.getName();
        String email = contact.getEmail();
        Long telephone = contact.getTelephone();
        String address = contact.getAddress();
        Object[] args = {name, email, telephone, address};
        getJdbcTemplate().update(sql, args);
    }
    }
@Override
    public Contact getById(int contactId)
    {
        Object[]args={contactId};
        String sql = "select * from Contact where id=?";
        Contact contact=getJdbcTemplate().queryForObject(sql,new ContactRowMapper(),args);
        return contact;
    }
@Override
    public void delete(int contactId) {
        Object[]args={contactId};
        String sql="delete from contact where id=?";
        getJdbcTemplate().update(sql,args);

    }
}
