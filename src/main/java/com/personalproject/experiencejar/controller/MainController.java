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
public class MainController {

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

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String renderRegistration(@RequestParam Map<String,String> allRequestParams,
                                     Model model,
                                     HttpServletRequest httpServletRequest){
        return "registration";
    }

    @RequestMapping(value = {"/jar"}, method = RequestMethod.GET)
    public String renderUserJar(@RequestParam Map<String,String> allRequestParams,
                                     Model model,
                                     HttpServletRequest httpServletRequest){
        return "user-jar";
    }
    @RequestMapping(value = {"/statistics"}, method = RequestMethod.GET)
    public String renderStatistics(@RequestParam Map<String,String> allRequestParams,
                                Model model,
                                HttpServletRequest httpServletRequest){
        return "statistics";
    }


}
