package com.example.featurescovoiturage.Controller;

import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Services.accountServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/account")
@AllArgsConstructor
@NoArgsConstructor
public class FeaturesController {
    @Autowired
    private accountServices accountServices;
    @GetMapping("personalId/{id}")
    public int getPersonalId(@RequestParam Long userId, @PathVariable String id){

        return 3;
    }


    @GetMapping("carregistration/{id}")
    public int getPersonalId(@RequestParam Long userId){
        return 4;
    }
    @PostMapping("signup")
    public void signUp(@RequestBody User user){
        System.out.println(user.getEmail()+user.getLastName());
        accountServices.saveUser(user);
    }
    @PostMapping("personalId/upload")
    public void personalIdUpload(@RequestParam("personalid") MultipartFile personalIdDocument, @RequestParam("userid") Long userid) throws Exception {
        System.out.println("details "+userid);
        accountServices.saveUserPersonalId(personalIdDocument,userid);

    }
    @PostMapping("carregistration/upload")
    public void carRegistration(@RequestParam("carreg") MultipartFile carRegistrationDocument, @RequestParam("userid") Long userid) throws Exception {
       accountServices.saveUserCarRegistration(carRegistrationDocument,userid);

    }


}
