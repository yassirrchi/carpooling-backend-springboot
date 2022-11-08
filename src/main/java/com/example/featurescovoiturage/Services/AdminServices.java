package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.DTO.UserDataAndDoc;
import com.example.featurescovoiturage.Entities.User;

public interface AdminServices {
    public void verifyUserIdentity(UserDataAndDoc userData) throws Exception;

}
