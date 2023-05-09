package com.devedu.delist.services;

import com.devedu.delist.dto.GameMinDTO;
import com.devedu.delist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        var games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
