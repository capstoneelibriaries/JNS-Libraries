package capstone.elibraries.controllers;

import capstone.elibraries.error.ImageException;
import capstone.elibraries.error.IsbnException;
import capstone.elibraries.error.ValidationException;
import capstone.elibraries.models.Book;
import org.springframework.http.HttpStatus;
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

        double price = Double.parseDouble(request.getParameter("price"));
        double shipping = Double.parseDouble(request.getParameter("shipping"));
        Ad ad = new Ad(price, shipping);

        int bookCount = Integer.parseInt(request.getParameter("book-count"));
        for(int i = 0; i < bookCount; i++){
            String isbn = request.getParameter("book-isbn-" + i);
            String title = request.getParameter("book-title-" + i);
            String author = request.getParameter("book-author-" + i);
            String synopsis = request.getParameter("book-synopsis-" + i);
            byte wear = Byte.parseByte(request.getParameter("book-wear-" + i));

            // TODO:
            // Change the image url to a value from the form submission so it isn't always null
            // and loading the default image
            try {
                Book book = new Book(isbn, title, author, synopsis, null, wear);
                ad.addBook(book);
            }
            catch(ValidationException e){
                if(e.getClass().equals(ImageException.class)){
                    e.setRedirect(String.format("%s", HttpStatus.UNSUPPORTED_MEDIA_TYPE));
                }else if(e.getClass().equals(IsbnException.class)){
                    e.setRedirect(String.format("%s", HttpStatus.LENGTH_REQUIRED));
                }
                return e.getRedirect();
            }
        }
        System.out.println(ad.toString());
        ads.save(ad);
        return "/ads/index";
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
            ad.setId(id);
            ads.save(ad);
            return "redirect:/profile";
        }else{
            return "redirect:/profile";
        }
    }


}
