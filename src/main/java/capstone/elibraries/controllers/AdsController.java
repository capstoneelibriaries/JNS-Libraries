package capstone.elibraries.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import capstone.elibraries.repositories.Users;
import capstone.elibraries.repositories.Ads;
import capstone.elibraries.models.User;
import capstone.elibraries.models.Ad;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
        return "ads/index";
    }
    @GetMapping("/ads/view={id}")
    public String getOneAd(Model model, @PathVariable Long id){
        model.addAttribute("ad",ads.findOne(id));
        return "ads/single";
    }

    @GetMapping("/ads/create")
    public String createAdForm(Model model){

        Date date = new Date();
        String timehash = DigestUtils.md5DigestAsHex(date.toString().getBytes());
        System.out.println(timehash);

        model.addAttribute("timehash", timehash);
        model.addAttribute("ad",new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String createAd(HttpServletRequest request){
        System.out.println("DEBUG: createAd(...)");
        System.out.println(request.getParameter("price"));
        System.out.println(request.getParameter("shipping"));
        return "/ads/index";
    }
//    @PostMapping("/ads/create")
//    public String createAd(@ModelAttribute Ad ad){
//
//        ad.setSeller(
//        users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
//        ads.save(ad);
//
//        return "/ads/index";
//    }
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
            ad.setId(id);
            ads.save(ad);
            return "redirect:/profile";
        }else{
            return "redirect:/profile";
        }
    }


}
