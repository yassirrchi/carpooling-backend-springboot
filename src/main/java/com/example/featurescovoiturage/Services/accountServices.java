package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.DTO.AddCarToUser;
import com.example.featurescovoiturage.DTO.UserFormData;
import com.example.featurescovoiturage.Entities.User;
import org.springframework.web.multipart.MultipartFile;

public interface accountServices {
    boolean saveUser(UserFormData user);
    void saveUserPersonalId(MultipartFile idDocument,Long id) throws Exception;
    void saveUserMobPersonalId(byte[] idDocument,Long id) throws Exception;
    void saveUserCarRegistration(MultipartFile carRegDocument,Long id) throws Exception;

    User findUserByEmail(UserFormData userFormData);
    boolean addCarToUser(AddCarToUser car);


}
