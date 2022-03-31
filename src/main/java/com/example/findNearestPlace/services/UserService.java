package com.example.findNearestPlace.services;
import com.example.findNearestPlace.modals.MyUser;
import com.example.findNearestPlace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {


    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<MyUser> getUsers() {
        return userRepository.findAll();
    }

    public void register(MyUser myUser){
        userRepository.save(myUser);
    }

}
