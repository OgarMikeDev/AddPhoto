package com.example.photo.controllers;

import com.example.photo.model.Photo;
import com.example.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping("/addPhoto/")
    public void addPhoto(@RequestParam("text_form_photo") File photo) {
        System.out.println("File photo '" + photo + "'.");
        Photo photoOne = new Photo();
        photoOne.setPhoto(photo);
        photoRepository.save(photoOne);
        saveImage();
    }

    public void saveImage() {
        String srcFolder = "C:\\Users\\DNS\\OneDrive\\Рабочий стол\\Australia Canberra.jpg";
        String dstFolder = "C:\\Users\\DNS\\OneDrive\\Рабочий стол";

        File srcDirection = new File(srcFolder);
        int newWidth = 300;

        try {

                BufferedImage image = ImageIO.read(srcDirection);

                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));

                BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }

                File newFile = new File(dstFolder + "\\photos19.07.2023");
                ImageIO.write(newImage, "jpg", newFile);

        } catch (Exception ex) {
            ex.getMessage();
        }

    }
}
