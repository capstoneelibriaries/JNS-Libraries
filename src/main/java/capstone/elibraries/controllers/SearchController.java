package capstone.elibraries.controllers;

import capstone.elibraries.models.Ad;
import capstone.elibraries.repositories.Ads;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    private final Ads adsDao;
    private final String[] options = {"books", "ads"};

    public SearchController(Ads adsDao){
        this.adsDao = adsDao;
    }

    // The default search page
    @GetMapping("search")
    public String getSearch(@RequestParam("q") String query, @RequestParam("option") String option, Model model){
        // DEBUG
        System.out.println("DEBUG: getSearch(...): query = " + query + ", option = " + option);
        // END DEBUG

        Iterable<Ad> results = null;
        if(option.equals(options[0])){
            results = adsDao.findAdByBook(query, query, query);
        }else if(option.equals(options[1])){
            results = adsDao.findAdByAd(query, query);
        }else{
            return String.format("%s", HttpStatus.BAD_REQUEST);
        }

        model.addAttribute("ads", results);
        return "search/index";
    }

    // The advanced search page
    @GetMapping("advanced")
    public String getAdvanced(@RequestParam("q") String query, @RequestParam("option") String option){
        // DEBUG
        System.out.println("DEBUG: getAdvance(...): query = " + query + ", option = " + option);
        // END DEBUG
        return "search/advanced";
    }

}
