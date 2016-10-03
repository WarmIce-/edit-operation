package com.springapp.mvc.Controller;

import com.springapp.mvc.DAO.serviceImpl.ContactServiceImpl;
import com.springapp.mvc.Models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ContactController {
    private Logger logger = Logger.getLogger(ContactController.class.getName());
    private ContactServiceImpl contactServiceImpl;
@Autowired
    public ContactController(ContactServiceImpl contactServiceImpl) {
        this.contactServiceImpl = contactServiceImpl;
    }

    @RequestMapping(value="/list")
        public ModelAndView ListContact()
        {
            List<Contact> contact=contactServiceImpl.list();
            ModelAndView model=new ModelAndView("index");
            model.addObject("List",contact);
            model.addObject("msg","All the contact");
            logger.info("check value from database:" + contact.get(0).getName());
            return model;
        }



    @RequestMapping( value="/insertorupdate", method = RequestMethod.GET)
        public ModelAndView insertorUpdate(@RequestParam(value="name") String name,
                                   @RequestParam(value="email") String email,
                                   @RequestParam(value="address") String address,
                                   @RequestParam(value="telephone") String telephone)
        {
          Contact contact=new Contact();
            contact.setName(name);
            contact.setEmail(email);
            contact.setAddress(address);
            contact.setTelephone(Long.valueOf(telephone));
            contactServiceImpl.insertorUpdate(contact);
            ModelAndView modelandview=new ModelAndView("hello");
            modelandview.addObject("message","data insertion success");
            return modelandview;

        }

    @RequestMapping(value = "/editContact/{rowID}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable(value = "rowID") String id)
        {
            ModelAndView modelAndView = new ModelAndView("addpage");
            // id is sent from AJAX with get request, we are just making sure using logger whether the sent id is received here or not.
            logger.info("id sent from ajax:" + id);
            int contactId = Integer.valueOf(id);
            Contact contact = contactServiceImpl.getById(contactId);

            // to see if corresponding row is returned from database based on that id.
            logger.info("employee name ->" + contact.getName());
            modelAndView.addObject("contact", contact);
            return modelAndView;
        }
        @RequestMapping(value="/index" ,method = RequestMethod.GET)
       public ModelAndView addpage()
       {
           ModelAndView model=new ModelAndView("addpage");
           return model;
       }

}
