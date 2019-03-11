package com.paralun.app.controller;

import com.paralun.app.model.User;
import com.paralun.app.model.UserRole;
import com.paralun.app.repo.UserRepo;
import com.paralun.app.repo.UserRoleRepo;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserRoleRepo roleRepo;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices rememberMeServices;

    @Autowired
    AuthenticationTrustResolver trustResolver;
    
    @GetMapping(value = {"/", "/list"})
    public String listUsers(ModelMap model) {

        Iterable<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userslist";
    }
    
    @GetMapping(value = "/newuser")
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }
    
    @PostMapping(value = "/newuser")
    public String saveUser(@Valid User user, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }
        
//        if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
//            FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId", new String[]{user.getUsername()}, Locale.getDefault()));
//            result.addError(ssoError);
//            return "registration";
//        }

        userRepo.save(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }
    
    @GetMapping(value = "/edit-user-{username}")
    public String editUser(@PathVariable String username, ModelMap model) {
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }
    
    @PostMapping(value = "/edit-user-{username}")
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable String username) {

        if (result.hasErrors()) {
            return "registration";
        }
        
        userRepo.save(user);

        model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }
    
    @GetMapping(value = "/delete-user-{username}")
    public String deleteUser(@PathVariable String username) {
        return "redirect:/list";
    }
    
    @ModelAttribute("roles")
    public Iterable<UserRole> initializeProfiles() {
        return roleRepo.findAll();
    }
    
    @GetMapping(value = "/Access_Denied")
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }
    
    @GetMapping(value = "/login")
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/list";
        }
    }
    
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            rememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }
    
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return trustResolver.isAnonymous(authentication);
    }

}
