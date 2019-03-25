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
    public String getOneAd(Model model, @PathVariable Long id){
        model.addAttribute("ad", adsDao.findOne(id));
        return "ads/single";
    }

    @GetMapping("/ads/create")
    public String createAdForm(Model model){
        model.addAttribute("ad",new Ad());
        model.addAttribute("newbook", new Book());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String createAd(@ModelAttribute Ad ad, @ModelAttribute Book book){
        System.out.println(ad.toString());
        System.out.println(book.toString());
        ad.addBook(book);
        adsDao.save(ad);
        return "users/profile";
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
                usersDao.findOne(ad.getSeller().getId()).getId()) {
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
                usersDao.findOne(ad.getSeller().getId()).getId()) {
            ad.setId(id);
            adsDao.save(ad);
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
        if (user.getAds().isEmpty()) {
            return "redirect:/ads/view=" + id + "?noads";
        }
        else if (user.getId() == ad.getSeller().getId()){
            return "redirect:/ads/view=" + id+ "?error";
        }
        model.addAttribute("ad", ad);
        model.addAttribute("user", user);
        return "ads/trade";
    }

}