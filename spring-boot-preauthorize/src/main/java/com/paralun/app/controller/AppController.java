package com.paralun.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Selamat Datang";
    }

    @PreAuthorize(("hasAnyRole('USER')"))
    @GetMapping("/user")
    public String helloUser() {
        return "Hallo User";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hallo Admin";
    }
}
