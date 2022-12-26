package com.example.featurescovoiturage.Controller;

import com.example.featurescovoiturage.DTO.AddCarToUser;
import com.example.featurescovoiturage.DTO.MobFile;
import com.example.featurescovoiturage.DTO.UserFormData;
import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Services.accountServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Base64;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

@RestController
@RequestMapping("api/account")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "*")
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

    @PostMapping("personalId/upload")
    public void personalIdUpload(@RequestParam("personalid") MultipartFile personalIdDocument, @RequestParam("userid") Long userid) throws Exception {
        System.out.println("details "+userid);
        accountServices.saveUserPersonalId(personalIdDocument,userid);

    }
    @PostMapping("mob/personalId/upload")
    public void personalIdUpload(@RequestBody MobFile mobFile) throws Exception {
        byte[] buf = Base64.getDecoder().decode(mobFile.getPersonalid());
        System.out.println(buf);
        accountServices.saveUserMobPersonalId(buf,mobFile.getUserid());

    }
    @PostMapping("mob/carregistration/upload")
    public void carRegistration(@RequestBody MobFile mobFile) throws Exception {
        byte[] buf = Base64.getDecoder().decode(mobFile.getPersonalid());
        System.out.println(buf);
        accountServices.saveUserMobCar(buf,mobFile.getUserid());

    }

    @PostMapping("carregistration/upload")
    public void carRegistration(@RequestParam("carreg") MultipartFile carRegistrationDocument, @RequestParam("userid") Long userid) throws Exception {
       accountServices.saveUserCarRegistration(carRegistrationDocument,userid);

    }
    @PostMapping("add/car")
    /*
    Post localhost:4500/api/account/add/car

     {
    "userid": 2,
    "model":"hps",
    "brand":"olabola",
    "capacity":4
}
* */
    public ResponseEntity<?> addCarToUser(@RequestBody AddCarToUser car){

        if(accountServices.addCarToUser(car))
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.internalServerError().build();



    }





}
