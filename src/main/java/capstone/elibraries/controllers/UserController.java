package capstone.elibraries.controllers;

import capstone.elibraries.models.TradeRequest;
import capstone.elibraries.repositories.TradeRequests;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import capstone.elibraries.repositories.Users;
import capstone.elibraries.models.User;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private TradeRequests trades;


    public UserController(Users users, PasswordEncoder passwordEncoder, TradeRequests trades) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.trades = trades;
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
        return "users/profile";
    }

    @GetMapping("/profile/transactions")
    public String showTransactions(Model model) {
        User databaseUser = users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        model.addAttribute("user", databaseUser);
        return "users/transactions";
    }

    @GetMapping("/profile/trades")
    public String showTradeRequests(Model model) {
        User databaseUser = users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        Iterable<TradeRequest> t = trades.findTradeRequestsByTo(databaseUser) ;
        model.addAttribute("trades", t);
        return "users/trades";
    }

    @PostMapping("/profile/trades")
    public String confirmDenyTradeRequests(@RequestParam( name = "choice") String choice, @RequestParam( name = "id") Long trade) {
        TradeRequest tradeRequest = trades.findOne(trade);
        System.out.println(trade);
        if (choice.equalsIgnoreCase("confirm")){
            User databaseUser = users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

            tradeRequest.getWanted().setSeller(tradeRequest.getForSale().getSeller());
            tradeRequest.getForSale().setSeller(databaseUser);
            trades.save(tradeRequest);
            // TODO: send email and/or notification that trade is complete and exchange shipping addresses
        }
        trades.delete(tradeRequest);
        return "redirect:/profile/trades";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user) {
       if (user.getPassword().equals(user.getConfirmPassword())) {

           String hash = passwordEncoder.encode(user.getPassword());
           user.setPassword(hash);
           user.setConfirmPassword("");
           users.save(user);
           return "redirect:/login";
       }else{
           return "redirect:/register?error";
       }
    }
}