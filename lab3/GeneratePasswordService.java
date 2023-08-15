package com.example.firstservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class GeneratePasswordService {
    Random rand = new Random();



    @RequestMapping(path = "{name:[a-z]+}.generate", method = RequestMethod.GET)
    public String generate(@PathVariable("name") String name) {
        return "Hi,"+name +"\nYour new password is "+ rand.nextInt(100000000) + ".";
    }
}
