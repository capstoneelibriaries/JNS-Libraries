package capstone.elibraries.controllers;

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
        model.addAttribute("ad",new Ad());
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String createAd(HttpServletRequest request){
        try{
            // create a new ad
            Ad ad = new Ad(getCurrentUser(),
                    Double.parseDouble( request.getParameter("price") ),
                    Double.parseDouble( request.getParameter("shipping") ));
            // count the books
            int bookCount = Integer.parseInt(request.getParameter("book-count"));
            // add each book to the ad object
            for(int i = 0; i < bookCount; i++) {
                Book book = new Book(request.getParameter("book-isbn-" + i),
                        request.getParameter("book-title-" + i),
                        request.getParameter("book-author-" + i),
                        request.getParameter("book-synopsis-" + i),
                        "/images/bookexample.jpeg",
                        Byte.parseByte(request.getParameter("book-wear-" + i)));
                ad.addBook(book);
            }
            // save the ads and the books to the database
            ads.save(ad);
            return "/ads/index";
        }catch(ValidationException e){
            // if the image is bad
            if(e.getClass().equals(ImageException.class)){
                e.setRedirect(String.format("%s", HttpStatus.UNSUPPORTED_MEDIA_TYPE));
            }
            // if the isbn is bad
            else if(e.getClass().equals(IsbnException.class)){
                e.setRedirect(String.format("%s", HttpStatus.LENGTH_REQUIRED));
            }
            // if the user authentication is bad
            else if(e.getClass().equals(AuthenticationException.class)){
                e.setRedirect(String.format("%s", HttpStatus.EXPECTATION_FAILED));
            }
            // DEBUG
            System.out.println(e.toString());
            // END DEBUG
            return e.getRedirect();
        }catch(NumberFormatException e){
            return String.format("%s", HttpStatus.BAD_REQUEST);
        }
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

    @GetMapping("/ads/{id}/buy")
    public String buyForm(Model model, @PathVariable Long id){
        model.addAttribute("ad", ads.findOne(id));
        return "ads/buy";
    }
    @GetMapping("/ads/{id}/trade")
    public String tradeForm(Model model, @PathVariable Long id){
        User user = users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        Ad ad = ads.findOne(id);
        if (null == user ) {
            return "redirect:/login?trade";
        }
        if (user.getId() == ad.getSeller().getId()){
            return "redirect:/ads/" + id+ "?error";
        }
        model.addAttribute("ad", ad);
        model.addAttribute("user", user);
        return "ads/trade";
    }
    private User getCurrentUser()
        throws AuthenticationException
    {
        long id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        if(!users.exists(id)){
            throw new AuthenticationException(
                    "Expected: user id of " + id,
                    "Received: user does not exist!"
            );
        }
        User curUser = users.findOne(id);
        return curUser;
    }
}