package ua.com.markovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import ua.com.markovka.model.Client;
import ua.com.markovka.repositories.ClientRepository;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByPhone/{phone}")
    public ResponseEntity<Client> findByPhone(@PathVariable("phone") String phone){
        return new ResponseEntity<>(clientRepository.findByPhone(phone), HttpStatus.OK);
    }
}
