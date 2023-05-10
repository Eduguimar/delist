package com.devedu.delist.services;

import com.devedu.delist.dto.GameListDTO;
import com.devedu.delist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        var gameLists = gameListRepository.findAll();
        return gameLists.stream().map(GameListDTO::new).toList();
    }
}
