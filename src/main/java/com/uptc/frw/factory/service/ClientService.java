package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Client;
import com.uptc.frw.factory.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    public ClientRepository repository;

    public List<Client> findAllClient(){
        return repository.findAll();
    }

    public Client saveClient(Client client){
        return repository.save(client);
    }

    public Client findClient(Long id){
        return repository.findById(id).get();
    }

    public void deleteClient(Long id){
        repository.deleteById(id);
    }

    public Client updatePhone(Long id, String phone){
        Client client = findClient(id);
        client.setPhone(phone);
        return saveClient(client);
    }


}
