package com.company.demo.client;

import com.company.demo.user.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
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
