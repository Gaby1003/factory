package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Client;
import com.uptc.frw.factory.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {

    @Autowired
    public ClientRepository repository;

    @Autowired
    private LogService logService;

    public List<Client> findAllClient(){
        List<Client> clients = repository.findAll();
        logService.createLogList(clients.getClass().getSimpleName(),clients);
        return clients;
    }

    public Client saveClient(Client client){
        logService.createLogAdd(client.toString(), client.getId().toString(),
                client.getClass().getSimpleName());
        return repository.save(client);
    }

    public Client findClient(Long id){
        Client client = repository.findById(id).get();
        logService.createLogRead(client.toString(),client.getId().toString(),
                client.getClass().getSimpleName());
        return client;
    }

    public void deleteClient(Long id){
        try {
            Client client = repository.findById(id).get();
            logService.createLogDelete(client.toString(),client.getId().toString(),
                    client.getClass().getSimpleName());
            repository.deleteById(id);

        }catch (NoSuchElementException e){
            throw new RuntimeException("No se encontro el registro a eliminar");
        }
    }

    public Client updatePhone(Long id, String phone){
        Client client = findClient(id);
        Client clientAux = findClient(id);
        client.setPhone(phone);
        logService.createLogUpdate(clientAux.toString(),client.toString(),
                client.getId().toString(),client.getClass().getSimpleName());
        return repository.save(client);
    }


}
