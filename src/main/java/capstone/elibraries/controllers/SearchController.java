package capstone.elibraries.controllers;

import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @PostMapping("/search")
    public String postSearch(@RequestParam String query, Model model){
        //TODO: add search results to the model
        return "search";
    }
}
