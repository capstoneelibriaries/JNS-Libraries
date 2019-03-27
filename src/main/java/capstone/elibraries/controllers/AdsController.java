package capstone.elibraries.controllers;

import capstone.elibraries.repositories.TradeRequests;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import capstone.elibraries.repositories.Users;
import capstone.elibraries.repositories.Ads;
import org.springframework.http.HttpStatus;
import capstone.elibraries.models.*;
import capstone.elibraries.error.*;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdsController {
    private Ads adsDao;
    private Users usersDao;
    private TradeRequests tradesDao;

    public AdsController(Ads ads, Users users, TradeRequests trades){
        this.adsDao= ads;
        this.usersDao = users;
        this.tradesDao = trades;
    }

    private User getCurrentUser()
            throws AuthenticationException
    {
        long id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if(!usersDao.exists(id)){
            throw new AuthenticationException(
                    "Expected: user id of " + id,
                    "Received: user does not exist!"
            );
        }
        return usersDao.findOne(id);
    }

    @GetMapping("/ads")
    public String getAds(Model model){
        model.addAttribute("ads", adsDao.findAll());
        return "ads/index";
    }
    @GetMapping("/ads/view={id}")
    public String getOneAd(Model model, @PathVariable Long id) throws AuthenticationException {
        model.addAttribute("ad", adsDao.findOne(id));
        model.addAttribute("user", getCurrentUser());
        return "ads/single";
    }

    @GetMapping("/ads/create")
    public String createAdForm(Model model){
        model.addAttribute("ad",new Ad());
        model.addAttribute("newbook", new Book());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String createAd(@ModelAttribute Ad ad, @ModelAttribute Book book) throws AuthenticationException {
        System.out.println(ad.toString());
        System.out.println(book.toString());
        ad.addBook(book);
        ad.setSeller(getCurrentUser());
        adsDao.save(ad);
        return "redirect:/profile";
    }

    @PostMapping("/ads/newbook")
    public String addBook(@ModelAttribute Ad ad, @ModelAttribute Book book, Model model){
        ad.addBook(book);
        model.addAttribute("ad", ad);
        model.addAttribute("newbook", new Book());
        return "ads/create";
    }

    @GetMapping("/ads/{id}/delete")
    public String deleteForm(Model model, @PathVariable Long id){

        model.addAttribute("ad", adsDao.findOne(id));
        return "ads/delete";
    }

    @PostMapping("/ads/{id}/delete")
    public String deleteAd(@ModelAttribute Ad ad, @PathVariable Long id){
        if (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId() ==
                adsDao.findOne(ad.getId()).getSeller().getId()) {

                 adsDao.delete(adsDao.findOne(id));
                 return "redirect:/profile";
        }else{
            return "redirect:/profile";
        }
    }

    @GetMapping("/ads/{id}/edit")
    public String editForm(Model model, @PathVariable Long id){
        model.addAttribute("ad", adsDao.findOne(id));
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    public String editAd(@ModelAttribute Ad ad, @PathVariable Long id){
        if (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId() ==
                adsDao.findOne(ad.getId()).getSeller().getId()) {

            Ad dbAd = adsDao.findOne(id);
            dbAd.setAdTitle(ad.getAdTitle());
            dbAd.setDescription(ad.getDescription());
            dbAd.setPrice(ad.getPrice());
            dbAd.setShipping(ad.getShipping());

            adsDao.save(dbAd);
            return "redirect:/profile";
        }else{
            return "redirect:/profile";
        }
    }

    @GetMapping("/ads/{id}/buy")
    public String buyForm(Model model, @PathVariable Long id){
        model.addAttribute("ad", adsDao.findOne(id));
        return "ads/buy";
    }

    @GetMapping("/ads/{id}/trade")
    public String tradeForm(Model model, @PathVariable Long id) throws AuthenticationException{
        User user = getCurrentUser();
        Ad ad = adsDao.findOne(id);
        if (user.getAds().isEmpty()){
            return "redirect:/ads/view=" + id+ "?noads";
        }
        else if (user.getId() == ad.getSeller().getId()){
            return "redirect:/ads/view=" + id+ "?error";
        }
        model.addAttribute("ad", ad);
        model.addAttribute("user", user);
        return "ads/trade";
    }
    
    @PostMapping("/ads/{id}/trade")	
    public String trade(@RequestParam(name = "ad") Long adid, @PathVariable Long id) throws AuthenticationException{	
        User requestingUser = getCurrentUser();	
        Ad ad = adsDao.findOne(id);	
        Ad userAd = adsDao.findOne(adid);	
        tradesDao.save( new TradeRequest(	
            ad.getSeller(), // Owner of ad	
            requestingUser, // User requesting trade	
            ad,             // Owner's ad	
            userAd,         // User's offered ad	
            true    // Active status of the trade	
        ));	

         return "redirect:/profile";	
    }
}
