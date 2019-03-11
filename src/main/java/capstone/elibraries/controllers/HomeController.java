package capstone.elibraries.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "/index";
    }
}
