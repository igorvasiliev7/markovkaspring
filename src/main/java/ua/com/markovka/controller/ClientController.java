package ua.com.markovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.markovka.model.Client;
import ua.com.markovka.model.ClientDTO;
import ua.com.markovka.repositories.ClientRepository;

import java.util.LinkedList;
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
        List<ClientDTO> clients = new LinkedList<>();
        for (Object[] objects : clientRepository.findAllDto()){
            if(objects[5]==null) {
                objects[5]="-";
                objects[6]="-";
            }
            ClientDTO client = new ClientDTO(
                    Long.parseLong(objects[0].toString()),
                    objects[1].toString(),
                    objects[2].toString(),
                    objects[3].toString(),
                    Integer.parseInt(objects[4].toString()),
                    objects[5].toString(),
                    objects[6].toString(),
                    objects[7].toString(),
                    Integer.parseInt(objects[8].toString())
            );
            clients.add(client);
        }
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }
    @GetMapping("/findByStatusDto/{status}")
    public ResponseEntity<List<ClientDTO>> findByStatusDto(@PathVariable ("status") String status){
        List<ClientDTO> clients = new LinkedList<>();
        for (Object[] objects : clientRepository.findByStatusDto(status)) {
            if(objects[5]==null) {
                objects[5]="-";
                objects[6]="-";
            }
            ClientDTO client = new ClientDTO(
              Long.parseLong(objects[0].toString()),
                    objects[1].toString(),
                    objects[2].toString(),
                    objects[3].toString(),
              Integer.parseInt(objects[4].toString()),
                    objects[5].toString(),
                    objects[6].toString(),
                    objects[7].toString(),
              Integer.parseInt(objects[8].toString())
            );
            clients.add(client);
        }
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientRepository.saveAndFlush(client),HttpStatus.OK);
    }
}
