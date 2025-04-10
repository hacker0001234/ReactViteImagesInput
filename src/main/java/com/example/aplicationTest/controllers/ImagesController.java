package com.example.aplicationTest.controllers;

import com.example.aplicationTest.entities.Images;
import com.example.aplicationTest.entities.ImagesObj;
import com.example.aplicationTest.repositories.ImagesRepository;
import com.example.aplicationTest.services.ImagesService;
import com.example.aplicationTest.services.UsersService;
import jakarta.servlet.http.Cookie;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImagesController {
    private final ImagesService imagesService;
    private final ImagesRepository imagesRepository;
    private final UsersService usersService;

    public ImagesController(ImagesService imagesService, ImagesRepository imagesRepository, UsersService usersService) {
        this.imagesService = imagesService;
        this.imagesRepository = imagesRepository;
        this.usersService = usersService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("files") MultipartFile[] files, @AuthenticationPrincipal OAuth2User user) {
        try {
            String email = user.getAttribute("email");
            synchronized (email.intern()){
            if(imagesService.doImagesByUserExist(email)) {
            return ResponseEntity.ok("already exist!");
            }
            imagesService.saveImage(files,email,user.getAttribute("name"));
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok("added!");
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> allImages(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        if(!images.isEmpty()){
            Images additional = images.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(additional.getType()))
                    .body(new InputStreamResource(new ByteArrayInputStream(additional.getData())));
        }
        else return ResponseEntity.notFound().build();
    }
    @GetMapping("/id/{id}/Image2")
    public ResponseEntity<?> image2(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        Images image2 = images.get();
        if(image2.getData2()==null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image2.getType2()))
                .body(new InputStreamResource(new ByteArrayInputStream(image2.getData2())));
    }
    @GetMapping("/id/{id}/Image3")
    public ResponseEntity<?> image3(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        Images image2 = images.get();
        if(image2.getData3()==null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image2.getType3()))
                .body(new InputStreamResource(new ByteArrayInputStream(image2.getData3())));
    }
    @GetMapping("/id/{id}/Image4")
    public ResponseEntity<?> image4(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        Images image2 = images.get();
        if(image2.getData4()==null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image2.getType4()))
                .body(new InputStreamResource(new ByteArrayInputStream(image2.getData4())));
    }
    @GetMapping("/id/{id}/Image5")
    public ResponseEntity<?> image5(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        Images image2 = images.get();
        if(image2.getData5()==null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image2.getType5()))
                .body(new InputStreamResource(new ByteArrayInputStream(image2.getData5())));
    }
    @GetMapping("/id/{id}/Image6")
    public ResponseEntity<?> image6(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        Images image2 = images.get();
        if(image2.getData6()==null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image2.getType6()))
                .body(new InputStreamResource(new ByteArrayInputStream(image2.getData6())));
    }
    @GetMapping("/id/{id}/Image7")
    public ResponseEntity<?> image7(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        Images image2 = images.get();
        if(image2.getData7()==null){

            return ResponseEntity.ok(null);

        }

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image2.getType7()))
                .body(new InputStreamResource(new ByteArrayInputStream(image2.getData7())));
    }
    @GetMapping("/id/{id}/Image8")
    public ResponseEntity<?> image8(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        Images image2 = images.get();
        if(image2.getData8()==null){

            return ResponseEntity.ok(null);

        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image2.getType8()))
                .body(new InputStreamResource(new ByteArrayInputStream(image2.getData8())));
    }
    @GetMapping("/id/{id}/Image9")
    public ResponseEntity<?> image9(@PathVariable("id") Long id){
        Optional<Images> images = imagesRepository.findById(id);
        Images image2 = images.get();
        if(image2.getData9()==null){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(image2.getType9()))
                .body(new InputStreamResource(new ByteArrayInputStream(image2.getData9())));
    }
    @GetMapping("/all")
    public ResponseEntity<?> allImages(){
        List<ImagesObj> test = imagesRepository.findAll().stream()
                .map(image -> new ImagesObj(image.getId(), image.getName(), image.getEmail()))
                .toList();
        return ResponseEntity.ok(test);
    }
    @GetMapping("/id")
    public ResponseEntity<?> img1Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData())));
        }
        else return ResponseEntity.notFound().build();
    }

    @GetMapping("/id/Image2")
    public ResponseEntity<?> img2Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images.getData2()!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType2()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData2())));
        }
        else return ResponseEntity.ok("notFound");
    }

    @GetMapping("/id/Image3")
    public ResponseEntity<?> img3Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images.getData3()!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType3()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData3())));
        }
        else return ResponseEntity.ok("notFound");
    }

    @GetMapping("/id/Image4")
    public ResponseEntity<?> img4Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images.getData4()!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType4()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData4())));
        }
        else return ResponseEntity.ok("notFound");
    }

    @GetMapping("/id/Image5")
    public ResponseEntity<?> img5Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images.getData5()!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType5()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData5())));
        }
        else return ResponseEntity.ok("notFound");
    }

    @GetMapping("/id/Image6")
    public ResponseEntity<?> img6Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images.getData6()!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType6()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData6())));
        }
        else return ResponseEntity.ok("notFound");
    }

    @GetMapping("/id/Image7")
    public ResponseEntity<?> img7Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images.getData7()!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType7()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData7())));
        }
        else return ResponseEntity.ok("notFound");
    }

    @GetMapping("/id/Image8")
    public ResponseEntity<?> img8Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images.getData8()!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType8()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData8())));
        }
        else return ResponseEntity.ok("notFound");
    }

    @GetMapping("/id/Image9")
    public ResponseEntity<?> img9Email(@AuthenticationPrincipal OAuth2User user){
        Images images = imagesRepository.findByEmail(user.getAttribute("email"));
        if(images.getData9()!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(images.getType9()))
                    .body(new InputStreamResource(new ByteArrayInputStream(images.getData9())));
        }
        else return ResponseEntity.ok("notFound");
    }
    @GetMapping("/id/Image2/delete")
    public void img2EmailDelete(@AuthenticationPrincipal OAuth2User user){
        String email = user.getAttribute("email");
        synchronized (email.intern()){
        imagesService.DeleteImg(email,"2");

        }
    }

    @GetMapping("/id/Image3/delete")
    public void img3EmailDelete(@AuthenticationPrincipal OAuth2User user){
        String email = user.getAttribute("email");
        synchronized (email.intern()){
            imagesService.DeleteImg(email,"3");

        }
    }

    @GetMapping("/id/Image4/delete")
    public void img4EmailDelete(@AuthenticationPrincipal OAuth2User user){
        String email = user.getAttribute("email");
        synchronized (email.intern()){
            imagesService.DeleteImg(email,"4");
        }
    }

    @GetMapping("/id/Image5/delete")
    public void img5EmailDelete(@AuthenticationPrincipal OAuth2User user){
        String email = user.getAttribute("email");
        synchronized (email.intern()){
            imagesService.DeleteImg(email,"5");

        }
    }

    @GetMapping("/id/Image6/delete")
    public void img6EmailDelete(@AuthenticationPrincipal OAuth2User user){
        String email = user.getAttribute("email");
        synchronized (email.intern()){
            imagesService.DeleteImg(email,"6");

        }
    }

    @GetMapping("/id/Image7/delete")
    public void img7EmailDelete(@AuthenticationPrincipal OAuth2User user){
        String email = user.getAttribute("email");
        synchronized (email.intern()){
            imagesService.DeleteImg(email,"7");

        }
    }

    @GetMapping("/id/Image8/delete")
    public void img8EmailDelete(@AuthenticationPrincipal OAuth2User user){
        String email = user.getAttribute("email");
        synchronized (email.intern()){
            imagesService.DeleteImg(email,"8");

        }
    }

    @GetMapping("/id/Image9/delete")
    public void img9EmailDelete(@AuthenticationPrincipal OAuth2User user){
        String email = user.getAttribute("email");
        synchronized (email.intern()){
            imagesService.DeleteImg(email,"9");

        }
    }
    @PostMapping("/upload/one")
    public ResponseEntity<?> uploadOneImage(@AuthenticationPrincipal OAuth2User user,@RequestParam("file") MultipartFile file) throws IOException {
        String email= user.getAttribute("email");
        synchronized (email.intern()){
            imagesService.UploadOne(file,email);
        }
        return ResponseEntity.ok("added");
    }
}

