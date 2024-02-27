package com.ex.ex312.controller;

import com.ex.ex312.model.User;
import com.ex.ex312.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "all_users";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user_create";
    }

    @PostMapping("/create")
    public String saveNewUser(@ModelAttribute("user") @Valid User user,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_create";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user_edit";
    }

    @PatchMapping({"/update"})
    public String saveUpdateUser(@ModelAttribute("user") @Valid User user,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_edit";
        }
        userService.updateUser(user);
        return "redirect:/";

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id,
                             @ModelAttribute("user") User user) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
