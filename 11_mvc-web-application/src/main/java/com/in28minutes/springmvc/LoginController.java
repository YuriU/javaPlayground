package com.in28minutes.springmvc;

import com.in28minutes.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //@ResponseBody
    public String show() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //@ResponseBody
    public String processLogin(
            @RequestParam String name,
            @RequestParam String password,
            ModelMap model) {

        if (service.isUserValid(name, password)) {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        } else {
            model.put("errorMessage", "Credentials are invalid");
            return "login";
        }
    }
}
