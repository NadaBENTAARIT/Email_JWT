package com.loterie.loterie.service;





import com.loterie.loterie.entity.User;
import com.loterie.loterie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

/*

    //get user by email
    public ResponseEntity<User> findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {

            System.out.print("mawjouuuuuuuuuuuud");
            return ResponseEntity.ok(optionalUser.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
}
