package com.example.aplicationTest.services;

import com.example.aplicationTest.entities.Images;
import com.example.aplicationTest.entities.Users;
import com.example.aplicationTest.repositories.ImagesRepository;
import com.example.aplicationTest.repositories.UsersRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

@Service
public class UsersService {

private final UsersRepository usersRepository;
    private final ImagesRepository imagesRepository;

    public UsersService(UsersRepository usersRepository, ImagesRepository imagesRepository) {
        this.usersRepository = usersRepository;
        this.imagesRepository = imagesRepository;
    }


    public void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        String encodedValue = Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));

        Cookie cookie = new Cookie(name, encodedValue);
        cookie.setHttpOnly(false);
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
    public void deleteCookies(HttpServletResponse response){
        Cookie cookieEmail = new Cookie("email","");
        cookieEmail.setMaxAge(0);
        cookieEmail.setPath("/");
        cookieEmail.setHttpOnly(false);
        response.addCookie(cookieEmail);

        Cookie cookieName = new Cookie("name","");
        cookieName.setMaxAge(0);
        cookieName.setPath("/");
        cookieName.setHttpOnly(false);
        response.addCookie(cookieName);

        Cookie cookieAvatar = new Cookie("avatar","");
        cookieAvatar.setMaxAge(0);
        cookieAvatar.setPath("/");
        cookieAvatar.setHttpOnly(false);
        response.addCookie(cookieAvatar);
    }

    public String decodeCookie(String encodedValue){
    byte[] decodedValueBytes = Base64.getDecoder().decode(encodedValue);
    String decodedValue = new String(decodedValueBytes,StandardCharsets.UTF_8);
    return decodedValue;
    }

    public boolean isCookieCorrect(HttpServletRequest request,String cookieName,String cookieValue){
        if (request.getCookies() != null){
            for (Cookie cookie : request.getCookies()){
            if(cookie.getName().equals(cookieName)){
            if(decodeCookie(cookie.getValue()).equals(cookieValue)){
                return true;
            }
            }
            }
        }
        return false;
    }
    public String CreateUser(String email,String name,String avatarUrl){
        Users user = usersRepository.findByEmail(email);
        if(user!= null) {
        return "Already exists";
        }
        Users users = new Users(email,name,avatarUrl);
        usersRepository.save(users);
        return "Created!";
    }
    public boolean DoesUserExist(String email){
        Users user = usersRepository.findByEmail(email);
        if(user == null){
            return false;
        } else{
            return true;
        }
    }

    public Images allAboutUserById(Long id){
        Optional<Images> image = imagesRepository.findById(id);
        Images user = image.get();
        return user;
    }
    public Users findUserByEmail(String email){
    return usersRepository.findByEmail(email);
    }
}
