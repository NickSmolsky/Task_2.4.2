package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("users/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String selectUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.selectById(id));
        return "userById";
    }

    @GetMapping("users/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.selectById(id));
        return "edit";
    }

    @PatchMapping("users/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("users/{id}")
    public String userDelete(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
