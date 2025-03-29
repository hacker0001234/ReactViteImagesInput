package com.example.aplicationTest.services;

import com.example.aplicationTest.entities.Images;
import com.example.aplicationTest.repositories.ImagesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImagesService {
   private final ImagesRepository imagesRepository;

    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public Images saveImage(MultipartFile file) throws IOException {
        Images image = new Images();
        image.setData(file.getBytes());
        image.setType(file.getContentType());
        return imagesRepository.save(image);
    }

    public Optional<Images> getImageById(Long id) {
        return imagesRepository.findById(id);
    }
}
