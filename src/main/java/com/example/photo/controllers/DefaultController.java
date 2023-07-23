package com.example.photo.controllers;

import com.example.photo.model.Photo;
import com.example.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Base64;

@Controller
public class DefaultController {

    @Autowired
    private PhotoRepository photoRepository;

//    @GetMapping("/{id}")
//    public String mainPage(Model model, @PathVariable Integer id) {
//        Photo photo = photoRepository.findById(id).get();
//
//        model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getPhoto()));
//        return "mainPage";
//    }

    @GetMapping("/")
    public String mainPage(Model model) {
        return "mainPage";
    }
}
