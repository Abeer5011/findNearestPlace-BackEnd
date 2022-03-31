package com.example.findNearestPlace.repository;

import com.example.findNearestPlace.modals.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {

    MyUser getMyUserByUserName(String username);

}
