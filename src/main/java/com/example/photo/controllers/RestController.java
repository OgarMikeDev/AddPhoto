package com.example.photo.controllers;

import com.example.photo.model.Photo;
import com.example.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping("/addPhoto/")
    public void addPhoto(@RequestParam("add_photo")File photo) {
        Photo photoOne = new Photo();
        photoOne.setPhoto(photo);
        photoRepository.save(photoOne);
    }
}
