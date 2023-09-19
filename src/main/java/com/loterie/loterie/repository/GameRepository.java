package com.loterie.loterie.repository;


import com.loterie.loterie.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.loterie.loterie.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository <Game,Long> {


    @Override
    List<Game> findAll();


}



