package com.aistle.pay.login.loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginService {

    @Autowired
    private Environment env;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String loginUser(@RequestParam String user, @RequestParam String password) {
        if(user.equals(env.getProperty("login.user")) && password.equals(env.getProperty("login.password"))){
            return "{status:success}";
        }
        else {
            return "{status:failed}";
        }
    }
}
