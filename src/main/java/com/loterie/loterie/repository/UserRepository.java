package com.loterie.loterie.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.loterie.loterie.entity.User;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {


    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);



}



