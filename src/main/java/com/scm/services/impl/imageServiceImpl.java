package com.scm.services.impl;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.scm.services.imageService;

@Service
public class imageServiceImpl implements imageService {

    private Cloudinary cloudinary;
    
    public imageServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
        }



    @Override
    public String uploadImage(MultipartFile contactImage) {
        // Code for image upload
        String filename= UUID.randomUUID().toString();

        try{
            byte[] data=new byte[contactImage.getInputStream().available()];
            contactImage.getInputStream().read(data);
            cloudinary.uploader().upload(data, ObjectUtils.asMap(
                "public_id", contactImage.getOriginalFilename())
            );

        }
        catch(IOException e){
            e.printStackTrace();
        }
        // and it will return url
        // Wecan use AWS but we will user cloudinary

        return "";
    }


}
