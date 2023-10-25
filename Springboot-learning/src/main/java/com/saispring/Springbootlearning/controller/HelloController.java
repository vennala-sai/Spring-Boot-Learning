package com.saispring.Springbootlearning.controller;

import com.saispring.Springbootlearning.entity.Department;
import org.springframework.web.bind.annotation.*;

@RestController //Stereotype annotation - works the same as @Component
public class HelloController {
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/getSaiWord")
    public String helloWorld(){
        return "Welcome to sai's spring learning!!! aaabbb";
    }

    @PostMapping("/createAccount")
    public String createAccount(@RequestBody Department department){
        System.out.println(department.getDepartmentId());
        System.out.println(department.getDepartmentAddress());

        return "Watermark my image";
    }



}
