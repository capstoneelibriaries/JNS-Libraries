package capstone.elibraries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    @GetMapping("/login")
    public String getLogin(){
        return "/user/login";
    }

    @PostMapping("/login")
    public String postLogin(){
        return "/user/profile";
    }

    @GetMapping("/logout")
    public String getLogout(){
        return "/user/logout";
    }

}
