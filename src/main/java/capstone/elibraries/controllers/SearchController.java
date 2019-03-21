package capstone.elibraries.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    private final String[] options = {"books", "ads"};

    // The default search page
    @GetMapping("search")
    public String getSearch(@RequestParam("q") String query, @RequestParam("option") String option){
        // DEBUG
        System.out.println("DEBUG: getSearch(...): query = " + query + ", option = " + option);
        // END DEBUG
        return "index";
    }

    // The advanced search page
    @GetMapping("advanced")
    public String getAdvanced(@RequestParam("q") String query, @RequestParam("option") String option){
        // DEBUG
        System.out.println("DEBUG: getAdvance(...): query = " + query + ", option = " + option);
        // END DEBUG
        return "advanced";
    }

}
