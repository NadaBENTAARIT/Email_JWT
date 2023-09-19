package com.loterie.loterie.repository;


import com.loterie.loterie.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.loterie.loterie.entity.User;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository <Role,Long> {



}



