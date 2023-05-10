package com.devedu.delist.services;

import com.devedu.delist.dto.GameDTO;
import com.devedu.delist.dto.GameMinDTO;
import com.devedu.delist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        var games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        var game = gameRepository.findById(id).orElse(null);
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        var gamesProjection = gameRepository.searchByList(listId);
        return gamesProjection.stream().map(GameMinDTO::new).toList();
    }
}
