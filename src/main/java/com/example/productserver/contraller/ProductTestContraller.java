package com.example.productserver.contraller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productTestContraller")
public class ProductTestContraller {

    @GetMapping("/updateStore")
    public String updateStore(String productNo){
        System.out.println("8083======");
        return "远程调用成功！";
    }
}
