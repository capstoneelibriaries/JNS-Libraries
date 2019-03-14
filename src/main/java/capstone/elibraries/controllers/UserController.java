package capstone.elibraries.controllers;

import capstone.elibraries.repositories.Ads;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import capstone.elibraries.repositories.Users;
import capstone.elibraries.models.User;
import org.springframework.ui.Model;

@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private Ads ads;

    public UserController(Users users, PasswordEncoder passwordEncoder, Ads ads) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.ads = ads;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }

    @GetMapping("/profile")
    public String showProfileForm(Model model) {
        User databaseUser = users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

        model.addAttribute("user", databaseUser);
        model.addAttribute("ads", ads.findAdBySeller(databaseUser));

        return "users/profile";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
       if (user.getPassword().equals(user.getConfirmPassword())) {

           String hash = passwordEncoder.encode(user.getPassword());
           user.setPassword(hash);
           users.save(user);
           return "redirect:/login";
       }else{
           return "redirect:/register?error";
       }
    }
}