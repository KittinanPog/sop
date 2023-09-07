package com.example.demo;

import org.springframework.web.bind.annotation.*;


@RestController
public class MathAPI {
    @RequestMapping(value="/plus/{n1}/{n2}",method = RequestMethod.GET)
    public String myPlus(@PathVariable("n1") double n1 , @PathVariable("n2") double n2){
        return Double.toString(n1 + n2);
    }
    @RequestMapping(value="/minus/{n1}/{n2}",method = RequestMethod.GET)
    public String myMinus(@PathVariable("n1") double n1, @PathVariable("n2")double n2){
        return Double.toString(n1-n2);
    }

    @RequestMapping(value= "/divide/{n1}/{n2}", method = RequestMethod.GET)
    public String myDivide(@PathVariable("n1") double n1, @PathVariable("n2") double n2){
        return Double.toString(n1/n2);
    }

    @RequestMapping(value= "/multi/{n1}/{n2}", method = RequestMethod.GET)
    public String myMulti(@PathVariable("n1")double n1, @PathVariable("n2")double n2){
        return Double.toString(n1*n2);
    }

    @RequestMapping(value= "/mod/{n1}/{n2}", method = RequestMethod.GET)
    public String myMod(@PathVariable("n1" ) double n1, @PathVariable ("n2" ) double n2){
        return Double.toString(n1%n2);
    }

    @RequestMapping(value= "/max", method = RequestMethod.POST)
    public String myMax(@RequestParam("n1" ) double n1, @RequestParam ("n2" ) double n2){
        return Double.toString(Math.max(n1,n2));
    }
}