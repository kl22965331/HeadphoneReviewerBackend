package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/util")
public class UtilController {

    @Value("${frontendBrandPictureDirection}")
    private String brandPictureDirection;

    @PostMapping("/upload/image")
    public ResponseEntity<String> uploadImage(@RequestParam("name") String name, @RequestParam("image") MultipartFile image) {
        if (image.isEmpty()) {
            return new ResponseEntity<>("Please select an image to upload", HttpStatus.BAD_REQUEST);
        }

        try {

            String brandName = name.substring(0, 1).toUpperCase() + name.substring(1);
            String fileName = brandName + ".jpg";
            Path directoryPath = Paths.get(brandPictureDirection);
            Path filePath = directoryPath.resolve(fileName);
            Files.createDirectories(directoryPath);
            Files.write(filePath, image.getBytes());

            return new ResponseEntity<>("File uploaded successfully: " + fileName, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
