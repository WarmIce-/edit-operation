package com.springapp.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HomeController {
@RequestMapping(value="/")
    public ModelAndView Contact()
{
    ModelAndView model=new ModelAndView("hello");
    model.addObject("mess","Hello World");
    return model;


}
}
