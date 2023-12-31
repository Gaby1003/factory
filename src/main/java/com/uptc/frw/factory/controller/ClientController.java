package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.Client;
import com.uptc.frw.factory.jpa.entity.Log;
import com.uptc.frw.factory.service.ClientService;
import com.uptc.frw.factory.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public List<Client> findAll(){
        return service.findAllClient();
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client){
        return service.saveClient(client);
    }

    @GetMapping("/{id}")
    public Client findClient(@PathVariable Long id){
        return service.findClient(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id){
        service.deleteClient(id);
    }

    @PutMapping("/{id}")
    public Client updatePhone(@PathVariable Long id, @RequestParam String phone){
        return service.updatePhone(id, phone);
    }
}
