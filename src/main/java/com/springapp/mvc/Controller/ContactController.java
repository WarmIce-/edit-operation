package com.springapp.mvc.Controller;

import com.springapp.mvc.DAO.serviceImpl.ContactServiceImpl;
import com.springapp.mvc.Models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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


    @RequestMapping(value = "/insertOrUpdate", method = RequestMethod.POST)
    /* data sent from the <form> are bound to the contactModel
    which is represented by form attribute -> 'COMMAND NAME' or 'modelAttribute'

     <form:form> <form:form> = spring form tag . it supports attribute: 'commandName'
     <form><form>  = normal form which doesn't support attribute: 'commandName'

      <form:input> is equivalent to saying <input type="text">
      here, 'path' attribute specifies name of a property of the java model class.
       eg. 'Contact' model has a properties called 'name','address','telephone' and 'email' defined in java

      */
    public ModelAndView insertOrUpdate(@ModelAttribute(value = "contactModel") Contact contactModel, BindingResult result, ModelMap model)
        {
            ModelAndView modelandview = new ModelAndView("hello");
            if (result.hasErrors()) {
                modelandview.addObject("message", "Error occurred!!!!");
            } else {
                contactServiceImpl.insertorUpdate(contactModel);
                modelandview.addObject("message", "data insertion success");

            }

            return modelandview;
        }


    @RequestMapping(value = "/editContact/", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam(value = "rowId") String rowId)
        {
            ModelAndView modelAndView = new ModelAndView("addpage");
            // id [rowId in our case] was sent from <form> tag from jsp page, remember??,
            // we are just making sure using logger whether the sent rowId is received here or not.
            //this rowId can be seen in the console below in the red text.
            logger.info("id sent from JSP:" + rowId);
            int contactId = Integer.valueOf(rowId);
            Contact contact = contactServiceImpl.getById(contactId);

            // to see if corresponding row is returned from database based on that id.
            logger.info("employee name ->" + contact.getName());

            //pass 'contact' object to jsp page -> addpage.jsp and perform the edit operation there.
            modelAndView.addObject("contactModel", contact);
            modelAndView.addObject("saveOrEdit", "edit contact");
            return modelAndView;
        }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView addPage(Model model)
       {
           ModelAndView modelAndView = new ModelAndView("addpage");
           modelAndView.addObject("saveOrEdit", "save contact");

           //The form:form needs an "empty" model that corresponds to the 'commandName' or 'modelAttribute' you defined.
           model.addAttribute("contactModel", new Contact());
           return modelAndView;
       }


    @RequestMapping(value = "/deleteContact/", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(value = "rowId") String rowId) {
        ModelAndView modelAndView = new ModelAndView("hello");
        int contactId = Integer.valueOf(rowId);
        boolean isDeleteSuccessful = contactServiceImpl.delete(contactId);
        if (isDeleteSuccessful) {
            modelAndView.addObject("message", " table row deletion success!!");
        }
        return modelAndView;

    }


}
