package com.example.featurescovoiturage.Controller;

import com.example.featurescovoiturage.DTO.UserDataAndDoc;
import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Enums.DocumentType;
import com.example.featurescovoiturage.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.featurescovoiturage.Services.accountServices;
@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private AdminServices adminServices;


    @PostMapping("users/verify/identity")
    public void verifyUsersCarRegistry(@RequestBody  UserDataAndDoc userDataAndDoc) throws Exception {
        System.out.println(userDataAndDoc.getDocumentType());
        System.out.println(userDataAndDoc.getDocumentType()== DocumentType.CAR_REGISTRATION);
        adminServices.verifyUserIdentity(userDataAndDoc);

    }



}
