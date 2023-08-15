package com.example.firstservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathService {
    @RequestMapping (value = "/add/{val1}/{val2}", method = RequestMethod.GET)
    public String add (@PathVariable("val1") double val1, @PathVariable("val2") double val2){
        return Double.toString(val1+val2);
    }
    @RequestMapping (value = "/minus/{val1}/{val2}", method = RequestMethod.GET)
    public String minus (@PathVariable("val1") double val1, @PathVariable("val2") double val2){
        return Double.toString(val1-val2);
    }
    @RequestMapping (value = "/multiply", method = RequestMethod.GET)
    public String multiply (@RequestParam("num1") double num1, @RequestParam("num2") double num2){
        return Double.toString(num1*num2);
    }
    @RequestMapping (value = "/divide", method = RequestMethod.GET)
    public String divide (@RequestParam("num1") double num1, @RequestParam("num2") double num2){
        return Double.toString(num1/num2);
    }
}
