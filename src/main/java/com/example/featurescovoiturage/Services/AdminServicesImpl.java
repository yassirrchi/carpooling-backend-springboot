package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.DTO.UserDataAndDoc;
import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Enums.DocumentType;
import com.example.featurescovoiturage.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicesImpl implements AdminServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void verifyUserIdentity(UserDataAndDoc userData) throws Exception {

        User userToBeVerified=userRepository.findById(userData.getUserId()).orElse(null);
        if(userToBeVerified==null||(userData.getDocumentType()!=DocumentType.PERSONAL_ID&&userData.getDocumentType()!=DocumentType.CAR_REGISTRATION)){

            throw new Exception("error (USER NOT FOUND OR DOCUM TYPE UNRECOGNIZED)");

        }
        else{
            if(userData.getDocumentType()== DocumentType.PERSONAL_ID)
            userToBeVerified.setPersonalIdConfirmed(true);
            else if ((userData.getDocumentType()== DocumentType.CAR_REGISTRATION)) {
                userToBeVerified.setCarRegConfirmed(true);
            }


            userRepository.save(userToBeVerified);
        }


    }


}
