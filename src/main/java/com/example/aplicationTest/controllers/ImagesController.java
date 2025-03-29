package com.example.aplicationTest.controllers;

import com.example.aplicationTest.entities.Images;
import com.example.aplicationTest.services.ImagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImagesController {
    private final ImagesService imagesService;

    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Images images = imagesService.saveImage(file);
return ResponseEntity.ok("Added id: "+images.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
