package com.loterie.loterie.service;

import com.loterie.loterie.entity.Game;
import com.loterie.loterie.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;



    //get all games
    public List<Game> getGames() {
        return gameRepository.findAll();
    }





    //delete game by id
    public void deleteGame(long id) {
        gameRepository.deleteById(id);
    }

}