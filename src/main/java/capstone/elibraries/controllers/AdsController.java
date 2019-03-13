package capstone.elibraries.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import capstone.elibraries.repositories.Users;
import capstone.elibraries.repositories.Ads;
import capstone.elibraries.models.User;
import capstone.elibraries.models.Ad;
import org.springframework.ui.Model;

@Controller
public class AdsController {
    private Ads ads;
    private Users users;

    public AdsController(Ads ads, Users users){
        this.ads=ads;
        this.users=users;
    }
    @GetMapping("/ads")
    public String getAds(Model model){
        model.addAttribute("ads",ads.findAll());
        return "index";
    }
    @GetMapping("/ads/{id}")
    public String getOneAd(Model model, @PathVariable Long id){
        model.addAttribute("ad",ads.findOne(id));
        return "ad";
    }
    @GetMapping("/ads/create")
    public String createAd(Model model){
        model.addAttribute("ad",new Ad());
        return "ads/create";
    }
    @GetMapping("/ads/{id}/delete")
    public String deleteForm(Model model, @PathVariable Long id){
        model.addAttribute("ad",ads.findOne(id));
        return "ads/delete";
    }
    @PostMapping("/ads/{id}/delete")
    public String deleteAd(@ModelAttribute Ad ad, @PathVariable Long id){
        if (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId() ==
                users.findOne(ad.getSeller().getId()).getId()) {
                 ads.delete(ads.findOne(id));
                 return "redirect:/profile";
        }else{
            return "redirect:/profile";
        }
    }
    @GetMapping("/ads/{id}/edit")
    public String editForm(Model model, @PathVariable Long id){
        model.addAttribute("ad", ads.findOne(id));
        return "ads/edit";
    }
    @PostMapping("/ads/{id}/edit")
    public String editAd(@ModelAttribute Ad ad, @PathVariable Long id){
        if (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId() ==
                users.findOne(ad.getSeller().getId()).getId()) {
            ads.save(ad);
            return "redirect:/profile";
        }else{
            return "redirect:/profile";
        }
    }


}
