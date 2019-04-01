package com.codemaster.demo.client;

import com.codemaster.demo.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client>  getAllClients() {
        return clientRepository.findAll();
    }

    public List<Client>  getAllClientsByUser(ApplicationUser user) {
        return clientRepository.findAllByUser(user);
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findOne(clientId);
    }

    public void save(Client client) {
        clientRepository.save(client);
    }
}
