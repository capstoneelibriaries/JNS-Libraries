package capstone.elibraries.controllers;

import capstone.elibraries.error.ValidationException;
import capstone.elibraries.models.Address;
import capstone.elibraries.models.TradeRequest;
import capstone.elibraries.models.Transaction;
import capstone.elibraries.repositories.TradeRequests;
import capstone.elibraries.repositories.Transactions;
import capstone.elibraries.repositories.Addresses;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import capstone.elibraries.repositories.Users;
import capstone.elibraries.models.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/profile/settings")
    public String getSettings(Model model){
        User current = this.getCurrentUser();

        model.addAttribute("user", current);
        return "/users/settings";
    }

    @PostMapping("/profile/settings")
    public String postSettings(@ModelAttribute User user, Model model){
        User current = this.getCurrentUser();
        current.setUsername(user.getUsername());
        current.setEmail(user.getEmail());
        current.setPhone(user.getPhone());
        current.setPassword(user.getPassword());

        model.addAttribute("user", current);
        return "/users/settings";
    }

    @GetMapping("/profile/addresses")
    public String getAddress(Model model) {
        User current = this.getCurrentUser();

        model.addAttribute("userId", current.getId());
        return "/users/addresses";
    }

    @GetMapping("/profile/addresses/{userId}")
    @ResponseBody
    public String getAddressByUserId(@PathVariable long userId){
        User current = getCurrentUser();
        if(current.getId() != userId){
            return String.format("%s", HttpStatus.FORBIDDEN);
        }

        Address billing = current.getBillingAddress();
        Address shipping = current.getShippingAddress();

        billing = (billing == null) ? new Address() : billing;
        shipping = (shipping == null) ? new Address() : shipping;

        return String.format("[%s,%s]", billing.toJson(), shipping.toJson());
    }

    @PostMapping("/profile/addresses")
    public String postAddress(HttpServletRequest req){
        User current = getCurrentUser();

        List<Address> addr = new ArrayList<>(2);
        addr.add(new Address(req, "billing"));
        addr.add(new Address(req, "shipping"));
        current.setAddresses(addr);

        this.addrRepo.save(addr.get(0));
        this.addrRepo.save(addr.get(1));

        return "redirect:/profile";
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
                return "redirect:/login?success";
            }else{
                return "redirect:/register?error";
            }
        }catch(ValidationException e){
            model.addAttribute("error", e);
            return "redirect:/error/validation";
        }
    }

}
