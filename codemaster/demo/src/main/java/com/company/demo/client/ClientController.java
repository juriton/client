package com.company.demo.client;

import com.company.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final UserService userService;
    private final ClientValidation clientValidation;

    @Autowired
    ClientController(ClientService clientService, UserService userService, ClientValidation clientValidation) {
        this.clientService = clientService;
        this.userService = userService;
        this.clientValidation = clientValidation;
    }

    @GetMapping("/clients")
    public String getClients(Model model, @RequestParam(value="clients", required=false) List<Client> clients) {
        clients = clientService.getAllClientsByUser(userService.getAuthenticatedUser());
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/client")
    public String getClient(@ModelAttribute("clientForm") Client client) {
        return "client";
    }

    @GetMapping("/editClient/{clientId}")
    public String getClientById(@ModelAttribute("clientForm") Client clientForm, @PathVariable Long clientId, Model model) {
        Client client = clientService.getClientById(clientId);
        if (!client.user.getUserName().equals(userService.getAuthenticatedUser().getUserName())) {
            return "login";
        }
        model.addAttribute("client", client);
        return "editClient";
    }

    @PostMapping("/client")
    public String addClient(@ModelAttribute("clientForm") Client clientForm, BindingResult bindingResult) {
        clientValidation.validate(clientForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "client";
        }
        clientForm.setUser(userService.getAuthenticatedUser());
        clientService.save(clientForm);
        return "redirect:/clients";
    }

    @PostMapping("/editClient/{clientId}")
    public String editClient(@ModelAttribute("clientForm") Client clientForm, BindingResult bindingResult, @PathVariable Long clientId, Model model) {
        clientValidation.validate(clientForm, bindingResult);

        if (bindingResult.hasErrors()) {
            Client client = clientService.getClientById(clientId);
            model.addAttribute("client", client);
            return "editClient";
        }
        clientForm.setUser(userService.getAuthenticatedUser());
        clientService.save(clientForm);
        return "redirect:/clients";
    }
}
