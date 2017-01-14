package com.testcontoller;

import com.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by Edvard Piri on 13.01.2017.
 */
@Controller
public class TestController {

    @Autowired
    TestDAO testDAO;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        return new ModelAndView("index.vm");
    }

    @RequestMapping(value = "/newUser")
    public void newUser() {
        Date date = new Date();
        Users user = new Users("Lotar", "Hagen", "lotar@mail.ru", "+380312323", date, "horinis");
        testDAO.save(user);
    }

    @RequestMapping(value = "/showUser")
    public ModelAndView showUser() {
        ModelAndView modelAndView = new ModelAndView("testUser.vm");

        return modelAndView;
    }
}
