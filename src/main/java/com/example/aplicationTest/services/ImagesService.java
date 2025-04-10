package com.example.aplicationTest.services;

import com.example.aplicationTest.entities.Images;
import com.example.aplicationTest.repositories.ImagesRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@Service
public class ImagesService {
   private final ImagesRepository imagesRepository;

    public ImagesService(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }

    public void saveImage(MultipartFile[] files,String email,String name) throws IOException {
        Images image = new Images();

        image.setEmail(email);
        image.setName(name);
        int count = 1;
        for (MultipartFile file:files) {
            if(count ==1) {
                image.setData(file.getBytes());
                image.setType(file.getContentType());
            }
            else if(count ==2) {
                image.setData2(file.getBytes());
                image.setType2(file.getContentType());
            }
            else if(count ==3) {
                image.setData3(file.getBytes());
                image.setType3(file.getContentType());
            }
            else if(count ==4) {
                image.setData4(file.getBytes());
                image.setType4(file.getContentType());
            }
            else if(count ==5) {
                image.setData5(file.getBytes());
                image.setType5(file.getContentType());
            }
            else if(count ==6) {
                image.setData6(file.getBytes());
                image.setType6(file.getContentType());
            }
            else if(count ==7) {
                image.setData7(file.getBytes());
                image.setType7(file.getContentType());
            }
            else if(count ==8) {
                image.setData8(file.getBytes());
                image.setType8(file.getContentType());
            }
            else if(count ==9) {
                image.setData9(file.getBytes());
                image.setType9(file.getContentType());
            }
            count++;
        }
        imagesRepository.save(image);
    }

    public boolean doImagesByUserExist(String email){
        Images image = imagesRepository.findByEmail(email);
        if(image!=null){
            return true;
        }
        return false;
    }
    public void DeleteImg(String email,String number){
        Images image = imagesRepository.findByEmail(email);
        if(number.equals("2")){
        if (image.getData2()!= null){
            image.setData2(null);
            image.setType2(null);
        }
        }
        if(number.equals("3")){
            if (image.getData3()!= null){
                image.setData3(null);
                image.setType3(null);
            }
        }
        if(number.equals("4")){
            if (image.getData4()!= null){
                image.setData4(null);
                image.setType4(null);
            }
        }
        if(number.equals("5")){
            if (image.getData5()!= null){
                image.setData5(null);
                image.setType5(null);
            }
        }
        if(number.equals("6")){
            if (image.getData6()!= null){
                image.setData6(null);
                image.setType6(null);
            }
        }
        if(number.equals("7")){
            if (image.getData7()!= null){
                image.setData7(null);
                image.setType7(null);
            }
        }
        if(number.equals("8")){
            if (image.getData8()!= null){
                image.setData8(null);
                image.setType8(null);
            }
        }
        if(number.equals("9")){
            if (image.getData9()!= null){
                image.setData9(null);
                image.setType9(null);
            }
        }
        imagesRepository.save(image);
    }

    public void UploadOne(MultipartFile file,String email) throws IOException {
            Images image = imagesRepository.findByEmail(email);
            if(image.getData2()==null){
                image.setData2(file.getBytes());
                image.setType2(file.getContentType());
            } else if(image.getData3()== null){
                image.setData3(file.getBytes());
                image.setType3(file.getContentType());
            } else if(image.getData4()== null){
                image.setData4(file.getBytes());
                image.setType4(file.getContentType());
            } else if(image.getData5()== null){
                image.setData5(file.getBytes());
                image.setType5(file.getContentType());
            } else if(image.getData6()== null){
                image.setData6(file.getBytes());
                image.setType6(file.getContentType());
            } else if(image.getData7()== null){
                image.setData7(file.getBytes());
                image.setType7(file.getContentType());
            }else if(image.getData7()== null){
                image.setData7(file.getBytes());
                image.setType7(file.getContentType());
            }else if(image.getData7()== null){
                image.setData7(file.getBytes());
                image.setType7(file.getContentType());
            }else if(image.getData8()== null){
                image.setData8(file.getBytes());
                image.setType8(file.getContentType());
            }else if(image.getData8()== null){
                image.setData8(file.getBytes());
                image.setType8(file.getContentType());
            }else if(image.getData9()== null){
                image.setData9(file.getBytes());
                image.setType9(file.getContentType());
            }
            imagesRepository.save(image);
    }
}
