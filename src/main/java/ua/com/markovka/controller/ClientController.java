package ua.com.markovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.com.markovka.model.Client;
import ua.com.markovka.model.ClientDTO;
import ua.com.markovka.repositories.ClientRepository;

import javax.persistence.Tuple;
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

    @GetMapping("/findAllDto")
    public ResponseEntity<List<ClientDTO>> findAllDto(){
        return new ResponseEntity<>(clientRepository.findAllDto(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientRepository.saveAndFlush(client),HttpStatus.OK);
    }
}
