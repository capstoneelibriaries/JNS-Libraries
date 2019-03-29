package capstone.elibraries.controllers;

import capstone.elibraries.error.ValidationException;
import capstone.elibraries.models.Address;
import capstone.elibraries.models.TradeRequest;
import capstone.elibraries.models.Transaction;
import capstone.elibraries.repositories.TradeRequests;
import capstone.elibraries.repositories.Transactions;
import capstone.elibraries.repositories.Addresses;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import capstone.elibraries.repositories.Users;
import capstone.elibraries.models.User;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


@Controller
public class UserController {
    private Users users;
    private PasswordEncoder passwordEncoder;
    private TradeRequests trades;
    private Addresses addrRepo;
    private Transactions transactions;

    public UserController(Users users, PasswordEncoder passwordEncoder, TradeRequests trades, Addresses addresses, Transactions transactions) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.trades = trades;
        this.addrRepo = addresses;
        this.transactions = transactions;
    }

    private User getCurrentUser(){
        return users.findOne(
                ((User) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal()
                ).getId());
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

    @GetMapping("/profile/addresses")
    public String getAddress(Model model) {
        User curUser = this.getCurrentUser();
        try {

        } catch(UnknownError e) {

        }
        Address shippingAddress = new Address();
        Address billingAddress = new Address();
        model.addAttribute("shippingAddress", shippingAddress);
        model.addAttribute("billingAddress", billingAddress);
        return "/users/addresses";
    }

    @PostMapping("/profile/addresses")
    public String postAddress(@ModelAttribute Address shippingAddress, @ModelAttribute Address billingAddress){
        User current = getCurrentUser();

        List<Address> addr = new ArrayList<>(2);
        billingAddress.setBilling(true);
        shippingAddress.setBilling(false);
        addr.add(billingAddress);
        addr.add(shippingAddress);

        current.setAddress(addr);
        users.save(current);

//        shippingAddress.setBilling(false);
//        shippingAddress.setUser(current);
//        billingAddress.setBilling(true);
//        billingAddress.setUser(current);
//        this.addrRepo.save(shippingAddress);
//        this.addrRepo.save(billingAddress);
        return "redirect:/users/profile";
    }

    @GetMapping("/profile/transactions")
    public String showTransactions(Model model) {
        User databaseUser = users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        model.addAttribute("transactions", transactions.findAllBySellerOrBuyerOrderByDateAsc(databaseUser, databaseUser));
        model.addAttribute("user", databaseUser);
        return "users/transactions";
    }

    @GetMapping("/profile/trades")
    public String showTradeRequests(Model model) {
        User databaseUser = users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        List<TradeRequest> t = (List<TradeRequest>) trades.findTradeRequestByPendingIsTrueAndTo(databaseUser) ;
        model.addAttribute("trades", t);
        return "users/trades";
    }

    @PostMapping("/profile/trades")
    public String confirmDenyTradeRequests(@RequestParam( name = "choice") String choice, @RequestParam( name = "id") Long trade) {
        TradeRequest tradeRequest = trades.findOne(trade);
        tradeRequest.setPending(false);

        if (choice.equalsIgnoreCase("confirm")){
            User databaseUser = users.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());

            tradeRequest.getWanted().setSeller(tradeRequest.getForSale().getSeller());
            tradeRequest.getForSale().setSeller(databaseUser);
            // TODO: send email and/or notification that trade is complete and exchange shipping addresses
            transactions.save(
                    new Transaction(
                            tradeRequest.getFrom(),
                            tradeRequest.getTo(),
                            tradeRequest.getForSale(),
                            tradeRequest,
                            new Timestamp(new Date().getTime())
                    )
            );
        }
            trades.save(tradeRequest);
        return "redirect:/profile/trades";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user, Model model) {
        try{
            if (user.getPassword().equals(user.getConfirmPassword())) {

                String hash = passwordEncoder.encode(user.getPassword());
                user.setPassword(hash);
                user.setConfirmPassword("");
                users.save(user);
                return "redirect:/login";
            }else{
                return "redirect:/register?error";
            }
        }catch(ValidationException e){
            model.addAttribute("error", e);
            return "redirect:/error/validation";
        }
    }

}
