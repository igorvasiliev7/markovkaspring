package ua.com.markovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.markovka.model.Call;
import ua.com.markovka.repositories.CallRepository;

import java.util.List;

@RestController
@RequestMapping("api/calls")
public class CallController {

    @Autowired
    CallRepository callRepository;

    @GetMapping
    public ResponseEntity<List<Call>> findAll(){
        return new ResponseEntity<>(callRepository.findAll(), HttpStatus.OK);
    }
}
