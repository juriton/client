package com.company.demo.user;

import com.company.demo.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final SecurityService securityService;

    @Autowired
    UserController (SecurityService securityService) {
        this.securityService = securityService;
    }


    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("userForm") ApplicationUser userForm) {
        securityService.autoLogin(userForm.getUserName(), userForm.getPassword());
        return "login";
    }

    @GetMapping("/")
    public String getClients(@RequestParam(value="name", required=false) String name) {
        return "redirect:/clients";
    }
}
