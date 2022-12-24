package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.DTO.AddCarToUser;
import com.example.featurescovoiturage.DTO.UserFormData;
import com.example.featurescovoiturage.Entities.User;
import com.example.featurescovoiturage.Entities.Voiture;
import com.example.featurescovoiturage.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional

public class accountServicesImpl implements accountServices {
    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean saveUser(UserFormData user) {

        System.out.println("cin is "+user.getCni());
        User isExist=userRepository.findUserByEmail(user.getEmail());
        if(isExist!=null)
            return false;
        isExist=new User();
        isExist.setEmail(user.getEmail());
        isExist.setPassword(user.getPassword());
        isExist.setFirstName(user.getFirstname());
        isExist.setLastName(user.getLastname());
        isExist.setCIN(user.getCni());
        isExist.setEmailVerified(false);
        isExist.setPhoneNumberVerified(false);
        isExist.setCarRegConfirmed(false);
        isExist.setCarRegConfirmed(false);

        userRepository.save(isExist);
        return true;
    }

    @Override
    public void saveUserPersonalId(MultipartFile idDocument, Long id) throws Exception {
        User user=userRepository.findById(id).orElse(null);
        if(user==null){
            throw new Exception("user not found");
        }else{
            user.setPersonalIdCard(idDocument.getBytes());
            userRepository.save(user);

        }

    }
    @Override
    public void saveUserMobPersonalId(byte[] idDocument, Long id) throws Exception {
        User user=userRepository.findById(id).orElse(null);
        if(user==null){
            throw new Exception("user not found");
        }else{
            user.setPersonalIdCard(idDocument);
            userRepository.save(user);

        }

    }

    @Override
    public void saveUserCarRegistration(MultipartFile carRegDocument, Long id) throws Exception {
        User user=userRepository.findById(id).orElse(null);
        if(user==null){
            throw new Exception("user not found");
        }else{
            user.setCarReg(carRegDocument.getBytes());
            userRepository.save(user);

        }

    }




    @Override
    public User findUserByEmail(UserFormData userFormData) {
        User user=userRepository.findUserByEmail(userFormData.getEmail());
        System.out.println(user.getEmail()+" "+user.getPassword()+" "+ userFormData.getPassword()+" "+user.getPassword().equals(userFormData.getPassword()));
        if(user.getPassword().equals(userFormData.getPassword()))
            return user;
        return null;
    }

    @Override
    public boolean addCarToUser(AddCarToUser car) {
        Voiture voiture=new Voiture();
        User user=userRepository.findById(car.getUserid()).orElse(null);
        if(user==null)
            return false;

        voiture.setModel(car.getModel());
        voiture.setBrand(car.getBrand());
        voiture.setCapacity(car.getCapacity());
        user.setVoiture(voiture);
        userRepository.save(user);
        return true;




    }

}
