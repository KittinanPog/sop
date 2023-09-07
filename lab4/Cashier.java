package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {

    @RequestMapping(value="/getChange/{ch}")
    public Change getChange(@PathVariable("ch") int ch){
        Change changes = new Change();
        while (ch >0){
            if (ch >= 1000) {
                ch -= 1000;
                changes.setB1000(changes.getB1000() + 1);
            }
            else if (ch >= 500) {
                ch -= 500;
                changes.setB500(changes.getB500() + 1);
            }
            else if (ch >= 100) {
                ch -= 100;
                changes.setB100(changes.getB100() + 1);
            }
            else if (ch >= 20) {
                ch -= 20;
                changes.setB20(changes.getB20() + 1);
            }
            else if (ch >= 10) {
                ch -= 10;
                changes.setB10(changes.getB10() + 1);
            }
            else if (ch >= 5) {
                ch -= 5;
                changes.setB5(changes.getB5() + 1);
            }
            else if (ch >= 1) {
                ch -= 1;
                changes.setB1(changes.getB1() + 1);
            }
        }
      return changes;
    }

}
