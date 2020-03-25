package com.week3.demo;


import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/products")
public class ProductApi {

    /*
    Poprzez parametr
    @RequestMapping(method = RequestMethod.GET)  ---> czasami mozna uzywac
    @GetMapping
    public String getProducts(@RequestParam  String name, @RequestParam(required = false,defaultValue = "") String surname){
        return "Hello " + name + " " + surname;
    }


    Poprzez PATH
    @GetMapping("/{name}")
    public String getProducts(@PathVariable  String name){
        return "Hello " + name ;
    }

    Poprzez HEADER
    @GetMapping
    public String getProducts(@RequestHeader  String name){
        return "Hello " + name ;
    }

    //Body
    @GetMapping
    public String getProducts(@RequestBody  String name){
        return "Hello " + name ;
    }

    @GetMapping
    public String getProducts(@RequestParam String name, @RequestHeader(required = false, defaultValue = "") String surname) {
        return "Hello " + name + " " + surname;
    }
*/



    @PostMapping
    public String addProduct() {
        return "Hello word with POST";
    }

    @PutMapping
    public String modifyProducts() {
        return "Hello word with Put";
    }

    @DeleteMapping
    public String removeProducts() {
        return "Hello word with Delete";
    }

}
