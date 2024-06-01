package com.ourhome.favorite.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.favorite.service.FavoriteService;

@RestController
@RequestMapping("/users/{userId}/favorites")
public class FavoriteController {

    FavoriteService favoriteService;

    FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

}
