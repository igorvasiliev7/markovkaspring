package ua.com.markovka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.markovka.model.Visit;
import ua.com.markovka.repositories.VisitRepository;

import java.util.List;

@RestController
@RequestMapping("api/visits")
public class VisitController {

    @Autowired
    VisitRepository visitRepository;

    @GetMapping
    public ResponseEntity<List<Visit>> findAll(){
        return new ResponseEntity<>(visitRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/byClientId")
    public ResponseEntity<List<Visit>> findByClientId(Long id){
        return new ResponseEntity<>(visitRepository.findAllByClientId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Visit> save(@RequestBody Visit visit){
        return new ResponseEntity<>(visitRepository.saveAndFlush(visit),HttpStatus.OK);
    }

}
