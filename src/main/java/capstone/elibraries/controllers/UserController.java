package capstone.elibraries.controllers;

import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @GetMapping("/login")
    public String getLogin(){
        return "/user/login";
    }

    @PostMapping("/login")
    public String postLogin(){
        return "/user/profile";
    }

}
