package ua.com.markovka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("api/hello")
public class HelloController {

    @GetMapping
    public String hello(){
        return "hello";
    }
}
