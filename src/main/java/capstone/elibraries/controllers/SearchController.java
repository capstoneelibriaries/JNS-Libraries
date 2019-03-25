package capstone.elibraries.controllers;

import capstone.elibraries.models.Ad;
import capstone.elibraries.repositories.Ads;
import capstone.elibraries.repositories.Books;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    private Ads adsDao;
    private Books booksDao;
    private final String[] options = {"books", "ads"};

    public SearchController(Ads adsDao, Books booksDao){
        this.adsDao = adsDao;
        this.booksDao = booksDao;
    }

    // The default search page
    @GetMapping("search")
    public String getSearch(@RequestParam("q") String query, @RequestParam("option") String option, Model model){
        // DEBUG
        System.out.println("DEBUG: getSearch(...): query = " + query + ", option = " + option);
        // END DEBUG

        query = "%" + query + "%";
        List<Ad> results = null;
        if(option.equals(options[0])){
            results = adsDao.findByBooks(
                    booksDao.findByTitleIsLikeOrAuthorIsLikeOrSynopsisIsLike(query, query, query)
            );
        }else if(option.equals(options[1])){
            //results = adsDao.findByTitleIsLikeOrDescriptionIsLike(query, query);
            results = adsDao.findByAdTitleIsLikeOrDescriptionIsLike(query, query);
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
