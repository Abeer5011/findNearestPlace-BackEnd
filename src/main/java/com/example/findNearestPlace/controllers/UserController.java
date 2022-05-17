package com.example.findNearestPlace.controllers;
import com.example.findNearestPlace.modals.ApiResponse;
import com.example.findNearestPlace.modals.MyUser;
import com.example.findNearestPlace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class UserController {


    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")

    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody MyUser myUser){
        String hashedPassword= new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPassword);
        userService.register(myUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("user registered", 201));
    }
    @PostMapping("/login")
    public ResponseEntity login(HttpSession session){

        HashMap hashMap=new HashMap();
        hashMap.put("message", session.getId());
        return ResponseEntity.status(200).body(hashMap);
    }

}
