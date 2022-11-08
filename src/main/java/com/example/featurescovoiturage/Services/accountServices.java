package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.Entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface accountServices {
    void saveUser(User user);
    void saveUserPersonalId(MultipartFile idDocument,Long id) throws Exception;
    void saveUserCarRegistration(MultipartFile carRegDocument,Long id) throws Exception;

}
