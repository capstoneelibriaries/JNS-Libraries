package capstone.elibraries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SearchController {

    private final String[] options = {"books", "ads"};

    @GetMapping("/search")
    public String getSearch(){
        return "redirect:/";
    }

    @GetMapping("/search?q=&option={option}")
    public String getSearch(@PathVariable String option){
        //TODO: do stuff
        return "search";
    }

    @GetMapping("/search?q={query}&option={option}")
    public String getSearch(@PathVariable String query, @PathVariable String option){
        // TODO: do stuff
        return "search";
    }

    @GetMapping("/advanced?q={query}&option={option}")
    public String getAdvanced(@PathVariable String query, @PathVariable String option){
        // TODO: advanced search page
        return "advanced";
    }

}
