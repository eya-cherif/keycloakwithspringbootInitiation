package com.eyacherif.keycloak;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;



@RestController 
@RequestMapping("/api/v1/demo")
public class DemoController {
    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public String hello(){
        return " hello from Spring boot & keycloak !! "; 
    }
    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('client_admin')")
    public String hello2(){
        return " hello from Spring boot & keycloak !! - ADMIN  "; 
    }
}

