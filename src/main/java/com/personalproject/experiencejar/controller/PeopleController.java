package com.personalproject.experiencejar.controller;

import com.personalproject.experiencejar.controller.collectdata.PersonDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class PeopleController {

    @Autowired
    public PersonDataHandler personDataHandler;

    @RequestMapping(value = {"/", "/hapinessjar"}, method = RequestMethod.GET)
    public String renderPeople(@RequestParam Map<String,String> allRequestParams,
                                Model model,
                                HttpServletRequest httpServletRequest) {


        return "index";
    }

    @RequestMapping(value = {"/whatisit" }, method = RequestMethod.GET)
    public String renderWhatisit(@RequestParam Map<String,String> allRequestParams,
                               Model model,
                               HttpServletRequest httpServletRequest) {


        return "about";
    }

}
