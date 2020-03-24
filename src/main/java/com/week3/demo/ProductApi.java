package com.week3.demo;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {

//    @RequestMapping(method = RequestMethod.GET)  ---> czasami mozna uzywac
    @GetMapping
    public String getProducts(){
        return "Hello word with GET";
    }
    @PostMapping
    public String addProduct(){
        return "Hello word with POST";
    }
    @PutMapping
    public String modifyProducts(){
        return "Hello word with Put";
    }
    @DeleteMapping
    public String removeProducts(){
        return "Hello word with Delete";
    }

}
