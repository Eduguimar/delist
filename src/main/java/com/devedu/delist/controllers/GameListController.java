package com.devedu.delist.controllers;

import com.devedu.delist.dto.GameListDTO;
import com.devedu.delist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
