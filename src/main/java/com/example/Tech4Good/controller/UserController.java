package com.example.Tech4Good.controller;

import com.example.Tech4Good.entities.User;
import com.example.Tech4Good.exception.InvalidPasswordException;
import com.example.Tech4Good.exception.UsernameNotFoundException;
import com.example.Tech4Good.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping
    public String homeCompany(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/register-session")
    public String createDepartment(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {

        userService.save(user);
        model.addAttribute("success", "User registered successfully");

        return "home-register";
    }

    @GetMapping("/register-login")
    public String registerLogin(@ModelAttribute("user") User user, Model model) {

        model.addAttribute("success", "User registered successfully");

        return "home-register";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        // Busca al usuario por el nombre de usuario
        User user = userService.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username does not exist");
        }

        // Verifica si la contraseña es correcta
        if (!userService.checkPassword(user, password)) {
            throw new InvalidPasswordException("Invalid password");
        }

        model.addAttribute("users", userService.findAll());
        // Si el login es exitoso, redirige a la página de inicio
        return "home-donor";  // Cambia "/home" a la ruta que desees
    }


    @GetMapping("/home-users")
    public String homeUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "home-users";  // Asegúrate de que este sea el nombre correcto de tu vista
    }



}