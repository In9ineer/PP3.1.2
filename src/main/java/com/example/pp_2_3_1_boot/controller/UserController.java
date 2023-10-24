package com.example.pp_2_3_1_boot.controller;

import com.example.pp_2_3_1_boot.model.User;
import com.example.pp_2_3_1_boot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

     public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getUsers(ModelMap model) {
        model.addAttribute("UserTable", userService.getUsers());

        return "getUsers";
    }

    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        }

        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") @Valid User user, BindingResult result, @PathVariable("id") long id) {
        if (result.hasErrors()) {
            return "editUser";
        }

        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

}
