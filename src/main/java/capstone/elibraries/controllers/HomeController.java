package capstone.elibraries.controllers;

import capstone.elibraries.models.Ad;
import capstone.elibraries.repositories.Ads;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private Ads adsDao;

    public HomeController(Ads adsDao){
        this.adsDao = adsDao;
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("ads", adsDao.findAll());
        return "index";
    }
}
