package com.example.Tech4Good.controller;

import com.example.Tech4Good.entities.Donor;
import com.example.Tech4Good.entities.User;
import com.example.Tech4Good.service.impl.DonorService;
import com.example.Tech4Good.service.impl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/donors")
public class DonorController {

    private final DonorService donorService;
    private final UserServiceImpl userService;

    public DonorController(DonorService donorService, UserServiceImpl userService) {
        this.donorService = donorService;
        this.userService = userService;
    }

    @GetMapping
    public String homeDonor(Model model) {
        List<Donor> donors = donorService.findAll();

        model.addAttribute("donors", donors);
        return "home-donor";
    }





    @GetMapping("/create")
    public String createDonor(Model model) {
        model.addAttribute("users", userService.findAll());  // Pasa la lista de usuarios al modelo
        model.addAttribute("donor", new Donor());  // Pasa un nuevo objeto Donor al modelo
        return "create-donor";  // Retorna el nombre de la plantilla Thymeleaf
    }


    @PostMapping("/save")
    public String saveDonor(Donor donor){
        donorService.save(donor);

        return "redirect:/donors";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Donor donor = donorService.findById(id);
        List<User> users = userService.findAll();
        model.addAttribute("donor", donor);
        model.addAttribute("users", users);
        return "update-donor";
    }

    @GetMapping("/delete/{id}")
    public String deleteDonor(@PathVariable Long id ,Model model){
        Donor donor = donorService.findById(id);
        if(donor != null){
            donorService.deleteUserById(id);
            return "redirect:/donors";
        }else{
            return "error";
        }

    }
}