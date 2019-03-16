package com.paralun.app.controller;

import com.paralun.app.model.User;
import com.paralun.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/login"})
    public String login(Model model) {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String createNewUser(@Valid User user, BindingResult result, Model model) {
        User userExist = userService.findUserByEmail(user.getEmail());
        if(userExist != null) {
            result.rejectValue("email", "error.user", "There is already a user registered with the email provided");
        }

        if(result.hasErrors()) {
            return "registration";
        }else {
            userService.saveUser(user);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
            return "registration";
        }
    }

    @GetMapping(value = "/admin/home")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("userName", "Welcome " + user.getFirstName());
        model.addAttribute("adminMessage", "Content Available Only for Users with Admin Role");
        return "admin/home";
    }
}
