package com.spring.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rollDiceView() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDiceN(@PathVariable int n, Model model) {
        String message;

        int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);

        if(n == randomNum) {
            message = "You guessed correctly!";
        } else {
            message = "Sorry! Try again!";
        }

        model.addAttribute("randomNumber", randomNum);
        model.addAttribute("n", n);
        model.addAttribute("message", message);

        return "roll-results";
    }
}
