package ua.com.markovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/byClientId")
    public ResponseEntity<List<Call>> findByClientId(Long id){
        return new ResponseEntity<>(callRepository.findAllByClientId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Call> save(@RequestBody Call call){
        return new ResponseEntity<>(callRepository.saveAndFlush(call),HttpStatus.OK);
    }
}
