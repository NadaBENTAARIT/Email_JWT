package com.loterie.loterie.controller;

import com.loterie.loterie.Dto.GameDto;
import com.loterie.loterie.entity.User;
import com.loterie.loterie.payload.request.LoginRequest;
import com.loterie.loterie.payload.request.SignupRequest;
import com.loterie.loterie.payload.response.JwtResponse;
import com.loterie.loterie.payload.response.MessageResponse;
import com.loterie.loterie.repository.GameRepository;
import com.loterie.loterie.repository.UserRepository;
import com.loterie.loterie.security.jwt.JwtUtils;
import com.loterie.loterie.security.services.UserDetailsImpl;
import com.loterie.loterie.service.GameService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class GameController {


    @Autowired
    GameService gameService;


    @Autowired
    private ModelMapper modelMapper;


    //get all games
    @GetMapping("/getGames")
    public List<GameDto> getGames() {
        return gameService.getGames().stream().map(promotion -> modelMapper.map(promotion, GameDto.class))
                .collect(Collectors.toList());
    }



    //delete game with id
    @DeleteMapping(value = "/deleteGame/{id}")
    public void deleteGame(@PathVariable("id") long id) {
        gameService.deleteGame(id);
    }


}








