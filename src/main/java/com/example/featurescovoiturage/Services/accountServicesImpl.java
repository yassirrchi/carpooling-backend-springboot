package com.example.featurescovoiturage.Services;

import com.example.featurescovoiturage.Entities.User;
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
    public void saveUser(User user) {
        //makin sure process for later
        user.setCarRegConfirmed(false);
        user.setCarRegConfirmed(false);

        userRepository.save(user);
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
    public void saveUserCarRegistration(MultipartFile carRegDocument, Long id) throws Exception {
        User user=userRepository.findById(id).orElse(null);
        if(user==null){
            throw new Exception("user not found");
        }else{
            user.setCarReg(carRegDocument.getBytes());
            userRepository.save(user);

        }

    }
}
