package com.example.findNearestPlace.services;
import com.example.findNearestPlace.modals.MyUser;
import com.example.findNearestPlace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {


    private final UserRepository userRepository;
    @Autowired
    public MyUserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = userRepository.getMyUserByUserName(username);

        if(myUser == null){
            throw new UsernameNotFoundException("username not found");
        }else {
            return myUser;
        }
    }
}
