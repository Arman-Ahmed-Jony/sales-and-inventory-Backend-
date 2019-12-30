package com.getanoutfit.salesAndInventory.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping()
    public String urlTest(){
        return "welcome J test";
    }
}
