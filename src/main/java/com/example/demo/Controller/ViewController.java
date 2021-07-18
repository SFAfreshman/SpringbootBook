package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created BY DarkSheep ON 2021/7/15 23:56
 **/
@RestController
public class ViewController {
    @GetMapping("/test")
    public String test()
    {
        return "helloWorld";
    }
}
