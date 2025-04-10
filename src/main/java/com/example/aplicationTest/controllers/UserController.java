package com.example.aplicationTest.controllers;

import com.example.aplicationTest.entities.Images;
import com.example.aplicationTest.entities.Users;
import com.example.aplicationTest.services.ImagesService;
import com.example.aplicationTest.services.UsersService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    private final ImagesService imagesService;
    private final UsersService usersService;

    public UserController(ImagesService imagesService, UsersService usersService) {
        this.imagesService = imagesService;
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<?> User(@AuthenticationPrincipal OAuth2User user, HttpServletResponse response){
        String email = user.getAttribute("email");
        String name = user.getAttribute("name");
        String avatar = user.getAttribute("picture");

        usersService.addCookie(response,"email",email,86400);
        usersService.addCookie(response,"name",name,86400);
        usersService.addCookie(response,"avatar",avatar,86400);


        Map<String, String> userData = new HashMap<>();
        userData.put("email", email);
            userData.put("name", name);
            userData.put("avatar", avatar);
            return ResponseEntity.ok(userData);
        }
    @PostMapping("/create")
    public ResponseEntity<?> Create(@AuthenticationPrincipal OAuth2User user, HttpServletRequest request,HttpServletResponse respons) {
        String email = user.getAttribute("email");
        Map<String,String> emailCurrent = new HashMap<>();
        if(usersService.isCookieCorrect(request,"email",email)==false){
            usersService.addCookie(respons,"email",user.getAttribute("email"),86400);
            usersService.addCookie(respons,"name",user.getAttribute("name"),86400);
            usersService.addCookie(respons,"avatar",user.getAttribute("picture"),86400);
            emailCurrent.put("email",email);
        }
        synchronized (email.intern()) {
            if (!usersService.DoesUserExist(email)) {
                String response = usersService.CreateUser(email, user.getAttribute("name"), user.getAttribute("picture"));
                if (emailCurrent == null) {
                    return ResponseEntity.ok("created!");
                }
                return ResponseEntity.ok(emailCurrent);
            }
            if (emailCurrent == null) {
                return ResponseEntity.ok("Exists!");
            }
            return ResponseEntity.ok(emailCurrent);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> userById(@PathVariable("id") Long id){
        Images user = usersService.allAboutUserById(id);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/email")
    public ResponseEntity<?> user(@RequestHeader("email") String email){
      return ResponseEntity.ok(usersService.findUserByEmail(email));
    }


}
