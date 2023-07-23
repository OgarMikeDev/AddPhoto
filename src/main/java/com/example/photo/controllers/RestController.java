package com.example.photo.controllers;

import com.example.photo.model.Photo;
import com.example.photo.repository.PhotoRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping("/upload")
    public void addPhoto(@RequestParam("file") MultipartFile photo) throws IOException {
        Photo photoOne = new Photo();
        photoOne.setPhoto(photo.getBytes());
        photoRepository.save(photoOne);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> mainPage(@PathVariable Integer id, HttpServletResponse response) throws Exception {
        Photo photo = photoRepository.findById(id).get();
//        response.setContentType("image/jpg");
//        response.getOutputStream().write(Base64.getEncoder().encodeToString(photo.getPhoto()).getBytes());
//        response.getOutputStream().close();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(photo.getPhoto());
    }
}
